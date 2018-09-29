package com.pgt.proyecto.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Resultado;

public interface ResultadoDAO extends JpaRepository<Resultado, Integer>{
	
	@Query("FROM Resultado p WHERE p.prueba = :idPrueba ORDER BY tiempo ASC")
	public List<Resultado> findByPrueba(@Param("idPrueba") Prueba idPrueba);
}

