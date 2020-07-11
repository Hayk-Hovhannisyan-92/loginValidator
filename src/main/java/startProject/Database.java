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

	public void checkUsernameInDatabase() {
		start.enterYourUsername();
		boolean isavailable = hm.containsKey(start.username);
		if (isavailable) {
			start.enterYourPassword();
		} else {
		System.out.println("your username is invalid ");
		checkUsernameInDatabase();
		}
	}
}