package com.triveratech.weasley;

import java.util.Date;

public class VIPCustomer extends Customer {
	private Float discount = 0.10F;

	public VIPCustomer() {
		// This call to super() will happen regardless. We'd have to explicitly call a different super(...)
		// or a this(...) to call a variant.
		// super(); 
	}

	public VIPCustomer(Long customerId, String firstName, String lastName, String email, String phoneNumber,
			Address homeAddress, Address workAddress, Date birthDate, Order[] orders, Float discount) {
		super(customerId, firstName, lastName, email, phoneNumber, homeAddress, workAddress, birthDate, orders);
		this.setDiscount(0.15F);
		this.setDiscount(discount);
	}

	public VIPCustomer(Long customerId, String firstName, String lastName, String email, String phoneNumber,
			Address homeAddress, Address workAddress, Date birthDate, Order[] orders) {
		super(customerId, firstName, lastName, email, phoneNumber, homeAddress, workAddress, birthDate, orders);
		this.setDiscount(0.15F);
	}

	public VIPCustomer(String firstName, String lastName, String email, String phoneNumber, Address homeAddress,
			Address workAddress, Date birthDate, Order[] orders) {
		super(firstName, lastName, email, phoneNumber, homeAddress, workAddress, birthDate, orders);
		this.setDiscount(0.15F);
	}

	public VIPCustomer(String firstName, String lastName, String email, String phoneNumber, Address homeAddress,
			Address workAddress, Date birthDate, Order[] orders, Float discount) {
		super(firstName, lastName, email, phoneNumber, homeAddress, workAddress, birthDate, orders);
		this.setDiscount(discount);
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "VIPCustomer " + super.toString() + " [discount=" + discount + "]";
	}

}
