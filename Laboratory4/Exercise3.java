package Laboratory4;

import java.util.Arrays;

/*
 * Write a generic method for swapping two elements in an array
 */

public class Exercise3 {
	public static void main(String args[]) {
		Integer[] a = new Integer[] { 1, 2, 3, 4 };
		int firstIndex = 0;
		int secondIndex = 1;
		System.out.print(Arrays.toString(a) + " after swapping " + firstIndex + " with " + secondIndex + ": ");
		swap(a, firstIndex, secondIndex);
		System.out.println(Arrays.toString(a));

		String[] b = new String[] { "George", "Vlad", "Christian", "Gregory" };
		firstIndex = 1;
		secondIndex = 3;
		System.out.print(Arrays.toString(b) + " after swapping " + firstIndex + " with " + secondIndex + ": ");
		swap(b, firstIndex, secondIndex);
		System.out.println(Arrays.toString(b));
	}

	public static <Type> void swap(Type[] array, int first, int second) {
		Type temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
