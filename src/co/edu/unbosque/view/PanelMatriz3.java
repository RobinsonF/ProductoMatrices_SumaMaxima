/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * 
 * @author Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano and Juan
 *         Felipe Rojas Rodriguez
 *
 */
public class PanelMatriz3 extends JPanel{
	
	/**
	 * Variable txtMatriz tipo JLabel.
	 */
	private JLabel[][] labelMatriz;
	
	/**
	 * Constructor clase PanelMatriz3
	 */
	public PanelMatriz3() {
		
	}
	
	/**
	 * Este método se encarga de limpiar todo el panel.
	 */
	public void limpiarPanel() {
		this.removeAll();
		this.repaint();
	}
	
	/**
	 * Este método se encarga de inicializar los componentes del panel.
	 * @param filas, numero de filas del panel.
	 * @param columnas, numero de columnas del panel.
	 */
	public void inicializarCompentes(int filas, int columnas) {
		setLayout(new GridLayout(filas, columnas));
		labelMatriz = new JLabel[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				labelMatriz[i][j] = new JLabel();
				this.add(labelMatriz[i][j]);
			}
		}
	}

	/**
	 * @return the txtMatriz
	 */
	public JLabel[][] getTxtMatriz() {
		return labelMatriz;
	}

	/**
	 * @param txtMatriz the txtMatriz to set
	 */
	public void setTxtMatriz(JLabel[][] txtMatriz) {
		this.labelMatriz = txtMatriz;
	}

}
