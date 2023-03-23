package edu.kh.community.member.model.service;


import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.community.member.model.DAO.MemberDAO;
import edu.kh.community.member.model.vo.Member;
public class MemberService {

	
	private MemberDAO dao = new MemberDAO();
	
	/** 회원 정보 조회 Service
	 * @param memberEmail
	 * @return
	 */
	public Member selectOne(String memberEmail) throws Exception{
		
		Connection conn = getConnection();
		
		Member member = dao.selectOne(conn, memberEmail);
		
		
		close(conn);
		
		
		return member;
	}
	
	
	
	
}
