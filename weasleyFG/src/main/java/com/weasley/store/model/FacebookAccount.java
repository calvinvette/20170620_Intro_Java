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
 * FacebookAccount generated by hbm2java
 */
@Entity
@Table(name = "FacebookAccount", catalog = "weasleydb")
@XmlRootElement
public class FacebookAccount implements java.io.Serializable {

	private Long facebookAccountId;

	public FacebookAccount() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "facebookAccountId", unique = true, nullable = false)
	public Long getFacebookAccountId() {
		return this.facebookAccountId;
	}

	public void setFacebookAccountId(Long facebookAccountId) {
		this.facebookAccountId = facebookAccountId;
	}

}