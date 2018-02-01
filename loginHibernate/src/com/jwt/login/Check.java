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
public class Check extends HttpServlet {
private String uname;


	public String getUname() {
	return uname;
}


public void setUname(String uname) {
	this.uname = uname;
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
        	Query qry; List l;Iterator it;
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
            	uname = request.getParameter("uname");
            	setUname(uname);
                qry=session.createQuery("from Validate v where v.userid=?");
                qry.setParameter(0,uname);
                l =qry.list();
    			//it = l.iterator();
                
                if (l.size()==0) {
                    out.println("<font color=green><b>"+uname+"</b> is avaliable");
                }
                else{
                out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
                }
                out.println();
            }
            catch(Exception e) {
            	out.print("There is a problem"+e);
            }
            
        } catch (Exception ex) {

            out.println("Error ->" + ex.getMessage());

        } finally {
            out.close();
        }
    }

/*    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }*/
}