package br.com.cruzvita.exercicio.request;

import java.util.List;

import br.com.cruzvita.exercicio.model.Carro;
import br.com.cruzvita.exercicio.model.Filtro;
import lombok.Data;

@Data
public class CarroRequest {
	
	private List<Carro> listaCarro;
	
	private Filtro filtro;

}
