package com.jwt.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.jwt.login.Login;
public class Welcome extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(Login.getUser()!=null) {
        out.println("Welcome "+Login.getUser()+" !");
        out.println(" to this Imaginery World");
        }
        else if(Register.getUser()!=null) {
        	out.println("Welcome " + Register.getUser()+" !");
            out.println("to this Imaginery World");
        }
      }  
}