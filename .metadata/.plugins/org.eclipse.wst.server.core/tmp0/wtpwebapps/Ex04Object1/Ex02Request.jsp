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
String name1 = request.getParameter("name");
int java1 = Integer.parseInt(request.getParameter("java"));
int web1 = Integer.parseInt(request.getParameter("web"));
int iot1 = Integer.parseInt(request.getParameter("iot"));
int and1 = Integer.parseInt(request.getParameter("and"));




int av = (java1+web1+iot1+and1)/4;

String avg ;
if(av >=95 && av<=100){
	out.print("A+");
	avg = "A+";
}else if(av>=90 && av<=94){
	avg= "A";
	}else if (av>=85 && av<=89){
	avg = "B+";
	}else if(av>=80 && av <=84){
	avg ="B";
	}else{
		avg ="F";
	}
%>

	<fieldset>
		<legend>학점확인프로그램</legend>
		<form action="Ex02Request.jsp">
			<table>
				<tr>
					<td>이름</td>
					<td><%= name1 %></td>
				</tr>
				<tr>
					<td>Java점수</td>
					<td><%= java1 %></td>
				</tr>
				<tr>
					<td>Web점수</td>
					<td><%= web1 %></td>
				</tr>
				<tr>
					<td>IoT점수</td>
					<td><%= iot1 %></td>
				</tr>
				<tr>
					<td>Android점수</td>
					<td><%= and1 %></td>
				</tr>
				<tr>
					<td>평균</td>
					<td><%=av %></td>
				</tr>
				<tr>
					<td>학점</td>
					<td><%=avg %></td>
				</tr>
			</table>

		</form>
	</fieldset>

</body>
</html>