package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAlumnosService;
import serviciosImp.AlumnosServiceImp;

import java.io.IOException;
import java.util.ArrayList;

import DTO.DesplegableDTO;
import DTO.IDesplegableDAO;
import Utils.DesplegableUtils;
import dao.DesplegableDAOImp;

/**
 * Servlet implementation class insertarAlumno
 */
@WebServlet("/alumnos/insertarAlumno")
public class insertarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DesplegableUtils.recuperarDesplegableMunicipios(request);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/insertarAlumno.jsp");
		d.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperamos los datos del formulario
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String idMunicipio = request.getParameter("municipios")!= null? "1":"0";
		String familiaNumerosa = request.getParameter("famNumerosa")!= null? "1":"0";
		String activo = request.getParameter("activo");
		IAlumnosService a = new AlumnosServiceImp();
		Integer resultado = a.insertarAlumno(id, nombre, apellido, idMunicipio, Integer.parseInt(familiaNumerosa),
		Integer.parseInt(activo));
		request.setAttribute("resultado", resultado);
		DesplegableUtils.recuperarDesplegableMunicipios(request);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/insertarAlumno.jsp");
				d.forward(request, response);
			}
}


