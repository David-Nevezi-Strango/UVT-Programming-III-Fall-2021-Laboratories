package Laboratory2;

import java.util.Arrays;

public class Container {
	private Product[] products;
	private String label;

	Container(String label) {
		products = new Product[0];
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public void addProduct(Product product) {
		Product[] newProducts = Arrays.copyOf(this.products, this.products.length + 1);
		newProducts[this.products.length] = product;
		this.products = newProducts;
	}

	public void removeProduct(int index) {
		if (index < 0 || index >= this.products.length) {
			return;
		}
		Product[] newProducts = Arrays.copyOf(this.products, this.products.length - 1);
		for (int i = index; i < this.products.length - 1; ++i) {
			newProducts[i] = this.products[i + 1];
		}
		this.products = newProducts;
	}

	public Product findByName(String name) {
		for (Product product : products) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	public static void changeStoredAmountOfProduct(Product product, int newAmount) {
		product.setAmount(newAmount);
	}

	public double getContainerPrice() {
		double totalPrice = 0;
		for (Product product : products) {
			totalPrice += product.getPrice() * product.getAmount();
		}
		return totalPrice;
	}

	@Override
	public String toString() {
		String containerString = "Container: " + label + "\n";
		for (Product product : products) {
			containerString += product.toString() + "\n";
		}
		return containerString;
	}
}
