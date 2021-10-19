/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import co.edu.unbosque.controller.Controller;

/**
 * 
 * @author Jhoan Ricardo Cuevas Patinio, Robinson Jose Gutierrez Solano and Juan
 *         Felipe Rojas Rodriguez
 *
 */
public class Vista extends JFrame{
	
	/**
	 * Variable COMMANDO_CONFIRMAR tipo String
	 */
	private final String COMANDO_CONFIRMAR = "CONFIRMAR2";
	
	private final String COMANDO_SUMA = "SUMA";
	
	private final String COMANDO_PRODUCTO = "PRODUCTO";

	
	/**
	 * Variable panelSeleccion tipo PanelSeleccion1
	 */
	private PanelSeleccion1 panelSeleccion;
	
	/**
	 * Variable panelSeleccion2 tipo PanelSeleccion2
	 */
	private PanelSeleccion2 panelSeleccion2;
	
	/**
	 * Variable panelMatriz1 tipo PanelMatriz1
	 */
	private PanelMatriz1 panelMatriz1;
	
	/**
	 * Variable panelMatriz2 tipo PanelMatriz2
	 */
	private PanelMatriz2 panelMatriz2;
	
	/**
	 * Variable panelMatriz3 tipo PanelMatriz3
	 */
	private PanelMatriz3 panelMatriz3;
	
	/**
	 * Variable splitPane tipo JSplitPane
	 */
	private JSplitPane splitPane;
	
	/**
	 * Variable splitPane2 tipo JSplitPane
	 */
	private JSplitPane splitPane2;
	
	/**
	 * Variable splitPane3 tipo JSplitPane
	 */
	private JSplitPane splitPane3;
		
	/**
	 * Variable btnConfirmar tipo JButton
	 */
	private JButton btnConfirmar;
	
	private JMenuBar menu;
	
	private JMenu opcion;
	
	private JMenuItem productoMatrices;
	
	private JMenuItem sumaMaxima;
	
	private JPanel panel;
	

