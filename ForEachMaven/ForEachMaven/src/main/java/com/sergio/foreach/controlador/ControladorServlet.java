package com.sergio.foreach.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.sergio.foreach.beans.Desplegable;
import com.sergio.foreach.beans.Persona;

/**
 * Servlet implementation class ControladorServlet
 */
@WebServlet("/personas")
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse
    		response) throws ServletException, IOException {
    		ArrayList<Persona> listaPersonas = new ArrayList<>();
    		Persona p1 = new Persona("Paco", 2000);
    		Persona p2 = new Persona("Luis", 100000);
    		Persona p3 = new Persona("Pedro", 100);
    		Persona p4 = new Persona("Alberto", -2989);
    		listaPersonas.add(p1);
    		listaPersonas.add(p2);
    		listaPersonas.add(p3);
    		listaPersonas.add(p4);
    		request.setAttribute("listaPersonas", listaPersonas);
    		ArrayList<Desplegable> desplegable = new ArrayList<>();
    		Desplegable d1 = new Desplegable(1, "Salamanca");
    		Desplegable d2 = new Desplegable(2, "Zamora");
    		Desplegable d3 = new Desplegable(3, "Leon");
    		desplegable.add(d1);
    		desplegable.add(d2);
    		desplegable.add(d3);
    		request.setAttribute("opcionesDesplegable", desplegable);
    		
    		RequestDispatcher dispatcher =
    		getServletContext().getRequestDispatcher("/WEB-INF/lista.jsp");
    		dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
