package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.File;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.ComponentOrientation;

/**
 * Titulo: Clase VentanaPrincipal
 * 
 * @author UO281847
 * @version 07/11/2021
 */
public class VentanaPrincipal extends JFrame {
	/**
	 * Constante serialVersionUID
	 */
	private static final long serialVersionUID = 5767732953572960676L;
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo panelNorte
	 */
	private JPanel panelNorte;
	/**
	 * Atributo lblLogo
	 */
	private JLabel lblLogo;
	/**
	 * Atributo sliderVolumen
	 */
	private JSlider sliderVolumen;
	/**
	 * Atributo panelVolumen
	 */
	private JPanel panelVolumen;
	/**
	 * Atributo lblVolumen
	 */
	private JLabel lblVolumen;
	/**
	 * Atributo textVolumen
	 */
	private JTextField textVolumen;
	/**
	 * Atributo panelCentro
	 */
	private JPanel panelCentro;
	/**
	 * Atributo panelLibreria
	 */
	private JPanel panelLibreria;
	/**
	 * Atributo panelPlay
	 */
	private JPanel panelPlay;
	/**
	 * Atributo lblLibreria
	 */
	private JLabel lblLibreria;
	/**
	 * Atributo panelBotonesLibreria
	 */
	private JPanel panelBotonesLibreria;
	/**
	 * Atributo lblPlaylist
	 */
	private JLabel lblPlaylist;
	/**
	 * Atributo panelBotonesPlay
	 */
	private JPanel panelBotonesPlay;
	/**
	 * Atributo btnAddToPlaylist
	 */
	private JButton btnAddToPlaylist;
	/**
	 * Atributo btnDelL
	 */
	private JButton btnDelL;
	/**
	 * Atributo btnPlay
	 */
	private JButton btnPlay;
	/**
	 * Atributo btnStop
	 */
	private JButton btnStop;
	/**
	 * Atributo btnNext
	 */
	private JButton btnNext;
	/**
	 * Atributo btnPrev
	 */
	private JButton btnPrev;
	/**
	 * Atributo scrollListaLibreria
	 */
	private JScrollPane scrollListaLibreria;
	/**
	 * Atributo btnDelP
	 */
	private JButton btnDelP;
	/**
	 * Atributo tglbtnMute
	 */
	private JToggleButton tglbtnMute;
	/**
	 * Atributo scrollListaPlay
	 */
	private JScrollPane scrollListaPlay;
	/**
	 * Atributo listPlay
	 */
	private JList<File> listPlay;
	/**
	 * Atributo listLibrary
	 */
	private JList<File> listLibrary;
	/**
	 * Atributo modeloListPlay
	 */
	private DefaultListModel<File> modeloListPlay;
	/**
	 * Atributo modeloListLib
	 */
	private DefaultListModel<File> modeloListLib;
	/**
	 * Atributo menuBarPlayer
	 */
	private JMenuBar menuBarPlayer;
	/**
	 * Atributo mnFile
	 */
	private JMenu mnFile;
	/**
	 * Atributo mntmOpen
	 */
	private JMenuItem mntmOpen;
	/**
	 * Atributo mntmExit
	 */
	private JMenuItem mntmExit;
	/**
	 * Atributo mnPlay
	 */
	private JMenu mnPlay;
	/**
	 * Atributo mnOptions
	 */
	private JMenu mnOptions;
	/**
	 * Atributo mnHelp
	 */
	private JMenu mnHelp;
	/**
	 * Atributo mntmContents
	 */
	private JMenuItem mntmContents;
	/**
	 * Atributo separator
	 */
	private JSeparator separator;
	/**
	 * Atributo mntmAbout
	 */
	private JMenuItem mntmAbout;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo2.png")));
		setTitle("BatPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBarPlayer());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
	}
	/**
	 * Devuelve el panel Norte
	 * @return panelNorte
	 */
	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setBackground(Color.BLACK);
			panelNorte.setLayout(new GridLayout(1, 3, 0, 0));
			panelNorte.add(getLblLogo());
			panelNorte.add(getSliderVolumen());
			panelNorte.add(getPanelVolumen());
		}
		return panelNorte;
	}	
	/**
	 * Devuelve el logo
	 * @return lblLogo
	 */
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setBackground(Color.BLACK);
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoBatplayer.png")));
		}
		return lblLogo;
	}
	/**
	 * Devuelve el slider
	 * @return sliderVolumen
	 */
	private JSlider getSliderVolumen() {
		if (sliderVolumen == null) {
			sliderVolumen = new JSlider();
			sliderVolumen.setToolTipText("Mueva la barra para subir o bajar el volumen");
			sliderVolumen.setIgnoreRepaint(true);
			sliderVolumen.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			sliderVolumen.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			sliderVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					pintaYCambiaVolumen();
				}
			});
			sliderVolumen.setPaintLabels(true);
			sliderVolumen.setPaintTicks(true);
			sliderVolumen.setForeground(Color.RED);
			sliderVolumen.setMajorTickSpacing(20);
			sliderVolumen.setMinorTickSpacing(5);
			sliderVolumen.setBackground(Color.BLACK);
		}
		return sliderVolumen;
	}
	/**
	 * Método que pinta y cambia el volumen
	 */
	private void pintaYCambiaVolumen() {
		getTextVolumen().setText(String.valueOf(getSliderVolumen().getValue()));
	}
	/**
	 * Devuelve el panel de volumen
	 * @return panelVolumen
	 */
	private JPanel getPanelVolumen() {
		if (panelVolumen == null) {
			panelVolumen = new JPanel();
			panelVolumen.setAlignmentX(Component.LEFT_ALIGNMENT);
			panelVolumen.setAlignmentY(Component.TOP_ALIGNMENT);
			panelVolumen.setBackground(Color.BLACK);
			panelVolumen.setLayout(null);
			panelVolumen.add(getLblVolumen());
			panelVolumen.add(getTextVolumen());
		}
		return panelVolumen;
	}
	/**
	 * Devuelve la etiqueta volumen
	 * @return lblVolumen
	 */
	private JLabel getLblVolumen() {
		if (lblVolumen == null) {
			lblVolumen = new JLabel("Vol:");
			lblVolumen.setBounds(35, 15, 84, 30);
			lblVolumen.setFont(new Font("BatmanForeverOutline", Font.BOLD, 30));
			lblVolumen.setForeground(Color.RED);
			lblVolumen.setBackground(Color.BLACK);
		}
		return lblVolumen;
	}
	/**
	 * Devuelve el texto de volumen
	 * @return textVolumen
	 */
	private JTextField getTextVolumen() {
		if (textVolumen == null) {
			textVolumen = new JTextField();
			textVolumen.setBounds(129, 11, 105, 35);
			textVolumen.setBorder(null);
			textVolumen.setFont(new Font("BatmanForeverAlternate", Font.PLAIN, 35));
			textVolumen.setForeground(Color.WHITE);
			textVolumen.setBackground(Color.BLACK);
			textVolumen.setEditable(false);
			textVolumen.setColumns(3);
			textVolumen.setText(String.valueOf(getSliderVolumen().getValue()));
		}
		return textVolumen;
	}
	/**
	 * Devuelve el panel central
	 * @return panelCentro
	 */
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setBackground(Color.BLACK);
			panelCentro.setLayout(new GridLayout(0, 2, 5, 0));
			panelCentro.add(getPanelLibreria());
			panelCentro.add(getPanelPlay());
		}
		return panelCentro;
	}
	/**
	 * Devuelve el panel de la libreria
	 * @return panelLiberia
	 */
	private JPanel getPanelLibreria() {
		if (panelLibreria == null) {
			panelLibreria = new JPanel();
			panelLibreria.setBackground(Color.BLACK);
			panelLibreria.setLayout(new BorderLayout(0, 0));
			panelLibreria.add(getLblLibreria(), BorderLayout.NORTH);
			panelLibreria.add(getPanelBotonesLibreria(), BorderLayout.SOUTH);
			panelLibreria.add(getScrollListaLibreria(), BorderLayout.CENTER);
		}
		return panelLibreria;
	}
	/**
	 * Devuelve el panel de play
	 * @return panelPlay
	 */
	private JPanel getPanelPlay() {
		if (panelPlay == null) {
			panelPlay = new JPanel();
			panelPlay.setBackground(Color.BLACK);
			panelPlay.setLayout(new BorderLayout(0, 0));
			panelPlay.add(getLblPlaylist(), BorderLayout.NORTH);
			panelPlay.add(getPanelBotonesPlay(), BorderLayout.SOUTH);
			panelPlay.add(getScrollListaPlay(), BorderLayout.CENTER);
		}
		return panelPlay;
	}
	/**
	 * Devuelve la etiqueta liberia
	 * @return lblLibreria
	 */
	private JLabel getLblLibreria() {
		if (lblLibreria == null) {
			lblLibreria = new JLabel("\u266A" + " Library:");
			lblLibreria.setHorizontalAlignment(SwingConstants.CENTER);
			lblLibreria.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblLibreria.setForeground(Color.RED);
			lblLibreria.setBackground(Color.BLACK);
		}
		return lblLibreria;
	}
	/**
	 * Debuelve el panel botones de la libreria
	 * @return panelBotonesLibreria
	 */
	private JPanel getPanelBotonesLibreria() {
		if (panelBotonesLibreria == null) {
			panelBotonesLibreria = new JPanel();
			panelBotonesLibreria.setLayout(new GridLayout(1, 2, 0, 0));
			panelBotonesLibreria.add(getBtnAddToPlaylist());
			panelBotonesLibreria.add(getBtnDelL());
		}
		return panelBotonesLibreria;
	}
	/**
	 * Devuelve la etiquetaPlayList
	 * @return lblPlaylist
	 */
	private JLabel getLblPlaylist() {
		if (lblPlaylist == null) {
			lblPlaylist = new JLabel("\u266A" + " Playlist:");
			lblPlaylist.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlaylist.setForeground(Color.RED);
			lblPlaylist.setBackground(Color.BLACK);
			lblPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblPlaylist;
	}
	/**
	 * Devuelve el panel de botones play
	 * @return panelBotonesPlay
	 */
	private JPanel getPanelBotonesPlay() {
		if (panelBotonesPlay == null) {
			panelBotonesPlay = new JPanel();
			panelBotonesPlay.setLayout(new GridLayout(1, 6, 0, 0));
			panelBotonesPlay.add(getBtnDelP());
			panelBotonesPlay.add(getBtnPlay());
			panelBotonesPlay.add(getBtnStop());
			panelBotonesPlay.add(getBtnNext());
			panelBotonesPlay.add(getBtnPrev());
			panelBotonesPlay.add(getTglbtnMute());
		}
		return panelBotonesPlay;
	}
	/**
	 * Devuelve el boton de añadir a la playlist
	 * @return btnAddToPlaylist
	 */
	private JButton getBtnAddToPlaylist() {
		if (btnAddToPlaylist == null) {
			btnAddToPlaylist = new JButton("Add To Playlist");
			btnAddToPlaylist.setToolTipText("A\u00F1ada las canciones seleccionadas a la Playlist");
			btnAddToPlaylist.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnAddToPlaylist;
	}
	/**
	 * Devuelve el boton Del
	 * @return btnDel
	 */
	private JButton getBtnDelL() {
		if (btnDelL == null) {
			btnDelL = new JButton("Del");
			btnDelL.setToolTipText("Elimine las canciones seleccionadas");
			btnDelL.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnDelL;
	}
	/**
	 * Devuelve el boton de play
	 * @return btnPlay
	 */
	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("\u25C4\u25C4");
			btnPlay.setToolTipText("Canci\u00F3n anterior");
			btnPlay.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnPlay;
	}
	/**
	 * Devuelve el boton de stop
	 * @return btnStop
	 */
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("\u25BA");
			btnStop.setToolTipText("Reproduzca la canci\u00F3n");
			btnStop.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnStop;
	}
	/**
	 * Devuelve el boton next
	 * @return btnNext
	 */
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("\u25A0");
			btnNext.setToolTipText("Pare la canci\u00F3n");
			btnNext.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return btnNext;
	}
	/**
	 * Devuelve el boton prev
	 * @return btnPrev
	 */
	private JButton getBtnPrev() {
		if (btnPrev == null) {
			btnPrev = new JButton("\u25BA\u25BA");
			btnPrev.setToolTipText("Canci\u00F3n posterior");
			btnPrev.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnPrev;
	}
	/**
	 * Devuelve el panel de scroll de la libreria
	 * @return scrollListaLibreria
	 */
	private JScrollPane getScrollListaLibreria() {
		if (scrollListaLibreria == null) {
			scrollListaLibreria = new JScrollPane();
			scrollListaLibreria.setBorder(new LineBorder(Color.RED, 4));
			scrollListaLibreria.setViewportView(getListLibrary());
		}
		return scrollListaLibreria;
	}
	/**
	 * Devuelve el boton DelP
	 * @return btnDelP
	 */
	private JButton getBtnDelP() {
		if (btnDelP == null) {
			btnDelP = new JButton("Del");
			btnDelP.setToolTipText("Elimine las canciones seleccionadas de la Playlist");
			btnDelP.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnDelP;
	}	
	/**
	 * Devuelve el boton de mute
	 * @return tglbtnMute
	 */
	private JToggleButton getTglbtnMute() {
		if (tglbtnMute == null) {
			tglbtnMute = new JToggleButton("");
			tglbtnMute.setToolTipText("Quitar volumen");
			tglbtnMute.setSelectedIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/volume_off.jpg")));
			tglbtnMute.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/volume_on.jpg")));
			tglbtnMute.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return tglbtnMute;
	}
	/**
	 * Devuelve el panel de scroll de play
	 * @return scrollListaPlay
	 */
	private JScrollPane getScrollListaPlay() {
		if (scrollListaPlay == null) {
			scrollListaPlay = new JScrollPane();
			scrollListaPlay.setBorder(new LineBorder(Color.RED, 4));
			scrollListaPlay.setViewportView(getListPlay());
		}
		return scrollListaPlay;
	}
	/**
	 * Devuelve la lista de la libreria
	 * @return listLibrary
	 */
	private JList<File> getListLibrary() {
		if (listLibrary == null) {
			modeloListLib = new DefaultListModel<File>();
			listLibrary = new JList<File>(modeloListLib);
			listLibrary.setBackground(Color.BLACK);
			listLibrary.setForeground(Color.WHITE);
		}
		return listLibrary;
	}
	/**
	 * Devuelve la lista del play
	 * @return listPlay
	 */
	private JList<File> getListPlay() {
		if (listPlay == null) {
			modeloListPlay= new DefaultListModel<File>();
			listPlay = new JList<File>(modeloListPlay);
			listPlay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPlay.setForeground(Color.WHITE);
			listPlay.setBackground(Color.BLACK);
		}
		return listPlay;
	}
	/**
	 * Devuelve la barra de menu
	 * @return menuBarPlayer
	 */
	private JMenuBar getMenuBarPlayer() {
		if (menuBarPlayer == null) {
			menuBarPlayer = new JMenuBar();
			menuBarPlayer.add(getMnFile());
			menuBarPlayer.add(getMnPlay());
			menuBarPlayer.add(getMnOptions());
			menuBarPlayer.add(getMnHelp());
		}
		return menuBarPlayer;
	}
	/**
	 * Devuelve el menu file
	 * @return mnFile
	 */
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	/**
	 * Devuelve el menu item Open
	 * @return mntmOpen
	 */
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
		}
		return mntmOpen;
	}
	/**
	 * Devuelve el menu item exit
	 * @return mtnmExit
	 */
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
		}
		return mntmExit;
	}
	/**
	 * Devuelve el menu play
	 * @return mnPlay
	 */
	private JMenu getMnPlay() {
		if (mnPlay == null) {
			mnPlay = new JMenu("Play");
		}
		return mnPlay;
	}
	/**
	 * Devuelve el menu options
	 * @return mnOptions
	 */
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
		}
		return mnOptions;
	}
	/**
	 * Devuelve el menu de ayuda
	 * @return mnHelp
	 */
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmContents());
			mnHelp.add(getMntmAbout());
			mnHelp.add(getSeparator());
		}
		return mnHelp;
	}
	/**
	 * Devuelve el menu item de contenidos
	 * @return mntmContents
	 */
	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContents;
	}
	/**
	 * Devuelve el separador
	 * @return separator
	 */
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	/**
	 * Devuelve el menu item about
	 * @return mntmAbout
	 */
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}
}
