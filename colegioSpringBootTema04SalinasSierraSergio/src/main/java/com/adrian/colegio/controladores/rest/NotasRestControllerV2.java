package com.adrian.colegio.controladores.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.servicio.interfaces.INotasService;

@RestController
@RequestMapping("/v1")
public class NotasRestControllerV2 {

    @Autowired
    private INotasService notasService;

    @PostMapping("/notas")
    public ResponseEntity<String> insertarNota(@RequestBody NotaDTO nota) {
        notasService.insertarNota(nota.getIdAlumno(), nota.getIdAsignatura(),Double.parseDouble( nota.getNota()), nota.getFecha());
        return new ResponseEntity<>("Inserción correcta!", HttpStatus.OK);
    }
    //arreglar
    @GetMapping("/notas/{id}")
    public ArrayList<NotaDTO> buscarNotaPorId(@PathVariable("id") Integer id) {
        // Asumiendo que existe un método similar en el servicio
        return notasService.obtenerNotasPorFiltros(null, null, null, null, null, null);
    }

    @GetMapping(value = "/notas", params = {"idAlumno", "nombreAlumno", "asignatura", "nota", "fecha", "activo"})
    public List<NotaDTO> listarNotas(
            @RequestParam(value = "idAlumno", required = false) Integer idAlumno,
            @RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
            @RequestParam(value = "asignatura", required = false) String asignatura,
            @RequestParam(value = "nota", required = false) Double nota,
            @RequestParam(value = "fecha", required = false) String fecha,
            @RequestParam(value = "activo", required = false) String activo) {

        // Convertir activo de String a Integer
        Integer act = (activo != null && !activo.isEmpty()) ? 1 : null;	
        
        // Si la fecha está vacía, usar la fecha actual
        if (fecha == null || fecha.isEmpty() || fecha.isBlank()) {
            fecha = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        return notasService.obtenerNotasPorFiltros(idAlumno, nombreAlumno, asignatura, nota, fecha, act);
    }

    @PutMapping("/notas/{id}")
    public ResponseEntity<?> actualizarNota(@PathVariable Integer id, @RequestBody NotaDTO nota) {
        if (!id.equals(nota.getId())) {
            return ResponseEntity.badRequest().body("El ID de la URL no coincide con el de la nota");
        }

  
        ArrayList<NotaDTO> notaExistente = buscarNotaPorId(nota.getId());
        if (notaExistente == null || notaExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        notasService.actualizarNota(nota.getId(), nota.getIdAlumno(), nota.getIdAsignatura(), Double.parseDouble( nota.getNota()), nota.getFecha());
        return ResponseEntity.ok(buscarNotaPorId(nota.getId()));
    }

    @DeleteMapping("/notas/{id}")
    public ResponseEntity<?> borrarNota(@PathVariable Integer id) {
        ArrayList<NotaDTO> notaExistente = buscarNotaPorId(id);
        if (notaExistente == null || notaExistente.isEmpty()) {
            return ResponseEntity.notFound().build(); // Devolverá un error 404
        }
        
        notasService.borrarNota(id);
        return new ResponseEntity<String>("Borrado correcto!", HttpStatus.OK);
    }
    
}