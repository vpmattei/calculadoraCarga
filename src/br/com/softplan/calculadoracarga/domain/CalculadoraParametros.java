package br.com.softplan.calculadoracarga.domain;

import br.com.softplan.calculadoracarga.application.Parametros;

public class CalculadoraParametros extends Parametros{
	
	private double precoDistancia;
	private double precoVeiculo;
	private double precoToneladas;
	private double valorTotal = 0;
	
	public void setParametros(Parametros parametros){
		setPrecoDistancia(parametros.getDistanciaPavimento(), parametros.getDistanciaSemPavimento());
		setPrecoVeiculo(parametros.getVeiculo());
		setPrecoToneladas(parametros.getToneladas());
	}
	
	//Distancia pavimentada tem taxa de 0,54R$/km e não pavimentada 0,62R$/km
	public void setPrecoDistancia(double distanciaPavimento, double distanciaSemPavimento) {
		this.precoDistancia = distanciaPavimento*0.54 + distanciaSemPavimento*0.62;
	}
	
	//Cada veículo tem uma taxa unica sobre o valor total
	public void setPrecoVeiculo(Veiculo veiculo) {
		this.precoVeiculo = veiculo.getPrecoVeiculo();
	}
	
	//Caso peso ultrapasse 5t, aplicar taxa de a cada tonelada a mais, adicionar 0,02R$/km
	public void setPrecoToneladas(double toneladas) {
		if(toneladas > 5){
			toneladas = toneladas - 5;
			this.precoToneladas = toneladas*0.02*(getDistanciaPavimento() + getDistanciaSemPavimento());
		}
	}
	
	public void setValorTotal(){
		this.valorTotal += this.precoDistancia;
		this.valorTotal = this.valorTotal*this.precoVeiculo;
		this.valorTotal += this.precoToneladas;
	}
	
	public double getValorTotal(){
		return this.valorTotal;
	}
}