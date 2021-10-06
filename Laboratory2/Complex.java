package Laboratory2;

public class Complex {
	private double realPart;
	private double imaginaryPart;

	Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	public double computeModulus() {
		return Math.sqrt(this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart);
	}

	static Complex sum(Complex first, Complex second) {
		return new Complex(first.realPart + second.realPart, first.imaginaryPart + second.imaginaryPart);
	}

	static Complex product(Complex first, Complex second) {
		return new Complex(first.realPart * second.realPart - first.imaginaryPart * second.imaginaryPart,
				first.realPart * second.imaginaryPart + first.imaginaryPart * second.realPart);
	}

	@Override
	public String toString() {
		return this.realPart + " + " + this.imaginaryPart + "i";
	}
}
