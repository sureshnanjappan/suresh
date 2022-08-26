package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project.ProjectConnection;

public class ProjectJdbcOperation {
	private static Connection myconn; 
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement pst=null;
	
	public static void displayStudents() throws SQLException {
		myconn=ProjectConnection.getConnection();
		st=myconn.createStatement();
		String sel="select * from students";
		rs=st.executeQuery(sel);
		
		System.out.println("sid\tsname\tph_no\tsemail\tcourse");
		  
		  while(rs.next()) {
			  int sid=rs.getInt(1);// or rs.getInt("sid");
			  String sname=rs.getString(2); //or rs.getString("sname");
			  String ph_no=rs.getString(3);
			  String semail=rs.getString(4);//rs.getFloat("fees");
			  String course=rs.getString(5);
			  System.out.println(sid+"\t"+sname+"\t"+ph_no+"\t" +semail+"\t"+course);
		  }
	}
	public static void insertStudents() throws SQLException {
		int sid;
		String sname,ph_no,semail,course;
		

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter student id");
		sid=sc.nextInt();
		System.out.println("Enter Student name");
		sname=sc.next();
		System.out.println("Enter student phone number");
		ph_no=sc.next();
		System.out.println("Enter student email");
		semail=sc.next();
		System.out.println("enter the course name");
		course=sc.next();
				
		try {
			//load the driver at run time, register 
			myconn =ProjectConnection.getConnection(); //create the connection
			
			
			String s="insert into students values(?,?,?,?,?)";
			//String s1="insert into student values
			pst=myconn.prepareStatement(s);
			pst.setInt(1, sid);
			pst.setString(2, sname);
			pst.setString(3, ph_no);
			pst.setString(4, semail);
			pst.setString(5, course);
			
			int rv=pst.executeUpdate();
			if(rv>0) {
				System.out.println("Record is inserted");
			}
			else {
				System.out.println("Not inserted");
			}
			
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
		public static void updateStudentscourse() throws SQLException {
			try {
				
				myconn =ProjectConnection.getConnection();
			}catch(Exception e) {
				e.printStackTrace();
			}
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter student id to check");
	int sid=sc.nextInt();

	
	

	
	
	//check for student existence
	String sel="select * from students where sid=?";
	pst=myconn.prepareStatement(sel);
	
	pst.setInt(1, sid);
	rs=pst.executeQuery();
	if(rs.next()) {
		//if record exists then go for update
		System.out.println("enter course to change");
		String course=sc.next();
		String upd="update students set course=? where sid=?";
		pst=myconn.prepareStatement(upd);
		
		
		
		pst.setString(1,course);
		pst.setInt(2, sid);
		
		int rv=pst.executeUpdate();
		if(rv>0) {
			System.out.println("record is changed successfully");
		}else {
			System.out.println("ERRROR||||||");
		}
		
	}
	else {
		System.out.println(sid+" not exists");
	}
		
	}
		public static void updateStudentsemail() throws SQLException {
			try {
				
				myconn =ProjectConnection.getConnection();
			}catch(Exception e) {
				e.printStackTrace();
			}
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter student id to check");
	int sid=sc.nextInt();
		
	String sel="select * from students where sid=?";
	pst=myconn.prepareStatement(sel);
	
	pst.setInt(1, sid);
	rs=pst.executeQuery();
	if(rs.next()) {
		//if record exists then go for update
		System.out.println("Enter email to change");
		String semail=sc.next();
		String upd="update students set semail=? where sid=?";
		pst=myconn.prepareStatement(upd);
		
		
		pst.setString(1,semail);
		pst.setInt(2, sid);
		
		int rv=pst.executeUpdate();
		if(rv>0) {
			System.out.println("record is changed successfully");
		}else {
			System.out.println("ERRROR||||||");
		}
		
	}
	else {
		System.out.println(sid+" not exists");
	}
		
		}
		public static void updateStudentsphonenumber() throws SQLException {
			try {
				
				myconn =ProjectConnection.getConnection();
			}catch(Exception e) {
				e.printStackTrace();
			}
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter student id to check");
	int sid=sc.nextInt();
	
	String sel="select * from students where sid=?";
	pst=myconn.prepareStatement(sel);
	
	pst.setInt(1, sid);
	rs=pst.executeQuery();
	if(rs.next()) {
		//if record exists then go for update
		System.out.println("Enter phone number to change");
		String ph_no=sc.next();
		String upd="update students set ph_no=?,semail=? where sid=?";
		pst=myconn.prepareStatement(upd);
		
		pst.setString(1, ph_no);
		pst.setInt(2, sid);
		
		int rv=pst.executeUpdate();
		if(rv>0) {
			System.out.println("record is changed successfully");
		}else {
			System.out.println("ERRROR||||||");
		}
		
	}
	else {
		System.out.println(sid+" not exists");
	}
	
		
		
		
		}
		
		public static void updateStudentsname() throws SQLException { 
			try {
			
			myconn =ProjectConnection.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter student id to check");
			int sid=sc.nextInt();
			
			
			String sel="select * from students where sid=?";
			pst=myconn.prepareStatement(sel);
			
			pst.setInt(1, sid);
			rs=pst.executeQuery();
			if(rs.next()) {
				//if record exists then go for update
				System.out.println("Enter name to change");
				String sname=sc.next();
				String upd="update students set sname=? where sid=?";
				pst=myconn.prepareStatement(upd);
				pst.setString(1, sname);
				pst.setInt(2, sid);
				
				int rv=pst.executeUpdate();
				if(rv>0) {
					System.out.println("record is changed successfully");
				}else {
					System.out.println("ERRROR||||||");
				}
				
			}
			else {
				System.out.println(sid+" not exists");
			}
			
		}
		
		public static void deleteStudents() throws SQLException {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter student id to delete record");
			int sid=sc.nextInt();
			try {
				
				myconn =ProjectConnection.getConnection();
				String sel="select * from students where sid=?";
				pst=myconn.prepareStatement(sel);
				pst.setInt(1, sid);
				rs=pst.executeQuery();
				if(rs.next()) {
				
				String del="delete from students where sid=?";
				pst=myconn.prepareStatement(del);
				pst.setInt(1, sid);
				int rv=pst.executeUpdate();
				
				if(rv>0) {
					System.out.println("Record is deleted");
				}else {
					System.out.println("ERROR!!!!!");
				}
				}else {
					System.out.println("Student id "+sid+" not exists");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		public static void displayStudentsUnique() throws SQLException {
			int sid;
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter sid to display records");
		sid=sc.nextInt();
			myconn=ProjectConnection.getConnection();
			st=myconn.createStatement();
			String sel="select * from students where sid="+sid;
			rs=st.executeQuery(sel);
			
			
			  
			  if(rs.next()) {
				  System.out.println("sid\tsname\tph_no\tsemail\tcourse");
				  sid=rs.getInt(1);// or rs.getInt("sid");
				  String sname=rs.getString(2); //or rs.getString("sname");
				  String ph_no=rs.getString(3);
				  String semail=rs.getString(4);//rs.getFloat("fees");
				  String course=rs.getString(5);
				  System.out.println(sid+"\t"+sname+"\t"+ph_no+"\t" +semail+"\t"+course);
			  }
			  else {
				  System.out.println("student doesn't exist");
				  
				 
			  }
			  
		}
}
