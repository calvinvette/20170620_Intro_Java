package trivera.core.employee;

/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of Trivera Technologies, LLC
 *
 * Copyright (c) 2017 Trivera Technologies, LLC.
 * http://www.triveratech.com   
 * </p>
 * @author Trivera Technologies Tech Team.
 */

public class Test {
	private int numberOfTests = 0;
	
    public static void main(String[] args) {
//    	this.numberOfTests
    	
    	int foo = 1123;
//    	System.out.println(Person.numberOfPersons);
    	System.out.println(foo);
    	String[ ] myStrings = {
    			"One",
    			"Two",
    			"Three",
    			"Four"
    	};
    	for (String s : myStrings) {
    		System.out.println(s);
    	}
    	System.out.println(myStrings[4]); // Actually the Fifth element (Obi-wan error)
    	
    	
    	
        Person pers = new Person("Harry Potter");
//        Employee manager = new Employee("Hermione Granger", 1234, null);
//        Employee emp = new Employee("Harry Potter", 4321, manager);
        Employee manager = new SalesEmployee("Hermione Granger", 1234);
        Employee emp = new HourlyEmployee("Harry Potter", 4321);
        emp.setManager(manager);
        
        // Don't use instance variables to reference static fields or methods
//        System.out.println(emp.numberOfPersons);
        
//        System.out.println(Person.numberOfPersons);
        
        
        System.out.println(pers);
        System.out.println(manager);
        System.out.println(emp);
        // LAB HINT: Instantiate a person and an employee,
        //           using the two variables supplied
        
        if (pers.equals(manager)) {
        	System.out.println("What?!?");
        } else {
        	System.out.println("Good - Harry != Hermione");
        }
        
        if (pers.equals(emp)) {
        	System.out.println("Harry is Harry no matter what.");
        } else {
        	System.out.println("Why isn't Harry (person) .equals Harry (employee)???");
        }
        
        if (pers == emp) {
        	System.out.println("Something wrong here...");
        } else {
        	System.out.println("Harry (pers) != Harry (emp)");
        }

    // LAB HINT: Print the instance variables by way of their toString() method


    }

}