package com.gn.board.vo;

import java.time.LocalDateTime;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	public Board() {}
	
	public Board(int boardNo, String boardTitle, String boardContent,
			int boardWriter, LocalDateTime regDate, LocalDateTime modDate) {
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(int boardWriter) {
		this.boardWriter = boardWriter;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		return "[번호=" + boardNo + ", 제목=" + boardTitle 
				+ ", 내용=" + boardContent
				+ ", 작성자=" + boardWriter 
				+ ", 등록일=" + regDate + ", 수정일=" + modDate + "]";
	}
	
}
