package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5767732953572960676L;
	private JPanel contentPane;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getP1(), "p1");
		contentPane.add(getP2(), "p2");
		contentPane.add(getP3(), "p3");
	}

	private JPanel getP1() {
		if (p1 == null) {
			p1 = new JPanel();
			p1.setBackground(Color.YELLOW);
		}
		return p1;
	}
	private JPanel getP2() {
		if (p2 == null) {
			p2 = new JPanel();
			p2.setBackground(Color.BLUE);
		}
		return p2;
	}
	private JPanel getP3() {
		if (p3 == null) {
			p3 = new JPanel();
			p3.setBackground(Color.GREEN);
		}
		return p3;
	}
}
