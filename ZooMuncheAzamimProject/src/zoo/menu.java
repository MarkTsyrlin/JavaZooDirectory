package zoo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import comparators.PenguinAgeComparator;
import comparators.PenguinHeightComparator;
import comparators.PenguinNameComparator;

public class menu {

	// -------------------------------InitializedAnimals-----------------------------------------//
	private static List<Lions> existingLions = Arrays.asList(new Lions("Nala", 3, 100, "Male"),
			new Lions("Jacob", 12, 100, "Male"), new Lions("Racon", 7, 90, "Female"),
			new Lions("Igris", 10, 150, "Female"));

	private static List<Tiger> existingTiger = Arrays.asList(new Tiger("Ted", 7, 100, "Male"),
			new Tiger("Shalev", 11, 100, "Male"), new Tiger("Bakura", 7, 90, "Female"),
			new Tiger("Kira", 13, 100, "Female"));

	private static List<Penguin> existingPenguins = Arrays.asList(new Penguin(1, new BigDecimal("200.0"), "Coco"),
			new Penguin(3, new BigDecimal("190.5"), "Lola"), new Penguin(2, new BigDecimal("100.2"), "Didi"));

	private static List<Bear> existingBears = Arrays.asList(new Bear("Baloo", 16, 350, "Male", "Brown"),
			new Bear("Yogi", 15, 250, "Female", "Brown"));

	private static List<PolarBear> existingPolarBears = Arrays.asList(
			new PolarBear("Misha", 12, 180, "Female", "White"), new PolarBear("Paddington", 13, 100, "Male", "White"));

	private static List<PandaBear> existingPandaBears = Arrays.asList(
			new PandaBear("Bili", 14, 300, "Male", "White and Black"),
			new PandaBear("Sandy", 13, 250, "Female", "White and Black"));

	public static void main(String[] args) {
		myZoo.addRandomFishes(10);
		Scanner scanner = new Scanner(System.in);
		int action = 0;
		final int ZOO_DETAILS = 1;
		final int SORT_PENGUINS = 2;
		final int SHOW_ALL_PENGUINS = 3;
		final int ADD_PENGUINS = 4;
		final int SHOW_ALL_PREDATORS = 5;
		final int ADD_PREDATORS = 6;
		final int SHOW_ALL_FISHES_AND_COLOURS = 7;
		final int ADD_FISH = 8;
		final int FEED_THE_ANIMALS = 9;
		final int PLAY_SOUND = 10;
		final int SHOW_ALL_BEARS = 11;
		final int ADD_BEARS = 12;
		final int AGE_ONE_YEAR = 13;
		final int EXIT = 0;

		do {
			printMenuOptions();
			action = readInRange(0, 13, scanner);
			switch (action) {
			case ZOO_DETAILS:
				displayZooData(myZoo);
				break;
			case SORT_PENGUINS:
				chooseHowToSortPenguins(scanner);
				;
				break;
			case SHOW_ALL_PENGUINS:
				myZoo.PrintPenguin();
				break;
			case ADD_PENGUINS:
				inputPenguin(scanner);
				break;
			case SHOW_ALL_PREDATORS:
				printAllPredators();
				break;
			case ADD_PREDATORS:
				inputPredator(scanner);
				break;
			case SHOW_ALL_FISHES_AND_COLOURS:
				printAquariumFishDetails(myZoo);
				printAllColoursInAquarim();
				printTwoMostPopularColours();
				break;
			case ADD_FISH:
				askHowManyFishes(scanner);
				break;
			case FEED_THE_ANIMALS:
				displayAmountOfConsumedFoodAtTheZoo();
				myZoo.raiseHappinessTo100();
				myZoo.raiseHappinessTo100ToPenguin();
				break;
			case PLAY_SOUND:
				playSoundOfAllAnimals();
				break;
			case SHOW_ALL_BEARS:
				printAllBears();
				break;
			case ADD_BEARS:
				chooseBearToAdd(scanner);
				break;
			case AGE_ONE_YEAR:
				myZoo.ageByOneYear();
				printAllRemovedAnimals();
				PrintAgeOneYearMessage();
				break;
			case EXIT:
				System.out.println("Thank you");
				scanner.close();
				break;
			}
		} while (action != EXIT);
	}

	// -----------------------------------------------------------------------------------------------------------------//

	static Zoo myZoo = new Zoo("Our Zoo", "Afeka Tel-Aviv", existingLions, existingTiger, existingPenguins,
			existingBears, existingPolarBears, existingPandaBears);

