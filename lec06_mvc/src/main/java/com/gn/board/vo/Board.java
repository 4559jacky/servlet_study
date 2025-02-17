package com.gn.board.vo;

import java.time.LocalDateTime;

public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	private String memberName;
	
	public Board() {
		super();
	}
	
	public Board(int boardNo, String boardTitle, String boardContent, int boardWriter, LocalDateTime regDate,
			LocalDateTime modDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public Board(int boardNo, String boardTitle, String boardContent, int boardWriter, LocalDateTime regDate,
			LocalDateTime modDate, String memberName) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.regDate = regDate;
		this.modDate = modDate;
		this.memberName = memberName;
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
	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", regDate=" + regDate + ", modDate=" + modDate + "]";
	}
	
	
}
