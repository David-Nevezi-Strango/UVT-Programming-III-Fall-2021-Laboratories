package Laboratory4;

/*
 * Think of a Library class that can manipulate the following types of objects:
 * book, video, paper
 *
 * Implement two versions of the Library class, one that uses generics and one
 * that doesn't.
 */

public class Exercise4 {
	public static void main(String args[]) {
		GenericLibrary genericLibrary = new GenericLibrary();
		genericLibrary.addElement(new Book("Harry Potter - Volume 1", "J. K. Rowling"));
		genericLibrary.addElement(new Paper("Local Elections Timisoara 2020", 250));
		genericLibrary.addElement(new Video("iPhone 12 Pro Max Review", 657.30));
		genericLibrary.removeElement(Book.class, 0);
		System.out.println(genericLibrary);
	}
}
