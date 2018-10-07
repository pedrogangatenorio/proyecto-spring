package com.pgt.proyecto.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.ResultadoDAO;
import com.pgt.proyecto.dto.ClasificacionDTO;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.mapper.PruebaMapper;
import com.pgt.proyecto.mapper.ResultadoMapper;
import com.pgt.proyecto.model.Puntuacion;
import com.pgt.proyecto.model.Resultado;
import com.pgt.proyecto.operation.Ranking;

@Service
public class ResultadoServiceImpl implements ResultadoService{
	
	@Autowired
	ResultadoDAO dao;
	
	@Autowired
	CorredorService corredorService;
	
	@Autowired
	PruebaService pruebaService;
	
	@Autowired
	PuntuacionService puntuacionService;
	
	@Autowired
	Ranking ranking;
	
	@Autowired
	PruebaMapper mapper;
	
	@Autowired
	ResultadoMapper resultadomapper;

	@Override
	public List<ResultadoDTO> findAllCorredor() {
		return resultadomapper.mapToDTO(dao.findAll());
	}

	@Override
	public ResultadoDTO findById(Integer id) {
		return resultadomapper.mapToDTO(dao.findById(id).get());
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);			
	}

	@Override
	public ResultadoDTO create(ResultadoDTO mapToModel, Integer id) {
		Resultado r = resultadomapper.mapToModel(mapToModel);
		r.setPrueba(mapper.mapToModel(pruebaService.findById(id)));
		return resultadomapper.mapToDTO(dao.save(r));
	}

	@Override
	public void update(Integer id, Integer idResultado, ResultadoDTO mapToModel) {
		final Optional<Resultado> resultadoToUpdate = dao.findById(idResultado);
		resultadoToUpdate.get().setSeconds(resultadomapper.mapToModel(mapToModel).getSeconds());
		resultadoToUpdate.get().setPrueba(mapper.mapToModel(pruebaService.findById(id)));
		dao.save(resultadoToUpdate.get());
	}

	@Override
	public Map<String,Integer> clasificacionPrueba(Integer id) {
		return opera(dao.findByPrueba(mapper.mapToModel(pruebaService.findById(id))),puntuacionService.getPuntuacion(mapper.mapToModel(pruebaService.findById(id))),id);
	}
	
	public Map<String,Integer> opera(List<Resultado> result,List<Puntuacion> puntos,Integer id) {
		Map<String, Integer> res = new HashMap<>();
		for (int i=0;i<puntos.size();i++) {
			String nombre = result.get(i).getCorredor().getClub().getName();
			Integer puntu = puntos.get(i).getPuntos();
			if(res.get(nombre)==null) {
				res.put(nombre, puntu);
			}else {
				res.put(nombre, res.get(nombre)+puntu);
			}
		}
		ranking.escribefichero(res,mapper.mapToModel(pruebaService.findById(id)).getName());
		return res;
	}

	@Override
	public List<ClasificacionDTO> clasificacionCategoria(Integer id, Integer categoria) {
		return resultadomapper.mapToDTOC(dao.findByCategoria(mapper.mapToModel(pruebaService.findById(id)), Calendar.getInstance().get(Calendar.YEAR) - categoria));
	}
}
