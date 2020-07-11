package startProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start {

	public String email;
	public String password;

	Scanner in = new Scanner(System.in);

	public void enterYourEmail() {
		System.out.print("Enter your email  -- ");
		email = in.nextLine();

	}

	public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z]+\\.[A-Z]",
			Pattern.CASE_INSENSITIVE);

	public boolean checkEmailRegex() {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(password).find();
	}

	public void checkEmailIsValid() {
		if (email.isEmpty()) {
			System.out.println("email is empty ");
			enterYourEmail();
			checkEmailIsValid();
		}
		if (checkEmailRegex()) {
			System.out.println("Correct!");
		} else {
			System.out.println("your email is invalid ");
			enterYourEmail();
			checkEmailIsValid();
		}
	}

	public final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^[A-Za-z0-9._%+-]");

	public void enterYourPassword() {
		System.out.print("Enter your password -- ");
		password = in.nextLine();
	}

	/*
	char[] pass = new char[0];

	public void dividePassword() {
		while (password != null) {
			for (int i = 0; i < pass.length; i++) {
				pass[i] = password.charAt(0);
				password = password.substring(1);
			}
		}
	}
		*/


	public boolean checkCharSequencePassword() {
		return VALID_PASSWORD_REGEX.matcher(password).find();
	}

	public void checkPasswordIsValid() {
		if (password.isEmpty()) {
			System.out.println("your password is empty  ");
			enterYourPassword();
			checkPasswordIsValid();
		} else
			//dividePassword();

		if (password.length() < 8) {
			System.out.println("Password is too short ");
			enterYourPassword();
			checkPasswordIsValid();
		} else {
			if (password.length() > 12) {
				System.out.println("Password is too long ");
				enterYourPassword();
				checkPasswordIsValid();
			} else {
				if (!checkCharSequencePassword()) {
					System.out.println("Password  is not strong enough ");
					enterYourPassword();
					checkPasswordIsValid();
				}
				System.out.println("Correct!");
			}
		}
	}
}
