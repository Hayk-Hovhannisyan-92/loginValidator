package startProject;

import java.util.HashMap;
import java.util.Map;

public class Database {

	Map<String, String> hm = new HashMap<String, String>();
	{
		hm.put("user1@gmail.com", "Password1!");
		hm.put("user2@gmail.com", "Password2!");
		hm.put("user3@gmail.com", "Password3!");
		hm.put("user4@gmail.com", "Password4!");
		hm.put("user5@gmail.com", "Password5!");

	}

	public boolean checkEmailInDatabase(String email) {
		boolean isavailable = hm.containsKey(email);
		if (isavailable) {
			System.out.println();
			return true;
		} else {
			System.out.println("your email is not registered ");
			return false;
		}
	}

	public boolean checkValidLogin(String email, String password) {
		boolean isavailable = hm.containsValue(password);
		if (!isavailable) {
			System.out.println("Your email or password is invalid ");
			return false;
		} else {
			Start start = new Start();
			if (password.equals(hm.get(email))) {
				System.out.println("you have  successfully log in ");
				return true;
			}
			System.out.println("Your email or password is invalid ");
			return false;
		}
	}
}