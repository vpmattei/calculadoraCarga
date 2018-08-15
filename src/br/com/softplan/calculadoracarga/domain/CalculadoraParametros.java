package br.com.softplan.calculadoracarga.domain;

import br.com.softplan.calculadoracarga.application.Parametros;

public class CalculadoraParametros extends Parametros{
	
	private double distanciaTotal;
	private double precoDistancia;
	private double precoVeiculo = 1;
	private double precoToneladas;
	
	public void setDistanciaTotal(){
		this.distanciaTotal = getDistanciaPavimento() + getDistanciaSemPavimento();
	}
	
	public double getDistanciaTotal(){
		return this.distanciaTotal;
	}
	
	//Distancia pavimentada tem taxa de 0,54R$/km e não pavimentada 0,62R$/km
	public void setPrecoDistancia() {
		this.precoDistancia = getDistanciaPavimento()*0.54 + getDistanciaSemPavimento()*0.62;
	}
	
	//Cada veículo tem uma taxa unica sobre o valor total
	public void setPrecoVeiculo() {
		if(this.caminhaoBau) {
	        this.precoVeiculo = this.precoVeiculo*1;
	    }
	    else if(this.caminhaoCacamba) {
	    	this.precoVeiculo = this.precoVeiculo*1.05;
	    }
	    else if(this.carreta) {
	    	this.precoVeiculo = this.precoVeiculo*1.12;
	    }
	}
	
	//Caso peso ultrapasse 5t, aplicar taxa de a cada tonelada a mais, adicionar 0,02R$/km
	public void setPrecoToneladas() {
		if(this.toneladas > 5){
			this.toneladas = this.toneladas - 5;
			this.precoToneladas = this.toneladas*0.02*(this.distanciaTotal);
		}
		setValorTotal();
	}
	
	public void setValorTotal(){
		this.valorTotal += this.precoDistancia;
		this.valorTotal = this.valorTotal*this.precoVeiculo;
		this.valorTotal += this.precoToneladas;
		super.setValorTotal(this.valorTotal);
	}
	
	public double getValorTotal(){
		return this.valorTotal;
	}
}