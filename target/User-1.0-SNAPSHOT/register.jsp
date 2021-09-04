<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <div align="center">
          <h1>User Sign up Form</h1>
          <form action="<%= request.getContextPath() %>/register" method="post">
           <table style="with: 80%">
            <tr>
             <td>First Name</td>
             <td><input type="text" name="firstName" /></td>
            </tr>
            <tr>
             <td>Last Name</td>
             <td><input type="text" name="lastName" /></td>
            </tr>
            <tr>
             <td>UserName</td>
             <td><input type="text" name="username" /></td>
            </tr>
            <tr>
             <td>Password</td>
             <td><input type="password" name="password" /></td>
            </tr>
            <tr>
             <td>Address</td>
             <td><input type="text" name="address" /></td>
            </tr>
            <tr>
             <td>Contact No</td>
             <td><input type="text" name="contact" /></td>
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