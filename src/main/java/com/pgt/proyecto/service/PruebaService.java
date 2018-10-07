package com.pgt.proyecto.service;

import java.util.List;
import com.pgt.proyecto.dto.PruebaDTO;

public interface PruebaService {

	List<PruebaDTO> findAll(String name);

	PruebaDTO findById(Integer id);

	PruebaDTO create(PruebaDTO mapToModel);

	void update(Integer id, PruebaDTO mapToModel);

	void delete(Integer id);
}
