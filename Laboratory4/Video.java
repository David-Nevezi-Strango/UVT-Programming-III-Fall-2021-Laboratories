package Laboratory4;

public class Video {
	String title;
	double lengthInSeconds;

	public Video(String title, double lengthInSeconds) {
		super();
		this.title = title;
		this.lengthInSeconds = lengthInSeconds;
	}

	@Override
	public String toString() {
		return "Video [title=" + title + ", lengthInSeconds=" + lengthInSeconds + "]";
	}
}
