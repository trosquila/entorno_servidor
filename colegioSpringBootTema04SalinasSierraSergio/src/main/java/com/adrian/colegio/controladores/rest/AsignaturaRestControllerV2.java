package com.adrian.colegio.controladores.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.servicio.interfaces.IAsignaturasService;

@RestController
@RequestMapping("/colegio/v2")
public class AsignaturaRestControllerV2 {

    @Autowired
    private IAsignaturasService asignaturaService;

    @PostMapping("/asignaturas")
    public ResponseEntity<AsignaturaDTO> insertarAsignatura(@RequestBody AsignaturaDTO asignatura) {
        asignaturaService.insertarAsignatura(
                asignatura.getId(),
                asignatura.getNombre(),
                asignatura.getCurso(),
                asignatura.getTasa(),
                asignatura.getActivo()
        );
        return new ResponseEntity<>(asignatura, HttpStatus.CREATED);
    }

    @GetMapping("/asignaturas/{id}")
    public ResponseEntity<AsignaturaDTO> buscarAsignaturaPorId(@PathVariable("id") Integer id) {
        ArrayList<AsignaturaDTO> respuesta = asignaturaService.obtenerAsignaturasPorId(id);
        if (respuesta == null || respuesta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta.get(0));
    }

    @GetMapping(value = "/asignaturas")
    public ResponseEntity<List<AsignaturaDTO>> listarTodas() {

        return ResponseEntity.ok(asignaturaService.obtenerAsignaturasPorFiltros(null, null, null, null, null));
    }

    @GetMapping(value = "/asignaturas", params = {"id", "nombre", "curso", "tasa", "activo"})
    public ResponseEntity<List<AsignaturaDTO>> listarAsignaturas(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "curso", required = false) Integer curso,
            @RequestParam(value = "tasa", required = false) Double tasa,
            @RequestParam(value = "activo", required = false) Integer activo) {

        Integer activoOk = (activo != null && (activo == 0 || activo == 1)) ? activo : null;

        return ResponseEntity.ok(asignaturaService.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activoOk));
    }

    @PutMapping("/asignaturas/{id}")
    public ResponseEntity<?> actualizarAsignaturas(@PathVariable Integer id, @RequestBody AsignaturaDTO asignatura) {

        if (asignatura.getId() == null || !id.equals(asignatura.getId())) {
            return ResponseEntity.badRequest().body("El ID de la URL no coincide con el de la asignatura");
        }

        ArrayList<AsignaturaDTO> existente = asignaturaService.obtenerAsignaturasPorId(id);
        if (existente == null || existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        asignaturaService.actualizarAsignatura(
                asignatura.getId(),
                asignatura.getNombre(),
                asignatura.getCurso(),
                asignatura.getTasa(),
                asignatura.getActivo()
        );

        ArrayList<AsignaturaDTO> actualizada = asignaturaService.obtenerAsignaturasPorId(id);
        return ResponseEntity.ok(actualizada.isEmpty() ? null : actualizada.get(0));
    }

    @DeleteMapping("/asignaturas/{id}")
    public ResponseEntity<String> borrarAsignatura(@PathVariable Integer id) {

        ArrayList<AsignaturaDTO> existente = asignaturaService.obtenerAsignaturasPorId(id);
        if (existente == null || existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        asignaturaService.borrarAsignatura(id);

        return ResponseEntity.ok("Asignatura eliminada correctamente.");
    }
}
