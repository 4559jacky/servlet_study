package com.gn.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.gn.member.vo.Member;

import static com.gn.common.sql.JDBCTemplate.close;

public class MemberDao {
	// createMember 메소드
	// 매개변수로 Connection, Member 받아서
	// DB에 INSERT(member_id, member_pw, member_name)
	// 결과를 int로 반환
	public int createMember(Member member, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO member(member_id, member_pw, member_name) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  member.getMemberId());
			pstmt.setString(2,  member.getMemberPw());
			pstmt.setString(3,  member.getMemberName());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
}
