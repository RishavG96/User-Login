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
        <center>
            <div style="background: #ca4335; width:500px; margin-top: 200px; border-radius: 10px; box-shadow: 2px 2px 2px black">
                <h1>Welcome user <%out.print(request.getAttribute("uname"));%></h1>
                    
                <a href="ShowProfile?value=<%out.print(request.getAttribute("uname"));%>" >Show Profile</a>
                
                <!--<c:url var="ShowProfile" value="ShowProfile">
                    <c:param name="query" value="${request.getAttribute("uname")}" />
                </c:url>
                <a href="${ShowProfile}">Show Profile</a>-->
            </div>
        </center>
    </body>
</html>
