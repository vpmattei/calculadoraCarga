package br.com.softplan.calculadoracarga.domain;

public class Veiculo {
	protected double precoVeiculo;
	
	public void setVeiculo(boolean caminhaoBau, boolean caminhaoCacamba, boolean carreta, boolean mendigoCarregador){
		Veiculo novoCaminhaoBau = new Veiculo();
		Veiculo novoCaminhaoCacamba = new Veiculo();
		Veiculo novoCarreta = new Veiculo();
		Veiculo novoMendigoCarregador = new Veiculo();
		
		/*
		if(caminhaoBau){
			System.out.println("Caminhao Bau: " + caminhaoBau);
			novoCaminhaoBau.
		} else if(caminhaoCacamba){
			novoCaminhaoCacamba.setPrecoVeiculo(1.05);
		} else if(carreta){
			novoCarreta.setPrecoVeiculo(1.12);
		} else if(mendigoCarregador){
			novoMendigoCarregador.setPrecoVeiculo(0.5);
		}*/
	}
	

	
	public double getPrecoVeiculo(){
		System.out.println("Preço caminhao bau: " + this.precoVeiculo);
		return this.precoVeiculo;
	}
}