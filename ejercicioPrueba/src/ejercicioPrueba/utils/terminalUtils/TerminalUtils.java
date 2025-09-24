package ejercicioPrueba.utils.terminalUtils;

import java.util.Scanner;

public class TerminalUtils {
	
	private static Scanner scanner = new Scanner(System.in);

	public static String inputText() {
		String result = scanner.nextLine();
		return result;
	}
	
	public static void output(String text) {
		System.out.println(text);
	}

	public static int inputInt() {
		int result = Integer.parseInt(scanner.nextLine());
		return result;
	}
	
	public static boolean esValido(String value){
		return value  != null && !value.isEmpty() && !value.isBlank();
	}
}
