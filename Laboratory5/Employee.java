package Laboratory5;

public class Employee extends Person {
	double salary;

	public Employee(String lastName, String firstName, int birthyear, String lastAttendedStudies, double salary) {
		super(lastName, firstName, birthyear, lastAttendedStudies);
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", lastName=" + lastName + ", firstName=" + firstName + ", birthyear="
				+ birthyear + ", lastAttendedStudies=" + lastAttendedStudies + "]";
	}
}
