package com.gn.member.vo;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	
	public Member() {}
	
	public Member(int memberNo, String memberId, String memberPw, String memberName) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
	}
	
	public Member(String memberId, String memberPw, String memberName) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
	}
	
	
	public int getMemberNo() {
		return memberNo;
	}
	
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "[회원 번호 : " + memberNo
				+ ", 아이디 : " + memberId
				+ ", 비밀번호 : " + memberPw
				+ ", 이름 : " + memberName + "]";
	}
	
	
	
	
}
