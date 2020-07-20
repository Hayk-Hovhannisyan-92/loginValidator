package startProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start {

	Scanner in = new Scanner(System.in);

	public String enterYourEmail() {
		System.out.print("Enter your email  -- ");
		String email = in.nextLine();
		if (email.isEmpty()) {
			System.out.println("email is empty ");
			email = enterYourEmail();
		}
		return email;

	}
	
	String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
	Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);

	public void checkEmailValidation(String email) {
		
		Matcher matcherEmail = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		boolean boolEmail = matcherEmail.matches();

		if (boolEmail) {
		} else {
			System.out.println("your email is invalid ");
			email = enterYourEmail();
			checkEmailValidation(email);
		}
	}

	public String regexPassword = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,12})";
	public Pattern VALID_PASSWORD_REGEX = Pattern.compile(regexPassword);

	public String enterYourPassword() {
		System.out.print("Enter your password -- ");
		String password = in.nextLine();
		if (password.isEmpty()) {
			System.out.println("your password is empty  ");
			password = enterYourPassword();
		} else {
			if (password.length() < 8) {
				System.out.println("Password is too short ");
				password = enterYourPassword();
			} else {
				if (password.length() > 12) {
					System.out.println("Password is too long ");
					password = enterYourPassword();
				}
			}
		}
		return password;
	}

	public void checkPasswordValidation(String password) {
		Matcher matcherPassword = VALID_PASSWORD_REGEX.matcher(password);
		boolean boolPassword = matcherPassword.matches();
		if (boolPassword) {
			System.out.println();
		} else {
			System.out.println("Password  is not strong enough ");
			password = enterYourPassword();
			checkPasswordValidation(password);
		}
	}
}