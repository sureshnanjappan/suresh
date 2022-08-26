package com.edu.suresh;

import java.util.Scanner;

public class SwitchOperation {

	public static void main(String[] args) {
		int a,b,c;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		char operator;
		System.out.println("enter the operators+,-,*,/or%:");
		operator=sc.next().charAt(0);
		switch (operator) {
		case'+':
		System.out.println(a+b);
		case'-':
		System.out.println(a-b);
		case'*':
		System.out.println(a*b);
			
		
		}
		
		
		
		
			
		
		
		

	}

}
