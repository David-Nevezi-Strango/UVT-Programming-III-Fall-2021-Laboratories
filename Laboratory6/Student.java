package Laboratory6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
	String name;
	int grade;
	Map<String, List<Integer>> marks;

	public Student(String name, int grade, Map<String, List<Integer>> marks) throws StudentException {
		this.name = name;

		boolean gradeIsIn0To12Interval = 0 <= grade && grade <= 12;
		if (gradeIsIn0To12Interval) {
			this.grade = grade;
		} else {
			throw new StudentException(StudentException.INVALID_GRADE);
		}

		boolean allGradesAreIn1To10Interval = marks.values().stream().flatMap(marksList -> marksList.stream())
				.allMatch(mark -> (1 <= mark && mark <= 10));
		if (allGradesAreIn1To10Interval) {
			this.marks = marks;
		} else {
			throw new StudentException(StudentException.INVALID_MARK);
		}
	}

	public double getAverageForSubject(String subject) {
		double average = 0.0;
		if (marks.containsKey(subject)) {
			average = marks.get(subject).stream().mapToDouble(mark -> mark).average().getAsDouble();
		}
		return average;
	}

	public double getGPA() {
		return marks.values().stream()
				.map(marksList -> marksList.stream().mapToDouble(mark -> mark).average().getAsDouble())
				.mapToDouble(average -> average).average().getAsDouble();
	}

	public void addMark(String subject, int mark) throws StudentException {
		if (!(1 <= mark && mark <= 10)) {
			throw new StudentException(StudentException.INVALID_MARK);
		} else {
			if (!marks.containsKey(subject)) {
				marks.put(subject, new ArrayList<Integer>());
			}
			marks.get(subject).add(mark);
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", marks=" + marks + ", GPA=" + this.getGPA() + "]";
	}
}
