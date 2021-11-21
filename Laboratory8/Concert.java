package Laboratory8;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Concert {
	String name;
	int startingHour;
	List<String> singersNames;

	private static int MAXIMUM_STRING_LENGTH = 20;
	private static int NAME_POSITION = 0;
	private static int STARTING_HOUR_POSITION = 20 * Character.BYTES;
	private static int SINGERS_NAMES_SIZE_POSITION = 20 * Character.BYTES + Integer.BYTES;

	@Override
	public String toString() {
		return "Concert [name=" + name + ", startingHour=" + startingHour + ", singersNames=" + singersNames + "]";
	}

	public Concert() {
	}

	public Concert(String name, int startingHour, List<String> singersNames) {
		super();
		this.name = name;
		this.startingHour = startingHour;
		this.singersNames = singersNames;
	}

	public void writeObjectInFile(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");

			StringBuffer nameSb = new StringBuffer(this.name == null ? "" : this.name);
			nameSb.setLength(MAXIMUM_STRING_LENGTH);
			raf.writeChars(nameSb.toString());

			raf.writeInt(this.startingHour);

			if (this.singersNames == null)
				this.singersNames = new ArrayList<String>();
			raf.writeInt(this.singersNames.size());
			for (String singerName : this.singersNames) {
				StringBuffer singerNameSb = new StringBuffer(singerName);
				singerNameSb.setLength(MAXIMUM_STRING_LENGTH);
				raf.writeChars(singerNameSb.toString());
			}

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readObjectFromFile(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "r");

			char[] nameFromFile = new char[MAXIMUM_STRING_LENGTH];
			for (int npos = 0; npos < MAXIMUM_STRING_LENGTH; ++npos) {
				nameFromFile[npos] = raf.readChar();
			}
			this.name = new String(nameFromFile).trim();

			this.startingHour = raf.readInt();

			this.singersNames = new ArrayList<String>();
			int singersNamesSize = raf.readInt();
			for (int npos = 0; npos < singersNamesSize; ++npos) {
				char[] singerNameFromFile = new char[MAXIMUM_STRING_LENGTH];
				for (int mpos = 0; mpos < MAXIMUM_STRING_LENGTH; ++mpos) {
					singerNameFromFile[mpos] = raf.readChar();
				}
				this.singersNames.add(new String(singerNameFromFile).trim());
			}

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void modifyNameInFile(File file, String newName) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");

			raf.seek(NAME_POSITION);

			StringBuffer nameSb = new StringBuffer(newName);
			nameSb.setLength(MAXIMUM_STRING_LENGTH);
			raf.writeChars(nameSb.toString());

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void modifyStartingHourInFile(File file, int newStartingHour) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");

			raf.seek(STARTING_HOUR_POSITION);

			raf.writeInt(newStartingHour);

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void modifySingersNamesInFile(File file, List<String> newSingersNames) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");

			raf.seek(SINGERS_NAMES_SIZE_POSITION);

			int newSingersNamesSize = newSingersNames.size();
			raf.writeInt(newSingersNamesSize);
			for (String singerName : newSingersNames) {
				StringBuffer singerNameSb = new StringBuffer(singerName);
				singerNameSb.setLength(MAXIMUM_STRING_LENGTH);
				raf.writeChars(singerNameSb.toString());
			}

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
