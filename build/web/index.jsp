<%-- 
    Document   : index
    Created on : Jul 15, 2017, 9:42:08 AM
    Author     : mahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN USER</title>
    </head>
    <body style="background:whitespace">
    <center>
        <div style="background: #ca4335; width:500px; margin-top: 100px; border-radius: 10px; box-shadow: 2px 2px 2px black">
            <form style="padding:40px" method="post" action="MyServlet">
                <table>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="login"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color:white"><%
                            if(request.getAttribute("errorMsg")!=null)
                                out.println(request.getAttribute("errorMsg"));
                            %></td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
    </body>
</html>
