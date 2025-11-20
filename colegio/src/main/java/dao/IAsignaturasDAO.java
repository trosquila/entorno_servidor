package dao;

import java.util.ArrayList;

import dto.AsignaturasDTO;

public interface IAsignaturasDAO {
	ArrayList<AsignaturasDTO> obtenerTodasAsignaturasFiltradas(int id, String nombre, int curso, int tasa);
	
}
