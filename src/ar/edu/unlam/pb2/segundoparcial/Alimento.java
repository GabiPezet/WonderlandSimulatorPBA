package ar.edu.unlam.pb2.segundoparcial;
import java.util.Objects;

public abstract class Alimento implements Comparable<Alimento>{
	
	protected String nombreMarca;
	protected Double precio;
	protected TipoDeDulce tipo;
	//protected Integer codigo;
	
	protected Alimento (String marca, Double precio, TipoDeDulce tipo) {
		super();
		this.nombreMarca=marca;
		this.precio=precio;
		this.tipo=tipo;
		}
		
	public abstract Integer activarEfectoPorConsumo(Integer altura);
	
	public Double getPrecio() {return precio;}

	public String getNombreMarca() {return nombreMarca;}

	@Override
	public int hashCode() {
		return Objects.hash(nombreMarca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return Objects.equals(nombreMarca, other.nombreMarca);
	}

	@Override
	public int compareTo(Alimento otro) {
		// TODO Auto-generated method stub
		return this.compareTo(otro);
	}

	@Override
	public String toString() {return "Marca: " + nombreMarca + "|Precio: " + precio + "|Tipo: " + tipo;}

}
