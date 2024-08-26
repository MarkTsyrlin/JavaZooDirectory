package zoo;

import java.util.Random;

public class Lions {

	protected String name;
	protected int age;
	protected double weight;
	protected String gender;
	protected String noise;
	protected int count;
	public static final int LIFE_SPAN = 15;
	private int happiness = 100;
	public final int FEEDING_LIMIT = 25;

	public Lions(String name, int age, double weight, String gender) {
		if (age < 0 || age > LIFE_SPAN) {
			throw new IllegalArgumentException("Invalid age: " + age + ", Age must be between 0 and " + LIFE_SPAN);
		}

		setName(name);
		setAge(age);
		setWeight(weight);
		setGender(gender);
		this.noise = "ROAR";
		count++;

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

	public void setGender(String gender) {
		if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"))
			this.gender = null;
		this.gender = gender;
	}

	public double CalculateConsumptionOfLion() {

		double weightMultiplyAge = getWeight() * getAge();
		double consumption;

		if (getGender().equalsIgnoreCase("female")) {
			consumption = weightMultiplyAge * 0.03;
		} else {
			consumption = weightMultiplyAge * 0.02;
		}

		consumption = Math.floor(consumption);

		if (consumption > FEEDING_LIMIT)
			consumption = FEEDING_LIMIT;

		return consumption;
	}

	public boolean ageByOneYear() {
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

	public void resetHappinessByFeedingPredator() {
		happiness = 100;
	}

	public int getHappiness() {
		return happiness;
	}

	@Override
	public String toString() {
		return "Lions [name=" + name + ", age=" + age + ", weight=" + weight + ", gender=" + gender + ", happiness="
				+ happiness + "]";
	}
}
