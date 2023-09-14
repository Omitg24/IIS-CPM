package igu;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

import logica.Pedido;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

/**
 * Titulo: Clase VentanaConfirmación
 * 
 * @author UO281847
 * @version 09/10/2021
 */
public class VentanaConfirmacion extends JDialog {
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo lblTick
	 */
	private JLabel lblTick;
	/**
	 * Atributo lblFinalizar
	 */
	private JLabel lblFinalizar;
	/**
	 * Atributo lblRecogida
	 */
	private JLabel lblRecogida;
	/**
	 * Atributo tfCodigo
	 */
	private JTextField tfCodigo;
	/**
	 * Atributo btnNewButton
	 */
	private JButton btnNewButton;
	/**
	 * Atributo lblPrecio
	 */
	private JLabel lblPrecio;
	/**
	 * Atributo lblPrecioValor
	 */
	private JLabel lblPrecioValor;
	/**
	 * Atributo vR
	 */
	private VentanaRegistro vR;
	
	/**
	 * Constructor de la ventana confrimación
	 */
	public VentanaConfirmacion(VentanaRegistro vReg) {
		vR=vReg;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.png")));
		setTitle("McDonald's: Confirmaci\u00F3n de Pedido");
		setBounds(100, 100, 600, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(getLblTick());
		getContentPane().add(getLblFinalizar());
		getContentPane().add(getLblRecogida());
		getContentPane().add(getTfCodigo());
		getContentPane().add(getBtFinalizar());
		getContentPane().add(getLblPrecio());
		getContentPane().add(getLblPrecioValor());

	}
	
	/**
	 * Método que crea la etiqueta de Tick
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblTick() {
		if (lblTick == null) {
			lblTick = new JLabel("");
			lblTick.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblTick.setBounds(10, 75, 50, 56);
		}
		return lblTick;
	}
	
	/**
	 * Método que crea la etiqueta Finalizar
	 * 
	 * @return etiqueta 
	 */
	private JLabel getLblFinalizar() {
		if (lblFinalizar == null) {
			lblFinalizar = new JLabel("Pulse Finalizar para confirmar su pedido");
			lblFinalizar.setFont(new Font("Arial Black", Font.PLAIN, 22));
			lblFinalizar.setBounds(70, 92, 504, 25);
		}
		return lblFinalizar;
	}
	
	/**
	 * Método que crea la etiqueta recogida
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblRecogida() {
		if (lblRecogida == null) {
			lblRecogida = new JLabel("El c\u00F3digo de recogida es:");
			lblRecogida.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblRecogida.setBounds(132, 128, 198, 25);
		}
		return lblRecogida;
	}
	
	/**
	 * Método que crea el textField codigo
	 * 
	 * @return textField
	 */
	private JTextField getTfCodigo() {
		if (tfCodigo == null) {
			Pedido pedido = new Pedido();
			tfCodigo = new JTextField();
			tfCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			tfCodigo.setText(pedido.getCodigo());
			tfCodigo.setEditable(false);
			tfCodigo.setBounds(348, 128, 101, 31);
			tfCodigo.setColumns(10);
		}
		return tfCodigo;
	}
	
	/**
	 * Método que crea el boton finalizar
	 * 
	 * @return boton
	 */
	private JButton getBtFinalizar() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Finalizar");
			btnNewButton.setToolTipText("Pulse para confirmar el pedido");
			btnNewButton.setMnemonic('F');
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();
					
					dispose();
				}

				
			});
			btnNewButton.setBackground(new Color(0, 128, 0));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBounds(473, 219, 101, 31);
		}
		return btnNewButton;
	}
	
	private void finalizar() {
		JOptionPane.showMessageDialog(null, "Espere a recoger su pedido");
		vR.getVp().grabarPedido();
		vR.getVp().inicializar();
		vR.dispose();
		dispose();
	}
	
	/**
	 * Método que devuelve la etiqueta del precio
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel("El precio del pedido es:");
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPrecio.setBounds(132, 175, 198, 25);
		}
		return lblPrecio;
	}
	/**
	 * Método que devuelve al etiqeuta del valor del pedido
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblPrecioValor() {
		if (lblPrecioValor == null) {
			lblPrecioValor = new JLabel("New label");
			lblPrecioValor.setForeground(new Color(0, 128, 0));
			lblPrecioValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
			String precio = String.format("%.2f",vR.getVp().getPrecio());
			lblPrecioValor.setText(precio +" €");
			lblPrecioValor.setBounds(324, 170, 61, 36);
		}
		return lblPrecioValor;
	}
}
