package Domain;

public class CalcularParametros {
	
	private double valorTotal;
	private double distPav, distSemPav, precoDist, precoTon;
	
	public void SetPrecoDist(double distPav, double distSemPav) {
		this.distPav = distPav;
		this.distSemPav = distSemPav;
		precoDist = this.distPav*0.54 + this.distSemPav*0.62;
		valorTotal = valorTotal + precoDist;
	}

	public void SetPrecoToneladas(double ton) {
		if(ton > 5){
			ton = ton - 5;
			precoTon = ton*0.02*(distPav+distSemPav);
			valorTotal = valorTotal + precoTon;
		}
	}

	public void SetPrecoVeiculo(boolean camBau, boolean camCac, boolean carreta) {
		if(camBau) {
	        valorTotal = valorTotal*1;
	    }
	    else if(camCac) {
	        valorTotal = valorTotal*1.05;
	    }
	    else if(carreta) {
	        valorTotal = valorTotal*1.12;
	    }
	}

	public double GetValorTotal() {
		return valorTotal;
	}
}