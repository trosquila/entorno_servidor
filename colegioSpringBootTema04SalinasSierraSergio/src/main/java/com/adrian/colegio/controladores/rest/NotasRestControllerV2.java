package com.adrian.colegio.controladores.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.servicio.interfaces.INotasService;

@RestController
@RequestMapping("/colegio/v2")
public class NotasRestControllerV2 {

    @Autowired
    private INotasService notasService;

    @PostMapping("/notas")
    public ResponseEntity<NotaDTO> insertarNota(@RequestBody NotaDTO nota) {
        notasService.insertarNota(
                nota.getIdAlumno(),
                nota.getIdAsignatura(),
                Double.parseDouble(nota.getNota()),
                nota.getFecha()
        );
        return new ResponseEntity<>(nota, HttpStatus.CREATED);
    }

    @GetMapping("/notas/{id}")
    public ResponseEntity<NotaDTO> buscarNotaPorId(@PathVariable("id") Integer id) {
        ArrayList<NotaDTO> res = notasService.obtenerNotaPorId(id);
        if (res == null || res.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res.get(0));
    }

    @GetMapping(value = "/notas", params = {
            "idAlumno", "nombreAlumno", "asignatura", "nota", "fecha", "activo"})
    public ResponseEntity<List<NotaDTO>> listarTodas() {
        return ResponseEntity.ok(
                notasService.obtenerNotasPorFiltros(null, null, null, null, null, null)
        );
    }

    @GetMapping("/notas")
    public ResponseEntity<List<NotaDTO>> listarNotasConFiltros(
            @RequestParam(value = "idAlumno", required = false) Integer idAlumno,
            @RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
            @RequestParam(value = "asignatura", required = false) String asignatura,
            @RequestParam(value = "nota", required = false) Double nota,
            @RequestParam(value = "fecha", required = false) String fecha,
            @RequestParam(value = "activo", required = false) String activo) {

        Integer act = ("1".equals(activo)) ? 1 : null;

        if (fecha == null || fecha.isBlank()) {
            fecha = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        return ResponseEntity.ok(
                notasService.obtenerNotasPorFiltros(idAlumno, nombreAlumno, asignatura, nota, fecha, act)
        );
    }

    @PutMapping("/notas/{id}")
    public ResponseEntity<?> actualizarNota(@PathVariable Integer id, @RequestBody NotaDTO nota) {

        if (nota.getId() == null || !id.equals(nota.getId())) {
            return ResponseEntity.badRequest().body("El ID de la URL no coincide con el de la nota");
        }

        ArrayList<NotaDTO> notaExistente = notasService.obtenerNotaPorId(id);
        if (notaExistente == null || notaExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        notasService.actualizarNota(
                id,
                nota.getIdAlumno(),
                nota.getIdAsignatura(),
                Double.parseDouble(nota.getNota()),
                nota.getFecha()
        );

        ArrayList<NotaDTO> actualizada = notasService.obtenerNotaPorId(id);
        return ResponseEntity.ok(actualizada.isEmpty() ? null : actualizada.get(0));
    }

    @DeleteMapping("/notas/{id}")
    public ResponseEntity<String> borrarNota(@PathVariable Integer id) {

        ArrayList<NotaDTO> notaExistente = notasService.obtenerNotaPorId(id);
        if (notaExistente == null || notaExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        notasService.borrarNota(id);
        return ResponseEntity.ok("Nota eliminada correctamente.");
    }
}
