package igu;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

/**
 * Titulo: Clase VentanaRegistro
 *  
 * @author UO281847
 * @version 09/10/2021
 */
public class VentanaRegistro extends JDialog {
	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo btSiguiente
	 */
	private JButton btSiguiente;
	/**
	 * Atributo pnPedido
	 */
	private JPanel pnPedido;
	/**
	 * Atributo rdLocal
	 */
	private JRadioButton rdLocal;
	/**
	 * Atributo rdLlevar
	 */
	private JRadioButton rdLlevar;
	/**
	 * Atributo btCancelar
	 */
	private JButton btCancelar;
	/**
	 * Atributo pnCliente
	 */
	private JPanel pnCliente;
	/**
	 * Atributo buttonGroup
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Atributo lblPassword
	 */
	private JLabel lblPassword;
	/**
	 * Atributo lblReintroduzcaPassword
	 */
	private JLabel lblReintroduzcaPassword;
	/**
	 * Atributo lblAñoDeNacimiento
	 */
	private JLabel lblAñoDeNacimiento;
	/**
	 * Atributo lblNameSurname
	 */
	private JLabel lblNameSurname;
	/**
	 * Atributo cbNacimiento
	 */
	private JComboBox<String> cbNacimiento;
	/**
	 * Atributo pwPassR
	 */
	private JPasswordField pwPassR;
	/**
	 * Atributo pwPass
	 */
	private JPasswordField pwPass;
	/**
	 * Atributo pwNameSurname
	 */
	private JTextField tfNameSurname;
	/**
	 * Atributo vP
	 */
	private VentanaPrincipal vP;
	
