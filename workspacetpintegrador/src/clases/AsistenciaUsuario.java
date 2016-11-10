package clases;

public class AsistenciaUsuario extends Tarea {

	public AsistenciaUsuario(String nombre, String tipo, int cantidadHoras, Miembro miembro) {
		super(nombre, tipo, cantidadHoras, miembro);
	}

	public void cerrarTarea() throws Exception {
		this.getEstado().cambiarAEstadoCerrado(this);
	}

}
