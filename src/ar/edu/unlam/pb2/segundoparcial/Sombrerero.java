package ar.edu.unlam.pb2.segundoparcial;

public class Sombrerero extends Personaje {

	private final static Integer ALTURA_INICIAL_SOMBRERERO=150;
	
	public Sombrerero(Integer altura, Double peso, String nombre, Integer edad, Double dinero) {
		super(altura, nombre, peso, edad, dinero);
		this.altura=ALTURA_INICIAL_SOMBRERERO;
		this.peso=peso;
		this.nombre=nombre;
		this.edad=edad;
		this.dinero=dinero;
		}
}
