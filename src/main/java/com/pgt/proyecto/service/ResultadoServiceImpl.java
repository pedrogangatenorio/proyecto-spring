package com.pgt.proyecto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgt.proyecto.dao.CorredorDAO;
import com.pgt.proyecto.dao.PruebaDAO;
import com.pgt.proyecto.dao.ResultadoDAO;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Resultado;


@Service
public class ResultadoServiceImpl implements ResultadoService{
	
	@Autowired
	PruebaDAO prueba;
	
	@Autowired
	ResultadoDAO resultado;
	
	@Autowired
	CorredorDAO corredor;
	
	public Map<String,Integer> ranking(String nombre){
		Map<String,Integer> m = new HashMap<>();
		Prueba p = prueba.findByNombre(nombre);
		List<Resultado> r = resultado.findByPrueba(p);		
		for(Resultado r1:r) {
			m.put(r1.getCorredor().getNombre(), r1.getTiempo());
		}
		return m;
	}
}
