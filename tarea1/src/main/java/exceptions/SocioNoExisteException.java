package exceptions;

@SuppressWarnings("serial")
public class SocioNoExisteException extends Exception {
	
	public SocioNoExisteException(String mensaje) {
		super(mensaje);
	}
}
