package com.jwt.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import com.jwt.login.Login;
import com.jwt.persistence.HibernateUtil;

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query qry;
        try {
        	if(((String)request.getParameter("pincode")).length()!=6)
        		throw new ArithmeticException ("Pincode is not Valid please go back and try again with New PIN :)");
        
        try {
        	
            ProfilePOJO pr=new ProfilePOJO();
            if(Register.getUser()!=null)            pr.setUserid(Register.getUser());
            else if(Login.getUser()!=null )			pr.setUserid(Login.getUser());
            pr.setFname(fname);
            pr.setLname(lname);
            pr.setAddress(address);
            pr.setCity(city);
            pr.setPin(pin);
            pr.setDob(date);
            
            Transaction tx = session.beginTransaction();
    		session.save(pr);
    		tx.commit();
    		session.flush();

            RequestDispatcher rsd = request.getRequestDispatcher("Welcome");
            rsd.include(request, response);
        }
        catch(Exception e)
        {
        	out.println("SORRY");
        	out.println("Please retry again..."+e);
        }
            Transaction transaction = session.beginTransaction();  
        try {
        	     	
        	qry=session.createQuery("UPDATE Validate v set v.profile=:profile where v.userid=:userid");
        	qry.setInteger("profile",1);
        	if(Register.getUser()!=null)          	qry.setString("userid",Register.getUser());
            else if(Login.getUser()!=null )			qry.setString("userid",Login.getUser());
			int res = qry.executeUpdate();
			transaction.commit();
        }
        catch(Exception e)
        {
        	
        	transaction.rollback();
        	out.println("Not Updated..."+e);
        }        
        
        
      }
        catch(ArithmeticException ae)
        {
        	out.println(ae.getMessage());
        }
        
	}
//	STR_TO_DATE(?,'%d-%m-%Y')
}