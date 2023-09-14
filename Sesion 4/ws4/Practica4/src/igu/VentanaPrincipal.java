package igu;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

import logica.Articulo;
import logica.Carta;
import logica.Pedido;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Titulo: Clase VentanaPrincipal
 * 
 * @author UO281847
 * @version 09/10/2021
 */
public class VentanaPrincipal extends JFrame{
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo spUnidades
	 */
	private JSpinner spUnidades;
	/**
	 * Atributo btAñadir
	 */
	private JButton btAñadir;
	/**
	 * Atributo btCancelar
	 */
	private JButton btCancelar;
	/**
	 * Atributo btSiguiente
	 */
	private JButton btSiguiente;
	/**
	 * Atributo comboBox
	 */
	private JComboBox<Articulo> cbArticulos;
	/**
	 * Atributo lblPrecio
	 */
	private JLabel lblPrecio;
	/**
	 * Atributo tfPrecio
	 */
	private JTextField tfPrecio;
	/**
	 * Atributo lblUnidades
	 */
	private JLabel lblUnidades;
	/**
	 * Atributo lblLogo
	 */
	private JLabel lblLogo;
	/**
	 * Atributo lblMcDonadls
	 */
	private JLabel lblMcDonadls;
	/**
	 * Atributo lblArticulos
	 */
	private JLabel lblArticulos;	
	/**
	 * Atributo pedido
	 */
	private Pedido pedido;
	/**
	 * Atributo carta
	 */
	private Carta carta;
	/**
	 * Atributo lblMcHappyDay
	 */
	private JLabel lblPedido;
	/**
	 * Atributo lblPromocion
	 */
	private JLabel lblPromocion;
	/**
	 * Atributo btElimianr
	 */
	private JButton btEliminar;
	/**
	 * Atributo panelPedido
	 */
	private JScrollPane panelPedido;
	/**
	 * Atributo txPedido
	 */
	private JTextArea txPedido;
	/**
	 * Atributo lblMcHappyDay
	 */
	private JLabel lblMcHappyDay;
	/**
	 * Atributo btMostrarPedido
	 */
	private JButton btMostrarPedido;
	
