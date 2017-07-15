<%-- 
    Document   : home
    Created on : Jul 15, 2017, 10:08:28 AM
    Author     : mahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welcome <%out.print(request.getAttribute("uname"));%></h1>
    </body>
</html>
