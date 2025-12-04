package controllers.matriculaciones;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAsignaturasService;
import servicios.IMatriculacionesService;
import servicios.INotasService;
import serviciosImp.AsiganturasServicelmp;
import serviciosImp.MatriculacionesServiceImp;
import serviciosImp.NotasServiceImp;

import java.io.IOException;

import dto.NotasDTO;

/**
 * Servlet implementation class ActualizarAlumnosController
 */
@WebServlet("/matriculaciones/actualizarMatricula")
public class ActualizarMatriculacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarMatriculacionesController() {
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
		String idMatriculaParam = request.getParameter("id");
		String idAsignaturaParam = request.getParameter("asignatura");
		String idAlumnoParam = request.getParameter("idAlumno");
		String importeParam = request.getParameter("importe");
		String fecha = request.getParameter("fecha");

		int idMatricula;
		try {
			idMatricula = Integer.parseInt(idMatriculaParam);
		} catch (NumberFormatException | NullPointerException e) {
			idMatricula = 0;
		}

		int idAsignatura;
		try {
		    idAsignatura = Integer.parseInt(idAsignaturaParam);
		} catch (NumberFormatException | NullPointerException e) {
		    idAsignatura = 0;
		}

		int importe;
		try {
			importe = Integer.parseInt(importeParam);
		} catch (NumberFormatException | NullPointerException e) {
			importe = 0;
		}
		
		int idAlumno;
		try {
			idAlumno = Integer.parseInt(idAlumnoParam);
		} catch (NumberFormatException | NullPointerException e) {
			idAlumno = 0;
		}
		
        IMatriculacionesService matriculaService = new MatriculacionesServiceImp();
        int resultado = matriculaService.actualizarMatricula(idMatricula, idAsignatura, idAlumno, importe, fecha);

        // Guardar resultado en request para mostrar mensaje en JSP
        request.setAttribute("resultado", resultado);

        // Redirigir de nuevo al JSP
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/matriculaciones/actualizarMatricula.jsp");
        dispatcher.forward(request, response);

	}

}
