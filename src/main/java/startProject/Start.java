package startProject;

import java.util.Scanner;

public class Start {
	
	public String username;
	public String password;
	
	Scanner in = new Scanner(System.in); 
	
	public void enterYourUsername() {
		System.out.print("Enter your username -- ");
		String username = in.nextLine();	
		
	}
	
	public void enterYourPassword() {
		System.out.print("Enter your password -- ");
		String username = in.nextLine();	
		
	}

}
