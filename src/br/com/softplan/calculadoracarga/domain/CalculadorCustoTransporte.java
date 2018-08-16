package br.com.softplan.calculadoracarga.domain;

import br.com.softplan.calculadoracarga.application.Parametros;

public class CalculadorCustoTransporte {
	
	private double precoDistancia;
	private double precoVeiculo;
	private double precoToneladas;
	
	public void setParametros(Parametros parametros){
		setPrecoDistancia(parametros.getDistanciaPavimentada(), parametros.getDistanciaNaoPavimentada());
		setPrecoVeiculo(parametros.getVeiculo());
		setPrecoToneladas(parametros.getToneladas(), parametros.getDistanciaPavimentada(), parametros.getDistanciaNaoPavimentada());
	}
	
	//Distancia pavimentada tem taxa de 0,54R$/km e não pavimentada 0,62R$/km
	public void setPrecoDistancia(double distanciaPavimentada, double distanciaNaoPavimentada) {
		this.precoDistancia = distanciaPavimentada*0.54 + distanciaNaoPavimentada*0.62;
	}
	
	//Cada veículo tem uma taxa unica sobre o valor total
	public void setPrecoVeiculo(Veiculo veiculo) {
		this.precoVeiculo = veiculo.getPrecoVeiculo();
	}
	
	//Caso peso ultrapasse 5t, aplicar taxa de a cada tonelada a mais, adicionar 0,02R$/km
	public void setPrecoToneladas(double toneladas, double distanciaPavimentada, double distanciaNaoPavimentada) {
		if(toneladas > 5){
			toneladas = toneladas - 5;
			this.precoToneladas = toneladas*0.02*(distanciaPavimentada + distanciaNaoPavimentada);
		}
	}
	
	public String calcularValorTotal(){
		double valorTotal = 0;
		valorTotal += this.precoDistancia;
		valorTotal = valorTotal*this.precoVeiculo;
		valorTotal += this.precoToneladas;
		return String.format("%.2f", valorTotal);
	}
	
	public void asdf() {
		System.out.println("asdf");
	}
}