	public static void printMenuOptions() {
		System.out.println(" ");
		System.out.println("1.Print zoo details");
		System.out.println("2.Sort penguins");
		System.out.println("3.Print the penguins");
		System.out.println("4.Add penguin");
		System.out.println("5.Print all the predators");
		System.out.println("6.Add a predator");
		System.out.println("7.Print the fishes");
		System.out.println("8.Add fish");
		System.out.println("9.Feed the animals");
		System.out.println("10.Hear the animals");
		System.out.println("11.Print all bears");
		System.out.println("12.Add Bear");
		System.out.println("13.Age by one year");
		System.out.println("0.exit the program");
	}

	public static void displayZooData(Zoo zoo) {
		System.out.println("Zoo Name: " + zoo.getName());
		System.out.println("Zoo Address: " + zoo.getAddress());
		printNumOfEachAnimal();
	}

	public static void printNumOfEachAnimal() {
		System.out.println("The number of lions at the zoo is: " + myZoo.currentLionsInArray);
		System.out.println("The number of tigers at the zoo is: " + myZoo.currentTigerInArray);
		System.out.println("The number of penguins at the zoo: " + myZoo.numOfPenguins());
		System.out.println("The number of Clown fishes at the zoo is: " + myZoo.ClownFishCounter);
		System.out.println("The number of Gold fishes at the zoo is: " + myZoo.GoldFishCounter);
		System.out.println("The number of Normal fishes at the zoo is: " + myZoo.normalFishCounter);
		System.out.println("The number of Brown bears at the zoo is: " + myZoo.currentBearInArray);
		System.out.println("The number of Polar bears at the zoo is: " + myZoo.currentPolarBearInArray);
		System.out.println("The number of Panda bears at the zoo is: " + myZoo.currentPandaBearInArray);
	}

	public static void displayAmountOfConsumedFoodAtTheZoo() {
		System.out.println("The lions ate " + myZoo.feedLions() + " meat kg");
		System.out.println("The tigers ate " + myZoo.feedTiger() + " meat kg");
		System.out.println("The penguins ate " + myZoo.feedPenguins() + " fishes");
		double totalFoodAte = myZoo.HowMuchFishAte();
		System.out.println("the Aquarium fishes ate: " + myZoo.HowMuchFishAte() + " dishes of fish food");
		System.out.println("The Brown bear ate " + myZoo.feedBear() + " meat kg");
		System.out.println("The Polar bear ate " + myZoo.feedPolarBear() + " meat kg");
		System.out.println("The Panda bear ate " + myZoo.feedPanda() + "  Bamboks kg");
	}

	public static void playSoundOfAllAnimals() {
		boolean isFirst = true;

		for (Penguin penguin : myZoo.getPenguins().getPenguinList()) {
			System.out.print(myZoo.getPenguins().getNoise() + ", ");
		}

		for (int i = 0; i < myZoo.currentLionsInArray; i++) {
			System.out.print(myZoo.lionsArr[0].getNoise() + ", ");
		}

		for (int i = 0; i < myZoo.currentTigerInArray; i++) {
			System.out.print(myZoo.tigerArr[0].getNoise() + ", ");
		}

		for (int i = 0; i < myZoo.currentBearInArray; i++) {
			System.out.print(myZoo.bearsArr[0].getNoise() + ", ");
		}

		for (int i = 0; i < myZoo.currentPandaBearInArray; i++) {
			System.out.print(myZoo.pandaBearsArr[0].getNoise() + ", ");
		}

		for (int i = 0; i < myZoo.currentPolarBearInArray; i++) {
			System.out.print(myZoo.polarBearsArr[0].getNoise() + ", ");
		}

		for (AquariumFish fish : myZoo.getAquariumFish()) {
			if (!isFirst) {
				System.out.print(", ");
			}
			System.out.print(fish.getNoise());
			isFirst = false;
		}

	}

