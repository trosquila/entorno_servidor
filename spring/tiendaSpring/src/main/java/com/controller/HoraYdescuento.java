package com.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class HoraYdescuento {
	 public String horaActual() {
		    LocalDate fecha = LocalDate.now();
		    LocalTime hora = LocalTime.now();

		    // Obtener día y mes en formato textual
		    int dia = fecha.getDayOfMonth();
		    String mes = fecha.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

		    // Formatear la hora como hh:mm
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		    String horaFormateada = hora.format(formatter);
		    
		    int descuento = porcentaje();

		    return "El descuento de hoy " + dia + " de " + mes + " a las " + horaFormateada + " es de " + descuento + "%.";
	    }
	 public int porcentaje() {
			return  (int) (Math.random() * 18) + 2;
			
		}
}