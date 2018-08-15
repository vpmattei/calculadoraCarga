package br.com.softplan.calculadoracarga.application;
 
//Classe para salvar parâmetros
public class Parametros {
	protected double distanciaPavimento;
	protected double distanciaSemPavimento;
	protected double toneladas;
	protected double valorTotal = 0;
	
	protected boolean caminhaoBau;
	protected boolean caminhaoCacamba;
	protected boolean carreta;
	
	public void setDistancia(double distanciaPavimento, double distanciaSemPavimento){
		this.distanciaPavimento = distanciaPavimento;
		this.distanciaSemPavimento = distanciaSemPavimento;
	}
	
	protected double getDistanciaPavimento(){
		return this.distanciaPavimento;
	}
	
	protected double getDistanciaSemPavimento(){
		return this.distanciaSemPavimento;
	}

	public void setVeiculo(boolean caminhaoBau, boolean caminhaoCacamba, boolean carreta){
		if(caminhaoBau){
			this.caminhaoBau = caminhaoBau;
		} else if(caminhaoCacamba){
			this.caminhaoCacamba = caminhaoCacamba;
		} else if(carreta){
			this.carreta = carreta;
		}
	}
	
	public void setToneladas(double toneladas) {
		this.toneladas = toneladas;
	}
	
	
	public void setValorTotal(double valorTotal){
		this.valorTotal = valorTotal;
	}
	
	public double getValorTotal(){
		return this.valorTotal;
	}
}