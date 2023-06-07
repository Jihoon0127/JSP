import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String id = request.getParameter("id");
      String password = request.getParameter("password");
      
      if(id.equals("test")&&password.equals("12345")) {
         response.sendRedirect("Ex08Main.jsp?id="+id);
      } else {
         response.sendRedirect("Ex08LoginForm.html");
      }
      
//      response.setContentType("text/html; charset=UTF-8");
//      PrintWriter out = response.getWriter(); 
//      out.print("id:"+id+"<br>");
//      out.print("pw:"+pw);
      
   }

}
