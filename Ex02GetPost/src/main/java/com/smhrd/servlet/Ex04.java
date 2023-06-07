package com.smhrd.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04")
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String password =request.getParameter("password");
		String password1 =request.getParameter("password1");
		String gender =request.getParameter("gender");
		String blood =request.getParameter("blood");
		String birthday =request.getParameter("birthday");
		String[] hobby = request.getParameterValues("hobby");
		String color =request.getParameter("color");
		String talk =request.getParameter("talk");
		
		System.out.println(id);
		// if문 사용하기
		if(password.equals(password1)) {
			System.out.println("패스워드가 일치 합니다.");
		}else {
			System.out.println("패스워드가 일치하지 않습니다.");
		}
		
		System.out.println(gender);
		// 각각 value값 넣어주기
		System.out.println(blood);
		System.out.println(birthday);
		//배열 출력하기
		for(int i = 0; i< hobby.length; i++) {
		System.out.print(hobby[i]);	
		}
		
		System.out.println(color);
		System.out.println(talk);
	}

}
