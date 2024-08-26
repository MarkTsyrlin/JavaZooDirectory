package zoo;

import java.util.Random;

public class PandaBear extends Bear {
	public static int BambokConsaption;
	public static final int LIFE_SPAN = 20;
	private int happiness = 100;

	@Override
	public String getType() {
		return "Panda Bear";
	}

	@Override
	public int foodAteByBear() {
		BambokConsaption += weight;
		return 0;
	}

	@Override
	public String getNoise() {
		return "gro";
	}

	public int getHappiness() {
		return happiness;
	}

	@Override
	public String getColor() {
		return color;
	}

	public PandaBear(String name, int age, double weight, String gender, String color) {
		super(name, age, weight, gender, "White and Black");
	}

	@Override
	public boolean decreaseHappinessRandomly() {
		Random random = new Random();
		int decreaseAmount = random.nextInt(10) + 5;
		happiness -= decreaseAmount;
		if (happiness <= 0) {
			happiness = 0; // Ensure happiness doesn't go below 0
			return true; // Return true to indicate that happiness reached 0 or less
		}
		return false; // Return false if happiness is still above 0
	}

	@Override
	public String toString() {
		return "Panda Bears [name=" + name + ", age=" + age + ", weight=" + weight + ", gender=" + gender + ", color="
				+ color + " ,happiness=" + happiness + "]";
	}
}