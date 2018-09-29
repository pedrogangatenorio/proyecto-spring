package com.pgt.proyecto.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.PruebaDAO;
import com.pgt.proyecto.dao.PuntuacionDAO;
import com.pgt.proyecto.dao.ResultadoDAO;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Puntuacion;
import com.pgt.proyecto.model.Resultado;

@Service
public class ClubServiceImpl implements ClubService{
	
	@Autowired
	PruebaDAO prueba;
	
	@Autowired
	ResultadoDAO resultado;
	
	@Autowired
	PuntuacionDAO puntuacion;
	
	public Map<String, Integer> getClasificacion(Date fecha){
		Map<String, Integer> res = new HashMap<>();
		List<Prueba> pruebas = prueba.findByFecha(new Date());
		for (Prueba p: pruebas) {
			List<Resultado> result = resultado.findByPrueba(p);
			List<Puntuacion> puntos = puntuacion.findByPrueba(p);
			opera(res,result,puntos);
		}
		return res;
	}
	
	public void opera(Map<String, Integer> res,List<Resultado> result,List<Puntuacion> puntos) {
		for (int i=0;i<puntos.size();i++) {
			String nombre = result.get(i).getCorredor().getClub().getNombre();
			Integer puntu = puntos.get(i).getPuntos();
			if(res.get(nombre)==null) {
				res.put(nombre, puntu);
			}else {
				Integer old = res.get(nombre);
				res.put(nombre, old+puntu);
			}
		}
	}
}
