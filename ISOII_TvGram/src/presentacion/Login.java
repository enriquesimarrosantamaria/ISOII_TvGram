package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblUsuario;
	private JTextField txtNombre;
	private JLabel lblPassword;
	private JPasswordField pwdfPassword;
	private JLabel label;
	private JButton btnEntrar;
	private JPanel panel_1;
	private final String password="iso2";
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(Color.GREEN);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TV-Gram", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(0, 0, 434, 265);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			{
				label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setSize(new Dimension(100, 100));
				label.setIcon(new ImageIcon(Login.class.getResource("/presentacion/palomitas.png")));
				label.setBounds(10, 33, 139, 174);
				panel.add(label);
			}
			{
				panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(222, 184, 135)));
				panel_1.setBounds(161, 25, 252, 194);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					lblUsuario = new JLabel("Usuario:");
					lblUsuario.setBounds(11, 24, 61, 14);
					panel_1.add(lblUsuario);
				}
				{
					txtNombre = new JTextField();
					txtNombre.addActionListener(new TxtUsuarioActionListener());
					txtNombre.setBounds(99, 21, 134, 20);
					panel_1.add(txtNombre);
					txtNombre.setColumns(10);
				}
				{
					lblPassword = new JLabel("Contraseña:");
					lblPassword.setEnabled(false);
					lblPassword.setBounds(10, 71, 87, 14);
					panel_1.add(lblPassword);
				}
				{
					pwdfPassword = new JPasswordField();
					pwdfPassword.addKeyListener(new PwdfPasswordKeyListener());
					
					
					pwdfPassword.setEnabled(false);
					pwdfPassword.setBounds(99, 68, 134, 20);
					panel_1.add(pwdfPassword);
				}
				{
					btnEntrar = new JButton("Entrar");
					btnEntrar.setEnabled(false);
					btnEntrar.addActionListener(new BtnEntrarActionListener());
					btnEntrar.setBounds(123, 130, 63, 23);
					panel_1.add(btnEntrar);
				}
			}
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Usuarios usuario = new Usuarios(txtNombre.getText());
			Principal segundaVentana = new Principal();
			frame.dispose();
			//segundaVentana.setVisible(true);
		}
	}
	private class TxtUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
					//Activamos los de la contraseña
				pwdfPassword.setEnabled(true);
				lblPassword.setEnabled(true);
					//Pasamos el foco (el cursor) al campo de la contraseña
					pwdfPassword.requestFocus();
		}
	}
	private class PwdfPasswordKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (pwdfPassword.getText().equals("iso2")) {
				pwdfPassword.setBorder(bordeVerde);
				//lblCheck.setIcon(new ImageIcon(agenda.class.getResource("/presentacion/tick.png")));
				btnEntrar.setEnabled(true);
				
			} else{
				pwdfPassword.setBorder(bordeRojo);
				//lblCheck.setIcon(new ImageIcon(agenda.class.getResource("/presentacion/cross.png"))); }
			}
		}
	}
	
	
	
}
