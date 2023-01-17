package br.com.cruz.vita.exercicios.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.cruz.vita.exercicios.model.CarroModel;
import br.com.cruz.vita.exercicios.request.CarroRequest;

@Service
public class CarroService {
//aaaaaaaaaaaaaaaaa
	private final String error = "Seus dados estão incorretos " ;
	
	// ------A lista estando vazia , retorna lista vazia-------//
	public String recebeLista(CarroRequest carro) {
		try {
			if (carro.getListaCarros().isEmpty()) {
				return "Sua lista esta vazia ";
			}
		} catch (Exception ae) {
			System.out.println("insira um valor para buscar");
	}
		return (verficarTipoFiltro(carro));

	}

	// 2- Se o filtro for por nome , ele retorna carro .
	// se for por por preço ele retorna carro .
	private String verficarTipoFiltro(CarroRequest carro) {
		try {
			if (carro.getFiltro().getTipoFiltro().equals("nome")) {
				return verificarCarroEncotrado(verificarNomeCarroFiltroParametro(carro));
			} else {
				return verificarCarroEncotrado(verificarPrecoCarroFiltroParametro(carro));
			}
		} catch (Exception ea) {
			ea.printStackTrace();
			return "Seus dados estão incorretos";
		}
	  }

     private String verificarCarroEncotrado(CarroModel carro) {
    	 if(carro.getNome() == null ) {
    		 return error ;
    	 }
		return carro.toString();
	 }


	// logica verificar preço
	private CarroModel verificarPrecoCarroFiltroParametro(CarroRequest carro) {
		for (CarroModel carroModel : carro.getListaCarros()) {
			try {
				var valorParametroPreco = new BigDecimal(carro.getFiltro().getParametro());
				if (carroModel.getPreco().equals(valorParametroPreco)) {
					return formatarPrecoCarro(carroModel);
				}
			} catch (Exception e) {
				System.out.println("Os valores que voce didgitou esta incorreto");
			 }
		 }
		return new CarroModel();
	 }

	// ------ Logica do nome ------ //
	private CarroModel verificarNomeCarroFiltroParametro(CarroRequest carro) {
		for (CarroModel carroModel : carro.getListaCarros()) {

			if (carroModel.getNome().equals(carro.getFiltro().getParametro())) {
				return formatarPrecoCarro(carroModel);
			}
		}
		return new CarroModel();
	}

	// -----logica para formatar o preço------//
	private CarroModel formatarPrecoCarro(CarroModel carroModel) {
		if (carroModel.getPreco().toString().length() == 5) {

			carroModel.setPreco(new BigDecimal(carroModel.getPreco().toString().substring(0, 2) + "."
					+ carroModel.getPreco().toString().substring(2, 5)));
			return carroModel;
		} else {
			carroModel.setPreco(new BigDecimal(carroModel.getPreco().toString().substring(0, 1) + "."
					+ carroModel.getPreco().toString().substring(1, 4)));
			return carroModel;
		}
	}
}
