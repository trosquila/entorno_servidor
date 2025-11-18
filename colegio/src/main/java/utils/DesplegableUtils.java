package utils;

import java.util.ArrayList;

import dao.IDesplegableDAO;
import daoImp.DesplegableDAOImp;
import dto.DesplegableDTO;
import jakarta.servlet.http.HttpServletRequest;

public class DesplegableUtils {
	
	public static void recuperarDesplegableMunicipios(HttpServletRequest request) {
		IDesplegableDAO desplegableMunicipios = new DesplegableDAOImp();
		ArrayList<DesplegableDTO> listaMunicipios = desplegableMunicipios.desplegableMunicipios();
		request.setAttribute("desplegableMunicipios", listaMunicipios);
	}

}
