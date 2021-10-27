package Laboratory5;

public class Person implements Comparable<Person> {
	String lastName;
	String firstName;
	int birthyear;
	String lastAttendedStudies;

	public Person(String lastName, String firstName, int birthyear, String lastAttendedStudies) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthyear = birthyear;
		this.lastAttendedStudies = lastAttendedStudies;
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", firstName=" + firstName + ", birthyear=" + birthyear
				+ ", lastAttendedStudies=" + lastAttendedStudies + "]";
	}

	@Override
	public int compareTo(Person other) {
		return this.lastName.compareTo(other.lastName);
	}
}
