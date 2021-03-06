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
 * EcheckPayment generated by hbm2java
 */
@Entity
@Table(name = "ECheckPayment", catalog = "weasleydb")
@XmlRootElement
public class EcheckPayment implements java.io.Serializable {

	private Long echeckPaymentId;
	private long bankAccountId;
	private long paymentId;
	private Date processDate;
	private Long confirmationNumber;
	private Long transactionId;

	public EcheckPayment() {
	}

	public EcheckPayment(long bankAccountId, long paymentId, Date processDate) {
		this.bankAccountId = bankAccountId;
		this.paymentId = paymentId;
		this.processDate = processDate;
	}
	public EcheckPayment(long bankAccountId, long paymentId, Date processDate,
			Long confirmationNumber, Long transactionId) {
		this.bankAccountId = bankAccountId;
		this.paymentId = paymentId;
		this.processDate = processDate;
		this.confirmationNumber = confirmationNumber;
		this.transactionId = transactionId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "eCheckPaymentId", unique = true, nullable = false)
	public Long getEcheckPaymentId() {
		return this.echeckPaymentId;
	}

	public void setEcheckPaymentId(Long echeckPaymentId) {
		this.echeckPaymentId = echeckPaymentId;
	}

	@Column(name = "bankAccountId", nullable = false)
	public long getBankAccountId() {
		return this.bankAccountId;
	}

	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
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

	@Column(name = "confirmationNumber")
	public Long getConfirmationNumber() {
		return this.confirmationNumber;
	}

	public void setConfirmationNumber(Long confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	@Column(name = "transactionId")
	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

}
