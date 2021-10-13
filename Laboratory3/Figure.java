package Laboratory3;

public abstract class Figure {
	boolean isFilled;

	Figure(boolean isFilled) {
		this.isFilled = isFilled;
	}

	public abstract double computeArea();

	public abstract double computePerimeter();
}
