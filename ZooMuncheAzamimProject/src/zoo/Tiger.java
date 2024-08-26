package zoo;

public class Tiger extends Lions {
	private int happiness = 100;

	public Tiger(String name, int age, double weight, String gender) {
		super(name, age, weight, gender);
		this.noise = "roar";

	}

	public String getNoise() {
		return noise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null)
			this.name = null;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public boolean setAge(int age) {
		if (age <= 0)
			return false;

		this.age = age;
		return true;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight <= 0)
			this.weight = 0;
		this.weight = weight;
	}

	public void setGender(String gender) {
		if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"))
			this.gender = null;
		this.gender = gender;
	}

	public double CalculateConsumptionOfTiger() {

		double weightMultiplyAge = getWeight() * getAge();
		double consumption;

		if (getGender().equalsIgnoreCase("female")) {
			consumption = weightMultiplyAge * 0.03;
		} else {
			consumption = weightMultiplyAge * 0.02;
		}

		consumption = Math.floor(consumption);

		return consumption;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Tigers [name=" + name + ", age=" + age + ", weight=" + weight + ", gender=" + gender + ", happiness="
				+ getHappiness() + "]";
	}
}
