package clases;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private List<Proyecto> proyectos = new ArrayList<>();

	public void agregarProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
	}

	public int getCantidadProyectos() {
		return proyectos.size();
	}

	public void eliminarProyecto(Proyecto proyecto) {
		proyectos.remove(proyecto);
		
	}

}
