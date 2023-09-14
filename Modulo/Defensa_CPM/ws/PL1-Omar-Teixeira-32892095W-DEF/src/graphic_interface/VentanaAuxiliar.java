package graphic_interface;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logic.Gift;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.awt.Rectangle;

/**
 * Título: Clase VentanaAuxiliar
 * Descripción: Clase que crea una ventana auxiliar empleada para marcar la fecha y las observaciones. 
 *
 * @author Omar Teixeira, UO281847
 * @version 3 ene. 2022
 */
public class VentanaAuxiliar extends JDialog {
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
	 * Constante TRIP_FILE
	 */
	private static final String TRIP_FILE = "/images/products/";
//-- ATRIBUTOS -----------------------------------------------------------------
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo vP
	 */
	private VentanaPrincipal vP;
	//-- Internacionalización --------------------------------------------------
	/**
	 * Atributo textos
	 */
	private ResourceBundle textos;
	/**
	 * Atributo localizacion
	 */
	private Locale localizacion;
	//-- Viajes ----------------------------------------------------------------
	/**
	 * Atributo panelLblViajeSeleccionado
	 */
	private JPanel panelLblViajeSeleccionado;
	/**
	 * Atributo lblSeleccionado
	 */
	private JLabel lblSeleccionado;
	/**
	 * Atributo lblNombreViaje
	 */
	private JLabel lblNombreViaje;
	/**
	 * Atributo lblImagenViaje
	 */
	private JLabel lblImagenViaje;
	/**
	 * Atributo btnInterrogacion
	 */
	private JButton btnInterrogacion;
	/**
	 * Atributo lblFecha1
	 */
	private JLabel lblFecha1;
	/**
	 * Atributo panelLblFechas
	 */
	private JPanel panelLblFechas;
	/**
	 * Atributo lblFecha2
	 */
	private JLabel lblFecha2;
	/**
	 * Atributo lblObservaciones
	 */
	private JLabel lblObservaciones;
	/**
	 * Atributo scrollPaneObservaciones
	 */
	private JScrollPane scrollPaneObservaciones;
	/**
	 * Atributo textAreaObservaciones
	 */
	private JTextArea textAreaObservaciones;
	/**
	 * Atributo btnConfirmar
	 */
	private JButton btnConfirmar;
	/**
	 * Atributo calendar
	 */
	private JCalendar calendar;
	/**
	 * Atributo btnFecha
	 */
	private JButton btnFecha;
	/**
	 * Atributo textFieldFecha
	 */
	private JTextField textFieldFecha;
	/**
	 * Atributo dateFormat
	 */
	private String dateFormat;
	/**
	 * Atributo observation
	 */
	private String observation;

