package ejercicioPrueba.controlador.vistaControlador;

import ejercicioPrueba.modelo.tipo.TipoModel;

public class TipoController implements ITipoController{
	 private TipoModel tipoModel;
	 public TipoController() {
		 this.tipoModel = new TipoModel();
	 }
	@Override
	public void controlMenu(int choose) {
		switch (choose) {
		case 1:
				//insertar tipos
				
			break;
		case 2:
				//listar tipos
			
			break;
		case 3:
				//update tipos
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
