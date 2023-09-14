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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Titulo: Clase VentanaPrincipal
 * 
 * @author UO281847
 * @version 14/10/2021
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
	 * Atributo lblUnidadesProducto
	 */
	private JLabel lblUnidadesProducto;
	/**
	 * Atributo lblImagenProducto
	 */
	private JLabel lblImagenProducto;
	/**
	 * Atributo menuBar
	 */
	private JMenuBar menuPrincipal;
	/**
	 * Atributo mnMenuPedido
	 */
	private JMenu mnMenuPedido;
	/**
	 * Atributo miNuevo
	 */
	private JMenuItem miNuevo;
	/**
	 * Atributo miSalir
	 */
	private JMenuItem miSalir;
	/**
	 * Atributo mnMenuAyuda
	 */
	private JMenu mnMenuAyuda;
	/**
	 * Atributo miContenidos
	 */
	private JMenuItem miContenidos;
	/**
	 * Atributo miAcercaDe
	 */
	private JMenuItem miAcercaDe;
	/**
	 * Atributo panelFiltro
	 */
	private JPanel panelFiltro;
	/**
	 * Atributo btBebidas
	 */
	private JButton btBebidas;
	/**
	 * Atributo btHamburguesas
	 */
	private JButton btHamburguesas;
	/**
	 * Atributo btComplementos
	 */
	private JButton btComplementos;
	/**
	 * Atributo btPostres
	 */
	private JButton btPostres;
	/**
	 * Atributo btTodos
	 */
	private JButton btTodos;
	
	/**
	 * Constructor de la ventana principal
	 */
	public VentanaPrincipal(Carta carta, Pedido pedido) {
		this.pedido = pedido;
		this.carta = carta;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("McDonald's Espa\u00F1a");
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getSpUnidades());
		getContentPane().add(getBtAñadir());
		getContentPane().add(getBtCancelar());
		getContentPane().add(getBtSiguiente());
		getContentPane().add(getCbArticulos());
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
		getContentPane().add(getLblUnidadesProducto());
		getContentPane().add(getLblImagenProducto());
		getContentPane().add(getPanelFiltro());
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setJMenuBar(getMenuPrincipal());
		
	}
	
	/**
	 * Método que inicializa la aplicación
	 */
	protected void inicializar() {
		pedido.inicializar();		
		getCbArticulos().setSelectedIndex(0);
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
			spUnidades.setToolTipText("N\u00FAmero de unidades del producto");
			spUnidades.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spUnidades.setBounds(646, 284, 54, 29);
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
			btAñadir.setBounds(786, 284, 76, 29);
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
			btEliminar.setBounds(872, 284, 76, 29);
			btEliminar.setEnabled(false);
		}
		return btEliminar;
	}
	
	/**
	 * Método que añade al pedido
	 */
	private void añadirAPedido() {
		Articulo arti = (Articulo) getCbArticulos().getSelectedItem();		
		int uni = (int) getSpUnidades().getValue();
		pedido.add(arti, uni);		
		
		mostrarUnidadesProducto(arti);	
		setPrecio();
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
		Articulo arti = (Articulo) getCbArticulos().getSelectedItem();		
		int uni = (int) getSpUnidades().getValue();
		pedido.remove(arti, uni);
		
		mostrarUnidadesProducto(arti);			
		setPrecio();		
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
	private JComboBox<Articulo> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			cbArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Articulo arti = (Articulo) getCbArticulos().getSelectedItem();
					mostrarImagen(arti);
					eliminarNoDisponible(arti);
					mostrarUnidadesProducto(arti);
				}
			});
			cbArticulos.setToolTipText("Seleccione los productos que desee");
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(carta.getArticulos()));
			cbArticulos.setBounds(175, 284, 404, 29);			
		}
		
		return cbArticulos;
	}
	
	/**
	 * Método que modifica el precio
	 */
	private void setPrecio() {
		String precio = String.format("%.2f", pedido.getTotal());
		getSpUnidades().setValue(1);
		getTfPrecio().setText(precio + " €");
	}
	/**
	 * Método que muestra las unidades del producto
	 * 
	 * @param arti, articulo
	 */
	private void mostrarUnidadesProducto(Articulo arti) {
		String unidadesProducto = "Hay " + pedido.unidadesProducto(arti) 
		+ " uds. de este producto en el pedido";					
		getLblUnidadesProducto().setText(unidadesProducto);
	}
	
	/**
	 * Método que muestra la imagen del articulo seleccionado en el combobox
	 * 
	 * @param arti, articulo
	 */
	private void mostrarImagen(Articulo arti) {
		getLblImagenProducto().setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/"+String.valueOf(arti.getCodigo())+".png")));
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
			btCancelar.setBounds(874, 501, 100, 27);
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
			btSiguiente.setBounds(762, 501, 100, 27);
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
			lblPrecio.setBounds(646, 383, 83, 23);
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
			tfPrecio.setToolTipText("El precio de su pedido");
			tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tfPrecio.setEditable(false);
			tfPrecio.setBounds(646, 417, 70, 41);
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
			lblUnidades.setBounds(646, 256, 70, 23);
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
			lblLogo.setBounds(175, 57, 152, 126);
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
			lblMcDonadls.setBounds(337, 96, 243, 60);
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
			lblArticulos.setLabelFor(getCbArticulos());
			lblArticulos.setBounds(175, 256, 70, 23);
		}
		return lblArticulos;
	}
	
	/**
	 * Método que genera la etiqueta de las unidades de cada producto
	 * 
	 * @return lblUnidadesProducto
	 */
	private JLabel getLblUnidadesProducto() {
		if (lblUnidadesProducto == null) {
			lblUnidadesProducto = new JLabel("Hay 0 uds. de este producto en el pedido");
			lblUnidadesProducto.setForeground(Color.RED);
			lblUnidadesProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblUnidadesProducto.setBounds(185, 331, 394, 23);
		}
		return lblUnidadesProducto;
	}
	
	/**
	 * Método que crea la etiqueta del McHappyDay
	 * 
	 * @return etiqueta
	 */
	private JLabel getLblPedido() {
		if (lblPedido == null) {
			lblPedido = new JLabel("D");
			lblPedido.setLabelFor(getPanelPedido());
			lblPedido.setDisplayedMnemonic('D');
			lblPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					verPedido(true);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					verPedido(false);
				}
			});
			lblPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			lblPedido.setBounds(841, 11, 133, 42);
		}
		return lblPedido;
	}
	
	/**
	 * Método que hace visible el pedido cuando se presiona el botón
	 * 
	 * @param ver, true o false
	 */
	private void verPedido(boolean ver) {
		if (ver) {
			getTxPedido().setText(pedido.toString());
		}
		getTxPedido().setVisible(ver);
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
			lblMcHappyDay.setBounds(766, 342, 193, 148);
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
			lblPromocion.setBounds(536, 424, 100, 23);
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
			panelPedido.setBounds(694, 57, 280, 148);
			panelPedido.setViewportView(getTxPedido());
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
	 * Método que genera la etiqueta que muestra las imagenes
	 * 
	 * @return lblImagenProducto
	 */
	private JLabel getLblImagenProducto() {
		if (lblImagenProducto == null) {
			lblImagenProducto = new JLabel("");
			lblImagenProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/HA01.png")));
			lblImagenProducto.setBounds(303, 383, 160, 130);
		}
		return lblImagenProducto;
	}
	
	/**
	 * Método que genera la barra del menu principal
	 * 
	 * @return menuPrincipal
	 */
	private JMenuBar getMenuPrincipal() {
		if (menuPrincipal == null) {
			menuPrincipal = new JMenuBar();
			menuPrincipal.add(getMnMenuPedido());
			menuPrincipal.add(getMnMenuAyuda());
		}
		return menuPrincipal;
	}
	
	/**
	 * Método que genera el menu del Pedido
	 * 
	 * @return mnMenuPedido
	 */
	private JMenu getMnMenuPedido() {
		if (mnMenuPedido == null) {
			mnMenuPedido = new JMenu("Pedido");
			mnMenuPedido.setMnemonic('P');
			mnMenuPedido.add(getMiNuevo());
			mnMenuPedido.add(getMiSalir());
		}
		return mnMenuPedido;
	}
	
	/**
	 * Método que genera el menú interactivo de Nuevo
	 * 
	 * @return miNuevo
	 */
	private JMenuItem getMiNuevo() {
		if (miNuevo == null) {
			miNuevo = new JMenuItem("Nuevo");
			miNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			miNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			miNuevo.setMnemonic('N');
		}
		return miNuevo;
	}
	
	/**
	 * Método que genera el menú interactivo de Salir
	 * 
	 * @return miSalir
	 */
	private JMenuItem getMiSalir() {
		if (miSalir == null) {
			miSalir = new JMenuItem("Salir");
			miSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			miSalir.setMnemonic('S');
		}
		return miSalir;
	}
	
	/**
	 * Método que genera el menu de Ayuda
	 * 
	 * @return mnMenuAyuda
	 */
	private JMenu getMnMenuAyuda() {
		if (mnMenuAyuda == null) {
			mnMenuAyuda = new JMenu("Ayuda");
			mnMenuAyuda.setMnemonic('Y');
			mnMenuAyuda.add(getMiContenidos());
			mnMenuAyuda.add(getMiAcercaDe());
		}
		return mnMenuAyuda;
	}
	
	/**
	 * Método que genera el menu interactivo de Contenidos
	 * 
	 * @return miContenidos
	 */
	private JMenuItem getMiContenidos() {
		if (miContenidos == null) {
			miContenidos = new JMenuItem("Contenidos");
			miContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							 "Ayuda no disponible", "Contenidos de la Ayuda",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
			miContenidos.setMnemonic('C');
			miContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return miContenidos;
	}
	
	/**
	 * Método que genera el menu interactivo de Acerca De
	 * 
	 * @return miAcercaDe
	 */
	private JMenuItem getMiAcercaDe() {
		if (miAcercaDe == null) {
			miAcercaDe = new JMenuItem("Acerca de");
			miAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, 
							"Aplicación para TPV de comida rápida \n Realizada por ...\n "
							+ "Prácticas CPM 21-22 \n EII Oviedo", "Acerca de", 
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
			miAcercaDe.setMnemonic('A');
		}
		return miAcercaDe;
	}
	
	/**
	 * Método que filtra los articulos del combobox
	 * 
	 * @param type
	 */
	private void filtrarArticulos(String tipo) {		
		getCbArticulos().setModel(new DefaultComboBoxModel<Articulo>(carta.getProducto(tipo)));
		mostrarImagen((Articulo) getCbArticulos().getSelectedItem());
	}
	
	/**
	 * Método que genera el panel de filtros
	 * 
	 * @return panelFiltro
	 */
	private JPanel getPanelFiltro() {
		if (panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.setBounds(10, 11, 155, 517);
			panelFiltro.setLayout(new GridLayout(5, 1, 0, 0));
			panelFiltro.add(getBtHamburguesas());
			panelFiltro.add(getBtBebidas());
			panelFiltro.add(getBtComplementos());
			panelFiltro.add(getBtPostres());
			panelFiltro.add(getBtTodos());
		}
		return panelFiltro;
	}
	
	/**
	 * Método que genera el botón de hamburguesas
	 * 
	 * @return btHamburguesas
	 */
	private JButton getBtHamburguesas() {
		if (btHamburguesas == null) {
			btHamburguesas = new JButton("Hamburguesas");
			btHamburguesas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtrarArticulos("Hamburguesa");
				}
			});
			btHamburguesas.setBackground(Color.WHITE);
			btHamburguesas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Hamburguesa.png")));			
			btHamburguesas.setMnemonic('H');
			btHamburguesas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btHamburguesas.setVerticalAlignment(SwingConstants.TOP);
			btHamburguesas.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btHamburguesas;
	}
	
	/**
	 * Método que genera el botón de bebidas
	 * 
	 * @return btBedidas
	 */
	private JButton getBtBebidas() {
		if (btBebidas == null) {
			btBebidas = new JButton("Bebidas");			
			btBebidas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtrarArticulos("Bebida");
				}
			});
			btBebidas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Bebida.png")));
			btBebidas.setBackground(Color.WHITE);
			btBebidas.setMnemonic('B');
			btBebidas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btBebidas.setVerticalAlignment(SwingConstants.TOP);
			btBebidas.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btBebidas;
	}
	
	/**
	 * Método que genera el botón de complementos
	 * 
	 * @return btComplementos
	 */
	private JButton getBtComplementos() {
		if (btComplementos == null) {
			btComplementos = new JButton("Complementos");
			btComplementos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtrarArticulos("Complemento");
				}
			});
			btComplementos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Complemento.png")));
			btComplementos.setBackground(Color.WHITE);
			btComplementos.setMnemonic('M');
			btComplementos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btComplementos.setVerticalAlignment(SwingConstants.TOP);
			btComplementos.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btComplementos;
	}
	
	/**
	 * Método que genera el botón de postres
	 * 
	 * @return btPostres
	 */
	private JButton getBtPostres() {
		if (btPostres == null) {
			btPostres = new JButton("Postres");
			btPostres.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtrarArticulos("Postre");
				}
			});
			btPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Postre.png")));
			btPostres.setBackground(Color.WHITE);
			btPostres.setMnemonic('R');
			btPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
			btPostres.setVerticalAlignment(SwingConstants.TOP);
			btPostres.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btPostres;
	}
	
	/**
	 * Método que genera el botón de todos
	 * 
	 * @return btTodos
	 */
	private JButton getBtTodos() {
		if (btTodos == null) {
			btTodos = new JButton("Todos");
			btTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(carta.getArticulos()));
					mostrarImagen((Articulo) getCbArticulos().getSelectedItem());
				}
			});
			btTodos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/McDonalds-logo1@0,1x@0,5x@0,33x.png")));
			btTodos.setBackground(Color.WHITE);
			btTodos.setMnemonic('T');
			btTodos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btTodos.setVerticalAlignment(SwingConstants.TOP);
			btTodos.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btTodos;
	}
}