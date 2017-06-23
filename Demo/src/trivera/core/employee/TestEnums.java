package trivera.core.employee;

public class TestEnums {

	public static void main(String[] args) {
		for(States s : States.values()) {
			System.out.println(s);
			System.out.println(s.getStateName());
			System.out.println(s.getCapital());
			System.out.println(s.getPopulation());
		}

	}

}
