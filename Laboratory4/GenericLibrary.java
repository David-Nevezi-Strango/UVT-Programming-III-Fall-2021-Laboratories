package Laboratory4;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class GenericLibrary {
	List<Book> books;
	List<Video> videos;
	List<Paper> papers;

	public GenericLibrary() {
		this.books = new ArrayList<Book>();
		this.videos = new ArrayList<Video>();
		this.papers = new ArrayList<Paper>();
	}

	public GenericLibrary(List<Book> books, List<Video> videos, List<Paper> papers) {
		this.books = books;
		this.videos = videos;
		this.papers = papers;
	}

	public <Type> void addElement(Type element) {
		if (element instanceof Book) {
			books.add((Book) element);
		} else if (element instanceof Video) {
			videos.add((Video) element);
		} else {
			papers.add((Paper) element);
		}
	}

	public <Type> void removeElement(Class<Type> type, int index) {
		if (type == Book.class) {
			if (index >= 0 && index < books.size()) {
				books.remove(index);
			}
		} else if (type == Video.class) {
			if (index >= 0 && index < videos.size()) {
				videos.remove(index);
			}
		} else {
			if (index >= 0 && index < papers.size()) {
				papers.remove(index);
			}
		}
	}

	@Override
	public String toString() {
		return "GenericLibrary [books=" + Arrays.toString(books.toArray()) + ", videos="
				+ Arrays.toString(videos.toArray()) + ", papers=" + Arrays.toString(papers.toArray()) + "]";
	}
}
