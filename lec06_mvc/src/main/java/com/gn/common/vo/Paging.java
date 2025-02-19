package com.gn.common.vo;

public class Paging {
	// 전체 게시글 갯수
	private int totalData; // 15
	// 전체 페이지 갯수 
	private int totalPage; // 3
	// 한 페이지당 게시글의 개수
	private int numPerPage = 2; // 10
	// LIMIT 쿼리 앞쪽 숫자
	private int limitPageNo;
	// 현재 페이지 번호
	private int nowPage = 1;
	
	// 페이징바
	private int pageBarSize = 5;
	private int pageBarStart;
	private int pageBarEnd;
	
	// 이전, 다음 여부
	private boolean prev = true;
	private boolean next = true;
	
	
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
		calcPaging();
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getLimitPageNo() {
		return limitPageNo;
	}
	public void setLimitPageNo(int limitPageNo) {
		this.limitPageNo = limitPageNo;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageBarSize() {
		return pageBarSize;
	}
	public void setPageBarSize(int pageBarSize) {
		this.pageBarSize = pageBarSize;
	}
	public int getPageBarStart() {
		return pageBarStart;
	}
	public void setPageBarStart(int pageBarStart) {
		this.pageBarStart = pageBarStart;
	}
	public int getPageBarEnd() {
		return pageBarEnd;
	}
	public void setPageBarEnd(int pageBarEnd) {
		this.pageBarEnd = pageBarEnd;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	private void calcPaging() {
		// 현재 페이지를 기준으로 건너뛸 데이터 개수
		// 3페이지 -> 앞에 2페이지 -> 6개(한페이지당 3개)
		limitPageNo = (nowPage-1)*numPerPage;
		// 전체 게시글 개수 기준으로 페이지 개수 계산
		totalPage = (int)Math.ceil((double)totalData/numPerPage);
		
		// 페이징바
		// 시작 번호
		pageBarStart = ((nowPage-1)/pageBarSize)*pageBarSize + 1;
		// 끝번호
		pageBarEnd = pageBarStart + pageBarSize - 1;
		if(pageBarEnd > totalPage) pageBarEnd = totalPage;
		
		// 이전 이후 버튼
		if(pageBarStart == 1)  prev = false;
		if(pageBarEnd >= totalPage) next = false;
		
		
		
	}
	
}
