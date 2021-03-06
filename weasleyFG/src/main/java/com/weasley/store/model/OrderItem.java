package com.weasley.store.model;
// Generated Jun 24, 2017 10:00:21 AM by Hibernate Tools 5.2.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * OrderItem generated by hbm2java
 */
@Entity
@Table(name = "OrderItem", catalog = "weasleydb")
@XmlRootElement
public class OrderItem implements java.io.Serializable {

	private Long orderItemId;
	private Long orderId;
	private Long productId;
	private Float quantity;
	private Float unitPrice;
	private Character backorderable;

	public OrderItem() {
	}

	public OrderItem(Long orderId, Long productId, Float quantity,
			Float unitPrice, Character backorderable) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.backorderable = backorderable;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderItemId", unique = true, nullable = false)
	public Long getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	@Column(name = "orderId")
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "productId")
	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Column(name = "quantity", precision = 12, scale = 0)
	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	@Column(name = "unitPrice", precision = 12, scale = 0)
	public Float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "backorderable", length = 1)
	public Character getBackorderable() {
		return this.backorderable;
	}

	public void setBackorderable(Character backorderable) {
		this.backorderable = backorderable;
	}

}
