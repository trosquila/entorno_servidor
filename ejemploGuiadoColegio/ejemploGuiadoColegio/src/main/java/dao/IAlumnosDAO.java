package dao;

import java.util.ArrayList;

import DTO.AlumnoDTO;

public interface IAlumnosDAO {
	ArrayList<AlumnoDTO> obtenerTodosAlumnos();
	ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(String id, String nombre, String apellido, int familiaNumerosa, int activo);
	int insertarAlumno(String id, String nombre, String apellido, String idMunicipio, int familiaNumerosa, int activo);
}
