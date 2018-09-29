package com.pgt.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Puntuacion;

public interface PuntuacionDAO extends JpaRepository<Puntuacion, Integer>{
	
	@Query("FROM Puntuacion p WHERE p.prueba = :idPrueba ORDER BY posicion ASC")
	public List<Puntuacion> findByPrueba(@Param("idPrueba") Prueba idPrueba);
}
