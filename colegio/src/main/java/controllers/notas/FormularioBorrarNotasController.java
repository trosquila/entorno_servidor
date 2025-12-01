package controllers.notas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.IAsignaturasService;
import servicios.INotasService;
import serviciosImp.AsiganturasServicelmp;
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
 * Servlet implementation class FormularioBorrarAlumnosController
 */
@WebServlet("/notas/formularioBorrarNotas")
public class FormularioBorrarNotasController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FormularioBorrarNotasController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/borrarNota.jsp");
        d.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        DesplegableUtils.recuperarDesplegableMunicipios(request);

        String alumno = request.getParameter("alumno");
        String asignatura = request.getParameter("asignatura");
        String fecha = request.getParameter("fecha");

        INotasService notasService = new NotasServiceImp();
        ArrayList<NotasDTO> listaNotas = notasService.obtenerNotasModificar(alumno, asignatura, fecha);
        request.setAttribute("lista", listaNotas);


        RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/borrarNota.jsp");
        d.forward(request, response);
    }
}
