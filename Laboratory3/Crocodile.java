package Laboratory3;

public class Crocodile extends Reptile implements IAbility {
	boolean isMediumSize;

	public Crocodile(int age, String name, int numberOfProducedEggs, boolean isMediumSize) {
		super(age, name, numberOfProducedEggs);
		this.isMediumSize = isMediumSize;
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
		return "Crocodile [isMediumSize=" + isMediumSize + ", numberOfProducedEggs=" + numberOfProducedEggs + ", age="
				+ age + ", name=" + name + ", prefferedEnvironment=" + preferredEnvironment + ", canSwim()=" + canSwim()
				+ ", canFly()=" + canFly() + ", canClimb()=" + canClimb() + "]";
	}
}
