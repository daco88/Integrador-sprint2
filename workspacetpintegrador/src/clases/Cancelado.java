package clases;

public class Cancelado implements Estado {
	
	private static Cancelado estadoCancelado;
	
	//Constructor privado, solo lo puede utilizar el metodo getSingletonInstance();
	private Cancelado(){}
	
	/*Si no existe una instancia la crea, y sino devuelve la ya creada. 
	  Sirve para no tener multiples instancias de estado en el sistema cuando necesito asignar estados a las tareas.
	  Tambien facilita el assert en los tests para comparar por igualdad de instancia y no por igualdad de la clase del estado. 
	*/
	public static Cancelado getSingletonInstance() {
		if(estadoCancelado == null) {
			estadoCancelado = new Cancelado();
		}
		return estadoCancelado;
	}

	@Override
	public void cambiarAEstadoCerrado(Tarea tarea) throws Exception {
		throw new Exception("Esta tarea ya se encuentra cancelada.");
	}

	@Override
	public void cambiarAEstadoEnProceso(Tarea tarea) throws Exception {
		throw new Exception("No se puede poner en proceso una tarea cancelada.");
	}

	@Override
	public void cambiarAEstadoBloqueado(Tarea tarea) throws Exception {
		throw new Exception("No se puede bloquear una tarea cancelada.");
	}

	@Override
	public void cambiarAEstadoCancelado(Tarea tarea) throws Exception {
		throw new Exception("No se puede cancelar una tarea cancelada.");
	}

}
