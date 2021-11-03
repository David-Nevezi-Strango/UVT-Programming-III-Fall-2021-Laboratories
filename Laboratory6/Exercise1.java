package Laboratory6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Create Student class:
 * - name
 * - grade (between 0 and 12)
 * - dictionary:
 *  - key: subject
 *  - value: list of marks (between 1 and 10)
 *  
 * a) Implement an exception class
 * b) Verify the values stored in the fields that have restrictions
 * c) Create a Student list and display it
 * d) Add methods to Student class for computing the average of the marks
 * for a given subject, the gpa and for adding a mark
 * e) Sort the students list based on the gpa
 * f) For a given subject display all the students with a passing grade (> 5)
 * g) For each grade display the student with: highest/lowest gpa
 * h) Find the student with the most attended subjects
 * i) For each grade display the students list
 * j) For each grade display the first 3 students based on their gpa
 * k) For a given subject display a report: mark - number of students with that mark
 */

public class Exercise1 {
	public static void main(String args[]) {
		// c) Create a Student list and display it
		List<Student> students = new ArrayList<Student>();
		try {
			students = createStudentsArrayList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		students.forEach(System.out::println);

		// e) Sort the students list based on the gpa
		students.sort(studentGPAComparator);
		System.out.println("\nStudents after ordering based on GPA:");
		students.forEach(System.out::println);

		// f) For a given subject display all the students with a passing grade (> 5)
		String subject = "cs";
		System.out.println("\nStudents with passing grade for [" + subject + "]:");
		displayStudentsWithPassingGradeForSubject(students, subject);

		// g) For each grade display the student with: highest/lowest gpa
		System.out.println("\nHighest/Lowest GPA for each grade:");
		displayStudentsWithHighestOrLowestGPAForEachGrade(students);

		// h) Find the student with the most attended subjects and display it
		System.out.println("\nThe student with the most attended subjects:");
		displayTheStudentWithTheMostAttendedSubjects(students);

		// i) For each grade display the students list
		System.out.println("\nStudents lists per grade:");
		displayStudentsListPerGrade(students);

		// j) For each grade display the first 3 students based on their gpa
		System.out.println("\nTop 3 students per grade:");
		displayTop3StudentsPerGrade(students);

		// k) For a given subject display a report: mark - number of students with that
		// mark
		System.out.println("\nThe marks report for [" + subject + "]:");
		displayMarksReportForSubject(students, subject);
	}

	private static void displayMarksReportForSubject(List<Student> students, String subject) {
		for (int mark = 1; mark <= 10; ++mark) {
			final int thisMark = mark;
			long numberOfStudentsWithThisMark = students.stream()
					.filter(student -> hasMarkOnSubject(student, thisMark, subject)).count();
			System.out.println(mark + " - " + numberOfStudentsWithThisMark);
		}
	}

	private static boolean hasMarkOnSubject(Student student, int mark, String subject) {
		if (!student.marks.containsKey(subject)) {
			return false;
		} else return student.marks.get(subject).contains(mark);
	}

	private static void displayTop3StudentsPerGrade(List<Student> students) {
		Set<Integer> grades = new HashSet<Integer>();
		for (Student student : students) {
			grades.add(student.grade);
		}
		for (Integer grade : grades) {
			ArrayList<Student> studentsInThisGrade = students.stream().filter(student -> student.grade == grade)
					.collect(Collectors.toCollection(ArrayList::new));
			studentsInThisGrade.sort(studentGPAComparator);
			System.out.println(studentsInThisGrade.subList(Math.max(0, studentsInThisGrade.size() - 3),
					studentsInThisGrade.size()));
		}
	}

	private static void displayStudentsListPerGrade(List<Student> students) {
		Set<Integer> grades = new HashSet<Integer>();
		for (Student student : students) {
			grades.add(student.grade);
		}
		for (Integer grade : grades) {
			System.out.println("[Grade " + grade + "]"
					+ students.stream().filter(student -> student.grade == grade).collect(Collectors.toList()));
		}
	}

	private static StudentGPAComparator studentGPAComparator = new StudentGPAComparator();

	private static void displayTheStudentWithTheMostAttendedSubjects(List<Student> students) {
		System.out.println(students.stream().max(Comparator.comparing(student -> student.marks.size())).get());
	}

	private static void displayStudentsWithHighestOrLowestGPAForEachGrade(List<Student> students) {
		Set<Integer> grades = new HashSet<Integer>();
		for (Student student : students) {
			grades.add(student.grade);
		}
		for (Integer grade : grades) {
			Student lowestGPA = students.stream().filter(student -> student.grade == grade).min(studentGPAComparator)
					.get();
			Student highestGPA = students.stream().filter(student -> student.grade == grade).max(studentGPAComparator)
					.get();
			System.out.println(
					"[Grade " + grade + "]\n[Lowest GPA " + lowestGPA + "]\n[Highest GPA " + highestGPA + "]\n");
		}
	}

	private static void displayStudentsWithPassingGradeForSubject(List<Student> students, String subject) {
		students.stream().filter(student -> student.getAverageForSubject(subject) >= 5.0)
				.forEach(student -> System.out.println(student));
	}

	private static List<Student> createStudentsArrayList() throws StudentException {
		return new ArrayList<Student>(List.of(new Student("George", 11, new HashMap<String, List<Integer>>() {
			{
				put("maths", new ArrayList<Integer>(List.of(8, 10, 6)));
				put("cs", new ArrayList<Integer>(List.of(10, 10, 10, 10)));
				put("english", new ArrayList<Integer>(List.of(8, 9, 8, 8)));
				put("biology", new ArrayList<Integer>(List.of(7, 6, 6, 5, 8)));
				put("chemistry", new ArrayList<Integer>(List.of(6, 7, 8, 8, 8)));
			}
		}), new Student("Vlad", 12, new HashMap<String, List<Integer>>() {
			{
				put("maths", new ArrayList<Integer>(List.of(6, 5, 8)));
				put("cs", new ArrayList<Integer>(List.of(2, 3, 5)));
				put("english", new ArrayList<Integer>(List.of(5, 6, 3, 8)));
				put("biology", new ArrayList<Integer>(List.of(1, 1, 3, 4, 7)));
			}
		}), new Student("Joe", 12, new HashMap<String, List<Integer>>() {
			{
				put("cs", new ArrayList<Integer>(List.of(1, 1, 1)));
			}
		}), new Student("Masha", 12, new HashMap<String, List<Integer>>() {
			{
				put("cs", new ArrayList<Integer>(List.of(1, 3, 2)));
			}
		}), new Student("Gregor", 12, new HashMap<String, List<Integer>>() {
			{
				put("maths", new ArrayList<Integer>(List.of(6, 5, 8)));
				put("cs", new ArrayList<Integer>(List.of(1, 1, 4)));
				put("english", new ArrayList<Integer>(List.of(8, 6, 3, 8)));
				put("biology", new ArrayList<Integer>(List.of(10, 10, 8, 8, 6)));
			}
		})));
	}
}
