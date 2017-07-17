package com.prowessapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s=request.getParameter("username");
        String p=request.getParameter("password");
        String rm=request.getParameter("rm");
        try {
            boolean found=false;
            Cookie ck=null;
            Cookie c[]=request.getCookies();
            for(Cookie c1:c)
            {
                if(c1.getName().equals("mycookie"))
                {
                    found=true;
                    ck=c1;
                    break;
                }
            }
            
            if(found)
            {
                String value=ck.getValue();
                String s1[]=value.split(":");
                Connection con=DBConnection.getDbConnection();
                PreparedStatement pst=con.prepareStatement("select * from login_master where user_id=? and password=?");
                pst.setString(1,s);
                pst.setString(2,p);
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    
                    HttpSession session=request.getSession(true);
                    System.out.println(ck.getName()+s1[0]+s1[1]+s1[2]);
                    session.setAttribute("u", s1[0]);
                    if(s1[2].equals("admin")){
                        session.setAttribute("role", "admin");
                        response.sendRedirect("adminhome.jsp");
                    }
                    else{
                        session.setAttribute("role", "user");
                        response.sendRedirect("userhome.jsp");
                    }
                }
            }
            else
            {
            Connection con=DBConnection.getDbConnection();
            PreparedStatement pst=con.prepareStatement("select * from login_master where user_id=? and password=?");
            pst.setString(1,s);
            pst.setString(2,p);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                String value="";
                HttpSession session=request.getSession(true);
                session.setAttribute("u",s);
                if(rs.getString(3).equals("admin"))
                {
                    if(rm!=null && rm.equals("on"))
                    {
                        value=s+":"+p+":"+"admin";
                        Cookie cookie=new Cookie("mycookie",value);
                        cookie.setMaxAge(60*60*24*30);
                        response.addCookie(cookie);
                    }
                    session.setAttribute("role", "admin");
                    session.setAttribute("uname",s);
                    response.sendRedirect("adminhome.jsp");
                }
                else
                {
                    if(rm!=null && rm.equals("on"))
                    {
                        value=s+":"+p+":"+"user";
                        Cookie cookie=new Cookie("mycookie",value);
                        cookie.setMaxAge(60*60*24*30);
                        response.addCookie(cookie);
                    }
                    session.setAttribute("role", "user");
                    session.setAttribute("uname",s);
                    response.sendRedirect("userhome.jsp");
                }
            }
            else
            {
                request.setAttribute("errorMsg","Username or Password incorrect");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
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
