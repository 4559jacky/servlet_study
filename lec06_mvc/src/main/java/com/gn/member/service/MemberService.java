package com.gn.member.service;

import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;

import com.gn.member.dao.MemberDao;
import com.gn.member.vo.Member;

public class MemberService {
	private MemberDao memberDao = new MemberDao();
	// createMember 메소드
	// Member를 매개변수로 받아서
	// Connection 객체 생성
	// MemberDao에게 Connection과 Member 전달
	// int 반환
	
	public int createMember(Member member) {
		Connection conn = getConnection();
		int result = memberDao.createMember(member, conn);
		close(conn);
		return result;
	}
}
