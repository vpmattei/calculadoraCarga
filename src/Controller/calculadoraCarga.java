package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Application.Parametros;

@SuppressWarnings("serial")
@WebServlet("/calculadoraCarga")
public class CalculadoraCarga extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		
		PrintWriter out = response.getWriter();
		
		//Iniciando par�metros
		double distanciaPavimento = 0;
		double distanciaSemPavimento = 0;
		double toneladas = 0;
		
		boolean caminhaoBau = false;
		boolean caminhaoCacamba = false;
		boolean carreta = false;
		
		
		//Dist�ncia percorrida
		verificarErroInput(request, response, "kmPav", distanciaPavimento);
		verificarErroInput(request, response, "kmSPav", distanciaSemPavimento);
		distanciaPavimento = getParametroDouble(request, "kmPav");
		distanciaSemPavimento = getParametroDouble(request, "kmSPav");
		
		//Carga transportada
		verificarErroInput(request, response, "ton", toneladas);
		toneladas = getParametroDouble(request, "ton");
		
		//Ve�culo utilizado
		caminhaoBau = request.getParameter("veiculo").equals("camBau");
		caminhaoCacamba = request.getParameter("veiculo").equals("camCac");
		carreta = request.getParameter("veiculo").equals("carreta");
		
		//Salva os parametros
		Parametros parametro = new Parametros();
		parametro.setDistancia(distanciaPavimento, distanciaSemPavimento);
		parametro.setVeiculo(caminhaoBau, caminhaoCacamba, carreta);
		parametro.setToneladas(toneladas);
		
		//Imprime o valor total
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>O valor total da rota � de: " + parametro.getValorTotal() + " R$</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	//M�todo para pegar parametros double
	public double getParametroDouble(HttpServletRequest request, String parametro){
		return Double.parseDouble(request.getParameter(parametro));
	}
	
	//M�todo para pegar parametros String
	public String getParametro(HttpServletRequest request, String parametro){
		return request.getParameter(parametro);
	}
	
	//M�todo println para Http
	public void println(HttpServletResponse response,  String string) throws IOException{
		PrintWriter out = response.getWriter();
		out.println(string);
	}
	
	//M�todo para verificar se usu�rio n�o digitou errado
	public void verificarErroInput(HttpServletRequest request, HttpServletResponse response,  String parametro, double valor) throws IOException{
		if(request.getParameter(parametro) != ""){
			if(getParametroDouble(request, parametro)<0){
				println(response, "A dist�ncia precisa ter um valor positivo ou igual a zero.");
				return;
			}
		} else {
			println(response, "Nenhum valor inserido.");
			return;
		}
	}
}