package com.pgt.proyecto.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pgt.proyecto.dto.ClasificacionDTO;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.service.ResultadoService;

@RestController
public class ResultadoController {

	@Autowired
	ResultadoService resultadoservice;
	
	@GetMapping("/resultado")
	public List<ResultadoDTO> findAll() {
		return resultadoservice.findAllCorredor();
	}
	
	@GetMapping("/resultado/{id}")
	public ResultadoDTO findById(@PathVariable Integer id) {
		return resultadoservice.findById(id);
	}
	
	@GetMapping("/prueba/{id}/resultado")
	public Map<String,Integer> clasificacionPrueba(@PathVariable Integer id){
		return resultadoservice.clasificacionPrueba(id);
	}
	
	@GetMapping("/prueba/{id}/categoria/{categoria}")
	public List<ClasificacionDTO> clasificacionCategoria(@PathVariable Integer id,@PathVariable Integer categoria){
		return resultadoservice.clasificacionCategoria(id,categoria);
	}
	
	@PostMapping("/prueba/{id}/resultado")
	public ResultadoDTO create(@PathVariable Integer id,@RequestBody ResultadoDTO resultadoDTO) {
		return resultadoservice.create(resultadoDTO, id);
	}
	
	@PutMapping("/prueba/{id}/resultado/{idResultado}")
	public void update(@RequestBody ResultadoDTO resultadoToUpdate,@PathVariable Integer id,
			@PathVariable Integer idResultado) {
		resultadoservice.update(id,idResultado, resultadoToUpdate);
	}
	
	@DeleteMapping("/resultado/{id}")
	public void delete(@PathVariable Integer id) {
		resultadoservice.delete(id);
	}
}
