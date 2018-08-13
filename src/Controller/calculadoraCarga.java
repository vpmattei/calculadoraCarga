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
		pegarParametroDouble("kmPav", distanciaPavimento);
		pegarParametroDouble("kmSPav", distanciaSemPavimento);
		
		//Carga transportada
		pegarParametroDouble("ton", toneladas);
		
		//Ve�culo utilizado
		pegarParametroBoolean("camBau", caminhaoBau);
		pegarParametroBoolean("camCac", caminhaoCacamba);
		pegarParametroBoolean("carreta", carreta);	
		
		//Monta uma nova rota
		Parametros parametro = new Parametros();
		parametro.setDistancia(distanciaPavimento, distanciaSemPavimento);
		parametro.setVeiculo(caminhaoBau, caminhaoCacamba, carreta);
		parametro.setToneladas(toneladas);
		
		//imprime o valor total
		out.println("<html>");
		out.println("<body>");
		out.println("O valor total da rota � de: " + parametro.GetValorTotal() + " R$");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	//M�todo para pegar parametros double com chaves de seguran�a
	@SuppressWarnings("null")
	public void pegarParametroDouble(String parametro, double valor) 
			throws ServletException,
			IOException{
		
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		PrintWriter out = response.getWriter();
		
		if(request.getParameter(parametro) != ""){
			if(Double.parseDouble(request.getParameter(parametro))<0){
				out.println("A dist�ncia precisa ter um valor positivo ou igual a zero.<br>");
				return;
			} else{
				valor = Double.parseDouble(request.getParameter(parametro));
			}
		} else {
			valor = 0;
		}
	}
	
	//M�todo para pegar parametros boolean
	@SuppressWarnings("null")
	public void pegarParametroBoolean(String parametro, boolean bool){
		
		HttpServletRequest request = null;
		
		bool = request.getParameter("veiculo").equals(parametro);
	}
}