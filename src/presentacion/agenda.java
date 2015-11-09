package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import dominio.Contacto;

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

public class agenda {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblUsuario;
	private JTextField txtNombre;
	private JLabel lblPassword;
	private JPasswordField pwdfPassword;
	private JLabel lblAviso;
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
					agenda window = new agenda();
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
	public agenda() {
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
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agenda", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel.setBounds(0, 0, 434, 265);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			{
				label = new JLabel("");
				label.setSize(new Dimension(100, 100));
				label.setIcon(new ImageIcon(agenda.class.getResource("/presentacion/contactos-de-la-agenda-icono-5659-128.png")));
				label.setBounds(10, 42, 135, 140);
				panel.add(label);
			}
			{
				panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(222, 184, 135)));
				panel_1.setBounds(165, 25, 248, 194);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					lblUsuario = new JLabel("Usuario:");
					lblUsuario.setBounds(11, 24, 40, 14);
					panel_1.add(lblUsuario);
				}
				{
					txtNombre = new JTextField();
					txtNombre.addActionListener(new TxtUsuarioActionListener());
					txtNombre.setBounds(84, 21, 154, 20);
					panel_1.add(txtNombre);
					txtNombre.setColumns(10);
				}
				{
					lblPassword = new JLabel("Contraseña");
					lblPassword.setEnabled(false);
					lblPassword.setBounds(10, 71, 56, 14);
					panel_1.add(lblPassword);
				}
				{
					pwdfPassword = new JPasswordField();
					pwdfPassword.addKeyListener(new PwdfPasswordKeyListener());
					
					
					pwdfPassword.setEnabled(false);
					pwdfPassword.setBounds(84, 68, 154, 20);
					panel_1.add(pwdfPassword);
				}
				{
					lblAviso = new JLabel("");
					lblAviso.setOpaque(true);
					lblAviso.setBounds(84, 99, 154, 14);
					panel_1.add(lblAviso);
				}
				{
					btnEntrar = new JButton("Entrar");
					btnEntrar.setEnabled(false);
					btnEntrar.addActionListener(new BtnEntrarActionListener());
					btnEntrar.setBounds(123, 130, 84, 23);
					panel_1.add(btnEntrar);
				}
			}
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Usuarios usuario = new Usuarios(txtNombre.getText());
			AplicacionPrincipal segundaVentana = new AplicacionPrincipal();
			
			segundaVentana.setVisible(true);
		}
	}
	private class TxtUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblAviso.setText("Evento de acción: ActionPerformed"+e.getActionCommand() );
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
	//Nuevo
	
	
	
}
