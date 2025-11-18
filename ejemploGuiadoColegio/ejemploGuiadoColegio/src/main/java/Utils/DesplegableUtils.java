package Utils;

import java.util.ArrayList;

import DTO.DesplegableDTO;
import DTO.IDesplegableDAO;
import dao.DesplegableDAOImp;
import jakarta.servlet.http.HttpServletRequest;

public class DesplegableUtils {
	public static void recuperarDesplegableMunicipios(HttpServletRequest request) {
		IDesplegableDAO desplegableMunicipios = new DesplegableDAOImp();
		ArrayList<DesplegableDTO> listaMunicipios =
		desplegableMunicipios.desplegableMunicipios();
		request.setAttribute("desplegableMunicipios", listaMunicipios);
	}
}
