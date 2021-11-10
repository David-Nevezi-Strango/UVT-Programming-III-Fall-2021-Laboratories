package Laboratory7;

import java.io.Serializable;

public class ChristmasTree implements Serializable {
	double price;
	String type;
	double height;
	transient double reducedPrice;

	public ChristmasTree(double price, String type, double height) {
		super();
		this.price = price;
		this.type = type;
		this.height = height;
		this.reducedPrice = 0.9 * price;
	}

	public ChristmasTree(ChristmasTree other) {
		this.price = other.price;
		this.type = other.type;
		this.height = other.height;
		this.reducedPrice = 0.9 * other.price;
	}

	@Override
	public String toString() {
		return "\nChristmasTree [price=" + price + ", type=" + type + ", height=" + height + ", reducedPrice="
				+ reducedPrice + "]\n";
	}
}
