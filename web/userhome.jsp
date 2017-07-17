<%-- 
    Document   : userhome
    Created on : Jul 15, 2017, 10:53:55 AM
    Author     : mahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home</title>
    </head>
    <%
        if(session.getAttribute("u")==null)
        {
            session.setAttribute("errorMsg", "Your session has expired, please login to continue");
            response.sendRedirect("index.jsp");
        }
        else if(session.getAttribute("role").equals("admin"))
        {
            response.sendRedirect("adminhome.jsp");
        }
        %>
    <body>
        <center>
            <div style="background: #ca4335; width:500px; margin-top: 200px; border-radius: 10px; box-shadow: 2px 2px 2px black">
                <h1>Welcome user <%out.print(session.getAttribute("uname"));%></h1>
                    
                <a href="ShowProfile?value=<%out.print(session.getAttribute("uname"));%>" >Show Profile</a>
                <form action="Logout" method="post">
                    <input type="submit" value="LOGOUT" name="logout"/>
                </form>
            </div>
        </center>
    </body>
</html>
