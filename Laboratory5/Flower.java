package Laboratory5;

public class Flower {
	String name;
	double price;
	String type;

	public Flower(String name, double price, String type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Flower [name=" + name + ", price=" + price + ", type=" + type + "]";
	}
}
