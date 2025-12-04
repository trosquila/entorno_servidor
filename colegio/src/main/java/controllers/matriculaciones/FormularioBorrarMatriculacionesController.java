package controllers.matriculaciones;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAlumnosService;
import servicios.IMatriculacionesService;
import serviciosImp.AlumnosServiceImp;
import serviciosImp.MatriculacionesServiceImp;
import utils.DesplegableUtils;

import java.io.IOException;
import java.util.ArrayList;

import dto.AlumnoDTO;
import dto.MatriculacionesDTO;

/**
 * Servlet implementation class FormularioBorrarAlumnosController
 */
@WebServlet("/matriculaciones/formularioBorraMatriculaciones")
public class FormularioBorrarMatriculacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarMatriculacionesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/borrarAlumnos.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableMunicipios(request);
		String id = request.getParameter("id");
        String alumno = request.getParameter("alumno");
        String asignatura = request.getParameter("asignatura");
        String date = request.getParameter("date");
        String activo =  request.getParameter("activo");
        

        
        ArrayList<MatriculacionesDTO> listaMatriculaciones = new ArrayList<>();
        
        IMatriculacionesService service = new MatriculacionesServiceImp();
        ArrayList<MatriculacionesDTO> listaMatriculas;
        listaMatriculas = service.listarMatriculas(nombreAlumno, nombreAsignatura, fecha, activo);
        request.setAttribute("lista", listaAlumnos);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/borrarAlumnos.jsp");
        d.forward(request, response);
	}

}
