package br.com.cruz.vita.exercicios.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.cruz.vita.exercicios.model.CarroModel;
import br.com.cruz.vita.exercicios.request.CarroRequest;

@Service
public class CarroService {

	
	   // 1-  Se a lista de carro estiver vazia , retorna um carro vazio 
	public CarroModel recebeLista(CarroRequest carro) {
		if (carro.getListaCarros().isEmpty()) {
			return new CarroModel();
		 }
		return verficarTipoFiltro(carro);
	   }
	
	
	
          // 2- Se o filtro for por nome , ele retorna carro .
	        // se for por por preço ele retorna carro .
	private CarroModel verficarTipoFiltro(CarroRequest carro) {
		if (carro.getFiltro().getTipoFiltro().equals("nome")) {
			return verificarNomeCarroFiltroParametro(carro);
		} else {
			return verificarPrecoCarroFiltroParametro(carro);
		}
	   }
	
	
	
	       //logica verificar preço
	private CarroModel verificarPrecoCarroFiltroParametro(CarroRequest carro) {
		for (CarroModel carroModel : carro.getListaCarros()) {
			var valorParametroPreco = new BigDecimal(carro.getFiltro().getParametro());
			if (carroModel.getPreco().equals(valorParametroPreco)) {
				return formatarPrecoCarro(carroModel);
		    }
		  }
		  return new CarroModel();
	     }

	
	
	          //logica por nome 
	private CarroModel verificarNomeCarroFiltroParametro(CarroRequest carro) {
		for (CarroModel carroModel : carro.getListaCarros()) {

			if (carroModel.getNome().equals(carro.getFiltro().getParametro())) {
				return formatarPrecoCarro(carroModel);
		  }
		 }
		return new CarroModel();
	   }
		
	
	
	         //logica para formatar o preço
	     //toString transforma tudo em String 
	    private CarroModel formatarPrecoCarro(CarroModel carroModel) {
		if (carroModel.getPreco().toString().length() == 5) {

			carroModel.setPreco(new BigDecimal(carroModel.getPreco().toString().substring(0, 2) + "."
					+ carroModel.getPreco().toString().substring(2, 5)));
			return carroModel;
		 }else {
         	carroModel.setPreco(new BigDecimal(carroModel.getPreco().toString().substring(0, 1) + "."
					+ carroModel.getPreco().toString().substring(1, 4)));
			return carroModel;
		}
	   } 
      }
