package graphic_interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logic.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * T�tulo: Clase VentanaInicio
 * Descripci�n: Clase que crea la ventana de inicio del programa, comenzando en
 * la selecci�n del idioma, para posteriormente ir a la comprobacion del c�digo
 * de la tarjeta del usuario a jugar.
 *
 * @author Omar Teixeira, UO281847
 * @version 28 dic. 2021
 */
public class VentanaInicio extends JFrame {	
//-- CONSTANTES ----------------------------------------------------------------
	/**
	 * Constante serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constante INTERN_FILE
	 */
	private static final String INTERN_FILE = "resources/textos";
	/**
	 * Constante ECI_LOGO
	 */
	private static final String ECI_LOGO = "/images/ECI_logo.png";
	/**
	 * Constante ID_LENGTH
	 */
	private static final int ID_LENGTH = 6;
	/**
	 * Constante PUEDE_JUGAR	
	 */
	private static final int PUEDE_JUGAR = 0;
	/**
	 * Constante NO_PUEDE_JUGAR
	 */
	private static final int NO_PUEDE_JUGAR = -1;
	/**
	 * Constante NO_ESTA
	 */
	private static final int NO_ESTA = -2;
	/**
	 * Constante RECORTAR_IMAGENES
	 */
	private static final int RECORTAR_IMAGENES = 30;
//-- ATRIBUTOS -----------------------------------------------------------------
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo game
	 */
	private Game game;
	//-- Eventos ---------------------------------------------------------------
	/**
	 * Atributo pT
	 */
	private ProcesaTecla pT;
	/**
	 * Atributo cTS
	 */
	private ChangeToSpanish cTS;
	/**
	 * Atributo cTE
	 */
	private ChangeToEnglish cTE;
	//-- Internacionalizaci�n --------------------------------------------------
	/**
	 * Atributo localizacion
	 */
	private Locale localizacion;
	/**
	 * Atributo textos
	 */
	private ResourceBundle textos;
	/**
	 * Atributo panelInternacionalizacion
	 */
	private JPanel panelInternacionalizacion;
	/**
	 * Atributo btnSiguienteInter
	 */
	private JButton btnSiguienteInter;
	/**
	 * Atributo lblIdioma
	 */
	private JLabel lblIdioma;
	/**
	 * Atributo lblLogo
	 */
	private JLabel lblLogoInternacionalizacion;
	/**
	 * Atributo btnEspa�ol
	 */
	private JButton btnEspa�ol;
	/**
	 * Atributo btnIngles
	 */
	private JButton btnIngles;
	//-- C�digo ----------------------------------------------------------------
	/**
	 * Atributo panelCodigo
	 */
	private JPanel panelCodigo;
	/**
	 * Atributo lblTarjeta
	 */
	private JLabel lblTarjeta;
	/**
	 * Atributo panelLblCodigo
	 */
	private JPanel panelLblCodigo;
	/**
	 * Atributo lblCodigo
	 */
	private JLabel lblCodigo;
	/**
	 * Atributo lblCodigo2
	 */
	private JLabel lblCodigo2;
	/**
	 * Atributo btnSiguienteCodigo	
	 */
	private JButton btnSiguienteCodigo;
	/**
	 * Atributo btnAnteriorCodigo
	 */
	private JButton btnAnteriorCodigo;
	/**
	 * Atributo textFieldCodigo	
	 */
	private JTextField textFieldCodigo;
	//-- Bienvenida ------------------------------------------------------------
	/**
	 * Atributo panelBienvenida
	 */
	private JPanel panelBienvenida;
	
	/**
	 * Atributo btnSiguienteBienvenida
	 */
	private JButton btnSiguienteBienvenida;
	/**
	 * Atributo panelLblBienvenida
	 */
	private JPanel panelLblBienvenida;
	/**
	 * Atributo lblNombre
	 */
	private JLabel lblNombre;
	/**
	 * Atributo lblBienvenida
	 */
	private JLabel lblBienvenida;
	/**
	 * Atributo lblLogoBienvenida
	 */
	private JLabel lblLogoBienvenida;
	/**
	 * Atributo panelLblInstrucciones
	 */
	private JPanel panelLblInstrucciones;
	/**
	 * Atributo lblInstrucciones
	 */
	private JLabel lblInstrucciones;
	/**
	 * Atributo lblAvisoEstrella
	 */
	private JLabel lblAvisoEstrella;
	/**
	 * Atributo lblAyuda
	 */
	private JLabel lblAyuda;
	/**
	 * Atributo lblInterrogacion
	 */
	private JLabel lblInterrogacion;
	//-- Menus -----------------------------------------------------------------
	/**
	 * Atributo menuBarPrincipal
	 */
	private JMenuBar menuBarInicio;
	/**
	 * Atributo mnJuego
	 */
	private JMenu mnJuego;
	/**
	 * Atributo mntmNuevo
	 */
	private JMenuItem mntmNuevo;
	/**
	 * Atributo mntmSalir
	 */
	private JMenuItem mntmSalir;
	/**
	 * Atributo mnIdioma
	 */
	private JMenu mnIdioma;
	/**
	 * Atributo mntmEspa�ol
	 */
	private JMenuItem mntmEspa�ol;
	/**
	 * Atributo mntmIngles
	 */
	private JMenuItem mntmIngles;
	/**
	 * Atributo mnAyuda
	 */
	private JMenu mnAyuda;
	/**
	 * Atributo mntmContenidos
	 */
	private JMenuItem mntmContenidos;
	/**
	 * Atributo mntmAcercaDe
	 */
	private JMenuItem mntmAcercaDe;	
		
