package br.com.cruzvita.exercicio.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Filtro {

	private String tipoFiltro;
	private String parametro;

	public List<Carro> filtrarPorPreco(List<Carro> listaCarro2, Filtro filtro) {

		List<Carro> carrosSelecionados = new ArrayList<Carro>();
		for (Carro carroDaVez : listaCarro2) {
			if (carroDaVez.getPreco().equals(filtro.getParametro())) {
				String nomeCarro = formartarNomeUpperCase(carroDaVez.getNome());
				String precoFormatado = formatarPreco(carroDaVez.getPreco());
				carroDaVez.setPreco(precoFormatado);
				carroDaVez.setNome(nomeCarro);
				carrosSelecionados.add(carroDaVez);
			}
		}
		return carrosSelecionados;
	}

	public String formatarPreco(String preco) {

		if (preco.length() == 5) {

			return preco.substring(0, 2) + "." + preco.substring(2, 5);

			// 70000 70.000
		} else {
			return preco.substring(0, 1) + "." + preco.substring(1, 4);
			// 7000 7.000
		}

	}

	public List<Carro> filtrarPorNome(List<Carro> listaCarro2, Filtro filtro) {

		List<Carro> carrosSelecionados = new ArrayList<Carro>();

		for (Carro carroDaVez : listaCarro2) {

			if (carroDaVez.getNome().equals(filtro.getParametro())) {
				String nomeCarro = formartarNomeUpperCase(carroDaVez.getNome());
				String precoFormatado = formatarPreco(carroDaVez.getPreco());
				carroDaVez.setPreco(precoFormatado);
				carroDaVez.setNome(nomeCarro);
				carrosSelecionados.add(carroDaVez);

			}
		}

		return carrosSelecionados;
	}

	public String formartarNomeUpperCase(String nomeCarro) {
		return nomeCarro.toUpperCase();

	}

	public boolean verificaListaVazia(List<Carro> listaCarro2) {
		if (listaCarro2.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean verificaFiltroNome(String tipoFiltro) {
		if (tipoFiltro.equals("nome")) {
			return true;
		} else {
			return false;
		}
	}
	
}
