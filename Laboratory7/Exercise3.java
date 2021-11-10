package Laboratory7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Given a file that contains on each line:
 * email address, name, abilities list:
 * 
 * a) Create a data structure for storing the file contents
 * b) Read the files from the file
 * c) Validate the email when reading from the file
 * d) Print the unique abilities from file and for each a list of
 * persons having the respective ability
 * 
 * Lecture: Learn more about regular expressions.
 * https://regexr.com/
 */

public class Exercise3 {
	public static void main(String args[]) {
		File file = new File("exercise3.txt");

		// b) Read the files from the file
		List<Person> persons = getPersonsFromFile(file);
		System.out.println(persons + "\n");

		// d) Print the unique abilities from file and for each
		// a list of persons having the respective ability
		displayUniqueAbilitiesMap(persons);
	}

	private static List<Person> getPersonsFromFile(File file) {
		List<Person> persons = new ArrayList<Person>();

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				Person currentPerson = scanPerson(line);
				if (currentPerson != null) {
					persons.add(currentPerson);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return persons;
	}

	private static Person scanPerson(String line) {
		Scanner personScanner = new Scanner(line);
		personScanner.useDelimiter(";");
		String personEmail = personScanner.next();
		String personName = personScanner.next();
		List<String> personAbilities = new ArrayList<String>();
		while (personScanner.hasNext()) {
			personAbilities.add(personScanner.next());
		}
		personScanner.close();

		try {
			return new Person(personEmail, personName, personAbilities);
		} catch (PersonException e) {
			return null;
		}
	}

	private static void displayUniqueAbilitiesMap(List<Person> persons) {
		Set<String> uniqueAbilities = new HashSet<String>();
		persons.stream().flatMap(person -> person.abilities.stream()).forEach(ability -> uniqueAbilities.add(ability));

		uniqueAbilities.stream().forEach(ability -> displayPersonsWithAbility(persons, ability));
	}

	private static void displayPersonsWithAbility(List<Person> persons, String ability) {
		System.out.println("Persons with [" + ability + "] are: "
				+ persons.stream().filter(person -> person.abilities.contains(ability))
						.map(personWithAbility -> personWithAbility.email)
						.collect(Collectors.toCollection(ArrayList::new)));
	}
}
