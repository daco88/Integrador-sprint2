package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private String nombre;
	private List<Tarea> listaTareas = new ArrayList<>();
	private List<String> cantidadRoles = new ArrayList<>();
	private List<Miembro> empleados = new ArrayList<>();
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String cliente;

	public Proyecto(String nombre, String fechaInicio, String fechaFin, String cliente) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaInicio_date = LocalDate.parse(fechaInicio, formatter);
		LocalDate fechaFin_date = LocalDate.parse(fechaInicio, formatter);
		
		this.nombre = nombre;
		this.fechaInicio = fechaInicio_date;
		this.fechaFin = fechaFin_date;
		this.cliente = cliente;
	}
	
	public void registrarEmpleado(Miembro empleado) {
		empleados.add(empleado);
	}

	public void asignarTarea(Tarea tarea) {
		listaTareas.add(tarea);	
	}

	public Tarea getTareaAt(int indice){
		return listaTareas.get(indice);
	}
	public int getCantidadRoles() {
		return cantidadRoles.size();
	}
	public int getCantidadTareas() {
		return listaTareas.size();
	}
	public int getCantidadEmpleados() {
		return empleados.size();
	}

	public void asignarRolAProyecto(String rol) {
		cantidadRoles.add(rol);	
	}

}
