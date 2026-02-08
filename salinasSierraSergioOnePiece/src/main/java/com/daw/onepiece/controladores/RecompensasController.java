package com.daw.onepiece.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.servicio.interfaces.IRecompensaService;

@Controller
@RequestMapping("/recompensas")
public class RecompensasController {

    @Autowired
    IRecompensaService recompensaService;

    @Autowired
    IDesplegablesDAO desplegables;

    @GetMapping("/listadoRecompensas")
    public String formularioListarRecompensas(ModelMap model) {
        ArrayList<DesplegableDTO> tripulacion = desplegables.desplegableTripulacion();
        model.addAttribute("tripulacionesActivas", tripulacion);


        return "recompensas/listadoRecompensas";
    }

    @PostMapping("/listadoRecompensas")
    public String listarRecompensas(
            @RequestParam(value = "nombrePirata", required = false) String nombrePirata,
            @RequestParam(value = "idTripulacion", required = false) Integer idTripulacion,
            @RequestParam(value = "cantidad", required = false) Long cantidad,
            @RequestParam(value = "estaVigente", required = false) Integer vigenteForm,
            ModelMap model) {

        Integer vigente = (vigenteForm != null && vigenteForm == 1) ? 1 : 0;
        
        
        ArrayList<DesplegableDTO> tripulacion = desplegables.desplegableTripulacion();
        ArrayList<RecompensaDTO> recompensa = recompensaService.BuscarRecompensaPorFiltro(nombrePirata, idTripulacion, cantidad, vigente);
        model.addAttribute("tripulacionesActivas", tripulacion);
        model.addAttribute("lista", recompensa);
        
        return "recompensas/listadoRecompensas";
    }

    @GetMapping("/actualizarRecompensas")
    public String formularioActualizarRecompensas(ModelMap model) {
        return "recompensas/actualizarRecompensas";
    }
}
