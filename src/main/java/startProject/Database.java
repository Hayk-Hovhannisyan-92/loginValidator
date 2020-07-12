package startProject;

import java.util.HashMap;
import java.util.Map;

public class Database {
	Start start = new Start();

	Map<String, String> hm = new HashMap<String, String>();
	{
		hm.put("user1@gmail.com", "password_1");
		hm.put("user2@gmail.com", "password_2");
		hm.put("user3@gmail.com", "password_3");
		hm.put("user4@gmail.com", "password_4");
		hm.put("user5@gmail.com", "password_5");

	}

	public void checkEmailInDatabase() {
		boolean isavailable = hm.containsKey(start.email);
		if (isavailable) {
			System.out.println();
		} else {
			System.out.println("your email is not registered ");
			start.enterYourEmail();
			start.checkEmailValidation();
			checkEmailInDatabase();
		}
	}

	public void checkPasswordInDatabase() {
		boolean isavailable = hm.containsValue(start.password);
		if (!isavailable) {
			System.out.println("Your email or password is invalid ");
			start.enterYourEmail();
			start.checkEmailValidation();
			checkEmailInDatabase();
			start.enterYourPassword();
			start.checkPasswordValidation();
			checkPasswordInDatabase();
		} else {
			if (start.password.equals(hm.get(start.email))) {
				System.out.println("you have  successfully log in ");
			}
			System.out.println("Your email or password is invalid ");
			start.enterYourEmail();
			start.checkEmailValidation();
			checkEmailInDatabase();
			start.enterYourPassword();
			start.checkPasswordValidation();
			checkPasswordInDatabase();
		}
	}
}