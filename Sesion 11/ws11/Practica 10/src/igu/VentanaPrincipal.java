package igu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.help.*;
import java.net.*;

import player.MusicPlayer;
import player.MyFile;

import javax.swing.event.ChangeEvent;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Insets;

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
	private JButton btnPrev;
	/**
	 * Atributo btnStop
	 */
	private JButton btnPlay;
	/**
	 * Atributo btnNext
	 */
	private JButton btnStop;
	/**
	 * Atributo btnPrev
	 */
	private JButton btnNext;
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
	private JList<MyFile> listPlay;
	/**
	 * Atributo listLibrary
	 */
	private JList<MyFile> listLibrary;
	/**
	 * Atributo modeloListPlay
	 */
	private DefaultListModel<MyFile> modeloListPlay;
	/**
	 * Atributo modeloListLib
	 */
	private DefaultListModel<MyFile> modeloListLib;
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
	 * Atributo selector
	 */
	private JFileChooser selector;	
	/**
	 * Atributo mP
	 */
	private MusicPlayer mP;
	private JButton btnClearLibrary;
	private JButton btnClearPlay;
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(MusicPlayer mP) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				minimoVentana();
			}
		});
		this.mP = mP;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo2.png")));
		setTitle("BatPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 700);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBarPlayer());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		setMinimumSize(new Dimension(580, 400));
		cargaAyuda();
	}
	private void minimoVentana() {		
		System.out.println(this.getSize());
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
					setVolume(getSliderVolumen().getValue());
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
			panelBotonesLibreria.setLayout(new GridLayout(0, 3, 0, 0));
			panelBotonesLibreria.add(getBtnAddToPlaylist());
			panelBotonesLibreria.add(getBtnDelL());
			panelBotonesLibreria.add(getBtnClearLibrary());
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
			panelBotonesPlay.setLayout(new GridLayout(0, 7, 0, 0));
			panelBotonesPlay.add(getBtnClearPlay());
			panelBotonesPlay.add(getBtnDelP());
			panelBotonesPlay.add(getBtnPrev());
			panelBotonesPlay.add(getBtnPlay());
			panelBotonesPlay.add(getBtnStop());
			panelBotonesPlay.add(getBtnNext());
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
			btnAddToPlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirAPlayList();
				}
			});
			btnAddToPlaylist.setToolTipText("A\u00F1ada las canciones seleccionadas a la Playlist");
			btnAddToPlaylist.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnAddToPlaylist;
	}
	/**
	 * Método que añade las canciones a la playlist
	 */
	private void añadirAPlayList() {		
		for (int i = 0; i< getListLibrary().getSelectedValuesList().size(); i++) {
			if (!modeloListPlay.contains(getListLibrary().getSelectedValuesList().get(i))) {
				modeloListPlay.addElement(getListLibrary().getSelectedValuesList().get(i));
			}				
		}
	}
	/**
	 * Devuelve el boton Del
	 * @return btnDel
	 */
	private JButton getBtnDelL() {
		if (btnDelL == null) {
			btnDelL = new JButton("Del");
			btnDelL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			btnDelL.setToolTipText("Elimine las canciones seleccionadas");
			btnDelL.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnDelL;
	}
	private void delete() {
		ArrayList<MyFile> listaLib = new ArrayList<MyFile>();
		listaLib.addAll(0, getListLibrary().getSelectedValuesList());
		
		for (int i = 0; i<listaLib.size(); i++) {
			modeloListLib.removeElement(listaLib.get(i));
		}
	}
	/**
	 * Devuelve el boton de play
	 * @return btnPlay
	 */
	private JButton getBtnPrev() {
		if (btnPrev == null) {
			btnPrev = new JButton("\u25C4\u25C4");
			btnPrev.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					previous();
					setVolume(getSliderVolumen().getValue());
				}
			});
			
			btnPrev.setToolTipText("Canci\u00F3n anterior");
			btnPrev.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnPrev;
	}
	private void previous() {
		if (getListPlay().getSelectedIndex() == -1) {
			getListPlay().setSelectedIndex(0);
		} else if (getListPlay().getSelectedIndex() != -1) {
			getListPlay().setSelectedIndex(getListPlay().getSelectedIndex() -1);
		}
		mP.play(getListPlay().getSelectedValue().getF());
	}
	/**
	 * Devuelve el boton de stop
	 * @return btnStop
	 */
	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("\u25BA");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					play();
					setVolume(getSliderVolumen().getValue());
				}
			});
			btnPlay.setToolTipText("Reproduzca la canci\u00F3n");
			btnPlay.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnPlay;
	}
	private void play() {
		if (getListPlay().getSelectedIndex() == -1) {
			getListPlay().setSelectedIndex(0);
		}
		mP.play(getListPlay().getSelectedValue().getF());
	}
	/**
	 * Devuelve el boton next
	 * @return btnNext
	 */
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("\u25A0");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mP.stop();
				}
			});
			btnStop.setToolTipText("Pare la canci\u00F3n");
			btnStop.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return btnStop;
	}
	/**
	 * Devuelve el boton prev
	 * @return btnPrev
	 */
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("\u25BA\u25BA");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					next();
					setVolume(getSliderVolumen().getValue());
				}
			});
			btnNext.setToolTipText("Canci\u00F3n posterior");
			btnNext.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnNext;
	}
	private void next() {
		if (getListPlay().getSelectedIndex() == -1) {
			getListPlay().setSelectedIndex(0);
		} else if (getListPlay().getSelectedIndex() != -1) {
			getListPlay().setSelectedIndex(getListPlay().getSelectedIndex() + 1);
		} else if (getListPlay().getSelectedIndex() == getListPlay().getSelectedValuesList().size()) {
			getListPlay().setSelectedIndex(0);
		}
		mP.play(getListPlay().getSelectedValue().getF());
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
			btnDelP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListPlay.remove(getListPlay().getSelectedIndex());
				}
			});
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
			tglbtnMute.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			tglbtnMute.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/volumeOn.png")));
			tglbtnMute.setToolTipText("Quitar volumen");
			tglbtnMute.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return tglbtnMute;
	}
	private void setVolume(double vol) {
		double volMax = getSliderVolumen().getMaximum();
		mP.setVolume(vol, volMax);
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
	private JList<MyFile> getListLibrary() {
		if (listLibrary == null) {
			modeloListLib = new DefaultListModel<MyFile>();
			listLibrary = new JList<MyFile>(modeloListLib);
			listLibrary.setBackground(Color.BLACK);
			listLibrary.setForeground(Color.WHITE);
		}
		return listLibrary;
	}
	/**
	 * Devuelve la lista del play
	 * @return listPlay
	 */
	private JList<MyFile> getListPlay() {
		if (listPlay == null) {
			modeloListPlay= new DefaultListModel<MyFile>();
			listPlay = new JList<MyFile>(modeloListPlay);
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
			mnFile.setMnemonic('F');
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
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirFicheros();
				}
			});
			mntmOpen.setMnemonic('O');
		}
		return mntmOpen;
	}
	/**
	 * Método que abre los ficheros
	 */
	private void abrirFicheros() {
		int respuesta = getSelector().showOpenDialog(null);
		if (respuesta == JFileChooser.APPROVE_OPTION) {
			for (int i = 0; i< getSelector().getSelectedFiles().length; i++) {
				if (!modeloListLib.contains(getSelector().getSelectedFiles()[i])) {
					modeloListLib.addElement(new MyFile(getSelector().getSelectedFiles()[i]));
				}				
			}
		}
	}	
	/**
	 * Devuelve el menu item exit
	 * @return mtnmExit
	 */
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int respuesta = JOptionPane.showConfirmDialog(null, 
							"¿Está seguro que quiere salir del reproductor?", 
							"EII BatPlayer: Salida", JOptionPane.INFORMATION_MESSAGE);
					if (respuesta == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});
			mntmExit.setMnemonic('E');
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
			mnPlay.setMnemonic('P');
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
			mnOptions.setMnemonic('O');
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
			mnHelp.setMnemonic('H');
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
			mntmContents.setMnemonic('C');
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
			mntmAbout.setMnemonic('A');
		}
		return mntmAbout;
	}	
	/**
	 * Método que devuelve el valor del atributo selector
	 * @return selector
	 */
	public JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
			selector.setFileFilter(new FileNameExtensionFilter("Archivos mp3", "mp3"));
			
			//Fija la ruta en el directorio de ejecución del programa
