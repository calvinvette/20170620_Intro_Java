package trivera.core.employee;

//import trivera.core.employee.*;

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

public class Employee extends Person // LAB HINT: What goes here for
										// sub-classing
{
	// LAB HINT: Add two instance variables
	private int empId;
	private Employee manager;

	// LAB HINT: Add your constructors here
	public Employee() {
//		super();
	}

	public Employee(String name, int empId, Employee manager) {
		super(name);
		this.empId = empId;
		this.manager = manager;
	}

	public Employee(int empId, Employee manager) {
		super();
		this.empId = empId;
		this.manager = manager;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	// LAB HINT: Code get and set methods for both instance variables

	// LAB HINT: Place calcSalary() method here
	public Float calcSalary() {
		return 0.0F;
	}

	@Override
	public String toString() {
		return new StringBuilder("Employee [empId=")
				.append(empId)
				.append(", manager=")
				.append(manager)
				.append("] ")
				.append(super.toString())
				.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (this == obj)
			return true;
		if (super.equals(obj))
			return true;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		return true;
	}

	// LAB HINT: Override toString() and equals() method using parent version

	/*
	 * public String toString() { StringBuffer sb = new
	 * StringBuffer(super.toString()); sb.append(" - empID: ").append(empID);
	 * return sb.toString(); }
	 */
	
	
	// For Mailable exercise;
	/*
	 * public void mailNote(String note) {
	 * System.out.println("Sending note internal to colleague " + name +
	 * " with message " + note); }
	 */

}
