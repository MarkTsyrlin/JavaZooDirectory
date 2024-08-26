package zoo;

import java.util.ArrayList;

public interface PenguinListManagment {

	// Method to add a penguin to the system
	void addPenguin(Penguin penguin);

	// Method to print all penguins in the system
	void displayPenguins();

	// Method to get the total number of penguins in the system
	int getTotalPenguins();

	// Method to remove penguins that have expired or are unhappy
	ArrayList<Penguin> removeExpiredPenguins();

	// Method to find the tallest penguin in the system
	Penguin findTallestPenguin();

}
