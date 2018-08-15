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
	
	public void setDistancia(double distanciaPavimento, double distanciaSemPavimento){
		this.distanciaPavimento = distanciaPavimento;
		this.distanciaSemPavimento = distanciaSemPavimento;
		System.out.println("distancia pavimento: " + this.distanciaPavimento);
		System.out.println("distancia sem pavimento: " + this.distanciaSemPavimento);
	}
	
	public double getDistanciaPavimento(){
		return this.distanciaPavimento;
	}
	
	public double getDistanciaSemPavimento(){
		return this.distanciaSemPavimento;
	}
	Veiculo veiculo = new Veiculo();
	public void setVeiculo(boolean caminhaoBau, boolean caminhaoCacamba, boolean carreta, boolean mendigoCarregador){
		veiculo.setVeiculo(caminhaoBau, caminhaoCacamba, carreta, mendigoCarregador);
	}
	
	public Veiculo getVeiculo(){
		return veiculo;
	}
	
	public void setToneladas(double toneladas) {
		this.toneladas = toneladas;
		System.out.println("toneladas: " + this.toneladas);
	}
	
	public double getToneladas(){
		return this.toneladas;
	}
}