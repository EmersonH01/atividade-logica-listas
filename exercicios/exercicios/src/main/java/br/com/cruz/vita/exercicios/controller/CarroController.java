package br.com.cruz.vita.exercicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cruz.vita.exercicios.model.CarroModel;
import br.com.cruz.vita.exercicios.request.CarroRequest;
import br.com.cruz.vita.exercicios.service.CarroService;

@RestController
@RequestMapping ("carro/")
 public class CarroController {
	
	
	@Autowired
	private CarroService carroservice;
	
	
	 @PostMapping("/buscar")
	    public ResponseEntity<String> listarTodos(@RequestBody CarroRequest listaCarros){
		  CarroModel carroRetorno = carroservice.recebeLista(listaCarros);
		  
		 if(carroRetorno.getNome() == null ) {
			 return ResponseEntity.ok("Carro não encontrado."); 
		 }
		  return ResponseEntity.ok(carroRetorno.toString().toUpperCase());      
	    } 
	 
}