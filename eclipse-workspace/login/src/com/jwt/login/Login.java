package com.jwt.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Login extends HttpServlet {
	static String userString;
	
	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//        out.println("Entered in Login.java");
        
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
//        out.println(email+"and"+pass);
        boolean flag=false;
        try {
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery("select * from REGISTER");
        int userProfileId=0;
        while(rs.next()){
//        	out.println("Entered in rs.next()");
//        	out.println(rs.getInt(1)+" and "+rs.getString(2)+ " and " + rs.getString(3));
        	if((rs.getString(1).equals(email) || rs.getString(2).equals(email)) && rs.getString(3).equals(pass))
			{
				flag=true; userString=rs.getString(1);userProfileId=rs.getInt(5);break;
			}
			else {
				flag=false;
			}
        }
        if(flag) {
        	if(userProfileId==1)
        	{
        		RequestDispatcher rsd = request.getRequestDispatcher("Welcome");
        		rsd.forward(request, response);
        	}
        	else {
        		RequestDispatcher rsd = request.getRequestDispatcher("profile.html");
        		rsd.forward(request, response);
        	}
        }
        else {
        	 out.println("Username or Password incorrect");
             RequestDispatcher rsd = request.getRequestDispatcher("retry.html");
             rsd.include(request, response);
        }
       }
        catch(Exception e)
        {
        	
        }
    }  
    	public static String getUser() {
		return userString;
	}
}
