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

/**
 * Titulo: Clase VentanaPrincipal
 * 
 * @author UO281847
 * @version 25//11/2021
 */
public class VentanaPrincipal extends JFrame {
	/**
	 * Constante serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo 
	 */
	private AccionBoton aB;
	/**
	 * Atributo 
	 */
	private JPanel contentPane;
	/**
	 * Atributo 
	 */
	private JLabel lblLogo;
	/**
	 * Atributo 
	 */
	private JLabel lblNombre;
	/**
	 * Atributo 
	 */
	private Carta carta;
	/**
	 * Atributo 
	 */
	private Pedido pedido;
	/**
	 * Atributo 
	 */
	private JPanel pnInfo1;
	/**
	 * Atributo 
	 */
	private JPanel pnlLogo;
	/**
	 * Atributo 
	 */
	private JPanel pnArticulos;
	/**
	 * Atributo 
	 */
	private JPanel pnBts1;
	/**
	 * Atributo 
	 */
	private JPanel pnBts2;
	/**
	 * Atributo 
	 */
	private JPanel pnBts3;
	/**
	 * Atributo 
	 */
	private JPanel pnContenidos;
	/**
	 * Atributo 
	 */
	private JPanel pn2;
	/**
	 * Atributo 
	 */
	private JPanel pn3;
	/**
	 * Atributo 
	 */
	private JPanel pnDatosCliente;
	/**
	 * Atributo 
	 */
	private JLabel lbNombre;
	/**
	 * Atributo 
	 */
	private JTextField txtNombre;
	/**
	 * Atributo 
	 */
	private JLabel lbAño;
	/**
	 * Atributo 
	 */
	private JComboBox<String> cbAños;
	/**
	 * Atributo 
	 */
	private JLabel lbPasw1;
	/**
	 * Atributo 
	 */
	private JPasswordField psw1;
	/**
	 * Atributo 
	 */
	private JLabel lbPasw2;
	/**
	 * Atributo 
	 */
	private JPasswordField psw2;
	/**
	 * Atributo 
	 */
	private JPanel pn1;
	/**
	 * Atributo 
	 */
	private JPanel pnFormulario;
	/**
	 * Atributo 
	 */
	private JPanel pnDatosPedido;
	/**
	 * Atributo 
	 */
	private JRadioButton rbLocal;
	/**
	 * Atributo 
	 */
	private JRadioButton rbLlevar;
	/**
	 * Atributo 
	 */
	private JPanel pnInfo2;
	/**
	 * Atributo 
	 */
	private JPanel pnConfirmacion;
	/**
	 * Atributo 
	 */
	private JPanel pnInfo3;
	/**
	 * Atributo 
	 */
	private JLabel lbAviso;
	/**
	 * Atributo 
	 */
	private JLabel lbOk;
	/**
	 * Atributo 
	 */
	private JLabel lbCodigo;
	/**
	 * Atributo 
	 */
	private JTextField txCodigo;	
	/**
	 * Atributo 
	 */
	private JTextField textFieldPrecio;
	/**
	 * Atributo 
	 */
	private JButton btnAnular;
	/**
	 * Atributo 
	 */
	private JButton btnSiguiente;
	/**
	 * Atributo 
	 */
	private JTabbedPane pnPedido;
	/**
	 * Atributo 
	 */
	private JScrollPane scrollPaneComida;
	/**
	 * Atributo 
	 */
	private JScrollPane scrollPaneBebida;
	/**
	 * Atributo 
	 */
	private JList<Articulo> listComida;
	/**
	 * Atributo 
	 */
	private JList<Articulo> listBebida;
	/**
	 * Atributo 
	 */
	private final ButtonGroup grPedido = new ButtonGroup();


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Carta carta, Pedido pedido) {
		this.carta = carta;
		this.pedido = pedido;
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				asociaImagenBotones();
			}
		});		
		aB = new AccionBoton();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		setTitle("McDonald's España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 820);
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
	 * @return lblNombre
	 */
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("McDonald's");
			lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lblNombre.setForeground(Color.BLACK);
		}
		return lblNombre;
	}

	/**
	 * Método que inicializa el programa
	 */
	protected void inicializar() {
		pedido.inicializar();
		//COMPLETAR
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
			pnInfo1.add(getPnPedido(), BorderLayout.NORTH);
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
			pnlLogo.add(getLblNombre());
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
			// COMPLETAR 1
			pnArticulos.setLayout(new GridLayout(0, 6, 3, 3));
			creaBotonesTablero();	
		}
		return pnArticulos;
	}
	
	/**
	 * Método que crea botones para el tablero
	 */
	private void creaBotonesTablero() {
		getPnArticulos().removeAll();
		for (int i=0; i<carta.getListaArticulos().size(); i++) {
			pnArticulos.add(nuevoBoton(i));
		}
	}
	
	/**
	 * Método que reescala la imagen
	 * @param boton
	 * @param rutaImagen
	 */
	private void setImagenAdaptada(JButton boton, String rutaImagen){
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(),boton.getHeight(), Image.SCALE_SMOOTH);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 boton.setIcon(icon);
	}
	
	/**
	 * Método que asocia imagenes a botones
	 */
	private void asociaImagenBotones() {
		for (int i = 0; i < pnArticulos.getComponents().length; i++)
		{
			JButton boton = (JButton) (pnArticulos.getComponents()[i]);
			setImagenAdaptada(boton,"/img/" + carta.getListaArticulos().get(i).getCodigo()+".png");
		}
	}
	
	/**
	 * Método que crea un nuevo boton
	 * @param posicion
	 * @return boton
	 */
	private JButton nuevoBoton(Integer posicion) {
		JButton boton = new JButton("");
		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setToolTipText(carta.getListaArticulos().get(posicion).toString());
		boton.setActionCommand(posicion.toString());		
		//boton.addActionListener(aB);
		return boton;
	}
	
	/**
	 * Titulo: Clase Eventos AccionBoton
	 * 
	 * @author UO281847
	 * @version 25/11/2021
	 */
	class AccionBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			añadirAPedido(Integer.parseInt(bt.getActionCommand()));
		}
	}
	
	/**
	 * Método que añade al pedido
	 * @param posArticuloEnCarta
	 */
	//COMPLETAR 2
	private void añadirAPedido(int posArticuloEnCarta) {
		
	}
	
	/**
	 * Método que muestra en la lista
	 * @param a
	 */
	//COMPLETAR 3
	private void mostrarEnLista(Articulo a) {
		
	}
	
	/**
	 * Método que muestra en el panel 1
	 */
	//COMPLETAR 4
	private void mostrarPn1() {
	}
	
	/**
	 * Método que muestra en el panel 2
	 */
	private void mostrarPn2() {
	}
	
	/**
	 * Método que muestra en el panel 3
	 */
	private void mostrarPn3() {
		if (comprobarCampos())
		{   
			// COMPLETAR
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
			pnBts1.add(getTextFieldPrecio());
			pnBts1.add(getBtnAnular());
			pnBts1.add(getBtnSiguiente());
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
	 * Método que crea el combobox de años
	 * @return cbAños
	 */
	private JComboBox<String> getCbAños() {
		if (cbAños == null) {
			String[]años = new String[90];
			for (int i=0;i<90;i++){
				String año = ""+((90-i)+1920);
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
	 * Método que devuelve el panel de datos del cliente
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
	 * Método que crea el text field del nombre
	 * @return txtNombre
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
	 * Método que crea la etiqueta año
	 * @return lblAño
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
	 * Método que crea la etiqueta de la password
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
	 * Método que crea la password 
	 * @return psw1
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
	 * Método que crea la etiqueta password 2 
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
	 * Método que crea la password 2
	 * @return psw2
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
		}
		return pn1;
	}
	
	/**
	 * Método que crea el panel del formulario
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
	 * Método que crea el panel de datos del pedido
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
	 * Método que crea el radio boton local
	 * @return rbLocal
	 */
	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton();
			rbLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
	 * Método que crea el radio boton llevar
	 */
	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton();
			rbLlevar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
	 * Método que crea el panel de informacion 2
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
	 * Método que crea el panel de confirmación
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
	 * Método que crea el panel de info 3
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
		//COMPLETAR
	}
	
	/**
	 * Método que crea la etiqueta de aviso
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
	 * Método que crea la etiqueta ok
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
	 * Método que crea la etiqueta codigo
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
	 * Método que crea el textfield codigo
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
	 * Método que crea el textfield precio
	 * @return textFieldPrecio
	 */
	private JTextField getTextFieldPrecio() {
		if (textFieldPrecio == null) {
			textFieldPrecio = new JTextField();
			textFieldPrecio.setEditable(false);
			textFieldPrecio.setText("Precio: 0.0");
			textFieldPrecio.setColumns(10);
		}
		return textFieldPrecio;
	}
	/**
	 * Método que crea el boton de anular
	 * @return btnAnular
	 */
	private JButton getBtnAnular() {
		if (btnAnular == null) {
			btnAnular = new JButton("Anular");
			btnAnular.setMnemonic('A');
		}
		return btnAnular;
	}
	/**
	 * Método que crea el boton siguiente
	 * @return btnSiguiente
	 */
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setMnemonic('S');
		}
		return btnSiguiente;
	}
	/**
	 * Método que crea el panel del pedido
	 * @return pnPedido
	 */
	private JTabbedPane getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JTabbedPane(JTabbedPane.TOP);
			pnPedido.addTab("Comida", null, getScrollPaneComida(), null);
			pnPedido.addTab("Bebida", null, getScrollPaneBebida(), null);
		}
		return pnPedido;
	}
	
	/**
	 * Método que crea el scrollPane comida
	 * @return scrollPaneComida
	 */
	private JScrollPane getScrollPaneComida() {
		if (scrollPaneComida == null) {
			scrollPaneComida = new JScrollPane();
			scrollPaneComida.setViewportView(getListComida());
		}
		return scrollPaneComida;
	}
	
	/**
	 * Método que crea el scrollPane bebida
	 * @return scrollPaneBebida
	 */
	private JScrollPane getScrollPaneBebida() {
		if (scrollPaneBebida == null) {
			scrollPaneBebida = new JScrollPane();
			scrollPaneBebida.setViewportView(getListBebida());
		}
		return scrollPaneBebida;
	}
	
	/**
	 * Método que crea la lista de comida 
	 * @return listComida
	 */
	private JList<Articulo> getListComida() {
		if (listComida == null) {
			listComida = new JList<Articulo>();
		}
		return listComida;
	}
	
	/**
	 * Método que crea la lista de bebida 
	 * @return listBebida
	 */
	private JList<Articulo> getListBebida() {
		if (listBebida == null) {
			listBebida = new JList<Articulo>();
		}
		return listBebida;
	}
}
