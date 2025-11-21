package controllers.asignaturas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;                     
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAlumnosService;
import servicios.IAsignaturasService;
import serviciosImp.AlumnosServiceImp;
import serviciosImp.AsiganturasServicelmp;
import utils.DesplegableUtils;

import java.io.IOException;
import java.util.ArrayList;

import dto.AlumnoDTO;
import dto.AsignaturasDTO;                                         
                                                                    
/**                                                                 
 * * Servlet implementation class FomularioActualizarAlumnosController */
@WebServlet("/asignaturas/formularioActualizarAsignaturas")
public class FormularioActualizarAsignaturasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarAsignaturasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/actualizarAsignatura.jsp");
        d.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableMunicipios(request);
		String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String curso = request.getParameter("curso");
        String tasa = request.getParameter("tasa");
        
        
        ArrayList<AsignaturasDTO> listaAsignaturas = new ArrayList<>();
        
        IAsignaturasService a = new AsiganturasServicelmp();
        listaAsignaturas = a.obtenerAsignaturasModificar(id, nombre, curso , tasa);
        request.setAttribute("lista", listaAsignaturas);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/actualizarAsignatura.jsp");
        d.forward(request, response);
        
        
	}

}
