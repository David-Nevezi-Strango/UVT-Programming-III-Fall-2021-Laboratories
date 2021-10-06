package Laboratory2;

import java.util.Arrays;

/*
 * Create Actor class:
 * private - firstName
 *         - lastName
 * package - birthyear
 * public  - school
 * 
 * If an actor didn't attend a school, school attribute should be set on "WITHOUT SCHOOL".
 * 
 * a) Add 3 constructors for Actor class
 * b) Override toString() method
 * c) Create set / get methods for the private fields
 * d) Create an Actor array and display it
 * e) Count how many actors didn't attend a school
 * f) Display the name of the actors whose first or last name starts with a prefix received
 * as a command line argument
 * g) Add comments for Actor and Exercise1 class and generate javadoc for them
 * 
 * Lecture: How to Write Doc Comments for the Javadoc Tool
 * https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html
 */

/**
 * The Exercise1 class used for solving Laboratory 2 first exercise
 * 
 * @author Damian-Teodor Beles
 */
public class Exercise1 {
	/**
	 * The main method used as the program entry point
	 * 
	 * @param args command line arguments
	 */
	public static void main(String args[]) {
		// d) Create an Actor array and display it
		Actor[] actors = createActorsArray();

		System.out.println(Arrays.toString(actors));

		// e) Count how many actors didn't attend a school
		System.out.println("Number of actors without school: " + countActorsWithoutSchool(actors));

		/*
		 * f) Display the name of the actors whose first or last name starts with a
		 * prefix received as a command line argument
		 */
		System.out.println("Actors whose first or last name starts with " + args[0] + ": ");
		displayActorsWhoseNameStartsWith(actors, args[0]);
	}

	/**
	 * This method creates an array of actors
	 * 
	 * @return Actor array
	 */
	private static Actor[] createActorsArray() {
		Actor[] actors = new Actor[3];
		actors[0] = new Actor();
		actors[0].setFirstName("Mark");
		actors[0].setLastName("Sinclair");
		actors[0].birthyear = 1967;
		actors[0].school = "Hunter College";

		actors[1] = new Actor("Jason", "Statham", 1967);

		actors[2] = new Actor("Dwayne", "Johnson", 1972, "University of Miami");
		return actors;
	}

	/**
	 * This method counts how many actors didn't attend a school
	 * 
	 * @param actors Actor array
	 * @return The number of actors without a school
	 */
	private static int countActorsWithoutSchool(Actor[] actors) {
		int result = 0;
		for (Actor actor : actors) {
			if (actor.school.equals("WITHOUT SCHOOL")) {
				result++;
			}
		}
		return result;
	}

	/**
	 * This method displays the name of the actors whose first or last name starts
	 * with a prefix
	 * 
	 * @param actors     Actor array
	 * @param namePrefix The prefix that actors first name should start with
	 */
	private static void displayActorsWhoseNameStartsWith(Actor[] actors, String namePrefix) {
		for (Actor actor : actors) {
			if (actor.getFirstName().startsWith(namePrefix) || actor.getLastName().startsWith(namePrefix)) {
				System.out.println(actor.getFirstName() + " " + actor.getLastName());
			}
		}
	}
}
