package com.pgt.proyecto.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgt.proyecto.service.ResultadoService;

@RestController
@RequestMapping("/query")
public class ResultadoController {

	@Autowired
	ResultadoService resultadoService;
	
	@GetMapping("/")
	public Map<String,Integer> clasificacion1() {
		return resultadoService.ranking("Jerez");
	}
}
