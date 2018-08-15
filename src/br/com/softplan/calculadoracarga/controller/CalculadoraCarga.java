package br.com.softplan.calculadoracarga.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.softplan.calculadoracarga.application.Parametros;
import br.com.softplan.calculadoracarga.domain.*;

//Calculadora de preço de transporte
@SuppressWarnings("serial")
@WebServlet("/calculadoraCarga")
public class CalculadoraCarga extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		Parametros parametro = new Parametros();
		CalculadoraParametros calculadora = new CalculadoraParametros();
		
		PrintWriter out = response.getWriter();
	
		//Distância percorrida usando método para retornar valor passado se não for vazio
		double distanciaPavimento = retornarValorOuZero("kmPav", request);
		double distanciaSemPavimento = retornarValorOuZero("kmSPav", request);
		
		if(distanciaPavimento<0){
			out.println("<html><body><h3>Quilômetros pavimentados inseridos precisam ser maior ou igual a zero.</h3></body></html>");
			return;
		}
		if(distanciaSemPavimento<0){
			out.println("<html><body><h3>Quilômetros sem pavimento inseridos precisam ser maior ou igual a zero.</h3></body></html>");
			return;
		}
		
		//Carga transportada
		double toneladas = retornarValorOuZero("ton", request);
		
		if(toneladas<0){
			out.println("<html><body><h3>Toneladas inseridas precisam ser maior ou igual a zero.</h3></body></html>");
			return;
		}
		
		//Veículo utilizado
		String veiculoSelecionado = request.getParameter("veiculo");
		boolean caminhaoBau = veiculoSelecionado.equals("caminhaoBau");
		boolean caminhaoCacamba = veiculoSelecionado.equals("caminhaoCacamba");
		boolean carreta = veiculoSelecionado.equals("carreta");
		boolean mendigoCarregador = veiculoSelecionado.equals("mendigo");
		boolean jumentoCarregador = veiculoSelecionado.equals("jumento");
		boolean carteiro = veiculoSelecionado.equals("carteiro");
		
		//Salva os parametros
		parametro.setDistancia(distanciaPavimento, distanciaSemPavimento);
		
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
		
		parametro.setVeiculo(veiculo);
		parametro.setToneladas(toneladas);
		calculadora.setParametros(parametro);
		calculadora.setValorTotal();
		
		//Imprime o valor total
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Calculadora de Preço de Carga</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>O valor total da rota é de: " + calculadora.getValorTotal() + " R$</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	//Se valor não for vazio retornar valor em double, caso contrário, retornar 0
	public double retornarValorOuZero(String valor, HttpServletRequest request){
		if(request.getParameter(valor) != ""){
			return Double.parseDouble(request.getParameter(valor));
		} else {
			return 0;
		}
	}
}