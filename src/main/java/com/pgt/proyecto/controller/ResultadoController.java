package com.pgt.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgt.proyecto.service.ResultadoService;

@RestController
@RequestMapping("/query")
public class ResultadoController {

	@Autowired
	ResultadoService resultadoService;
	
}
