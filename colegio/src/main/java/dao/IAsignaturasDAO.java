package dao;

import java.util.ArrayList;

import dto.AsignaturasDTO;

public interface IAsignaturasDAO {
	ArrayList<AsignaturasDTO> obtenerTodasAsignaturasFiltradas(int id, String nombre, int curso, int tasa);

	Integer insertarAsignatura(int id, String nombre, int curso, int tasa, int activo);

	ArrayList<AsignaturasDTO> obtenerAsignaturasModificar(String id, String nombre, String curso, String tasa);

	int actualizarAsignatura(int id, String nombre, int curso, int tasa);

	ArrayList<AsignaturasDTO> obtenerAsignaturasBorrar(String id, String nombre, String curso, String tasa);
	
}
