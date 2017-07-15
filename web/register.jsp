<%-- 
    Document   : register
    Created on : Jul 15, 2017, 6:08:07 PM
    Author     : mahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
    <center>
        <div style="background: #ca4335; width:500px; margin-top: 200px; border-radius: 10px; box-shadow: 2px 2px 2px black">
            <form style="padding:40px" method="post" action="RegisterUser">
                <table>
                    <tr>
                        <td>Enter Name</td>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Enter Password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="confirmpassword"/></td>
                    </tr>
                    <tr>
                        <td>Enter Location</td>
                        <td><input type="text" name="location"/></td>
                    </tr>
                    <tr>
                        <td>Enter  College</td>
                        <td><input type="text" name="college"/></td>
                    </tr>
                    <tr>
                        <td>Enter Gender</td>
                        <td><input type="radio" value="Male" name="gender"/>Male
                            <input type="radio" value="Female" name="gender"/>Female</td>
                    </tr>
                    <tr>
                        <td>Enter Age</td>
                        <td><input type="text" name="ages"/></td>
                    </tr>
                    <tr>
                        <td>Enter Date of Birth</td>
                        <td><input type="date" name="dob" placeholder="year/month/date"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Register" style="width:150px"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
    </body>
</html>
