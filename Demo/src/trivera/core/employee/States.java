package trivera.core.employee;

public enum States {
	AL("Alabama", "Birmingham", 131049494),
	AK("Alaska", "Juneau", 3913911),
	AR("Arkansas", "Little Rock", 1231241);
	
	States(String stateName, String capital, int population) {
		this.stateName = stateName;
		this.capital = capital;
		this.population = population;
	}
	
	private final String stateName;
	private final String capital;
	private final int population;
	public String getStateName() {
		return stateName;
	}
	public String getCapital() {
		return capital;
	}
	public int getPopulation() {
		return population;
	}
}
