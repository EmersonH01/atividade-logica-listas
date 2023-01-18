package br.com.cruzvita.exercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cruzvita.exercicio.request.CarroRequest;
import br.com.cruzvita.exercicio.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	
	@PostMapping("/recebe")
	public ResponseEntity<String> listarTodos(@RequestBody CarroRequest listaCarros){
		  return ResponseEntity.ok(carroService.receberLista(listaCarros));	  
	 }

}
