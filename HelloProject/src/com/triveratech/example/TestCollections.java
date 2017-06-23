package com.triveratech.example;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.trivera.demo.Customer;

public class TestCollections {

	public static void main(String[] args) {
		Customer[] customers = new Customer[4];
		customers[0] = new Customer("Harry", "Potter", "+44 0206-145-1351", "harry@hogwarts.ac.uk");
		customers[1] = new Customer("Ronald", "Weasley", "+44 0206-145-1351", "harry@hogwarts.ac.uk");
		customers[2] = new Customer("Hermione", "Granger", "+44 0206-145-1351", "harry@hogwarts.ac.uk");
		customers[3] = new Customer("Neville", "Longbottom", "+44 0206-145-1351", "harry@hogwarts.ac.uk");
		System.out.println("Customers:");
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		System.out.println();
		Customer[] biggerCustomers = new Customer[5];
		System.arraycopy(customers, 0, biggerCustomers, 0, 4);

		customers = biggerCustomers;

		customers[4] = new Customer("Dean", "Thomas", "+44 0206-145-1351", "harry@hogwarts.ac.uk");

		System.out.println("Bigger Customers (Customers post-arrayCopy:");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		System.out.println();
		List<Customer> customerList = new Vector<>();
		customerList.add(new Customer("Harry", "Potter", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList.add(new Customer("Ronald", "Weasley", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList.add(new Customer("Hermione", "Granger", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList.add(new Customer("Neville", "Longbottom", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList.add(new Customer("Dean", "Thomas", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		System.out.println("Customer List (Vector)");
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
		System.out.println();
		customerList.add(new Customer("Seamus", "Finnegan", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		System.out.println("Customer List (Vector)");
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
		System.out.println();
		List<Customer> customerList2 = new LinkedList<>();
		customerList2.add(new Customer("Harry", "Potter", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList2.add(new Customer("Ronald", "Weasley", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList2.add(new Customer("Hermione", "Granger", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList2.add(new Customer("Neville", "Longbottom", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList2.add(new Customer("Dean", "Thomas", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		System.out.println("Customer List (Linked List)");
		for (Customer customer : customerList2) {
			System.out.println(customer);
		}
		System.out.println();
		customerList2.add(new Customer("Seamus", "Finnegan", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		System.out.println("Customer List (Linked List)");
		for(int i = 0; i < customerList2.size(); i++) {
			System.out.println(i + ":\t" + customerList2.get(i)); // .get(pos) instead of [pos]
		}
		
		customerList2.remove(3);
		System.out.println();
		System.out.println("Customer List (Linked List)");
		for(int i = 0; i < customerList2.size(); i++) {
			System.out.println(i + ":\t" + customerList2.get(i)); // .get(pos) instead of [pos]
		}
		
		System.out.println();
		List<Customer> customerList3 = new LinkedList<>();
		customerList3.add(new Customer("Harry", "Potter", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList3.add(new Customer("Ronald", "Weasley", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList3.add(new Customer("Hermione", "Granger", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList3.add(new Customer("Neville", "Longbottom", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerList3.add(new Customer("Dean", "Thomas", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		System.out.println("Customer List (Linked List)");
		for (Customer customer : customerList3) {
			System.out.println(customer);
		}
		
		// K = Key, V = Value. Key should be small/simple with a reasonable
		// hashcode() that is regenerateable from information on hand
		// Harry won't forget his name, so our key will be a String of
		// "lastName,firstName"
		Map<String, Customer> customerHash = new Hashtable<>(); 
		// or new HashMap<>() (no thread safety) or TreeMap<>() if we're sorting
		Customer h =  new Customer("Harry", "Potter", "+44 0206-145-1351", "harry@hogwarts.ac.uk");
		customerHash.put("Potter,Harry", h);
		customerHash.put("harry.potter@hogwarts.ac.uk", h);
		customerHash.put("Weasley,Ronald", new Customer("Ronald", "Weasley", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		customerHash.put("Granger,Hermione", new Customer("sdfasdfg", "Granger", "+44 0206-145-1351", "harry@hogwarts.ac.uk"));
		
		System.out.println();
		Customer harryFromDict = customerHash.get("Potter,Harry");
		System.out.println("Harry From Dict: " + harryFromDict);
		
		System.out.println();
		System.out.println("CustDict by values");
		for (Customer c : customerHash.values()) {
			System.out.println(c);
		}
		
		System.out.println();
		System.out.println("CustDict by key");
		for (String key : customerHash.keySet()) {
			System.out.println(key + "=" + customerHash.get(key));
		}
		
		System.out.println();
		System.out.println("CustDict by Map.Entry");
		for (Map.Entry<String, Customer> entry : customerHash.entrySet()) {
			System.out.println("key = " + entry.getKey() + "; value = " + entry.getValue());
		}
		
		// Natural Sort order (Comparable/compare method in data class)
		// External Comparator
		Customer removed = customerHash.remove("Weasley,Ronald"); // Remove Ron from the Map
		System.out.println(removed);
		System.out.println();
		System.out.println(customerHash);
		
		
	}

}



















