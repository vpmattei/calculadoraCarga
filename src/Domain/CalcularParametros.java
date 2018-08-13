package Domain;

public class CalcularParametros {
	
	private double valorTotal;
	private double distanciaPavimento;
	private double distanciaSemPavimento;
	private double distanciaTotal;
	private double precoDistancia;
	private double precoToneladas;
	
	public void setPrecoDistancia(double distPav, double distSemPav) {
		distanciaPavimento = distPav;
		distanciaSemPavimento = distSemPav;
		distanciaTotal = distanciaPavimento + distanciaSemPavimento;
		
		precoDistancia = distanciaPavimento*0.54 + distanciaSemPavimento*0.62;
		valorTotal = valorTotal + precoDistancia;
	}

	public void setPrecoToneladas(double ton) {
		if(ton > 5){
			ton = ton - 5;
			precoToneladas = ton*0.02*(distanciaTotal);
			valorTotal = valorTotal + precoToneladas;
		}
	}

	public void setPrecoVeiculo(boolean camBau, boolean camCac, boolean carreta) {
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

	public double getValorTotal() {
		return valorTotal;
	}
}