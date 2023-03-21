package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.vo.Person;

@WebServlet("/foreach")
public class ForEachServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<Person> pList = new ArrayList<>();
		
		pList.add( new Person("홍길동", 25, "서울시 중구") );
		pList.add( new Person("고길동", 25, "서울시 강남구") );
		pList.add( new Person("박길동", 25, "서울시 강서구") );
		pList.add( new Person("강길동", 25, "서울시 성동구") );
		pList.add( new Person("김길동", 25, "서울시 종로구") );
		
		
		req.setAttribute("pList", pList);
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/foreach.jsp");
		
		
		dispatcher.forward(req, resp);
	}
	
	

}
