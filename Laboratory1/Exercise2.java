package Laboratory1;

/*
 * Write a static function for computing the greatest common divisor of two numbers.
 * The numbers are given as command line arguments.
 *
 * Lecture: Why doesn't Java have the filename as the first argument, as it is in C?
 * https://softwareengineering.stackexchange.com/questions/211073/why-does-java-not-put-the-filename-in-args
 */

public class Exercise2 {
	public static void main(String args[]) {
		final int first = Integer.parseInt(args[0]);
		final int second = Integer.parseInt(args[1]);
		System.out.println("Iterative GCD: " + iterativeGcd(first, second));
		System.out.println("Recursive GCD: " + recursiveGcd(first, second));
	}

	private static int iterativeGcd(int first, int second) {
		int remainder;

		while (second > 0) {
			remainder = first % second;

			first = second;
			second = remainder;
		}

		return first;
	}

	public static int recursiveGcd(int a, int b) {
		if (b == 0)
			return a;
		return recursiveGcd(b, a % b);
	}
}
