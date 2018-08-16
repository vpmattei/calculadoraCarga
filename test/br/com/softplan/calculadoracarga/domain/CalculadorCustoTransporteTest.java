package br.com.softplan.calculadoracarga.domain;

import junit.framework.Assert;

import org.junit.Test;

import br.com.softplan.calculadoracarga.application.Parametros;

public class CalculadorCustoTransporteTest {
	
	@Test
	public void testeEmRodoviaPavimentadaComCaminhaoCacambaComOitoToneladas() {
		Parametros parametros = new Parametros();
		parametros.setDistancia(100, 0);
		parametros.setVeiculo(new CaminhaoCacamba());
		parametros.setToneladas(8);
		
		CalculadorCustoTransporte calculador = new CalculadorCustoTransporte();
		calculador.setParametros(parametros);
		
		String valorTotal = calculador.calcularValorTotal();
		
		Assert.assertEquals("62,70", valorTotal);
	}
	
	@Test
	public void testeEmRodoviaNaoPavimentadaComCaminhaoBauComQuatroToneladas() {
		Parametros parametros = new Parametros();
		parametros.setDistancia(0, 60);
		parametros.setVeiculo(new CaminhaoBau());
		parametros.setToneladas(4);
		
		CalculadorCustoTransporte calculador = new CalculadorCustoTransporte();
		calculador.setParametros(parametros);
		
		String valorTotal = calculador.calcularValorTotal();
		
		Assert.assertEquals("37,20", valorTotal);
	}
	
	@Test
	public void testeEmRodoviaNaoPavimentadaComCarretaComDozeToneladas() {
		Parametros parametros = new Parametros();
		parametros.setDistancia(0, 180);
		parametros.setVeiculo(new Carreta());
		parametros.setToneladas(12);
		
		CalculadorCustoTransporte calculador = new CalculadorCustoTransporte();
		calculador.setParametros(parametros);
		
		String valorTotal = calculador.calcularValorTotal();
		
		Assert.assertEquals("150,19", valorTotal);
	}
	
	@Test
	public void testeEmRodoviaPavimentadaENaoPavimentadaComCaminhaoBauComSeisToneladas() {
		Parametros parametros = new Parametros();
		parametros.setDistancia(80, 20);
		parametros.setVeiculo(new CaminhaoBau());
		parametros.setToneladas(6);
		
		CalculadorCustoTransporte calculador = new CalculadorCustoTransporte();
		calculador.setParametros(parametros);
		
		String valorTotal = calculador.calcularValorTotal();
		
		Assert.assertEquals("57,60", valorTotal);
	}
	
	@Test
	public void testeEmRodoviaPavimentadaENaoPavimentadaComCaminhaoCacambaComCincoToneladas() {
		Parametros parametros = new Parametros();
		parametros.setDistancia(50, 30);
		parametros.setVeiculo(new CaminhaoCacamba());
		parametros.setToneladas(5);
		
		CalculadorCustoTransporte calculador = new CalculadorCustoTransporte();
		calculador.setParametros(parametros);
		
		String valorTotal = calculador.calcularValorTotal();
		
		Assert.assertEquals("47,88", valorTotal);
	}
	
	@Test
	public void testeEmRodoviaPavimentadaENaoPavimentadaComCarretaComVinteToneladas() {
		Parametros parametros = new Parametros();
		parametros.setDistancia(100, 50);
		parametros.setVeiculo(new Carreta());
		parametros.setToneladas(20);
		
		CalculadorCustoTransporte calculador = new CalculadorCustoTransporte();
		calculador.setParametros(parametros);
		
		String valorTotal = calculador.calcularValorTotal();
		
		Assert.assertEquals("140,20", valorTotal);
	}
}
