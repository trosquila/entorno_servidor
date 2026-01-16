package com.adrian.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IDesplegablesDAO;
import com.adrian.colegio.dtos.DesplegableDTO;
import com.adrian.colegio.entities.AlumnoEntity;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.entities.MunicipioEntity;
import com.adrian.colegio.entities.NotaEntity;
import com.adrian.colegio.repositorios.AlumnoRepository;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.MunicipioRepository;
import com.adrian.colegio.repositorios.NotaRepository;

@Repository
public class DesplegablesDAOImpl implements IDesplegablesDAO {

	@Autowired // Inyectamos el repository
	private MunicipioRepository municipioRepository;
	@Autowired 
	private AsignaturaRepository asignaturaRepository;
	@Autowired 
	private AlumnoRepository alumnoRepository;
	@Autowired 
	private NotaRepository notaRepository;

	@Override
	public ArrayList<DesplegableDTO> desplegableMunicipios() {
		// Utilizamos el método que nos "regala" Spring data JPA
		Iterable<MunicipioEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		ArrayList<DesplegableDTO> listaMunicipios = mapeoEntidadMunicioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	private ArrayList<DesplegableDTO> mapeoEntidadMunicioComboDTO(Iterable<MunicipioEntity> listaEntidadesMunicipios) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (MunicipioEntity municipiosEntity : listaEntidadesMunicipios) {
			listaCombos.add(new DesplegableDTO(municipiosEntity.getIdMunicipio(), municipiosEntity.getNombre()));
		}
		return listaCombos;

	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAlumnos() {
		Iterable<AlumnoEntity> listaEntidadesAlumnos = alumnoRepository.findAll();
		ArrayList<DesplegableDTO> listaAlumnos = mapeoEntidadAlumnos(listaEntidadesAlumnos);
		return listaAlumnos;
	}
	private ArrayList<DesplegableDTO> mapeoEntidadAlumnos(Iterable<AlumnoEntity> listaEntidadesAlumnos) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (AlumnoEntity alumnosEntity : listaEntidadesAlumnos) {
			listaCombos.add(new DesplegableDTO(alumnosEntity.getId(), alumnosEntity.getNombre()));
		}
		return listaCombos;
	}
	

	@Override
	public ArrayList<DesplegableDTO> desplegableAsignaturas() {
		//Utilizamos el método que nos "regala" Spring data JPA
		Iterable<AsignaturaEntity> listaEntidadesAsignaturas = asignaturaRepository.findAll();
		ArrayList<DesplegableDTO> listaAsignaturas = mapeoEntidadAsignaturas(listaEntidadesAsignaturas);
		return listaAsignaturas;

	}

	private ArrayList<DesplegableDTO> mapeoEntidadAsignaturas(Iterable<AsignaturaEntity> listaEntidadesAsignaturas) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (AsignaturaEntity asignaturasEntity : listaEntidadesAsignaturas) {
			listaCombos.add(new DesplegableDTO(asignaturasEntity.getId(), asignaturasEntity.getNombre()));
		}
		return listaCombos;
	}
	

}
