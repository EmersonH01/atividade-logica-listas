package br.com.cruz.vita.exercicios.request;

import java.util.List;

import br.com.cruz.vita.exercicios.model.CarroModel;
import br.com.cruz.vita.exercicios.model.Filtro;
import lombok.Data;

@Data
public class CarroRequest {

	private List<CarroModel> listaCarros;
	
	private Filtro filtro;
	
	
}