	/**
	 * M�todo que crea la ventana inicial, comenzando en el seleccionador del idioma
	 * 
	 * @param game, juego
	 */
	public VentanaInicio(Game game) {		
		this.game = game;
		
		this.localizacion = Locale.getDefault(Locale.Category.FORMAT);
		this.textos = ResourceBundle.getBundle(INTERN_FILE, localizacion);
		
		this.pT = new ProcesaTecla();
		this.cTS = new ChangeToSpanish();
		this.cTE= new ChangeToEnglish();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (confirmExit()) {
					System.exit(0);
				}
			}
		});			
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBarInicio());
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource(ECI_LOGO)));		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new LineBorder(new Color(165, 42, 42), 7, true));		
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelInternacionalizacion(), "name_216429699754700");
		contentPane.add(getPanelCodigo(), "name_216429705933100");
		contentPane.add(getPanelBienvenida(), "name_301275162171900");
		getRootPane().setDefaultButton(getBtnSiguienteInter());
		
		loadHelp();
		setTexts(localizacion);
	}
	
	/**
	 * M�todo que reinicia la aplicaci�n
	 */
	public void restart() {		
		localizacion = Locale.getDefault(Locale.Category.FORMAT);
		setTexts(localizacion);
		((CardLayout) getContentPane().getLayout()).first(contentPane);
		getRootPane().setDefaultButton(getBtnSiguienteInter());
		getTextFieldCodigo().setText("");
		getBtnSiguienteCodigo().setEnabled(false);
		game.startGame();
		this.setVisible(true);
	}
	
	/**
	 * M�todo que carga la ayuda
	 */
	private void loadHelp(){
		URL hsURL;
	    HelpSet hs;
	
	     try {
	             File fichero = new File("help/Ayuda.hs");
	             hsURL = fichero.toURI().toURL();
	             hs = new HelpSet(null, hsURL);
	           }	
	     catch (Exception e){
	       System.out.println("No se ha encontrado la ayuda.");
	       System.out.println(e.getMessage());
	
	       return;
	    }
	
	    HelpBroker hb = hs.createHelpBroker();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Point p = new Point((int)screenSize.getWidth()/4,(int)screenSize.getHeight()/4);
	    hb.setLocation(p);
	    hb.setSize(new Dimension(900, 1000));
	    hb.initPresentation();
	
	    hb.enableHelpKey(getRootPane(),"Introduccion", hs);
	    hb.enableHelpOnButton(getMntmContenidos(), "Introduccion", hs);
	    hb.enableHelp(getTextFieldCodigo(), "Introduccion del codigo", hs);
	    hb.enableHelp(getBtnEspa�ol(), "Seleccion de idioma", hs);
	    hb.enableHelp(getBtnIngles(), "Seleccion de idioma", hs);
	}
	
