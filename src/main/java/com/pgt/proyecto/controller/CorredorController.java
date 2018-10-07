package com.pgt.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pgt.proyecto.dto.CorredorDTO;
import com.pgt.proyecto.service.CorredorService;

@RestController
public class CorredorController {

		@Autowired
		CorredorService corredorservice;
		
		@GetMapping("/corredor")
		public List<CorredorDTO> findAll(
				@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
				@RequestParam(defaultValue = "3", value = "size", required = false) Integer size,
				@RequestParam(value = "name", required = false) String name) {
			return corredorservice.findAllCorredor(PageRequest.of(page, size),name);
		}
		
		@GetMapping("/corredor/{idCorredor}")
		public CorredorDTO findById(@PathVariable Integer idCorredor) {
			return corredorservice.findById(idCorredor);
		}
		
		@PostMapping("/club/{id}/corredor")
		public CorredorDTO create(@PathVariable Integer id,@RequestBody CorredorDTO corredorDTO) {
			return corredorservice.create(corredorDTO, id);
		}
		
		@PutMapping("/club/{id}/corredor/{idCorredor}")
		public void update(@RequestBody CorredorDTO corredorToUpdate,@PathVariable Integer id,@PathVariable Integer idCorredor) {
			corredorservice.update(id,idCorredor, corredorToUpdate);
		}
		
		@DeleteMapping("/corredor/{idCorredor}")
		public void delete(@PathVariable Integer idCorredor) {
			corredorservice.delete(idCorredor);
		}
}
