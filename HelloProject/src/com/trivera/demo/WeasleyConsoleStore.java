package com.trivera.demo;

public class WeasleyConsoleStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer harry = new Customer();
		harry.setFirstName("Harry");
		harry.setLastName("Potter");
		harry.setPhoneNumber("+44 0206 939-1414");
		harry.setEmail("harry@hogwarts.ac.uk");
		
		System.out.println(harry);
		
		System.out.println(harry.getFirstName() + " " + harry.getLastName());
		
		Customer hermione = new Customer("Hermione", "Granger", "+44 0206 301-1459", 
				"hermione.granger@hogwarts.ac.uk");
		System.out.println(hermione);
	}

}



