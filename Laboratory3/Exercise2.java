package Laboratory3;

/*
 * Create an abstract class named Animal with the following attributes:
 * - age
 * - name
 * - preferredEnvironment (water, earth, air) <- use an Enum for this
 * 
 * Create Mammalian, Bird and Reptile classes extending the Animal class
 * 
 * Add the following attributes:
 * for Mammalian: the average number of children that can be born at once
 * for Bird: the average fly speed
 * for Reptile: the number of produced eggs
 * From each one of these classes, derives some concrete classes:
 * for example:
 * from Mammalian: Dog, Cat
 * from Bird: Parrot, Owl
 * from Reptile: Snake, Crocodile
 * 
 * Create an interface named Ability, interface which contains the following methods:
 * - boolean canFly()
 * - boolean canSwim()
 * - boolean canClimb()
 * Each concrete class implements the Ability interface, for example a dog can swim but can't fly
 * 
 * Tasks:
 * a) Create an Animal array and print it
 * b) Find out how many animals can fly
 * c) Print the animals that can climb but can't swim
 */

public class Exercise2 {
	public static void main(String args[]) {
		// a) Create an Animal array and print it
		Animal[] animals = createAnimalArray();
		for (Animal animal : animals) {
			System.out.println(animal);
		}

		// b) Find out how many animals can fly
		System.out.println("\nNumber of animals that can fly: ");
		System.out.println(countAnimalsThatCanFly(animals));

		// c) Print the animals that can climb but can't swim
		System.out.println("\nAnimals that can climb but can't swim: ");
		printAnimalsThatCanFlyButCanNotSwim(animals);
	}

	private static Animal[] createAnimalArray() {
		Animal[] animals = new Animal[11];
		animals[0] = new Dog(10, "Scooby", 4, 40);
		animals[1] = new Cat(12, "Lily", 6, 3);
		animals[2] = new Parrot(15, "Perry", 23, true);
		animals[3] = new Parrot(7, "Lerry", 28, false);
		animals[4] = new Owl(6, "Owly", 30, true);
		animals[5] = new Snake(4, "Cobra", 50, 3);
		animals[6] = new Crocodile(7, "Crocky", 10, true);
		animals[7] = new Dog(3, "Mooby", 5, 42);
		animals[8] = new Dog(12, "Dooby", 3, 45);
		animals[9] = new Cat(8, "Kitty", 6, 0);
		animals[10] = new Cat(11, "Pretty", 7, 5);
		return animals;
	}

	private static int countAnimalsThatCanFly(Animal[] animals) {
		int count = 0;
		for (Animal animal : animals) {
			count += ((IAbility) animal).canFly() ? 1 : 0;
		}
		return count;
	}

	private static void printAnimalsThatCanFlyButCanNotSwim(Animal[] animals) {
		for (Animal animal : animals) {
			if (((IAbility) animal).canClimb() && !((IAbility) animal).canSwim()) {
				System.out.println(animal);
			}
		}
	}
}