	/**
	 * Constructor que crea la ventana auxiliar
	 * 
	 * @param vP, ventana principal de la aplicación
	 * @param localizacion, localización de la aplicación
	 */
	public VentanaAuxiliar(VentanaPrincipal vP, Locale localizacion) {
		this.vP = vP;
		this.localizacion = localizacion;
		this.textos = ResourceBundle.getBundle(INTERN_FILE, localizacion);
		this.observation = "";
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmaCancelacion();
			}
		});		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAuxiliar.class.getResource("/images/ECI_logo.png")));
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 825, 950);
		setLocationRelativeTo(vP);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new LineBorder(new Color(165, 42, 42), 5, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelLblViajeSeleccionado());
		contentPane.add(getLblImagenViaje());
		contentPane.add(getPanelLblFechas());
		contentPane.add(getLblObservaciones());
		contentPane.add(getScrollPaneObservaciones());
		contentPane.add(getBtnConfirmar());
		contentPane.add(getCalendar());
		contentPane.add(getBtnFecha());
		contentPane.add(getTextFieldFecha());
		contentPane.add(getBtnInterrogacion());
				
		loadHelp();
		setTexts(localizacion);
	}
	
	/**
	 * Método que confirma la cancelación de salir de la ventana
	 */
	protected void confirmaCancelacion() {
		int answer = JOptionPane.showOptionDialog(this, textos.getString("mensajeCancelacionViajes"), textos.getString("tituloCancelacionViajes"), 
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] {textos.getString("opcionSi"), textos.getString("opcionNo")}, 
					textos.getString("opcionSi"));
		if (answer==JOptionPane.YES_OPTION) {
			this.dateFormat = null;
			this.observation = null;
			getGift().setDate(dateFormat);
			getGift().setObservations(observation);
			setGift(getGift());
			dispose();
		}
	}

	/**
	 * Método que devuelve una referencia a la ventana principal
	 * 
	 * @return vP, referencia a la ventana principal
	 */
	private VentanaPrincipal getVP() {
		return vP;
	}
	
	/**
	 * Método que devuelve el viaje seleccionado
	 * 
	 * @return trip, viaje seleccionado
	 */
	private Gift getGift() {
		return getVP().getTrip();
	}
	
	/**
	 * Método que setea el viaje
	 * 
	 * @param trip, viaje
	 */
	private void setGift(Gift trip) {
		getVP().setTrip(trip);
	}
	
	/**
	 * Método que carga la ayuda
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
	    hb.enableHelpOnButton(getBtnInterrogacion(),"Ventana de viajes/experiencias", hs);
  }
	
//-- INTERNACIONALIZACIÓN --------------------------------------------------
	/**
	 * Método que setea los textos según su localización
	 * 
	 * @param localizacion, localización del usuario
	 */
	private void setTexts(Locale localizacion){
		this.textos = ResourceBundle.getBundle(INTERN_FILE, localizacion);
		
		setTitle(textos.getString("tituloViajes"));
		
		getLblSeleccionado().setText(textos.getString("lblSeleccionado"));
		getLblNombreViaje().setText(getGift().getDenomination());
		
		getLblFecha1().setText(textos.getString("lblFecha1"));
		getLblFecha2().setText(textos.getString("lblFecha2"));
		
		getLblFecha1().setDisplayedMnemonic(Integer.valueOf(textos.getString("mnemonicoCalendar")));
		getCalendar().setToolTipText(textos.getString("toolTipCalendar"));
		
		getBtnFecha().setText(textos.getString("btnFecha"));
		getBtnFecha().setMnemonic(Integer.parseInt(textos.getString("mnemonicoFecha")));
		getBtnFecha().setToolTipText(textos.getString("toolTipFecha"));
		
		getLblObservaciones().setText(textos.getString("lblObservaciones"));
		getLblObservaciones().setDisplayedMnemonic(Integer.valueOf(textos.getString("mnemonicoObservaciones")));
		getTextAreaObservaciones().setToolTipText(textos.getString("toolTipObservaciones"));
		
		getBtnConfirmar().setText(textos.getString("btnConfirmar"));
		getBtnConfirmar().setMnemonic(Integer.parseInt(textos.getString("mnemonicoConfirmar")));
		getBtnConfirmar().setToolTipText(textos.getString("toolTipConfirmar"));
	}
	
