/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * 
 * @author Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano and Juan
 *         Felipe Rojas Rodriguez
 *
 */
public class PanelMatriz1 extends JPanel {
	
	/**
	 * Variable txtMatriz tipo JTextField.
	 */
	private JTextField[][] txtMatriz;

	/**
	 * Constructor clase PanelMatri1
	 */
	public PanelMatriz1() {

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
		txtMatriz = new JTextField[filas][columnas];
		Font font = new Font("SansSerif", Font.BOLD, 30);

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				txtMatriz[i][j] = new JTextField();
				txtMatriz[i][j].setFont(font);
				txtMatriz[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				this.add(txtMatriz[i][j]);
			}
		}
	}
	
	/**
	 * Este método se encarga de verificar las entradas de la matriz.
	 * @param entradas, entradas a verificar.
	 * @return
	 */
	public boolean verificarEntradas(JTextField[][] entradas) {
		boolean verificar = false;
		for (int i = 0; i < entradas.length; i++) {
			for (int j = 0; j < entradas[0].length; j++) {
				if("".equals(entradas[i][j].getText())) {
					verificar = true;
					break;
				}
			}
		}
		return verificar;
	}

	/**
	 * @return the txtMatriz
	 */
	public JTextField[][] getTxtMatriz() {
		return txtMatriz;
	}

	/**
	 * @param txtMatriz the txtMatriz to set
	 */
	public void setTxtMatriz(JTextField[][] txtMatriz) {
		this.txtMatriz = txtMatriz;
	}

}
