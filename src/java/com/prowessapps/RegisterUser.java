package com.prowessapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String n="",l="",c="",g="",p="",cp="";
        int a=0;
        java.sql.Date dob=null;
        java.util.Date date=null;
        try {
            
            if(request.getParameter("name")!=null)
                n=request.getParameter("name");
            if(request.getParameter("location")!=null)
                l=request.getParameter("location");
            if(request.getParameter("college")!=null)
                c=request.getParameter("college");
            if(request.getParameter("gender")!=null)
                g=request.getParameter("gender");
            if((request.getParameter("ages"))!="")
                a=Integer.parseInt(request.getParameter("ages"));
            if(request.getParameter("password")!=null)
                p=request.getParameter("password");
            if(request.getParameter("confirmpassword")!=null)
                cp=request.getParameter("confirmpassword");
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            try {
                if(request.getParameter("dob")!=null){
                    date=format.parse(request.getParameter("dob"));
                 dob=new java.sql.Date(date.getDate());}
            } catch (ParseException ex) {
                Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con=DBConnection.getDbConnection();
            con.setAutoCommit(false);
            PreparedStatement pst2=con.prepareStatement("select * from user_info where name=?");
            pst2.setString(1,n);
            ResultSet rs=pst2.executeQuery();
            if(!rs.next()){
            PreparedStatement pst=con.prepareStatement("insert into user_info values(?,?,?,?,?,?)");
            pst.setString(1,n);
            pst.setString(2,l);
            pst.setString(3,c);
            pst.setString(4,g);
            pst.setInt(5, a);
            pst.setDate(6, dob);
            System.out.println("above execute");
            int status=pst.executeUpdate();
            System.out.println("Hello World");
            PreparedStatement pst1=con.prepareStatement("insert into login_master values(?,?,?,?)");
            pst1.setString(1, n);
            pst1.setString(2, cp);
            pst1.setString(3, "user");
            pst1.setString(4, "loggedout");
            int status1=pst1.executeUpdate();
            if(status>0 && status1>0 && n!="" && l!="" && c!="" && g!="" && a!=0 && dob!=null && p!="" && cp!="" && p.equals(cp) )
            {
                con.commit();
                request.setAttribute("regMsg","Registration Completed Sucessfully");
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
            }
            else
            {
                if(n==""){
                    request.setAttribute("regMsg","Registration Failed-Name not entered");
                }
                else if(!p.equals(cp)){
                    request.setAttribute("regMsg","Registration Failed-Password and Confirm Password do not match");
                }
                else if(l==""){
                    request.setAttribute("regMsg","Registration Failed-Location not entered");
                }
                else if(c==""){
                    request.setAttribute("regMsg","Registration Failed-College not entered");
                }
                else if(g==""){
                    request.setAttribute("regMsg","Registration Failed-Gender not entered");
                }
                else if(a==0){
                    request.setAttribute("regMsg","Registration Failed-Age not entered");
                }
                else if(dob==null){
                    request.setAttribute("regMsg","Registration Failed-Date of Birth not entered");
                }
                con.rollback();
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            }
            else
            {
                request.setAttribute("regMsg","Registration Failed-UserID already in use");
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
            }
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
