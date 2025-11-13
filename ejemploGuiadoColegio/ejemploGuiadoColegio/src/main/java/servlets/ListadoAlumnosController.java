package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAlumnosService;
import serviciosImp.AlumnosServiceImp;

import java.io.IOException;
import java.util.ArrayList;

import DTO.AlumnoDTO;

/**
 * Servlet implementation class ListadoAlumnosControlle
 */
@WebServlet("/alumnos/listadoAlumnos")
public class ListadoAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoAlumnosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/listadoAlumnos.jsp");
		d.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String familiaNumerosa = request.getParameter("familiaNumerosa");
			String activo = request.getParameter("activo");
			IAlumnosService a = new AlumnosServiceImp();
			ArrayList<AlumnoDTO> listaAlumnos = new ArrayList<>();
			listaAlumnos = a.obtenerAlumnosPorIdNombreApellido(id, nombre,
			apellido, familiaNumerosa, activo);
			request.setAttribute("lista", listaAlumnos);
			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/listadoAlumnos.jsp");
			d.forward(request, response);

	}

}
