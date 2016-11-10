package clases;

public class Desarrollo extends Tarea {

	public Desarrollo(String nombre, String tipo, int cantidadHoras, Miembro miembro) {
		super(nombre, tipo, cantidadHoras, miembro);
	}

	public void comenzarTarea() throws Exception {
		if(!tieneTareaPrevia()) {
			this.getEstado().cambiarAEstadoEnProceso(this);	
		}
		else {
			throw new Exception("No se puede comenzar la tarea, primero se debe finalizar su tarea previa.");
		}
	}
	
	public void bloquearTarea() throws Exception {
		this.getEstado().cambiarAEstadoBloqueado(this);
	}

	public void reanudarTarea() throws Exception {
		this.getEstado().cambiarAEstadoEnProceso(this);
	}

	public void cerrarTarea() throws Exception {
		this.getEstado().cambiarAEstadoCerrado(this);	
	}

	public void cancelarTarea() throws Exception {
		this.getEstado().cambiarAEstadoCancelado(this);
		
	}

}
