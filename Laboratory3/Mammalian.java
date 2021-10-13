package Laboratory3;

public class Mammalian extends Animal {
	int averageNumberOfChildrenThatCanBeBornOnce;

	public Mammalian(int age, String name, int averageNumberOfChildrenThatCanBeBornOnce) {
		super(age, name, Environment.EARTH);
		this.averageNumberOfChildrenThatCanBeBornOnce = averageNumberOfChildrenThatCanBeBornOnce;
	}
}
