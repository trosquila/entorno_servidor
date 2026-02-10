package com.adrian.colegio.controladores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.servicio.interfaces.IAsignaturasService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/v1")
public class AsignaturaRestControllerV1 {
	
	@Autowired
	private IAsignaturasService asignaturaService;
	
	@PostMapping("/asignaturas")
	public ResponseEntity<String> insertarAsignatura(@RequestBody AsignaturaDTO asignatura){
		asignaturaService.insertarAsignatura(asignatura.getId(), asignatura.getNombre(),asignatura.getCurso(), asignatura.getTasa(), asignatura.getActivo());
		return new ResponseEntity<>("Insercción correcta! ", HttpStatus.OK);
	}
	
	@GetMapping("/asignaturas")
    public ResponseEntity<Iterable<AsignaturaDTO>> listarTodas() {
        return new ResponseEntity<>(asignaturaService.obtenerAsignaturasPorFiltros(null, null, null, null, null), HttpStatus.OK);
    }
}
