package serviciosImp;

import java.util.ArrayList;

import dao.IAsignaturasDAO;
import daoImp.AsignaturasDAOImpl;
import dto.AsignaturasDTO;
import servicios.IAsignaturasService;

public class AsiganturasServicelmp implements IAsignaturasService{

	@Override
	public ArrayList<AsignaturasDTO> obtenerTodasAsignaturasFiltradas(int id, String nombre, int curso, int tasa, int activo) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.obtenerTodasAsignaturasFiltradas(id, nombre, curso, tasa, activo);
	}

	@Override
	public Integer insertarAsignatura(int id, String nombre, int curso, int tasa, int activo) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.insertarAsignatura(id, nombre, curso, tasa, activo);
	}

	@Override
	public ArrayList<AsignaturasDTO> obtenerAsignaturasModificar(String id, String nombre, String curso, String tasa) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.obtenerAsignaturasModificar(id, nombre, curso, tasa);
	}

	@Override
	public int actualizarAsignatura(int id, String nombre, int curso, int tasa) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.actualizarAsignatura(id, nombre, curso, tasa);
		
	}

	@Override
	public ArrayList<AsignaturasDTO> obtenerAsignaturasBorrar(String id, String nombre, String curso, String tasa) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.obtenerAsignaturasBorrar(id, nombre, curso, tasa);
	}

	@Override
	public int borrarAsignatura(String id) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.borrarAsignatura(id);
		
	}

}
