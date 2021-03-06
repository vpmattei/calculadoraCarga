package br.com.softplan.calculadoracarga.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.softplan.calculadoracarga.application.Parametros;
import br.com.softplan.calculadoracarga.domain.CalculadorCustoTransporte;
import br.com.softplan.calculadoracarga.domain.CaminhaoBau;
import br.com.softplan.calculadoracarga.domain.CaminhaoCacamba;
import br.com.softplan.calculadoracarga.domain.Carreta;
import br.com.softplan.calculadoracarga.domain.Carteiro;
import br.com.softplan.calculadoracarga.domain.JumentoCarregador;
import br.com.softplan.calculadoracarga.domain.MendigoCarregador;
import br.com.softplan.calculadoracarga.domain.Veiculo;

//Calculadora de pre�o de transporte
@SuppressWarnings("serial")
@WebServlet("/calculadoraCarga")
public class CalculadorCustoTransporteController extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		Parametros parametro = new Parametros();
		CalculadorCustoTransporte calculadora = new CalculadorCustoTransporte();
		
		PrintWriter out = response.getWriter();
	
		//Dist�ncia percorrida usando m�todo para retornar valor passado se n�o for vazio
		double distanciaPavimentada = retornarValorOuZero("kmPav", request);
		double distanciaNaoPavimentada = retornarValorOuZero("kmSPav", request);
		
		if(distanciaPavimentada<0){
			out.println("<html><body><h3>Quil�metros pavimentados inseridos precisam ser maior ou igual a zero.</h3></body></html>");
			return;
		}
		if(distanciaNaoPavimentada<0){
			out.println("<html><body><h3>Quil�metros sem pavimento inseridos precisam ser maior ou igual a zero.</h3></body></html>");
			return;
		}
		
		//Carga transportada
		double toneladas = retornarValorOuZero("ton", request);
		
		if(toneladas<0){
			out.println("<html><body><h3>Toneladas inseridas precisam ser maior ou igual a zero.</h3></body></html>");
			return;
		}
		
		//Ve�culo utilizado
		String veiculoSelecionado = request.getParameter("veiculo");
		boolean caminhaoBau = veiculoSelecionado.equals("caminhaoBau");
		boolean caminhaoCacamba = veiculoSelecionado.equals("caminhaoCacamba");
		boolean carreta = veiculoSelecionado.equals("carreta");
		boolean mendigoCarregador = veiculoSelecionado.equals("mendigo");
		boolean jumentoCarregador = veiculoSelecionado.equals("jumento");
		boolean carteiro = veiculoSelecionado.equals("carteiro");
		
		Veiculo veiculo = null;
		if (caminhaoBau) {
			veiculo = new CaminhaoBau();
		} else if (caminhaoCacamba) {
			veiculo = new CaminhaoCacamba();
		} else if (carreta) {
			veiculo = new Carreta();
		} else if (mendigoCarregador) {
			veiculo = new MendigoCarregador();
		} else if (jumentoCarregador) {
			veiculo = new JumentoCarregador();
		} else if (carteiro) {
			veiculo = new Carteiro();
		}
		
		//Salva os parametros
		parametro.setDistancia(distanciaPavimentada, distanciaNaoPavimentada);
		parametro.setVeiculo(veiculo);
		parametro.setToneladas(toneladas);
		calculadora.setParametros(parametro);
		
		//Imprime o valor total
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Calculadora de Pre�o de Carga</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>O valor total da rota � de: " + calculadora.calcularValorTotal() + " R$</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	//Se valor n�o for vazio retornar valor em double, caso contr�rio, retornar 0
	public double retornarValorOuZero(String valor, HttpServletRequest request){
		if(request.getParameter(valor) != ""){
			return Double.parseDouble(request.getParameter(valor));
		} else {
			return 0;
		}
	}
}