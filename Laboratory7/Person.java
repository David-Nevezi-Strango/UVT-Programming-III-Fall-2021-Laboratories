package Laboratory7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Person {
	String email;
	String name;
	List<String> abilities;

	public Person(String email, String name, List<String> abilities) throws PersonException {
		super();

		if (Pattern.matches("^(.+)@(.+)$", email)) {
			this.email = email;
		} else {
			throw new PersonException(PersonException.INVALID_EMAIL);
		}

		this.name = name;
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "\nPerson [email=" + email + ", name=" + name + ", abilities=" + abilities + "]\n";
	}
}
