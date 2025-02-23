package com.jtc.dto;

public class fileDto {

	
	private Integer id;
	private String originalFileName;
	private String displayFileName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getDisplayFileName() {
		return displayFileName;
	}
	public void setDisplayFileName(String displayFileName) {
		this.displayFileName = displayFileName;
	}
	public fileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public fileDto(Integer id, String originalFileName, String displayFileName) {
		super();
		this.id = id;
		this.originalFileName = originalFileName;
		this.displayFileName = displayFileName;
	}

	

}
