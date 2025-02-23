package com.jtc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FileDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String uploadFileName;
	private String originalFileName;
	private String displayFilename;
	private String path;
	private Long fileSize;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getDisplayFilename() {
		return displayFilename;
	}
	public void setDisplayFilename(String displayFilename) {
		this.displayFilename = displayFilename;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public FileDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDetails(Integer id, String uploadFileName, String originalFileName, String displayFilename, String path,
			Long fileSize) {
		super();
		this.id = id;
		this.uploadFileName = uploadFileName;
		this.originalFileName = originalFileName;
		this.displayFilename = displayFilename;
		this.path = path;
		this.fileSize = fileSize;
	}
	
	
}
