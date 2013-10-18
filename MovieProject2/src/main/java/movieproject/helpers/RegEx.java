package movieproject.helpers;

/**
 * 
 * @author hyoung
 * 
 */

public class RegEx {

	/*
	 * Regular expressions for login and registration validation.
	 */
	private static final String EMAILREGEX = "[a-zA-Z0-9_.]{1,25}[\\@][a-zA-Z]{1,20}\\.[a-zA-Z]{2,4}";
	private static final String PASSWORDREGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()~`;:<>]).{8,50})";
	private static final String USERNAMEREGEX = "^[A-Za-z][A-Za-z0-9]{3,49}$";

	/*
	 * Error message String for Regular Expression validation.
	 */
	private String emailError = "Invalid email! Please enter a valid email address (ex. JaneDoe1@mail.com)";
	private String passwordError = "Invalid password! Passwords must have at least one uppercase letter, one lower case letter, one number, one symbol and must be between 8 and 50 characters long.";
	private String userNameError = "Invalid Username! Usernames must start with a letter, be between 4 and 50 characters long and include no special characters.";

	/**
	 * Checks for a bad email by comparing with emailRegEx. Returns error
	 * message if email does not match, otherwise returns null.
	 */
	public String badEmailCheck(String email) {
		if (!(email.matches(EMAILREGEX))) {
			return emailError;
		}
		return null;
	}

	/**
	 * Checks for a bad password by comparing with passwordRegEx. Returns error
	 * message if password does not match, otherwise returns null.
	 */
	public String badPasswordCheck(String password) {
		if (!(password.matches(PASSWORDREGEX))) {
			return passwordError;
		}
		return null;
	}

	/**
	 * Checks for a bad Username by comparing with UserNameRegEx. Returns error
	 * message if Username does not match, otherwise returns null.
	 */
	public String badUserNameCheck(String userName) {
		if (!(userName.matches(USERNAMEREGEX))) {
			return userNameError;
		}
		return null;
	}

}