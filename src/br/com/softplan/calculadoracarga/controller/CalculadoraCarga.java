package br.com.softplan.calculadoracarga.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.softplan.calculadoracarga.application.Parametros;
import br.com.softplan.calculadoracarga.domain.CalculadoraParametros;


//Calculadora de pre�o de transporte
@SuppressWarnings("serial")
@WebServlet("/calculadoraCarga")
public class CalculadoraCarga extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		Parametros parametro = new Parametros();
		CalculadoraParametros calculadora = new CalculadoraParametros();
		
		PrintWriter out = response.getWriter();
	
		//Dist�ncia percorrida usando m�todo para retornar valor passado se n�o for vazio
		double distanciaPavimento = retornarValorOuZero("kmPav", request);
		double distanciaSemPavimento = retornarValorOuZero("kmSPav", request);
		
		if(distanciaPavimento<0){
			out.println("<html><body><h3>Quil�metros pavimentados inseridos precisam ser maior ou igual a zero.</h3></body></html>");
			return;
		}
		if(distanciaSemPavimento<0){
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
		boolean caminhaoBau = request.getParameter("veiculo").equals("camBau");
		boolean caminhaoCacamba = request.getParameter("veiculo").equals("camCac");
		boolean carreta = request.getParameter("veiculo").equals("carreta");
		boolean mendigoCarregador = request.getParameter("veiculo").equals("mendigo");
		
		//Salva os parametros
		parametro.setDistancia(distanciaPavimento, distanciaSemPavimento);
		parametro.setVeiculo(caminhaoBau, caminhaoCacamba, carreta, mendigoCarregador);
		parametro.setToneladas(toneladas);
		calculadora.setParametros(parametro);
		calculadora.setValorTotal();
		
		//Imprime o valor total
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Calculadora de Pre�o de Carga</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>O valor total da rota � de: " + calculadora.getValorTotal() + " R$</h2>");
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