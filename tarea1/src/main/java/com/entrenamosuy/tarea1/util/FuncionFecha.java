package com.entrenamosuy.tarea1.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class FuncionFecha {
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
}
