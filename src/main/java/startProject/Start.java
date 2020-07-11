package startProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public  final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		//public boolean checkUsernameIsValid(String username) {
			//if (username.find()) {
			//    System.out.println("Correct!");
		//	}
			//Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
		      //  Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(username);
		      //  if(username.)
		  //      return matcher.find();
		}


