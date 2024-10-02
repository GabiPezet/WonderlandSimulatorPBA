package ar.edu.unlam.pb2.segundoparcial;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public abstract class Personaje implements Comparable<Personaje>{
	
	protected Integer altura;
	protected Double peso;
	protected String nombre;
	protected Integer edad;
	protected Double dinero;
	private final Integer ALTURA_MAXIMA_PERMITIDA = 280;
	private final Integer ALTURA_MINIMA_PERMITIDA = 50;
	protected LinkedList<Alimento> changuito = new LinkedList<Alimento>();
	
	public Personaje (Integer altura, String nombre, Double peso, Integer edad, Double dinero) {
		super();
		this.altura=altura;
		this.nombre=nombre;
		this.peso=peso;
		this.edad=edad;
		this.dinero=dinero;
		}
	
	public Integer getAltura() {return altura;}

	public void setAltura(Integer altura) {this.altura = altura;}

	public Double getDinero() {return dinero;}
	
	public LinkedList<Alimento> getChanguito(){return this.changuito;}
	
	public Boolean activarBocadillo(Alimento bocadillo) {
		Boolean efectoActivado=false;
		for(Alimento alimento: this.changuito) {
			if(alimento.equals(bocadillo)) {
				if(bocadillo.activarEfectoPorConsumo(this.getAltura())<= this.ALTURA_MAXIMA_PERMITIDA &&
					bocadillo.activarEfectoPorConsumo(this.getAltura())>= this.ALTURA_MINIMA_PERMITIDA) {
				  Integer nuevaAltura = bocadillo.activarEfectoPorConsumo(this.getAltura());
				  this.setAltura(nuevaAltura);
				  return efectoActivado=true;
						}
					}
			}return efectoActivado;
		}
	
	
	public void activarBocadilloConExcepcion(Alimento bocadillo) throws LimitesDeAlturaException {	
	try {	
		Boolean efectoActivado=false;
		for(Alimento alimento: this.changuito) {
			if(alimento.equals(bocadillo)) {
				if(bocadillo.activarEfectoPorConsumo(this.getAltura())<= this.ALTURA_MAXIMA_PERMITIDA &&
					bocadillo.activarEfectoPorConsumo(this.getAltura())>= this.ALTURA_MINIMA_PERMITIDA) {
				  Integer nuevaAltura = bocadillo.activarEfectoPorConsumo(this.getAltura());
				  this.setAltura(nuevaAltura);
				  efectoActivado=true;
						}
				  }
			}
		if(efectoActivado==false) {
			throw new LimitesDeAlturaException();
			}
		}catch (LimitesDeAlturaException exception) {
			throw exception;
			}
	}
	
	public void ingresarAlimentoAlChanguito(Alimento alimento, Integer cantidad)throws SaldoInsuficienteException {
	try {	
		Boolean resultado=false;
		if(verificarDineroAntesDeComprar(alimento,cantidad)) {
			this.changuito.add(alimento);
			resultado=true;
			}
		if(resultado==false) {
		throw new SaldoInsuficienteException();
			}
		}
	catch (SaldoInsuficienteException exception) {
		throw exception;
		}
	}
	
	public Boolean verificarDineroAntesDeComprar(Alimento alimento, Integer cantidad) {
		Double precioTotal=alimento.getPrecio()*cantidad;
		Boolean dineroDisponible=false;
		if(this.dinero>=precioTotal) {
			this.dinero=this.dinero-precioTotal;
			dineroDisponible=true;
			return dineroDisponible;
			} return dineroDisponible;	
		}
	
	public void ordenarPorMarca() {
		ComparadorMarca compMarca = new ComparadorMarca();
		Collections.sort(this.changuito, compMarca);
		}
	
	public LinkedList<Alimento> getChanguitoOrdenado() {
		this.ordenarPorMarca();
		return this.changuito;
		}
	
	public Alimento getPrimero() {
		return this.changuito.getFirst();
		}
	public Alimento getUltimo() {
		return this.changuito.getLast();
		}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
		}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(nombre, other.nombre);
		}
	
	@Override
	public int compareTo(Personaje otro) {
		// TODO Auto-generated method stub
		return this.compareTo(otro);
	}
}
