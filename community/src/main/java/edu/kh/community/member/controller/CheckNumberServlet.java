package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;

@WebServlet("/member/checkNumber")
public class CheckNumberServlet extends HttpServlet {
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputEmail = req.getParameter("inputEmail");
		
		String checkNumber = null;
		MemberService service = new MemberService();
		
		
		try {
			
			 checkNumber = service.checkNumber(inputEmail);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	

}
