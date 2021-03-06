package com.weasley.store.model;
// Generated Jun 24, 2017 10:00:21 AM by Hibernate Tools 5.2.0.Final

import java.math.BigDecimal;
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
 * Payment generated by hbm2java
 */
@Entity
@Table(name = "Payment", catalog = "weasleydb")
@XmlRootElement
public class Payment implements java.io.Serializable {

	private Long paymentId;
	private long orderId;
	private BigDecimal amount;
	private Date paymentDate;
	private Date dueDate;
	private Character paymentType;

	public Payment() {
	}

	public Payment(long orderId, BigDecimal amount, Date paymentDate) {
		this.orderId = orderId;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public Payment(long orderId, BigDecimal amount, Date paymentDate,
			Date dueDate, Character paymentType) {
		this.orderId = orderId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.dueDate = dueDate;
		this.paymentType = paymentType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "paymentId", unique = true, nullable = false)
	public Long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	@Column(name = "orderId", nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "amount", nullable = false, precision = 8)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "paymentDate", nullable = false, length = 10)
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dueDate", length = 10)
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "paymentType", length = 1)
	public Character getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(Character paymentType) {
		this.paymentType = paymentType;
	}

}
