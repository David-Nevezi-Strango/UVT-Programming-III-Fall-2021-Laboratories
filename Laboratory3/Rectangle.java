package Laboratory3;

public class Rectangle extends Figure {
	double width;
	double height;

	Rectangle(double width, double height, boolean isFilled) {
		super(isFilled);
		this.width = width;
		this.height = height;
	}

	@Override
	public double computeArea() {
		return this.width * this.height;
	}

	@Override
	public double computePerimeter() {
		return 2 * this.width + 2 * this.height;
	}

	@Override
	public String toString() {
		return "Rectangle [width: " + this.width + ", height: " + this.height + "]";
	}
}
