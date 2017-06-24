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
 * Note generated by hbm2java
 */
@Entity
@Table(name = "Note", catalog = "weasleydb")
@XmlRootElement
public class Note implements java.io.Serializable {

	private Long noteId;
	private String noteCategory;
	private String noteText;
	private String exposure;
	private Date noteDate;
	private Date validUntilDate;

	public Note() {
	}

	public Note(String noteCategory) {
		this.noteCategory = noteCategory;
	}
	public Note(String noteCategory, String noteText, String exposure,
			Date noteDate, Date validUntilDate) {
		this.noteCategory = noteCategory;
		this.noteText = noteText;
		this.exposure = exposure;
		this.noteDate = noteDate;
		this.validUntilDate = validUntilDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "noteId", unique = true, nullable = false)
	public Long getNoteId() {
		return this.noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	@Column(name = "noteCategory", nullable = false, length = 20)
	public String getNoteCategory() {
		return this.noteCategory;
	}

	public void setNoteCategory(String noteCategory) {
		this.noteCategory = noteCategory;
	}

	@Column(name = "noteText", length = 65535)
	public String getNoteText() {
		return this.noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	@Column(name = "exposure", length = 10)
	public String getExposure() {
		return this.exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "noteDate", length = 10)
	public Date getNoteDate() {
		return this.noteDate;
	}

	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "validUntilDate", length = 10)
	public Date getValidUntilDate() {
		return this.validUntilDate;
	}

	public void setValidUntilDate(Date validUntilDate) {
		this.validUntilDate = validUntilDate;
	}

}