	public static <T extends Number> T readInRange(T min, T max, Scanner scan) {
		T value = null;
		boolean finished = false;
		while (!finished) {
			try {
				if (min instanceof Integer) {
					value = (T) Integer.valueOf(scan.nextInt());
				} else if (min instanceof Double) {
					value = (T) Double.valueOf(scan.nextDouble());
				} else if (min instanceof Long) {
					value = (T) Long.valueOf(scan.nextLong());
				} else if (min instanceof BigDecimal) {
					value = (T) new BigDecimal(scan.nextBigDecimal().toString());
				}
				if (value != null && min.doubleValue() <= value.doubleValue()
						&& value.doubleValue() <= max.doubleValue()) {
					finished = true;
				} else {
					System.out.println("Please enter a value between " + min + " and " + max + ".");
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid value(number).");
				scan.nextLine();
			}
		}
		scan.nextLine();
		return value;
	}

	public static void PrintAgeOneYearMessage() {
		System.out.println("");
		System.out.println("All animals have aged by one year.");
		System.out.println("Their happiness index was reduced :( ");
		System.out.println("");
	}

	public static void printAllRemovedAnimals() {
		System.out.println("");
		for (Penguin penguin : myZoo.agePenguinOneYear()) {
			System.out.println("Penguin " + penguin.getName() + " has removed");
		}

		for (Lions lion : myZoo.removeLionIfReachedLifespan()) {
			System.out.println("Lion " + lion.getName() + " has removed");
		}
		for (Tiger tiger : myZoo.removeTigerIfReachedLifespan()) {
			System.out.println("Tiger " + tiger.getName() + " has removed");
		}
		for (Bear bear : myZoo.removeNormalBearIfReachedLifespan()) {
			System.out.println("Removed normal bear " + bear.getName());
		}
		for (PolarBear polarBear : myZoo.removePolarBearIfReachedLifespan()) {
			System.out.println("Removed polar bear " + polarBear.getName());
		}
		for (PandaBear pandaBear : myZoo.removePandaBearIfReachedLifespan()) {
			System.out.println("Removed panda bear " + pandaBear.getName());
		}
		// Print removed fishes
		for (AquariumFish fish : myZoo.removeFishIfReachedLifespanOrHappinessZero()) {
			System.out.println("Removed " + fish.getType());
		}

	}
	// -------------------------------Penguin-----------------------------------------//

	public static void chooseHowToSortPenguins(Scanner scan) {
		int choice;
		System.out.println("Please choose how you would like to sort the penguins:");
		System.out.println("1. Sort by name from A-Z");
		System.out.println("2. Sort by height (higher-lower)");
		System.out.println("3. Sort by age (lower-higher)");
		choice = readInRange(1, 3, scan);
		if (choice == 1) {
			List<Penguin> sortablePenguinList = myZoo.getPenguins().getPenguinList();
			Collections.sort(sortablePenguinList, new PenguinNameComparator());
			PenguinList.setSortingCriteria(SortingCriteria.NAME_ASCENDING);
		} else if (choice == 2) {
			List<Penguin> sortablePenguinList = myZoo.getPenguins().getPenguinList();
			Collections.sort(sortablePenguinList, new PenguinHeightComparator().reversed());
			PenguinList.setSortingCriteria(SortingCriteria.HEIGHT_DESCENDING);
		} else {
			List<Penguin> sortablePenguinList = myZoo.getPenguins().getPenguinList();
			Collections.sort(sortablePenguinList, new PenguinAgeComparator());
			PenguinList.setSortingCriteria(SortingCriteria.AGE_ASCENDING);
		}
	}

	public static void inputPenguin(Scanner scan) {
		boolean addMorePenguins = true;
		do {
			boolean isValid = false;
			while (!isValid) {
				try {
					System.out.println("Enter the penguin's name:");
					String name = scan.next();
					System.out.println("Enter the penguin's age:");
					int age = readInRange(0, 1000, scan);
					System.out.println("Enter the penguin's height:");
					BigDecimal minHeight = new BigDecimal("10");
					BigDecimal maxHeight = new BigDecimal("210");
					BigDecimal height = readInRange(minHeight, maxHeight, scan);

					Penguin newPenguin = new Penguin(age, height, name);
					myZoo.getPenguins().addPenguin(newPenguin); // Add penguin to the list

					System.out.println("Penguin added successfully!");
					isValid = true;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid age and height.");
					scan.nextLine();
				} catch (IllegalArgumentException e) {
					System.out.println("Error adding penguin: " + e.getMessage());
					break; // Break out of the loop
				}
			}
			System.out.println("");
			System.out.println("Would you like to add another penguin? (1 for Yes, 0 for No)");
			int choice = scan.nextInt();
			if (choice != 1) {
				addMorePenguins = false;
			}
		} while (addMorePenguins);
	}

	// -------------------------------Lion-----------------------------------------//

	public static void inputPredator(Scanner scan) {
		System.out.println("Press 1 to add lions");
		System.out.println("Press 2 to add tigers");
		int TypeOfPredators = scan.nextInt();

		String typeOfPredatorName = ""; // Declared outside the if-else block

		if (TypeOfPredators == 1) {
			typeOfPredatorName = "Lion";
		} else if (TypeOfPredators == 2) {
			typeOfPredatorName = "Tiger";
		} else {
			System.out.println("Invalid number");
			inputPredator(scan);
			return;
		}

		int numOfPossibleInputLions = myZoo.ARRAYSIZE - (myZoo.currentLionsInArray);
		int numOfPossibleInputTiger = myZoo.ARRAYSIZE - (myZoo.currentTigerInArray);

		System.out.println(" ");
		System.out.println("Enter " + typeOfPredatorName + " details:");
		System.out.println("How many " + typeOfPredatorName + " do you want to add?");
		int numOfPredatorsToAdd = scan.nextInt();

		if (numOfPredatorsToAdd > numOfPossibleInputLions && (TypeOfPredators == 1)) {
			System.out.println(
					"The number of lions to add cannot be more than " + numOfPossibleInputLions + ", try again");
			inputPredator(scan);
			return;
		}

		if (numOfPredatorsToAdd > numOfPossibleInputTiger && (TypeOfPredators == 2)) {
			System.out.println(
					"The number of tigers to add cannot be more than " + numOfPossibleInputTiger + ", try again");
			inputPredator(scan);
			return;
		}
		while (numOfPredatorsToAdd > 0) {
			try {
				System.out.println("Please enter " + typeOfPredatorName + " name:");
				String name = scan.next();
				System.out.println("Please enter " + typeOfPredatorName + "'s age:");
				int age = readInRange(1, 100, scan);
				System.out.println("Please enter " + typeOfPredatorName + "'s weight:");
				double weight = readInRange(1.0, 999.9, scan);
				String gender;
				do {
					System.out.println("Please enter " + typeOfPredatorName + "'s gender (Male/Female):");
					gender = scan.next();
					if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
						System.out.println("Invalid gender. It should be 'Male' or 'Female'.");
					}
				} while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"));
				System.out.println("-----------------------");

				if (typeOfPredatorName.equals("Lion")) {
					myZoo.lionsArr[myZoo.currentLionsInArray++] = new Lions(name, age, weight, gender);

				} else if (typeOfPredatorName.equals("Tiger")) {
					// Code to add Tiger
					myZoo.tigerArr[myZoo.currentTigerInArray++] = new Tiger(name, age, weight, gender);
				}
				numOfPredatorsToAdd--;
				System.out.println("The " + typeOfPredatorName + " was added successfully.");
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid age entered: " + e.getMessage());
				System.out.println("Please try again.");
			}
		}
	}

