package com.pgt.proyecto.service;

import java.util.List;
import java.util.Map;
import com.pgt.proyecto.dto.ClasificacionDTO;
import com.pgt.proyecto.dto.ResultadoDTO;

public interface ResultadoService {

	List<ResultadoDTO> findAllCorredor();

	ResultadoDTO findById(Integer id);

	void delete(Integer id);

	ResultadoDTO create(ResultadoDTO mapToModel, Integer id);

	void update(Integer id,Integer idResultado, ResultadoDTO mapToModel);

	Map<String,Integer> clasificacionPrueba(Integer id);

	List<ClasificacionDTO> clasificacionCategoria(Integer id, Integer categoria);
}
