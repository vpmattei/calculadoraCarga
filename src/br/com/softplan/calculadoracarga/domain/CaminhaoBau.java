package br.com.softplan.calculadoracarga.domain;

public class CaminhaoBau extends Veiculo{
	public void setPrecoVeiculo(double precoVeiculo){
		this.precoVeiculo = precoVeiculo;
		System.out.println("Pre�o caminhao bau: " + this.precoVeiculo);
	}
}
