package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class prueabaConexion
 */
@WebServlet("/prueabaConexion")
public class pruebaConexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(pruebaConexion.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pruebaConexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		try {
		//Con esta linea formazamos que se cargue el driver de MySQL
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/colegio";
		String username = "root";
		String password = "root";
		connection = DriverManager.getConnection(dbURL, username, password);
		//Ya tenemos la conexio hecha a la BBDD
		logger.info("Conexion con la BBDD establecida");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
