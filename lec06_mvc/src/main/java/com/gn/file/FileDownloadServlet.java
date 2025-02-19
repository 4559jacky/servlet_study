package com.gn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Attach;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 읽어올 파일명 전달받기
		int attachNo = Integer.parseInt(request.getParameter("attach_no"));
		Attach a = new BoardService().selectAttachOne(attachNo);
		
		// 2. 파일명 비어있는지 확인
		String filePath = a.getAttachPath();
		if(filePath == null || filePath.trim().equals("")) {
			// 400에러 발생 -> 잘못된 요청
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// 3. 파일 경로에 파일 존재하는지 확인
		File file = new File(filePath);
		if(!file.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 4. 파일 다운로드 응답 헤더 설정
		response.setContentType("application/octet-stream"); // 파일 컨텐트 타입을 사용하기위해
		response.setContentLength((int)file.length());
		
		// 5. 파일명 설정(인코딩)
		String encodedFileName
			= URLEncoder.encode(a.getOriName(),"UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment; filename=\""+encodedFileName+"\"") ;
		
		// 6. 파일 데이터를 클라이언트 전송
		try (FileInputStream fis = new FileInputStream(file);
				OutputStream out = response.getOutputStream()) {
			byte[] buffer = new byte[1024];
			int byteRead;
			while((byteRead = fis.read(buffer)) != -1) {
				out.write(buffer,0,byteRead);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
