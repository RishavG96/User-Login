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
    <body>
        <h1>Welcome user <%out.print(request.getAttribute("uname"));%></h1>
    </body>
</html>
