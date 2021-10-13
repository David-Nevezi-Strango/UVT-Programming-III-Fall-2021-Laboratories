package Laboratory3;

public class Snake extends Reptile implements IAbility {
	double length;

	public Snake(int age, String name, int numberOfProducedEggs, double length) {
		super(age, name, numberOfProducedEggs);
		this.length = length;
	}

	@Override
	public boolean canSwim() {
		return true;
	}

	@Override
	public boolean canFly() {
		return false;
	}

	@Override
	public boolean canClimb() {
		return true;
	}

	@Override
	public String toString() {
		return "Snake [length=" + length + ", numberOfProducedEggs=" + numberOfProducedEggs + ", age=" + age + ", name="
				+ name + ", prefferedEnvironment=" + preferredEnvironment + ", canSwim()=" + canSwim() + ", canFly()="
				+ canFly() + ", canClimb()=" + canClimb() + "]";
	}
}
