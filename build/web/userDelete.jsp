<%-- 
    Document   : userDelete
    Created on : Jul 16, 2017, 6:27:31 AM
    Author     : mahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete User</title>
    </head>
    <body>
    <center>
        <div style="background: #ca4335; width:500px; margin-top: 200px; border-radius: 10px; box-shadow: 2px 2px 2px black">
            <form style="padding:40px" method="post" action="DeleteUser">
                <table>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="deleteuser" value="Delete"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
