package clases;

import java.util.ArrayList;
import java.util.List;

public class Miembro {
	
	private List<Tarea> tareas = new ArrayList<>();
	private String rol;
	
	public Miembro(String rol) {
		this.rol = rol;
	}
	
	public String getRol() {
		return(rol);
	}
	public List getTareas() {
		return(tareas);
	}
	public int getCantTareas() {
		return(tareas.size());
	}
	public void agregarTarea(Tarea tarea) {
		tareas.add(tarea);
	}
}
