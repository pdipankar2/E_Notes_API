package com.jtc.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

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

}
