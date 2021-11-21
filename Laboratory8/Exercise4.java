package Laboratory8;

/*
 * Create CustomDate class:
 * - day
 * - month
 * - year
 * 
 * Use StringTokenizer for accepting the following date types:
 * - DD/MM/YYYY
 * - DD Month YYYY
 * 
 * Add methods for printing the date in different formats.
 */

public class Exercise4 {
	public static void main(String args[]) {
		CustomDate firstCustomDate = new CustomDate("10/02/2020");
		CustomDate secondCustomDate = new CustomDate("10 February 2020");
		CustomDate thirdCustomDate = new CustomDate("This will be set to the default date");

		System.out.println(firstCustomDate.format("Year: yyyy, Month: mm, Day: dd"));
		System.out.println(secondCustomDate.format("dd.mm.yyyy"));
		System.out.println(thirdCustomDate.format("dd-mm-yyyy"));
	}
}
