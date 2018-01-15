// The Strategy is just to increase LOC.
// I can shorten the code to 30 % of LOC.
// Dakshay Agarwal ---> dakshay.tumblr.com
package com.jwt.hibernate;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SimpleTest1 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(); 
	/*	Object o=session.load(Student.class, new Long(0));
		Student s=(Student)o;
		*/
		
	/*	System.out.println("Name of the Student is:"+s.getName());
		System.out.println("Roll number of the Student is:"+s.getRoll());
		System.out.println("Phone of the Student is:"+s.getPhone());
		System.out.println("Degree of the Student is:"+s.getDegree());
		*/
		/*Query qry=session.createQuery("select s.roll from Student s");
		List l=qry.list();
		Iterator it = l.iterator();
		System.out.println("Name of the Students are:");*/
		String ch="";
		do {
		System.out.println("What type of operation did you want ?");
		System.out.println("1. Entry of Student Record in database" );
		System.out.println("2. Retrieval of Record from Database as per your Requirement" );
		System.out.println("3. Delete tuple from the table in the Database" );
		System.out.println("4. Update any tuple" );
		int choicee=sc.nextInt();sc.nextLine();
		
		switch(choicee)
		{
		case 1:Student student = new Student();
		
		do {
		session = factory.openSession(); 
		System.out.println("Please Enter Details Name -> Degree -> Rollno -> MobileNo ");
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
		session.flush();
		factory.close();
		
		System.out.println("\t\t Want to Enter more data (y/n)" );
		ch = sc.next();
		sc.nextLine();
		}while(ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("y"));

		System.out.println("Object saved successfully.....!!");break;
		case 2:
			int choice;
			String s; Query qry; List l; Iterator it;
			System.out.println("\t\tSeacrh students" );
			do {
			System.out.println("1. By name" );
			System.out.println("2. By Degree" );
			System.out.println("3. By Roll Number" );
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1: 
			s=sc.nextLine();
			qry = session.createQuery("from Student st where st.name= ?");
			qry.setParameter(0,s);
			l =qry.list();
			System.out.println("Total Number Of Records found : "+l.size());
			it = l.iterator();
			while(it.hasNext())
			 {
			 Object o = (Object) it.next();
			 Student st = (Student)o;
			 System.out.println("Student Name : "+st.getName());
			 System.out.println("Student degree : "+st.getDegree());
			 System.out.println("Student RollNo : "+st.getRoll());
			 System.out.println("Student Phone : "+st.getPhone());
			 System.out.println("---------------------------");
			 
			 }
				break;
			case 2:
			s=sc.nextLine();
			qry = session.createQuery("from Student st where st.degree= ?");
			qry.setParameter(0,s);
			l =qry.list();
			System.out.println("Total Number Of Records found : "+l.size());
			it = l.iterator();
			while(it.hasNext())
			 {
			 Object o = (Object) it.next();
			 Student st = (Student)o;
			 System.out.println("Student Name : "+st.getName());
			 System.out.println("Student degree : "+st.getDegree());
			 System.out.println("Student RollNo : "+st.getRoll());
			 System.out.println("Student Phone : "+st.getPhone());
			 System.out.println("---------------------------");
			 } 
			break;
			case 3: 
			s=sc.nextLine();
			qry = session.createQuery("from Student st where st.roll= ?");
			qry.setParameter(0,s);
			l =qry.list();
			System.out.println("Total Number Of Records found : "+l.size());
			it = l.iterator();
			while(it.hasNext())
			 {
			 Object o = (Object) it.next();
			 Student st = (Student)o;
			 System.out.println("Student Name : "+st.getName());
			 System.out.println("Student degree : "+st.getDegree());
			 System.out.println("Student RollNo : "+st.getRoll());
			 System.out.println("Student Phone : "+st.getPhone());
			 System.out.println("---------------------------");
			 
			 }
			break;
			}
			System.out.println("\t\t Want to Retrieve more ?? (y/n)" );
			ch = sc.next();
			sc.nextLine();
			}while(ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("y"));
			break;
			
		case 3:
			
			qry=session.createQuery("select s from Student s");
			l=qry.list();
			it=l.iterator();
			System.out.println("Here is the Table STUDENT");
			System.out.println("ID\tNAME\t\tDEGREE\t\tROLL\\ttPHONE");
			while(it.hasNext())
			{
				Object o = (Object) it.next();
				Student st = (Student)o;
				System.out.print(st.getId()+"\t");
				System.out.print(st.getName()+"\t\t");
				System.out.print(st.getDegree()+"\t\t");
				System.out.print(st.getRoll()+"\t\t");
				System.out.println(st.getPhone()+"\t");
				
			}
			do {
				System.out.println("tell which row to delete");
				int idChoice=sc.nextInt(); //sc.nextLine();
				Transaction transaction = session.beginTransaction();
				  try{
				
				qry = session.createQuery("delete from Student s where s.id=:id"); 
				qry.setInteger("id",idChoice);
				int res = qry.executeUpdate();
						   
				System.out.println("Command successfully executed....");
				
				System.out.println("Numer of records effected due to delete query"+res);
				transaction.commit();
			}
				  catch(Throwable t)
				  {
					  transaction.rollback();
				  }
				  transaction = session.beginTransaction();
			/*	  try{
						
					  int num=0;
						qry=session.createQuery("UPDATE Student s set s.id=:id=:id1");
						qry.setParameter("id","@"+num+":");
						qry.setParameter("id1","@"+(num+1));
						System.out.println("After update");
						int res = qry.executeUpdate();
								   
						System.out.println("Command successfully executed....");
						transaction.commit();
						System.out.println("Numer of records effected due to delete query"+res);
						
					}
						  catch(Throwable t)
						  {
							  transaction.rollback();
						  }
				  */
	/*			Object o=session.load(Student.class,new Long(idChoice));
		        Student st=(Student)o;
		        Transaction tx = session.beginTransaction();
		        session.delete(st);
		        System.out.println("Object Deleted successfully.....!!");
		        tx.commit();
				*/
		        System.out.println("\t\t Want to delete more ?? (y/n)" );
				ch = sc.next();
				sc.nextLine();
		        
			}while(ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("y"));
			break;
			
		case 4:
			qry=session.createQuery("select s from Student s");
			l=qry.list();
			it=l.iterator();
			System.out.println("Here is the Table STUDENT");
			System.out.println("ID\tNAME\t\tDEGREE\t\tROLL\\ttPHONE");
			while(it.hasNext())
			{
				Object o = (Object) it.next();
				Student st = (Student)o;
				System.out.print(st.getId()+"\t");
				System.out.print(st.getName()+"\t\t");
				System.out.print(st.getDegree()+"\t\t");
				System.out.print(st.getRoll()+"\t\t");
				System.out.println(st.getPhone()+"\t");
				
			}
			do {
			System.out.println("\t\tTell tuple Id which you want to update" );
			int idChoice=sc.nextInt(); //sc.nextLine();
			Transaction transaction = session.beginTransaction();
			System.out.println("\t\twhat you want to update" );
			System.out.println("1. Name" );
			System.out.println("2. Degree" );
			System.out.println("3. Roll Number" );
			choice=sc.nextInt();
			sc.nextLine();
			String sUpdate;
			switch(choice)
			{
			case 1:
				System.out.println("\t\tEnter New Name" );
				sUpdate=sc.nextLine();
				try {
				qry=session.createQuery("UPDATE Student s set s.name=:name where s.id=:id");
				qry.setParameter("name",sUpdate);
				qry.setInteger("id",idChoice);
				int res = qry.executeUpdate();
				   
		        System.out.println("Command successfully executed....");
		        System.out.println("Numer of records effected due to delete query="+res);
				transaction.commit();
				}
				catch(Throwable t)
				  {
					  transaction.rollback();
				  }
			break;
			case 2:
				System.out.println("\t\tEnter New Degree" );
				sUpdate=sc.nextLine();
				try {
				qry=session.createQuery("UPDATE Student s set s.degree=:degree where s.id=:id");
				qry.setParameter("degree",sUpdate);
				qry.setInteger("id",idChoice);
				int res = qry.executeUpdate();
				   
		        System.out.println("Command successfully executed....");
		        System.out.println("Numer of records effected due to delete query="+res);
				transaction.commit();
				}
				catch(Throwable t)
				  {
					  transaction.rollback();
				  }
			break;
			case 3:
				System.out.println("\t\tEnter New Roll number" );
				sUpdate=sc.nextLine();
				try {
				qry=session.createQuery("UPDATE Student s set s.roll=:roll where s.id=:id");
				qry.setParameter("roll",sUpdate);
				qry.setInteger("id",idChoice);
				int res = qry.executeUpdate();
				   
		        System.out.println("Command successfully executed....");
		        System.out.println("Numer of records effected due to delete query="+res);
				transaction.commit();
				}
				catch(Throwable t)
				  {
					  transaction.rollback();
				  }
				break;
			case 4:
				System.out.println("\t\tEnter New Mobile Number" );
				sUpdate=sc.nextLine();
				try {
				qry=session.createQuery("UPDATE Student s set s.phone=:phone where s.id=:id");
				qry.setParameter("phone",sUpdate);
				qry.setInteger("id",idChoice);
				int res = qry.executeUpdate();
				   
		        System.out.println("Command successfully executed....");
		        System.out.println("Numer of records effected due to delete query="+res);
				transaction.commit();
				}
				catch(Throwable t)
				  {
					  transaction.rollback();
				  }
			break;
			}
			
			System.out.println("\t\t Want to update more ?? (y/n)" );
			ch = sc.next();
			sc.nextLine();
		}while(ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("y"));
	
	}
		System.out.println("\t\t Would you do more type of operations ?? (y/n)" );
		ch = sc.next();
		sc.nextLine();
		}while(ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("y"));
	/*	while(it.hasNext())
		 {
		 Object o[] = (Object[])it.next();
		 
		 System.out.println("Student Roll : "+o[0]+ ",\tStudent Name : "+o[1]);
		
		 } */
		 
		
	/*	while(it.hasNext())
		{
			String i = (String)it.next();
			System.out.println(i.toString());
		}	
		*/
		
	/*	Transaction tx=session.beginTransaction();
		session.delete(s);
		System.out.println("Object retrieved Successfully");
		tx.commit();
		*/
		session.close();
		factory.close();
	}
}