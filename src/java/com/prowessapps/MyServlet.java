package com.prowessapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s=request.getParameter("username");
        String p=request.getParameter("password");
        try {
            Connection con=DBConnection.getDbConnection();
            PreparedStatement pst=con.prepareStatement("select * from login_master where user_id=? and password=?");
            pst.setString(1,s);
            pst.setString(2,p);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                if(rs.getString(3).equals("admin"))
                {
                    request.setAttribute("uname",s);
                    RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    request.setAttribute("uname",s);
                    RequestDispatcher rd=request.getRequestDispatcher("userhome.jsp");
                    rd.forward(request, response);
                }
            }
            else
            {
                request.setAttribute("errorMsg","Username or Password incorrect");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in MyServlet"+e);
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
