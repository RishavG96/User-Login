<%-- 
    Document   : adminhome.jsp
    Created on : Jul 15, 2017, 10:54:11 AM
    Author     : mahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
    </head>
    <%
        if(session.getAttribute("u")==null)
        {
            session.setAttribute("errorMsg", "Your session has expired, please login to continue");
            response.sendRedirect("index.jsp");
        }
        else if(session.getAttribute("role").equals("user"))
        {
            response.sendRedirect("userhome.jsp");
        }
        %>
    <body>
        
        <center>
            <div style="background: #ca4335; width:500px; margin-top: 200px; border-radius: 10px; box-shadow: 2px 2px 2px black">
                <h1>Welcome admin <%out.print(session.getAttribute("uname"));%></h1>
                <a href="ShowUsers">Show all Users</a> &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="userDelete.jsp">Delete User</a><br><br>
                <form action="Logout" method="post">
                    <input type="submit" value="LOGOUT" name="logout"/>
                </form>
                <%
                if(request.getAttribute("deleteMsg")!=null){
                    out.println(request.getAttribute("deleteMsg"));
                }
                %>
            </div>
        </center>
    </body>
</html>
