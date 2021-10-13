package Laboratory3;

public class Dog extends Mammalian implements IAbility {
	int barkingLoudness;

	public Dog(int age, String name, int averageNumberOfChildrenThatCanBeBornOnce, int barkingLoudness) {
		super(age, name, averageNumberOfChildrenThatCanBeBornOnce);
		this.barkingLoudness = barkingLoudness;
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
		return false;
	}

	@Override
	public String toString() {
		return "Dog [barkingLoudness=" + barkingLoudness + ", averageNumberOfChildrenThatCanBeBornOnce="
				+ averageNumberOfChildrenThatCanBeBornOnce + ", age=" + age + ", name=" + name
				+ ", prefferedEnvironment=" + preferredEnvironment + ", canSwim()=" + canSwim() + ", canFly()="
				+ canFly() + ", canClimb()=" + canClimb() + "]";
	}
}
