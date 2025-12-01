package controllers.notas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;                     
import jakarta.servlet.http.HttpServletResponse;

import servicios.INotasService;
import serviciosImp.NotasServiceImp;
import utils.DesplegableUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.IAsignaturasDAO;
import daoImp.AsignaturasDAOImpl;
import dto.AsignaturasDTO;
import dto.NotasDTO;                                         
                                                                    
/**                                                                 
 * * Servlet implementation class FomularioActualizarAlumnosController */
@WebServlet("/notas/formularioActualizarNotas")
public class FormularioActualizarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/actualizarNota.jsp");
        d.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableMunicipios(request);
		String alumno = request.getParameter("alumno");

        String asignatura = request.getParameter("asignatura");
        String fecha = request.getParameter("fecha");
        
        
        ArrayList<NotasDTO> listaNotas = new ArrayList<>();
        
        INotasService a = new NotasServiceImp();
        listaNotas = a.obtenerNotasModificar(alumno, asignatura, fecha);
        request.setAttribute("lista", listaNotas);
        
        IAsignaturasDAO asignaturasDAO = new AsignaturasDAOImpl();
        List<AsignaturasDTO> listaAsignaturas = asignaturasDAO.obtenerAsignaturas();
        request.setAttribute("listaAsignaturas", listaAsignaturas);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/actualizarNota.jsp");
        d.forward(request, response);
        
        
	}

}
