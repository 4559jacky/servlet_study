package com.gn.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;

@WebServlet("/boardCreateEnd")
public class BoardCreateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BoardCreateEndServlet() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청시 전달된 데이터를 담을 바구니
		Board b = new Board();
		Attach a = new Attach();
		
		// 2. 파일 업로드할 경로 설정
		// Window에서는 파일 경로를 나타낼 때 역슬래시(\)를 사용한다
		// 역슬래시를 하나만 쓰면 문자열에서 escape로 작동하기 때문에 두개를 붙여서 사용한다.
		String path = "C:\\upload\\board";
		
		// 2-1. 폴더 생성
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		// 3. 파일을 업로드할 저장 공간 정보 셋팅
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 3-1. 만든 폴더 경로를 담아준다.
		factory.setRepository(dir);
		// byte -> KB -> MB -> GB -> TB
		// 1024 -> 1KB * 1024 -> 1MB * 10
		factory.setSizeThreshold(1024*1024*10);
		
		// 4. 요청을 통해 전달된 데이터 읽어오기
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			// items의 길이 체크(파일이 몇개 들어있는지)
			System.out.println(items.size());
			for(int i=0; i<items.size(); i++) {
				FileItem fileItem = items.get(i);
				if(fileItem.isFormField()) {
					// (1) 파일이 아닌 폼 내부 요소
					// System.out.println(fileItem.getFieldName());
					switch(fileItem.getFieldName()) {
						case "board_title" :
							b.setBoardTitle(fileItem.getString("utf-8"));
							break;
						case "board_content" :
							b.setBoardContent(fileItem.getString("utf-8"));
							break;
						case "board_writer" :
							b.setBoardWriter(Integer.parseInt(fileItem.getString("utf-8")));
							break;
					}
				} else {
					// (2) 파일 형태의 폼 요소
					// System.out.println(fileItem.getName());
					if(fileItem.getSize() > 0) {
						// 파일의 원래 이름 가져오기
						String oriName = fileItem.getName();
						int idx = oriName.lastIndexOf(".");
						// 파일 확장명 가져오기
						String ext = oriName.substring(idx);
						
						// UUID로 파일의 이름 랜덤값으로 이름 정해주기
						String uuid = UUID.randomUUID().toString().replace("-", "");
						// UUID로 만든 랜덤이름을 확장명을 붙여서 새로운 파일이름으로 붙여주기
						String newName = uuid+ext;
						
						// 여기까지가 자바에서 이미지를 받고 내 컴퓨터 경로로 이동하는 코드
						// 밑에 a.set부터 데이터베이스에 담아주는 코드
						File uploadFile = new File(dir,newName);
						fileItem.write(uploadFile);
						
						a.setOriName(oriName);
						a.setNewName(newName);
						// C:\\upload\\board\\새로운이름.확장자
						a.setAttachPath(path+"\\"+newName);
						
					}
				}
			}
			// 1. 바구니에 데이터 들어있는지 확인
			System.out.println(b);
			System.out.println(a);
			// 2. 지정한 경로에 파일 업로드 되었는지 확인
			int result = new BoardService().createBoard(b, a);
//			RequestDispatcher view
//				= request.getRequestDispatcher("/views/board/create_fail.jsp");
			JSONObject obj = new JSONObject();
			if(result > 0) {
//				view = request.getRequestDispatcher("/views/board/create_success.jsp");
				obj.put("res_code", "200");
				obj.put("res_msg", "정상적으로 게시글 등록되었습니다.");
			}else {
				obj.put("res_code", "500");
				obj.put("res_msg", "게시글 등록 중 오류가 발생하였습니다.");
				String deletePath = a.getAttachPath();
				File deleteFile = new File(deletePath);
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			}
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(obj);
//			view.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
