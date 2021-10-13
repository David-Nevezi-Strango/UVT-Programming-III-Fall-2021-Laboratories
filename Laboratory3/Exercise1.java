package Laboratory3;

import java.util.Arrays;

/*
 * Create the following classes:
 * 1. An abstract class named Figure which contains declarations of two methods:
 * - compute perimeter
 * - compute area
 * and an attribute isFilled denoting if the figure is filled with color
 * 
 * 2. Two concrete classes Circle and Rectangle extending the Figure class
 * 
 * Solve:
 * a) Create a Figure array and print it
 * b) Print the area for circles and the perimeter for rectangles
 * c) Create a Trapezoid class that extends the Figure class and add objects to the array
 */

public class Exercise1 {
	public static void main(String args[]) {
		// a) Create a Figure array and print it
		Figure[] figures = createFigureArray();
		System.out.println(Arrays.toString(figures));

		// b) Print the area for circles and the perimeter for rectangles
		for (Figure figure : figures) {
			if (figure instanceof Circle) {
				System.out.println(figure + " <-> Area: " + figure.computeArea());
			} else {
				System.out.println(figure + " <-> Perimeter: " + figure.computeArea());
			}
		}

		// c) Create a Trapezoid class that extends the Figure class and add objects to
		// the array
		figures = Arrays.copyOf(figures, 7);
		figures[5] = new Trapezoid(5, 8, 4, 5, 4, true);
		figures[6] = new Trapezoid(13, 29, 17, 17, 15, false);
		System.out.println(Arrays.toString(figures));
	}

	private static Figure[] createFigureArray() {
		Figure[] figures = new Figure[5];
		figures[0] = new Circle(3, true);
		figures[1] = new Rectangle(5, 4, false);
		figures[2] = new Circle(5, false);
		figures[3] = new Rectangle(2, 8, false);
		figures[4] = new Rectangle(7, 5, true);
		return figures;
	}
}
