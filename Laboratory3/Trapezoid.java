package Laboratory3;

public class Trapezoid extends Figure {
	double topBaseLength;
	double bottomBaseLength;
	double leftLegLength;
	double rightLegLength;
	double height;

	public Trapezoid(double topBaseLength, double bottomBaseLength, double leftLegLength, double rightLegLength,
			double height, boolean isFilled) {
		super(isFilled);
		this.topBaseLength = topBaseLength;
		this.bottomBaseLength = bottomBaseLength;
		this.leftLegLength = leftLegLength;
		this.rightLegLength = rightLegLength;
		this.height = height;
	}

	@Override
	public double computeArea() {
		return (topBaseLength + bottomBaseLength) * height / 2;
	}

	@Override
	public double computePerimeter() {
		return topBaseLength + bottomBaseLength + leftLegLength + rightLegLength;
	}

	@Override
	public String toString() {
		return "Trapezoid [topBaseLength: " + this.topBaseLength + ", bottomBaseLength: " + this.bottomBaseLength
				+ ", leftLegLength: " + this.leftLegLength + ", rightLegLength: " + this.rightLegLength + ", height: "
				+ this.height + "]";
	}
}
