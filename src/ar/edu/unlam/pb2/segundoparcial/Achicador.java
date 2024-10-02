package ar.edu.unlam.pb2.segundoparcial;

public class Achicador extends Alimento {
	
	private final static Integer HabilidadPorConsumo = 50;
	
	protected Achicador(String marca, Double precio, TipoDeDulce tipo) {
		super(marca, precio, tipo);
	}

	@Override
	public Integer activarEfectoPorConsumo(Integer altura) {
		Integer nuevaAltura = altura - HabilidadPorConsumo;
		return nuevaAltura;
	}
}
