package com.triveratech.weasley;

import java.util.Date;

public class WeasleyStore {

	public static void main(String[] args) {
		Customer harry = new Customer();
		harry.setFirstName("Harry");
		harry.setLastName("Potter");
		harry.setEmail("harry.potter@hogwarts.ac.uk");
		harry.setPhoneNumber("+44 0206 331-4141");
		Date harryBDay = new Date();

		harryBDay.setMonth(6 - 1);
		harryBDay.setDate(31 - 0);
		harryBDay.setYear(1980 - 1900);

		harry.setBirthDate(harryBDay);
		
		Address harryHome = new Address();
		harryHome.setLine1("#4 Privet Drive");
		harryHome.setLine2("Cupboard Under the Stair");
		harryHome.setCity("Little Whinging");
		harryHome.setState("Surrey");
		harryHome.setCountry("England");

		harry.setHomeAddress(harryHome);

		Order harryOrder = new Order(harry, "10 boxes of Bertie Bott's Every Flavoured Beans");
//		harryOrder.setCustomer(harry);
//		harryOrder.setOrderItems("10 boxes of Bertie Bott's Every Flavoured Beans");
//		harry.setOrder(harryOrder);
		
		
		System.out.println(harry);

		Customer hermione = new Customer();
		hermione.setLastName("Granger");
		hermione.setEmail("hermione.granger@hogwarts.ac.uk");
		hermione.addOrder("4 Gorilla Grunts");
		hermione.addOrder("1 Fanged Frisbee");
		
//		Order hermioneOrder = new Order(hermione, "4 Gorilla Grunts");
//		hermioneOrder.setOrderItems("4 Gorilla Grunts");
//		hermioneOrder.setCustomer(hermione);
//		hermione.setOrder(hermioneOrder);
		
		//
//		if (hermione.getEmail().equals("foo@bar.com")) {
//			System.out.println("Hermione works at Bar corp!");
//		} else if (hermione.getEmail().split(".")[2].equals("uk")) {
//			System.out.println("Her email is British");
//		}
		
		System.out.println(hermione);
		
		VIPCustomer fred = new VIPCustomer();
		fred.setFirstName("Fred");
		fred.setLastName("Weasley");
		
		System.out.println(fred);

	}

}
