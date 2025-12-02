package controllers.matriculaciones;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import servicios.IMatriculacionesService;

import serviciosImp.MatriculacionesServiceImp;


import java.io.IOException;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import dto.MatriculacionesDTO;

/**
 * Servlet implementation class InsertarMatriculacionesController
 */
@WebServlet("/matriculaciones/listarMatriculaciones")
public class listarMatriculaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static Logger logger = LoggerFactory.getLogger(listarMatriculaciones.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listarMatriculaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/matriculaciones/listarMatriculas.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperar datos del formulario
        String nombreAlumno = request.getParameter("nombreAlumno");
        String nombreAsignatura = request.getParameter("nombreAsignatura");
        String activoParam = request.getParameter("asignatura");
        String fecha = request.getParameter("fecha");
        
        int activo = 0;
        if(activoParam == "on") {
        	activo = 1;
        }
        // Insertar matriculación
      IMatriculacionesService service = new MatriculacionesServiceImp();
       ArrayList<MatriculacionesDTO> listaMatriculas;
       listaMatriculas = service.listarMatriculas(nombreAlumno, nombreAsignatura, fecha, activo);
        
        request.setAttribute("listaMatriculas", listaMatriculas);
        
        RequestDispatcher d = getServletContext()
                .getRequestDispatcher("/WEB-INF/vistas/matriculaciones/listarMatriculas.jsp");
        d.forward(request, response);
	}

}
