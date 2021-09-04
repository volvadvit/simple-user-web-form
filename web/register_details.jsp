<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.volvadvit.userform.dao.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Form App</title>
    </head>
    <body>
        <h1><%=request.getAttribute("name")%> <%=request.getAttribute("confirm")%> registered!</h1>
        <br>
        <h3>
            <a href="/user/register"> <b> Back </b> </a>
        </h3>
    </body>
</html>