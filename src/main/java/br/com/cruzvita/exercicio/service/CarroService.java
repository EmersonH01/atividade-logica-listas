package br.com.cruzvita.exercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cruzvita.exercicio.model.Carro;
import br.com.cruzvita.exercicio.model.Filtro;
import br.com.cruzvita.exercicio.request.CarroRequest;

@Service
public class CarroService {

	@Autowired
	private Filtro filtro;

	public List<Carro> receberLista(CarroRequest carro) {

		boolean filtroENome = filtro.verificaFiltroNome(carro.getFiltro().getTipoFiltro());
		System.out.println(filtroENome);

		boolean listaEVazia = filtro.verificaListaVazia(carro.getListaCarro());
		System.out.println(listaEVazia);

		if (listaEVazia) {

			return null;

		} else {
			if (filtroENome) {
				List<Carro> carrosSelecionadosPorNome = filtro.filtrarPorNome(carro.getListaCarro(), carro.getFiltro());
				return carrosSelecionadosPorNome;

			} else {
				List<Carro> carrosSelecionadosPorPreco = filtro.filtrarPorPreco(carro.getListaCarro(),
						carro.getFiltro());

				return carrosSelecionadosPorPreco;

			}
		}
	}

}
