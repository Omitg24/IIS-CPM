package igu;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import logica.*;
import logica.Pedido.TipoPedido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Titulo: Clase VentanaPrincipal 
 * 
 * @author Omitg
 * @version 06/12/2021
 */
public class VentanaPrincipal extends JFrame {
	/**
	 * Constante 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo aB
	 */
	private AccionBoton aB;
	/**
	 * Atributo pT
	 */
	private ProcesaTecla pT;
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo lblLogo
	 */
	private JLabel lblLogo;
	/**
	 * Atributo lblLblnombre
	 */
	private JLabel lblLblnombre;
	/**
	 * Atributo carta
	 */
	private Carta carta;
	/**
	 * Atributo pedido
	 */
	private Pedido pedido;
	/**
	 * Atributo pnInfo1
	 */
	private JPanel pnInfo1;
	/**
	 * Atributo pnlLogo
	 */
	private JPanel pnlLogo;
	/**
	 * Atributo pnArticulos
	 */
	private JPanel pnArticulos;
	/**
	 * Atributo pnBts1
	 */
	private JPanel pnBts1;
	/**
	 * Atributo pnBts2
	 */
	private JPanel pnBts2;
	/**
	 * Atributo pnBts3
	 */
	private JPanel pnBts3;
	/**
	 * Atributo pnContenidos
	 */
	private JPanel pnContenidos;
	/**
	 * Atributo pn2
	 */
	private JPanel pn2;
	/**
	 * Atributo pn3
	 */
	private JPanel pn3;
	/**
	 * Atributo pnDatosCliente
	 */
	private JPanel pnDatosCliente;
	/**
	 * Atributo lbNombre
	 */
	private JLabel lbNombre;
	/**
	 * Atributo txtNombre
	 */
	private JTextField txtNombre;
	/**
	 * Atributo lbAño
	 */
	private JLabel lbAño;
	/**
	 * Atributo cbAños
	 */
	private JComboBox<String> cbAños;
	/**
	 * Atributo lbPasw1
	 */
	private JLabel lbPasw1;
	/**
	 * Atributo psw1
	 */
	private JPasswordField psw1;
	/**
	 * Atributo lbPasw2
	 */
	private JLabel lbPasw2;
	/**
	 * Atributo psw2
	 */
	private JPasswordField psw2;
	/**
	 * Atributo pn1
	 */
	private JPanel pn1;
	/**
	 * Atributo pnFormulario
	 */
	private JPanel pnFormulario;
	/**
	 * Atributo pnDatosPedido
	 */
	private JPanel pnDatosPedido;
	/**
	 * Atributo rbLocal
	 */
	private JRadioButton rbLocal;
	/**
	 * Atributo rbLlevar
	 */
	private JRadioButton rbLlevar;
	/**
	 * Atributo pnInfo2
	 */
	private JPanel pnInfo2;
	/**
	 * Atributo pnConfirmacion
	 */
	private JPanel pnConfirmacion;
	/**
	 * Atributo pnInfo3
	 */
	private JPanel pnInfo3;
	/**
	 * Atributo lbAviso
	 */
	private JLabel lbAviso;
	/**
	 * Atributo lbOk
	 */
	private JLabel lbOk;
	/**
	 * Atributo lbCodigo
	 */
	private JLabel lbCodigo;
	/**
	 * Atributo txCodigo
	 */
	private JTextField txCodigo;
	/**
	 * Atributo grPedido
	 */
	private final ButtonGroup grPedido = new ButtonGroup();
	/**
	 * Atributo txPrecio
	 */
	private JTextField txPrecio;
	/**
	 * Atributo btnAnular1
	 */
	private JButton btnAnular1;
	/**
	 * Atributo btnSig1
	 */
	private JButton btnSig1;
	/**
	 * Atributo pnPedido
	 */
	private JTabbedPane pnPedido;
	/**
	 * Atributo scrComida
	 */
	private JScrollPane scrComida;
	/**
	 * Atributo scrBebida
	 */
	private JScrollPane scrBebida;
	/**
	 * Atributo listComida
	 */
	private JList<Articulo> listComida;
	/**
	 * Atributo listBebida
	 */
	private JList<Articulo> listBebida;
	/**
	 * Atributo modeloListaComida
	 */
	private DefaultListModel<Articulo> modeloListaComida;
	/**
	 * Atributo modeloListaBebida
	 */
	private DefaultListModel<Articulo> modeloListaBebida;
	/**
	 * Atributo btnAnt2
	 */
	private JButton btnAnt2;
	/**
	 * Atributo btnSig2
	 */
	private JButton btnSig2;
	/**
	 * Atributo btnAnt3
	 */
	private JButton btnAnt3;
	/**
	 * Atributo btnFin3
	 */
	private JButton btnFin3;
	/**
	 * Atributo pnFiltro
	 */
	private JPanel pnFiltro;
	/**
	 * Atributo btnTodos
	 */
	private JButton btnTodos;
	/**
	 * Atributo btnHamburguesas
	 */
	private JButton btnHamburguesas;
	/**
	 * Atributo btnBebidas
	 */
	private JButton btnBebidas;
	/**
	 * Atributo btnComplementos
	 */
	private JButton btnComplementos;
	/**
	 * Atributo btnPostres
	 */
	private JButton btnPostres;	
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(final Carta carta, final Pedido pedido) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(final ComponentEvent e) {
				asociaImagenBotones();
			}
		});
		this.carta = carta;
		this.pedido = pedido;
		aB = new AccionBoton();
		pT = new ProcesaTecla();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		setTitle("McDonald's España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 1000);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnlLogo(), BorderLayout.NORTH);
		contentPane.add(getPnContenidos(), BorderLayout.CENTER);
	}
	/**
	 * Método que crea el logo 
	 * @return lblLogo
	 */
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		}
		return lblLogo;
	}
	/**
	 * Método que crea la etiqueta nombre 
	 * @return lblLblNombre
	 */
	private JLabel getLblLblnombre() {
		if (lblLblnombre == null) {
			lblLblnombre = new JLabel("McDonald's");
			lblLblnombre.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lblLblnombre.setForeground(Color.BLACK);
		}
		return lblLblnombre;
	}
	/**
	 * Método que incializa la aplicación 
	 */
	protected void inicializar() {
		anularPedido();
		inicializar2();
	}
	/**
	 * Método que incializa la aplicación parte 2
	 */
	private void inicializar2() {
		getTxtNombre().setText("");
		getCbAños().setSelectedIndex(0);
		getPsw1().setText("");
		getPsw2().setText("");
		getRbLocal().setSelected(true);
	}
	/**
	 * Método que crea el panel de info 1 
	 * @return pnInfo1
	 */
	private JPanel getPnInfo1() {
		if (pnInfo1 == null) {
			pnInfo1 = new JPanel();
			pnInfo1.setBackground(Color.WHITE);
			pnInfo1.setLayout(new BorderLayout(0, 0));
			pnInfo1.add(getPnBts1(),BorderLayout.SOUTH);
			pnInfo1.add(getPnPedido(), BorderLayout.CENTER);
		
		}
		return pnInfo1;
	}
	/**
	 * Método que crea el panel del logo 
	 * @return pnlLogo
	 */
	private JPanel getPnlLogo() {
		if (pnlLogo == null) {
			pnlLogo = new JPanel();
			pnlLogo.setBackground(Color.WHITE);
			pnlLogo.setLayout(new GridLayout(1, 0, 0, 0));
			pnlLogo.add(getLblLogo());
			pnlLogo.add(getLblLblnombre());
		}
		return pnlLogo;
	}
	/**
	 * Método que crea el panel de articulos 
	 * @return pnArticulos
	 */
	private JPanel getPnArticulos() {
		if (pnArticulos == null) {
			pnArticulos = new JPanel();
			pnArticulos.setBorder(new LineBorder(Color.ORANGE, 4));
			pnArticulos.setBackground(Color.WHITE);
			pnArticulos.setLayout(new GridLayout(0, 6, 3, 3));
			creaBotonesTablero();
		}
		return pnArticulos;
	}	
	/**
	 * Método que crea botones para el tablero 
	 */
	private void creaBotonesTablero() {
		pnArticulos.removeAll();
		for(int i = 0; i < carta.getListaArticulos().size(); i++) {
			pnArticulos.add(nuevoBoton(i));
		}
	}
	/**
	 * Método que setea la imagen adaptada
	 * @param boton
	 * @param rutaImagen
	 */
	private void setImagenAdaptada(final JButton boton, final String rutaImagen){
		 final Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 final Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(),boton.getHeight(), Image.SCALE_SMOOTH);
		 final ImageIcon icon = new ImageIcon(imgEscalada);
		 boton.setIcon(icon);
	}	
	/**
	 * Método que asocia la imagen a botones
	 */
	private void asociaImagenBotones() {
		for (int i = 0; i < getPnArticulos().getComponents().length; i++)
		{
			final JButton boton = (JButton) (pnArticulos.getComponents()[i]);
			setImagenAdaptada(boton, "/img/" + carta.getListaArticulos().get(i).getCodigo()+".png");
		}
	}
	/**
	 * Método que crea un nuevo boton
	 * @param posicion
	 * @return boton
	 */
	private JButton nuevoBoton(final Integer posicion) {
		final JButton boton = new JButton("");
		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setToolTipText(carta.getListaArticulos().get(posicion).toString());
		boton.setActionCommand(posicion.toString());
		boton.addActionListener(aB);
		return boton;
	}

	/**
	 * Titulo: Clase AccionBoton
	 * 
	 * @author Omitg
	 * @version 06/12/2021
	 */
	class AccionBoton implements ActionListener {
		/**
		 * Método actionPerformed 
		 * @param e
		 */
		public void actionPerformed(final ActionEvent e) {
			final JButton bt = (JButton) e.getSource();
			añadirAPedido(Integer.parseInt(bt.getActionCommand()));
		}
	}
	/**
	 * Método que añade a pedido
	 * @param posArticuloEnCarta
	 */
	private void añadirAPedido(final int posArticuloEnCarta) {
		final Articulo a = carta.getListaArticulos().get(posArticuloEnCarta);
		pedido.add(a, 1);
		mostrarEnLista(a);
		getTxPrecio().setText("Precio: " + String.format("%.2f", pedido.getTotal()));
		if(!getBtnSig1().isEnabled()) {
			getBtnSig1().setEnabled(true);
		}
	}
	/**
	 * Método que muestra en la lista
	 * @param a
	 */
	private void mostrarEnLista(final Articulo a) {
		if(a.getTipo().equals("Bebida"))
			modeloListaBebida.addElement(a);
		else
			modeloListaComida.addElement(a);
	}
	/**
	 * Método que muestra el panel 1
	 */
	private void mostrarPn1() {
		getPnInfo1().add(getPnPedido());
		getPnBts1().add(getTxPrecio(),0);
		((CardLayout)getPnContenidos().getLayout()).show(pnContenidos, "pn1");
	}
	/**
	 * Método que muestra el panel 2
	 */
	private void mostrarPn2() {
		getPnInfo2().add(getPnPedido());
		getPnBts2().add(getTxPrecio(),0);
		((CardLayout)getPnContenidos().getLayout()).show(pnContenidos,"pn2");
		//((CardLayout)getPnContenidos().getLayout()).next(pnContenidos);
	}
	/**
	 * Método que muestra el panel 3
	 */
	private void mostrarPn3() {
		if (comprobarCampos())
		{   
			getPnInfo3().add(getPnPedido());
			getPnBts3().add(getTxPrecio(),0);
			((CardLayout)getPnContenidos().getLayout()).show(pnContenidos,"pn3");
		}
	}
	/**
	 * Método que crea el panel de botones 1
	 * @return pnBts1
	 */
	private JPanel getPnBts1() {
		if (pnBts1 == null) {
			pnBts1 = new JPanel();
			pnBts1.setBackground(Color.WHITE);
			pnBts1.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts1.add(getTxPrecio());
			pnBts1.add(getBtnAnular1());
			pnBts1.add(getBtnSig1());
		}
		return pnBts1;
	}
	/**
	 * Método que crea el panel de botones 2 
	 * @return pnBts2
	 */
	private JPanel getPnBts2() {
		if (pnBts2 == null) {
			pnBts2 = new JPanel();
			pnBts2.setBackground(Color.WHITE);
			pnBts2.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts2.add(getBtnAnt2());
			pnBts2.add(getBtnSig2());
		}
		return pnBts2;
	}
	/**
	 * Método que crea el panel de botones 3 
	 * @return pnBts3
	 */
	private JPanel getPnBts3() {
		if (pnBts3 == null) {
			pnBts3 = new JPanel();
			pnBts3.setBackground(Color.WHITE);
			pnBts3.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts3.add(getBtnAnt3());
			pnBts3.add(getBtnFin3());
		}
		return pnBts3;
	}
	/**
	 * Método que crea el panel de contenidos 
	 * @return pnContenidos
	 */
	private JPanel getPnContenidos() {
		if (pnContenidos == null) {
			pnContenidos = new JPanel();
			pnContenidos.setLayout(new CardLayout(0, 0));
			pnContenidos.add(getPn1(), "pn1");
			pnContenidos.add(getPn2(), "pn2");
			pnContenidos.add(getPn3(), "pn3");
		}
		return pnContenidos;
	}
	/**
	 * Método que crea el panel 2
	 * @return pn2
	 */
	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getPnFormulario(), BorderLayout.CENTER);
			pn2.add(getPnInfo2(), BorderLayout.SOUTH);
		}
		return pn2;
	}
	/**
	 * Método que crea el panel 3 
	 * @return pn3
	 */
	private JPanel getPn3() {
		if (pn3 == null) {
			pn3 = new JPanel();
			pn3.setBackground(Color.WHITE);
			pn3.setLayout(new BorderLayout(0, 0));
			pn3.add(getPnConfirmacion());
			pn3.add(getPnInfo3(), BorderLayout.SOUTH);
		}
		return pn3;
	}
	/**
	 * Método que crea el comboBox
	 * @return cbAños
	 */
	private JComboBox<String> getCbAños() {
		if (cbAños == null) {
			final String[]años = new String[90];
			for (int i=0;i<90;i++){
				final String año = ""+((90-i)+1920);
				años[i]= año;
			}
			cbAños = new JComboBox<String>();
			cbAños.setFont(new Font("Arial", Font.PLAIN, 14));
			cbAños.setModel(new DefaultComboBoxModel<String>(años));
			cbAños.setBounds(new Rectangle(264, 84, 157, 25));
		}
		return cbAños;
	}
	/**
	 * Método que comprueba si esta vacío
	 * @return true o false
	 */
	private boolean isVacio() {
		return (txtNombre.getText().equals("")||(String.valueOf(psw1.getPassword()).equals(""))||(String.valueOf(psw2.getPassword()).equals(""))); 
	
	}
	/**
	 * Método que comprueba si es incorrecto
	 * @return true o false
	 */
	private boolean isIncorrecta() {
		return (!String.valueOf(psw1.getPassword()).equals(String.valueOf(psw2.getPassword())));
	}
	/**
	 * Método que crea el panel de datos del cliente
	 * @return pnDatosCliente
	 */
	private JPanel getPnDatosCliente() {
		if (pnDatosCliente == null) {
			pnDatosCliente = new JPanel();
			pnDatosCliente.setBounds(104, 58, 656, 224);
			pnDatosCliente.setBorder(new TitledBorder(null, "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosCliente.setBackground(Color.WHITE);
			pnDatosCliente.setLayout(null);
			pnDatosCliente.add(getLbNombre());
			pnDatosCliente.add(getTxtNombre());
			pnDatosCliente.add(getLbAño());
			pnDatosCliente.add(getCbAños());
			pnDatosCliente.add(getLbPasw1());
			pnDatosCliente.add(getPsw1());
			pnDatosCliente.add(getLbPasw2());
			pnDatosCliente.add(getPsw2());
		}
		return pnDatosCliente;
	}
	/**
	 * Método que crea la etiqueta nombre 
	 * @return lbNombre
	 */
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel();
			lbNombre.setText("Nombre y Apellidos:");
			lbNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setBounds(30, 31, 132, 20);
		}
		return lbNombre;
	}
	/**
	 * Método que crea la etiqueta nombre 
	 * @return lbNombre
	 */
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txtNombre.setBounds(264, 31, 330, 25);
		}
		return txtNombre;
	}
	/**
	 * Método que crea lbAño 
	 * @return lbAño
	 */
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("A\u00F1o de nacimiento:");
			lbAño.setFont(new Font("Arial", Font.PLAIN, 14));
			lbAño.setDisplayedMnemonic('A');
			lbAño.setBounds(30, 81, 151, 16);
		}
		return lbAño;
	}
	/**
	 * Método que crea la etiqueta lbPasw1 
	 * @return lbPasw1
	 */
	private JLabel getLbPasw1() {
		if (lbPasw1 == null) {
			lbPasw1 = new JLabel();
			lbPasw1.setText("Password:");
			lbPasw1.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPasw1.setDisplayedMnemonic('P');
			lbPasw1.setBounds(new Rectangle(13, 123, 105, 16));
			lbPasw1.setBounds(30, 129, 105, 16);
		}
		return lbPasw1;
	}
	/**
	 * Método que crea la etiqueta lbPasw1 
	 * @return lbPasw1
	 */
	private JPasswordField getPsw1() {
		if (psw1 == null) {
			psw1 = new JPasswordField();
			psw1.setFont(new Font("Arial", Font.PLAIN, 14));
			psw1.setBounds(new Rectangle(176, 121, 218, 25));
			psw1.setBounds(264, 129, 218, 25);
		}
		return psw1;
	}
	/**
	 * Método que crea la etiqueta lbPasw2 
	 * @return lbPasw2
	 */
	private JLabel getLbPasw2() {
		if (lbPasw2 == null) {
			lbPasw2 = new JLabel();
			lbPasw2.setText("Reintroduzca password:");
			lbPasw2.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPasw2.setDisplayedMnemonic('R');
			lbPasw2.setBounds(new Rectangle(13, 167, 151, 16));
			lbPasw2.setBounds(30, 181, 182, 16);
		}
		return lbPasw2;
	}
	/**
	 * Método que crea la etiqueta lbPasw2 
	 * @return lbPasw2
	 */
	private JPasswordField getPsw2() {
		if (psw2 == null) {
			psw2 = new JPasswordField();
			psw2.setFont(new Font("Arial", Font.PLAIN, 14));
			psw2.setBounds(new Rectangle(176, 163, 218, 25));
			psw2.setBounds(264, 179, 218, 25);
		}
		return psw2;
	}	
	/**
	 * Método que comprueba los campos
	 * @return true o false
	 */
	public boolean comprobarCampos() {
		if (isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Hay algún campo en blanco");
			return false;
		}
		else
			if (isIncorrecta()) {
				JOptionPane.showMessageDialog(null, "Error: Las passwords no coinciden");
				return false;
			}
		return true;
	 }
	/**
	 * Método que crea el panel 1
	 * @return pn1
	 */
	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getPnArticulos(), BorderLayout.CENTER);
			pn1.add(getPnInfo1(), BorderLayout.SOUTH);
			pn1.add(getPnFiltro(), BorderLayout.WEST);
		}
		return pn1;
	}
	/**
	 * Metodo que crea el panel de formulario
	 * @return pnFormulario
	 */
	private JPanel getPnFormulario() {
		if (pnFormulario == null) {
			pnFormulario = new JPanel();
			pnFormulario.setBorder(new LineBorder(Color.ORANGE, 4));
			pnFormulario.setBackground(Color.WHITE);
			pnFormulario.setLayout(null);
			pnFormulario.add(getPnDatosCliente());
			pnFormulario.add(getPnDatosPedido());
		}
		return pnFormulario;
	}
	/**
	 * Metodo que crea el panel de datos del pedido
	 * @return pnDatosPedido
	 */
	private JPanel getPnDatosPedido() {
		if (pnDatosPedido == null) {
			pnDatosPedido = new JPanel();
			pnDatosPedido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatosPedido.setBackground(Color.WHITE);
			pnDatosPedido.setBounds(104, 304, 248, 60);
			pnDatosPedido.add(getRbLocal());
			pnDatosPedido.add(getRbLlevar());
		}
		return pnDatosPedido;
	}
	/**
	 * Metodo que crea el radioBoton local
	 * @return rbLocal
	 */
	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton();
			rbLocal.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					if (rbLocal.isSelected()) {
						pedido.setTipo(TipoPedido.LOCAL);
					}
				}
			});
			grPedido.add(rbLocal);
			rbLocal.setText("Local");
			rbLocal.setSelected(true);
			rbLocal.setMnemonic('L');
			rbLocal.setFont(new Font("Arial", Font.PLAIN, 14));
			rbLocal.setBounds(new Rectangle(17, 27, 94, 24));
			rbLocal.setBackground(Color.WHITE);
		}
		return rbLocal;
	}
	/**
	 * Metodo que crea el radioBoton llevar
	 * @return rbLlevar
	 */	
	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton();
			rbLlevar.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					if (rbLlevar.isSelected()) {
						pedido.setTipo(TipoPedido.LLEVAR);
					}
				}
			});
			grPedido.add(rbLlevar);
			rbLlevar.setText("Llevar");
			rbLlevar.setMnemonic('r');
			rbLlevar.setFont(new Font("Arial", Font.PLAIN, 14));
			rbLlevar.setBounds(new Rectangle(115, 27, 86, 24));
			rbLlevar.setBackground(Color.WHITE);
		}
		return rbLlevar;
	}
	/**
	 * Metodo que crea el panel de info 2
	 * @return pnInfo2
	 */
	private JPanel getPnInfo2() {
		if (pnInfo2 == null) {
			pnInfo2 = new JPanel();
			pnInfo2.setBackground(Color.WHITE);
			pnInfo2.setLayout(new BorderLayout(0, 0));
			pnInfo2.add(getPnBts2(),BorderLayout.SOUTH);
		}
		return pnInfo2;
	}
	/**
	 * Metodo que crea el panel de confirmacion
	 * @return pnConfirmacion
	 */
	private JPanel getPnConfirmacion() {
		if (pnConfirmacion == null) {
			pnConfirmacion = new JPanel();
			pnConfirmacion.setBorder(new LineBorder(Color.ORANGE, 4));
			pnConfirmacion.setBackground(Color.WHITE);
			pnConfirmacion.setLayout(null);
			pnConfirmacion.add(getLbAviso());
			pnConfirmacion.add(getLbOk());
			pnConfirmacion.add(getLbCodigo());
			pnConfirmacion.add(getTxCodigo());
		}
		return pnConfirmacion;
	}
	/**
	 * Metodo que crea el panel de info 3
	 * @return pnInfo3
	 */
	private JPanel getPnInfo3() {
		if (pnInfo3 == null) {
			pnInfo3 = new JPanel();
			pnInfo3.setBackground(Color.WHITE);
			pnInfo3.setLayout(new BorderLayout(0, 0));
			pnInfo3.add(getPnBts3(),BorderLayout.SOUTH);
		}
		return pnInfo3;
	}
	/**
	 * Método que finaliza el programa
	 */
	private void finalizar() {
		pedido.grabarPedido();
		inicializar();
		mostrarPn1();
	}
	/**
	 * Metodo que crea la etiqueta aviso
	 * @return lbAviso
	 */
	private JLabel getLbAviso() {
		if (lbAviso == null) {
			lbAviso = new JLabel("Pulse Finalizar para confirmar su pedido");
			lbAviso.setFont(new Font("Tahoma", Font.BOLD, 28));
			lbAviso.setBounds(135, 104, 622, 35);
		}
		return lbAviso;
	}
	/**
	 * Metodo que crea la etiqueta Ok
	 * @return lbOk
	 */
	private JLabel getLbOk() {
		if (lbOk == null) {
			lbOk = new JLabel("");
			lbOk.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ok.png")));
			lbOk.setBounds(50, 91, 73, 52);
		}
		return lbOk;
	}
	/**
	 * Metodo que crea la etiqueta Codigo
	 * @return lbCodigo
	 */
	private JLabel getLbCodigo() {
		if (lbCodigo == null) {
			lbCodigo = new JLabel("El c\u00F3digo de recogida es:");
			lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbCodigo.setBounds(138, 172, 191, 26);
		}
		return lbCodigo;
	}
	/**
	 * Metodo que crea el textField Codigo
	 * @return txCodigo
	 */
	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txCodigo.setEditable(false);
			txCodigo.setText(pedido.getCodigo());
			txCodigo.setBounds(341, 161, 191, 45);
			txCodigo.setColumns(10);
		}
		return txCodigo;
	}
	/**
	 * Metodo que crea el textfield precio
	 * @return textFieldPrecio
	 */
	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setDisabledTextColor(Color.WHITE);
			txPrecio.setFont(new Font("Arial Black", Font.PLAIN, 16));
			txPrecio.setForeground(Color.WHITE);
			txPrecio.setBackground(Color.ORANGE);
			txPrecio.setText("Precio: 0.0");
			txPrecio.setEditable(false);
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}
	/**
	 * Metodo que crea el boton Anular
	 * @return btnAnular
	 */
	private JButton getBtnAnular1() {
		if (btnAnular1 == null) {
			btnAnular1 = new JButton("Anular");
			btnAnular1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					anularPedido();
				}
			});
			btnAnular1.setMnemonic('A');
			btnAnular1.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnAnular1.setForeground(Color.WHITE);
			btnAnular1.setBackground(Color.RED);
		}
		return btnAnular1;
	}
	/**
	 * Método que anula el pedido
	 */
	private void anularPedido() {
		modeloListaComida.removeAllElements();
		modeloListaBebida.removeAllElements();
		pedido.inicializar();
		getTxPrecio().setText("Precio: " + String.format("%.2f", pedido.getTotal()));
		getTxCodigo().setText(pedido.getCodigo());
		if(getBtnSig1().isEnabled()) {
			getBtnSig1().setEnabled(false);
		}
	}
	/**
	 * Metodo que crea el boton Siguiente
	 * @return btnSiguiente
	 */
	private JButton getBtnSig1() {
		if (btnSig1 == null) {
			btnSig1 = new JButton("Siguiente");
			btnSig1.setEnabled(false);
			btnSig1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					mostrarPn2();
				}
			});
			btnSig1.setMnemonic('S');
			btnSig1.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnSig1.setForeground(Color.WHITE);
			btnSig1.setBackground(Color.GREEN);
		}
		return btnSig1;
	}

	/**
	 * Metodo que crea el panel de pedido
	 * @return pnPedido
	 */
	private JTabbedPane getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JTabbedPane(JTabbedPane.TOP);
			pnPedido.addTab("Comida", null, getScrComida(), null);
			pnPedido.addTab("Bebida", null, getScrBebida(), null);
		}
		return pnPedido;
	}
	/**
	 * Metodo que crea el panel de scroll de Comida
	 * @return scrollPaneComida
	 */
	private JScrollPane getScrComida() {
		if (scrComida == null) {
			scrComida = new JScrollPane();
			scrComida.setViewportView(getListComida());
		}
		return scrComida;
	}
	/**
	 * Metodo que crea el panel de scroll de Bebida
	 * @return scrollPaneBebida
	 */
	private JScrollPane getScrBebida() {
		if (scrBebida == null) {
			scrBebida = new JScrollPane();
			scrBebida.setViewportView(getListBebida());
		}
		return scrBebida;
	}
	/**
	 * Método que crea la lista de Comida
	 * @return listComida
	 */
	private JList<Articulo> getListComida() {
		if (listComida == null) {
			modeloListaComida = new DefaultListModel<Articulo>();
			listComida = new JList<Articulo>(modeloListaComida);
			listComida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listComida.addKeyListener(pT);
		}
		return listComida;
	}
	/**
	 * Método que crea la lista de Bebida
	 * @return listBebida
	 */
	private JList<Articulo> getListBebida() {
		if (listBebida == null) {
			modeloListaBebida = new DefaultListModel<Articulo>();
			listBebida = new JList<Articulo>(modeloListaBebida);
			listBebida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listBebida.addKeyListener(pT);
		}
		return listBebida;
	}
	/**
	 * Método que crea el boton anterior 
	 * @return btnAnt2
	 */
	private JButton getBtnAnt2() {
		if (btnAnt2 == null) {
			btnAnt2 = new JButton("Anterior");
			btnAnt2.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					mostrarPn1();
				}
			});
			btnAnt2.setMnemonic('A');
			btnAnt2.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnAnt2.setForeground(Color.WHITE);
			btnAnt2.setBackground(Color.RED);
		}
		return btnAnt2;
	}
	/**
	 * Método que crea el boton siguiente 2
	 * @return btnSig2
	 */
	private JButton getBtnSig2() {
		if (btnSig2 == null) {
			btnSig2 = new JButton("Siguiente");
			btnSig2.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					mostrarPn3();
				}
			});
			btnSig2.setMnemonic('S');
			btnSig2.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnSig2.setForeground(Color.WHITE);
			btnSig2.setBackground(Color.GREEN);
		}
		return btnSig2;
	}	
	/**
	 * Método que crea el boton anterior 3 
	 * @return btnAnt2
	 */
	private JButton getBtnAnt3() {
		if (btnAnt3 == null) {
			btnAnt3 = new JButton("Anterior");
			btnAnt3.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					mostrarPn2();
				}
			});
			btnAnt3.setMnemonic('A');
			btnAnt3.setForeground(Color.WHITE);
			btnAnt3.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnAnt3.setBackground(Color.RED);
		}
		return btnAnt3;
	}
	/**
	 * Método que crea el boton final 
	 * @return btnFin3
	 */
	private JButton getBtnFin3() {
		if (btnFin3 == null) {
			btnFin3 = new JButton("Finalizar");
			btnFin3.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					finalizar();
				}
			});
			btnFin3.setMnemonic('F');
			btnFin3.setForeground(Color.WHITE);
			btnFin3.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnFin3.setBackground(Color.GREEN);
		}
		return btnFin3;
	}
	
	/**
	 * Titulo: Clase ProcesaTecla
	 * 
	 * @author Omitg
	 * @version 06/12/2021
	 */
	class ProcesaTecla extends KeyAdapter {
		/**
		 * Método que actua cuando hay una tecla presionada
		 * @param e
		 */
		public void keyPressed(final KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_DELETE) {
				borrarElemento(e);
			}
		}
		/**
		 * Método que borra un elemento de la lista
		 * @param e
		 */
		@SuppressWarnings("unchecked")
		private void borrarElemento(final KeyEvent e) {
			final DefaultListModel<Articulo> modelo = (DefaultListModel<Articulo>) ((JList<Articulo>)e.getSource()).getModel();
			pedido.remove(((JList<Articulo>)e.getSource()).getSelectedValue(), 1);
			getTxPrecio().setText("Precio: " + String.format("%.2f", pedido.getTotal()));
			modelo.remove(((JList<Articulo>)e.getSource()).getSelectedIndex());
			if(pedido.isVacio() && getBtnSig1().isEnabled()) {
				getBtnSig1().setEnabled(false);
			}
		}
	}
	/**
	 * Método que crea el panel de filtros 
	 * @return pnFitro
	 */
	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.setLayout(new GridLayout(5, 1, 0, 0));
			pnFiltro.add(getBtnTodos());
			pnFiltro.add(getBtnHamburguesas());
			pnFiltro.add(getBtnBebidas());
			pnFiltro.add(getBtnComplementos());
			pnFiltro.add(getBtnPostres());
		}
		return pnFiltro;
	}
	/**
	 * Método que crea  el boton de todos
	 * @return btnTodos
	 */
	private JButton getBtnTodos() {
		if (btnTodos == null) {
			btnTodos = new JButton("Todos");
			btnTodos.setMnemonic('T');
			btnTodos.setBackground(Color.WHITE);
			btnTodos.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					deshabilitar("Todos");
				}
			});
			btnTodos.setHorizontalTextPosition(SwingConstants.CENTER);
			btnTodos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnTodos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Todo.png")));
		}
		return btnTodos;
	}
	/**
	 * Método que deshabilita
	 * @param Str 
	 */
	private void deshabilitar(final String str) {
		if(str.equals("Todos")) {
			for(int i = 0; i < getPnArticulos().getComponentCount(); i++) {
				getPnArticulos().getComponent(i).setEnabled(true);
			}
		}
		
	}
	/**
	 * Método que crea el boton de hamburguesas
	 * @return btnHamburguesas
	 */
	private JButton getBtnHamburguesas() {
		if (btnHamburguesas == null) {
			btnHamburguesas = new JButton("Hamburguesas");
			btnHamburguesas.setMnemonic('H');
			btnHamburguesas.setBackground(Color.WHITE);
			btnHamburguesas.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					deshabilitar("Hamburguesa");
				}
			});
			btnHamburguesas.setHorizontalTextPosition(SwingConstants.CENTER);
			btnHamburguesas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnHamburguesas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Hamburguesa.png")));
		}
		return btnHamburguesas;
	}
	/**
	 * Método que crea el boton de bebidas
	 * @return btnBebidas
	 */
	private JButton getBtnBebidas() {
		if (btnBebidas == null) {
			btnBebidas = new JButton("Bebidas");
			btnBebidas.setMnemonic('B');
			btnBebidas.setBackground(Color.WHITE);
			btnBebidas.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					deshabilitar("Bebida");
				}
			});
			btnBebidas.setHorizontalTextPosition(SwingConstants.CENTER);
			btnBebidas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBebidas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Bebida.png")));
		}
		return btnBebidas;
	}
	/**
	 * Método que crea el boton de complementos
	 * @return btnComplementos
	 */
	private JButton getBtnComplementos() {
		if (btnComplementos == null) {
			btnComplementos = new JButton("Complementos");
			btnComplementos.setMnemonic('C');
			btnComplementos.setBackground(Color.WHITE);
			btnComplementos.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					deshabilitar("Complemento");
				}
			});
			btnComplementos.setHorizontalTextPosition(SwingConstants.CENTER);
			btnComplementos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnComplementos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Complemento.png")));
		}
		return btnComplementos;
	}
	/**
	 * Método que crea el boton de postres 
	 * @return btnPostres
	 */
	private JButton getBtnPostres() {
		if (btnPostres == null) {
			btnPostres = new JButton("Postres");
			btnPostres.setMnemonic('P');
			btnPostres.setBackground(Color.WHITE);
			btnPostres.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					deshabilitar("Postre");
				}
			});
			btnPostres.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Postre.png")));
		}
		return btnPostres;
	}
}