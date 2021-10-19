/**
 * Paquete controller
 */
package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

/**
 * 
 * @author Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano and Juan
 *         Felipe Rojas Rodriguez
 *
 */
public class Controller implements ActionListener {

	/**
	 * Variable metodo tipo Metodo
	 */
	private Metodo metodo;

	/**
	 * Variable vista tipo Vista
	 */
	private Vista vista;

	/**
	 * Variable fila1 tipo String
	 */
	String fila1 = "0";

	/**
	 * Variable columna1 tipo String
	 */
	String columna1 = "0";

	/**
	 * Variable fila2 tipo String
	 */
	String fila2 = "0";

	/**
	 * Variable columna2 tipo String
	 */
	String columna2 = "0";

	/**
	 * Constructor clase Controller
	 */

	public Controller() {
		metodo = new Metodo();
		vista = new Vista(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if (comando.equals(vista.getPanelSeleccion().getCOMMANDO_CONFIRMAR())) {
			try {
				String[] entradas = vista.getPanelSeleccion().verificarEntradas();
				if (entradas[0].equals("0")) {
					fila1 = entradas[1];
					metodo.verificarNumero(fila1);
					columna1 = entradas[2];
					metodo.verificarNumero(columna1);
					vista.getPanelMatriz1().limpiarPanel();
					vista.getPanelMatriz1().inicializarCompentes(Integer.parseInt(fila1), Integer.parseInt(columna1));
					vista.getSplitPane().setRightComponent(vista.getPanelMatriz1());
				} else {
					vista.mostrarMensajeAdvertencia(entradas[1]);
				}
			} catch (ExcepcionNumero excepcion) {
				vista.mostrarMensajeAdvertencia(excepcion.getMessage());
			} catch (Exception excepcion2) {
				vista.mostrarMensajeError("Lo siento se ha presentado un error");
			}

		}

		if (comando.equals(vista.getPanelSeleccion2().getCOMMANDO_CONFIRMAR())) {
			try {
				String[] entradas = vista.getPanelSeleccion2().verificarEntradas();
				if (entradas[0].equals("0")) {
					fila2 = entradas[1];
					metodo.verificarNumero(fila2);
					columna2 = entradas[2];
					metodo.verificarNumero(columna2);
					vista.getPanelMatriz2().limpiarPanel();
					vista.getPanelMatriz2().inicializarCompentes(Integer.parseInt(fila2), Integer.parseInt(columna2));
					vista.getSplitPane2().setRightComponent(vista.getPanelMatriz2());
				} else {
					vista.mostrarMensajeAdvertencia(entradas[1]);
				}
			} catch (ExcepcionNumero excepcion) {
				vista.mostrarMensajeAdvertencia(excepcion.getMessage());
			} catch (Exception excepcion2) {
				vista.mostrarMensajeError("Lo siento se ha presentado un error");
			}
		}

		if (comando.equals(vista.getCOMMANDO_CONFIRMAR())) {
			try {
				if (Integer.parseInt(fila1) != 0 && Integer.parseInt(fila2) != 0) {
					JTextField[][] datosMatriz1 = vista.getPanelMatriz1().getTxtMatriz();
					JTextField[][] datosMatriz2 = vista.getPanelMatriz2().getTxtMatriz();
					if (!vista.getPanelMatriz1().verificarEntradas(datosMatriz1)
							&& !vista.getPanelMatriz2().verificarEntradas(datosMatriz2)) {
						if (Integer.parseInt(columna1) == Integer.parseInt(fila2)) {
							int[][] matriz1 = new int[Integer.parseInt(fila1)][Integer.parseInt(columna1)];
							int[][] matriz2 = new int[Integer.parseInt(fila2)][Integer.parseInt(columna2)];

							for (int i = 0; i < Integer.parseInt(fila1); i++) {
								for (int j = 0; j < Integer.parseInt(columna1); j++) {
									String numero = (datosMatriz1[i][j].getText());
									metodo.verificarNumero(numero);
									matriz1[i][j] = Integer.parseInt(numero);
								}
							}
							for (int i = 0; i < Integer.parseInt(fila2); i++) {
								for (int j = 0; j < Integer.parseInt(columna2); j++) {
									String numero = (datosMatriz2[i][j].getText());
									metodo.verificarNumero(numero);
									matriz2[i][j] = Integer.parseInt(numero);
								}
							}
							int[][] resultado = metodo.productoMatriz(matriz1, matriz2);
							vista.getPanelMatriz3().limpiarPanel();
							vista.getPanelMatriz3().inicializarCompentes(Integer.parseInt(fila1),
									Integer.parseInt(columna2));
							JLabel[][] resultadoMatriz = vista.getPanelMatriz3().getTxtMatriz();
							Font font = new Font("SansSerif", Font.BOLD, 30);
							for (int i = 0; i < Integer.parseInt(fila1); i++) {
								for (int j = 0; j < Integer.parseInt(columna2); j++) {
									resultadoMatriz[i][j].setText(resultado[i][j] + "");
									resultadoMatriz[i][j].setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
									resultadoMatriz[i][j].setFont(font);
									resultadoMatriz[i][j].setHorizontalAlignment(SwingConstants.CENTER);
									resultadoMatriz[i][j].setVerticalAlignment(SwingConstants.CENTER);

								}
							}
							vista.getSplitPane3().setRightComponent(vista.getPanelMatriz3());
							vista.getPanelMatriz3().setTxtMatriz(resultadoMatriz);
						} else {
							vista.mostrarMensajeAdvertencia(
									"Las matrices que acaba de ingresar no se pueden multiplicar, revise las dimensiones");
						}
					} else {
						vista.mostrarMensajeAdvertencia("Complete todos los campos");
					}
				} else {
					vista.mostrarMensajeAdvertencia("Ingrese las matrices a multiplicar");
				}
			} catch (ExcepcionNumero excepcion) {
				vista.mostrarMensajeAdvertencia(excepcion.getMessage());
			} catch (Exception excepcion2) {
				vista.mostrarMensajeError("Lo siento se ha presentado un error");
			}

		}

		if (comando.equals(vista.getCOMANDO_PRODUCTO())) {
			vista.getPanel().setVisible(true);
		}
		if (comando.equals(vista.getCOMANDO_SUMA())) {
			for (int i = 0; i < Integer.parseInt(fila1); i++) {
				for (int j = 0; j < Integer.parseInt(columna1); j++) {
					vista.getPanelMatriz1().getTxtMatriz()[i][j].setText("");
				}
			}
			for (int i = 0; i < Integer.parseInt(fila2); i++) {
				for (int j = 0; j < Integer.parseInt(columna2); j++) {
					vista.getPanelMatriz2().getTxtMatriz()[i][j].setText("");
				}
			}
			
			for (int i = 0; i < Integer.parseInt(fila2); i++) {
				for (int j = 0; j < Integer.parseInt(columna2); j++) {
					vista.getPanelMatriz3().getTxtMatriz()[i][j].setText("");
				}
			}
			vista.getPanel().setVisible(false);
			String elemento = "";
			String numeroDato = "";
			try {
				int k = 0;
				do {
					numeroDato = vista.leer("¿Cuántos datos desea ingresar?");
					metodo.verificarNumero(numeroDato);
					if (Integer.parseInt(numeroDato) > 0) {
						k = 1;
					} else {
						vista.mostrarMensajeAdvertencia("Solo se permiten números positivos");
						k = 0;
					}
				} while (k == 0);
				int[] arreglo = new int[Integer.parseInt(numeroDato)];
				for (int i = 0; i < arreglo.length; i++) {
					elemento = vista.leer("Ingrese el elemento número: " + (i + 1));
					metodo.verificarNumero(elemento);
					arreglo[i] = Integer.parseInt(elemento);
				}
				vista.mostrarMensajeInformacion("La suma máxima es: " + metodo.calcularSumaMaxima(arreglo));

			} catch (ExcepcionNumero exception) {
				vista.mostrarMensajeInformacion(exception.getMessage());
			} catch (Exception excepcion2) {
				vista.mostrarMensajeError("Lo siento se ha presentado un error");
			}
		}
	}

	/**
	 * @return the metodo
	 */
	public Metodo getMetodo() {
		return metodo;
	}

	/**
	 * @param metodo the metodo to set
	 */
	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}

	/**
	 * @return the vista
	 */
	public Vista getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(Vista vista) {
		this.vista = vista;
	}

	/**
	 * @return the fila1
	 */
	public String getFila1() {
		return fila1;
	}

	/**
	 * @param fila1 the fila1 to set
	 */
	public void setFila1(String fila1) {
		this.fila1 = fila1;
	}

	/**
	 * @return the columna1
	 */
	public String getColumna1() {
		return columna1;
	}

	/**
	 * @param columna1 the columna1 to set
	 */
	public void setColumna1(String columna1) {
		this.columna1 = columna1;
	}

	/**
	 * @return the fila2
	 */
	public String getFila2() {
		return fila2;
	}

	/**
	 * @param fila2 the fila2 to set
	 */
	public void setFila2(String fila2) {
		this.fila2 = fila2;
	}

	/**
	 * @return the columna2
	 */
	public String getColumna2() {
		return columna2;
	}

	/**
	 * @param columna2 the columna2 to set
	 */
	public void setColumna2(String columna2) {
		this.columna2 = columna2;
	}

}
