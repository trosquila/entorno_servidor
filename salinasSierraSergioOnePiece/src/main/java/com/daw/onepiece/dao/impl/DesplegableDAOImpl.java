package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.entities.IslaEntity;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.entities.TripulacionEntity;
import com.daw.onepiece.repositorios.IslaRepository;
import com.daw.onepiece.repositorios.PiratasRepository;
import com.daw.onepiece.repositorios.TripulacionRepository;
@Repository
public class DesplegableDAOImpl implements IDesplegablesDAO{
	@Autowired
	IslaRepository islaRepository;
	
	@Autowired
	PiratasRepository piratasRepository;
	@Autowired
	TripulacionRepository tripulacionRepository;
	
	@Override
	public ArrayList<DesplegableDTO> desplegableIslas() {
		Iterable<IslaEntity> listaEntidadesIslas = islaRepository.findAll();
		ArrayList<DesplegableDTO> listaIslas = mapeoEntidadIslaDTO(listaEntidadesIslas);
		return listaIslas;
	}
	
	private ArrayList<DesplegableDTO> mapeoEntidadIslaDTO(Iterable<IslaEntity> listaEntidadesIslas) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (IslaEntity islaEntity : listaEntidadesIslas) {
			listaCombos.add(new DesplegableDTO(islaEntity.getId(), islaEntity.getNombre()));
		}
		return listaCombos;

	}

	@Override
	public ArrayList<DesplegableDTO> desplegablePiratas() {
		Iterable<PirataEntity> listaEntidadesPiratas= piratasRepository.findAll();
		ArrayList<DesplegableDTO> listaPiratas = mapeoPiratasDTO(listaEntidadesPiratas);
		return listaPiratas;
	}
	
	private ArrayList<DesplegableDTO> mapeoPiratasDTO(Iterable<PirataEntity> listaEntidadesPiratas) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (PirataEntity pirataEntity : listaEntidadesPiratas) {
			listaCombos.add(new DesplegableDTO(pirataEntity.getId(), pirataEntity.getNombre()));
		}
		return listaCombos;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegableTripulacion() {
		Iterable<TripulacionEntity> listaEntidadesTripulacion = tripulacionRepository.findAll();
		ArrayList<DesplegableDTO> listaTripulacion = mapeoTripulacionDTO(listaEntidadesTripulacion);
		return listaTripulacion;
	}

	private ArrayList<DesplegableDTO> mapeoTripulacionDTO(Iterable<TripulacionEntity> listaEntidadesTripulacion) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (TripulacionEntity tripulacionEntity : listaEntidadesTripulacion) {
			listaCombos.add(new DesplegableDTO(tripulacionEntity.getId(), tripulacionEntity.getNombre()));
		}
		return listaCombos;
	}
}
