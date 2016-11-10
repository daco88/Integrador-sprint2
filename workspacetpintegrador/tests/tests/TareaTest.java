package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clases.Abierto;
import clases.AsistenciaUsuario;
import clases.Bug;
import clases.Cancelado;
import clases.Cerrado;
import clases.Desarrollo;
import clases.EnProceso;
import clases.Miembro;
import clases.Proyecto;
import clases.Tarea;

public class TareaTest {
	
	Bug bug;
	Miembro tester;
	Exception caughtException;
	
	@Before
	public void setUp() {
		tester = new Miembro("Tester");
		bug = new Bug("Debug sistema", "Bug", 3, tester);
	}
	
	
	@Test public void crearTareaYAsignarleTareaPrevia() {
		
		Proyecto miProyecto = new Proyecto("Migracion web", "10/03/2016", "12/25/2016", "Molinos");
		Desarrollo tareaPrevia = new Desarrollo("Preparar ambiente", "Desarrollo", 4, tester);
		
		miProyecto.asignarTarea(bug);
		bug.asignarTareaPrevia(tareaPrevia);
		
		assertEquals(miProyecto.getTareaAt(0).getTareaPrevia(), bug.getTareaPrevia());
	}
	
	@Test
	public void agregarleUnaTareaAUnMiembro() {
		
		//Exercise en setUp()

		assertEquals(1, tester.getCantTareas());
		assertEquals(tester, bug.getMiembro());
	}
	
	@Test
	public void agregarTareasAMiembroYConocerSusTareasAsignadas() {
		Miembro desarrollador = new Miembro("Desarrollador");
		Desarrollo tareaDesarrollo = new Desarrollo("Desarrollo sistema", "Desarrollo", 100, desarrollador);
		
		desarrollador.agregarTarea(bug);
		
		//Usar mockito
		assertEquals(2, desarrollador.getTareas().size());
	}
	
	//Test cambio de estado Asistencia al usuario
	@Test
	public void dadaUnaTareaAsistAlUsuarioCerrarla() throws Exception {
		Miembro soporte = new Miembro("Soporte Tecnico");
		AsistenciaUsuario tareaAsist = new AsistenciaUsuario("Problema al procesar operacion", "Asistencia al Usuario", 1, soporte);
		
		tareaAsist.cerrarTarea();
		
		assertEquals(Cerrado.getSingletonInstance(), tareaAsist.getEstado());

	}
	
	//Tests cambio de estado Bug
	@Test 
	public void dadaUnaTareaBugPonerlaEnProceso() throws Exception{
		
		bug.comenzarTarea();
		
		assertEquals(EnProceso.getSingletonInstance(), bug.getEstado());
	}
	
	@Test
	public void dadaUnaTareaBugBloquearlaYLuegoReanudarla() throws Exception {
		bug.comenzarTarea();
		bug.bloquearTarea();
		bug.reanudarTarea();
		
		assertEquals(EnProceso.getSingletonInstance(), bug.getEstado());
	}
	
	@Test
	public void dadaUnaTareaBugIniciarlaYCerrarla() throws Exception {
		bug.comenzarTarea();
		bug.cerrarTarea();
		
		assertEquals(Cerrado.getSingletonInstance(), bug.getEstado());
	}
	
	//Test cambio de estado Desarrollo
	@Test
	public void dadaUnaTareaDesarrolloComenzarlaYLuegoCancelarla() throws Exception{
		Miembro desarrollador = new Miembro("Desarrollador");
		Desarrollo tareaDesarrollo = new Desarrollo("Web API nuevo sistema", "Desarrollo", 100, desarrollador);
		
		tareaDesarrollo.comenzarTarea();
		tareaDesarrollo.cancelarTarea();
		
		assertEquals(Cancelado.getSingletonInstance(), tareaDesarrollo.getEstado());
	}
	
	@Test
	public void agregarHorasAUnaTareaEnProceso() throws Exception {
		bug.comenzarTarea();
		bug.agregarHorasEjecucion(8);
		
		assertEquals(8, bug.getCantHorasEjecucion());
	}
	
	@Test
	public void agregarHorasAUnaTareaQueNoEstaEnProceso() {
		try {
			bug.agregarHorasEjecucion(10);
		} catch (Exception e) {
			caughtException = e;
		}
		
		assertEquals(Exception.class, caughtException.getClass());
	}

	@Test
	public void intentarComenzarUnaTareaQueTieneUnaTareaPrevia() {
		Bug bugWeb = new Bug("Debug pagina web", "Bug", 8, tester);
		bugWeb.asignarTareaPrevia(bug);
		
		try {
			bugWeb.comenzarTarea();
		} catch (Exception e) {
			caughtException = e;
		}
		
		assertEquals(Exception.class, caughtException.getClass());
	}

}
