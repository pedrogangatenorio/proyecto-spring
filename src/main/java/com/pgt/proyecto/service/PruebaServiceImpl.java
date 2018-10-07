package com.pgt.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.PruebaDAO;
import com.pgt.proyecto.dto.PruebaDTO;
import com.pgt.proyecto.mapper.PruebaMapper;
import com.pgt.proyecto.model.Prueba;

@Service
public class PruebaServiceImpl implements PruebaService{

	@Autowired
	PruebaDAO dao;
	
	@Autowired
	PruebaMapper mapper;
	
	@Override
	public List<PruebaDTO> findAll(String name) {
		return name!= null ? mapper.mapToDTO(dao.findByName(name)) : mapper.mapToDTO(dao.findAll());
	}

	@Override
	public PruebaDTO findById(Integer id) {
		return mapper.mapToDTO(dao.findById(id).get());
	}

	@Override
	public PruebaDTO create(PruebaDTO mapToModel) {
		return mapper.mapToDTO(dao.save(mapper.mapToModel(mapToModel)));
	}

	@Override
	public void update(Integer id, PruebaDTO mapToModel) {
		Prueba p = mapper.mapToModel(mapToModel);
		p.setId(id);
		dao.saveAndFlush(p);		
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);		
	}
}
