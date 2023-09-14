package igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Articulo;
import logica.Juego;
import logica.Producto;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = -7580081883960159787L;
	private Juego juego;
	private Producto producto;
	
	private JPanel contentPane;
	private JButton btnRuleta;
	private JLabel lblTitulo;
	private JLabel lblRuleta;
	private JTextField txtPuntos;
	private JLabel lblPuntos;
	private JComboBox<Articulo> cbArticulos;
	private JLabel lblArticulos;
	private JButton btnFinalizar;
	private JButton btnAñadir;
	private JLabel lblImagenArticulo;
	private JScrollPane scrollPaneProductos;
	private JTextArea textAreaProductos;
	private JLabel lblTusArticulos;
	private JButton btnElectronica;
	private JPanel panelFiltro;
	private JButton btnOcio;
	private JButton btnInfantil;
	private JButton btnTodos;
	private JLabel lblAviso;
	private JMenuBar menuBarRuleta;
	private JMenu mnJuego;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmNewMenuItem;
	private JSeparator separator;
	private JMenuItem mntmAcercaDe;

	/**
	 * Create the frame.
	 * @param producto 
	 * @param pedido 
	 */
	public VentanaPrincipal(Juego juego, Producto producto) {		
		this.juego = juego;
		this.producto = producto;		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/ruleta.png")));
		setResizable(false);
		setTitle("Ruleta de Premios");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 525);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnRuleta());
		contentPane.add(getLblTitulo());
		contentPane.add(getLblRuleta());
		contentPane.add(getTxtPuntos());
		contentPane.add(getLblPuntos());
		contentPane.add(getCbArticulos());
		contentPane.add(getLblArticulos());
		contentPane.add(getBtnFinalizar());
		contentPane.add(getBtnAñadir());
		contentPane.add(getLblImagenArticulo());
		contentPane.add(getScrollPaneProductos());
		contentPane.add(getLblTusArticulos());
		contentPane.add(getPanelFiltro());
		contentPane.add(getLblAviso());
	}
	private JButton getBtnRuleta() {
		if (btnRuleta == null) {
			btnRuleta = new JButton("");
			btnRuleta.setMnemonic('P');
			btnRuleta.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ruleta.png")));
			btnRuleta.setBorder(null);
			btnRuleta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calcularPuntos();
					habilitarBotones();
				}
			});
			btnRuleta.setToolTipText("Presione la ruleta para conseguir puntos");
			btnRuleta.setBackground(Color.WHITE);
			btnRuleta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ruleta.png")));
			btnRuleta.setBounds(10, 99, 214, 222);
		}
		return btnRuleta;
	}
	private void calcularPuntos() {
		juego.lanzar();
		getTxtPuntos().setText(String.valueOf(juego.getPuntos()));
		getBtnRuleta().setEnabled(false);
	}
	private void habilitarBotones() {
		getBtnAñadir().setEnabled(true);
		getCbArticulos().setEnabled(true);
		getBtnElectronica().setEnabled(true);
		getBtnInfantil().setEnabled(true);
		getBtnOcio().setEnabled(true);
		getBtnTodos().setEnabled(true);
	}
	private JComboBox<Articulo> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			cbArticulos.setEnabled(false);
			cbArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					actualizarImagen((Articulo) getCbArticulos().getSelectedItem());
					getLblAviso().setText("");
				}
			});
			cbArticulos.setToolTipText("Presione para ver la lista de articulos");
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(producto.getArticulos()));
			cbArticulos.setBounds(412, 162, 341, 31);
		}
		return cbArticulos;
	}
	protected void actualizarImagen(Articulo arti) {
		getLblImagenArticulo().setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/"+String.valueOf(arti.getCodigo())+".png")));
		getLblImagenArticulo().setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/"+String.valueOf(arti.getCodigo())+".png")));
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("RULETA DE PREMIOS");
			lblTitulo.setForeground(Color.RED);
			lblTitulo.setFont(new Font("Bell MT", Font.BOLD, 28));
			lblTitulo.setBounds(451, 11, 302, 31);
		}
		return lblTitulo;
	}
	private JLabel getLblRuleta() {
		if (lblRuleta == null) {
			lblRuleta = new JLabel("Presione la Ruleta");
			lblRuleta.setLabelFor(getBtnRuleta());
			lblRuleta.setDisplayedMnemonic('P');
			lblRuleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRuleta.setBounds(57, 74, 114, 14);
		}
		return lblRuleta;
	}
	private JTextField getTxtPuntos() {
		if (txtPuntos == null) {
			txtPuntos = new JTextField();
			txtPuntos.setToolTipText("Puntos conseguidos!");
			txtPuntos.setForeground(Color.RED);
			txtPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntos.setFont(new Font("Tahoma", Font.PLAIN, 30));
			txtPuntos.setEditable(false);
			txtPuntos.setBounds(57, 382, 114, 54);
			txtPuntos.setColumns(10);
		}
		return txtPuntos;
	}
	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("Puntos");
			lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPuntos.setBounds(82, 358, 58, 13);
		}
		return lblPuntos;
	}	
	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Articulos:");
			lblArticulos.setLabelFor(getCbArticulos());
			lblArticulos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblArticulos.setDisplayedMnemonic('A');
			lblArticulos.setBounds(412, 134, 114, 17);
		}
		return lblArticulos;
	}
	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.setFocusPainted(false);
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "!Feliciades por el premio!", "Ruleta de regalos: Fin", JOptionPane.INFORMATION_MESSAGE);
					deshabilitaBotones();										
				}
			});
			btnFinalizar.setBackground(Color.RED);
			btnFinalizar.setForeground(Color.BLACK);
			btnFinalizar.setFont(new Font("Arial", Font.BOLD, 23));
			btnFinalizar.setMnemonic('F');
			btnFinalizar.setToolTipText("Pulse para finalizar");
			btnFinalizar.setBounds(903, 389, 197, 46);
		}
		return btnFinalizar;
	}
	protected void deshabilitaBotones() {		
		for (int i = 0; i<contentPane.getComponentCount();i++) {
			contentPane.getComponent(i).setEnabled(false);
		}
		for (int i = 0; i<getPanelFiltro().getComponentCount(); i++) {
			getPanelFiltro().getComponent(i).setEnabled(false);
		}
	}
	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("A\u00F1adir");
			btnAñadir.setFocusPainted(false);
			btnAñadir.setEnabled(false);
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirArticulos();					
				}
			});
			btnAñadir.setBackground(Color.GREEN);
			btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnAñadir.setToolTipText("Presione para a\u00F1adir al pedido");
			btnAñadir.setBounds(777, 162, 89, 27);
		}
		return btnAñadir;
	}
	protected void añadirArticulos() {
		Articulo arti = (Articulo) getCbArticulos().getSelectedItem();
		float puntos = juego.getPuntos();
		if (arti.getPuntos()<=puntos) {
			juego.add(arti, 1);
			juego.setPuntos(puntos-arti.getPuntos());
			getTxtPuntos().setText(String.valueOf(juego.getPuntos()));
		} else {
			getLblAviso().setText("No tiene puntos suficientes para este articulo");
		}
		String lista = juego.productosToString();
		getTextAreaProductos().setText(lista);
	}
	private JLabel getLblImagenArticulo() {
		if (lblImagenArticulo == null) {
			lblImagenArticulo = new JLabel("");
			lblImagenArticulo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/EL01.png")));
			lblImagenArticulo.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/EL01.png")));
			lblImagenArticulo.setBounds(516, 250, 151, 150);
		}
		return lblImagenArticulo;
	}
	private JScrollPane getScrollPaneProductos() {
		if (scrollPaneProductos == null) {
			scrollPaneProductos = new JScrollPane();
			scrollPaneProductos.setBounds(893, 164, 226, 194);
			scrollPaneProductos.setViewportView(getTextAreaProductos());
		}
		return scrollPaneProductos;
	}
	private JTextArea getTextAreaProductos() {
		if (textAreaProductos == null) {
			textAreaProductos = new JTextArea();
			textAreaProductos.setBackground(Color.LIGHT_GRAY);
			textAreaProductos.setToolTipText("La lista de los articulos que has seleccionado");
			textAreaProductos.setEditable(false);
		}
		return textAreaProductos;
	}
	private JLabel getLblTusArticulos() {
		if (lblTusArticulos == null) {
			lblTusArticulos = new JLabel("Tus Articulos:");
			lblTusArticulos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTusArticulos.setDisplayedMnemonic('A');
			lblTusArticulos.setBounds(971, 134, 82, 17);
		}
		return lblTusArticulos;
	}
	private JPanel getPanelFiltro() {
		if (panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.setBounds(241, 74, 102, 362);
			panelFiltro.setLayout(new GridLayout(4, 1, 0, 0));
			panelFiltro.add(getBtnElectronica());
			panelFiltro.add(getBtnInfantil());
			panelFiltro.add(getBtnOcio());
			panelFiltro.add(getBtnTodos());
		}
		return panelFiltro;
	}
	private void filtraArticulos(String tipo) {
		getCbArticulos().setModel(new DefaultComboBoxModel<Articulo>(producto.getArticulosFiltro(tipo)));
		actualizarImagen((Articulo) getCbArticulos().getSelectedItem());
	}
	private JButton getBtnElectronica() {
		if (btnElectronica == null) {
			btnElectronica = new JButton("Electronica");
			btnElectronica.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoElectronica.png")));
			btnElectronica.setEnabled(false);
			btnElectronica.setToolTipText("Ver articulos de \"Electronica\"");
			btnElectronica.setFocusPainted(false);
			btnElectronica.setFocusTraversalPolicyProvider(true);
			btnElectronica.setFocusCycleRoot(true);
			btnElectronica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtraArticulos("Electronica");
				}
			});
			btnElectronica.setHorizontalTextPosition(SwingConstants.CENTER);
			btnElectronica.setMnemonic('E');
			btnElectronica.setBackground(Color.WHITE);
			btnElectronica.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoElectronica.png")));
			btnElectronica.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnElectronica.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return btnElectronica;
	}	
	private JButton getBtnOcio() {
		if (btnOcio == null) {
			btnOcio = new JButton("Ocio");
			btnOcio.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoOcio.png")));
			btnOcio.setEnabled(false);
			btnOcio.setToolTipText("Ver articulos de \"Ocio\"");
			btnOcio.setFocusPainted(false);
			btnOcio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtraArticulos("Ocio");
				}
			});
			btnOcio.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoOcio.png")));
			btnOcio.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnOcio.setVerticalAlignment(SwingConstants.BOTTOM);
			btnOcio.setMnemonic('O');
			btnOcio.setHorizontalTextPosition(SwingConstants.CENTER);
			btnOcio.setBackground(Color.WHITE);
		}
		return btnOcio;
	}
	private JButton getBtnInfantil() {
		if (btnInfantil == null) {
			btnInfantil = new JButton("Infantil");
			btnInfantil.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoInfantil.png")));
			btnInfantil.setEnabled(false);
			btnInfantil.setToolTipText("Ver articulos de \"Infantil\"");
			btnInfantil.setFocusPainted(false);
			btnInfantil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtraArticulos("Infantil");
				}
			});
			btnInfantil.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoInfantil.png")));
			btnInfantil.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnInfantil.setVerticalAlignment(SwingConstants.BOTTOM);
			btnInfantil.setMnemonic('I');
			btnInfantil.setHorizontalTextPosition(SwingConstants.CENTER);
			btnInfantil.setBackground(Color.WHITE);
		}
		return btnInfantil;
	}
	private JButton getBtnTodos() {
		if (btnTodos == null) {
			btnTodos = new JButton("Todos");
			btnTodos.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/\u00EDndice_opt.jpg")));
			btnTodos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/\u00EDndice_opt.jpg")));
			btnTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getCbArticulos().setModel(new DefaultComboBoxModel<Articulo>(producto.getArticulos()));					 
					actualizarImagen((Articulo) getCbArticulos().getSelectedItem());					
				}
			});
			btnTodos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnTodos.setVerticalAlignment(SwingConstants.BOTTOM);
			btnTodos.setToolTipText("Ver articulos de \"Ocio\"");
			btnTodos.setMnemonic('T');
			btnTodos.setHorizontalTextPosition(SwingConstants.CENTER);
			btnTodos.setFocusPainted(false);
			btnTodos.setEnabled(false);
			btnTodos.setBackground(Color.WHITE);
		}
		return btnTodos;
	}
	private JLabel getLblAviso() {
		if (lblAviso == null) {
			lblAviso = new JLabel("");
			lblAviso.setForeground(Color.RED);
			lblAviso.setFont(new Font("Tahoma", Font.ITALIC, 11));
			lblAviso.setBounds(422, 204, 331, 27);
		}
		return lblAviso;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBarRuleta == null) {
			menuBarRuleta = new JMenuBar();
			menuBarRuleta.add(getMnJuego());
		}
		return menuBarRuleta;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('J');
			mnJuego.add(getMntmNuevo());
			mnJuego.add(getMntmNewMenuItem());
			mnJuego.add(getMntmAcercaDe());
			mnJuego.add(getSeparator());
		}
		return mnJuego;
	}
	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("Nuevo");
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					juego.inicializar();
					getTxtPuntos().setText("");
					deshabilitaBotones();
					habilitaTrasNuevo();
				}
			});
			mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			mntmNuevo.setMnemonic('N');
		}
		return mntmNuevo;
	}
	private void habilitaTrasNuevo() {
		getBtnRuleta().setEnabled(true);
		getBtnFinalizar().setEnabled(true);
		getTxtPuntos().setEnabled(true);
		getLblPuntos().setEnabled(true);
		getLblRuleta().setEnabled(true);
		getLblArticulos().setEnabled(true);
		getLblTusArticulos().setEnabled(true);
		getLblTitulo().setEnabled(true);
		getLblAviso().setEnabled((true));
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Salir");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (confirmaSalida()) {
						System.exit(0);
					}
				}
			});
			mntmNewMenuItem.setMnemonic('S');
			mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmNewMenuItem;
	}
	private boolean confirmaSalida() {
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro de que quiere salir de la aplicación?");
		if (respuesta == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Omar Teixeira González\nDNI: 32892095W", "Ruleta de Premios: Acerca de", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAcercaDe.setMnemonic('A');
		}
		return mntmAcercaDe;
	}
}
