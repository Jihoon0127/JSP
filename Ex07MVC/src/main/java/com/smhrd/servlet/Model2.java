package com.smhrd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.FullStack;

@WebServlet("/Model2")
public class Model2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	FullStack fs =null;
    	try {
    		// 오라클과 연결할 드라이버 가지고 오기 (동적 로딩)
    		Class.forName("oracle.jdbc.OracleDriver");

    		// 지정한 데이터베이스와 연결하기 위한 객체(Connection) 생성
    		String url = "jdbc:oracle:thin:@localhost:1521:xe";
    		String user = "service";
    		String password = "12345";

    		conn = DriverManager.getConnection(url, user, password);

    		String sql = "select * from fullstack ";
    		// sql 쿼리문을 다루기 위한 객체(PreparedStatement) 생성 : 완성, 실행 등
    		ps = conn.prepareStatement(sql);

    		//? 자리 채우기
    		ps.setString(1, "선영표");

    		// INSERT, DELETE, UPDATE -> executeUpdate() -> int (몇 개행이 update 되었는지)
    		// SELECT (READ)-> executeQuery() -> ResultSet (읽어온 데이터, 커서))
    		// sql 실행
    		rs = ps.executeQuery();

    		if (rs.next()) { //next() -> true(커서가 가리키고 있는 행에 데이터가 있음) / false(없음)
    			String name = rs.getString("name"); // 컬럼이름 지정
    			String major = rs.getString(2); //테이블 상 2번째 컬럼값
    			String phone = rs.getString("phone");

    			fs = new FullStack(name, major, phone);
    		}
    	} catch (ClassNotFoundException e) {
    		//OricleDriver 가지고 올때 경로가 잘못됐을 경우
    		System.out.println("OracleDriver 클래스 못찾음!");
    	} catch (SQLException e) {
    		System.out.println("sql 예외 발생!");
    	} catch (Exception e) {
    		System.out.println("다른 예외 발생");
    		e.printStackTrace(); //원인, 발생하게 된 절차
    	} finally { //예외상황이 발생 하던지/ 하지 않던지 간에 무조건 실행!
    		//사용한 자원 반환(생성한 순서 반대로!)
    		try{
    		rs.close();
    		ps.close();
    		conn.close();
    		}catch(Exception e){
    			System.out.println("finally 에서 예외상황 발생!");
    			e.printStackTrace();
    		}
    	}
    	
    	// list -> session에 저장
    	HttpSession session = request.getSession();
    	session.setAttribute("list", list);
    	response.sendRedirect("Ex02mode12.jsp");
    	
    	
    	}
    	
    }


