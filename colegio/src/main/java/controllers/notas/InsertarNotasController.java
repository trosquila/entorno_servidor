package controllers.notas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAlumnosService;
import servicios.IAsignaturasService;
import servicios.INotasService;
import serviciosImp.AlumnosServiceImp;
import serviciosImp.AsiganturasServicelmp;
import serviciosImp.NotasServiceImp;
import utils.DesplegableUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.AlumnoDTO;
import dto.AsignaturasDTO;



/**
 * Servlet implementation class InsertarAlumnosController
 */
@WebServlet("/notas/insertarNotas")
public class InsertarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(InsertarNotasController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableMunicipios(request);
        IAlumnosService alumnoService = new AlumnosServiceImp();
        IAsignaturasService asignaturaService = new AsiganturasServicelmp();
        List<AlumnoDTO> listaAlumnos = null;
        try {
        	listaAlumnos = alumnoService.obtenerAlumnos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<AsignaturasDTO> listaAsignaturas = asignaturaService.obtenerAsignaturas();
        request.setAttribute("listaAlumnos", listaAlumnos);
        request.setAttribute("listaAsignaturas", listaAsignaturas);
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/insertarNota.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAlumnosService alumnoService = new AlumnosServiceImp();
	    IAsignaturasService asignaturaService = new AsiganturasServicelmp();
	    List<AlumnoDTO> listaAlumnos = null;
	   
	    try {
	        listaAlumnos = alumnoService.obtenerAlumnos();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    List<AsignaturasDTO> listaAsignaturas = asignaturaService.obtenerAsignaturas();
	    
	    String alumnoParam = request.getParameter("alumno");
	    String asignaturaParam = request.getParameter("asignatura");
	    int nota = Integer.parseInt(request.getParameter("nota"));
	    String fecha = request.getParameter("fecha");
	    int idAlumno;
	    int idAsignatura;
	    
	    try {
			idAlumno = Integer.parseInt(alumnoParam);
		} catch (Exception e) {
			idAlumno = 0;
		}
	    try {
	    	idAsignatura = Integer.parseInt(asignaturaParam);
		} catch (Exception e) {
			idAsignatura = 0;
		}
	    
	    if(fecha == "") {
	    	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	    	fecha = formato.format(new Date());
	
	    }
	    INotasService a = new NotasServiceImp();
	    Integer resultado = a.insertarNota(idAlumno, idAsignatura, nota, fecha);
	    
	    request.setAttribute("listaAlumnos", listaAlumnos);
	    request.setAttribute("listaAsignaturas", listaAsignaturas);
	    request.setAttribute("resultado", resultado);
	    
	    DesplegableUtils.recuperarDesplegableMunicipios(request);
        
	    
	    RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/insertarNota.jsp");
	    d.forward(request, response);
	}
	


}
