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
public class calculadoraCarga extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		
		PrintWriter out = response.getWriter();
		
		//Iniciando parâmetros
		double distPav, distSemPav, ton = 0;
		boolean camBau, camCac, carreta;
		
		//Distância percorrida
		if(request.getParameter("kmPav") != ""){
			if(Double.parseDouble(request.getParameter("kmPav"))<0){
				out.println("A distância precisa ter um valor positivo ou igual a zero.<br>");
				return;
			} else{
				distPav = Double.parseDouble(request.getParameter("kmPav"));
			}
		} else {
			distPav = 0;
		}
		
		if(request.getParameter("kmSPav") != ""){
			if(Double.parseDouble(request.getParameter("kmSPav"))<0){
				out.println("A distância precisa ter um valor positivo ou igual a zero.<br>");
				return;
			} else{
				distSemPav = Double.parseDouble(request.getParameter("kmSPav"));
			}
		} else {
			distSemPav = 0;
		}
		
		//Carga transportada
		if(request.getParameter("ton") != ""){
			ton = Double.parseDouble(request.getParameter("ton"));
		}
		
		//Veículo utilizado
		camBau = request.getParameter("veiculo").equals("camBau");
		camCac = request.getParameter("veiculo").equals("camCac");
		carreta = request.getParameter("veiculo").equals("carreta");	
		
		//Monta uma nova rota
		Parametros parametro = new Parametros();
		parametro.SetDist(distPav, distSemPav);
		parametro.SetVeiculo(camBau, camCac, carreta);
		parametro.SetToneladas(ton);
		
		//imprime o valor total
		out.println("<html>");
		out.println("<body>");
		out.println("O valor total da rota é de: " + parametro.GetValorTotal() + " R$");
		out.println("</body>");
		out.println("</html>");
		
	}
}