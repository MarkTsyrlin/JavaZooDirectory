package zoo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import comparators.PenguinNameComparator;
import comparators.PenguinAgeComparator;
import comparators.PenguinHeightComparator;

enum SortingCriteria {
	NAME_ASCENDING, HEIGHT_DESCENDING, AGE_ASCENDING
}

public class PenguinList implements PenguinListManagment {
	private List<Penguin> penguinList;
	private String noise;
	private static SortingCriteria sortingCriteria;

	// private Comparator<Penguin> lastComparator;

	public PenguinList() {
		penguinList = new ArrayList<>();
		this.sortingCriteria = SortingCriteria.NAME_ASCENDING;
		this.noise = "squack";
	}

	public String getNoise() {
		return noise;
	}

	public List<Penguin> getPenguinList() {
		return penguinList;
	}

	public static void setSortingCriteria(SortingCriteria sortingCriteria) {
		PenguinList.sortingCriteria = sortingCriteria;
	}

	public void addPenguin(Penguin penguin) {
		BigDecimal minHeight = new BigDecimal("10");

		if (penguinList.isEmpty()) {
			// If the list is empty, any penguin can be added without comparison
			penguinList.add(penguin);
		} else {
			// Find the tallest penguin
			Penguin tallestPenguin = findTallestPenguin();

			// If there's a tallest penguin, set the maximum height
			BigDecimal maxHeight = (tallestPenguin != null) ? tallestPenguin.getHeight() : new BigDecimal("200");

			BigDecimal penguinHeight = penguin.getHeight();

			if (penguinHeight.compareTo(maxHeight) > 0 || penguinHeight.compareTo(minHeight) < 0) {
				throw new IllegalArgumentException("New penguin's height should be between " + minHeight + " and "
						+ maxHeight + "(The leader's height).");
			}

			// Add the penguin to the list
			penguinList.add(penguin);
		}

		// Sort the list based on the chosen criteria
		sortPenguins();
	}

	private void sortPenguins() {
		if (sortingCriteria == SortingCriteria.NAME_ASCENDING) {
			Collections.sort(penguinList, new PenguinNameComparator());
		} else if (sortingCriteria == SortingCriteria.HEIGHT_DESCENDING) {
			Collections.sort(penguinList, new PenguinHeightComparator().reversed());
		} else if (sortingCriteria == SortingCriteria.AGE_ASCENDING) {
			Collections.sort(penguinList, new PenguinAgeComparator());
		}

	}

	public void displayPenguins() {
		for (Penguin penguin : penguinList) {

			String height = penguin.getHeight().toString();
			System.out.println(String.format("Name: %-6s Age: %-3s Height: %-5s cm  Happiness: %-3s", penguin.getName(),
					penguin.getAge(), height, penguin.getHappiness()));
		}
	}

	public int getTotalPenguins() {
		return penguinList.size();
	}

	public Penguin findTallestPenguin() {
		if (penguinList.isEmpty()) {
			return null; // If the list is empty, return null
		}

		// Sort the penguin list by height in descending order
		Collections.sort(penguinList, new PenguinHeightComparator().reversed());

		// The tallest penguin will be the first one after sorting
		return penguinList.get(0);
	}

	public ArrayList<Penguin> removeExpiredPenguins() {
		boolean hasRemoved = false;
		Iterator<Penguin> iterator = penguinList.iterator();
		ArrayList<Penguin> penguinsRemoved = new ArrayList<Penguin>();
		while (iterator.hasNext()) {
			Penguin penguin = iterator.next();
			if (penguin.getAge() >= Penguin.LIFE_SPAN || penguin.getHappiness() <= 0) {
				penguinsRemoved.add(penguin);
				iterator.remove(); // Remove the penguin from the list

			}
		}
		return penguinsRemoved;
	}
}