package Ex011111111;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex011")
public class Ex011 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data =request.getParameter("data");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out =response.getWriter(); 
		out.print("입력한 숫자는 <b>" + data + "</b> 입니다.");
	}

	
	
}
