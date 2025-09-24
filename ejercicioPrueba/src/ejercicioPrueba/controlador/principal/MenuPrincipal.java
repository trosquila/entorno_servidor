package ejercicioPrueba.controlador.principal;

import ejercicioPrueba.utils.terminalUtils.TerminalUtils;

public class MenuPrincipal {
	public void menu() {
		boolean control = true;
		do {
			System.out.println("Menú principal");
			System.out.println("<----------->");
			System.out.println("1.- Publicación");
			System.out.println("2.- Venta");
			System.out.println("3.- Empleado");
			System.out.println("4.- Usuario");
			try {
				int choose= TerminalUtils.inputInt();
				if(choose > 0 && choose < 5) {
					
				}else {
					System.out.println("Valor introducido no válido");
				}
			} catch (Exception e) {
				System.out.println("Valor introducido no válido");
			}
		}while(control == true);
	}
}
