package com.pgt.proyecto.dto;

public class CorredorDTO {
	private Integer id;
	private String name;	
	private Integer year;
	
	public CorredorDTO() {}
	
	public CorredorDTO(Integer id,String name,Integer year) {
		this.id=id;
		this.name = name;
		this.year = year;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}	
}
