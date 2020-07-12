package startProject;

public class Main {

	public static void main(String[] args) {
		Start start = new Start();
		Database database = new Database();
		
		start.enterYourEmail();
		start.checkEmailValidation();
		database.checkEmailInDatabase();
		start.enterYourPassword();
		start.checkPasswordValidation();
		database.checkPasswordInDatabase();
		

	   /* Set<Entry<String, String>> st = database.hm.entrySet();

		for (Map.Entry<String, String> me : st) {
			System.out.print(me.getKey() + " - ");
			System.out.println(me.getValue());
		}
		System.out.println();
		database.checkEmailInDatabase();
		database.checkPasswordInDatabase();

	}*/
	}		
}