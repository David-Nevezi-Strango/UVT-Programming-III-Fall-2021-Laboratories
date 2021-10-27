package Laboratory5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * a) Create a class Person:
 * - first name
 * - last name
 * - year of birth
 * - last attended studies
 * b) Create a generic class Pair that has two members: first & second;
 * Create get / set methods, a constructor, a method that displays an object
 * of type Pair and a method used for switching first with second.
 * c) Create a list of pairs of Persons and print it
 * d) Sort the list based on first person last name, and if two "first" persons
 * have the same name, based on the second person last name
 * e) Create a Map<String(last attended studies), List<Person>(list of persons
 * who last studies attended are the key)> and display the map
 * f) Extend Person class with:
 * Employee:
 * - salary
 * Student:
 * - monthsWithoutTaxes
 * g) Create a method that can display a list of Persons, Employees & Students, but
 * can't print a list of pairs of persons
 * h) Modify the pair class for allowing just the creation of Person pairs
 * i) Find the oldest person from the list of pairs
 */

public class Exercise1 {
	public static void main(String args[]) {
		// c) Create a list of pairs of Persons and print it
		List<Pair<Person>> pairsOfPersons = createPairsOfPersonsArrayList();
		System.out.println(pairsOfPersons);

		// d) Sort the list based on first person last name, and if two "first" persons
		// have the same name, based on the second person last name
		Collections.sort(pairsOfPersons);
		System.out.println("\nAfter sorting the list:\n" + pairsOfPersons);

		// e) Create a Map<String, List<Person>> and display the map
		Map<String, List<Person>> map = createMap(pairsOfPersons);
		printMap(map);

		// g) Create a method that can display a list of Persons, Employees & Students,
		// but can't print a list of pairs of persons
		List<Person> persons = createPersonsArrayList();
		List<Employee> employees = createEmployeesArrayList();
		List<Student> students = createStudentsArrayList();

		System.out.println("\nPrint lists: ");
		displayArrayList(persons);
		displayArrayList(employees);
		displayArrayList(students);
		// displayArrayList(pairsOfPersons); <- error
		System.out.print("\n");

		// h) Modify the pair class for allowing just the creation of Person pairs
		// in class Pair, instead of Type, write Type extends Person or
		// modify the class to not be generic and use Person as attributes' type

		// i) Find the oldest person from the list of pairs
		printOldestPersonFromTheListOfPairs(pairsOfPersons);
	}

	private static List<Pair<Person>> createPairsOfPersonsArrayList() {
		List<Pair<Person>> pairsOfPersons = new ArrayList<Pair<Person>>();
		pairsOfPersons.add(new Pair<Person>(new Person("Gregor", "Smith", 1999, "Engineering"),
				new Person("Vlad", "Smith", 2000, "Engineering")));
		pairsOfPersons.add(new Pair<Person>(new Person("Scott", "Larssen", 1973, "Economics"),
				new Person("Viktor", "Morris", 1988, "Chemistry")));
		pairsOfPersons.add(new Pair<Person>(new Person("Scott", "Kars", 1966, "Education"),
				new Person("Raymond", "Kruse", 1967, "Education")));
		pairsOfPersons.add(new Pair<Person>(new Person("Paul", "Straner", 1996, "Art"),
				new Person("Chuck", "Flaton", 1980, "Pharmacy")));
		return pairsOfPersons;
	}

	private static Map<String, List<Person>> createMap(List<Pair<Person>> pairsOfPersons) {
		Map<String, List<Person>> map = new HashMap<String, List<Person>>();
		Set<String> uniqueStudies = getUniqueStudies(pairsOfPersons);
		for (String entry : uniqueStudies) {
			map.put(entry, new ArrayList<Person>());
		}
		for (Pair<Person> pairOfPersons : pairsOfPersons) {
			map.get(pairOfPersons.getFirst().lastAttendedStudies).add(pairOfPersons.getFirst());
			map.get(pairOfPersons.getSecond().lastAttendedStudies).add(pairOfPersons.getSecond());
		}
		return map;
	}

	private static Set<String> getUniqueStudies(List<Pair<Person>> pairsOfPersons) {
		Set<String> uniqueStudies = new HashSet<String>();
		for (Pair<Person> pairOfPersons : pairsOfPersons) {
			uniqueStudies.add(pairOfPersons.getFirst().lastAttendedStudies);
			uniqueStudies.add(pairOfPersons.getSecond().lastAttendedStudies);
		}
		return uniqueStudies;
	}

	private static void printMap(Map<String, List<Person>> map) {
		for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
			System.out.println("\nPersons that last attended: " + "[" + entry.getKey() + "]: ");
			for (Person person : entry.getValue()) {
				System.out.println(person);
			}
		}
	}

	private static List<Person> createPersonsArrayList() {
		List<Person> persons = new ArrayList<Person>(List.of(new Person("Gregor", "Smith", 1999, "Engineering"),
				new Person("Vlad", "Smith", 2000, "Engineering"), new Person("Viktor", "Morris", 1999, "Chemistry")));
		return persons;
	}

	private static List<Employee> createEmployeesArrayList() {
		List<Employee> employees = new ArrayList<Employee>(
				List.of(new Employee("Gregor", "Smith", 1999, "Engineering", 6500),
						new Employee("Vlad", "Smith", 2000, "Engineering", 6400),
						new Employee("Viktor", "Morris", 1999, "Chemistry", 3100)));
		return employees;
	}

	private static List<Student> createStudentsArrayList() {
		List<Student> students = new ArrayList<Student>(
				List.of(new Student("Gregor", "Smith", 1999, "Engineering", 24),
						new Student("Vlad", "Smith", 2000, "Engineering", 0),
						new Student("Viktor", "Morris", 1999, "Chemistry", 36)));
		return students;
	}

	private static void displayArrayList(List<? extends Person> list) {
		System.out.println(list);
	}

	private static void printOldestPersonFromTheListOfPairs(List<Pair<Person>> pairsOfPersons) {
		Person oldestPerson = new Person("?", "?", Integer.MAX_VALUE, "?");
		for (Pair<Person> pairOfPersons : pairsOfPersons) {
			if (pairOfPersons.getFirst().birthyear < oldestPerson.birthyear) {
				oldestPerson = pairOfPersons.getFirst();
			}
			if (pairOfPersons.getSecond().birthyear < oldestPerson.birthyear) {
				oldestPerson = pairOfPersons.getSecond();
			}
		}
		System.out.println("The oldest person is: " + oldestPerson);
	}
}
