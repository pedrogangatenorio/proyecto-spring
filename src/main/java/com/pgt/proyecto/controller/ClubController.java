package com.pgt.proyecto.controller;

import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgt.proyecto.service.ClubService;

@RestController
@RequestMapping("/club")
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	@GetMapping
	public Map<String,Integer> clasificacion(Date fecha) {
		return clubService.getClasificacion(new Date());
	}
}


