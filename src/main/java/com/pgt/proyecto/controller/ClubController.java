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
import com.pgt.proyecto.dto.ClubDTO;
import com.pgt.proyecto.service.ClubService;

@RestController
@RequestMapping("/club")
public class ClubController {
	
	@Autowired
	ClubService clubservice;

	@GetMapping
	public List<ClubDTO> findAll(@RequestParam(value = "name", required = false) String name) {
		return clubservice.findAll(name);
	}

	@GetMapping("/{id}")
	public ClubDTO findById(@PathVariable Integer id) {
		return clubservice.findById(id);
	}

	@PostMapping
	public ClubDTO create(@RequestBody ClubDTO clubToCreate) {
		return clubservice.create(clubToCreate);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody ClubDTO clubToUpdate,@PathVariable Integer id) {
		clubservice.update(id, clubToUpdate);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		clubservice.delete(id);
	}
}


