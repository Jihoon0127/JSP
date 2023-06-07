<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Random"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%  request.setCharacterEncoding("UTF-8");
 String[] Arraylist = request.getParameterValues("fuck"); 

 Random fucking = new Random();
 int veryfuck = fucking.nextInt(Arraylist.length); 
 %>
 
 
 
 
<h1 align='center'>랜덤 당첨 게임</h1>
	<fieldset align='center'>
	<legend >랜덤뽑기결과</legend>
	<form >
	<div >
		<legend>오늘 점심메뉴는?</legend>
		<legend><%=Arraylist[veryfuck] %></legend>
</div>
	</form>
	</fieldset>
</body>
</html>