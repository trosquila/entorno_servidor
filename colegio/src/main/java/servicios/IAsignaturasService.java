package servicios;

import java.util.ArrayList;

import dto.AsignaturasDTO;

public interface IAsignaturasService {

	ArrayList<AsignaturasDTO> obtenerTodasAsignaturasFiltradas(int id, String nombre, int curso, int tasa);

}
