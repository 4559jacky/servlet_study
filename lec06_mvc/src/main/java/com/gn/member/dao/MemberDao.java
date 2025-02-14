package com.gn.member.dao;

import static com.gn.common.sql.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.member.vo.Member;

public class MemberDao {
	// createMember 메소드
	// 매개변수로 Connection, Member 받아서
	// DB에 INSERT(member_id, member_pw, member_name)
	// 결과를 int로 반환
	
	// 회원가입
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
	
	// 로그인
	public Member loginMember(String id, String pw, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			String sql = "SELECT * FROM member WHERE member_id = ? and member_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			pstmt.setString(2,  pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new Member();
				m.setMemberNo(rs.getInt("member_no"));
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPw(rs.getString("member_pw"));
				m.setMemberName(rs.getString("member_name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		return m;
	}
	
	// 수정
	public int updateMember(Member m, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE member SET member_pw = ?, member_name = ? WHERE member_no = ?;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberName());
			pstmt.setInt(3, m.getMemberNo());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	// Session 재설정
	public Member updateSession(Member m, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		System.out.println("다오 : "+m);
		try {
			String sql = "SELECT * FROM member WHERE member_no = ?;";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, m.getMemberNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		System.out.println("다오 :" + member);
		return member;
	}
	
	
}
