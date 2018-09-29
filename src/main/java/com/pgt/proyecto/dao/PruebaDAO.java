package com.pgt.proyecto.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pgt.proyecto.model.Prueba;

public interface PruebaDAO extends JpaRepository<Prueba, Integer>{
	
	@Query("FROM Prueba p WHERE p.fecha <= :date")
	public List<Prueba> findByFecha(@Param("date") Date date);
	
	@Query("Select p FROM Prueba p WHERE p.nombre = :nombre")
	public Prueba findByNombre(@Param("nombre") String nombre);
}


