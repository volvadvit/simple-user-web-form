<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User form app</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
        <div align="center">
            <h1>Hello to user-database-app app!</h1>

            <%
                String[] pages = new String[]{"Registration","Login"};
                request.setAttribute("urls", pages);
            %>

            <ur>
                <c:forEach var="url" items="${urls}">
                    <li>
                        <a href="<c:url value='${url}.jsp'/>">${url}</a>
                    </li>
                </c:forEach>
            </ur>
        </div>
    </body>
</html>