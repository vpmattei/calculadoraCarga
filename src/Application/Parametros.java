package Application;

import Domain.CalcularParametros;

public class Parametros {
	
	CalcularParametros calculo = new CalcularParametros();
	
	private double distPav, distSemPav, ton;
	private boolean camBau = false, camCac = false, carreta = false;
	
	public void SetDist(double distPav, double distSemPav){
		this.distPav = distPav;
		this.distSemPav = distSemPav;
		calculo.SetPrecoDist(this.distPav, this.distSemPav);
	}

	public void SetToneladas(double ton) {
		this.ton = ton;
		calculo.SetPrecoToneladas(this.ton);
	}

	public void SetVeiculo(boolean camBau, boolean camCac, boolean carreta){
		if(camBau){
			this.camBau = camBau;
		} else if(camCac){
			this.camCac = camCac;
		} else if(carreta){
			this.carreta = carreta;
		}
		calculo.SetPrecoVeiculo(this.camBau, this.camCac, this.carreta);
	}
	
	public double GetValorTotal(){
		return calculo.GetValorTotal();
	}
}