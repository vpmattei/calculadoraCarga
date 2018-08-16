package br.com.softplan.calculadoracarga.application;

import br.com.softplan.calculadoracarga.domain.Veiculo;

//Classe para salvar parâmetros
public class Parametros {
	protected double distanciaPavimentada;
	protected double distanciaNaoPavimentada;
	protected double toneladas;
	
	protected boolean caminhaoBau;
	protected boolean caminhaoCacamba;
	protected boolean carreta;
	
	private Veiculo veiculo;
	
	public void setDistancia(double distanciaPavimentada, double distanciaNaoPavimentada){
		this.distanciaPavimentada = distanciaPavimentada;
		this.distanciaNaoPavimentada = distanciaNaoPavimentada;
	}
	
	public double getDistanciaPavimentada(){
		return this.distanciaPavimentada;
	}
	
	public double getDistanciaNaoPavimentada(){
		return this.distanciaNaoPavimentada;
	}
	
	public void setVeiculo(Veiculo veiculo){
		this.veiculo = veiculo;
	}
	
	public Veiculo getVeiculo(){
		return veiculo;
	}
	
	public void setToneladas(double toneladas) {
		this.toneladas = toneladas;
	}
	
	public double getToneladas(){
		return this.toneladas;
	}
}