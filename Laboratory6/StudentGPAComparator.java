package Laboratory6;

import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {
	public int compare(Student first, Student second) {
		if (first.getGPA() < second.getGPA()) {
			return -1;
		} else if (first.getGPA() == second.getGPA()) {
			return 0;
		} else {
			return 1;
		}
	}
}
