package controllers.notas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAsignaturasService;
import servicios.INotasService;
import serviciosImp.AsiganturasServicelmp;
import serviciosImp.NotasServiceImp;

import java.io.IOException;

import dto.NotasDTO;

/**
 * Servlet implementation class ActualizarAlumnosController
 */
@WebServlet("/notas/actualizarNotas")
public class ActualizarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarNotasController() {
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
		String idParam = request.getParameter("id");
		String idAsignaturaParam = request.getParameter("idAsignatura");
		String notaParam = request.getParameter("nota");
		String fecha = request.getParameter("fecha");

		int id;
		try {
		    id = Integer.parseInt(idParam);
		} catch (NumberFormatException | NullPointerException e) {
		    id = 0;
		}

		int idAsignatura;
		try {
		    idAsignatura = Integer.parseInt(idAsignaturaParam);
		} catch (NumberFormatException | NullPointerException e) {
		    idAsignatura = 0;
		}

		int nota;
		try {
		    nota = Integer.parseInt(notaParam);
		} catch (NumberFormatException | NullPointerException e) {
		    nota = 0;
		}

        INotasService notasService = new NotasServiceImp();
        int resultado = notasService.actualizarNota(id, idAsignatura, nota, fecha);

        // Guardar resultado en request para mostrar mensaje en JSP
        request.setAttribute("resultado", resultado);

        // Redirigir de nuevo al JSP
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/notas/actualizarNota.jsp");
        dispatcher.forward(request, response);

	}

}
