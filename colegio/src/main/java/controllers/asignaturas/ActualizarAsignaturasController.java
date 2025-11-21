package controllers.asignaturas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAsignaturasService;
import serviciosImp.AsiganturasServicelmp;

import java.io.IOException;

/**
 * Servlet implementation class ActualizarAlumnosController
 */
@WebServlet("/asignaturas/actualizarAsignaturas")
public class ActualizarAsignaturasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarAsignaturasController() {
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
		String idParam = request.getParameter("id");
		String nombre = request.getParameter("nombre");
	    int curso = Integer.parseInt(request.getParameter("curso"));
	    String tasaParam = request.getParameter("tasa");
	    int activo = Integer.parseInt(request.getParameter("activo"));
	    System.out.println(tasaParam);
	    int tasa;
	    try {
	    	tasa = Integer.parseInt(tasaParam);
		} catch (NumberFormatException | NullPointerException e) {
			tasa = 0;
		}
	    int id;
	    try {
	    	id = Integer.parseInt(idParam);
		} catch (NumberFormatException | NullPointerException e) {
			id = 0;
		}
	    
	    IAsignaturasService a = new AsiganturasServicelmp();
	    Integer resultado = a.actualizarAsignatura(id, nombre, curso, tasa);
	    request.setAttribute("resultado", resultado);
		    
	        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/actualizarAsignatura.jsp");
	        d.forward(request, response);
	}

}
