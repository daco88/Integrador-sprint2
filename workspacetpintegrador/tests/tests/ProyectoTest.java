package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clases.Miembro;
import clases.Proyecto;
import clases.Sistema;
import clases.Tarea;

public class ProyectoTest {
	Proyecto miProyecto;
	Sistema sistema;

	@Before
	public void setUp() throws Exception {
		miProyecto = new Proyecto("Migracion web", "10/03/2016", "12/25/2016", "Molinos");
		sistema = new Sistema();
	}
	
	@Test
	public void agregarUnProyectoAlSistema() {
		sistema.agregarProyecto(miProyecto);
		
		assertEquals(1, sistema.getCantidadProyectos());
	}
	
	@Test
	public void eliminarUnProyectoAlSistema() {
		sistema.eliminarProyecto(miProyecto);
		
		assertEquals(0, sistema.getCantidadProyectos());
	}

	@Test
	public void asignarRolAlProyecto(){

		miProyecto.asignarRolAProyecto("Desarrollador");
		
		assertEquals(1, miProyecto.getCantidadRoles());
	}
	
	@Test
	public void asignarTareaAlProyecto(){
		
		Miembro miembro = new Miembro("Desarrollador");
		Tarea tarea = new Tarea("Configurar entorno", "Desarrollo", 4, miembro);
		miProyecto.asignarTarea(tarea);
		
		assertEquals(1, miProyecto.getCantidadTareas());
	}
	
	@Test 
	public void registrarEmpleadoAlProyecto() {
		Miembro empleado = new Miembro("Tester");
		
		miProyecto.registrarEmpleado(empleado);
		assertEquals(1, miProyecto.getCantidadEmpleados());
		
	}
	
	@Test
	public void asignarRolesAProyectoYVerificarCantidad(){
		miProyecto.asignarRolAProyecto("Tester");
		miProyecto.asignarRolAProyecto("Desarrollador");
		miProyecto.asignarRolAProyecto("Lider Proyecto");
		miProyecto.asignarRolAProyecto("Gerente Comercial");
		
		assertEquals(4, miProyecto.getCantidadRoles());
	}
	
}
