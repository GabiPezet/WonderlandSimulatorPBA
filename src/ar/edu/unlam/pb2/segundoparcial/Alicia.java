package ar.edu.unlam.pb2.segundoparcial;

public class Alicia extends Personaje{
	
	private final static Integer ALTURA_INICIAL_ALICIA = 180;
		
	public Alicia(Integer altura, Double peso, String nombre, Integer edad, Double dinero) {
		super(altura, nombre, peso, edad, dinero);
		this.altura=ALTURA_INICIAL_ALICIA;
		this.peso=peso;
		this.nombre=nombre;
		this.edad=edad;
		this.dinero=dinero;
		}
}
