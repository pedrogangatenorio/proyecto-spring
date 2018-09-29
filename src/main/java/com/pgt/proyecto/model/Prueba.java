package com.pgt.proyecto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prueba {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPrueba;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prueba")
	private List<Resultado> resultados = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prueba")
	private List<Puntuacion> puntuaciones = new ArrayList<>();
	
	private String nombre;
	
	private Date fecha;
		
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdPrueba() {
		return idPrueba;
	}

	public void setIdPrueba(Integer idPrueba) {
		this.idPrueba = idPrueba;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public List<Puntuacion> getPuntuaciones() {
		return puntuaciones;
	}

	public void setPuntuaciones(List<Puntuacion> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}	
}
