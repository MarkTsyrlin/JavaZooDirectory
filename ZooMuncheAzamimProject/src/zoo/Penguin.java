package zoo;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Random;

public class Penguin {
	private int age;
	private BigDecimal height;
	private String name;
	private double foodAmount;
	public static final int LIFE_SPAN = 6;
	private int happiness = 100;
	protected int count = 0;

	public Penguin(int age, BigDecimal height, String name) {
		if (age < 0 || age > LIFE_SPAN) {
			throw new IllegalArgumentException(
					"Invalid age: " + age + ". Age must be between 0 and " + LIFE_SPAN + ".");
		}
		if (height.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Invalid height: " + height + ". Height cannot be negative.");
		}
		this.age = age;
		this.height = height;
		this.name = name;
		this.foodAmount = 1.0;
		count++;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public double getFoodAmount() {
		return foodAmount;
	}

	public boolean ageByOneYear() {
		age++;
		if (age >= LIFE_SPAN) {
			return false; // Penguin has reached its lifespan
		}
		decreaseHappinessRandomly();
		return true; // Penguin is still alive
	}

	public int getHappiness() {
		return happiness;
	}

	public void resetHappinessByFeedingPenguin() {
		// Reset happiness to 100 when the penguin is fed
		happiness = 100;
	}

	private void decreaseHappinessRandomly() {
		Random random = new Random();
		int decreaseAmount = random.nextInt(16) + 5; // Generates a random number between 5 and 20
		happiness -= decreaseAmount;
		if (happiness < 0) {
			happiness = 0; // Ensure happiness doesn't go below 0
		}
	}

}