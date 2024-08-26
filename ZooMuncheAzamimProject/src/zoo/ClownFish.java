package zoo;

public class ClownFish extends AquariumFish {
	private static String[] ClownFishBodyColours;
	
	public static final int LIFE_SPAN=8;

	@Override
	public String getType() {
		return "Clown fish";
	}

	@Override
	public void foodForFish(int age, double length) {
		fishEatFood += 2;
	}
	@Override
	public int getFinalMaxAge() {
		return LIFE_SPAN;	
		}
	
	public ClownFish(int age, double length, String[] ClownFishBodyColours, fishPattern pattern) {
		super(age, length, ClownFishBodyColours, fishPattern.STRIPES);
		// Set specific attributes for clownfish
		ClownFishBodyColours[0] = "ORANGE";
		ClownFishBodyColours[1] = "BLACK";
		ClownFishBodyColours[2] = "WHITE";
		ClownFish.ClownFishBodyColours = ClownFishBodyColours;
		this.pattern = pattern;
		Zoo.ClownFishCounter++;
	}

}
