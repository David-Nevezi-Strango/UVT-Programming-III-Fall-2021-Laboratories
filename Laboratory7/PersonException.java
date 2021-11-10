package Laboratory7;

public class PersonException extends Exception {
	public PersonException(String e) {
		super(e);
	}

	static String INVALID_EMAIL = "The email is in an invalid format!";
}