//-- INTERNACIONALIZACI�N ------------------------------------------------------
	/**
	 * M�todo que setea los textos seg�n su localizaci�n
	 * 
	 * @param localizacion, localizaci�n del usuario
	 */
	private void setTexts(Locale localizacion) {
		textos = ResourceBundle.getBundle(INTERN_FILE, localizacion);
		
		setTitle(textos.getString("tituloIdioma"));
		
		//-- Seleccion de Idioma
		getBtnSiguienteInter().setText(textos.getString("btnSiguiente"));
		getBtnSiguienteInter().setMnemonic(Integer.parseInt(textos.getString("mnemonicoSiguiente")));
		getBtnSiguienteInter().setToolTipText(textos.getString("toolTipSiguiente"));
		
		getLblIdioma().setText(textos.getString("lblIdioma"));
		
		getBtnEspa�ol().setText(textos.getString("btnEspa�ol"));
		getBtnEspa�ol().setMnemonic(Integer.parseInt(textos.getString("mnemonicoEspa�ol")));
		getBtnEspa�ol().setToolTipText(textos.getString("toolTipEspa�ol"));
		
		getBtnIngles().setText(textos.getString("btnIngles"));
		getBtnIngles().setMnemonic(Integer.parseInt(textos.getString("mnemonicoIngles")));
		getBtnIngles().setToolTipText(textos.getString("toolTipIngles"));
		
		//-- Introducir el c�digo
		getBtnSiguienteCodigo().setText(textos.getString("btnSiguiente"));
		getBtnSiguienteCodigo().setMnemonic(Integer.parseInt(textos.getString("mnemonicoSiguiente")));
		getBtnSiguienteCodigo().setToolTipText(textos.getString("toolTipSiguiente"));
		
		getBtnAnteriorCodigo().setText(textos.getString("btnAnterior"));
		getBtnAnteriorCodigo().setMnemonic(Integer.parseInt(textos.getString("mnemonicoAnterior")));
		getBtnAnteriorCodigo().setToolTipText(textos.getString("toolTipAnterior"));
		
		getLblCodigo().setText(textos.getString("lblCodigo"));
		getLblCodigo().setDisplayedMnemonic(Integer.parseInt(textos.getString("mnemonicoCodigo")));
		getLblCodigo2().setText(textos.getString("lblCodigo2"));
		
		getTextFieldCodigo().setToolTipText(textos.getString("toolTipTextFieldCodigo"));
		
		//-- Bienvenida
		getBtnSiguienteBienvenida().setText(textos.getString("btnSiguiente"));
		getBtnSiguienteBienvenida().setMnemonic(Integer.parseInt(textos.getString("mnemonicoSiguiente")));
		getBtnSiguienteBienvenida().setToolTipText(textos.getString("toolTipSiguiente"));
		
		//Aqu� deber�a de ir la escritua de la lblNombre, pero se debe hacer en 
		//el boton de siguiente del panel del c�digo para evitar problemas.
		getLblBienvenida().setText(textos.getString("lblBienvenida"));
		getLblInstrucciones().setText(textos.getString("lblInstrucciones"));
		getLblAvisoEstrella().setText(textos.getString("lblAvisoEstrella"));
		getLblAyuda().setText(textos.getString("lblAyuda"));
		
		//-- Menus
		getMnJuego().setText(textos.getString("menuJuego"));
		getMnJuego().setMnemonic(Integer.parseInt(textos.getString("mnemonicoJuego")));
		getMnJuego().setToolTipText(textos.getString("toolTipJuego"));
		
		getMntmNuevo().setText(textos.getString("mntmNuevo"));
		getMntmNuevo().setMnemonic(Integer.parseInt(textos.getString("mnemonicoNuevo")));
		getMntmNuevo().setToolTipText(textos.getString("toolTipNuevo"));
		
		getMntmSalir().setText(textos.getString("mntmSalir"));
		getMntmSalir().setMnemonic(Integer.parseInt(textos.getString("mnemonicoSalir")));
		getMntmSalir().setToolTipText(textos.getString("toolTipSalir"));
		
		getMnIdioma().setText(textos.getString("menuIdioma"));
		getMnIdioma().setMnemonic(Integer.parseInt(textos.getString("mnemonicoIdioma")));
		getMnIdioma().setToolTipText(textos.getString("toolTipIdioma"));		
		
		getMntmEspa�ol().setText(textos.getString("btnEspa�ol"));
		getMntmEspa�ol().setMnemonic(Integer.parseInt(textos.getString("mnemonicoEspa�ol")));
		getMntmEspa�ol().setToolTipText(textos.getString("toolTipEspa�ol"));
		
		getMntmIngles().setText(textos.getString("btnIngles"));
		getMntmIngles().setMnemonic(Integer.parseInt(textos.getString("mnemonicoIngles")));
		getMntmIngles().setToolTipText(textos.getString("toolTipIngles"));
		
		getMnAyuda().setText(textos.getString("menuAyuda"));
		getMnAyuda().setMnemonic(Integer.parseInt(textos.getString("mnemonicoAyuda")));
		getMnAyuda().setToolTipText(textos.getString("toolTipAyuda"));
		
		getMntmContenidos().setText(textos.getString("mntmContenidos"));
		getMntmContenidos().setMnemonic(Integer.parseInt(textos.getString("mnemonicoContenidos")));
		getMntmContenidos().setToolTipText(textos.getString("toolTipContenidos"));
		
		getMntmAcercaDe().setText(textos.getString("mntmAcercaDe"));
		getMntmAcercaDe().setMnemonic(Integer.parseInt(textos.getString("mnemonicoAcercaDe")));
		getMntmAcercaDe().setToolTipText(textos.getString("toolTipAcercaDe"));
	}
	
	/**
	 * M�todo que crea el panel de internacionalizaci�n
	 * 
	 * @return panelInternacionalizacion, panel de la internacionalizaci�n
	 */
	private JPanel getPanelInternacionalizacion() {
		if (panelInternacionalizacion == null) {
			panelInternacionalizacion = new JPanel();
			panelInternacionalizacion.setBackground(new Color(152, 251, 152));
			panelInternacionalizacion.setLayout(null);
			panelInternacionalizacion.add(getBtnSiguienteInter());
			panelInternacionalizacion.add(getLblIdioma());
			panelInternacionalizacion.add(getLblLogoInternacionalizacion());
			panelInternacionalizacion.add(getBtnEspa�ol());
			panelInternacionalizacion.add(getBtnIngles());
		}
		return panelInternacionalizacion;
	}
	
	/**
	 * M�todo que crea el boton siguiente de la internacionalizaci�n
	 * 
	 * @return btnSiguienteInter, boton siguiente de la internacionalizaci�n
	 */
	private JButton getBtnSiguienteInter() {
		if (btnSiguienteInter == null) {
			btnSiguienteInter = new JButton("");
			btnSiguienteInter.setForeground(new Color(47, 79, 79));
			btnSiguienteInter.addActionListener(new ActionListener() {
				/**
				 * M�todo que ejecuta la accion de los botones
				 * 
				 * @param e, evento
				 */
				public void actionPerformed(ActionEvent e) {
					setTitle(textos.getString("tituloCodigo"));
					((CardLayout) getContentPane().getLayout()).next(contentPane);		
					getTextFieldCodigo().requestFocus();
					getRootPane().setDefaultButton(getBtnSiguienteCodigo());
				}
			});
			btnSiguienteInter.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSiguienteInter.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));
			btnSiguienteInter.setBackground(new Color(60,179,113));
			btnSiguienteInter.setBounds(735, 417, 125, 41);
		}
		return btnSiguienteInter;
	}
	
	/**
	 * M�todo que crea la etiqueta del idioma
	 * 
	 * @return lblIdioma, etiqueta del idioma
	 */
	private JLabel getLblIdioma() {
		if (lblIdioma == null) {
			lblIdioma = new JLabel("");
			lblIdioma.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblIdioma.setHorizontalAlignment(SwingConstants.CENTER);
			lblIdioma.setBounds(10, 51, 850, 33);
		}
		return lblIdioma;
	}
	
	/**
	 * M�todo que crea la etiqueta del logo
	 * 
	 * @return lblLogo, etiqueta del logo
	 */
	private JLabel getLblLogoInternacionalizacion() {
		if (lblLogoInternacionalizacion == null) {
			lblLogoInternacionalizacion = new JLabel("");
			lblLogoInternacionalizacion.setBounds(311, 281, 250, 105);			
			lblLogoInternacionalizacion.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/images/ECI_logo.png")).getImage().getScaledInstance(
							getLblLogoInternacionalizacion().getWidth(), getLblLogoInternacionalizacion().getHeight(), Image.SCALE_SMOOTH)));			
		}
		return lblLogoInternacionalizacion;
	}	
	
	/**
	 * M�todo que crea el boton espa�ol 
	 * 
	 * @return btnEspa�ol, boton espa�ol
	 */
	private JButton getBtnEspa�ol() {
		if (btnEspa�ol == null) {
			btnEspa�ol = new JButton("");
			btnEspa�ol.setFocusCycleRoot(true);
			btnEspa�ol.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));			
			btnEspa�ol.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnEspa�ol.setVerticalAlignment(SwingConstants.TOP);
			btnEspa�ol.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEspa�ol.setBackground(new Color(143, 188, 143));
			btnEspa�ol.setBounds(309, 129, 102, 113);
			btnEspa�ol.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/images/Espa�ol.png")).getImage().getScaledInstance(
							getBtnEspa�ol().getWidth(), getBtnEspa�ol().getHeight()-RECORTAR_IMAGENES, Image.SCALE_SMOOTH)));
			btnEspa�ol.addActionListener(cTS);
		}
		return btnEspa�ol;
	}
	
	/**
	 * M�todo que crea el boton ingles 
	 * 
	 * @return btnIngles, boton ingles
	 */
	private JButton getBtnIngles() {
		if (btnIngles == null) {
			btnIngles = new JButton("");
			btnIngles.setFocusCycleRoot(true);
			btnIngles.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));
			btnIngles.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnIngles.setVerticalAlignment(SwingConstants.TOP);
			btnIngles.setHorizontalTextPosition(SwingConstants.CENTER);
			btnIngles.setBackground(new Color(143, 188, 143));
			btnIngles.setBounds(459, 129, 102, 113);
			btnIngles.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/images/Ingles.png")).getImage().getScaledInstance(
							getBtnEspa�ol().getWidth(), getBtnEspa�ol().getHeight()-RECORTAR_IMAGENES, Image.SCALE_SMOOTH)));
			btnIngles.addActionListener(cTE);
		}
		return btnIngles;
	}