	/**
	 * Constructor de la ventana principal
	 */
	public VentanaPrincipal(Carta carta, Pedido pedido) {
		this.pedido = pedido;
		this.carta = carta;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("McDonald's Espa\u00F1a");
		setBounds(100, 100, 850, 550);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getSpUnidades());
		getContentPane().add(getBtAñadir());
		getContentPane().add(getBtCancelar());
		getContentPane().add(getBtSiguiente());
		getContentPane().add(getCbArticulo());
		getContentPane().add(getLblPrecio());
		getContentPane().add(getTfPrecio());
		getContentPane().add(getLblUnidades());
		getContentPane().add(getLblLogo());
		getContentPane().add(getLblMcDonadls());
		getContentPane().add(getLblArticulos());
		getContentPane().add(getLblPedido());
		getContentPane().add(getLblPromocion());
		getContentPane().add(getLblMcHappyDay());
		getContentPane().add(getBtEliminar());
		getContentPane().add(getPanelPedido());
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		
	}
	
	/**
	 * Método que inicializa la aplicación
	 */
	protected void inicializar() {
		pedido.inicializar();		
		getCbArticulo().setSelectedIndex(0);
		getSpUnidades().setValue(1);
		getLblPrecio().setText("Precio Pedido: ");
		getTfPrecio().setText("");
		getLblPromocion().setText("");
		getTxPedido().setText("");
		getBtSiguiente().setEnabled(false);
	}
	
	/**
	 * Método que muestra la ventana de registro
	 */
	private void mostrarVentanaRegistro() {
		VentanaRegistro vRegistro = new VentanaRegistro(this);
		vRegistro.setLocationRelativeTo(this);
		vRegistro.setModal(true);
		vRegistro.setVisible(true);
	}
	
	/**
	 * Método que crea el spinner de unidades
	 * 
	 * @return spinner
	 */
	@SuppressWarnings("deprecation")
	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades.setToolTipText("N\u00EDmero de unidades del producto");
			spUnidades.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spUnidades.setBounds(461, 244, 54, 29);
		}
		return spUnidades;
	}
	
	/**
	 * Método que crea el botón añadir
	 *  
	 * @return boton
	 */
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("A\u00F1adir");
			btAñadir.setToolTipText("A\u00F1adir al pedido");
			btAñadir.setMnemonic('A');
			btAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirAPedido();					
				}
			});
			btAñadir.setForeground(Color.WHITE);
			btAñadir.setBackground(new Color(0, 128, 0));
			btAñadir.setBounds(601, 244, 76, 29);
		}
		return btAñadir;
	}
	
	/**
	 * Método que modifica el valor del atributo enLocal
	 * 
	 * @param enLocal
	 */
	public void setEnLocal(boolean enLocal) {
		pedido.setEnLocal(enLocal);
	}
	
	/**
	 * Método que devuelve el botón eliminar
	 * 
	 * @return btEliminar
	 */
	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.setToolTipText("Eliminar del pedido");
			btEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarDePedido();
				}
			});
			btEliminar.setMnemonic('E');
			btEliminar.setForeground(Color.WHITE);
			btEliminar.setBackground(new Color(0, 128, 0));
			btEliminar.setBounds(687, 244, 76, 29);
			btEliminar.setEnabled(false);
		}
		return btEliminar;
	}
	
	/**
	 * Método que añade al pedido
	 */
	private void añadirAPedido() {
		Articulo arti = (Articulo) getCbArticulo().getSelectedItem();		
		int uni = (int) getSpUnidades().getValue();
		pedido.add(arti, uni);		
		
		getTxPedido().setText(pedido.toString());
		
		String precio = String.format("%.2f", pedido.getTotal());
		getTfPrecio().setText(precio + " €");
		getSpUnidades().setValue(1);		
		
		comprobarDescuento();
		eliminarNoDisponible(arti);
		
		if(!getBtSiguiente().isEnabled()) {
			getBtSiguiente().setEnabled(true);
		}	
	}	
	
	/**
	 * Método que añade al pedido
	 */
	private void eliminarDePedido() {
		Articulo arti = (Articulo) getCbArticulo().getSelectedItem();		
		int uni = (int) getSpUnidades().getValue();
		pedido.remove(arti, uni);
		
		getTxPedido().setText(pedido.toString());
		
		String precio = String.format("%.2f", pedido.getTotal());
		getSpUnidades().setValue(1);
		getTfPrecio().setText(precio + " €");
		
		comprobarDescuento();
		eliminarNoDisponible(arti);
		
		if (pedido.listaPedidoVacia()) {
			getBtSiguiente().setEnabled(false);
		}
	}
	
	/**
	 * Método que comprueba si el descuento esta aplicado
	 */
	private void comprobarDescuento() {
		if (pedido.isDescuentoAplicado()) {
			getLblPromocion().setText("10% de Descuento");
		} else {
			getLblPromocion().setText("");
		}
	}
	
	/**
	 * Método que crea el combobox con los productos
	 * 
	 * @return combobox
	 */
	private JComboBox<Articulo> getCbArticulo() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			cbArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Articulo arti = (Articulo) getCbArticulo().getSelectedItem();
					eliminarNoDisponible(arti);
				}
			});
			cbArticulos.setToolTipText("Seleccione los productos que desee");
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(carta.getArticulos()));
			cbArticulos.setBounds(13, 244, 404, 29);			
		}
		
		return cbArticulos;
	}
	
	/**
	 * Método que hace que el botón eliminar no este disponible
	 * 
	 * @param arti, articulo
	 */
	private void eliminarNoDisponible(Articulo arti) {
		if (pedido.estaEnPedido(arti)){
			getBtEliminar().setEnabled(true);;
		} else {
			getBtEliminar().setEnabled(false);;
		}
	}
	
	/**
	 * Método que crea el botón cancelar
	 * 
	 * @return boton
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setToolTipText("Cancelar el pedido");
			btCancelar.setMnemonic('C');
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(EXIT_ON_CLOSE);
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(689, 461, 100, 27);
		}
		return btCancelar;
	}
	
	/**
	 * Método que crea el botón siguiente
	 * 
	 * @return boton
	 */
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setToolTipText("Ir a la ventana de regsitro del pedido");
			btSiguiente.setMnemonic('S');
			btSiguiente.setEnabled(false);
			btSiguiente.setBackground(new Color(0, 128, 0));
			btSiguiente.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaRegistro();
				}
			});
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBounds(577, 461, 100, 27);
		}
		return btSiguiente;
	}
		
	/**
	 * Método que crea la etiqueta del precio
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel("Precio Pedido:");
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPrecio.setBounds(461, 343, 83, 23);
		}
		return lblPrecio;
	}
	
	/**
	 * Método que crea el textField del precio
	 * 
	 * @return texto
	 */
	private JTextField getTfPrecio() {
		if (tfPrecio == null) {
			tfPrecio = new JTextField();
			tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tfPrecio.setEditable(false);
			tfPrecio.setBounds(461, 377, 70, 41);
			tfPrecio.setColumns(10);
		}
		return tfPrecio;
	}
	
	/**
	 * Método que creea la etiqueta de unidades
	 *  
	 * @return etiqueta
	 */
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setDisplayedMnemonic('U');
			lblUnidades.setLabelFor(getSpUnidades());
			lblUnidades.setBounds(461, 216, 70, 23);
		}
		return lblUnidades;
	}
	
	/**
	 * Método que crea la etiqueta del logo
	 *  
	 * @return etiqueta
	 */
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lblLogo.setBounds(13, 41, 152, 126);
		}
		return lblLogo;
	}
	
	/**
	 * Método que crea la etiqueta McDonald's
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblMcDonadls() {
		if (lblMcDonadls == null) {
			lblMcDonadls = new JLabel("McDonald's");
			lblMcDonadls.setFont(new Font("Arial Black", Font.PLAIN, 38));
			lblMcDonadls.setBounds(174, 79, 243, 60);
		}
		return lblMcDonadls;
	}
	
	/**
	 * Método que crea la etiqueta de Articulos
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Art\u00EDculos:");
			lblArticulos.setDisplayedMnemonic('R');
			lblArticulos.setLabelFor(getCbArticulo());
			lblArticulos.setBounds(13, 216, 70, 23);
		}
		return lblArticulos;
	}
	
	/**
	 * Método que crea la etiqueta del McHappyDay
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblPedido() {
		if (lblPedido == null) {
			lblPedido = new JLabel("");
			lblPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			lblPedido.setBounds(679, 11, 133, 42);
		}
		return lblPedido;
	}
	
	/**
	 * Método que genera la etiqueta de la promoción del McHappyDay
	 * 
	 * @return lblMcHappyDay
	 */
	private JLabel getLblMcHappyDay() {
		if (lblMcHappyDay == null) {
			lblMcHappyDay = new JLabel("");
			lblMcHappyDay.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ofertaHappy.png")));
			lblMcHappyDay.setBounds(581, 302, 193, 148);
		}
		return lblMcHappyDay;
	}
	
	/**
	 * Método que crea la etiqueta de la promocion
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblPromocion() {
		if (lblPromocion == null) {
			lblPromocion = new JLabel("");
			lblPromocion.setBackground(new Color(0, 128, 0));
			lblPromocion.setForeground(Color.RED);
			lblPromocion.setFont(new Font("Arial", Font.PLAIN, 11));
			lblPromocion.setHorizontalAlignment(SwingConstants.CENTER);
			lblPromocion.setBounds(351, 384, 100, 23);
		}
		return lblPromocion;
	}
		
	/**
	 * Método que graba el pedido
	 */
	public void grabarPedido() {
		pedido.grabarPedido();
	}
	
	/**
	 * Método que devuelve el precio
	 * 
	 * @return precio
	 */
	public double getPrecio() {
		return pedido.getTotal();
	}	
	
	/**
	 * Método que genera el panel de Scroll
	 * 
	 * @return scrollPanel
	 */
	private JScrollPane getPanelPedido() {
		if (panelPedido == null) {
			panelPedido = new JScrollPane();
			panelPedido.setViewportBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
			panelPedido.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelPedido.setBounds(532, 57, 280, 148);
			panelPedido.setViewportView(getTxPedido());
			panelPedido.setColumnHeaderView(getBtMostrarPedido());
		}
		return panelPedido;
	}
	
	/**
	 * Método que genera el panel con el pedido
	 * 
	 * @return txPedido
	 */
	private JTextArea getTxPedido() {
		if (txPedido == null) {
			txPedido = new JTextArea();
			txPedido.setToolTipText("Su pedido");
			txPedido.setEditable(false);
			txPedido.setVisible(false);
		}
		return txPedido;
	}
	
	/**
	 * Método que genera el botón de mostrar el pedido
	 * 
	 * @return btMostrarPedido
	 */
	private JButton getBtMostrarPedido() {
		if (btMostrarPedido == null) {
			btMostrarPedido = new JButton("Mostrar Pedido");
			btMostrarPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					getTxPedido().setVisible(true);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					getTxPedido().setVisible(false);
				}
			});
			btMostrarPedido.setToolTipText("Presione este bot\u00F3n para mostrar el pedido");
			btMostrarPedido.setForeground(new Color(255, 255, 255));
			btMostrarPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btMostrarPedido.setBackground(new Color(128, 0, 0));
			btMostrarPedido.setMnemonic('M');
		}
		return btMostrarPedido;
	}
}