package clases;

public class EnProceso implements Estado {
	
	private static EnProceso estadoEnProceso;
	
	//Constructor privado, solo lo puede utilizar el metodo getSingletonInstance();
	private EnProceso(){}
	
	/*Si no existe una instancia la crea, y sino devuelve la ya creada. 
	  Sirve para no tener multiples instancias de estado en el sistema cuando necesito asignar estados a las tareas.
	  Tambien facilita el assert en los tests para comparar por igualdad de instancia y no por igualdad de la clase del estado. 
	*/
	public static EnProceso getSingletonInstance() {
		if(estadoEnProceso == null) {
			estadoEnProceso = new EnProceso();
		}
		return estadoEnProceso;
	}
	
	@Override
	public void cambiarAEstadoCerrado(Tarea tarea) {
		Cerrado estadoCerrado = Cerrado.getSingletonInstance();
		tarea.setEstado(estadoCerrado);
	}

	@Override
	public void cambiarAEstadoEnProceso(Tarea tarea) throws Exception {
		throw new Exception("La tarea ya se encuentra en proceso");
	}

	@Override
	public void cambiarAEstadoBloqueado(Tarea tarea) {
		Bloqueado estadoBloqueado = Bloqueado.getSingletonInstance();
		tarea.setEstado(estadoBloqueado);
	}

	@Override
	public void cambiarAEstadoCancelado(Tarea tarea) {
		Cancelado estadoCancelado = Cancelado.getSingletonInstance();
		tarea.setEstado(estadoCancelado);
	}

}
