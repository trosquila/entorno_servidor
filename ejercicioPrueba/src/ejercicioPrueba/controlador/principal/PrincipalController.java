package ejercicioPrueba.controlador.principal;

import ejercicioPrueba.vista.tipo.VistaTipo;

public class PrincipalController implements IPrincipalController {

	@Override
	public void controlMenu(int choose) {
		
		switch (choose) {
		case 1:
				// ir a tipo
				VistaTipo tipo = new VistaTipo();
				tipo.menuTipo();
			break;
		case 2:
				//ir a publicación
			break;
		case 3:
				//ir a venta
			break;
		case 4:	
				// ir a empleado
			break;
		case 5:	
			// ir a usuario
		break;
		case 6:	
			// ir a promoción
		break;
		default:
			break;
		}
	}

}
