package com.pgt.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.PruebaDAO;
import com.pgt.proyecto.dao.ResultadoDAO;


@Service
public class ResultadoServiceImpl implements ResultadoService{
	
	@Autowired
	PruebaDAO prueba;
	
	@Autowired
	ResultadoDAO resultado;
}
