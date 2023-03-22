package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.vo.Student;
import static edu.kh.jsp.common.JDBCTemplate.*;

public class DepartmentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public DepartmentDAO() {
		
		try {
			// 기본 생성자가 생성되면서 sql구문이 실행되어야함
			// 경로 설정이 필요
			
			String filePath = DepartmentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	

	public List<Student> departList(Connection conn, String department) throws Exception {
		
		
		List<Student> departList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("departSelect");
			
			
			
			// Statement 객체 생성
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, department);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				departList.add(new Student(studentNo,studentName,studentAddress,departmentName));
				
			}
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		
		
		return departList;
	}
}
