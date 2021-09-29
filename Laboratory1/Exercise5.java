package Laboratory1;

/*
 * Explain each of the following prints.
 */

public class Exercise5 {
	public static void main(String args[]) {
		System.out.println(new String("test").equals("test"));
		// .equals() method returns true when the two values match

		System.out.println(new String("test") == "test");
		// new String("test") and "test" are not the same object

		System.out.println(new String("test") == new String("test"));
		// new String("test") and new String("test") are not the same object

		System.out.println("test" == "test");
		// "test" and "test" are the same object

		System.out.println("test" == "te" + "st");
		// string literals are concatenated by the compiler, so at runtime the test will
		// be "test" == "test"

		System.out.println("test" == "!test".substring(1));
		// "test" and "!test".substring(1) are not the same object, .substring() method
		// returns a new string
	}
}