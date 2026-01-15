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
        model.addAttribute("alumnos", desplegables.desplegableAlumnos());
        model.addAttribute("asignaturas", desplegables.desplegableAsignaturas());
        return "notas/insertarNota";
    }

    @PostMapping("/insertarNota")
    public String insertarNota(
        @RequestParam("alumno") Integer idAlumno,
        @RequestParam("asignatura") Integer idAsignatura,
        @RequestParam("nota") String nota,
        @RequestParam(value = "fecha", required = false) String fecha,
        ModelMap model
    ) {
        Integer resultado = notasService.insertarNota(idAlumno, idAsignatura, nota, fecha);
        model.addAttribute("resultado", resultado);
        return "notas/insertarNota";
    }

    // LISTAR
    @GetMapping("/listadoNotas")
    public String formularioListadoNotas() {
        return "notas/listadoNotas";
    }

    @PostMapping("/listadoNotas")
    public String listadoNotas(
        @RequestParam(value = "idNota", required = false) Integer idNota,
        @RequestParam(value = "idAlumno", required = false) Integer idAlumno,
        @RequestParam(value = "idAsignatura", required = false) Integer idAsignatura,
        ModelMap model
    ) {
        ArrayList<NotaDTO> lista =
            notasService.obtenerNotasPorFiltros(idNota, idAlumno, idAsignatura);
        model.addAttribute("lista", lista);
        return "notas/listadoNotas";
    }

    // BORRAR
    @PostMapping("/borrarNota")
    public String borrarNota(@RequestParam("id") Integer id, ModelMap model) {
        Integer resultado = notasService.borrarNota(id);
        model.addAttribute("resultado", resultado);
        return "notas/listadoNotas";
    }
}
