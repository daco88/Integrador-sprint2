package clases;

public class Tarea {

	private Tarea tareaPrevia;
	private String nombre;
	private Estado estado;
	private Miembro miembro;
	private int cantidadDeHorasEstimadas;
	private int cantidadDeHorasEjecucion = 0;

	public Tarea(String nombre, String tipo, int cantidadHoras, Miembro miembro) {
		this.nombre = nombre;
		this.estado = Abierto.getSingletonInstance();
		this.miembro = miembro;
		this.cantidadDeHorasEstimadas = cantidadHoras;
		miembro.agregarTarea(this);
	}

	public Miembro getMiembro() {
		return miembro;
	}

	public Tarea getTareaPrevia() {
		return tareaPrevia;
	}
	
	public Boolean tieneTareaPrevia(){
		return (tareaPrevia != null);
	}

	public void asignarTareaPrevia(Tarea tareaPrevia) {
		this.tareaPrevia = tareaPrevia;	
	}

	public void agregarHorasEjecucion(int horas) throws Exception {
		if(estado == EnProceso.getSingletonInstance()) {
			cantidadDeHorasEjecucion += horas;
		}
		else {
			throw new Exception("Solo se pueden agregar horas de ejecucion a las tareas en proceso");
		}
	}

	public int getCantHorasEjecucion() {
		return cantidadDeHorasEjecucion;
	}
	
	public Estado getEstado(){
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
