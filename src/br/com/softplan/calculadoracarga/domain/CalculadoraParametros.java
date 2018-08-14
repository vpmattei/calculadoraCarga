package br.com.softplan.calculadoracarga.domain;

import br.com.softplan.calculadoracarga.application.Parametros;

public class CalculadoraParametros {
	
	private double valorTotal;
	private double distanciaTotal;
	private double precoDistancia;
	private double precoToneladas;
	
	//Distancia pavimentada tem taxa de 0,54R$/km e não pavimentada 0,62R$/km
	public void setPrecoDistancia(double distPav, double distSemPav) {
		distanciaTotal = distPav + distSemPav;
		precoDistancia = distPav*0.54 + distSemPav*0.62;
		valorTotal = valorTotal + precoDistancia;
	}
	
	//Cada veículo tem uma taxa unica sobre o valor total
	public void setPrecoVeiculo(boolean camBau, boolean camCac, boolean carreta) {
		if(camBau) {
	        valorTotal = valorTotal*1;
	    }
	    else if(camCac) {
	        valorTotal = valorTotal*1.05;
	    }
	    else if(carreta) {
	        valorTotal = valorTotal*1.12;
	    }
	}
	
	//Caso peso ultrapasse 5t, aplicar taxa de a cada tonelada a mais, adicionar 0,02R$/km
	public void setPrecoToneladas(double ton) {
		if(ton > 5){
			ton = ton - 5;
			precoToneladas = ton*0.02*(distanciaTotal);
			valorTotal = valorTotal + precoToneladas;
		}
		setValorTotal();
	}

	public void setValorTotal() {
		Parametros parametro = new Parametros();
		parametro.setValorTotal(valorTotal);
	}
}