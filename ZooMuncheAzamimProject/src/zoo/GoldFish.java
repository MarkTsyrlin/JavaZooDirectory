package zoo;

enum GoldFishBodyColours {
	ORANGE, BLACK, GOLD, YELLOW;
}

public class GoldFish extends AquariumFish {

	private static String[] GoldFishBodyColours;
	public static final int LIFE_SPAN=12;


	@Override
	public String getType() {
		return "Gold fish";
	}

	@Override
	public void foodForFish(int age, double length) {
		fishEatFood++;
	}
	@Override
	public int getFinalMaxAge() {
		return LIFE_SPAN;	
		}
	 
	public GoldFish(int age, double length, String[] GoldFishBodyColours, fishPattern pattern) {
		super(age, length, GoldFishBodyColours, fishPattern.SMOOTH);
		this.length = length;
		this.GoldFishBodyColours = GoldFishBodyColours;
		this.pattern = pattern;
		Zoo.GoldFishCounter++;
	}
}
