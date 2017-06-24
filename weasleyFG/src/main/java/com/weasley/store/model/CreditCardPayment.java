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
 * CreditCardPayment generated by hbm2java
 */
@Entity
@Table(name = "CreditCardPayment", catalog = "weasleydb")
@XmlRootElement
public class CreditCardPayment implements java.io.Serializable {

	private Long creditCardPaymentId;
	private long creditCardId;
	private long paymentId;
	private Date processDate;
	private Long authorization;
	private Character settled;

	public CreditCardPayment() {
	}

	public CreditCardPayment(long creditCardId, long paymentId, Date processDate) {
		this.creditCardId = creditCardId;
		this.paymentId = paymentId;
		this.processDate = processDate;
	}
	public CreditCardPayment(long creditCardId, long paymentId,
			Date processDate, Long authorization, Character settled) {
		this.creditCardId = creditCardId;
		this.paymentId = paymentId;
		this.processDate = processDate;
		this.authorization = authorization;
		this.settled = settled;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "creditCardPaymentId", unique = true, nullable = false)
	public Long getCreditCardPaymentId() {
		return this.creditCardPaymentId;
	}

	public void setCreditCardPaymentId(Long creditCardPaymentId) {
		this.creditCardPaymentId = creditCardPaymentId;
	}

	@Column(name = "creditCardId", nullable = false)
	public long getCreditCardId() {
		return this.creditCardId;
	}

	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
	}

	@Column(name = "paymentId", nullable = false)
	public long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "processDate", nullable = false, length = 10)
	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	@Column(name = "authorization")
	public Long getAuthorization() {
		return this.authorization;
	}

	public void setAuthorization(Long authorization) {
		this.authorization = authorization;
	}

	@Column(name = "settled", length = 1)
	public Character getSettled() {
		return this.settled;
	}

	public void setSettled(Character settled) {
		this.settled = settled;
	}

}