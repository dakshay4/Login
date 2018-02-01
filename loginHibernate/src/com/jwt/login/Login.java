package com.jwt.login;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Query;
import org.hibernate.Session;
import com.jwt.persistence.HibernateUtil;

public class Login extends HttpServlet {
	static String userString;
	
	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//        out.println("Entered in Login.java");
        String emailOrUser = request.getParameter("emailOrUser");
        String pass = request.getParameter("pass");
//        out.println(email+"and"+pass);
		Session session = HibernateUtil.getSessionFactory().openSession();
        boolean flag=false;
       
        	Query qry; List l;Iterator it;
        	int userProfileId=0;
        	try {
    		qry=session.createQuery("select v from Validate v");
    		l=qry.list();
    		it=l.iterator();
    		while(it.hasNext()) {
    			Object o = (Object) it.next();
    			Validate vt=(Validate)o;
       			if((emailOrUser.equals(vt.getUserid()) || emailOrUser.equals(vt.getEmail())) && pass.equals(vt.getPass()))
    			{
    				flag=true; userString=vt.getUserid();userProfileId=vt.getProfile();break;
    			}
    			else {
    				flag=false;
    			}
    		
    		}
//        	out.println("Entered in rs.next()");
//        	out.println(rs.getInt(1)+" and "+rs.getString(2)+ " and " + rs.getString(3));
        	
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
        	 out.println("<font color=red size=6><b>Username or Password incorrect</b>");
             RequestDispatcher rsd = request.getRequestDispatcher("retry.html");
             rsd.include(request, response);
        }
       }
        catch(Exception e)
        {
        	out.print(e);
        }
        session.close();
    } 
    	public static String getUser() {
		return userString;
	}
    	
    	
    	
    	
}
