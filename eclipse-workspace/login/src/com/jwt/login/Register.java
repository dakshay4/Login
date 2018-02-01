package com.jwt.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

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
        Double mobile = Double.parseDouble(mobilee);
        isCorrectEmail o =new isCorrectEmail();
                
   try {
        	out.println("Hi..."+userid);
        if(!(mobilee.length()==10 && o.validate(email))) throw new ArithmeticException ("Invalid Mobile Number or EmailId, go back and try again");
        
      
        boolean flag=false;
         
        try {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select * from REGISTER");
            while(rs.next()) {
        	  if((userid.equals(rs.getString(1))) || (email.equals(rs.getString(2))) || (mobile.equals(rs.getDouble(4)))) {
        		  flag=true;break;
        	  }
        	  else continue;
            }
            if(flag)   throw new ArithmeticException ("Username or EmailId or mobile already exists! Please go back and try again!");
           /*  PreparedStatement ps=con.prepareStatement("Select * from REGISTER");*/
          
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String sql ="INSERT INTO REGISTER(USERID,EMAIL,PASS,MOBILE_NO,PROFILE)"+"VALUES(?,?,?,?,0)";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,userid);
                ps.setString(2,email);
                ps.setString(3,pass);
                ps.setDouble(4,mobile);
                ps.executeUpdate();
                con.close();
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