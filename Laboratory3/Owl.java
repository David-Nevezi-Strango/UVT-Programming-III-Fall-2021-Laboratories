package Laboratory3;

public class Owl extends Bird implements IAbility {
	boolean isBrown;

	public Owl(int age, String name, double averageFlySpeed, boolean isBrown) {
		super(age, name, averageFlySpeed);
		this.isBrown = isBrown;
	}

	@Override
	public boolean canSwim() {
		return false;
	}

	@Override
	public boolean canFly() {
		return true;
	}

	@Override
	public boolean canClimb() {
		return true;
	}

	@Override
	public String toString() {
		return "Owl [isBrown=" + isBrown + ", averageFlySpeed=" + averageFlySpeed + ", age=" + age + ", name=" + name
				+ ", prefferedEnvironment=" + preferredEnvironment + ", canSwim()=" + canSwim() + ", canFly()="
				+ canFly() + ", canClimb()=" + canClimb() + "]";
	}
}
