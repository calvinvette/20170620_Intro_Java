package trivera.core.employee;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of Trivera
 * Technologies, LLC
 *
 * Copyright (c) 2017 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */

public class Person {
	public static int numberOfPersons = 0;
	private static Person[] peeps = new Person[10];

	private String name;

	public Person() {
		this.name = "Unknown";
		addPeeps();
	}

	public Person(String name) {
		this.name = name;
		addPeeps();
	}

	public void addPeeps() {	// Initializer Block - used to give the same logic for all CTORs
		// for (int index = 0; index < Person.peeps.length; index++) {
		// Person p = Person.peeps[index];
		boolean alreadyExists = false;
		for (Person p : Person.peeps) {
			if (p == null) { break; }
			if (this.name.equals(p.name)) {
				alreadyExists = true;
				break;
			}
		}
		if (!alreadyExists) {
			Person.numberOfPersons++;
		}

	}

	// LAB HINT: Override the equals() method
	// Left-Hand side is "this"
	// Right hand side is "obj"
	// harry1.equals(harry2)
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Person) {
			Person rhs = (Person) obj;
			if (this.getName() == rhs.getName()) {
				return true;
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}

	// LAB HINT: Override the toString() method
	@Override
	public String toString() {
		return "Person: " + this.getName();
	}

	// LAB HINT: Write the get and set methods for the name instance variable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
