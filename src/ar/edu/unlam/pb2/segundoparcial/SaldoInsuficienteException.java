package ar.edu.unlam.pb2.segundoparcial;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "El personaje no tiene saldo suficiente";
	}
}
