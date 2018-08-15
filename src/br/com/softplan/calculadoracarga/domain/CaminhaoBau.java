package br.com.softplan.calculadoracarga.domain;
@Deprecated
public class CaminhaoBau extends Veiculo{
	public void setPrecoVeiculo(double precoVeiculo){
		this.precoVeiculo = precoVeiculo;
		System.out.println("Preço caminhao bau: " + this.precoVeiculo);
	}
	
	public double getPrecoVeiculo(){
		return this.precoVeiculo;
	}
}
