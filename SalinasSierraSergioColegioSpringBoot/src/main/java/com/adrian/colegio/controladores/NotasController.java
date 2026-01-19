package com.adrian.colegio.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.colegio.dao.interfaces.IDesplegablesDAO;
import com.adrian.colegio.dtos.DesplegableDTO;
import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.servicio.interfaces.INotasService;

@Controller
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    INotasService notasService;

    @Autowired
    IDesplegablesDAO desplegables;

    // INSERTAR
    @GetMapping("/insertarNota")
    public String formularioInsertarNota(ModelMap model) {
    	ArrayList<DesplegableDTO> listaAsignaturas =
				desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
        
        return "notas/insertarNota";
    }

    @PostMapping("/insertarNota")
    public String insertarNota(
        @RequestParam("alumno") Integer idAlumno,
        @RequestParam("asignatura") Integer idAsignatura,
        @RequestParam("nota") Integer nota,
        @RequestParam(value = "fecha", required = false) String fecha,
        ModelMap model
    ) {
    	
		ArrayList<DesplegableDTO> listaAsignaturas =
				desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);
		
		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		
        Integer resultado = notasService.insertarNota(idAlumno, idAsignatura, nota, fecha);
        model.addAttribute("resultado", resultado);
        return "notas/insertarNota";
    }

    @GetMapping("/listadoNotas")
    public String formularioListadoNotas() {
        return "notas/listadoNotas";
    }

    @PostMapping("/listadoNotas")
    public String listadoNotas(
    		@RequestParam(value = "idAlumno", required = false) Integer idAlumno,
            @RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
            @RequestParam(value = "asignatura", required = false) String asignatura,
            @RequestParam(value = "nota", required = false) Integer nota,
            @RequestParam(value = "fecha", required = false) String fecha,
            @RequestParam(value = "activo", required = false) Integer activo,
            ModelMap model

    ) {
        ArrayList<NotaDTO> lista = notasService.buscarNotas(idAlumno, nombreAlumno, asignatura, nota, fecha, activo);
        model.addAttribute("lista", lista);
        return "notas/listadoNotas";
    }
    
    @GetMapping("/formularioActualizarNotas")
    public String formularioActualizarNotas(ModelMap model) {
  
        return "notas/actualizarNotas";
    }
    
    @PostMapping("/formularioActualizarNotas")
    public String formularioModificarNotas(
            @RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
            @RequestParam(value = "asignatura", required = false) String asignatura,
            @RequestParam(value = "fecha", required = false) String fecha,
            ModelMap model) {

        ArrayList<NotaDTO> listaNotas = notasService.buscarNotas(null, nombreAlumno, asignatura, null, fecha,1);

        model.addAttribute("lista", listaNotas);

        return "notas/actualizarNotas";
    }
    
    
    @PostMapping("/actualizarNota")
    public String modificarNotas(
    		  @RequestParam(value = "id", required = false) Integer idNota,
    		  @RequestParam(value = "alumno", required = false) Integer idAlumno,
              @RequestParam(value = "asignatura", required = false) Integer idAsignatura,
              @RequestParam(value = "nota", required = false) Integer nota,
              @RequestParam(value = "fecha", required = false) String fecha,
              ModelMap model){
    	Integer resultado = notasService.actualizarNota(idNota, idAlumno, idAsignatura, nota, fecha);
		model.addAttribute("resultado", resultado);
		return null;
    	
    }
    // BORRAR
    @PostMapping("/borrarNota")
    public String borrarNota(@RequestParam("id") Integer id, ModelMap model) {
        Integer resultado = notasService.borrarNota(id);
        model.addAttribute("resultado", resultado);
        return "notas/listadoNotas";
    }
}
