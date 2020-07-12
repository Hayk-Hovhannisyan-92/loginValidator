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

	public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z]+.[A-Z]",
			Pattern.CASE_INSENSITIVE);
	Matcher matcherEmail = VALID_EMAIL_ADDRESS_REGEX.matcher("start.email");
	boolean boolEmail = matcherEmail.matches();

	public void checkEmailValidation() {
		if (email.isEmpty()) {
			System.out.println("email is empty ");
			enterYourEmail();
			checkEmailValidation();
		}
		if (boolEmail) {
			System.out.println();
		} else {
			System.out.println("your email is invalid ");
			enterYourEmail();
			checkEmailValidation();
		}
	}

	public final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^[A-Z]+[0-9]+[a-z]+[.@$%+_]");
	Matcher matcherPassword = VALID_PASSWORD_REGEX.matcher("start.password");
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
		} else {if (password.length() < 8) {
			System.out.println("Password is too short ");
			enterYourPassword();
			checkPasswordValidation();
		} else {
			if (password.length() > 12) {
				System.out.println("Password is too long ");
				enterYourPassword();
				checkPasswordValidation();
			} else {
				if (!boolPassword) {
					System.out.println("Password  is not strong enough ");
					enterYourPassword();
					checkPasswordValidation();
				} else {
					System.out.println();
				}
			}
		}
	}
}
}
