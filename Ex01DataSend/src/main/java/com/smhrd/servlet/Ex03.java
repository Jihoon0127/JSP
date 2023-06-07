package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터 2개(name = num1, num2) 받기
		String num1 = request.getParameter("num1");
		// String -> int(정수형)
		// Integer : int(정수형)의 클래스(Class) 타입
		// parseInt(String) : 문자열(String) -> 정수형(int) 변환
		// parseInt("ㄱㄴㄷ"); -> 변환이 불가능하므로 오류 ** 문자열안에 숫자만 포함되어 있을 수 있도록 주의
		int int_num1 = Integer.parseInt(num1);
		
//		String num2 = request.getParameter("num2");
		int int_num2 = Integer.parseInt(request.getParameter("num2"));
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(int_num1 +" + "+ int_num2+" = "+ (int_num1+int_num2));
	}

}
