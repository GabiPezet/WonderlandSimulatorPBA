package ar.edu.unlam.pb2.segundoparcial;
import java.util.Comparator;

public class ComparadorMarca implements Comparator<Alimento> {
	
	@Override
	public int compare(Alimento unAlimento, Alimento otroAlimento) {
		String unaMarca = unAlimento.getNombreMarca();
		String otraMarca = otroAlimento.getNombreMarca();
		return -unaMarca.compareToIgnoreCase(otraMarca);
	}

}
