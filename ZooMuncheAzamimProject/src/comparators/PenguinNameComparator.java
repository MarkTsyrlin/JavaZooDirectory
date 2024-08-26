package comparators;

import java.util.Comparator;

import zoo.Penguin;

public  class PenguinNameComparator implements Comparator<Penguin> {
	  @Override
	    public int compare(Penguin penguin1, Penguin penguin2) {
	        // Convert names to lowercase for case-insensitive comparison
	        String name1 = penguin1.getName().toLowerCase();
	        String name2 = penguin2.getName().toLowerCase();
	        
	      
	        return name1.compareTo(name2);
	    }

}