<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
int int_num1 = Integer.parseInt(request.getParameter("one"));
int int_num2 = Integer.parseInt(request.getParameter("two"));
String ope1 = request.getParameter("ope");

if(ope1.equals("plus")) {
	out.print(int_num1 +" + "+ int_num2+" ="+ (int_num1+int_num2));
}else if(ope1.equals("minus")) {
	out.print(int_num1 +" - "+ int_num2+" = "+ (int_num1-int_num2));
}else if(ope1.equals("mul")) {
	out.print(int_num1 +" * "+ int_num2+" = "+ (int_num1*int_num2));
}else {
	out.print(int_num1 +" / "+ int_num2+" = "+ (int_num1/int_num2));
}
%>
</body>
</html>