package zoo;

import java.util.Random;

enum fishColour {
	BLACK, WHITE, GREEN, ORANGE, BLUE, YELLOW, BROWN, GOLD, RED, CYAN;
}

enum fishPattern {
	SMOOTH, DOTTED, STRIPES, SPOTS;
}

public class AquariumFish {
	protected int age;
	protected double length;
	protected String[] bodyColours;
	fishPattern pattern;
	public static double fishEatFood = 0;
	private String noise;
	public static final int LIFE_SPAN = 25;
	private int happiness = 100;

	public static int BLACKCount = 0, WHITECount = 0, GREENCount = 0, ORANGECount = 0, BLUECount = 0, YELLOWCount = 0,
			BROWNCount = 0, GOLDCount = 0, REDCount = 0, CYANCount = 0;

	public String getType() {
		return "Normal fish";
	}

	public int getAge() {
		return age;
	}

	public int getFinalMaxAge() {
		return LIFE_SPAN;
	}

	public double getLength() {
		return length;
	}

	public String[] getBodyColours() {
		return bodyColours;
	}

	public fishPattern getPattern() {
		return pattern;
	}

	public int getHappiness() {
		return happiness;
	}

	public static int[] getAllColoursCount() {
		int[] allColoursCount = { BLACKCount, WHITECount, GREENCount, ORANGECount, BLUECount, YELLOWCount, BROWNCount,
				GOLDCount, REDCount, CYANCount };
		return allColoursCount;
	}

	public AquariumFish(int age, double length, String[] bodyColours, fishPattern pattern) {

		if (age < 0 || age >= LIFE_SPAN || length <= 0 || pattern == null || bodyColours == null) {
			return;
		}

		this.age = age;
		this.length = length;
		this.bodyColours = bodyColours;
		this.pattern = pattern;
		this.noise = "blob";
		foodForFish(age, length);
		coloursCounter(bodyColours);

	}

	public String getNoise() {
		return noise;
	}

	public static void coloursCounter(String[] colours) {
		for (String color : colours) {
			// Increment the count based on the color
			switch (fishColour.valueOf(color)) {
			case BLACK:
				BLACKCount++;
				break;
			case YELLOW:
				YELLOWCount++;
				break;
			case WHITE:
				WHITECount++;
				break;
			case GREEN:
				GREENCount++;
				break;
			case ORANGE:
				ORANGECount++;
				break;
			case BLUE:
				BLUECount++;
				break;
			case BROWN:
				BROWNCount++;
				break;
			case GOLD:
				GOLDCount++;
				break;
			case RED:
				REDCount++;
				break;
			case CYAN:
				CYANCount++;
				break;
			default:
				// Handle unknown colors or any other logic
				break;
			}
		}
	}

	public void foodForFish(int age, double length) {
		if (age < 3)
			fishEatFood = fishEatFood + 3;

		else {
			fishEatFood = fishEatFood + length;
		}
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

}
