package Laboratory6;

public class StudentException extends Exception {
	public StudentException(String e) {
		super(e);
	}

	static String INVALID_GRADE = "The grade is not in the [0, 12] interval!";
	static String INVALID_MARK = "Some marks are not in the [1, 10] interval!";
}
