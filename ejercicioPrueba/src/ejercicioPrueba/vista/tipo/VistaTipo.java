package ejercicioPrueba.vista.tipo;

import ejercicioPrueba.controlador.vistaControlador.ITipoController;
import ejercicioPrueba.controlador.vistaControlador.TipoController;
import ejercicioPrueba.utils.terminalUtils.TerminalUtils;

public class VistaTipo {
	ITipoController iTipoController;
	public VistaTipo() {
		this.iTipoController = new TipoController();
	}
	public void menuTipo() {
		boolean control = true;
		do {
			System.out.println("Menú principal");
			System.out.println("<----------->");
			System.out.println("1.- tipo");
			System.out.println("2.- Publicación");
			System.out.println("3.- Venta");
			System.out.println("4.- Empleado");
			System.out.println("5.- Usuario");
			System.out.println("5.- Promoción");
			try {
				int choose= TerminalUtils.inputInt();
				if(choose > 0 && choose < 6) {
					iTipoController.controlMenu(choose);
				}else {
					System.out.println("Valor introducido no válido");
				}
			} catch (Exception e) {
				System.out.println("Valor introducido no válido");
			}
		}while(control == true);
		
	}

}
