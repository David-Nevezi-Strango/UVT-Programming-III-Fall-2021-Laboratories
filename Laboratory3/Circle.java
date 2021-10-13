package Laboratory3;

public class Circle extends Figure {
	double radius;

	Circle(double radius, boolean isFilled) {
		super(isFilled);
		this.radius = radius;
	}

	@Override
	public double computeArea() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public double computePerimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public String toString() {
		return "Circle radius: " + this.radius;
	}
}
