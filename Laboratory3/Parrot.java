package Laboratory3;

public class Parrot extends Bird implements IAbility {
	boolean isMonocolor;

	public Parrot(int age, String name, double averageFlySpeed, boolean isMonocolor) {
		super(age, name, averageFlySpeed);
		this.isMonocolor = isMonocolor;
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
		return "Parrot [isMonocolor=" + isMonocolor + ", averageFlySpeed=" + averageFlySpeed + ", age=" + age
				+ ", name=" + name + ", prefferedEnvironment=" + preferredEnvironment + ", canSwim()=" + canSwim()
				+ ", canFly()=" + canFly() + ", canClimb()=" + canClimb() + "]";
	}
}
