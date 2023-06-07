package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class JoinController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		String url = "";

		try {
			// 요청 데이터 인코딩
			request.setCharacterEncoding("utf-8");

			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");

			WebMember member = new WebMember(email, pw, tel, address);

			WebMemberDAO dao = new WebMemberDAO(); // SqlSessionFactory 생성
			int cnt = dao.join(member); // 회원가입 기능

			if(cnt>0) { // 포워딩 방식!
	            // request 영역에 회원가입 시 입력한 이메일 추가 저장
	            request.setAttribute("joinEmail", email);
	            // -> joinEmail 이라는 키값으로 저장해둠
	            System.out.println("회원가입 성공!");
	            url = "joinSuccess.jsp";
	         } else {
	            System.out.println("회원가입 실패!");
	            url = "index.jsp";
	         }

		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 방식 잘못지정함!");
		} catch (IOException e) {
			System.out.println("redirect 경로 잘못지정");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		UnsupportedEncodingException
// 요청 데이터 인코딩 방식 지정
		return url;

	}
}
