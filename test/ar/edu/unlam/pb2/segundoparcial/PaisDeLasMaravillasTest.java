package ar.edu.unlam.pb2.segundoparcial;
import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;

public class PaisDeLasMaravillasTest {

	@Test
	public void queSePuedaCrearSupermercadoyAlicia() {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1500.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			assertNotNull(wonderMart);
			assertNotNull(alicia);
	}
	
	@Test
	public void queSePuedaReponerAlimentosAlSupermercado() {
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			assertNotNull(wonderMart);
			Achicador achicador1 = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			Achicador achicador2 = new Achicador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			Achicador achicador3 = new Achicador("Valente", 150.0, TipoDeDulce.BAGEL);
			Agrandador agrandador1 = new Agrandador("Mogul", 200.0, TipoDeDulce.GOMITAS);
			Agrandador agrandador2 = new Agrandador("Milka", 300.0, TipoDeDulce.BOCADO_DE_CHOCOLATE);
			Agrandador agrandador3 = new Agrandador("Arcor", 200.0, TipoDeDulce.CARAMELOS);
			wonderMart.agregarAlimento(achicador1, 10);
			wonderMart.agregarAlimento(achicador2, 10);
			wonderMart.agregarAlimento(achicador3, 10);
			wonderMart.agregarAlimento(agrandador1, 10);
			wonderMart.agregarAlimento(agrandador2, 10);
			wonderMart.agregarAlimento(agrandador3, 10);
			
			Integer alimentosEsperados=6;
			Integer alimentosObtenidos=wonderMart.getCantidadAlimentos();
			assertEquals(alimentosEsperados, alimentosObtenidos);
	}
	
	@Test
	public void queSePuedaActualizarStockEnGondolasSupermercado() throws StockInsuficienteException, SaldoInsuficienteException {
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1500.0);			
			Achicador achicador1 = new Achicador("Oreo", 200.0, TipoDeDulce.MASITA);
			Achicador achicador2 = new Achicador("Jorgelin", 250.0, TipoDeDulce.ALFAJOR);
			wonderMart.agregarAlimento(achicador1, 10);
			wonderMart.agregarAlimento(achicador2, 10);
			alicia.ingresarAlimentoAlChanguito(achicador1, 5);
			alicia.ingresarAlimentoAlChanguito(achicador2, 2);
			wonderMart.actualizarGondolaSupermercado(achicador1, 5);
			wonderMart.actualizarGondolaSupermercado(achicador2, 2);
			
			Integer stockOreoEsperado=5;
			Integer stockJorgelinEsperado=8;
			Integer stockOreoObtenido=wonderMart.getStock(achicador1);
			Integer stockJorgelinObtenido=wonderMart.getStock(achicador2);
			
