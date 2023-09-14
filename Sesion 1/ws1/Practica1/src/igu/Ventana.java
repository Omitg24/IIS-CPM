package igu;

import java.awt.Color;

import javax.swing.*;

/**
 * Titulo: Clase Ventana
 * 
 * @author UO281847
 * @version 16/09/2021
 */
public class Ventana extends JFrame{
	/**
	 * Version serial UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo pnPrincipal
	 */
	private JPanel pnPrincipal;
	/**
	 * Atributo btAceptar
	 */
	private JButton btAceptar;
	/**
	 * Atributo btCancelar
	 */
	private JButton btCancelar;
	/**
	 * Atributo etiqueta
	 */
	private JLabel etiqueta;
	/**
	 * Atributo textField
	 */
	private JTextField textField;	
	
	/**
	 * Constructor de la clase Ventana que le aplica formato
	 */
	public Ventana() {
		this.setTitle("Ventana principal");
		this.setBounds(100,100,450,300);
		this.setLocationRelativeTo(null);
		
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.white);
		pnPrincipal.setLayout(null);
		this.setContentPane(pnPrincipal);
		
		btAceptar = new JButton("Aceptar");
		btAceptar.setBounds(200, 220, 100, 30);	
		btAceptar.setForeground(Color.blue);
		pnPrincipal.add(btAceptar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(320,220,100,30);
		btCancelar.setForeground(Color.blue);
		pnPrincipal.add(btCancelar);
		
		etiqueta = new JLabel("Introduzca su nombre:");
		etiqueta.setBounds(10,99,200,30);
		pnPrincipal.add(etiqueta);
		
		textField = new JTextField();
		textField.setBounds(145, 104, 275, 20);
		pnPrincipal.add(textField);
		textField.setColumns(10);
	}	
	/**
	 * 
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		Ventana ventana = new Ventana();		
		ventana.setVisible(true);	
	}
}
