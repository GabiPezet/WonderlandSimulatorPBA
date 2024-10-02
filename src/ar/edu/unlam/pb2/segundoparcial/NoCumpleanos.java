package ar.edu.unlam.pb2.segundoparcial;
import java.util.*;

public class NoCumpleanos {
	
	private String nombre;
	private LinkedList<Alimento> catering = new LinkedList <Alimento>();
	private Set<Personaje> invitados = new HashSet<Personaje>();
	
	public NoCumpleanos(String nombre) {this.nombre=nombre;}
	
	public Boolean ingresarInvitadoAlNoCumple(Personaje invitado) {
		Boolean ingresoExitoso = false;
		if(!invitados.contains(invitado)) {
			invitados.add(invitado);
			ingresoExitoso = true;
			return ingresoExitoso;
		}return ingresoExitoso;
	}
	
	public Boolean cargarMesaCatering(Personaje invitado) {
		Boolean mesaPreparada=false;
		if(!invitado.getChanguito().isEmpty()) {
			this.catering=invitado.getChanguito();
			mesaPreparada=true;
			return mesaPreparada;
		}return mesaPreparada;
	}

	public Boolean consumirBocadilloDelCatering(Alimento bocadillo, Personaje invitado) {
		Boolean bocadilloConsumido=false;
		if(this.catering.contains(bocadillo) && this.invitados.contains(invitado)) {
			if(invitado.activarBocadillo(bocadillo)==true) {
				this.catering.remove(bocadillo);
				bocadilloConsumido=true;
				return bocadilloConsumido;
				}	
			}else {
				bocadilloConsumido=false;
			}return bocadilloConsumido;
		}
	
	public Boolean verificarSiElInvitadoEstaEnElNoCumple(Personaje invitado) {
		Boolean invitadoPresente=false;
		if(this.invitados.contains(invitado)) {
			return invitadoPresente=true;
			}return invitadoPresente;
		}
	
	public Personaje llamarInvitado(Personaje invitado) {
		Personaje buscado=null;
		if(this.invitados.contains(invitado)) {
			buscado=invitado;
			return buscado;
		}return buscado;
	}
	
	public String getNombre() {
		return nombre;
	}

	public LinkedList<Alimento> getCatering() {
		return catering;
	}

	public Set<Personaje> getInvitados() {
		return invitados;
	}
	
}
