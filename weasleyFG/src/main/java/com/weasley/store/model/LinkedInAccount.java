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
 * LinkedInAccount generated by hbm2java
 */
@Entity
@Table(name = "LinkedInAccount", catalog = "weasleydb")
@XmlRootElement
public class LinkedInAccount implements java.io.Serializable {

	private Long linkedInAccountId;

	public LinkedInAccount() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "linkedInAccountId", unique = true, nullable = false)
	public Long getLinkedInAccountId() {
		return this.linkedInAccountId;
	}

	public void setLinkedInAccountId(Long linkedInAccountId) {
		this.linkedInAccountId = linkedInAccountId;
	}

}
