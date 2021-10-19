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
public class Metodo {

	/**
	 * Contructor clase Metodo
	 */
	public Metodo() {

	}

	/**
	 * Este método se encarga de multiplicar dos matrices.
	 * 
	 * @param matriz1, primer matriz a multiplicar.
	 * @param matriz2, segunda matriz a multiplicar. @return, retorna la matriz
	 *                 resultante del producto.
	 */
	public int[][] productoMatriz(int[][] matriz1, int[][] matriz2) {
		int filas = matriz1.length;
		int columnas = matriz2[0].length;
		int[][] resultado = new int[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				for (int k = 0; k < columnas; k++) {
					int producto = matriz1[i][k] * matriz2[k][j];
					resultado[i][j] += producto;
				}
			}
		}
		return resultado;
	}

	/**
	 * 
	 * @param inicio
	 * @param inicio2
	 * @param matriz1
	 * @param matriz2
	 * @param resultado
	 * @return
	 */

	public static int[][] productoMatrizRecursivamente(int inicio, int inicio2, int[][] matriz1, int[][] matriz2,
			int[][] resultado) {

		int r = 0;

		if (inicio < matriz1.length && inicio2 < matriz2[0].length) {

			for (int i = 0; i < resultado.length; i++) {
				r += matriz1[inicio][i] * matriz2[i][inicio2];
			}

			resultado = productoMatrizRecursivamente(inicio + 1, inicio2, matriz1, matriz2, resultado);
			resultado = productoMatrizRecursivamente(inicio, inicio2 + 1, matriz1, matriz2, resultado);

			resultado[inicio][inicio2] = r;
		}

		return resultado;
	}

	public int calcularSumaMaxima(int[] arreglo) {
		int max_anterior = 0;
		int max_aux = 0;
		for (int i = 0; i < arreglo.length; i++) {
			max_aux = Math.max(max_aux + arreglo[i], 0);
			max_anterior = Math.max(max_anterior, max_aux);
		}
		return max_anterior;
	}

	/**
	 * Este método se encarga de verificar si hay números dentro de una cadena de
	 * texto o no.
	 * 
	 * @param numero, cadena de texto la cual será verificada.
	 * @return retorna si hay numeros o no.
	 */

	public boolean soloNumeros(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Este método se encarga de saber si hay caracteres no permitidos en una cadena
	 * de texto, para luego capturarlo en una excepción.
	 * 
	 * @param numero, numero a verificar.
	 * @throws ExcepcionNumero
	 */
	public void verificarNumero(String numero) throws ExcepcionNumero {
		if (!soloNumeros(numero)) {
			throw new ExcepcionNumero("Solo se permiten ingresar números, verifique los campos");
		}
	}

}
