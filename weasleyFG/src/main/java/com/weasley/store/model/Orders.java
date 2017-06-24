package com.weasley.store.model;
// Generated Jun 24, 2017 10:00:21 AM by Hibernate Tools 5.2.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "Orders", catalog = "weasleydb")
@XmlRootElement
public class Orders implements java.io.Serializable {

	private Long orderId;
	private Long customerId;
	private Date orderDate;
	private String shipMethod;
	private Date shipDate;
	private String status;
	private Long shipAddressId;

	public Orders() {
	}

	public Orders(Long customerId, Date orderDate, String shipMethod,
			Date shipDate, String status, Long shipAddressId) {
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.shipMethod = shipMethod;
		this.shipDate = shipDate;
		this.status = status;
		this.shipAddressId = shipAddressId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderId", unique = true, nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "customerId")
	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "orderDate", length = 10)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "shipMethod", length = 10)
	public String getShipMethod() {
		return this.shipMethod;
	}

	public void setShipMethod(String shipMethod) {
		this.shipMethod = shipMethod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "shipDate", length = 10)
	public Date getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "shipAddressId")
	public Long getShipAddressId() {
		return this.shipAddressId;
	}

	public void setShipAddressId(Long shipAddressId) {
		this.shipAddressId = shipAddressId;
	}

}
