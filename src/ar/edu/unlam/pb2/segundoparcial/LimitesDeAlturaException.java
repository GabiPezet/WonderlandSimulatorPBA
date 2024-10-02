package ar.edu.unlam.pb2.segundoparcial;

public class LimitesDeAlturaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "La altura minima o maxima no es suficiente";
	}
}
