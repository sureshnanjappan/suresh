package project;

import java.sql.SQLException;
import java.util.Scanner;

public class ProjectMainOperation {

	public static void main(String[] args) throws SQLException {
		
	Scanner sc=new Scanner (System.in);
	System.out.println("****welcome****");
	System.out.println("home page");
	
	System.out.println("are you admin or student?");
	while (true) {
	System.out.println("1.ADMIN");
	System.out.println("2.STUDENT");
	int n=sc.nextInt();
	switch(n) {
	case 1:
		
		System.out.println("enter admin username");
		String un=sc.next();
		System.out.println("enter admin password");
		String up=sc.next();
		
		
		
		if(un.equals("suresh")&&up.equals("suresh@123")) {
			while (true) {
			
			
			System.out.println("choose the action you want to do");
			System.out.println("1.display records");
			System.out.println("2.insert record");
			System.out.println("3.update record");
			System.out.println("4.delete record");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("displaying record");
				ProjectJdbcOperation.displayStudents();
				break;
			case 2:
				System.out.println("insert record");
				ProjectJdbcOperation.insertStudents();
				break;
			case 3:
				System.out.println("update record");
				System.out.println("which one you have to update");
				System.out.println("1.update student name");
				System.out.println("2.update student email");
				System.out.println("3.update student phone number");
				System.out.println("4.update student course");
				 
				int upchoice=sc.nextInt();
				switch(upchoice) {
				case 1:
					System.out.println("update student");
					ProjectJdbcOperation.updateStudentsname();
					break;
				case 2:
					System.out.println("update email");
					ProjectJdbcOperation.updateStudentsemail();
					break;
				case 3:
					System.out.println("update phone number");
					ProjectJdbcOperation.updateStudentsphonenumber();
					break;
				case 4:
					System.out.println("update course");
					ProjectJdbcOperation.updateStudentscourse();
					break;
				default:
					System.out.println("invalid input");
					
					
					
					
				}
				
				break;
			case 4:
				System.out.println("delete record");
				ProjectJdbcOperation.deleteStudents();
				break;
			default:
				System.out.println("invalid input");
			}//switch
			System.out.println("do you want to continue y/n");
			char ch=sc.next().charAt(0);
			if(ch=='n'|| ch=='N')
				break;
					
			
			}	//while(true)
		}	
		
			
			
			
			
			
			
		else {
			System.out.println("incorrect username or password");
			
		}
				
		
		System.out.println("you are terminated");
		break;
		
	case 2:
		
		System.out.println("you are in student portal");
		System.out.println("enter user name");
		String un1=sc.next();
		System.out.println("enter password");
		String up1=sc.next();
		if(un1.equals("student")&&up1.equals("student@123")) {
			while(true) {
			System.out.println("choose the action you want to do");
			System.out.println("1.display your record");
			System.out.println("2.insert record");
			System.out.println("3.update record");
			int choice2=sc.nextInt();
			switch(choice2) {
			case 1:
				System.out.println("displaying your record");
				ProjectJdbcOperation.displayStudentsUnique();
				break;
				
			case 2:
				System.out.println("insert your record");
				ProjectJdbcOperation.insertStudents();
				break;
			case 3:
				System.out.println("select the option to update");
				System.out.println("1.update phone number");
				System.out.println("2.update email");
				int upchoice1=sc.nextInt();
				
				switch (upchoice1) {
				case 1:
					System.out.println("update phone number");
					ProjectJdbcOperation.updateStudentsphonenumber();
					break;
				case 2:
					System.out.println("update email");
					ProjectJdbcOperation.updateStudentsemail();
					break;
				default:
				
					System.out.println("invalid input");
					
				}
			default:
					System.out.println("invalid input");
			}
			
			System.out.println("do you want to continue y/n");
			char ch=sc.next().charAt(0);
			if(ch=='n'|| ch=='N')
				break;
			}
			
		}
		else {
			System.out.println("incorrect username or password");
		}
		System.out.println("you are terminated");
	
		
		
		break;
		
		default:
		System.out.println("invalid input");
		
		
	}//switch
	System.out.println("do you to return to home page y/n");
	char ch=sc.next().charAt(0);
	if(ch=='n'|| ch=='N')
		break;
	

	
	

	}
	System.out.println("you are terminated");
	
}
}
