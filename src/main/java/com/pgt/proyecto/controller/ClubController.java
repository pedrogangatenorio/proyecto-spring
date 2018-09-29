package com.pgt.proyecto.controller;

import java.util.Date;
import java.util.Iterator;
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
	public String clasificacion(Date fecha) {
		String s ="";
		Iterator it = clubService.getClasificacion(new Date()).keySet().iterator();
		while(it.hasNext()){
			  String key = it.next().toString();
			  s+="Clave: " + key + " -> Valor: " + clubService.getClasificacion(new Date()).get(key).toString();
		}
		return s;
	}
}


