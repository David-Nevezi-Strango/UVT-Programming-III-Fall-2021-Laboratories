package Laboratory4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 * Write a generic method for counting the number of elements in an ArrayList
 * that have a specified property (even numbers, prime numbers, palindrome strings)
 */

public class Exercise2 {
	public static void main(String args[]) {
		List<Integer> integers = new ArrayList<Integer>(List.of(1, 2, 3, 4));
		System.out.println("The number of even elements in " + Arrays.toString(integers.toArray()) + ":");
		System.out.println(count(integers, integer -> integer % 2 == 0));

		List<Double> doubles = new ArrayList<Double>(List.of(0.69, 0.44, 1.23, 0.33));
		System.out.println("The number of doubles smaller than 1 in " + Arrays.toString(doubles.toArray()) + ":");
		System.out.println(count(doubles, number -> number <= 1.0));

		List<String> objects = new ArrayList<String>(List.of("radar", "apple", "car", "table"));
		System.out.println("The number of palindrome strings in " + Arrays.toString(objects.toArray()));
		System.out.println(count(objects, object -> isPalindrome(object)));
	}

	public static <Type> int count(List<Type> collection, Predicate<Type> predicate) {
		int count = 0;
		for (Type entry : collection) {
			count += predicate.test(entry) ? 1 : 0;
		}
		return count;
	}

	public static <Type> boolean isPalindrome(Type object) {
		StringBuilder objectStringBuilder = new StringBuilder();
		objectStringBuilder.append(object.toString());
		return object.equals(objectStringBuilder.reverse().toString());
	}
}
