package edu.kh.community.member.model.DAO;

import static edu.kh.community.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.community.member.model.vo.Member;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public MemberDAO() {
		
		try {
			
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/edu/kh/community/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/** 회원 정보 DAO
	 * @param conn
	 * @param memberEmail
	 * @return
	 */
	public Member selectOne(Connection conn, String memberEmail) throws Exception{
		
		Member member = new Member();
		
		try {
			
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberEmail);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				// MEMBER_NICK, MEMBER_TEL, MEMBER_ADDR, ENROLL_DT
				member.setMemberEmail(memberEmail);
				member.setMemberNickname(rs.getString("MEMBER_NICK"));
				member.setMemberTel(rs.getString("MEMBER_TEL"));
				member.setMemberAddress(rs.getString("MEMBER_ADDR"));
				member.setEnrollDate(rs.getString("ENROLL_DATE"));
				
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	/** 인증번호, 발급일 수정 DAO
	 * @param conn
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 * @throws Exception
	 */
	public int updateCertification(Connection conn, String inputEmail, String cNumber) throws Exception {
		
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateCertification");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cNumber);
			pstmt.setString(2, inputEmail);
			
			result = pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 인증번호 생성 DAO
	 * @param conn
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 */
	public int insertCertification(Connection conn, String inputEmail, String cNumber) throws Exception {

		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertCertification");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, cNumber);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	

	public String checkNumber(Connection conn, String inputEmail) throws Exception{
		
		String checkNumber = null;
		
		
		try {
			
			String sql = prop.getProperty("selectCheckNumber");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			
			rs = pstmt.executeQuery();
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			
		}
		
		
		
		return checkNumber;
	}

	
	
	
	
	
	
	
	
	
}
