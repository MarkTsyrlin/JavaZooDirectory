package zoo;

import java.util.Random;

public class PolarBear extends Bear {
	public static int PolarBearEatFood = 0;
	public static final int LIFE_SPAN = 20;
	private int happiness = 100;

	@Override
	public String getType() {
		return "Polar Bear";
	}

	@Override
	public int foodAteByBear() {
		PolarBearEatFood += (int) (weight / 2);
		return (int) (weight / 2);
	}

	@Override
	public String getNoise() {
		return "GROOOOOOOOOOWLLL";
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean decreaseHappinessRandomly() {
		Random random = new Random();
		int decreaseAmount = random.nextInt(18) + 5;
		happiness -= decreaseAmount;
		if (happiness <= 0) {
			happiness = 0; // Ensure happiness doesn't go below 0
			return true; // Return true to indicate that happiness reached 0 or less
		}
		return false; // Return false if happiness is still above 0
	}

	public int getHappiness() {
		return happiness;
	}

	public PolarBear(String name, int age, double weight, String gender, String color) {
		super(name, age, weight, gender, "White");

	}

	@Override
	public String toString() {
		return "Polar Bears [name=" + name + ", age=" + age + ", weight=" + weight + ", gender=" + gender + ", color="
				+ color + " ,happiness=" + happiness + "]";
	}
}
