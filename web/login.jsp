<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Authentication</title>
    </head>
    <body>
        <div align="center">
          <h1>User Sign in Form</h1>
          <form action="<%= request.getContextPath() %>/login" method="post">
           <table style="with: 80%">
                <tr>
                    <td>UserName</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
           </table>
           <input type="submit" value="Submit" />
          </form>
          <br>
            <h6>
                <a href="/user/"> <b> Back </b> </a>
            </h6>
         </div>
    </body>
</html>