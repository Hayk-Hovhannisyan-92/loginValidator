package am.itu.loginValidator.run;

import am.itu.loginValidator.db.Database;
import am.itu.loginValidator.util.ValidatorUtil;

public class RunLoginValidator {

	public static void main(String[] args) {
		ValidatorUtil start = new ValidatorUtil();
		Database database = new Database();
		boolean isEmailValid = false;
		boolean isLoginValid = true;
		boolean isPasswordValid = false;
		String email = "";
		String password = "";
		do {
			email = start.enterYourEmail();
			start.checkEmailValidation(email);

			password = start.enterYourPassword();
			start.checkPasswordValidation(password);
			
			isLoginValid = database.isLoginValid(email, password);
			if(!isLoginValid) {
				System.out.println("Your username or password is invalid.");
			}
		} while (!isLoginValid);

		System.out.println("You have successfully logged in");
	}
}