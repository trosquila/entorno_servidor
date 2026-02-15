package com.adrian.colegio.controladores.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.servicio.interfaces.IMatriculacionesService;

@RestController
@RequestMapping("/colegio/v1") // <- requerido por el profesor
public class MatriculacionesRestControllerV2 {

    @Autowired
    private IMatriculacionesService matriculacionesService;

    // 1. Listar todas (SIN filtros)
    @GetMapping(value = "/matriculaciones", params = {"!asignatura", "!nombreAlumno", "!fecha", "!activo"})
    public ResponseEntity<List<MatriculacionDTO>> listarTodas() {
        return ResponseEntity.ok(
            matriculacionesService.obtenerMatriculacionesPorFiltros(null, null, null, null)
        );
    }

    // 3. Buscar con filtros (opcionales)
    @GetMapping("/matriculaciones")
    public ResponseEntity<List<MatriculacionDTO>> listarConFiltros(
            @RequestParam(value = "asignatura", required = false) String asignatura,      // <- antes nombreAsignatura
            @RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
            @RequestParam(value = "fecha", required = false) String fecha,
            @RequestParam(value = "activo", required = false) Integer activo) {

        // activo: 1 = activa, null = todas
        Integer act = (activo != null && activo == 1) ? 1 : null;

        // Si no se proporciona fecha, usar la fecha actual
        if (fecha == null || fecha.isBlank()) {
            fecha = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        return ResponseEntity.ok(
            matriculacionesService.obtenerMatriculacionesPorFiltros(asignatura, nombreAlumno, fecha, act)
        );
    }

    // 2. Obtener una matriculación específica -> 200 o 404
    @GetMapping("/matriculaciones/{id}")
    public ResponseEntity<MatriculacionDTO> buscarMatriculacionPorId(@PathVariable("id") Integer id) {
        ArrayList<MatriculacionDTO> matricula = matriculacionesService.obtenerMatriculasPorId(id);
        if (matricula == null || matricula.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matricula.get(0));
    }

    // 4. Crear -> 201 Created + JSON
    @PostMapping("/matriculaciones")
    public ResponseEntity<MatriculacionDTO> insertarMatriculacion(@RequestBody MatriculacionDTO matricula) {
        matriculacionesService.insertarMatriculacion(
                matricula.getIdAlumno(),
                matricula.getIdAsignatura(),
                matricula.getFecha(),
                matricula.getTasa()
        );
        return new ResponseEntity<>(matricula, HttpStatus.CREATED);
    }

    // 5. Actualizar -> 200 o 404
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

    // 6. Eliminar (marcar inactiva) -> 200 o 404
    @DeleteMapping("/matriculaciones/{id}")
    public ResponseEntity<String> borrarMatriculacion(@PathVariable Integer id) {

        ArrayList<MatriculacionDTO> existente = matriculacionesService.obtenerMatriculasPorId(id);
        if (existente == null || existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Asumimos que tu service la marca como inactiva (como pide el enunciado)
        matriculacionesService.borrarMatriculacion(id);

        return ResponseEntity.ok("Matriculación eliminada correctamente.");
    }
}
