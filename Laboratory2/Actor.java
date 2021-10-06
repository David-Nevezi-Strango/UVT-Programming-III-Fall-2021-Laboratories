package Laboratory2;

/**
 * The Actor class used for solving Laboratory 2 first exercise
 * 
 * @author Damian-Teodor Beles
 */
public class Actor {
	/**
	 * Actor's first name
	 */
	private String firstName;
	/**
	 * Actor's last name
	 */
	private String lastName;
	/**
	 * Actor's birthyear
	 */
	int birthyear;
	/**
	 * The school that the actor attended
	 */
	public String school;

	// a) Add 3 constructors for Actor class
	/**
	 * The no-arg constructor of the Actor class. After using this constructor, one
	 * should use the getters / setters for manipulating attributes.
	 */
	Actor() {
		this.birthyear = -1;
		this.school = "WITHOUT SCHOOL";
	}

	/**
	 * The constructor used for initializing an actor with first name, last name and
	 * birthyear
	 * 
	 * @param firstName Actor's first name
	 * @param lastName  Actor's last name
	 * @param birthyear Actor's birthyear
	 */
	Actor(String firstName, String lastName, int birthyear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthyear = birthyear;
		this.school = "WITHOUT SCHOOL";
	}

	/**
	 * The constructor used for initializing an actor with first name, last name,
	 * birthyear and school
	 * 
	 * @param firstName Actor's first name
	 * @param lastName  Actor's last name
	 * @param birthyear Actor's birthyear
	 * @param school    The school that the actor attended
	 */
	Actor(String firstName, String lastName, int birthyear, String school) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthyear = birthyear;
		this.school = school;
	}

	// c) Create set / get methods for the private fields
	/**
	 * @return Actor's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName Actor's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return Actor's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName Actor's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// b) Override toString() method
	@Override
	public String toString() {
		return "First Name: " + firstName + " Last Name: " + lastName + " Birthyear: " + birthyear + " School: "
				+ school;
	}
}