//-- C�DIGO --------------------------------------------------------------------
	/**
	 * M�todo que crea el panel del codigo
	 * 
	 * @return panelCodigo, panel del codigo
	 */
	private JPanel getPanelCodigo() {
		if (panelCodigo == null) {
			panelCodigo = new JPanel();
			panelCodigo.setBackground(new Color(152, 251, 152));
			panelCodigo.setLayout(null);
			panelCodigo.add(getLblTarjeta());
			panelCodigo.add(getBtnSiguienteCodigo());
			panelCodigo.add(getBtnAnteriorCodigo());
			panelCodigo.add(getTextFieldCodigo());
			panelCodigo.add(getPanelLblCodigo());
		}
		return panelCodigo;
	}
	
	/**
	 * M�todo que crea la etiqueta de la tarjeta
	 * 
	 * @return lblTarjeta, etiqueta de la tarjeta
	 */
	private JLabel getLblTarjeta() {
		if (lblTarjeta == null) {
			lblTarjeta = new JLabel("");
			lblTarjeta.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTarjeta.setBackground(new Color(152, 251, 152));
			lblTarjeta.setBounds(243, 215, 360, 214);
			lblTarjeta.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/images/ECI_tarjeta.png")).getImage().getScaledInstance(
							getLblTarjeta().getWidth(), getLblTarjeta().getHeight(), Image.SCALE_SMOOTH)));
		}
		return lblTarjeta;
	}
	
	/**
	 * M�todo que crea el panel de las etiquetas 
	 * 
	 * @return panelLbl, panel de las etiquetas
	 */
	private JPanel getPanelLblCodigo() {
		if (panelLblCodigo == null) {
			panelLblCodigo = new JPanel();
			panelLblCodigo.setBackground(new Color(152, 251, 152));
			panelLblCodigo.setBounds(10, 50, 850, 67);
			panelLblCodigo.setLayout(new GridLayout(2, 1, 0, 0));
			panelLblCodigo.add(getLblCodigo());
			panelLblCodigo.add(getLblCodigo2());
		}
		return panelLblCodigo;
	}
	
	/**
	 * M�todo que crea la etiqueta del c�digo
	 * 
	 * @return lblCodigo, etiqueta del c�digo
	 */
	private JLabel getLblCodigo() {
		if (lblCodigo == null) {
			lblCodigo = new JLabel("");			
			lblCodigo.setLabelFor(getTextFieldCodigo());
			lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCodigo;
	}
	
	/**
	 * M�todo que crea la segunda etiqueta del c�digo
	 * 
	 * @return lblCodigo2, etiqueta del codigo 2
	 */
	private JLabel getLblCodigo2() {
		if (lblCodigo2 == null) {
			lblCodigo2 = new JLabel((String) null);
			lblCodigo2.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblCodigo2;
	}
	
	/**
	 * M�todo que crea el bot�n de siguiente de la ventana del c�digo
	 * 
	 * @return btnSiguienteCodigo, bot�n de siguiente de la ventana del c�digo
	 */
	private JButton getBtnSiguienteCodigo() {
		if (btnSiguienteCodigo == null) {
			btnSiguienteCodigo = new JButton((String) null);
			btnSiguienteCodigo.setForeground(new Color(47, 79, 79));
			btnSiguienteCodigo.addActionListener(new ActionListener() {
				/**
				 * M�todo que ejecuta la accion de los botones
				 * 
				 * @param e, evento
				 */
				public void actionPerformed(ActionEvent e) {					
					siguienteVentana();
					//Se escribe aqui para que salga el nombre en el siguiente panel					
					getLblNombre().setText(textos.getString("lblNombre") + game.getClientName() + "!");
				}
			});
			btnSiguienteCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSiguienteCodigo.setEnabled(false);
			btnSiguienteCodigo.setToolTipText((String) null);
			btnSiguienteCodigo.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));
			btnSiguienteCodigo.setBackground(new Color(60,179,113));
			btnSiguienteCodigo.setBounds(735, 417, 125, 41);
		}
		return btnSiguienteCodigo;
	}	
	
	/**
	 * M�todo que comprueba si el id introducido est� en la lista de clientes y, de ser as�,
	 * comprueba si este puede o no jugar
	 * 
	 * @return 0, -1, -2 o -3, dependiendo de si esta, si puede o no jugar y si ha introducido bien el c�digo
	 */
	protected int comprobarCliente() {
		String idCliente = getTextFieldCodigo().getText();
		if (idCliente.length() == 6) {			
			return game.checkClients(idCliente);
		}
		return -3;
	}
	
	/**
	 * M�todo que, en caso de que el cliente pueda jugar, le env�a a la siguiente ventana, 
	 * correspondiente a la bienvenida a la aplicaci�n; y, en caso de que no pueda, 
	 * le avisa de cual ha podido ser el motivo
	 */
	protected void siguienteVentana() {
		int result = comprobarCliente();
		if (result == PUEDE_JUGAR) {
			System.out.println("\nEl nombre del cliente es: " + game.getClientName() + "\n");
			((CardLayout) getContentPane().getLayout()).next(contentPane);		
			getRootPane().setDefaultButton(getBtnSiguienteBienvenida());
			setTitle(textos.getString("tituloBienvenida"));
		} else if (result == NO_PUEDE_JUGAR){
			JOptionPane.showMessageDialog(this, textos.getString("mensajeNoPuedeJugar"), 
					textos.getString("tituloCodigo"), JOptionPane.INFORMATION_MESSAGE);
			restart();
		} else if (result == NO_ESTA){
			JOptionPane.showMessageDialog(this, textos.getString("mensajeNoEsta"), 
					textos.getString("tituloCodigo"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, textos.getString("mensajeSeHaConfundido"), 
					textos.getString("tituloCodigo"), JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * M�todo que crea el bot�n de anterior de la ventana del c�digo 
	 * 
	 * @return btnAnteriorCodigo, bot�n de anterior de la ventana del c�digo  
	 */
	private JButton getBtnAnteriorCodigo() {
		if (btnAnteriorCodigo == null) {
			btnAnteriorCodigo = new JButton((String) null);
			btnAnteriorCodigo.setForeground(new Color(47, 79, 79));
			btnAnteriorCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAnteriorCodigo.addActionListener(new ActionListener() {
				/**
				 * M�todo que ejecuta la accion de los botones
				 * 
				 * @param e, evento
				 */
				public void actionPerformed(ActionEvent e) {
					setTitle(textos.getString("tituloIdioma"));
					((CardLayout) getContentPane().getLayout()).previous(contentPane);
					getRootPane().setDefaultButton(getBtnSiguienteInter());
				}
			});
			btnAnteriorCodigo.setToolTipText((String) null);
			btnAnteriorCodigo.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));
			btnAnteriorCodigo.setBackground(new Color(60,179,113));
			btnAnteriorCodigo.setBounds(10, 417, 125, 41);
		}
		return btnAnteriorCodigo;
	}
	
	/**
	 * M�todo que crea el textField de la ventana del c�digo
	 * 
	 * @return textFieldCodigo, textField de la ventana del c�digo
	 */
	private JTextField getTextFieldCodigo() {
		if (textFieldCodigo == null) {
			textFieldCodigo = new JTextField();
			textFieldCodigo.setBackground(new Color(143, 188, 143));
			textFieldCodigo.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));
			textFieldCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textFieldCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldCodigo.setBounds(362, 141, 139, 47);
			textFieldCodigo.addKeyListener(pT);
		}
		return textFieldCodigo;
	}
	
	/**
	 * M�todo que activa el boton de siguiente si el textField no est� vac�o
	 */
	protected void activarBotonSiguiente() {
		if (!getTextFieldCodigo().getText().equals("")) {
			getBtnSiguienteCodigo().setEnabled(true);
		} else {
			getBtnSiguienteCodigo().setEnabled(false);
		}
	}	
