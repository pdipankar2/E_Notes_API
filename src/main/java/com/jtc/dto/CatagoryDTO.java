package com.jtc.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.val;

public class CatagoryDTO {

	private Integer id;
	
	@NotBlank(message = "Name must not be blank")
	@Size(min = 5, max = 100, message = "Name must be between 1 and 100 characters")

	private String name;

	@NotBlank(message = "Description must not be blank")
	@Size(min = 5, max = 100, message = "Description must be between 1 and 100 characters")
	private String description;
	//@NotBlank
	private Boolean isActive;

	private Integer createdBy;

	@CreationTimestamp
	private Date createdOn;

	private Integer upadtedBy;

	public CatagoryDTO(Integer id, String name, String description, Boolean isActive, Integer createdBy, Date createdOn,
			Integer upadtedBy, Date updateOn) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.upadtedBy = upadtedBy;
		this.updateOn = updateOn;
	}

	public CatagoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

	@UpdateTimestamp
	private Date updateOn;

}
