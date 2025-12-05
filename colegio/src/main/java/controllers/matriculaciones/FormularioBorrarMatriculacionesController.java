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
@WebServlet("/matriculaciones/formularioBorrarMatriculaciones")
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

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculaciones/borrarMatriculaciones.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableMunicipios(request);
        String alumno = request.getParameter("alumno");
        String asignatura = request.getParameter("asignatura");
        String date = request.getParameter("fecha");
        

        
        ArrayList<MatriculacionesDTO> listaMatriculas = new ArrayList<>();
        
        IMatriculacionesService service = new MatriculacionesServiceImp();
        listaMatriculas = service.listarMatriculas( alumno, asignatura, date, 0);
        request.setAttribute("lista", listaMatriculas);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculaciones/borrarMatriculaciones.jsp");
        d.forward(request, response);
	}

}
