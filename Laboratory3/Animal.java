package Laboratory3;

public abstract class Animal {
	int age;
	String name;
	Environment preferredEnvironment;

	public Animal(int age, String name, Environment preferredEnvironment) {
		this.age = age;
		this.name = name;
		this.preferredEnvironment = preferredEnvironment;
	}
}
