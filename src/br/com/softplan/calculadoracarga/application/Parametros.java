package br.com.softplan.calculadoracarga.application;

import br.com.softplan.calculadoracarga.domain.CalculadoraParametros;

//Classe para salvar parâmetros
public class Parametros {
	
	CalculadoraParametros calculo = new CalculadoraParametros();
	
	private double distanciaPavimento;
	private double distanciaSemPavimento;
	private double toneladas;
	private double valorTotal;
	
	private boolean caminhaoBau;
	private boolean caminhaoCacamba;
	private boolean carreta;
	
	public void setDistancia(double distPav, double distSemPav){
		distanciaPavimento = distPav;
		distanciaSemPavimento = distSemPav;
		calculo.setPrecoDistancia(distanciaPavimento, distanciaSemPavimento);
	}

	public void setVeiculo(boolean camBau, boolean camCac, boolean carreta){
		if(camBau){
			caminhaoBau = camBau;
		} else if(camCac){
			caminhaoCacamba = camCac;
		} else if(carreta){
			this.carreta = carreta;
		}
		calculo.setPrecoVeiculo(caminhaoBau, caminhaoCacamba, this.carreta);
	}
	
	public void setToneladas(double ton) {
		toneladas = ton;
		calculo.setPrecoToneladas(toneladas);
	}
	
	public void setValorTotal(double valorTotal){
		this.valorTotal = valorTotal;
	}
	
	public double getValorTotal(){
		return this.valorTotal;
	}
}