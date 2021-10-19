/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 * @author Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano and Juan
 *         Felipe Rojas Rodriguez
 *
 */
public class PanelSeleccion1 extends JPanel {

	/**
	 * Variable COMMANDO_CONFIRMAR tipo String
	 */
	private final String COMANDO_CONFIRMAR = "CONFIRMAR";

	/**
	 * Variable labelMatriz1 tipo Label
	 */
	private JLabel labelMatriz1;

	/**
	 * Variable txtFilas tipo JTextField
	 */
	private JTextField txtFilas;

	/**
	 * Variable txtColumnas tipo JTextField
	 */
	private JTextField txtColumnas;

	/**
	 * Variable btnConfirmar tipo JButton
	 */
	private JButton btnConfirmar;

	/**
	 * Variabel JPanel tipo JPanel
	 */
	private JPanel panel;

	/**
	 * Contructor clase PanelSeleccion1
	 */
	public PanelSeleccion1() {
		setLayout(new GridLayout(3, 1));
		labelMatriz1 = new JLabel("Dimensiones Matriz 1");
		txtFilas = new JTextField();
		txtColumnas = new JTextField();
		btnConfirmar = new JButton("Confirmar");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		txtFilas.setFont(font);
		txtColumnas.setFont(font);
		txtFilas.setHorizontalAlignment(SwingConstants.CENTER);
		txtColumnas.setHorizontalAlignment(SwingConstants.CENTER);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(txtFilas);
		panel.add(txtColumnas);
		this.add(labelMatriz1);
		this.add(panel);
		this.add(btnConfirmar);

		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);

	}

	/**
	 * Este método se encarga de verificar las entradas de las dimensiones de la
	 * matriz. @return, retorna las entradas validad o con su respectivo mensaje de
	 * advertencia.
	 */
	public String[] verificarEntradas() {
		String[] salidas = new String[3];
		salidas[0] = "0";
		if (!"".equals(txtFilas.getText()) && !"".equals(txtColumnas.getText()) && !txtFilas.getText().equals("0")
				&& !txtColumnas.getText().equals("0")) {
			salidas[1] = txtFilas.getText();
			salidas[2] = txtColumnas.getText();
		} else {
			salidas[0] = "1";
			salidas[1] = "Por favor ingrese las dimensiones de la matriz 1, verifique que no sean ceros";
		}
		return salidas;
	}

	/**
	 * @return the labelMatriz1
	 */
	public JLabel getLabelMatriz1() {
		return labelMatriz1;
	}

	/**
	 * @param labelMatriz1 the labelMatriz1 to set
	 */
	public void setLabelMatriz1(JLabel labelMatriz1) {
		this.labelMatriz1 = labelMatriz1;
	}

	/**
	 * @return the txtFilas
	 */
	public JTextField getTxtFilas() {
		return txtFilas;
	}

	/**
	 * @param txtFilas the txtFilas to set
	 */
	public void setTxtFilas(JTextField txtFilas) {
		this.txtFilas = txtFilas;
	}

	/**
	 * @return the txtColumnas
	 */
	public JTextField getTxtColumnas() {
		return txtColumnas;
	}

	/**
	 * @param txtColumnas the txtColumnas to set
	 */
	public void setTxtColumnas(JTextField txtColumnas) {
		this.txtColumnas = txtColumnas;
	}

	/**
	 * @return the btnConfirmar
	 */
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	/**
	 * @param btnConfirmar the btnConfirmar to set
	 */
	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the cOMMANDO_CONFIRMAR
	 */
	public String getCOMMANDO_CONFIRMAR() {
		return COMANDO_CONFIRMAR;
	}

}
