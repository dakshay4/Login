package com.jwt.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jwt.persistence.HibernateUtil;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class Register extends HttpServlet{
	
	static String userid;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.println("Entered in Register.java");
        userid = request.getParameter("uname");
        final String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String mobilee=request.getParameter("mobile");
        long mobile = Long.parseLong(mobilee);
        isCorrectEmail ic =new isCorrectEmail();
        out.println(userid+"||"+email+"||" +pass+ "||"+mobilee);        
        
   try {
       // 	out.println("Hi. .."+userid);
        if(!(mobilee.length()==10 && ic.validate(email))) throw new ArithmeticException ("Invalid Mobile Number or EmailId, go back and try again");
        
        Query qry; List l;Iterator it;
        boolean flag=false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        	
            qry=session.createQuery("Select v from Validate v");
            l=qry.list();
    		it=l.iterator();
    		while(it.hasNext()) {
    			Object o = (Object) it.next();
    			Validate vt=(Validate) o;
        	  if((userid.equals(vt.getUserid())) || (email.equals(vt.getEmail())) || (mobile==(vt.getMobile()))) {
        		  flag=true;break;
        	  }
        	  else continue;
            }
            if(flag)   throw new ArithmeticException ("Username or EmailId or mobile already exists! Please go back and try again!");
           /*  PreparedStatement ps=con.prepareStatement("Select * from REGISTER");*/
          
            try {
                Validate val=new Validate();
                val.setUserid(userid);
                val.setEmail(email);
                val.setPass(pass);
                val.setMobile(mobile);
                Transaction tx = session.beginTransaction();
        		session.save(val);
        		tx.commit();
        		session.flush();
                RequestDispatcher rsd = request.getRequestDispatcher("profile.html");
                rsd.include(request, response);
            }
            catch(Exception e)
            {
            	out.println("err!."+e.getMessage());
            }
          
        }
        catch(ArithmeticException e) {
        	out.println("Error :!!!!"+e.getMessage());        	
        }
        catch(Exception e) {
        	out.println("error:"+e.getMessage());        	
        }
      
}
        catch(ArithmeticException ae)
        {
        	out.print(ae.getMessage());
        }
        
	}
		public static String getUser() {
		return userid;
	}
}