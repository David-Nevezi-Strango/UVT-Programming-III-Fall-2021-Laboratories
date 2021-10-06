package Laboratory2;

/*
 * Create Product class:
 * private - name
 *         - price
 *         - amount
 * 
 * Add a constructor and override toString() method
 * 
 * Create Container class:
 * private - products (array)
 *         - label
 * 
 * Add methods for adding and removing products and a static method
 * for changing the amount of a stored product
 * 
 * a) Create a Container object
 * b) Add and remove objects from container
 * c) Find a product in the container by name (received as a command line argument) and
 * change it's stored amount to a value (received as a command line argument)
 * d) Compute the total price of the container (sum the products prices)
 * e) Create a Container array and display it
 */

public class Exercise2 {
	public static void main(String args[]) {
		// a) Create a Container object
		Container juiceCansContainer = new Container("Juice Cans");

		// b) Add and remove objects from container
		juiceCansContainer.addProduct(new Product("Cola Can", 0.59, 10));
		juiceCansContainer.addProduct(new Product("Pepsi Can", 0.59, 12));
		juiceCansContainer.addProduct(new Product("Nestea Peach Can", 0.75, 20));
		juiceCansContainer.addProduct(new Product("Fanta Orange Can", 0.55, 15));
		juiceCansContainer.removeProduct(1);

		/*
		 * c) Find a product in the container by name (received as a command line
		 * argument) and change it's stored amount to a value (received as a command
		 * line argument)
		 */
		Product product = juiceCansContainer.findByName(args[0]);
		if (product != null) {
			Container.changeStoredAmountOfProduct(product, Integer.parseInt(args[1]));
		}

		// d) Compute the total price of the container (sum the products prices)
		System.out.println("The total price of " + juiceCansContainer.getLabel() + " is: "
				+ juiceCansContainer.getContainerPrice());

		// e) Create a Container array and display it
		Container pcPartsContainer = new Container("PC Parts");
		pcPartsContainer.addProduct(new Product("nVidia Geforce RTX 2060 Super", 499.99, 10));
		pcPartsContainer.addProduct(new Product("Intel Core i5-10600k", 274.99, 15));
		pcPartsContainer.addProduct(new Product("Z490 Aorus PRO AX ", 299.99, 20));

		Container cdsContainer = new Container("CDs");
		cdsContainer.addProduct(new Product("Michael Jackson Album #1", 24.99, 1000));
		cdsContainer.addProduct(new Product("Modern Talking Album #4", 14.99, 3000));
		cdsContainer.addProduct(new Product("C.C. Catch Album #3", 19.99, 2000));

		Container[] containers = new Container[3];
		containers[0] = juiceCansContainer;
		containers[1] = pcPartsContainer;
		containers[2] = cdsContainer;

		for (Container container : containers) {
			System.out.println(container.toString());
		}
	}
}
