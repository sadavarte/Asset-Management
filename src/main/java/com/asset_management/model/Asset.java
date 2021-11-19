package com.asset_management.model;

 
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Asset {

	// Add an asset. Asset will have a name, purchase date, condition notes,
	// a category, assignment status - Available, Assigned, Recovered.

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	 
	 
    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
	private Date purchaseDate;
	private String conditionNotes;
	private String assignmentStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Categories category;

	public Asset() {
		super();
 	}

	public Asset(long id, String name, Date purchaseDate, String conditionNotes, String assignmentStatus,
			Categories category) {
		super();
		this.id = id;
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.conditionNotes = conditionNotes;
		this.assignmentStatus = assignmentStatus;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getConditionNotes() {
		return conditionNotes;
	}

	public void setConditionNotes(String conditionNotes) {
		this.conditionNotes = conditionNotes;
	}

	public String getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", name=" + name + ", purchaseDate=" + purchaseDate + ", conditionNotes="
				+ conditionNotes + ", assignmentStatus=" + assignmentStatus + ", category=" + category + "]";
	}
	
	

}
