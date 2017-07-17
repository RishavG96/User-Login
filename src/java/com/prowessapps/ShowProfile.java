package com.prowessapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ShowProfile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String user=request.getParameter("value");
            System.out.println(user);
            Connection con=DBConnection.getDbConnection();
            PreparedStatement pst=con.prepareStatement("select * from user_info where name=?");
            pst.setString(1,user);
            ResultSet rs=pst.executeQuery();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowProfile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<table border='1'>");
            if(rs.next()){
            out.println("<tr>");
            out.println("<td>Name</td>");
            out.println("<td>"+rs.getString("name")+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Location</td>");
            out.println("<td>"+rs.getString("location")+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>College</td>");
            out.println("<td>"+rs.getString("college")+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Gender</td>");
            out.println("<td>"+rs.getString("gender")+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Age</td>");
            out.println("<td>"+rs.getInt("age")+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Date of Birth</td>");
            out.println("<td>"+rs.getDate("dob")+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
