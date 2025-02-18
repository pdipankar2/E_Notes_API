package com.jtc.entity;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

	private Boolean isActive;
	private Boolean isDelete;
	private Integer createdon;
	private Date createdDate;
	private Integer updateon;
	private Date updateDate;
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Integer createdon) {
		this.createdon = createdon;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getUpdateon() {
		return updateon;
	}
	public void setUpdateon(Integer updateon) {
		this.updateon = updateon;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
}
