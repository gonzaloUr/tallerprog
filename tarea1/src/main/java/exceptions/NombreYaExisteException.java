package com.entrenamosuy.tarea1.exceptions;

@SuppressWarnings("serial")
public class NombreYaExisteException extends Exception {
	
	public NombreYaExisteException(String mensaje) {
		super(mensaje);
	}
}
