package com.controller;

import java.time.LocalTime;

public class HoraYdescuento {
	 public String horaActual() {
	        LocalTime hora = LocalTime.now();
			return "La hora actual es: " + hora;
	    }
	 public int porcentaje() {
			return  (int) (Math.random() * 20) + 1;
			
		}
}
