package Laboratory7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * Create ChristmasTree class:
 * - price
 * - type (natural, artificial)
 * - height
 * - reducedPrice (by 10%, transient field)
 * 
 * a) Create 10 objects and print them
 * b) Create a method which serializes the objects in a file
 * Write each object, not the list one
 * c) Create a method which reads the objects from the file
 * and display them
 */

public class Exercise1 {
	public static void main(String args[]) {
		// a) Create 10 objects and print them
		List<ChristmasTree> christmasTrees = createChristmasTreeList();
		// System.out.println(christmasTrees);

		// b) Create a method which serializes the objects in a file
		// Write each object, not the list one
		File file = new File("exercise1.txt");
		serializeChristmasTrees(christmasTrees, file);

		// c) Create a method which reads the objects from the file and display them
		System.out.println(deserializeChristmasTrees(file));
	}

	private static List<ChristmasTree> createChristmasTreeList() {
		return new ArrayList<ChristmasTree>(
				List.of(new ChristmasTree(39.99, "natural", 3.0), new ChristmasTree(19.99, "artificial", 2.2),
						new ChristmasTree(59.99, "natural", 4.0), new ChristmasTree(39.99, "natural", 2.8),
						new ChristmasTree(19.99, "artificial", 2.0), new ChristmasTree(15.99, "artificial", 1.5),
						new ChristmasTree(10.99, "artificial", 0.5), new ChristmasTree(49.99, "natural", 3.5),
						new ChristmasTree(29.99, "natural", 2.6), new ChristmasTree(24.99, "natural", 2.4)));
	}

	private static void serializeChristmasTrees(List<ChristmasTree> christmasTrees, File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			christmasTrees.forEach(christmasTree -> {
				try {
					oos.writeObject(christmasTree);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<ChristmasTree> deserializeChristmasTrees(File file) {
		List<ChristmasTree> christmasTrees = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			for (int i = 0; i < 10; i++) {
				Object obj = ois.readObject();
				christmasTrees.add(new ChristmasTree((ChristmasTree) obj));
			}

			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ee) {
			ee.printStackTrace();
		}

		return christmasTrees;
	}
}
