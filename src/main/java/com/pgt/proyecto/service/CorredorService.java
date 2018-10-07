package com.pgt.proyecto.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.pgt.proyecto.dto.CorredorDTO;

public interface CorredorService {

	List<CorredorDTO> findAllCorredor(Pageable of,String name);
	
	CorredorDTO findById(Integer id);

	void delete(Integer id);

	CorredorDTO create(CorredorDTO corredorToCreate, Integer id);

	void update(Integer id, Integer idCorredor, CorredorDTO corredor);

}
