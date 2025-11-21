package controllers.asignaturas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import servicios.IAsignaturasService;

import serviciosImp.AsiganturasServicelmp;
import utils.DesplegableUtils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Servlet implementation class InsertarAlumnosController
 */
@WebServlet("/asignaturas/insertarAsignatura")
public class InsertarAsignaturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(InsertarAsignaturaController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAsignaturaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableMunicipios(request);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignatura.jsp");
        d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperamos los datos del formulario
	    String nombre = request.getParameter("nombre");
	    int curso = Integer.parseInt(request.getParameter("curso"));
	    String tasaParam = request.getParameter("tasa");
	    int activo = Integer.parseInt(request.getParameter("activo"));
	    int tasa;
	    try {
	    	tasa = Integer.parseInt(tasaParam);
		} catch (NumberFormatException | NullPointerException e) {
			tasa = 0;
		}
	    
	    IAsignaturasService a = new AsiganturasServicelmp();
	    Integer resultado = a.insertarAsignatura(0, nombre, curso, tasa, activo);
	    
	    request.setAttribute("resultado", resultado);
	    
	    DesplegableUtils.recuperarDesplegableMunicipios(request);
        
	    
	    RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignatura.jsp");
	    d.forward(request, response);
	}
	


}