//-- BIENVENIDA ----------------------------------------------------------------
	/**
	 * M�todo que crea el panel de bienvenida
	 * 
	 * @return panelBienvenida, panel de bienvenida
	 */
	private JPanel getPanelBienvenida() {
		if (panelBienvenida == null) {
			panelBienvenida = new JPanel();
			panelBienvenida.setBackground(new Color(152, 251, 152));
			panelBienvenida.setLayout(null);
			panelBienvenida.add(getBtnSiguienteBienvenida());
			panelBienvenida.add(getPanelLblBienvenida());
			panelBienvenida.add(getLblLogoBienvenida());
			panelBienvenida.add(getPanelLblInstrucciones());
			panelBienvenida.add(getLblInterrogacion());
		}
		return panelBienvenida;
	}
	
	/**
	 * M�todo que crea el boton de siguiente del panel de bienvenida
	 * 
	 * @return btnSiguienteBienvenida, boton de siguiente del panel de bienvenida
	 */
	private JButton getBtnSiguienteBienvenida() {
		if (btnSiguienteBienvenida == null) {
			btnSiguienteBienvenida = new JButton((String) null);
			btnSiguienteBienvenida.setForeground(new Color(47, 79, 79));
			btnSiguienteBienvenida.addActionListener(new ActionListener() {
				/**
				 * M�todo que ejecuta la accion de los botones
				 * 
				 * @param e, evento
				 */
				public void actionPerformed(ActionEvent e) {
					irAVentanaPrincipal();
				}
			});
			btnSiguienteBienvenida.setToolTipText((String) null);
			btnSiguienteBienvenida.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSiguienteBienvenida.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));
			btnSiguienteBienvenida.setBackground(new Color(60,179,113));
			btnSiguienteBienvenida.setBounds(735, 417, 125, 41);
		}
		return btnSiguienteBienvenida;
	}
	
	/**
	 * M�todo que crea la ventana principal y va hasta ella, cerrando la ventana de inicio
	 */
	private void irAVentanaPrincipal() {
		VentanaPrincipal vP = new VentanaPrincipal(this, localizacion, game);
		vP.setVisible(true);
		this.setVisible(false);
	}
	
	/**
	 * M�todo que crea el panel de etiquetas de bienvenida
	 * 
	 * @return panelLblBienvenida, panel de etiquetas de bienvenida
	 */
	private JPanel getPanelLblBienvenida() {
		if (panelLblBienvenida == null) {
			panelLblBienvenida = new JPanel();
			panelLblBienvenida.setBackground(new Color(152, 251, 152));
			panelLblBienvenida.setBounds(10, 50, 850, 67);
			panelLblBienvenida.setLayout(new GridLayout(2, 1, 0, 0));
			panelLblBienvenida.add(getLblNombre());
			panelLblBienvenida.add(getLblBienvenida());
		}
		return panelLblBienvenida;
	}
	
	/**
	 * M�todo que crea la etiqueta del nombre
	 * 
	 * @return lblNombre, etiqueta del nombre
	 */
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel((String) null);
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblNombre;
	}
	
	/**
	 * M�todo que crea la etiqueta de bienvenida
	 * 
	 * @return lblBienvenida, etiqueta de bienvenida
	 */
	private JLabel getLblBienvenida() {
		if (lblBienvenida == null) {
			lblBienvenida = new JLabel((String) null);
			lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
			lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblBienvenida;
	}
	
	/**
	 * M�todo que crea la etiqueta del logo en el panel de bienvenida
	 * 
	 * @return lblLogoBienvenida, etiqueta del logo en el panel de bienvenida 
	 */
	private JLabel getLblLogoBienvenida() {
		if (lblLogoBienvenida == null) {
			lblLogoBienvenida = new JLabel("");
			lblLogoBienvenida.setBounds(328, 128, 250, 93);
			lblLogoBienvenida.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/images/ECI_logo.png")).getImage().getScaledInstance(
							getLblLogoBienvenida().getWidth(), getLblLogoBienvenida().getHeight(), Image.SCALE_SMOOTH)));			
		}
		return lblLogoBienvenida;
	}
	
	/**
	 * M�todo que crea el panel de las etiquetas de instrucciones
	 * 
	 * @return panelLblInstrucciones, panel de las etiquetas de instrucciones 
	 */
	private JPanel getPanelLblInstrucciones() {
		if (panelLblInstrucciones == null) {
			panelLblInstrucciones = new JPanel();
			panelLblInstrucciones.setBackground(new Color(152, 251, 152));
			panelLblInstrucciones.setBounds(10, 232, 850, 83);
			panelLblInstrucciones.setLayout(new GridLayout(3, 1, 0, 0));
			panelLblInstrucciones.add(getLblInstrucciones());
			panelLblInstrucciones.add(getLblAvisoEstrella());
			panelLblInstrucciones.add(getLblAyuda());
		}
		return panelLblInstrucciones;
	}
	
	/**
	 * M�todo que crea la etiqueta de las instrucciones
	 * 
	 * @return lblInstrucciones, etiqueta de las instrucciones
	 */
	private JLabel getLblInstrucciones() {
		if (lblInstrucciones == null) {
			lblInstrucciones = new JLabel((String) null);
			lblInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblInstrucciones.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblInstrucciones;
	}
	/**
	 * M�todo que crea la etiqueta de aviso sobre la estrella
	 * 
	 * @return lblAvisoEstrella, etiqueta de aviso sobre la estrella
	 */
	private JLabel getLblAvisoEstrella() {
		if (lblAvisoEstrella == null) {
			lblAvisoEstrella = new JLabel("");
			lblAvisoEstrella.setHorizontalAlignment(SwingConstants.CENTER);
			lblAvisoEstrella.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblAvisoEstrella;
	}
	/**
	 * M�todo que crea la etiqueta de ayuda
	 * 
	 * @return lblAyuda, etiqueta de ayuda
	 */
	private JLabel getLblAyuda() {
		if (lblAyuda == null) {
			lblAyuda = new JLabel((String) null);
			lblAyuda.setHorizontalAlignment(SwingConstants.CENTER);
			lblAyuda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblAyuda;
	}
	
	/**
	 * M�todo que crea la etiqueta del boton de interrogacion
	 * 
	 * @return lblInterrogacion, etiqueta del boton de interrogacion
	 */
	private JLabel getLblInterrogacion() {
		if (lblInterrogacion == null) {
			lblInterrogacion = new JLabel("");
			lblInterrogacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblInterrogacion.setOpaque(true);
			lblInterrogacion.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			lblInterrogacion.setBackground(new Color(143, 188, 143));
			lblInterrogacion.setBounds(390, 326, 96, 86);
			lblInterrogacion.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/images/Interrogacion.png")).getImage().getScaledInstance(
							getLblInterrogacion().getWidth(), getLblInterrogacion().getHeight(), Image.SCALE_SMOOTH)));			
		}
		return lblInterrogacion;
	}
