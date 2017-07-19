package com.prowessapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUser extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session=request.getSession();
            if(session.getAttribute("u")==null)
            {
                session.setAttribute("errorMsg", "Your session has expired, please login to continue");
                response.sendRedirect("index.jsp");
            }
            else if(session.getAttribute("role").equals("user"))
            {
                response.sendRedirect("userhome.jsp");
            }
            String user=request.getParameter("username");
            Connection con=DBConnection.getDbConnection();
            PreparedStatement pst=con.prepareStatement("delete from login_master where user_id=?");
            pst.setString(1,user);
            PreparedStatement pst1=con.prepareStatement("delete from user_info where name=?");
            pst1.setString(1,user);
            int status=pst.executeUpdate();
            int status1=pst1.executeUpdate();
            if(status>0 && status1>0)
            {
                request.setAttribute("deleteMsg", "Record Deleted Sucessfully");
            }
            else{
                request.setAttribute("deleteMsg", "Record Not Found");
            }
            RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");
            rd.forward(request, response);
        }
        catch(Exception e)
        {
            System.out.println("Exception in DeleteUser"+e);
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
