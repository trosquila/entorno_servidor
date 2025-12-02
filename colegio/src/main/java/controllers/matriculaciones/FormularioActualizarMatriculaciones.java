package controllers.matriculaciones;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAlumnosService;

import servicios.IMatriculacionesService;

import serviciosImp.MatriculacionesServiceImp;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IAlumnosDAO;
import dao.IAsignaturasDAO;
import daoImp.AlumnosDAOImpl;
import daoImp.AsignaturasDAOImpl;
import dto.AlumnoDTO;
import dto.AsignaturasDTO;
import dto.MatriculacionesDTO;

/**
 * Servlet implementation class InsertarMatriculacionesController
 */
@WebServlet("/matriculaciones/formularioActualizarMatriculas")
public class FormularioActualizarMatriculaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static Logger logger = LoggerFactory.getLogger(FormularioActualizarMatriculaciones.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarMatriculaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/matriculaciones/actualizarMatricula.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperar datos del formulario
        String nombreAlumno = request.getParameter("nombreAlumno");
        String nombreAsignatura = request.getParameter("nombreAsignatura");
        String fecha = request.getParameter("fecha");
        
        int activo = 0;
        // Insertar matriculación
      IMatriculacionesService service = new MatriculacionesServiceImp();
       ArrayList<MatriculacionesDTO> listaMatriculas;
       listaMatriculas = service.listarMatriculas(nombreAlumno, nombreAsignatura, fecha, activo);
        
        request.setAttribute("listaMatriculas", listaMatriculas);
        
        
        //sacar alumnos
        IAlumnosDAO alumnosDAO = new AlumnosDAOImpl();
        List<AlumnoDTO> listaAlumnos = alumnosDAO.obtenerTodosAlumnos();
        request.setAttribute("listaAlumnos", listaAlumnos);
        
        //sacarAsignaturas
        IAsignaturasDAO asignaturasDAO = new AsignaturasDAOImpl();
        List<AsignaturasDTO> listaAsignaturas = asignaturasDAO.obtenerAsignaturas();
        request.setAttribute("listaAsignaturas", listaAsignaturas);
        
        
        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/matriculaciones/actualizarMatricula.jsp");
        d.forward(request, response);
	}

}