	/**
	 * Constructor clase Vista	
	 * @param controller
	 */
	public Vista(Controller controller) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1350, 400);
		this.setTitle("Producto Matrices");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		panel = new JPanel();
		panel.setBounds(0, 0, 1330, 338);
		panel.setLayout(new GridLayout(1,3));
		menu = new JMenuBar();
		opcion = new JMenu("Seleccione");
		productoMatrices = new JMenuItem("Produto matrices");
		sumaMaxima = new JMenuItem("Suma máxima");
		opcion.add(productoMatrices);
		opcion.add(sumaMaxima);
		menu.add(opcion);
		panelSeleccion = new PanelSeleccion1();
		panelSeleccion2 = new PanelSeleccion2();
		panelMatriz1 = new PanelMatriz1();
		panelMatriz2 = new PanelMatriz2();
		panelMatriz3 = new PanelMatriz3();
		btnConfirmar = new JButton("Hallar Producto");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		productoMatrices.setActionCommand(COMANDO_PRODUCTO);
		sumaMaxima.setActionCommand(COMANDO_SUMA);

		splitPane = new JSplitPane();
		splitPane2 = new JSplitPane();
		splitPane3 = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane2.setEnabled(false);
		splitPane3.setEnabled(false);
		splitPane.setRightComponent(panelMatriz1);
		splitPane.setLeftComponent(panelSeleccion);
		splitPane2.setRightComponent(panelMatriz2);
		splitPane2.setLeftComponent(panelSeleccion2);
		splitPane3.setLeftComponent(btnConfirmar);
		splitPane3.setRightComponent(panelMatriz3);

		panel.add(splitPane);
		panel.add(splitPane2);
		panel.add(splitPane3);
		panel.setVisible(false);

		getContentPane().add(menu);
		setJMenuBar(menu);
		getContentPane().add(panel);
		asignarOyentes(controller);
		repaint();
		revalidate();
	}
	
	/**
	 * Este método se encarga de asignar los oyenter a los botones
	 * @param controller
	 */
	public void asignarOyentes(Controller controller) {
		panelSeleccion.getBtnConfirmar().addActionListener(controller);
		panelSeleccion2.getBtnConfirmar().addActionListener(controller);
		this.btnConfirmar.addActionListener(controller);
		this.productoMatrices.addActionListener(controller);
		this.sumaMaxima.addActionListener(controller);
	}
	
	/**
	 * Este método se encarga de mostrar mensajes cuya finalidad sea una advertencia al usuario.
	 * @param mensaje, mensaje a mostrar.
	 */
	public void mostrarMensajeAdvertencia(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Este método se encarga de mostrar un mensaje de información al usuario.
	 * @param mensaje, mensaje a mostrar.
	 */
	public void mostrarMensajeInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	public String leer(String mensaje) {
		return JOptionPane.showInputDialog(null,mensaje);
	}
	/**
	 * @return the panelSeleccion
	 */
	public PanelSeleccion1 getPanelSeleccion() {
		return panelSeleccion;
	}

	/**
	 * @param panelSeleccion the panelSeleccion to set
	 */
	public void setPanelSeleccion(PanelSeleccion1 panelSeleccion) {
		this.panelSeleccion = panelSeleccion;
	}

	/**
	 * @return the panelSeleccion2
	 */
	public PanelSeleccion2 getPanelSeleccion2() {
		return panelSeleccion2;
	}

	/**
	 * @param panelSeleccion2 the panelSeleccion2 to set
	 */
	public void setPanelSeleccion2(PanelSeleccion2 panelSeleccion2) {
		this.panelSeleccion2 = panelSeleccion2;
	}

	/**
	 * @return the splitPane
	 */
	public JSplitPane getSplitPane() {
		return splitPane;
	}

	/**
	 * @param splitPane the splitPane to set
	 */
	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	/**
	 * @return the splitPane2
	 */
	public JSplitPane getSplitPane2() {
		return splitPane2;
	}

	/**
	 * @param splitPane2 the splitPane2 to set
	 */
	public void setSplitPane2(JSplitPane splitPane2) {
		this.splitPane2 = splitPane2;
	}

	/**
	 * @return the cOMMANDO_CONFIRMAR
	 */
	public String getCOMMANDO_CONFIRMAR() {
		return COMANDO_CONFIRMAR;
	}

	/**
	 * @return the splitPane3
	 */
	public JSplitPane getSplitPane3() {
		return splitPane3;
	}

	/**
	 * @param splitPane3 the splitPane3 to set
	 */
	public void setSplitPane3(JSplitPane splitPane3) {
		this.splitPane3 = splitPane3;
	}

	/**
	 * @return the panelMatriz1
	 */
	public PanelMatriz1 getPanelMatriz1() {
		return panelMatriz1;
	}

	/**
	 * @param panelMatriz1 the panelMatriz1 to set
	 */
	public void setPanelMatriz1(PanelMatriz1 panelMatriz1) {
		this.panelMatriz1 = panelMatriz1;
	}

	/**
	 * @return the panelMatriz2
	 */
	public PanelMatriz2 getPanelMatriz2() {
		return panelMatriz2;
	}

	/**
	 * @param panelMatriz2 the panelMatriz2 to set
	 */
	public void setPanelMatriz2(PanelMatriz2 panelMatriz2) {
		this.panelMatriz2 = panelMatriz2;
	}

	/**
	 * @return the panelMatriz3
	 */
	public PanelMatriz3 getPanelMatriz3() {
		return panelMatriz3;
	}

	/**
	 * @param panelMatriz3 the panelMatriz3 to set
	 */
	public void setPanelMatriz3(PanelMatriz3 panelMatriz3) {
		this.panelMatriz3 = panelMatriz3;
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
	 * @return the menu
	 */
	public JMenuBar getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}

	/**
	 * @return the opcion
	 */
	public JMenu getOpcion() {
		return opcion;
	}

	/**
	 * @param opcion the opcion to set
	 */
	public void setOpcion(JMenu opcion) {
		this.opcion = opcion;
	}

	/**
	 * @return the productoMatrices
	 */
	public JMenuItem getProductoMatrices() {
		return productoMatrices;
	}

	/**
	 * @param productoMatrices the productoMatrices to set
	 */
	public void setProductoMatrices(JMenuItem productoMatrices) {
		this.productoMatrices = productoMatrices;
	}

	/**
	 * @return the sumaMaxima
	 */
	public JMenuItem getSumaMaxima() {
		return sumaMaxima;
	}

	/**
	 * @param sumaMaxima the sumaMaxima to set
	 */
	public void setSumaMaxima(JMenuItem sumaMaxima) {
		this.sumaMaxima = sumaMaxima;
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
	 * @return the cOMANDO_CONFIRMAR
	 */
	public String getCOMANDO_CONFIRMAR() {
		return COMANDO_CONFIRMAR;
	}

	/**
	 * @return the cOMANDO_SUMA
	 */
	public String getCOMANDO_SUMA() {
		return COMANDO_SUMA;
	}

	/**
	 * @return the cOMANDO_PRODUCTO
	 */
	public String getCOMANDO_PRODUCTO() {
		return COMANDO_PRODUCTO;
	}
	
	
}
