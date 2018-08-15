package br.com.softplan.calculadoracarga.domain;

public class Veiculo {
	protected double precoVeiculo;
	
	public void setVeiculo(boolean caminhaoBau, boolean caminhaoCacamba, boolean carreta, boolean mendigoCarregador){
		CaminhaoBau novoCaminhaoBau = new CaminhaoBau();
		CaminhaoCacamba novoCaminhaoCacamba = new CaminhaoCacamba();
		Carreta novoCarreta = new Carreta();
		MendigoCarregador novoMendigoCarregador = new MendigoCarregador();
		
		if(caminhaoBau){
			novoCaminhaoBau.setPrecoVeiculo(1);
		} else if(caminhaoCacamba){
			novoCaminhaoCacamba.setPrecoVeiculo(1.05);
		} else if(carreta){
			novoCarreta.setPrecoVeiculo(1.12);
		} else if(mendigoCarregador){
			novoMendigoCarregador.setPrecoVeiculo(0.5);
		}
	}
	
	public double getPrecoVeiculo(){
		return this.precoVeiculo;
	}
}