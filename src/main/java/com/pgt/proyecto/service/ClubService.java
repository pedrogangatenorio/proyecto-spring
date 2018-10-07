package com.pgt.proyecto.service;

import java.util.List;
import com.pgt.proyecto.dto.ClubDTO;

public interface ClubService {

	List<ClubDTO> findAll(String name);

	ClubDTO findById(Integer id);

	ClubDTO create(ClubDTO clubDTO);

	void update(Integer id, ClubDTO clubDTO);

	void delete(Integer id);
}
