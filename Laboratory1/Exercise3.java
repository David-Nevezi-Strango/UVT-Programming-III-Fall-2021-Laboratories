package Laboratory1;

import java.util.Arrays;
import java.util.Random;

/*
 * Create an array that contains N random generated numbers, where N is a command line argument.
 * Using Arrays class, write functions to:
 * a) Display the array.
 * b) Sort the array.
 * c) Search for a given value in the array.
 * d) Copy a subarray from the array with random generated start and stop indexes.
 */

public class Exercise3 {
	public static void main(String args[]) {
		/*
		 * Prerequisites
		 */
		Random random = new Random();
		final int size = Integer.parseInt(args[0]);
		int[] array = new int[size];
		for (int i = 0; i < size; ++i) {
			array[i] = random.nextInt();
		}

		/*
		 * a) Display the array
		 */
		displayArray(array);

		/*
		 * b) Sort the array
		 */
		array = sortArray(array);
		displayArray(array);

		/*
		 * c) Search for a given value in the array
		 */
		if (isValueInArray(3, array)) {
			System.out.println("The array contains at least one 3.");
		} else {
			System.out.println("The array doesn't contain at least one 3.");
		}

		/*
		 * d) Copy a subarray from the array with random generated start and stop
		 * indexes.
		 */
		final int startIndex = random.nextInt(size - 1);
		final int stopIndex = random.nextInt(size - startIndex) + startIndex + 1;
		displayArray(getSubarray(array, startIndex, stopIndex));
	}

	private static void displayArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	private static int[] sortArray(int[] array) {
		Arrays.sort(array);
		return array;
	}

	private static boolean isValueInArray(int value, int[] array) {
		int searchResult = Arrays.binarySearch(array, value);
		return searchResult >= 0;
	}

	private static int[] getSubarray(int[] array, int startIndex, int stopIndex) {
		int[] subarray = Arrays.copyOfRange(array, startIndex, stopIndex);
		return subarray;
	}
}