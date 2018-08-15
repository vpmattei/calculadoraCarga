package br.com.softplan.calculadoracarga.application;

import br.com.softplan.calculadoracarga.domain.Veiculo;

//Classe para salvar parâmetros
public class Parametros {
	protected double distanciaPavimento;
	protected double distanciaSemPavimento;
	protected double toneladas;
	
	protected boolean caminhaoBau;
	protected boolean caminhaoCacamba;
	protected boolean carreta;
	
	private Veiculo veiculo;
	
	public void setDistancia(double distanciaPavimento, double distanciaSemPavimento){
		this.distanciaPavimento = distanciaPavimento;
		this.distanciaSemPavimento = distanciaSemPavimento;
	}
	
	public double getDistanciaPavimento(){
		return this.distanciaPavimento;
	}
	
	public double getDistanciaSemPavimento(){
		return this.distanciaSemPavimento;
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