//-- VIAJES --------------------------------------------------------------------	
	/**
	 * Método que crea el boton de interrogacion
	 * 
	 * @return btnInterrogacion, boton de interrogacion
	 */
	private JButton getBtnInterrogacion() {
		if (btnInterrogacion == null) {
			btnInterrogacion = new JButton("");
			btnInterrogacion.setBounds(new Rectangle(0, 0, 100, 100));
			btnInterrogacion.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			btnInterrogacion.setBackground(new Color(143, 188, 143));
			btnInterrogacion.setBounds(731, 11, 70, 70);
			btnInterrogacion.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/images/Interrogacion.png")).getImage().getScaledInstance(
							getBtnInterrogacion().getWidth(), getBtnInterrogacion().getHeight(), Image.SCALE_SMOOTH)));
		}
		return btnInterrogacion;
	}
	
	/**
	 * Método que crea el panel de las etiquetas del viaje seleccionado
	 * 
	 * @return panelLblViajeSeleccionado, panel de las etiquetas del viaje seleccionado
	 */
	private JPanel getPanelLblViajeSeleccionado() {
		if (panelLblViajeSeleccionado == null) {
			panelLblViajeSeleccionado = new JPanel();
			panelLblViajeSeleccionado.setBackground(new Color(152, 251, 152));
			panelLblViajeSeleccionado.setBounds(84, 24, 637, 70);
			panelLblViajeSeleccionado.setLayout(new GridLayout(0, 1, 0, 0));
			panelLblViajeSeleccionado.add(getLblSeleccionado());
			panelLblViajeSeleccionado.add(getLblNombreViaje());
		}
		return panelLblViajeSeleccionado;
	}
	
	/**
	 * Método que crea la etiqueta de seleccionado
	 * 
	 * @return lblSeleccionado, etiqueta de seleccionado
	 */
	private JLabel getLblSeleccionado() {
		if (lblSeleccionado == null) {
			lblSeleccionado = new JLabel("");
			lblSeleccionado.setForeground(new Color(165, 42, 42));
			lblSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblSeleccionado;
	}
	
	/**
	 * Método que crea la etiqueta de nombre del viaje
	 * 
	 * @return lblNombreViaje, etiqueta de nombre del viaje
	 */
	private JLabel getLblNombreViaje() {
		if (lblNombreViaje == null) {
			lblNombreViaje = new JLabel("");
			lblNombreViaje.setForeground(new Color(165, 42, 42));
			lblNombreViaje.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
			lblNombreViaje.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNombreViaje;
	}
	
	/**
	 * Método que crea la etiqueta de la imagen del viaje
	 * 
	 * @return lblImagenViaje, etiqueta de la imagen del viaje
	 */
	private JLabel getLblImagenViaje() {
		if (lblImagenViaje == null) {
			lblImagenViaje = new JLabel("");
			lblImagenViaje.setBounds(299, 105, 175, 153);
			lblImagenViaje.setIcon(new ImageIcon(new ImageIcon(
					VentanaPrincipal.class.getResource(TRIP_FILE + getGift().getId() + ".png")).getImage().getScaledInstance(
							getLblImagenViaje().getWidth(), getLblImagenViaje().getHeight(), Image.SCALE_SMOOTH)));
		}
		return lblImagenViaje;
	}
	
	/**
	 * Método que crea el panel de las etiquetas de fechas
	 * 
	 * @return panelLblFechas, panel de las etiquetas de fechas
	 */
	private JPanel getPanelLblFechas() {
		if (panelLblFechas == null) {
			panelLblFechas = new JPanel();
			panelLblFechas.setBackground(new Color(152, 251, 152));
			panelLblFechas.setBounds(10, 269, 789, 59);
			panelLblFechas.setLayout(new GridLayout(2, 1, 0, 0));
			panelLblFechas.add(getLblFecha1());
			panelLblFechas.add(getLblFecha2());
		}
		return panelLblFechas;
	}
	
	/**
	 * Método que crea la etiqueta de fecha 1
	 * 
	 * @return lblFecha1, etiqueta de fecha 1
	 */
	private JLabel getLblFecha1() {
		if (lblFecha1 == null) {
			lblFecha1 = new JLabel("");
			lblFecha1.setForeground(new Color(139, 0, 0));
			lblFecha1.setLabelFor(getCalendar());
			lblFecha1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblFecha1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblFecha1;
	}
	/**
	 * Método que crea la etiqueta de fecha 2
	 * 
	 * @return lblFecha2, etiqueta de fecha 2
	 */
	private JLabel getLblFecha2() {
		if (lblFecha2 == null) {
			lblFecha2 = new JLabel("");
			lblFecha2.setForeground(new Color(139, 0, 0));
			lblFecha2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblFecha2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblFecha2;
	}
	
	/**
	 * Método que crea el calendario
	 * 	
	 * @return calendar, calendario
	 */
	private JCalendar getCalendar() {
		if (calendar == null) {	        
			calendar = new JCalendar(localizacion);
			calendar.getYearChooser().setMaximum(2030);
			calendar.getYearChooser().getSpinner().setIgnoreRepaint(true);
			calendar.setDecorationBordersVisible(true);
			calendar.getYearChooser().setDayChooser(calendar.getDayChooser());
			calendar.getYearChooser().setMinimum(LocalDate.now().getYear());
			calendar.getYearChooser().getSpinner().setBackground(new Color(143, 188, 143));
			calendar.getYearChooser().setBackground(new Color(143, 188, 143));
			calendar.getYearChooser().setFont(new Font("Tahoma", Font.BOLD, 12));
			calendar.getMonthChooser().getSpinner().setBackground(new Color(143, 188, 143));			
			calendar.getMonthChooser().setBackground(new Color(143, 188, 143));
			calendar.getMonthChooser().setFont(new Font("Tahoma", Font.BOLD, 12));
			calendar.getMonthChooser().getSpinner().setFont(new Font("Tahoma", Font.BOLD, 11));			
			calendar.getDayChooser().setBackground(new Color(144, 238, 144));
			calendar.getDayChooser().setAutoscrolls(true);
			calendar.getDayChooser().setAlwaysFireDayProperty(false);
			calendar.getDayChooser().setFont(new Font("Tahoma", Font.BOLD, 12));
			calendar.getDayChooser().setDecorationBordersVisible(true);
			calendar.getDayChooser().setDayBordersVisible(true);
			calendar.getDayChooser().setWeekdayForeground(new Color(152, 251, 152));
			calendar.getDayChooser().getDayPanel().setBackground(new Color(143, 188, 143));			
			calendar.setMinSelectableDate(Calendar.getInstance().getTime());
			calendar.setBorder(new LineBorder(new Color(139, 0, 0), 2, true));			
			calendar.setForeground(new Color(0, 0, 0));			
			calendar.setBackground(new Color(152, 251, 152));
			calendar.setSundayForeground(new Color(255, 0, 0));
			calendar.setDecorationBackgroundColor(new Color(144, 238, 144));
			calendar.setWeekdayForeground(new Color(0, 0, 0));
			calendar.setBounds(66, 339, 520, 270);					
		}
		return calendar;
	}
	
	/**
	 * Método que crea el boton de fecha
	 * 
	 * @return btnFecha, boton de fecha
	 */
	private JButton getBtnFecha() {
		if (btnFecha == null) {
			btnFecha = new JButton("");
			btnFecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date date = getCalendar().getDate();
					DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.SHORT, localizacion);
					DateFormat formatoFechaFile = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("es"));
					dateFormat = formatoFechaFile.format(date);
					getTextFieldFecha().setText(formatoFecha.format(date));
					getBtnConfirmar().setEnabled(true);
				}
			});
			btnFecha.setForeground(new Color(47, 79, 79));
			btnFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnFecha.setBackground(new Color(60,179,113));
			btnFecha.setBorder(new LineBorder(new Color(0, 100, 0), 4, true));
			btnFecha.setBounds(616, 403, 133, 37);
		}
		return btnFecha;
	}
	
	/**
	 * Método que crea el text field de la fecha
	 * 
	 * @return textFieldFecha, text field de la fecha
	 */
	private JTextField getTextFieldFecha() {
		if (textFieldFecha == null) {
			textFieldFecha = new JTextField();
			textFieldFecha.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldFecha.setFont(new Font("Tahoma", Font.BOLD, 16));
			textFieldFecha.setBorder(new LineBorder(new Color(47, 79, 79), 2, true));
			textFieldFecha.setBackground(new Color(143, 188, 143));
			textFieldFecha.setEditable(false);
			textFieldFecha.setBounds(616, 486, 133, 49);
			textFieldFecha.setColumns(10);
		}
		return textFieldFecha;
	}
	
	/**
	 * Método que crea la etiqueta de observaciones
	 * 
	 * @return lblObservaciones, etiqueta de observaciones
	 */
	private JLabel getLblObservaciones() {
		if (lblObservaciones == null) {
			lblObservaciones = new JLabel("");
			lblObservaciones.setForeground(new Color(139, 0, 0));
			lblObservaciones.setLabelFor(getTextAreaObservaciones());
			lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblObservaciones.setBounds(10, 620, 789, 24);
		}
		return lblObservaciones;
	}
	
	/**
	 * Método que crea el panel de scroll de las observaciones
	 * 
	 * @return scrollPaneObservaciones, panel de scroll de las observaciones
	 */
	private JScrollPane getScrollPaneObservaciones() {
		if (scrollPaneObservaciones == null) {
			scrollPaneObservaciones = new JScrollPane();
			scrollPaneObservaciones.setBounds(226, 655, 360, 159);
			scrollPaneObservaciones.setViewportView(getTextAreaObservaciones());
		}
		return scrollPaneObservaciones;
	}
	
	/**
	 * Método que crea el text area de las observaciones
	 * 
	 * @return textAreaObservaciones, text area de las observaciones
	 */
	private JTextArea getTextAreaObservaciones() {
		if (textAreaObservaciones == null) {
			textAreaObservaciones = new JTextArea();
			textAreaObservaciones.setFont(new Font("Monospaced", Font.PLAIN, 16));
			textAreaObservaciones.setBorder(new LineBorder(new Color(139, 0, 0), 3, true));
			textAreaObservaciones.setBackground(new Color(143, 188, 143));
			textAreaObservaciones.setWrapStyleWord(true);
			textAreaObservaciones.setLineWrap(true);
			textAreaObservaciones.setBounds(0, 0, 5, 22);
		}
		return textAreaObservaciones;
	}
		
	/**
	 * Método que crea el boton de confirmar
	 * 
	 * @return btnConfirmar, boton de confirmar
	 */
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("");
			btnConfirmar.setForeground(new Color(47, 79, 79));
			btnConfirmar.setEnabled(false);
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					observation = getTextAreaObservaciones().getText();
					checkConfirmation();		
				}
			});
			btnConfirmar.setBorder(new LineBorder(new Color(47, 79, 79), 4, true));
			btnConfirmar.setBackground(new Color(60,179,113));
			btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnConfirmar.setBounds(305, 833, 200, 49);
		}
		return btnConfirmar;
	}
	
	/**
	 * Método que comprueba la confirmacion de que se añade el viaje
	 */
	private void checkConfirmation() {
		int answer = JOptionPane.showOptionDialog(this, textos.getString("mensajeConfirmacionViajes1") + " " + dateFormat + 
				textos.getString("mensajeConfirmacionViajes2") + " " + observation + textos.getString("mensajeConfirmacionViajes3"), 
				textos.getString("tituloConfirmacionViajes"), JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] 
						{textos.getString("opcionSi"), textos.getString("opcionNo")}, textos.getString("opcionSi"));
		if (answer == JOptionPane.YES_OPTION) {			
			getGift().setDate(dateFormat);
			getGift().setObservations(observation);
			setGift(getGift());
			dispose();
		}	
	}	
}
