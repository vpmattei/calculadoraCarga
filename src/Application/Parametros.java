package Application;

import Domain.CalcularParametros;

public class Parametros {
	
	CalcularParametros calculo = new CalcularParametros();
	
	private double distanciaPavimento;
	private double distanciaSemPavimento;
	private double toneladas;
	
	private boolean caminhaoBau;
	private boolean caminhaoCacamba;
	private boolean carreta;
	
	public void setDistancia(double distPav, double distSemPav){
		distanciaPavimento = distPav;
		distanciaSemPavimento = distSemPav;
		calculo.setPrecoDistancia(distanciaPavimento, distanciaSemPavimento);
	}

	public void setToneladas(double ton) {
		toneladas = ton;
		calculo.setPrecoToneladas(toneladas);
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
	
	public double getValorTotal(){
		return calculo.getValorTotal();
	}
}