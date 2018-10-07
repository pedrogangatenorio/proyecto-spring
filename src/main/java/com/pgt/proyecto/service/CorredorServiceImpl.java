package com.pgt.proyecto.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.CorredorDAO;
import com.pgt.proyecto.dto.CorredorDTO;
import com.pgt.proyecto.mapper.ClubMapper;
import com.pgt.proyecto.mapper.CorredorMapper;
import com.pgt.proyecto.model.Corredor;

@Service
public class CorredorServiceImpl implements CorredorService{
	
	@Autowired
	CorredorDAO dao;
	
	@Autowired
	ClubService clubservice;
	
	@Autowired
	ClubMapper mapper;
	
	@Autowired
	CorredorMapper corredormapper;

	@Override
	public List<CorredorDTO> findAllCorredor(Pageable pagination,String name) {
		return name != null ? corredormapper.mapToDTO(dao.findByNameContaining(name, pagination).getContent()) : corredormapper.mapToDTO(dao.findAll());
	}

	@Override
	public CorredorDTO findById(Integer id) {
		return corredormapper.mapToDTO(dao.findById(id).get());
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	public CorredorDTO create(CorredorDTO corredorToCreate, Integer id) {
		Corredor c = corredormapper.mapToModel(corredorToCreate);
		c.setClub(mapper.mapToModel(clubservice.findById(id)));
		return corredormapper.mapToDTO(dao.save(c));
	}

	@Override
	public void update(Integer id, Integer idCorredor, CorredorDTO corredor) {
		Corredor c = corredormapper.mapToModel(corredor);
		final Optional<Corredor> corredorToUpdate = dao.findById(idCorredor);
		corredorToUpdate.get().setName(c.getName());
		corredorToUpdate.get().setYear(c.getYear());
		corredorToUpdate.get().setClub(mapper.mapToModel(clubservice.findById(id)));
		dao.save(corredorToUpdate.get());		
	}
}
