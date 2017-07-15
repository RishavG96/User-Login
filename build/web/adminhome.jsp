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
    <body>
        <h1>Welcome admin <%out.print(request.getAttribute("uname"));%></h1>
    </body>
</html>
