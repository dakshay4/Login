package com.jwt.login;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Register extends HttpServlet{
	
	static String userid;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.println("Entered in Register.java");
        userid = request.getParameter("userid");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String mobilee=request.getParameter("mobile");
        Double mobile = Double.parseDouble(mobilee);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
            String sql ="INSERT INTO REGISTER(USERID,EMAIL,PASS,MOBILE_NO,PROFILE)"+"VALUES(?,?,?,?,0)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,userid);
            ps.setString(2,email);
            ps.setString(3,pass);
            ps.setDouble(4,mobile);
            ps.executeUpdate();
            con.close();
            RequestDispatcher rsd = request.getRequestDispatcher("profile.html");
            rsd.include(request, response);
        }
        catch(Exception e)
        {
        	out.println("Oops! Username already Exists...");
        	out.println("Please retry again...");
        }
        
	}
	public static String getUser() {
		return userid;
	}
}