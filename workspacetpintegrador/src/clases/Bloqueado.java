package clases;

public class Bloqueado implements Estado {
	
	private static Bloqueado estadoBloqueado;
	
	//Constructor privado, solo lo puede utilizar el metodo getSingletonInstance();
	private Bloqueado(){}
	
	/*Si no existe una instancia la crea, y sino devuelve la ya creada. 
	  Sirve para no tener multiples instancias de estado en el sistema cuando necesito asignar estados a las tareas.
	  Tambien facilita el assert en los tests para comparar por igualdad de instancia y no por igualdad de la clase del estado. 
	*/
	public static Bloqueado getSingletonInstance() {
		if(estadoBloqueado == null) {
			estadoBloqueado = new Bloqueado();
		}
		return estadoBloqueado;
	}

	@Override
	public void cambiarAEstadoEnProceso(Tarea tarea) {
		tarea.setEstado(EnProceso.getSingletonInstance());
	}
	
	@Override
	public void cambiarAEstadoCerrado(Tarea tarea) throws Exception {
		throw new Exception("No se puede cerrar una tarea bloqueada.");
	}

	@Override
	public void cambiarAEstadoBloqueado(Tarea tarea) throws Exception {
		throw new Exception("Esta tarea ya se encuentra bloqueada.");
	}

	@Override
	public void cambiarAEstadoCancelado(Tarea tarea) throws Exception {
		throw new Exception("No se puede cancelar una tarea bloqueada.");
	}

}
