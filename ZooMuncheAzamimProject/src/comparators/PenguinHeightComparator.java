package comparators;

import java.util.Comparator;

import zoo.Penguin;

public class PenguinHeightComparator implements Comparator<Penguin> {

	@Override
	public int compare(Penguin penguin1, Penguin penguin2) {
		return penguin1.getHeight().compareTo(penguin2.getHeight());
	}

}