package com.adrian.colegio.controladores.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.servicio.interfaces.IMatriculacionesService;

@RestController
@RequestMapping("/colegio/v2")
public class MatriculacionesRestControllerV2 {

    @Autowired
    private IMatriculacionesService matriculacionesService;
    
    @GetMapping(value = "/matriculaciones", params = {"nombreAsignatura", "nombreAlumno", "fecha", "activo"})
    public ResponseEntity<List<MatriculacionDTO>> listarTodas() {
        return ResponseEntity.ok(
            matriculacionesService.obtenerMatriculacionesPorFiltros(null, null, null, null)
        );
    }

    @GetMapping("/matriculaciones")
    public ResponseEntity<List<MatriculacionDTO>> listarConFiltros(
            @RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
            @RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
            @RequestParam(value = "fecha", required = false) String fecha,
            @RequestParam(value = "activo", required = false) Integer activo) {

        Integer act = (activo != null && (activo == 0 || activo == 1)) ? activo : null;

        return ResponseEntity.ok(
            matriculacionesService.obtenerMatriculacionesPorFiltros(nombreAsignatura, nombreAlumno, fecha, act)
        );
    }

    
    @GetMapping("/matriculaciones/{id}")
    public ResponseEntity<MatriculacionDTO> buscarAsignaturaPorId(@PathVariable("id") Integer id) {
        ArrayList<MatriculacionDTO> matricula = matriculacionesService.obtenerMatriculasPorId(id);
        if (matricula == null || matricula.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matricula.get(0));
    }
    
    
	@PostMapping("/matriculaciones")
	public ResponseEntity<MatriculacionDTO> insertarMatriculacion(@RequestBody MatriculacionDTO matricula) {
		matriculacionesService.insertarMatriculacion(matricula.getIdAlumno(), matricula.getIdAsignatura(), matricula.getFecha(), matricula.getTasa());
		
		return new ResponseEntity<>(matricula, HttpStatus.CREATED);
	}
    
    
	 @PutMapping("/matriculaciones/{id}")
	    public ResponseEntity<?> actualizarMatriculas(@PathVariable Integer id, @RequestBody MatriculacionDTO matricula) {

	        if (matricula.getId() == null || !id.equals(matricula.getId())) {
	            return ResponseEntity.badRequest().body("El ID de la URL no coincide con el de la matricula");
	        }

	        ArrayList<MatriculacionDTO> existente = matriculacionesService.obtenerMatriculasPorId(id);
	        if (existente == null || existente.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        matriculacionesService.actualizarMatriculacion(
	        		matricula.getId(),
	        		matricula.getIdAlumno(),
	        		matricula.getIdAsignatura(),
	        		matricula.getFecha(),
	        		matricula.getTasa()
	        );

	        ArrayList<MatriculacionDTO> actualizada = matriculacionesService.obtenerMatriculasPorId(id);
	        return ResponseEntity.ok(actualizada.isEmpty() ? null : actualizada.get(0));
	    }
	 
	    @DeleteMapping("/matriculaciones/{id}")
	    public ResponseEntity<String> borrarAsignatura(@PathVariable Integer id) {

	        ArrayList<MatriculacionDTO> existente = matriculacionesService.obtenerMatriculasPorId(id);
	        if (existente == null || existente.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        matriculacionesService.borrarMatriculacion(id);

	        return ResponseEntity.ok("Asignatura eliminada correctamente.");
	    }
}
