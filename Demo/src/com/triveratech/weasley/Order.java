package com.triveratech.weasley;

import java.util.Date;

public class Order {
	private Long orderId = -1L;
	private String status = "Ordered";
	private Date orderDate;
	private Date shipDate;
	private String orderItems;
	private Customer customer;
	
	// Replace the "Default" constructor (CTOR)
	// The default CTOR does nothing (NOOP)
	public Order() {
		this.setOrderDate(new Date());
		this.setShipDate(new Date(new Date().getTime() + 24 * 60 * 60 * 1000));
		this.setOrderItems("Empty Order");
		this.setStatus("Ordered"); // Replaces original "Ordered" with another "Ordered" (Expensive NOOP)
	}
	
	public Order(Customer customer, String orderItems) {
		this.setOrderDate(new Date());
		this.setShipDate(new Date(new Date().getTime() + 24 * 60 * 60 * 1000));
		this.setOrderItems("Empty Order");
		this.setStatus("Ordered"); // Replaces original "Ordered" with another "Ordered" (Expensive NOOP)
		this.orderItems = orderItems;
		this.customer = customer;
//		customer.setOrder(this);
//		for (int i = 0; i < customer.getOrders().length; i++) {
//			if (customer)
//		}
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public String getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(String orderItems) {
		this.orderItems = orderItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", orderDate="
				+ orderDate + ", shipDate=" + shipDate + ", orderItems=" + orderItems + "]";
	}
	
	
//	@Override
//	public String toString() {
//		return "Order: " + this.orderItems					// Direct property access (Don't) 
//				+ ", orderDate = " + this.getOrderDate() 	// Getter via this
//				+ ", shipDate = " + getShipDate();			// Getter (implicit this)
//	}

	// /**
	// * Pre-Existing orderIds were between 1 and 100
	// * After this system, new orders were generated with IDs of 2100+
	// * We'll dynamically alter the orderId of any of the old
	// * orders to be between 2000 and 2100.
	// * @return
	// */
	// public Long getOrderId() {
	// if (orderId < 2100) {
	// return orderId + 2000;
	// }
	// return orderId;
	// }
	//
	// public void setOrderId(Long orderId) {
	// // Validation logic
	// // TODO - make sure minimum value is > 0
	// this.orderId = orderId; // Expensive NOOP
	// }
	//
	// // Order o1 = new Order();
	// // o1.setOrderId(1234L);
	//
	// public String getStatus() {
	// return status; // same as return this.status; (this. is implied)
	// }
	//
	// public void setStatus(String status) {
	// this.status = status;
	// }
	//
	// public Date getOrderDate() {
	// return orderDate;
	// }
	//
	// public void setOrderDate(Date orderDate) {
	// this.orderDate = orderDate;
	// }

}
