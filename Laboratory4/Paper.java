package Laboratory4;

public class Paper {
	String producer;
	int numberOfCopies;

	public Paper(String producer, int numberOfCopies) {
		super();
		this.producer = producer;
		this.numberOfCopies = numberOfCopies;
	}

	@Override
	public String toString() {
		return "Paper [producer=" + producer + ", numberOfCopies=" + numberOfCopies + "]";
	}
}