//			String dirActual = System.getProperty("user.dir");
//			selector.setCurrentDirectory(new File(dirActual));
			
			//Con esta otra lo fija en el escritorio:
			String escritorio = System.getProperty("user.home") + "/Desktop/Music";
			selector.setCurrentDirectory(new File(escritorio));
		}
		return selector;
	}
	
	/**
	 * Botón que limpia la libreria
	 * @return btnClearLibrary
	 */
	private JButton getBtnClearLibrary() {
		if (btnClearLibrary == null) {
			btnClearLibrary = new JButton("Clear");
			btnClearLibrary.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListLib.removeAllElements();
				}
			});
			btnClearLibrary.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnClearLibrary;
	}
	/**
	 * Botón que limpia la playlist
	 * @return btnClearPlay
	 */
	private JButton getBtnClearPlay() {
		if (btnClearPlay == null) {
			btnClearPlay = new JButton("Clear");
			btnClearPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListPlay.removeAllElements();
				}
			});
			btnClearPlay.setMargin(new Insets(0, 0, 0, 0));
			btnClearPlay.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return btnClearPlay;
	}
	
	/**
	 * Método que carga la ayuda
	 */
	private void cargaAyuda(){
		URL hsURL;
		HelpSet hs;
	    try {
	    	File fichero = new File("help/ayuda.hs");
	    	hsURL = fichero.toURI().toURL();
	    	hs = new HelpSet(null, hsURL);
	    } catch (Exception e){
		    System.out.println("Ayuda no encontrada");
		    return;
		}
		HelpBroker hb = hs.createHelpBroker();
		hb.initPresentation();

		hb.enableHelpKey(getRootPane(),"introduccion", hs);
		hb.enableHelpOnButton(this.getMntmContents(), "introduccion", hs);
	    hb.enableHelp(getBtnPlay(), "reproducir", hs);
	    hb.enableHelp(getSliderVolumen(), "volumen", hs);
	}
}
