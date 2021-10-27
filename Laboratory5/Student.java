package Laboratory5;

public class Student extends Person {
	int monthsWithoutTaxes;

	public Student(String lastName, String firstName, int birthyear, String lastAttendedStudies,
			int monthsWithoutTaxes) {
		super(lastName, firstName, birthyear, lastAttendedStudies);
		this.monthsWithoutTaxes = monthsWithoutTaxes;
	}

	@Override
	public String toString() {
		return "Student [monthsWithoutTaxes=" + monthsWithoutTaxes + ", lastName=" + lastName + ", firstName="
				+ firstName + ", birthyear=" + birthyear + ", lastAttendedStudies=" + lastAttendedStudies + "]";
	}
}
