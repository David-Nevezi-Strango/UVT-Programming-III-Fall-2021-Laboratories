package Laboratory2;

/*
 * Create a class for modeling a complex number:
 * 
 * a) Create and display a complex number
 * b) Compute the modulus of a complex number
 * c) Compute the sum of two complex numbers
 * d) Compute the product of two complex numbers
 */

public class Exercise3 {
	public static void main(String args[]) {
		// a) Create and display a complex number
		Complex first = new Complex(2, 3);
		Complex second = new Complex(3, -1);

		System.out.println(first.toString());
		System.out.println(second.toString());

		// b) Compute the modulus of a complex number
		System.out.println("|" + first.toString() + "| = " + first.computeModulus());
		System.out.println("|" + second.toString() + "| = " + second.computeModulus());

		// c) Compute the sum of two complex numbers
		System.out.println("(" + first.toString() + ") + (" + second.toString() + ") = " + Complex.sum(first, second));

		// d) Compute the product of two complex numbers
		System.out.println(
				"(" + first.toString() + ") * (" + second.toString() + ") = " + Complex.product(first, second));
	}
}
