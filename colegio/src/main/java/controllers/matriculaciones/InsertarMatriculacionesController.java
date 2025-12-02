package controllers.matriculaciones;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAlumnosService;
import servicios.IAsignaturasService;
import servicios.IMatriculacionesService;
import serviciosImp.AlumnosServiceImp;
import serviciosImp.AsiganturasServicelmp;
import serviciosImp.MatriculacionesServiceImp;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.AlumnoDTO;
import dto.AsignaturasDTO;

/**
 * Servlet implementation class InsertarMatriculacionesController
 */
@WebServlet("/matriculaciones/insertarMatriculacion")
public class InsertarMatriculacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static Logger logger = LoggerFactory.getLogger(InsertarMatriculacionesController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarMatriculacionesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cargar desplegable de alumnos
		  IAlumnosService a = new AlumnosServiceImp();
	        ArrayList<AlumnoDTO> listaAlumnos = new ArrayList<>();
	        
	        try {
				listaAlumnos = a.obtenerAlumnos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("listaAlumnos", listaAlumnos);
	        
	        List<AsignaturasDTO> listaAsignaturas = new ArrayList<>();
	        
	        IAsignaturasService asignatura = new AsiganturasServicelmp();
	        listaAsignaturas = asignatura.obtenerAsignaturas();
	        
	        request.setAttribute("listaAsignaturas", listaAsignaturas);
	        
        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/matriculaciones/insertarMatriculacion.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperar datos del formulario
        String idAlumno = request.getParameter("alumno");
        String idAsignatura = request.getParameter("asignatura");
        String tasa = request.getParameter("tasa");
        String fecha = request.getParameter("fecha");
        
        // Si no hay fecha, usar fecha actual
        if (fecha == null || fecha.trim().isEmpty()) {
            fecha = LocalDate.now().toString();
        }
       
        
        // Insertar matriculación
      IMatriculacionesService service = new MatriculacionesServiceImp();
        Integer resultado = null;
		try {
			resultado = service.insertarMatriculacion(idAsignatura, idAlumno, fecha, tasa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("resultado", resultado);
        
        

		// Cargar desplegable de alumnos
		  IAlumnosService a = new AlumnosServiceImp();
	        ArrayList<AlumnoDTO> listaAlumnos = new ArrayList<>();
	        
	        try {
				listaAlumnos = a.obtenerAlumnos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("listaAlumnos", listaAlumnos);
	        
	        List<AsignaturasDTO> listaAsignaturas = new ArrayList<>();
	        
	        IAsignaturasService asignatura = new AsiganturasServicelmp();
	        listaAsignaturas = asignatura.obtenerAsignaturas();
	        
	        request.setAttribute("listaAsignaturas", listaAsignaturas);
        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/matriculaciones/insertarMatriculacion.jsp");
        d.forward(request, response);
	}

}