//-- MENU ----------------------------------------------------------------------
	/**
	 * M�todo que crea la barra de menus principal
	 * 
	 * @return menuBarPrincipal, barra de menus principal
	 */
	private JMenuBar getMenuBarInicio() {
		if (menuBarInicio == null) {
			menuBarInicio = new JMenuBar();
			menuBarInicio.setBackground(new Color(143, 188, 143));
			menuBarInicio.add(getMnJuego());
			menuBarInicio.add(getMnIdioma());
			menuBarInicio.add(getMnAyuda());
		}
		return menuBarInicio;
	}
	
	/**
	 * M�todo que crea el menu de juego
	 * 
	 * @return mnJuego,, menu de juego
	 */
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("");
			mnJuego.setFont(new Font("Segoe UI", Font.BOLD, 16));
			mnJuego.setBackground(new Color(152, 251, 152));
			mnJuego.add(getMntmNuevo());
			mnJuego.add(getMntmSalir());
		}
		return mnJuego;
	}
	
	/**
	 * M�todo que crea el item de nuevo
	 * 
	 * @return mntmNuevo, item de nuevo
	 */
	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("");
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (confirmNew()) {
						restart();
					}					
				}
			});
			mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			mntmNuevo.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return mntmNuevo;
	}
	
	/**
	 * M�todo que confirma el reinicio de la aplicaci�n
	 * 
	 * @return true o false, en funci�n de si se sale de la aplicaci�n.
	 */
	private boolean confirmNew() {
		int answer = JOptionPane.showOptionDialog(this,  textos.getString("mensajeNuevo"), textos.getString("tituloNuevo"), 
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] {textos.getString("opcionSi"), 
						textos.getString("opcionNo")}, textos.getString("opcionSi"));
		if (answer==JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que crea el item de salir
	 * 
	 * @return mntmSalir, item de salir
	 */
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("");
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (confirmExit()) {
						System.exit(0);
					}
				}
			});
			mntmSalir.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return mntmSalir;
	}
	
	/**
	 * M�todo que confirma la salida de la aplicaci�n
	 * 
	 * @return true o false, si se confirma
	 */
	private boolean confirmExit() {
		int answer = JOptionPane.showOptionDialog(this,  textos.getString("mensajeSalir"), textos.getString("tituloSalir"), 
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] {textos.getString("opcionSi"), 
								textos.getString("opcionNo")}, textos.getString("opcionSi"));
		if (answer==JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que crea el men� de idioma
	 * 
	 * @return mnIdioma, menu de idioma
	 */
	private JMenu getMnIdioma() {
		if (mnIdioma == null) {
			mnIdioma = new JMenu("");
			mnIdioma.setBackground(new Color(143, 188, 143));
			mnIdioma.setFont(new Font("Segoe UI", Font.BOLD, 16));
			mnIdioma.add(getMntmEspa�ol());
			mnIdioma.add(getMntmIngles());
		}
		return mnIdioma;
	}
	
	/**
	 * M�todo que crea el menu item de cambio a espa�ol
	 * 
	 * @return mntmEspa�ol, menu item de cambio a espa�ol
	 */
	private JMenuItem getMntmEspa�ol() {
		if (mntmEspa�ol == null) {
			mntmEspa�ol = new JMenuItem("");
			mntmEspa�ol.setFont(new Font("Tahoma", Font.ITALIC, 14));
			mntmEspa�ol.addActionListener(cTS);
		}
		return mntmEspa�ol;
	}
	
	/**
	 * M�todo que crea el menu item de cambio a ingles
	 * 
	 * @return mntmIngles, menu item de cambio a ingles
	 */
	private JMenuItem getMntmIngles() {
		if (mntmIngles == null) {
			mntmIngles = new JMenuItem("");
			mntmIngles.setFont(new Font("Tahoma", Font.ITALIC, 14));
			mntmIngles.addActionListener(cTE);
		}
		return mntmIngles;
	}
	
	/**
	 * M�todo que crea el men� de ayuda
	 * 
	 * @return mnAyuda, men� de ayuda
	 */
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("");
			mnAyuda.setBackground(new Color(143, 188, 143));
			mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 16));
			mnAyuda.add(getMntmContenidos());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	
	/**
	 * M�todo que crea el item de contenidos
	 * 
	 * @return mntmContenidos, item de contenidos
	 */
	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("");
			mntmContenidos.setFont(new Font("Tahoma", Font.ITALIC, 14));
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContenidos;
	}
	
	/**
	 * M�todo que crea el item de acerca de
	 * 
	 * @return mntmAcercaDe, item de acerca de 
	 */
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showAbout();
				}
			});
			mntmAcercaDe.setFont(new Font("Tahoma", Font.ITALIC, 14));
		}
		return mntmAcercaDe;
	}
	
	/**
	 * M�todo que muestra el panel Acerca De
	 */
	private void showAbout() {
		JOptionPane.showMessageDialog(this, textos.getString("mensajeAcercaDe"), 
				textos.getString("tituloAcercaDe"), JOptionPane.INFORMATION_MESSAGE);
	}
	
