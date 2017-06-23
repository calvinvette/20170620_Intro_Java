package com.trivera.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;

public class WeasleyConsoleStore {
	private static Map<String, Customer> customerMap = new Hashtable<>();
	private static BufferedReader input;

	public static Customer addCustomer() {
		try {
			System.out.print("First Name:\t");
			String firstName = input.readLine();
			System.out.print("Last Name:\t");
			String lastName = input.readLine();
			System.out.print("Phone Number:\t");
			String phoneNumber = input.readLine();
			System.out.print("Email:\t\t");
			String email = input.readLine();
			customerMap.put(lastName + "," + firstName, new Customer(firstName, lastName, phoneNumber, email));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Customer searchByLastNameAndFirstName(String lastName, String firstName) {
		return customerMap.get(lastName + "," + firstName);
	}

	public static Customer updateCustomer() {
		System.out.println("Not implemented.");
		return null;
	}

	public static void listCustomers() {
		for (Customer customer : customerMap.values()) {
			System.out.println(customer);
		}
	}

	public static void main(String[] args) {
		boolean done = false;
		input = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		System.out.println("Welcome to Weasley's!");
		while (!done) {
			try {
				line = input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (line.toLowerCase()) {
			case "q":
			case "quit":
				done = true;
				break;
			case "a":
			case "add":
				addCustomer();
				break;
			case "l":
			case "list":
				listCustomers();
				break;
			case "s":
			case "f":
			case "search":
			case "find":
				try {
					System.out.println("LastName to find:\t");
					String lastName = input.readLine();
					System.out.println("FirstName to find:\t");
					String firstName = input.readLine();
					Customer found = searchByLastNameAndFirstName(lastName, firstName);
					System.out.println(found);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "u":
			case "update":
				updateCustomer();
				break;
			default:
				System.out.println("Unknown option!");
				System.out.println("a) Add customer");
				System.out.println("u) Update customer");
				System.out.println("l) List customers");
				System.out.println("q) Quit");
			}
		}
		System.out.println("Bye!");
	}

}
