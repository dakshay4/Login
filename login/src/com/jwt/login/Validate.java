/*package com.jwt.login;

import java.sql.*;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jwt.login.Register;

public class Validate
 {
     public static boolean checkUser(String email,String pass)
     {
    	 boolean flag = false;
    	 Configuration cfg = new Configuration();
 		cfg.configure("hibernate.cfg.xml");
 		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		try {
		Query qry=session.createQuery("select r from Register r");
		List l=qry.list();
		Iterator it=l.iterator();
		while(it.hasNext()) {
			Object o = (Object) it.next();
			Register r = (Register)o;
			try {
				if(r.getEmail() == email && r.getPass() == pass)
				{
					flag=true; break;
				}
				else {
					flag=false;
				}
			}
			catch(Exception e)
			{
				System.err.println("Exception: ");
				   System.out.println("Exception at: "+ e.getMessage().getClass().getName());
				   e.printStackTrace();
			}
		}
		
		}
		catch(Throwable t)
		  {
			System.err.println("Exception: ");
		  }
		if(flag) return true;
		else return false;
		
  }   
}*/