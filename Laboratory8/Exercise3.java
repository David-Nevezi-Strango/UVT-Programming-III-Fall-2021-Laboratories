package Laboratory8;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Using RandomAccessFile:
 * 1. a) Create a file with integers.
 *    b) Read a file with integers and display them.
 *    c) Overwrite the integers in a file with their absolute value.
 * 
 * 2. a) Create a Concert class:
 *    - name
 *    - a starting hour
 *    - a list with singers' names
 *    b) Add class methods for writing, reading and modifying an 
 *    object in / from a file.
 */

public class Exercise3 {
	private static int numberOfIntegers = 10;

	public static void main(String args[]) {
		File file = new File("exercise3a.txt");

		// 1. a) Create a file with integers.
		createIntegersFile(file);

		// 1. b) Read a file with integers and display them.
		displayIntegersFromFile(file);

		// 1. c) Overwrite the integers in a file with their absolute value.
		overwriteIntegersWithTheirAbsoluteValuesInFile(file);
		displayIntegersFromFile(file);

		// 2. b) Add class methods for writing, reading and modifying an object in /
		// from a file.

		File concertFile = new File("exercise3b.txt");
		List<String> singersNames = new ArrayList<String>(List.of("AFROJACK", "ARMIN VAN BUUREN", "DANNIC"));
		Concert concertToWrite = new Concert();// new Concert("UNTOLD", 16, singersNames);
		concertToWrite.writeObjectInFile(concertFile);

		Concert.modifyNameInFile(concertFile, "UNTOLD 2020");
		Concert.modifyStartingHourInFile(concertFile, 17);
		singersNames.add("KYGO");
		Concert.modifySingersNamesInFile(concertFile, singersNames);

		Concert concertToRead = new Concert();
		concertToRead.readObjectFromFile(concertFile);
		System.out.println(concertToRead);
	}

	private static void createIntegersFile(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			for (int npos = 0; npos < numberOfIntegers; ++npos) {
				raf.writeInt(new Random().nextInt());
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void displayIntegersFromFile(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			for (int npos = 0; npos < numberOfIntegers; ++npos) {
				System.out.println(raf.readInt());
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void overwriteIntegersWithTheirAbsoluteValuesInFile(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			for (int npos = 0; npos < numberOfIntegers; ++npos) {
				int currentInteger = raf.readInt(); // Read an integer
				raf.seek(npos * Integer.BYTES); // Go back to the starting position of the read integer
				raf.writeInt(Math.abs(currentInteger)); // Overwrite the integer with it's absolute value
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
