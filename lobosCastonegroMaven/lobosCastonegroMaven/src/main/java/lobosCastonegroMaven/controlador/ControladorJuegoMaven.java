package lobosCastonegroMaven.controlador;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lobosCastonegroMaven.modelo.Jugadores;
import lobosCastonegroMaven.negocio.NegocioCastoNegro;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ControladorJuegoMaven
 */
@WebServlet("/ControladorJuegoMaven")
public class ControladorJuegoMaven extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorJuegoMaven() {
        super();
        // TODO Auto-generated constructor stub	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NegocioCastoNegro negocio = new NegocioCastoNegro();
		List <Jugadores> listaJugadores = negocio.buscarJugadores();
		request.setAttribute("listaJugadores", listaJugadores);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/programa.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NegocioCastoNegro negocio = new NegocioCastoNegro();
		List <Jugadores> listaJugadores = negocio.buscarJugadores();
		request.setAttribute("listaJugadores", listaJugadores);
		
		
		 String nombre = request.getParameter("nombre");
		 String rolAleatorio = negocio.obtenerRol();
		 request.setAttribute("nombre", nombre);
		 request.setAttribute("rolAleatorio", rolAleatorio);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/programa.jsp");
		    dispatcher.forward(request, response);
	}

}
