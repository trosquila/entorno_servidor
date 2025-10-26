package clashRoyale.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import clashRoyale.modelo.Carta;
import clashRoyale.negocio.CalculoIndiceFuerza;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CalculoIndiceFuerza datos = new CalculoIndiceFuerza();
		String nombre = request.getParameter("nombre");
		Carta carta = datos.buscarCarta(nombre);
		int cantidadPoder = datos.indiceFuerza(carta);
		
		request.setAttribute("carta", carta);
		request.setAttribute("cantidadPoder", cantidadPoder);
		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher("/WEB-INF/cantidadCartasVista.jsp");
				dispatcher.forward(request, response);
	}

}
