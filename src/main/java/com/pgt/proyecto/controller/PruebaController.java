package com.pgt.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pgt.proyecto.dto.PruebaDTO;
import com.pgt.proyecto.service.PruebaService;

@RestController
@RequestMapping("/prueba")
public class PruebaController {
	
	@Autowired
	PruebaService pruebaservice;
	
	@GetMapping
	public List<PruebaDTO> findAll(@RequestParam(value = "name", required = false) String name) {
		return pruebaservice.findAll(name);
	}

	@GetMapping("/{id}")
	public PruebaDTO findById(@PathVariable Integer id) {
		return pruebaservice.findById(id);
	}

	@PostMapping
	public PruebaDTO create(@RequestBody PruebaDTO pruebaToCreate) {
		return pruebaservice.create(pruebaToCreate);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody PruebaDTO pruebaToUpdate,@PathVariable Integer id) {
		pruebaservice.update(id, pruebaToUpdate);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		pruebaservice.delete(id);
	}
}
