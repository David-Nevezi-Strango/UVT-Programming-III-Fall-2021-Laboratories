package Laboratory3;

public class Cat extends Mammalian implements IAbility {
	int numberOfMarksOnFur;

	public Cat(int age, String name, int averageNumberOfChildrenThatCanBeBornOnce, int numberOfMarksOnFur) {
		super(age, name, averageNumberOfChildrenThatCanBeBornOnce);
		this.numberOfMarksOnFur = numberOfMarksOnFur;
	}

	@Override
	public boolean canSwim() {
		return false;
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
		return "Cat [numberOfMarksOnFur=" + numberOfMarksOnFur + ", averageNumberOfChildrenThatCanBeBornOnce="
				+ averageNumberOfChildrenThatCanBeBornOnce + ", age=" + age + ", name=" + name
				+ ", prefferedEnvironment=" + preferredEnvironment + ", canSwim()=" + canSwim() + ", canFly()="
				+ canFly() + ", canClimb()=" + canClimb() + "]";
	}
}
