package zoo;

import java.util.Random;

public class Bear {
	protected String name;
	protected int age;
	protected double weight;
	protected String gender;
	protected String noise;
	protected int count;
	public static String color;
	public static String type;
	final int bearLifeSpan = 20;
	public static int BearEatFood = 0;
	public static final int LIFE_SPAN = 20;
	private int happiness = 100;

	public Bear(String name, int age, double weight, String gender, String color) {
		if (age < 0 || age > LIFE_SPAN) {
			throw new IllegalArgumentException("Invalid age: " + age + ", Age must be between 0 and " + LIFE_SPAN);
		}
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		this.color = color;
		// this.type=type;
		this.noise = "GROWL";
		count++;
		foodAteByBear();
	}

	public int getHappiness() {
		return happiness;
	}

	public String getNoise() {
		return noise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null)
			this.name = null;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public boolean setAge(int age) {
		if (age <= 0)
			return false;

		this.age = age;
		return true;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight <= 0)
			this.weight = 0;
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public String getType() {
		return noise;
	}

	public String getColor() {
		return color;
	}

	public int foodAteByBear() {
		BearEatFood += (int) (weight / 3);
		return (int) (weight / 3);
	}

	public boolean hasAgeByOneYear() {
		// increase age
		age++;
		if (age >= LIFE_SPAN) {
			return false;
		}
		decreaseHappinessRandomly();
		return true;
	}

	public boolean decreaseHappinessRandomly() {
		Random random = new Random();
		int decreaseAmount = random.nextInt(16) + 5; // Generates a random number between 5 and 20
		happiness -= decreaseAmount;
		if (happiness <= 0) {
			happiness = 0; // Ensure happiness doesn't go below 0
			return true; // Return true to indicate that happiness reached 0 or less
		}
		return false; // Return false if happiness is still above 0
	}

	public void setGender(String gender) {
		if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"))
			this.gender = null;
		this.gender = gender;
	}

	public String toString() {
		return "Bears [name=" + name + ", age=" + age + ", weight=" + weight + ", gender=" + gender + ", color=" + color
				+ " ,happiness=" + happiness + "]";
	}

}
