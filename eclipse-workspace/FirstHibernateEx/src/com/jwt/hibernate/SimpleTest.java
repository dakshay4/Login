package com.jwt.hibernate;
import java.util.*;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SimpleTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		String ch="";
		do {
			
			
			Session session = factory.openSession();            
			Student student = new Student();			
		System.out.println("Please Enter Details Name -> Rollno -> MobileNo -> Degree");
		String s;
		s=sc.nextLine();
		student.setName(s);
		s=sc.nextLine();
		student.setDegree(s);
		s=sc.nextLine();
		student.setRoll(s);
		s=sc.nextLine();
		student.setPhone(s);
					
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		factory.close();
		session.flush();
		ch = sc.next();
		sc.nextLine();
		}while(ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("y"));

		System.out.println("Object saved successfully.....!!");
		sc.close();
		
		
	}
}