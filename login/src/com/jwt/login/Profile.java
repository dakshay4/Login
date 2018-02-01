package com.jwt.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.jwt.login.Login;

public class Profile extends HttpServlet{
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.println("Entered in Register.java");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String city=request.getParameter("city");
        int pin=Integer.parseInt((String)request.getParameter("pincode"));
//        Date date=new Date((long)request.getDateHeader("dob"));
        String date=request.getParameter("dob");
        //out.print(date);
        try {
        	if(((String)request.getParameter("pincode")).length()!=6)
        		throw new ArithmeticException ("Pincode is not Valid please go back and try again with New PIN :)");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
            String sql ="INSERT INTO PROFILE(FIRST_NAME,LAST_NAME,ADDRESS,CITY,PIN,DOB,USERID)"+"VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,fname);
            ps.setString(2,lname);
            ps.setString(3,address);
            ps.setString(4,city);
            ps.setInt(5,pin);
            ps.setString(6, date);
            if(Register.getUser()!=null)            ps.setString(7, Register.getUser());
            else if(Login.getUser()!=null )			ps.setString(7, Login.getUser());
            ps.executeUpdate();
            con.close();
            RequestDispatcher rsd = request.getRequestDispatcher("Welcome");
            rsd.include(request, response);
        
       
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
        	sql="UPDATE REGISTER SET PROFILE=1 WHERE USERID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, Login.getUser());
        	ps.executeUpdate();
            
        }
        catch(Exception e)
        {
        	out.println("Not Updated..."+e);
        }        
        
        }
        catch(Exception e)
        {
        	out.println("SORRY");
        	out.println("Please retry again..."+e);
        }
      }
        catch(ArithmeticException ae)
        {
        	out.println(ae.getMessage());
        }
        
	}
//	STR_TO_DATE(?,'%d-%m-%Y')
}