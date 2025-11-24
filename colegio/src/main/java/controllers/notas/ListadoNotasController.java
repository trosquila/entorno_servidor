package controllers.notas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.INotasService;
import serviciosImp.NotasServiceImp;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controllers.alumnos.ListadoAlumnosController;
import dto.NotasDTO;

/**
 * Servlet implementation class ListadoAsignaturasController
 */
@WebServlet("/notas/listarNotas")
public class ListadoNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ListadoAlumnosController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoNotasController() {
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
		String id = request.getParameter("id");
		String idAlumno= request.getParameter("idAlumno");
		String idAsignatura = request.getParameter("idAsignatura");
		String nota = request.getParameter("nota");
		String fecha = request.getParameter("fecha");
		String activo = request.getParameter("activo");
		
		INotasService a = new NotasServiceImp();
		ArrayList<NotasDTO> listaAsignaturas = new ArrayList<>();

		
		
		listaAsignaturas = a.obtenerTodasNotas(id, idAlumno, idAsignatura, nota, fecha, activo);

		request.setAttribute("listaAsignaturas", listaAsignaturas);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);
	}

}
