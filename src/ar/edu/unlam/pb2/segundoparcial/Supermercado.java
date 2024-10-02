package ar.edu.unlam.pb2.segundoparcial;
import java.util.HashMap;
import java.util.Map;

public class Supermercado {

	private String cuit;
	private String nombre;
	private final Integer STOCK_INICIAL=0;
	private Map<Alimento, Integer> stock = new HashMap<Alimento, Integer>();
		
	public Supermercado(String cuit, String nombre) {
		this.cuit=cuit;
		this.nombre=nombre;
		}
			
	public void agregarAlimento(Alimento alimento) {
		this.agregarAlimento(alimento, STOCK_INICIAL);
		}
	
	public void agregarAlimento(Alimento alimento, Integer cantidad) {
		Alimento clave = alimento;
		if(this.stock.containsKey(clave)) {
			Integer valor = this.stock.get(clave);
			valor = valor + cantidad;
			this.stock.put(clave, valor);
		} else {
			this.stock.put(clave, cantidad);
		}
	}
	
	public Integer getStock(Alimento alimento) {
		Alimento clave = alimento;
		return stock.get(clave);
		}
	
	public Integer getCantidadAlimentos() {
		return stock.size();
		}
	
	public void actualizarGondolaSupermercado(Alimento vendido, Integer cantidadVendida)throws StockInsuficienteException {
		try {
			Boolean stockSuficiente=false;
			Integer stockActualizado;
			for(Map.Entry<Alimento, Integer> entrada:this.stock.entrySet()) {
				if(entrada.getKey().equals(vendido)) {
					if(entrada.getValue()>=cantidadVendida) {
						stockActualizado = entrada.getValue() - cantidadVendida;
						modificarStock(vendido, stockActualizado);
						stockSuficiente = true;
					}
				}
			}
			if(stockSuficiente==false) {
				throw new StockInsuficienteException();
			}
		}catch (StockInsuficienteException exception) {
			throw exception;
		}
	}

	public void modificarStock(Alimento alimento, Integer nuevoStock) {
		Alimento clave = alimento;
	    Integer valor = nuevoStock;
		if(this.stock.containsKey(clave)) {
			this.stock.put(clave, valor);
			}
		}

	public String getCuit() {
		return cuit;
	}

	public String getNombre() {
		return nombre;
	}
	
}