//-- EVENTOS -------------------------------------------------------------------
	/**
	 * T�tulo: Clase ProcesaTecla
	 * Descripci�n: Clase evento que procesa cada tecla que se introduce en el textField-
	 * Con esto, se activa el bot�n de Siguiente, y cuando se han escrito 6 caracteres, no permite escribir m�s
	 *
	 * @author Omar Teixeira, UO281847
	 * @version 29 dic. 2021
	 */
	public class ProcesaTecla extends KeyAdapter {
		/**
		 * M�todo que procesa cada tecla escrita
		 * 
		 * @param e, evento
		 */
		public void keyTyped(KeyEvent e) {
			char pressedKey = e.getKeyChar();
			activarBotonSiguiente();
			if (getTextFieldCodigo().getText().length()==ID_LENGTH) {
				e.consume();
			} else if (getTextFieldCodigo().getText().length()<3) {
				if (Character.isAlphabetic(pressedKey)) {
					e.setKeyChar(String.valueOf(pressedKey).toUpperCase().charAt(0));
				} else if (Character.isDigit(pressedKey)) {
					e.consume();
				}
			} else if (getTextFieldCodigo().getText().length()>=3) {
				if (Character.isAlphabetic(pressedKey)) {
					e.consume();
				}
			}
		}
	}
	
	/**
	 * T�tulo: Clase changeToSpanish
	 * Descripci�n: Clase evento que procesa el cambio de idioma a espa�ol
	 *
	 * @author Omar Teixeira, UO281847
	 * @version 4 ene. 2022
	 */
	public class ChangeToSpanish implements ActionListener {
		/**
		 * M�todo que ejecuta la accion de los botones
		 * 
		 * @param e, evento
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			localizacion = new Locale("es");
			setTexts(localizacion);
			game.changeToSpanish();
		}		
	}
	
	/**
	 * T�tulo: Clase changeToEnglish
	 * Descripci�n: Clase evento que procesa el cambio de idioma a ingles
	 *
	 * @author Omar Teixeira, UO281847
	 * @version 4 ene. 2022
	 */
	public class ChangeToEnglish implements ActionListener {
		/**
		 * M�todo que ejecuta la accion de los botones
		 * 
		 * @param e, evento
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			localizacion = new Locale("en");
			setTexts(localizacion);
			game.changeToEnglish();
		}		
	}		
}
