package controllers.asignaturas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAsignaturasService;
import serviciosImp.AsiganturasServicelmp;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controllers.alumnos.ListadoAlumnosController;
import dto.AsignaturasDTO;

/**
 * Servlet implementation class ListadoAsignaturasController
 */
@WebServlet("/asignaturas/listarAsignaturas")
public class ListadoAsignaturasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ListadoAlumnosController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoAsignaturasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/listadoAsignaturas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String cursoParam = request.getParameter("curso");
		String tasaParam = request.getParameter("tasa");
		String activoParam = request.getParameter("activo");
		
		int id;
		int curso;
		int tasa;
		int activo;
		if(activoParam == null) {
			activo = 0;
		}else {
			activo = 1;
		}
		try {
		    id = Integer.parseInt(idParam);
		} catch (NumberFormatException | NullPointerException e) {
			id = 0;
		}
		try {
		    curso = Integer.parseInt(cursoParam);
		} catch (NumberFormatException | NullPointerException e) {
			curso = 0;
		}
		try {
			tasa = Integer.parseInt(tasaParam);
		} catch (NumberFormatException | NullPointerException e) {
			tasa = 0;
		}

		IAsignaturasService a = new AsiganturasServicelmp();
		ArrayList<AsignaturasDTO> listaAsignaturas = new ArrayList<>();

		
		
		listaAsignaturas = a.obtenerTodasAsignaturasFiltradas(id, nombre, curso, tasa, activo);

		request.setAttribute("listaAsignaturas", listaAsignaturas);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/listadoAsignaturas.jsp");
		d.forward(request, response);
	}

}