			assertEquals(stockOreoEsperado, stockOreoObtenido);	
			assertEquals(stockJorgelinEsperado, stockJorgelinObtenido);
	}	
	
	@Test
	public void queAlComprarUnAlimentoSeDescuenteDineroDisponible() throws SaldoInsuficienteException {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1500.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Achicador achicador1 = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			Achicador achicador2 = new Achicador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			Achicador achicador3 = new Achicador("Valente", 150.0, TipoDeDulce.BAGEL);
			Agrandador agrandador1 = new Agrandador("Mogul", 200.0, TipoDeDulce.GOMITAS);
			Agrandador agrandador2 = new Agrandador("Milka", 300.0, TipoDeDulce.BOCADO_DE_CHOCOLATE);
			Agrandador agrandador3 = new Agrandador("Arcor", 200.0, TipoDeDulce.CARAMELOS);
			
			wonderMart.agregarAlimento(achicador1, 10);
			wonderMart.agregarAlimento(achicador2, 10);
			wonderMart.agregarAlimento(achicador3, 10);
			wonderMart.agregarAlimento(agrandador1, 10);
			wonderMart.agregarAlimento(agrandador2, 10);
			wonderMart.agregarAlimento(agrandador3, 10);
			
			alicia.ingresarAlimentoAlChanguito(achicador1,1);
			alicia.ingresarAlimentoAlChanguito(achicador2,1);
			alicia.ingresarAlimentoAlChanguito(agrandador1,1);
	
			Double dineroEsperado=700.0;
			Double dineroObtenido=alicia.getDinero();
			assertEquals(dineroEsperado, dineroObtenido);
	}
	
	@Test
	public void queNoSeExcedaDelDineroDisponible() throws SaldoInsuficienteException {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1000.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Achicador achicador1 = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			Achicador achicador2 = new Achicador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			wonderMart.agregarAlimento(achicador1, 10);
			wonderMart.agregarAlimento(achicador2, 10);

			Boolean verificacionSaldoSuficiente = alicia.verificarDineroAntesDeComprar(achicador1, 4);
			assertTrue(verificacionSaldoSuficiente);

			Boolean verificacionSaldoInsuficiente = alicia.verificarDineroAntesDeComprar(achicador2, 2);
			assertFalse(verificacionSaldoInsuficiente);
	}
	
	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeAgrande() throws SaldoInsuficienteException {
			Sombrerero sombrerero = new Sombrerero(150, 50.0, "Sombrerero", 32, 1000.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Agrandador agrandador1 = new Agrandador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			wonderMart.agregarAlimento(agrandador1, 10);
			sombrerero.ingresarAlimentoAlChanguito(agrandador1, 2);
			
			Boolean verificarAchicador=sombrerero.activarBocadillo(agrandador1);
			Integer alturaEsperada=190;
			Integer alturaObtenida=sombrerero.getAltura();	
			
			assertTrue(verificarAchicador);
			assertEquals(alturaEsperada,alturaObtenida);	
	}

	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeAchique() throws SaldoInsuficienteException {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1000.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Achicador achicador1 = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			wonderMart.agregarAlimento(achicador1, 10);;
			alicia.ingresarAlimentoAlChanguito(achicador1,1);
			
			Boolean verificarAchicador=alicia.activarBocadillo(achicador1);
			Integer alturaEsperada=130;
			Integer alturaObtenida=alicia.getAltura();	
			
			assertTrue(verificarAchicador);
			assertEquals(alturaEsperada,alturaObtenida);
	}
	
	@Test
	public void queAlConsumirDosAlimentosVerificarQueSeAchiqueyAgrande() throws SaldoInsuficienteException {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1000.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Achicador achicador = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			Agrandador agrandador = new Agrandador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			wonderMart.agregarAlimento(agrandador, 10);
			wonderMart.agregarAlimento(achicador, 10);
			alicia.ingresarAlimentoAlChanguito(agrandador, 1);
			alicia.ingresarAlimentoAlChanguito(achicador,1);
			
			Boolean verificarAchicador=alicia.activarBocadillo(achicador);
			Boolean verificarAgrandador=alicia.activarBocadillo(agrandador);
			Integer alturaEsperada=170;
			Integer alturaObtenida=alicia.getAltura();	
			
			assertTrue(verificarAchicador);
			assertTrue(verificarAgrandador);
			assertEquals(alturaEsperada,alturaObtenida);
	}
	@Test
	public void queNoSePuedaAgrandarMasDeLaAlturaMaximaPermitida() throws LimitesDeAlturaException, SaldoInsuficienteException {
			Sombrerero sombrerero = new Sombrerero(150, 50.0, "Sombrerero", 32, 2000.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Agrandador agrandador1 = new Agrandador("Mogul", 200.0, TipoDeDulce.GOMITAS);
			Agrandador agrandador2 = new Agrandador("Milka", 300.0, TipoDeDulce.BOCADO_DE_CHOCOLATE);
			Agrandador agrandador3 = new Agrandador("Arcor", 200.0, TipoDeDulce.CARAMELOS);
			wonderMart.agregarAlimento(agrandador1, 10);
			wonderMart.agregarAlimento(agrandador2, 10);
			wonderMart.agregarAlimento(agrandador3, 10);
			sombrerero.ingresarAlimentoAlChanguito(agrandador1, 2);
			sombrerero.ingresarAlimentoAlChanguito(agrandador2, 1);
			sombrerero.ingresarAlimentoAlChanguito(agrandador3, 1);
			
			sombrerero.activarBocadillo(agrandador1);
			sombrerero.activarBocadillo(agrandador2);
			
			Boolean verificarAgrandadorParcial = sombrerero.activarBocadillo(agrandador3);
			assertTrue(verificarAgrandadorParcial);
			
			Integer alturaObtenida = sombrerero.getAltura();
			Integer alturaEsperada = 270;
			assertEquals(alturaEsperada,alturaObtenida);
			
			Boolean verificarAgrandadorSuperaLimiteSuperior= sombrerero.activarBocadillo(agrandador1);
			assertFalse(verificarAgrandadorSuperaLimiteSuperior);
	}
	
	@Test
	public void queNoSePuedaAgrandarMasDeLaAlturaMinimaPermitida() throws LimitesDeAlturaException, SaldoInsuficienteException {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1000.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Achicador achicador1 = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			Achicador achicador2 = new Achicador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			Achicador achicador3 = new Achicador("Valente", 150.0, TipoDeDulce.BAGEL);
			wonderMart.agregarAlimento(achicador1, 10);
			wonderMart.agregarAlimento(achicador2, 10);
			wonderMart.agregarAlimento(achicador3, 10);
			alicia.ingresarAlimentoAlChanguito(achicador1,1);
			alicia.ingresarAlimentoAlChanguito(achicador2,1);
			alicia.ingresarAlimentoAlChanguito(achicador3,1);
			
			alicia.activarBocadillo(achicador1);
			alicia.activarBocadillo(achicador2);
			Integer alturaObtenida = alicia.getAltura();
			Integer alturaEsperada = 80;
			assertEquals(alturaEsperada,alturaObtenida);
			
			Boolean verificarAgrandadorSuperaLimiteInferior= alicia.activarBocadillo(achicador3);
			assertFalse(verificarAgrandadorSuperaLimiteInferior);
	}
	
	
	@Test
	public void queNoSePuedaAgrandarMasDeLaAlturaMaximaPermitidaConException() throws LimitesDeAlturaException, SaldoInsuficienteException {
			Sombrerero sombrerero = new Sombrerero(150, 50.0, "Sombrerero", 32, 2000.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Agrandador agrandador1 = new Agrandador("Mogul", 200.0, TipoDeDulce.GOMITAS);
			Agrandador agrandador2 = new Agrandador("Milka", 300.0, TipoDeDulce.BOCADO_DE_CHOCOLATE);
			Agrandador agrandador3 = new Agrandador("Arcor", 200.0, TipoDeDulce.CARAMELOS);
			wonderMart.agregarAlimento(agrandador1, 10);
			wonderMart.agregarAlimento(agrandador2, 10);
			wonderMart.agregarAlimento(agrandador3, 10);
			sombrerero.ingresarAlimentoAlChanguito(agrandador1, 2);
			sombrerero.ingresarAlimentoAlChanguito(agrandador2, 1);
			sombrerero.ingresarAlimentoAlChanguito(agrandador3, 1);
			
			sombrerero.activarBocadilloConExcepcion(agrandador1);
			sombrerero.activarBocadilloConExcepcion(agrandador1);
			sombrerero.activarBocadilloConExcepcion(agrandador2);
			
			Integer alturaEsperada=270;
			Integer alturaObtenida=sombrerero.getAltura();	
			assertEquals(alturaEsperada,alturaObtenida);
// para verificar que la excepción se lanza correctamente hay que quitar los comentarios de la linea siguiente:		
			//sombrerero.activarBocadilloConExcepcion(agrandador3);
	}
	
	@Test
	public void queElChanguitoQuedeOrdenadoPorNombreDeMarcaFormaDescendente() throws SaldoInsuficienteException {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1500.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Achicador achicador1 = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			Achicador achicador2 = new Achicador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			Achicador achicador3 = new Achicador("Valente", 150.0, TipoDeDulce.BAGEL);
			Agrandador agrandador1 = new Agrandador("Mogul", 200.0, TipoDeDulce.GOMITAS);
			Agrandador agrandador2 = new Agrandador("Milka", 300.0, TipoDeDulce.BOCADO_DE_CHOCOLATE);
			Agrandador agrandador3 = new Agrandador("Arcor", 200.0, TipoDeDulce.CARAMELOS);
			
			wonderMart.agregarAlimento(achicador1, 10);
			wonderMart.agregarAlimento(achicador2, 10);
			wonderMart.agregarAlimento(achicador3, 10);
			wonderMart.agregarAlimento(agrandador1, 10);
			wonderMart.agregarAlimento(agrandador2, 10);
			wonderMart.agregarAlimento(agrandador3, 10);
			
			alicia.ingresarAlimentoAlChanguito(achicador1,1);
			alicia.ingresarAlimentoAlChanguito(achicador2,1);
			alicia.ingresarAlimentoAlChanguito(achicador3,1);
			alicia.ingresarAlimentoAlChanguito(agrandador1,1);
			alicia.ingresarAlimentoAlChanguito(agrandador2,1);
			alicia.ingresarAlimentoAlChanguito(agrandador3,1);
			
			alicia.ordenarPorMarca();
			//mostrarColeccion(alicia.getChanguito());
		
			assertEquals(achicador3.getNombreMarca(),alicia.getPrimero().getNombreMarca());
			assertEquals(agrandador3.getNombreMarca(),alicia.getUltimo().getNombreMarca());
	}
	
	@Test
	public void queSePuedaCrearFiestaNoCumpleañosYqueSePuedaCargarLaMesaDeCatering() throws SaldoInsuficienteException {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1750.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Achicador achicador1 = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			Achicador achicador2 = new Achicador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			Achicador achicador3 = new Achicador("Valente", 150.0, TipoDeDulce.BAGEL);
			Agrandador agrandador1 = new Agrandador("Mogul", 250.0, TipoDeDulce.GOMITAS);
			Agrandador agrandador2 = new Agrandador("Milka", 300.0, TipoDeDulce.BOCADO_DE_CHOCOLATE);
			Agrandador agrandador3 = new Agrandador("Arcor", 450.0, TipoDeDulce.CARAMELOS);
			wonderMart.agregarAlimento(achicador1, 10);
			wonderMart.agregarAlimento(achicador2, 10);
			wonderMart.agregarAlimento(achicador3, 10);
			wonderMart.agregarAlimento(agrandador1, 10);
			wonderMart.agregarAlimento(agrandador2, 10);
			wonderMart.agregarAlimento(agrandador3, 10);
			alicia.ingresarAlimentoAlChanguito(achicador1,1);
			alicia.ingresarAlimentoAlChanguito(achicador2,1);
			alicia.ingresarAlimentoAlChanguito(achicador3,1);
			alicia.ingresarAlimentoAlChanguito(agrandador1,1);
			alicia.ingresarAlimentoAlChanguito(agrandador2,1);
			alicia.ingresarAlimentoAlChanguito(agrandador3,1);
			
			alicia.ordenarPorMarca();
			//mostrarColeccion(alicia.getChanguito());
			
			NoCumpleanos fiestaNoCumpleanos = new NoCumpleanos("No Cumpleanos del 4 de mayo!!!!");
			assertNotNull(fiestaNoCumpleanos);
			
			fiestaNoCumpleanos.ingresarInvitadoAlNoCumple(alicia);
			fiestaNoCumpleanos.cargarMesaCatering(alicia);
			
			Integer cateringEsperado = 6;
			Integer cateringObtenido = fiestaNoCumpleanos.getCatering().size();
			//mostrarColeccion(fiestaNoCumpleanos.getCatering());
			assertEquals(cateringEsperado,cateringObtenido);
	}
	
	@Test
	public void queLosBocadillosDelCateringSeVayanConsumiendoDelCateringDespuesDeActivarse() throws SaldoInsuficienteException {
			Alicia alicia = new Alicia(180, 65.0, "Alicia", 20, 1750.0);
			Supermercado wonderMart = new Supermercado("33715323619", "WonderMart");
			Achicador achicador1 = new Achicador("Oreo", 250.0, TipoDeDulce.MASITA);
			Achicador achicador2 = new Achicador("Jorgelin", 350.0, TipoDeDulce.ALFAJOR);
			Achicador achicador3 = new Achicador("Valente", 150.0, TipoDeDulce.BAGEL);
			Agrandador agrandador1 = new Agrandador("Mogul", 250.0, TipoDeDulce.GOMITAS);
			Agrandador agrandador2 = new Agrandador("Milka", 300.0, TipoDeDulce.BOCADO_DE_CHOCOLATE);
			Agrandador agrandador3 = new Agrandador("Arcor", 450.0, TipoDeDulce.CARAMELOS);
			wonderMart.agregarAlimento(achicador1, 10);
			wonderMart.agregarAlimento(achicador2, 10);
			wonderMart.agregarAlimento(achicador3, 10);
			wonderMart.agregarAlimento(agrandador1, 10);
			wonderMart.agregarAlimento(agrandador2, 10);
			wonderMart.agregarAlimento(agrandador3, 10);
			alicia.ingresarAlimentoAlChanguito(achicador1,1);
			alicia.ingresarAlimentoAlChanguito(achicador2,1);
			alicia.ingresarAlimentoAlChanguito(achicador3,1);
			alicia.ingresarAlimentoAlChanguito(agrandador1,1);
			alicia.ingresarAlimentoAlChanguito(agrandador2,1);
			alicia.ingresarAlimentoAlChanguito(agrandador3,1);
			
			alicia.ordenarPorMarca();
			//mostrarColeccion(alicia.getChanguito());
			NoCumpleanos fiestaNoCumpleanos = new NoCumpleanos("No Cumpleanos del 4 de mayo!!!!");
			assertNotNull(fiestaNoCumpleanos);		
	
			fiestaNoCumpleanos.ingresarInvitadoAlNoCumple(alicia);
			assertTrue(fiestaNoCumpleanos.verificarSiElInvitadoEstaEnElNoCumple(alicia));
			fiestaNoCumpleanos.cargarMesaCatering(alicia);
			
			fiestaNoCumpleanos.consumirBocadilloDelCatering(achicador3, alicia);
			fiestaNoCumpleanos.consumirBocadilloDelCatering(achicador2, alicia);
			fiestaNoCumpleanos.consumirBocadilloDelCatering(agrandador1, alicia);
			fiestaNoCumpleanos.consumirBocadilloDelCatering(achicador1, alicia);
			
			System.out.println(fiestaNoCumpleanos.llamarInvitado(alicia).getAltura());
	
			Integer cateringEsperado = 2;
			Integer cateringObtenido = fiestaNoCumpleanos.getCatering().size();
			mostrarColeccion(fiestaNoCumpleanos.getCatering());
			assertEquals(cateringEsperado,cateringObtenido);
	}
	
	private void mostrarColeccion(LinkedList<Alimento> changuito) {
	for (Alimento alimento: changuito) {
		System.out.println(alimento);
		}	
	}
}
