package startProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start {

	public String email;
	public String password;

	Scanner in = new Scanner(System.in);

	public String regexEmail = "^[A-Z0-9._%+-]+@[A-Z]+.[A-Z]";
	public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
	Matcher matcherEmail = VALID_EMAIL_ADDRESS_REGEX.matcher("email");
	boolean boolEmail = matcherEmail.matches();

	public void enterYourEmail() {
		System.out.print("Enter your email  -- ");
		email = in.nextLine();

	}

	public void checkEmailValidation() {
		if (email.isEmpty()) {
			System.out.println("email is empty ");
			enterYourEmail();
			checkEmailValidation();
		}
		if (boolEmail) {
			System.out.println();
		}
		System.out.println("your email is invalid ");
		enterYourEmail();
		checkEmailValidation();
	}

	public String regexPassword = "[A-Za-z0-9-_+@%]";
	public Pattern VALID_PASSWORD_REGEX = Pattern.compile(regexPassword);
	Matcher matcherPassword = VALID_PASSWORD_REGEX.matcher("password");
	boolean boolPassword = matcherPassword.matches();

	public void enterYourPassword() {
		System.out.print("Enter your password -- ");
		password = in.nextLine();
	}

	public void checkPasswordValidation() {
		if (password.isEmpty()) {
			System.out.println("your password is empty  ");
			enterYourPassword();
			checkPasswordValidation();
		} else {
			if (password.length() < 8) {
				System.out.println("Password is too short ");
				enterYourPassword();
				checkPasswordValidation();
			} else {
				if (password.length() > 12) {
					System.out.println("Password is too long ");
					enterYourPassword();
					checkPasswordValidation();
				} else {
					if (boolPassword) {
						System.out.println();
					}
					System.out.println("Password  is not strong enough ");
					enterYourPassword();
					checkPasswordValidation();
				}
			}
		}
	}
}
