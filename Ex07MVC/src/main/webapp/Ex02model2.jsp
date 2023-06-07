<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.smhrd.model.FullStack" %>
<%@ page import= "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    <%-- 세션에서 학생 정보 가져오기 --%>
    <% 
        List<FullStack> studentList = (List<FullStack>) session.getAttribute("studentList");
        if (studentList != null) {
            for (Object obj : studentList) {
                if (obj instanceof FullStack) {
                    FullStack student = (FullStack) obj;
    %>
    <p>
        Name: <%= student.getName() %><br>
        Major: <%= student.getMajor() %><br>
        Phone: <%= student.getPhone() %>
    </p>
    <% 
                }
            }
        }
    %>
</body>
</html>