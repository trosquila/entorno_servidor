package com.daw.onepiece.controladores;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dao.interfaces.IPiratasDAO;
import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.dtos.IslaDTO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;

@Controller
@RequestMapping("/piratas")
public class PiratasController {
	
	@Autowired
	IPiratasDAO pirata;
	
	@Autowired
	IPirataService pirataService;
	
	@Autowired
	IDesplegablesDAO desplegables;
	
	@GetMapping("/listadoPiratas")
	public String formularioListarPiratas(ModelMap model) {
		
		return "piratas/listadoPiratas";
	}
	
	@PostMapping("/listadoPiratas")
	public String formularioListarPiratasRespueta(
			@RequestParam(value = "id", required = false) Integer idPirata,
			@RequestParam(value = "nombre", required = false) String nombrePirata,
			@RequestParam(value = "frutaDiablo", required = false) String frutaDiablo,
			@RequestParam(value = "activo", required = false) Integer activoForm, ModelMap model) {

		Boolean activo = (activoForm != null) ? (activoForm == 1) : null;
		ArrayList<PirataDTO> listaPiratas = pirataService.BuscarPirataPorFiltro(idPirata, nombrePirata, frutaDiablo, activo);
		System.out.println(listaPiratas);
		model.addAttribute("lista", listaPiratas);
		return "piratas/listadoPiratas";
	}
	
	@GetMapping("/insertarPirata")
	public String formularioInsertarPiratas(ModelMap model) {
		ArrayList<DesplegableDTO> listaIslas = desplegables.desplegableIslas();
		model.addAttribute("desplegableIslas", listaIslas);
		return "piratas/insertarPirata";
	}
	@PostMapping("/insertarPirata")
	public String insertarPirata(
            @RequestParam("nombre") String nombre,
            @RequestParam(value = "frutaDiablo", required = false) String frutaDiablo,
            @RequestParam(value = "fechaNacimiento", required = false) String fechaNacimientoStr,
            @RequestParam("islas") Integer islaId,
            @RequestParam(value = "activo", required = false) Integer activoForm,
            ModelMap model
    ) {

        boolean activo = (activoForm != null && activoForm == 1);

        LocalDate fechaNacimiento;
        if (fechaNacimientoStr == null || fechaNacimientoStr.isBlank()) {
            fechaNacimiento = LocalDate.now();
        } else {
            fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        }

        if (frutaDiablo != null && frutaDiablo.isBlank()) {
            frutaDiablo = null;
        }
        Integer result = pirataService.guardarNuevoNakama(nombre, frutaDiablo, fechaNacimiento, activo, islaId );
		return "piratas/insertarPirata";
	}
}