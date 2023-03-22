<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>



        #table{
            border-collapse: collapse;
            border:none;
        }

        #c > td:nth-child(1){
            text-align: center;
        }

        #a{
            background-color: black;
            color: white;
            
        }

        #b{
            background-color: antiquewhite;
        }

        #b > td:nth-child(1){
            text-align: center;
        }

        

    </style>
</head>
<body>
    
    
    <h1>[${ department }] 학과 검색 결과</h1>
    
    <table border="1" id="table">
    	
    	<tr id="a">
	    	<th>순서</th>
	    	<th>학번</th>
	    	<th>이름</th>
	    	<th>학과</th>
	    	<th>주소</th>
    	</tr>
    	
    	
    	
    	<c:forEach var="depart" items="${ departList }" varStatus="vs">
    		<c:choose>
    		
    			<c:when test="${ vs.count % 2 == 0 }">
    				<tr id=b >
		   				<td>${ vs.count }</td>
		   				<td>${ depart.studentNo }</td>
		   				<td>${ depart.studentName }</td>
		   				<td>${ depart.departmentName }</td>
		   				<td>${ depart.studentAddress }</td>
    				</tr>
    			</c:when>
    			
    			
    			<c:otherwise>
    			
    				<tr id="c">
		   				<td>${ vs.count }</td>
		   				<td>${ depart.studentNo }</td>
		   				<td>${ depart.studentName }</td>
		   				<td>${ depart.departmentName }</td>
		   				<td>${ depart.studentAddress }</td>
    				</tr>
    			
    				
    			
    			</c:otherwise>
    		
    		
    		
    		</c:choose>
    		
    		
    		
    	</c:forEach>
    	
    	
    	
    	
    
    
    
    </table>
    
    
    
    
</body>
</html>