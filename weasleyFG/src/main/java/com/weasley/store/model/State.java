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
 * State generated by hbm2java
 */
@Entity
@Table(name = "State", catalog = "weasleydb")
@XmlRootElement
public class State implements java.io.Serializable {

	private Integer stateId;
	private String name;
	private String stateCode;
	private Long country;

	public State() {
	}

	public State(String name, String stateCode) {
		this.name = name;
		this.stateCode = stateCode;
	}
	public State(String name, String stateCode, Long country) {
		this.name = name;
		this.stateCode = stateCode;
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stateId", unique = true, nullable = false)
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "stateCode", nullable = false, length = 3)
	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Column(name = "country")
	public Long getCountry() {
		return this.country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

}
