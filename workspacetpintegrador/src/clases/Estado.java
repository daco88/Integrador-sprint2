package clases;

public interface Estado {
	
	void cambiarAEstadoCerrado(Tarea tarea) throws Exception;

	void cambiarAEstadoEnProceso(Tarea tarea) throws Exception;

	void cambiarAEstadoBloqueado(Tarea tarea) throws Exception;

	void cambiarAEstadoCancelado(Tarea tarea) throws Exception;

}
