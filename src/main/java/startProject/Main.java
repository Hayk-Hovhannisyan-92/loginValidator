package startProject;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String []args) {
		Start start = new Start();
		Database database = new Database();
		
		Set<Entry<String, String>> st 
        = database.hm.entrySet(); 

    for (Map.Entry<String, String> me : st) { 
        System.out.print(me.getKey() + " - "); 
        System.out.println(me.getValue()); 
		}
    System.out.println();
    
    start.enterYourUsername();
    boolean isavailable = database.hm.containsKey("user2@gamil.com");
    System.out.println("Is key start.in exists: " + isavailable); 
		    
    
		
		
		
		
		
		
		
		
		
		
		/*Scanner in = new Scanner(System.in); 
		String email = "user@domain.com";
		
		Start start = new Start();
		start.enterYourUsername();
		String username = in.nextLine();	
		//for(int i = 0; i < 2 ; i++) {
		if(!email.matches(start.username)) {
		 start.enterYourPassword();
		}
		
		start.enterYourUsername();
		*/
		
		
		//Scanner in = new Scanner(System.in); 
		//System.out.print("Enter your username --  ");  
        //String username = in.nextLine(); 
        //System.out.println("Write username --  " + username); 
        
	}
	}

