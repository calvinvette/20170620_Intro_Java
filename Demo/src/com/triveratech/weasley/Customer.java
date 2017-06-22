package com.triveratech.weasley;

import java.util.Arrays;
import java.util.Date;

/**
 * A Weasley Customer
 * 
 * A customer in our system Customers can have 2 addresses (for now) - Home and
 * Work. Multiple Address support will be in Version 2.0 Orders are just
 * placeholders for now.
 * 
 * @author calvin
 *
 */
public class Customer {

	/**
	 * Customer ID Defaults to -1 so we know that it's not from the DB
	 */
	private Long customerId = -1L;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Address homeAddress;
	private Address workAddress;
	private Date birthDate;
	private Order[] orders = new Order[10]; // create 10 "null" spaces for
											// orders

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email, String phoneNumber, Address homeAddress,
			Address workAddress, Date birthDate, Order[] orders) {
		this(-1L, firstName, lastName, email, phoneNumber, homeAddress, workAddress, birthDate, orders);
	}

	public Customer(Long customerId, String firstName, String lastName, String email, String phoneNumber,
			Address homeAddress, Address workAddress, Date birthDate, Order[] orders) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.homeAddress = homeAddress;
		this.workAddress = workAddress;
		this.birthDate = birthDate;
		this.orders = orders;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * FirstNames
	 * 
	 * First Names should be between 2 and 25 alphanumeric characters
	 */
	public void setFirstName(String firstName) {
		// TODO: Restrict firstName to 2-25 alphanumberic customers
		// Validate first name
		// min length=2, max length=25, pattern=[A-Za-z0-9\' ]*
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

	public void addOrder(String orderItems) {
		// this.setOrder(new Order(this, orderItems));
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] == null) {
				orders[i] = new Order(this, orderItems);
				break;
			}
		}
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", homeAddress=" + homeAddress + ", workAddress="
				+ workAddress + ", birthDate=" + birthDate + ", orders=" + Arrays.toString(orders) + "]";
	}

	public Order[] getOrders() {
		return orders;
	}

	public void setOrders(Order[] orders) {
		this.orders = orders;
	}

	// Overloaded - adds a variant of hashCode - this one takes customerId
	public int hashCode(int customerId) {
		return -1;
	}

	// if (harry1.hashCode() == harry2.hashCode()
	// Over riding replaces a parent property or method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	// harry1.equals(harry2)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj; // Right-hand side customer
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equalsIgnoreCase(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equalsIgnoreCase(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equalsIgnoreCase(other.lastName))
			return false;
		return true;
	}

}