	/**
	 * Constructor de la ventana registro
	 */
	public VentanaRegistro(VentanaPrincipal vPrin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/logo.png")));
		vP = vPrin;
		setTitle("McDonald's: Datos de Registro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtSiguiente());
		contentPane.add(getPnPedido());
		contentPane.add(getBtCancelar());
		contentPane.add(getPnCliente());	
	}	
	
	/**
	 * Método que muestra la ventana de confirmación
	 */
	private void mostrarVentanaConfirmacion() {
		VentanaConfirmacion vConfirmacion = new VentanaConfirmacion(this);
		vConfirmacion.setLocationRelativeTo(this);
		vConfirmacion.setModal(true);
		vConfirmacion.setVisible(true);
	}
	
	public VentanaPrincipal getVp() {
		return vP;
	}
	
	/**
	 * Método que crea el botón siguiente
	 * 
	 * @return btSiguiente, button
	 */
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("SIguiente");
			btSiguiente.setToolTipText("Solicitar el pedido");
			btSiguiente.setMnemonic('S');
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarFormulario();
				}
			});
			btSiguiente.setForeground(new Color(255, 255, 255));
			btSiguiente.setBackground(new Color(0, 128, 0));
			btSiguiente.setBounds(441, 318, 93, 32);
		}
		return btSiguiente;
	}	
	
	/**
	 * Método que valida que se pueda entrar
	 *  
	 * @return true o false
	 */
	private boolean isValido() {
		if (!getTfNameSurname().getText().isEmpty() && 
				!String.valueOf(getPwPass().getPassword()).isEmpty() &&
				!String.valueOf(getPwPassR().getPassword()).isEmpty() && diffPass()){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Método que comprueba si la contraseña es distinta
	 * 
	 * @return true o false
	 */
	private boolean diffPass() {
		return String.valueOf(getPwPass().getPassword()).equals(String.valueOf(getPwPassR().getPassword()));
	}
	
	/**
	 * Método que valida el formulario
	 */
	private void validarFormulario() {
		if (isValido()) {
			mostrarVentanaConfirmacion();
		} else {
			JOptionPane.showMessageDialog(null, "Error: Pruebe otra vez");
		}		
	}
	
	/**
	 * Método que crea el panel del pedido
	 * 
	 * @return pnPedido, panel
	 */
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setAlignmentY(Component.TOP_ALIGNMENT);
			pnPedido.setAlignmentX(Component.LEFT_ALIGNMENT);
			pnPedido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, 
					new Color(255, 255, 255), new Color(160, 160, 160)), "Pedido", 
					TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			pnPedido.setBackground(new Color(255, 255, 255));
			pnPedido.setBounds(10, 256, 325, 94);
			pnPedido.setLayout(null);
			pnPedido.add(getRdLocal());
			pnPedido.add(getRdLlevar());
		}
		return pnPedido;
	}
	
	/**
	 * Método que crea el botón de selección local
	 * 
	 * @return rdLocal, botón de selección
	 */
	private JRadioButton getRdLocal() {
		if (rdLocal == null) {
			rdLocal = new JRadioButton("Local");
			rdLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vP.setEnLocal(true);
				}
			});
			rdLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdLocal.setMnemonic('L');
			rdLocal.setToolTipText("Pedir para consumir en el local");
			rdLocal.setBounds(46, 41, 78, 23);
			buttonGroup.add(rdLocal);
			rdLocal.setSelected(true);
			rdLocal.setBackground(new Color(255, 255, 255));
		}
		return rdLocal;
	}	
	
	/**
	 * Método que crea el botón de selección llevar
	 * 
	 * @return rdLlevar, botón de selección
	 */
	private JRadioButton getRdLlevar() {
		if (rdLlevar == null) {
			rdLlevar = new JRadioButton("Llevar");
			rdLlevar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vP.setEnLocal(false);
				}
			});
			rdLlevar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdLlevar.setMnemonic('T');
			rdLlevar.setToolTipText("Pedir para consumir para llevar");
			rdLlevar.setBounds(178, 41, 78, 23);
			buttonGroup.add(rdLlevar);
			rdLlevar.setBackground(Color.WHITE);
		}
		return rdLlevar;
	}	
	
	/**
	 * Método que crea el botón de cancelar
	 * 
	 * @return btCancelar, button
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setToolTipText("Modificar el pedido");
			btCancelar.setMnemonic('C');
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCancelar.setForeground(new Color(255, 255, 255));
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(581, 318, 93, 32);
		}
		return btCancelar;
	}	
	
	/**
	 * Método que crea el panel de cliente
	 * 
	 * @return pnCliente, panel
	 */
	private JPanel getPnCliente() {
		if (pnCliente == null) {
			pnCliente = new JPanel();
			pnCliente.setLayout(null);
			pnCliente.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, 
					new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Cliente", 
					TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			pnCliente.setBackground(Color.WHITE);
			pnCliente.setAlignmentY(0.0f);
			pnCliente.setAlignmentX(0.0f);
			pnCliente.setBounds(10, 11, 664, 226);
			pnCliente.add(getLblPassword());
			pnCliente.add(getLblReintroduzcaPassword());
			pnCliente.add(getLblAñoDeNacimiento());
			pnCliente.add(getLblNameSurname());
			pnCliente.add(getCbNacimiento());
			pnCliente.add(getPwPassR());
			pnCliente.add(getPwPass());
			pnCliente.add(getTfNameSurname());
		}
		return pnCliente;
	}	
	
	/**
	 * Método que crea la etiqueta de la contraseña
	 * 
	 * @return lblPassword, etiqueta
	 */
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPassword.setBounds(10, 148, 94, 14);
		}
		return lblPassword;
	}	
	
	/**
	 * Método que crea la etiqueta de reintroducir la contraseña
	 * 
	 * @return lblReintroduzcaPassword, etiqueta
	 */
	private JLabel getLblReintroduzcaPassword() {
		if (lblReintroduzcaPassword == null) {
			lblReintroduzcaPassword = new JLabel("Reintroduzca password:");
			lblReintroduzcaPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblReintroduzcaPassword.setBounds(10, 194, 161, 14);
		}
		return lblReintroduzcaPassword;
	}
	
	/**
	 * Método que crea la etiqueta de introducir el año de nacimiento
	 * 
	 * @return lblAñoDeNacimiento, etiqueta
	 */
	private JLabel getLblAñoDeNacimiento() {
		if (lblAñoDeNacimiento == null) {
			lblAñoDeNacimiento = new JLabel("A\u00F1o de nacimiento:");
			lblAñoDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblAñoDeNacimiento.setBounds(10, 96, 116, 14);
		}
		return lblAñoDeNacimiento;
	}	
	
	/**
	 * Método que crea la etiqueta de nombre y apellidos
	 * 
	 * @return lblNameSurname, etiqueta
	 */
	private JLabel getLblNameSurname() {
		if (lblNameSurname == null) {
			lblNameSurname = new JLabel("Nombre y Apellidos:");
			lblNameSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNameSurname.setBounds(10, 42, 116, 14);
		}
		return lblNameSurname;
	}	
	
	/**
	 * Método que crea el combobox
	 * 
	 * @return cbNacimiento, combobox
	 */
	private JComboBox<String> getCbNacimiento() {
		if (cbNacimiento == null) {			
			String[] años = new String[90];
			for (int i=0; i<90; i++) {
				años[i]=""+((90-i)+1920);
			}
			cbNacimiento = new JComboBox<String>();
			cbNacimiento.setToolTipText("Seleccione su a\u00F1o de nacimiento");
			cbNacimiento.setModel(new DefaultComboBoxModel<String>(años));
			cbNacimiento.setSelectedIndex(8);
			cbNacimiento.setBounds(242, 90, 116, 27);
		}
		return cbNacimiento;
	}	
	
	/**
	 * Método que crea el lugar para reintroducir la contraseña
	 * 
	 * @return pwPassR, passwordField
	 */
	private JPasswordField getPwPassR() {
		if (pwPassR == null) {
			pwPassR = new JPasswordField();
			pwPassR.setToolTipText("Introduzca su contrase\u00F1a");
			pwPassR.setBounds(242, 142, 322, 27);
		}
		return pwPassR;
	}	
	
	/**
	 * Método que crea el lugar para reintroducir la contraseña
	 * 
	 * @return pwPass, passwordField
	 */
	private JPasswordField getPwPass() {
		if (pwPass == null) {
			pwPass = new JPasswordField();
			pwPass.setToolTipText("Confirme su contrase\u00F1a");
			pwPass.setBounds(242, 188, 322, 27);
		}
		return pwPass;
	}
	
	/**
	 * Método que crea el lugar para introducir el nombre y apellidos
	 * 
	 * @return tfNameSurname, textField
	 */
	private JTextField getTfNameSurname() {
		if (tfNameSurname == null) {
			tfNameSurname = new JTextField();
			tfNameSurname.setToolTipText("Escriba su nombre y apellidos");
			tfNameSurname.setColumns(10);
			tfNameSurname.setBounds(242, 36, 400, 27);
		}
		return tfNameSurname;
	}
}
