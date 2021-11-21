package Laboratory8;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Comparator;
import java.util.Scanner;
import java.util.zip.ZipFile;

/*
 * Using nio API:
 * 
 * a) Copy a file from a directory to one other
 * b) Filter all the files within a directory that have a read 
 * extension from standard input
 * c) Delete a directory and it's content
 * d) Using WatchService react to the creation of a new file in a directory:
 * if it has the .txt extension display the name, size and permissions of the file
 * if it hasn't the .txt extension delete the file immediately
 * e) Display the content of a .zip file
 */

public class Exercise1 {
	public static void main(String args[]) {
		String directory = "otherFolder";

		// a) Copy a file from a directory to one other
		String fileToCopy = "exercise1a.txt";
		copyFile(fileToCopy, directory + "/" + fileToCopy);

		// b) Filter all the files within a directory that have a read
		// extension from standard input
		String extension = readExtensionFromStandardInput();
		displayFilesFromFolderWithExtension(directory, extension);

		// c) Delete a directory and it's content
		deleteDirectory(directory);

		/*
		 * d) Using WatchService react to the creation of a new file in a directory: if
		 * it has the .txt extension display the name, size and permissions of the file
		 * if it doesn't have the .txt extension delete the file immediately
		 */
		hookDirectory(directory);

		// e) Display the content of a .zip file
		String zipFile = "exercise1e.zip";
		displayZipFileContent(zipFile);
	}

	private static void copyFile(String fileToCopy, String whereToBeCopied) {
		Path pathOfFileToCopy = Paths.get(fileToCopy);
		Path pathOfWhereToBeCopied = Paths.get(whereToBeCopied);

		try {
			Files.copy(pathOfFileToCopy, pathOfWhereToBeCopied, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readExtensionFromStandardInput() {
		Scanner in = new Scanner(System.in);
		String extension = in.nextLine();
		in.close();
		return extension;
	}

	private static void displayFilesFromFolderWithExtension(String directory, String extension) {
		ExtensionFilterer ef = new ExtensionFilterer(extension);
		try {
			Files.walkFileTree(Paths.get(directory), ef);
			ef.filteredPaths.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void deleteDirectory(String directory) {
		try {
			Files.walk(Paths.get(directory)).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void displayZipFileContent(String zipFile) {
		try {
			ZipFile zf = new ZipFile(zipFile);

			zf.stream().forEach(zipEntry -> System.out.println(zipEntry));

			zf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void hookDirectory(String directory) {
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path path = Paths.get(directory);
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

			boolean isKeyValid = true;
			while (isKeyValid) {
				WatchKey key = watchService.take();
				for (WatchEvent<?> event : key.pollEvents()) {

					File currentFile = Paths.get(event.context().toString()).toFile();
					if (currentFile.getAbsolutePath().endsWith(".txt")) {
						String fileName = currentFile.getName();
						long fileDimension = currentFile.length();
						String permissions = (currentFile.canRead() ? "r" : "") + (currentFile.canWrite() ? "w" : "")
								+ (currentFile.canExecute() ? "x" : "");
						System.out.println("Name: " + fileName + ", Dimension: " + fileDimension
								+ " bits, Permissions: " + permissions);
					} else {
						if (Files.deleteIfExists(currentFile.toPath())) {
							System.out.println("File deleted successfully.");
						} else {
							System.out.println("Can't delete file.");
						}
					}
				}
				isKeyValid = key.reset();
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
