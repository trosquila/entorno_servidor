package serviciosImp;

import java.util.ArrayList;

import dao.IAsignaturasDAO;
import daoImp.AsignaturasDAOImpl;
import dto.AsignaturasDTO;
import servicios.IAsignaturasService;

public class AsiganturasServicelmp implements IAsignaturasService{

	@Override
	public ArrayList<AsignaturasDTO> obtenerTodasAsignaturasFiltradas(int id, String nombre, int curso, int tasa) {
		IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
		return asignaturas.obtenerTodasAsignaturasFiltradas(id, nombre, curso, tasa);
	}

}
