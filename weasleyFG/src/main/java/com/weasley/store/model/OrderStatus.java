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
 * OrderStatus generated by hbm2java
 */
@Entity
@Table(name = "OrderStatus", catalog = "weasleydb")
@XmlRootElement
public class OrderStatus implements java.io.Serializable {

	private Long orderStatusId;
	private String status;
	private String statusText;
	private String description;
	private Long prereq;

	public OrderStatus() {
	}

	public OrderStatus(String status, String statusText, String description,
			Long prereq) {
		this.status = status;
		this.statusText = statusText;
		this.description = description;
		this.prereq = prereq;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderStatusId", unique = true, nullable = false)
	public Long getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(Long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	@Column(name = "status", length = 5)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "statusText", length = 32)
	public String getStatusText() {
		return this.statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "prereq")
	public Long getPrereq() {
		return this.prereq;
	}

	public void setPrereq(Long prereq) {
		this.prereq = prereq;
	}

}
