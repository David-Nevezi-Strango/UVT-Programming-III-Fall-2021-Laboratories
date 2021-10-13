package Laboratory3;

public class Bird extends Animal {
	double averageFlySpeed;

	public Bird(int age, String name, double averageFlySpeed) {
		super(age, name, Environment.AIR);
		this.averageFlySpeed = averageFlySpeed;
	}
}
