package br.com.softplan.calculadoracarga.domain;

public class Veiculo {
	private double precoVeiculo;
	
	public void setVeiculo(boolean caminhaoBau, boolean caminhaoCacamba, boolean carreta, boolean mendigoCarregador){
		if(caminhaoBau){
			setPrecoVeiculo(1);
		} else if(caminhaoCacamba){
			setPrecoVeiculo(1.05);
		} else if(carreta){
			setPrecoVeiculo(1.12);
		} else if(mendigoCarregador){
			setPrecoVeiculo(0.5);
		}
	}

	public void setPrecoVeiculo(double precoVeiculo){
		this.precoVeiculo = precoVeiculo;
	}
	
	public double getPrecoVeiculo(){
		return this.precoVeiculo;
	}
}