package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.student.model.dao.DepartmentDAO;
import edu.kh.jsp.student.model.vo.Student;

public class DepartmentService {

	private DepartmentDAO dao = new DepartmentDAO();
	
	public List<Student> selectDepartment(String department) throws Exception{
		
		// 커넥션 생성
		Connection conn = getConnection();
		
		List<Student> departList = dao.departList(conn, department);
		
		// 객체 반환
		
		close(conn);
		
		return departList;
		
	}

}
