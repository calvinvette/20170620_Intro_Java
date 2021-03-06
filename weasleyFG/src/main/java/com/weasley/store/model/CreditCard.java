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
 * CreditCard generated by hbm2java
 */
@Entity
@Table(name = "CreditCard", catalog = "weasleydb")
@XmlRootElement
public class CreditCard implements java.io.Serializable {

	private Long creditCardId;
	private String creditCardNumber;
	private Date expirationDate;
	private Long billingAddress;
	private int cvv;
	private String nameOnCard;
	private String businessName;
	private long customerId;

	public CreditCard() {
	}

	public CreditCard(String creditCardNumber, Date expirationDate, int cvv,
			long customerId) {
		this.creditCardNumber = creditCardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.customerId = customerId;
	}
	public CreditCard(String creditCardNumber, Date expirationDate,
			Long billingAddress, int cvv, String nameOnCard,
			String businessName, long customerId) {
		this.creditCardNumber = creditCardNumber;
		this.expirationDate = expirationDate;
		this.billingAddress = billingAddress;
		this.cvv = cvv;
		this.nameOnCard = nameOnCard;
		this.businessName = businessName;
		this.customerId = customerId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "creditCardId", unique = true, nullable = false)
	public Long getCreditCardId() {
		return this.creditCardId;
	}

	public void setCreditCardId(Long creditCardId) {
		this.creditCardId = creditCardId;
	}

	@Column(name = "creditCardNumber", nullable = false, length = 20)
	public String getCreditCardNumber() {
		return this.creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "expirationDate", nullable = false, length = 10)
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "billingAddress")
	public Long getBillingAddress() {
		return this.billingAddress;
	}

	public void setBillingAddress(Long billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Column(name = "cvv", nullable = false)
	public int getCvv() {
		return this.cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Column(name = "nameOnCard", length = 50)
	public String getNameOnCard() {
		return this.nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	@Column(name = "businessName", length = 50)
	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "customerId", nullable = false)
	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}
