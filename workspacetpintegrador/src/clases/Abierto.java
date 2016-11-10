package clases;

public class Abierto implements Estado {
	
	private static Abierto estadoAbierto;
	
	//Constructor privado, solo lo puede utilizar el metodo getSingletonInstance();
	private Abierto(){}
	
	/*Si no existe una instancia la crea, y sino devuelve la ya creada. 
	  Sirve para no tener multiples instancias de estado en el sistema cuando necesito asignar estados a las tareas.
	  Tambien facilita el assert en los tests para comparar por igualdad de instancia y no por igualdad de la clase del estado. 
	*/
	public static Abierto getSingletonInstance() {
		if(estadoAbierto == null) {
			estadoAbierto = new Abierto();
		}
		return estadoAbierto;
	}

	@Override
	public void cambiarAEstadoCerrado(Tarea tarea) {
		tarea.setEstado(Cerrado.getSingletonInstance());
	}

	@Override
	public void cambiarAEstadoEnProceso(Tarea tarea) {
		tarea.setEstado(EnProceso.getSingletonInstance());
	}

	@Override
	public void cambiarAEstadoBloqueado(Tarea tarea) throws Exception {
		throw new Exception("No se puede bloquear una tarea abierta");
	}

	@Override
	public void cambiarAEstadoCancelado(Tarea tarea) throws Exception {
		throw new Exception("No se puede cancelar una tarea abierta");
	}

}
