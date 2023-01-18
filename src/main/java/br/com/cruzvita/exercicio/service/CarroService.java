package br.com.cruzvita.exercicio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cruzvita.exercicio.model.Filtro;
import br.com.cruzvita.exercicio.request.CarroRequest;

@Service
public class CarroService {

	@Autowired
	private Filtro filtro;

	public String receberLista(CarroRequest carro) {

		try {
			if (carro.getListaCarro().isEmpty()) {
				return "Lista Vazia";
			}
		} catch (Exception ex) {
			String msg = ex.getMessage();
			return "Tentar novamente" + msg;
		}
		return (filtro.verificarTipoFiltro(carro));
	}
}