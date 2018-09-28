package com.pgt.proyecto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Corredor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCorredor;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corredor")
	private List<Resultado> resultados = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Club club;
	
	private String nombre;
	
	private Integer edad;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getIdCorredor() {
		return idCorredor;
	}

	public void setIdCorredor(Integer idCorredor) {
		this.idCorredor = idCorredor;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}	
}
