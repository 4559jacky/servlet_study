package com.gn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Attach;

@WebServlet("/filePath")
public class FilePathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FilePathServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 읽어올 파일명 전달받기
		int attachNo = Integer.parseInt(request.getParameter("attach_no"));
		Attach attach = new BoardService().selectAttachOne(attachNo);
		request.setAttribute("attach", attach);
		
		// 2. 해당 파일명이 비어있는지 확인
		String filePath = attach.getAttachPath();
		if(filePath == null || filePath.trim().equals("")) {
			// 400 오류(잘못된 요청을 보낸 경우) 발생
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// 3. 파일 경로에 파일이 존재하는지 확인
		File file = new File(filePath);
		if(!file.exists()) {
			// 404 오류(요청한 파일을 찾을 수 없을 경우) 발생
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 4. MIME 타입 감지(모든 형태)
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		
		// 5. 파일을 읽어서(In), 클라이언트 전송(Out)
		try(FileInputStream fis = new FileInputStream(file);
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
