package exceptions;

@SuppressWarnings("serial")
public class ProfesorNoExisteException extends Exception {
	
	public ProfesorNoExisteException(String mensaje) {
		super(mensaje);
	}
}
