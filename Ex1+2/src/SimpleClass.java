import java.util.Date;

public class SimpleClass {
	private String name;
	private int salary;
	private int x = 86;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SimpleClass) {
			SimpleClass rhs= (SimpleClass) obj;
			if ((this.getName() == rhs.getName()) && 
					(this.getSalary() == rhs.getSalary())){
				return true;
			}
		}
		return false;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public SimpleClass() {
		this("John Doe");
		// Constructor Chaining...
		// this.name = "John Doe";
		// this.salary = 1000;
	}

	public SimpleClass(String name) {
		this(name, 0);
		// super();
		// this.name = name;
		// this.salary = 1000;
	}

	public SimpleClass(String name, int salary) {
		// super();
		this.name = name;
		this.salary = salary;
		// Add BL to add them to HR
		System.out.println("TODO: Add " + name + " to HR with a salary of $" + salary);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static void main(String[] args) {
		SimpleClass sc0 = new SimpleClass();
		System.out.println(sc0.getName() + " makes $" + sc0.getSalary());

		SimpleClass sc1 = new SimpleClass();
		// sc1.name = "Jim";
		// sc1.salary = 30000;
		sc1.setName("Jim"); // Name is encapsulated - call the setter to assign
		sc1.setSalary(30000);

		// System.out.println(sc1.name + " makes $" + sc1.salary);
		// Name is encapsulated - call the getter to retrieve
		System.out.println(sc1.getName() + " makes $" + sc1.getSalary());

		SimpleClass sc2 = new SimpleClass("Jane");
		System.out.println(sc2.getName() + " makes $" + sc2.getSalary());

		// TODO - Refactor the formatting of name & salary

		sc2.setSalary(45000);
		System.out.println(sc2.getName() + " makes $" + sc2.getSalary());

		SimpleClass sc3 = new SimpleClass("Jill", 65000);
		System.out.println(sc3.getName() + " makes $" + sc3.getSalary());

		int x = 42;
		System.out.println("x = " + x);
		x = x + 1;
		System.out.println("x = " + x);
		x++;
		System.out.println("x = " + x);
		++x;
		System.out.println("x = " + x);
		int y = 0;
		y = x++; // assign then increment
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		y = ++x; // Increment then assign
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		sc1.x = 99;
		sc2.x = 13;
		System.out.println(sc1.x); // Jim's x
		System.out.println(sc2.x); // Jane's x
		
		
		SimpleClass sc4 = new SimpleClass("Jim", 30000);
		sc4.setX(99);
		if (sc1 == sc4) { // compare reference variables (pointing to different instances)
			System.out.println("Jims are the same");
		} else {
			System.out.println("Jims are not the same");
		}
		if (sc1.equals(sc4)) { // qualitative comparison of 2 objects
			System.out.println("Jims are the same");
		} else {
			System.out.println("Jims are not the same");
		}
		
		int z = 42;
		int q = 85;
		if (z == q) {
			System.out.println("Z and Q are the same!");
		} else {
			System.out.println("Z and Q are NOT the same!");
		}
		
		if (z == 42 && q >= 86) {
			System.out.println("Both values are good");
		} else if (z == 42 && q != 86) {
			System.out.println("Z is good, q is bad");
		} else if (z != 42 && q >= 86) { 
			System.out.println("Q is good, z is bad");
		} else {
			System.out.println("Both Z and Q are bad (but we didn't explicitly check)");
		}
		
		
		
		for (int index = 0; index < 10; index++) {
			int y2 = 999;
			System.out.println("Index value: " + index + ", y2 = " + y2);
			y2 = 1234;
		}
//		System.out.println("Index value: " + index + ", y2 = " + y2);
		System.out.println("Done with program...");
		
		SimpleClass[ ] allSimps = new SimpleClass[ 4 ];
		allSimps[0] = sc0; // John Doe
		allSimps[1] = sc1; // Jim
		allSimps[2] = sc2; // Jane
		allSimps[3] = sc3; // Jill
		
		for (int index = 0; index < allSimps.length; index++) {
			System.out.println(allSimps[index].getName() 
					+ " makes $" + allSimps[index].getSalary());
		}
		
		int month = new Date().getMonth(); // 0-based
		switch(month) {
		case 0:
			System.out.println("January");
			break;
		case 1:
			System.out.println("February");
			break;
		case 2:
			System.out.println("March");
			break;
		case 3:
			System.out.println("April");
			break;
		case 4:
			System.out.println("May");
			break;
		case 5:
			System.out.println("June");
			break;
		case 6:
			System.out.println("July");
			break;
		case 7:
			System.out.println("August");
			break;
		case 8:
			System.out.println("September");
			break;
		case 9:
			System.out.println("October");
			break;
		case 10:
			System.out.println("November");
			break;
		case 11:
			System.out.println("December");
			break;
		default:
				System.out.println("What????");
				break;
		}
		System.out.println("Code after break...");
		
		String val = "A";
		switch(val) {
		case("a"): 
		case("A"):
			System.out.println("Today's code was brought to you by the letter A");
			break;
		case("b"): case("B"):
			System.out.println("Today's code was brought to you by the letter B");
			break;
		default:
			System.out.println("");
		}
		
	}

}












