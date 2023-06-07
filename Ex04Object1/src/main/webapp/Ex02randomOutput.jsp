<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
<%  request.setCharacterEncoding("UTF-8");
int num1 = Integer.parseInt(request.getParameter("num"));%>
	
	<h1 align='center'>랜덤 당첨 게임</h1>
	<fieldset align='center'>
		<legend>랜덤뽑기</legend>
		<form action="Ex02createInput.jsp">
			<div>
				 주제 : <input type="text"><br>
				<% for(int i =1; i<=num1 ; i++){%>
				아이템 : <input type="text" name ="fuck"><br>
				<%} %> 
				<input type="submit" value="생성하기">
			</div>
		</form>
	</fieldset>
</body>
</html>