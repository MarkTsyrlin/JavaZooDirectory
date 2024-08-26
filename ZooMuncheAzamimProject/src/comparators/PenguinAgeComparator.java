package comparators;

import java.util.Comparator;

import zoo.Penguin;

public class PenguinAgeComparator implements Comparator<Penguin> {

	@Override
	public int compare(Penguin penguin1, Penguin penguin2) {
		return Integer.compare(penguin1.getAge(), penguin2.getAge());
	}

}
