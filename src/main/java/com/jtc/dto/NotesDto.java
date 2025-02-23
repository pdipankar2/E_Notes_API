package com.jtc.dto;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.jtc.entity.Catagory;

import jakarta.persistence.Column;


public class NotesDto {

	private Integer id;
	private String title;
	private String description;

	private Catagory catagory;
	
	@CreatedBy
	@Column(updatable = false)
	private Integer createdBy;

	@CreatedDate
	@Column(updatable = false)

	private Date createdOn;

	@LastModifiedBy
	@Column(insertable = false)

	private Integer upadtedBy;

	@LastModifiedDate
	@Column(insertable = false)

	private Date updateOn;
	
	
	private fileDto fileDetails;
	
	
	
	

	public fileDto getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(fileDto fileDetails) {
		this.fileDetails = fileDetails;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUpadtedBy() {
		return upadtedBy;
	}

	public void setUpadtedBy(Integer upadtedBy) {
		this.upadtedBy = upadtedBy;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Catagory getCatagory() {
		return catagory;
	}
	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public NotesDto(Integer id, String title, String description, Catagory catagory, Integer createdBy, Date createdOn,
			Integer upadtedBy, Date updateOn) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.catagory = catagory;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.upadtedBy = upadtedBy;
		this.updateOn = updateOn;
	}

	public NotesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
