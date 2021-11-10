package Laboratory7;

import java.io.File;
import java.util.Scanner;

/*
 * Use File class for displaying the content of a directory:
 * - for each file:         name, relative path, size
 * - for each subdirectory: number of files it contains, it's content
 * 
 * Read the path from standard input.
 */

public class Exercise4 {
	private static String directoryPath;

	public static void main(String args[]) {
		directoryPath = readFilePath();
		File directory = new File(directoryPath);

		if (directory.isDirectory()) {
			displayDirectoryContent(directory, 0);
		} else {
			System.out.println("The path " + directoryPath + " doesn't point to a directory.");
		}
	}

	private static String readFilePath() {
		Scanner sin = new Scanner(System.in);
		String filePath = sin.next();
		sin.close();
		return filePath;
	}

	private static void displayDirectoryContent(File directory, int depth) {
		for (File file : directory.listFiles()) {
			if (file.isDirectory()) {
				System.out.println(" ".repeat(depth * 2) + file.getName() + " | " + file.listFiles().length);
				displayDirectoryContent(file, depth + 1);
			} else if (file.isFile()) {
				System.out.println(" ".repeat(depth * 2) + file.getName() + " | "
						+ file.getPath().replace(directoryPath, "") + " | " + file.length() + " bytes");
			}
		}
	}
}
