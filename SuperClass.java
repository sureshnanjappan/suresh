package com.edu.suresh;

public class SuperClass {

	public static void main(String[] args) {
		
	
		class SingletoneClass{
		public static SingletoneClass sob;
		    private SingletoneClass(){
		       System.out.println("Constructor of Singletoneclass");
		   }
		  public static SingletoneClass getSingletoneClassObject(){
			  sob=new SingletoneClass(); //calls constructor
		      return sob;
		  }

		public void display(){
		 System.out.println("Display");
		}
		}

		class MainClassSingletoneClass{
		    public static void main(String args[]){
		         // SingletoneClass ob=new SingletoneClass(); //error because private constr
		          SingletoneClass ob=SingletoneClass.getSingletoneClassObject();
		              ob.display(); 
		   }
		}

	}

}