	// -------------------------------Tiger-----------------------------------------//

	public static void printAllPredators() {
		for (int i = 0; i < myZoo.currentLionsInArray; i++) {
			System.out.println(myZoo.lionsArr[i]);
		}

		System.out.println(" ");

		for (int i = 0; i < myZoo.currentTigerInArray; i++) {
			System.out.println(myZoo.tigerArr[i]);
		}

		System.out.println(" ");
	}

	// --------------------------------BEAR-----------------------------------------//

	public static void chooseBearToAdd(Scanner scan) {
		int choise = 0;
		System.out.println("Press 1 to add Brown bear");
		System.out.println("Press 2 to add Polar bear");
		System.out.println("Press 3 to add Panda bear");
		choise = readInRange(1, 3, scan);
		if (choise > 0 && choise < 4) {
			inputBear(scan, choise);
		}

	}

	public static void inputBear(Scanner scan, int type) {
		System.out.println(" ");
		System.out.println("Enter bear details:");
		System.out.println("Please enter bear name");
		String name = scan.next();
		System.out.println("Please enter bear age");
		int age = readInRange(1, 19, scan);
		System.out.println("Please enter bear weight");
		double weight = readInRange(1.0, 999.9, scan);
		String gender;
		do {
			System.out.println("Please enter bear's gender (Male/Female):");
			gender = scan.next();
			if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
				System.out.println("Invalid gender. It should be 'Male' or 'Female'.");
			}
		} while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"));
		System.out.println("-----------------------");

