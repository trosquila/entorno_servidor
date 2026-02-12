package com.adrian.colegio.controladores.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.servicio.interfaces.IAsignaturasService;

import org.springframework.web.bind.annotation.RequestBody;

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
	
	/*
	@GetMapping("/asignaturas")
    public ResponseEntity<Iterable<AsignaturaDTO>> listarTodas() {
        return new ResponseEntity<>(asignaturaService.obtenerAsignaturasPorFiltros(null, null, null, null, null), HttpStatus.OK);
    }
	*/
	
	@GetMapping("/asignaturas/{id}")
	public ArrayList<AsignaturaDTO> buscarAsignaturaPorId(@PathVariable("id") Integer id){
	    return asignaturaService.obtenerAsignaturasPorId(id);
	}
	

		@GetMapping(value= "/asignaturas", params = {"id", "nombre", "curso", "tasa", "activo"})
		public List<AsignaturaDTO> listarAsignaturas(
				@RequestParam(value = "id", required = false) Integer id,
				@RequestParam(value = "nombre", required = false) String nombre,
				@RequestParam(value = "curso", required = false) Integer curso,
				@RequestParam(value = "tasa", required = false) Double tasa,
				@RequestParam(value = "activo", required = false) String activo) {
	
			// Convertir activo de String a Integer (igual que tu código antiguo)
			Integer act = (activo != null && !activo.isEmpty()) ? 1 : null;
			return asignaturaService.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, act);
		}
		@PutMapping("/asignaturas/{id}")
		public ResponseEntity<?> actualizarAsignaturas(@PathVariable Integer id, @RequestBody AsignaturaDTO asignatura) {
			if (!id.equals(asignatura.getId())) {
				return ResponseEntity.badRequest().body("El ID de la URL no coincide con el de la asignatura");
			}

			//Aprovechamos que ya lo tenemos implementado
			if (buscarAsignaturaPorId(asignatura.getId()) == null) {
				return ResponseEntity.notFound().build(); // Devolvera un error 404
			}

			asignaturaService.actualizarAsignatura(asignatura.getId(), asignatura.getNombre(), asignatura.getCurso(), asignatura.getTasa(), asignatura.getActivo());
			return ResponseEntity.ok(buscarAsignaturaPorId(asignatura.getId()));
		}
		
		@DeleteMapping("/asignaturas/{id}")
		public ResponseEntity<?> borrarAsignatura(@PathVariable Integer id) {

			if (buscarAsignaturaPorId(id) == null) {
				return ResponseEntity.notFound().build(); // Devolvera un error 404
			}
			asignaturaService.borrarAsignatura(id);
			return new ResponseEntity<String>("Borrado correcto!", HttpStatus.OK);
		}
	
	
}
