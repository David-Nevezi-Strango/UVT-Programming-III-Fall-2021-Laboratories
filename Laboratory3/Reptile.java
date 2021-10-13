package Laboratory3;

public class Reptile extends Animal {
	int numberOfProducedEggs;

	public Reptile(int age, String name, int numberOfProducedEggs) {
		super(age, name, Environment.WATER);
		this.numberOfProducedEggs = numberOfProducedEggs;
	}
}
