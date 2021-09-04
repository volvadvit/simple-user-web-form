<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.volvadvit.userform.dao.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <h1>User <%=request.getAttribute("name")%> <%=request.getAttribute("confirm")%> logged!</h1>
        <br>
        <h3>
            <a href="/user/login"> <b> Back </b> </a>
        </h3>
    </body>
</html>