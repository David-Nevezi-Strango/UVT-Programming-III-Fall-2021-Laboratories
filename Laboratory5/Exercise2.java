package Laboratory5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Create a Flower class:
 * - name
 * - price
 * - type
 * 
 * a) Create an ArrayList of flowers and print it
 * 
 * b) Use streams for:
 *   i. Compute and print the average price of the flowers
 *  ii. Print the flowers that have a specified type (received as an argument on the command line)
 * iii. Extract a list of flowers that have a name which starts with an prefix
 */

public class Exercise2 {
	public static void main(String args[]) {
		// a) Create an ArrayList of flowers and print it
		List<Flower> flowers = createFlowerArrayList();

		// b) i. Compute and print the average price of the flowers
		System.out.println(getAveragePriceOfFlowers(flowers));

		// b) ii. Print the flowers that have a specified type (received as an argument
		// on the command line)
		printFlowersThatAreOfType(flowers, args[0]);

		// b) iii. Extract a list of flowers that have a name which starts with an
		// prefix
		String prefix = "L";
		System.out.println(extractListOfFlowersThatStartWith(flowers, prefix));
	}

	private static List<Flower> createFlowerArrayList() {
		return new ArrayList<Flower>(List.of(new Flower("Lavender", 9, "Lavandula"), new Flower("Lily", 7, "Lilium"),
				new Flower("Rose", 8, "Rosaceae Family"), new Flower("Buzzy burr", 10, "Rosaceae Family")));
	}

	private static double getAveragePriceOfFlowers(List<Flower> flowers) {
		return flowers.stream().mapToDouble((flower) -> flower.price).average().getAsDouble();
	}

	private static void printFlowersThatAreOfType(List<Flower> flowers, String type) {
		flowers.forEach(flower -> printFlowerIfItIsOfType(flower, type));
	}

	private static void printFlowerIfItIsOfType(Flower flower, String type) {
		if (flower.type.equals(type)) {
			System.out.println(flower);
		}
	}

	private static List<Flower> extractListOfFlowersThatStartWith(List<Flower> flowers, String prefix) {
		return flowers.stream().filter(flower -> flower.name.startsWith(prefix))
				.collect(Collectors.toList());
	}
}
