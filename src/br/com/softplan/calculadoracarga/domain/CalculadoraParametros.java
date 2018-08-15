package br.com.softplan.calculadoracarga.domain;

import br.com.softplan.calculadoracarga.application.Parametros;

public class CalculadoraParametros extends Parametros{
	
	private double precoDistancia;
	private double precoVeiculo;
	private double precoToneladas;
	private double valorTotal = 0;
	
	public void setPrecos(){
		setPrecoDistancia();
		setPrecoVeiculo();
		setPrecoToneladas();
	}
	
	//Distancia pavimentada tem taxa de 0,54R$/km e não pavimentada 0,62R$/km
	public void setPrecoDistancia() {
		this.precoDistancia = getDistanciaPavimento()*0.54 + getDistanciaSemPavimento()*0.62;
		System.out.println("distancia pavimento(Calculadora): " + this.distanciaPavimento);
		System.out.println("distancia sem pavimento(Calculadora): " + this.distanciaSemPavimento);
		System.out.println("preco distancia: " + this.precoDistancia);
	}
	
	//Cada veículo tem uma taxa unica sobre o valor total
	public void setPrecoVeiculo() {
		Veiculo veiculo = new Veiculo();
		this.precoVeiculo = veiculo.getPrecoVeiculo();
		System.out.println("preco veiculo: " + this.precoVeiculo);
	}
	
	//Caso peso ultrapasse 5t, aplicar taxa de a cada tonelada a mais, adicionar 0,02R$/km
	public void setPrecoToneladas() {
		if(this.toneladas > 5){
			this.toneladas = this.toneladas - 5;
			this.precoToneladas = this.toneladas*0.02*(getDistanciaPavimento() + getDistanciaSemPavimento());
		}
		System.out.println("preco toneladas: " + this.precoToneladas);
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