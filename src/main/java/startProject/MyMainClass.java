package startProject;

public class MyMainClass {

	public static void main(String[] args) {
		Start start = new Start();
		Database database = new Database();
		boolean isEmailInDB = false;
		boolean isLoginValid = false;
		String email = "";
		String password = "";
		do {
			do {
				email = start.enterYourEmail();
				start.checkEmailValidation(email);
				database.CheckUsernameExists(email);
			} while (!isEmailInDB);

			password = start.enterYourPassword();
			start.checkPasswordValidation(password);
			isLoginValid = database.checkValidLogin(email, password);
		} while (!isLoginValid);
	}
}