		switch (type) {
		case 1:
			myZoo.bearsArr[myZoo.currentBearInArray++] = new Bear(name, age, weight, gender, "Brown");
			break;
		case 2:
			myZoo.polarBearsArr[myZoo.currentPolarBearInArray++] = new PolarBear(name, age, weight, gender, "White");
			break;
		case 3:
			myZoo.pandaBearsArr[myZoo.currentPandaBearInArray++] = new PandaBear(name, age, weight, gender,
					"White and Black");
			break;
		default:
			System.out.println("Invalid bear type.");
			return;
		}
		System.out.println("The bear was added successfully.");
	}

	public static void printAllBears() {
		for (int i = 0; i < myZoo.currentBearInArray; i++) {
			System.out.println(myZoo.bearsArr[i]);
		}

		System.out.println(" ");

		for (int i = 0; i < myZoo.currentPandaBearInArray; i++) {
			System.out.println(myZoo.pandaBearsArr[i]);
		}

		System.out.println(" ");

		for (int i = 0; i < myZoo.currentPolarBearInArray; i++) {
			System.out.println(myZoo.polarBearsArr[i]);
		}

		System.out.println(" ");
	}

	// -------------------------------FISH-----------------------------------------//

	public static void askHowManyFishes(Scanner scan) {

		System.out.println("TO add random fishes press 1");
		System.out.println("TO add specific fish press 2");
		int userChoise = scan.nextInt();
		if (userChoise == 2) {
			askUserForSpecificFish(scan);
			return;
		}
		if (userChoise == 1) {
			System.out.println("How many fishes do you want to add randomly?");
			int numberOfRandomFishes = scan.nextInt();
			if (numberOfRandomFishes > 10) {
				System.out.println("I am sorry but you ask for too many fishes, not enough place in the aquarium :(");
				System.out.println();
				System.out.println("I added 10 fishes instead");
				numberOfRandomFishes = 10;
			}
			System.out.println("The fishes added successfully.");
			myZoo.addRandomFishes(numberOfRandomFishes);
		} else {
			return;
		}
	}

	public static void askUserForSpecificFish(Scanner scan) {
		System.out.println("Choose the fish type you would like to add-");
		System.out.println("1.normal fish.");
		System.out.println("2.Clowm fish.");
		System.out.println("3.Gold fish.");
		int fishKind = scan.nextInt();
		int i = 0;
		System.out.println("Enter the details for a spesific fish:");

		System.out.println("Enter fish age:");
		int age = readInRange(0, 100, scan);

		System.out.println("Enter fish length (for gold fish max 10 cm):");
		double length = readInRange(0.0, 20.0, scan);

		switch (fishKind) {

		case 1:
			makeNormalFish(fishKind, age, length, scan);
			break;

		case 2:
			// Code for adding Clown fish
			makeClownFish(fishKind, age, length, scan);
			break;

		case 3:
			// Code for adding Gold fish
			if (length <= 10) {
				makeGoldFish(fishKind, age, length, scan);
				break;
			} else {
				System.out.println("invaild length for gold fish");
				return;
			}
		default:
			System.out.println("Invalid input");
			break;
		}
		System.out.println("The fish added successfully");

	}

	public static void makeNormalFish(int fishKind, int age, double length, Scanner scan) {
		fishColour[] selectedColor = new fishColour[3];
		int numOfColors = 0;
		while (numOfColors < 3) {
			if (numOfColors != 0)
				System.out.println("for add one more colour press 1 else  press any key");
			if (numOfColors == 0 || scan.nextInt() == 1) {
				// Display menu for colors
				displayColoursMenu();
				System.out.println("Choose a fish color " + (numOfColors + 1) + " :");

				int colorChoice = scan.nextInt();
				fishColour[] allColors = fishColour.values();

				if (colorChoice < 1 || colorChoice > allColors.length) {
					System.out.println("Invalid color choice. Please choose a valid color.");
					askUserForSpecificFish(scan);
					return;
				}

				selectedColor[numOfColors] = allColors[colorChoice - 1];
				myZoo.chosenColours[myZoo.counterOfChosenColours] = selectedColor[numOfColors].name();
				myZoo.counterOfChosenColours++;

				numOfColors++;
			} else {
				break;
			}
		}

		// Display menu for patterns
		System.out.println("Choose a fish pattern:");
		displayPatternMenu();

		int patternChoice = scan.nextInt();
		fishPattern[] allPatterns = fishPattern.values();

		if (patternChoice < 1 || patternChoice > allPatterns.length) {
			System.out.println("Invalid pattern choice. Please choose a valid pattern.");
			askUserForSpecificFish(scan);
			return;
		}

		fishPattern selectedPattern = allPatterns[patternChoice - 1];
		myZoo.addSpecificFish(fishKind, age, length, selectedColor, selectedPattern);
		Zoo.normalFishCounter++;

	}

	public static void makeClownFish(int fishKind, int age, double length, Scanner scan) {
		int numOfColors = 0;
		fishColour[] selectedColorForClown = new fishColour[3];
		selectedColorForClown[0] = fishColour.ORANGE;
		selectedColorForClown[1] = fishColour.BLACK;
		selectedColorForClown[2] = fishColour.WHITE;

		myZoo.chosenColours[myZoo.counterOfChosenColours] = selectedColorForClown[numOfColors].name();
		myZoo.counterOfChosenColours++;
		myZoo.addSpecificFish(fishKind, age, length, selectedColorForClown, fishPattern.STRIPES);
	}

	public static void makeGoldFish(int fishKind, int age, double length, Scanner scan) {
		int numOfColors = 0;
		if (length > 10) {
			System.out.println("Invalid length for gold FISH Please choose a valid length.");
			askUserForSpecificFish(scan);
		}
		fishColour[] selectedColorForGold = new fishColour[1];
		// Display menu for colors
		displayColoursMenuForGold(); // need to change for gold fish
		System.out.println("Choose Gold fish color: ");

		int colorChoice = scan.nextInt();

		switch (colorChoice) {
		case 1:
			colorChoice = 4;
			break;
		case 2:
			colorChoice = 8;
			break;
		case 3:
			colorChoice = 1;
			break;
		default:
			colorChoice = 6;
			break;
		}

		fishColour[] allColors = fishColour.values();

		selectedColorForGold[numOfColors] = allColors[colorChoice - 1];
		myZoo.chosenColours[myZoo.counterOfChosenColours] = selectedColorForGold[numOfColors].name();
		myZoo.counterOfChosenColours++;
		myZoo.addSpecificFish(fishKind, age, length, selectedColorForGold, fishPattern.SMOOTH); // >> for gold
																								// fish
	}

	public static void printAquariumFishDetails(Zoo zoo) {
		for (AquariumFish fish : zoo.getAquariumFish()) {
			System.out.println("Type: " + fish.getType());
			System.out.println("Age: " + fish.getAge());
			System.out.println("Length: " + fish.getLength());
			System.out.print("Body Colors: [");

			boolean isFirst = true;
			for (String colour : fish.getBodyColours()) {
				if (colour != null) {
					if (!isFirst) {
						System.out.print(", ");
					}
					System.out.print(colour);
					isFirst = false;
				}
			}

			System.out.println("]");
			System.out.println("Pattern: " + fish.getPattern());
			System.out.println("Happiness: " + fish.getHappiness());
			System.out.println("---------------------------");
		}
	}

	public static void printAllColoursInAquarim() {
		System.out.println("All the colours in the aquarium-");
		String[] colours = myZoo.printAllColoursInAquarim();

		// Filter out null elements from the array
		List<String> nonNullColours = new ArrayList<>();
		for (String colour : colours) {
			if (colour != null) {
				nonNullColours.add(colour);
			}
		}
		Collections.sort(nonNullColours);
		for (int i = 0; i < nonNullColours.size(); i++) {
			System.out.println((i + 1) + ". " + nonNullColours.get(i));
		}
	}

	public static void printTwoMostPopularColours() {
		System.out.println();
		String[] mostPopularColours = myZoo.twoMostPopularColours();

		if (mostPopularColours[1] != null) {
			System.out.println("The two most popular colours in the aquarium are " + mostPopularColours[0] + " + "
					+ mostPopularColours[1]);
		} else {
			System.out.println("The most popular color in the aquarium is " + mostPopularColours[0]);
		}
	}

	public static void displayColoursMenu() {
		int i = 1;
		for (fishColour color : fishColour.values()) {
			System.out.println(i + ". " + color);
			i++;
		}
	}

	public static void displayColoursMenuForGold() {
		int i = 1;
		for (GoldFishBodyColours color : GoldFishBodyColours.values()) {
			System.out.println(i + ". " + color);
			i++;
		}
	}

	// orange , gold, black, yellow
	public static void displayPatternMenu() {
		int i = 1;
		for (fishPattern pattern : fishPattern.values()) {
			System.out.println(i + ". " + pattern);
			i++;
		}
	}

}