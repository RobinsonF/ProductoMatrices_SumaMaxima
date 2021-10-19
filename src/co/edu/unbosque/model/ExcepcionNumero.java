/**
 * Paquete modelo
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano and Juan
 *         Felipe Rojas Rodriguez
 *
 */
public class ExcepcionNumero extends Exception{
	
	/**
	 * Constructor clase ExcepcionNumero.
	 */
	public ExcepcionNumero() {

	}
	
	/**
	 * Constructor clase ExcepcionNumero.
	 * @param mensaje, mensaje capturado de excepción.
	 */
	public ExcepcionNumero(String mensaje) {
		super(mensaje);
	}
}
