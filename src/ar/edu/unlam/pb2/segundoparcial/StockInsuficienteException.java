package ar.edu.unlam.pb2.segundoparcial;

public class StockInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "El Stock es insuficiente";
	}
}
