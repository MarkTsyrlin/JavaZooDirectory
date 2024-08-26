package zoo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Zoo {

	private String name;
	private String address;
	private PenguinList penguins;
	public final int ARRAYSIZE = 1000;
	protected Lions[] lionsArr;
	protected Tiger[] tigerArr;
	protected int currentLionsInArray = 0;
	protected int currentTigerInArray = 0;
	private ArrayList<AquariumFish> aquariumFish;
	protected Bear[] bearsArr;
	protected PandaBear[] pandaBearsArr;
	protected PolarBear[] polarBearsArr;
	protected int currentBearInArray = 0;
	protected int currentPandaBearInArray = 0;
	protected int currentPolarBearInArray = 0;
	static int fishCounter = 0;
	static int GoldFishCounter = 0;
	static int ClownFishCounter = 0;
	static int normalFishCounter = 0;
	protected String[] chosenColours = new String[100];;
	protected int counterOfChosenColours = 0;

	public Zoo(String name, String address, List<Lions> existingLions, List<Tiger> existingTiger,
			List<Penguin> existingPenguins, List<Bear> existingBears, List<PolarBear> existingPolarBears,
			List<PandaBear> existingPandaBears) {
		this.tigerArr = new Tiger[ARRAYSIZE];
		this.lionsArr = new Lions[ARRAYSIZE];
		this.bearsArr = new Bear[ARRAYSIZE];
		this.pandaBearsArr = new PandaBear[ARRAYSIZE];
		this.polarBearsArr = new PolarBear[ARRAYSIZE];

		for (Lions lion : existingLions) {
			lionsArr[currentLionsInArray++] = lion;
		}

		for (Tiger tiger : existingTiger) {
			tigerArr[currentTigerInArray++] = tiger;
		}

		for (Bear bear : existingBears) {
			bearsArr[currentBearInArray++] = bear;
		}

		for (PolarBear polarBear : existingPolarBears) {
			polarBearsArr[currentPolarBearInArray++] = polarBear;
		}

		for (PandaBear pandaBear : existingPandaBears) {
			pandaBearsArr[currentPandaBearInArray++] = pandaBear;
		}

		this.name = name;
		this.address = address;
		this.penguins = new PenguinList();
		for (Penguin penguin : existingPenguins) {
			penguins.addPenguin(penguin);
		}
		this.aquariumFish = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void ageByOneYear() {
		for (int i = 0; i < currentLionsInArray; i++) {
			lionsArr[i].ageByOneYear();
		}
		for (int i = 0; i < currentTigerInArray; i++) {
			tigerArr[i].ageByOneYear();
		}
		for (AquariumFish fish : getAquariumFish()) {
			fish.ageByOneYear();
		}
		removeFishIfReachedLifespanOrHappinessZero();

		for (int i = 0; i < currentBearInArray; i++) {
			bearsArr[i].hasAgeByOneYear();
		}
		removeNormalBearIfReachedLifespan();
		for (int i = 0; i < currentPandaBearInArray; i++) {
			pandaBearsArr[i].hasAgeByOneYear();
		}
		removePandaBearIfReachedLifespan();
		for (int i = 0; i < currentPolarBearInArray; i++) {
			polarBearsArr[i].hasAgeByOneYear();
		}
		removePolarBearIfReachedLifespan();
	}

	public void raiseHappinessTo100() {
		for (int i = 0; i < currentLionsInArray; i++) {
			lionsArr[i].resetHappinessByFeedingPredator();
		}
		for (int i = 0; i < currentTigerInArray; i++) {
			tigerArr[i].resetHappinessByFeedingPredator();
			;
		}
		for (AquariumFish fish : getAquariumFish()) {
			fish.resetHappinessByFeedingPredator();
			;
		}
	}

	// -------------------------------Penguin-----------------------------------------//
	public void addInputPenguin(int age, BigDecimal height, String name) {
		Penguin newPenguin = new Penguin(age, height, name);
		penguins.addPenguin(newPenguin);
	}

	public void PrintPenguin() {
		penguins.displayPenguins();
	}

	public double feedPenguins() {
		return numOfPenguins();
	}

	public int numOfPenguins() {
		return penguins.getTotalPenguins();
	}

	public PenguinList getPenguins() {
		return penguins;
	}

	public ArrayList<Penguin> agePenguinOneYear() {
		for (Penguin penguin : getPenguins().getPenguinList()) {
			penguin.ageByOneYear();
		}
		return getPenguins().removeExpiredPenguins();
	}

	public void raiseHappinessTo100ToPenguin() {
		for (Penguin penguin : getPenguins().getPenguinList()) {
			penguin.resetHappinessByFeedingPenguin();

		}
	}

	// -------------------------------Lion-----------------------------------------//

	public double feedLions() {
		double meatAmount = 0.0;
		for (int i = 0; i < currentLionsInArray; i++) {
			meatAmount += lionsArr[i].CalculateConsumptionOfLion();
		}
		return meatAmount;
	}

	public List<Lions> removeLionIfReachedLifespan() {
		List<Lions> removedLions = new ArrayList<>();
		List<Lions> remainingLions = new ArrayList<>();
		for (int i = 0; i < currentLionsInArray; i++) {
			if (lionsArr[i].getAge() >= lionsArr[i].LIFE_SPAN || lionsArr[i].getHappiness() <= 0) {
				removedLions.add(lionsArr[i]);
			} else {
				remainingLions.add(lionsArr[i]);
			}
		}
		currentLionsInArray = remainingLions.size();
		lionsArr = remainingLions.toArray(new Lions[0]);
		return removedLions;
	}

	// -------------------------------Tiger----------------------------------------//

	public double feedTiger() {
		double meatAmount = 0.0;
		for (int i = 0; i < currentTigerInArray; i++) {
			meatAmount += tigerArr[i].CalculateConsumptionOfTiger();
		}
		return meatAmount;
	}

	public void raiseTigerHappinessTo100() {
		for (int i = 0; i < currentTigerInArray; i++) {
			tigerArr[i].ageByOneYear();
		}
	}

	public List<Tiger> removeTigerIfReachedLifespan() {
		List<Tiger> removedTigers = new ArrayList<>();
		List<Tiger> remainingTigers = new ArrayList<>();
		for (int i = 0; i < currentTigerInArray; i++) {
			if (tigerArr[i].getAge() >= tigerArr[i].LIFE_SPAN || tigerArr[i].getHappiness() <= 0) {
				removedTigers.add(tigerArr[i]);
			} else {
				remainingTigers.add(tigerArr[i]);
			}
		}
		currentTigerInArray = remainingTigers.size();
		tigerArr = remainingTigers.toArray(new Tiger[0]);
		return removedTigers;
	}

	// -------------------------------Bear-----------------------------------------//
	public int feedBear() {
		return Bear.BearEatFood;
	}

	public int feedPolarBear() {
		return PolarBear.PolarBearEatFood;
	}

	public int feedPanda() {
		return PandaBear.BambokConsaption;
	}

	public List<Bear> removeNormalBearIfReachedLifespan() {
		List<Bear> removedBears = new ArrayList<>();
		List<Bear> remainingBears = new ArrayList<>();
		for (int i = 0; i < currentBearInArray; i++) {
			if (bearsArr[i].getAge() >= Bear.LIFE_SPAN || bearsArr[i].getHappiness() <= 0) {
				removedBears.add(bearsArr[i]);
			} else {
				remainingBears.add(bearsArr[i]);
			}
		}
		currentBearInArray = remainingBears.size();
		bearsArr = remainingBears.toArray(new Bear[0]);
		return removedBears;
	}

	public List<PolarBear> removePolarBearIfReachedLifespan() {
		List<PolarBear> removedPolarBears = new ArrayList<>();
		List<PolarBear> remainingPolarBears = new ArrayList<>();
		for (int i = 0; i < currentPolarBearInArray; i++) {
			if (polarBearsArr[i].getAge() >= PolarBear.LIFE_SPAN) {
				removedPolarBears.add(polarBearsArr[i]);
			} else {
				remainingPolarBears.add(polarBearsArr[i]);
			}
		}
		currentPolarBearInArray = remainingPolarBears.size();
		polarBearsArr = remainingPolarBears.toArray(new PolarBear[0]);
		return removedPolarBears;
	}

	public List<PandaBear> removePandaBearIfReachedLifespan() {
		List<PandaBear> removedPandaBears = new ArrayList<>();
		List<PandaBear> remainingPandaBears = new ArrayList<>();
		for (int i = 0; i < currentPandaBearInArray; i++) {
			if (pandaBearsArr[i].getAge() >= PandaBear.LIFE_SPAN) {
				removedPandaBears.add(pandaBearsArr[i]);
			} else {
				remainingPandaBears.add(pandaBearsArr[i]);
			}
		}
		currentPandaBearInArray = remainingPandaBears.size();
		pandaBearsArr = remainingPandaBears.toArray(new PandaBear[0]);
		return removedPandaBears;
	}

	// -------------------------------FISH-----------------------------------------//

	public List<AquariumFish> removeFishIfReachedLifespanOrHappinessZero() {
		List<AquariumFish> removedFishes = new ArrayList<>();
		for (AquariumFish fish : aquariumFish) {
			if (fish.getAge() >= fish.getFinalMaxAge() || fish.getHappiness() <= 0) {
				System.out.println("One " + fish.getType() + " is removed");
				removedFishes.add(fish);
			}
		}
		aquariumFish.removeAll(removedFishes);
		return removedFishes;
	}

	public String[] printAllColoursInAquarim() {

		String[] finalColoursOfFishes = new String[10];
		int k = 0;

		for (int i = 0; i < counterOfChosenColours; i++) {
			boolean colorAlreadyExists = false;

			// Check if the color is already in the finalColoursOfFishes array
			for (int j = 0; j < k; j++) {
				if (finalColoursOfFishes[j] == (chosenColours[i])) {
					colorAlreadyExists = true;
					break;
				}
			}

			// If the color is not already in the array, add it
			if (!colorAlreadyExists && k < 10) {
				finalColoursOfFishes[k] = chosenColours[i];
				k++;
			}
		}
		return finalColoursOfFishes;
	}

	public static String[] twoMostPopularColours() {
		int[] allColoursCount = AquariumFish.getAllColoursCount();
		String[] mostCommonTwo = new String[2];
		int mostCommon = allColoursCount[0];
		int totalFishes = 0;
		int mostCommonLocal = 0;

		for (int count : allColoursCount) {
			totalFishes += count;
		}
		// Checking the most common color
		for (int i = 1; i < allColoursCount.length; i++) {
			if (mostCommon < allColoursCount[i]) {
				mostCommon = allColoursCount[i];
				mostCommonLocal = i;
			}
		}
		mostCommonTwo[0] = fishColour.values()[mostCommonLocal].toString();
		// Checking if there is only one color in the aquarium
		if (mostCommon == totalFishes) {
			mostCommonTwo[1] = null;
			return mostCommonTwo;
		}
		// Checking the second most common color
		int secondCommon = 0;
		int secondCommonLocal = 0;

		for (int i = 0; i < allColoursCount.length; i++) {
			if (i != mostCommonLocal && allColoursCount[i] > secondCommon) {
				secondCommon = allColoursCount[i];
				secondCommonLocal = i;
			}
		}
		mostCommonTwo[1] = fishColour.values()[secondCommonLocal].toString();
		return mostCommonTwo;
	}

	public void addRandomFishes(int n) {
		int sumNormal = 0, sumClown = 0, sumGold = 0;
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int choice = random.nextInt(3) + 1;

			switch (choice) {
			case 1:
				sumNormal++;
				break;
			case 2:
				sumClown++;
				break;
			case 3:
				sumGold++;
				break;
			}

		}
		addNormalFishes(sumNormal);
		addClownFishes(sumClown);
		addGoldFishes(sumGold);
	}

	public void addGoldFishes(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			double randomAge = Math.round((1.0 + random.nextDouble() * 10.0) * 10.0) / 10.0;
			double randomLength = Math.round((1.0 + random.nextDouble() * 10.0) * 10.0) / 10.0;
			String[] colourForGoldFish = { "ORANGE", "BLACK", "GOLD", "YELLOW" };
			String[] randomColor = new String[1];
			int randomFishColourIndex = random.nextInt(colourForGoldFish.length); // Generate random index
			randomColor[0] = colourForGoldFish[randomFishColourIndex]; // Get color at random index

			GoldFish fish = new GoldFish((int) randomAge, randomLength, randomColor, fishPattern.SMOOTH);
			this.aquariumFish.add(fish);
			chosenColours[counterOfChosenColours] = randomColor[0];
			counterOfChosenColours++;
		}
		fishCounter = fishCounter + n;

	}

	public void addClownFishes(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			double randomAge = Math.round((1.0 + random.nextDouble() * 10.0) * 10.0) / 10.0;
			double randomLength = Math.round((1.0 + random.nextDouble() * 20.0) * 10.0) / 10.0;

			String[] colourForClownFish = { "ORANGE", "BLACK", "WHITE" };

			ClownFish fish = new ClownFish((int) randomAge, randomLength, colourForClownFish, fishPattern.STRIPES);
			this.aquariumFish.add(fish);
			chosenColours[counterOfChosenColours] = colourForClownFish[0];
			chosenColours[counterOfChosenColours] = colourForClownFish[1];
			chosenColours[counterOfChosenColours] = colourForClownFish[2];

			counterOfChosenColours += 3;

		}
		fishCounter = fishCounter + n;
	}

	public void addNormalFishes(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			double randomAge = Math.round((1.0 + random.nextDouble() * 10.0) * 7.0) / 10.0;
			double randomLength = Math.round((1.0 + random.nextDouble() * 20.0) * 10.0) / 10.0;
			fishPattern randomPattern = fishPattern.values()[random.nextInt(fishPattern.values().length)];

			// Randomly select a number between 1 and 3 for the count of body colors
			int numberOfColors = random.nextInt(3) + 1;

			fishColour[] allColours = fishColour.values();
			Set<fishColour> chosenColors = new HashSet<>();
			String[] randomBodyColours = new String[numberOfColors];
			for (int j = 0; j < numberOfColors; j++) {
				fishColour randomColor;
				do {
					randomColor = allColours[random.nextInt(allColours.length)];
				} while (chosenColors.contains(randomColor)); // Check if color is already chosen
				chosenColors.add(randomColor);
				randomBodyColours[j] = randomColor.toString(); // Convert enum to string
				chosenColours[counterOfChosenColours] = randomBodyColours[j];
				counterOfChosenColours++;
			}
			AquariumFish fish = new AquariumFish((int) randomAge, randomLength, randomBodyColours, randomPattern);
			this.aquariumFish.add(fish);
		}
		fishCounter = fishCounter + n;
		normalFishCounter += n;
	}

	public boolean addSpecificFish(int type, int age, double length, fishColour[] colors, fishPattern pattern) {
		if (age < 0 || length < 0 || colors == null || pattern == null) {
			return false;
		}
		fishCounter++;

		Set<fishColour> chosenColors = new HashSet<>();
		for (fishColour color : colors) {
			if (color != null) {
				chosenColors.add(color); // Add each color to the set
			}
		}
		String[] bodyColours = new String[chosenColors.size()];
		int i = 0;
		for (fishColour color : chosenColors) {
			bodyColours[i++] = color.name(); // Convert colors to string and add to the bodyColours array
		}
		if (type == 2) {
			ClownFish fish = new ClownFish(age, length, bodyColours, pattern);
			this.aquariumFish.add(fish);
		} else if (type == 3) {
			GoldFish fish = new GoldFish(age, length, bodyColours, pattern);
			this.aquariumFish.add(fish);
		} else {
			AquariumFish fish = new AquariumFish(age, length, bodyColours, pattern);
			this.aquariumFish.add(fish);
		}
		return true;
	}

	public static int fishCount() {
		return fishCounter;
	}

	public ArrayList<AquariumFish> getAquariumFish() {
		return this.aquariumFish;
	}

	public static int HowMuchFishAte() {

		int sumOfFood = (int) AquariumFish.fishEatFood;

		return sumOfFood;
	}

}