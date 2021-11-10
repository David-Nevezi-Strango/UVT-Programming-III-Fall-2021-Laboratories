package Laboratory7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

/* 
 * Create a file and add an integer on each line (at least 5 lines)
 * 
 * a) Use LineNumberReader to read the file and print even numbers from odd lines
 * b) Use Scanner to read the file and compute the arithmetic and geometric means
 */

public class Exercise2 {
	public static void main(String args[]) {
		File file = new File("exercise2.txt");

		// a) Use LineNumberReader to read the file and print even
		// numbers from odd lines
		displayEvenNumbersFromOddLines(file);

		// b) Use Scanner to read the file and compute the arithmetic
		// and geometric means
		displayArithmeticAndGeometricMeans(file);
	}

	private static void displayEvenNumbersFromOddLines(File file) {
		try {
			LineNumberReader lnr = new LineNumberReader(new FileReader(file));

			String line = lnr.readLine();
			while (line != null) {
				int lineNumber = lnr.getLineNumber();
				int value = Integer.parseInt(line);
				if ((lineNumber % 2 - value % 2) == 1) {
					System.out.println(line);
				}
				line = lnr.readLine();
			}

			lnr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	private static void displayArithmeticAndGeometricMeans(File file) {
		try {
			double sum = 0.0;
			double prod = 1.0;
			int counter = 0;

			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				int number = scanner.nextInt();
				sum += number;
				prod *= number;
				counter++;
			}

			scanner.close();

			System.out.println(sum / counter);
			System.out.println(Math.pow(prod, 1.0 / counter));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
