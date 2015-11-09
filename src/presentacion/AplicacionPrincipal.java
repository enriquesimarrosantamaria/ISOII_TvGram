package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import dominio.Contacto;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AplicacionPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnAñadir;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JList list;
	private JPanel cuestionario;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JTextField txtNombre;
	private JTextField txtNumero;
	private DefaultListModel dlm=new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionPrincipal frame = new AplicacionPrincipal();
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
	public AplicacionPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnAñadir = new JButton("Añadir");
			btnAñadir.addActionListener(new BtnAñadirActionListener());
			btnAñadir.setBounds(374, 70, 117, 29);
			contentPane.add(btnAñadir);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new BtnModificarActionListener());
			btnModificar.setBounds(374, 134, 117, 29);
			contentPane.add(btnModificar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new BtnBorrarActionListener());
			btnBorrar.setBounds(374, 206, 117, 29);
			contentPane.add(btnBorrar);
		}
		{
			list = new JList();
			list.addListSelectionListener(new ListListSelectionListener());
			list.setBounds(27, 25, 202, 210);
			contentPane.add(list);
		}
		{
			cuestionario = new JPanel();
			cuestionario.setBounds(22, 258, 492, 119);
			contentPane.add(cuestionario);
			cuestionario.setLayout(null);
			{
				lblTelefono = new JLabel("Telefono:");
				lblTelefono.setBounds(82, 48, 86, 14);
				cuestionario.add(lblTelefono);
			}
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(82, 11, 63, 14);
				cuestionario.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(157, 8, 234, 20);
				cuestionario.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtNumero = new JTextField();
				txtNumero.setBounds(157, 45, 234, 20);
				cuestionario.add(txtNumero);
				txtNumero.setColumns(10);
			}
		}
		
		//DefaultListModel model = new DefaultListModel();
			
		try{
			//DefaultListModel dlm=new DefaultListModel();
			// Apertura del fichero y creacion de BufferedReader
			File archivo = new File("/Users/Kike_Joek/Dropbox/workspace/ISOII_AM_2/src/presentacion/lista.txt");
			//File archivo = new File("/presentacion/lista.txt");
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			// Lectura del fichero linea a linea
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
				//list.append(linea+"\n");
				//textArea.append(linea+"\n");
				dlm.addElement(linea);
				list.setModel(dlm);
				
			}
			br.close();
			//System.out.println("Fichero leído : " + file.getName() + ".");
		}
		catch (IOException ioe){
			System.out.println("Problemas mientras se leía el archivo");
		} 
	}
	
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			Contacto contactos=new Contacto(txtNombre.getText());	
			dlm.addElement(contactos.getNombre());
			//list.setModel(dlm);
			
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index=list.getSelectedIndex();
			dlm.remove(index);
			Contacto contactos=new Contacto(txtNombre.getText());
			dlm.add(index,contactos.getNombre());
			list.setModel(dlm);
			
		}
	}
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//DefaultListModel modelo = (DefaultListModel) list.getModel(); 
			int index = list.getSelectedIndex();
			dlm.remove( index );
			list.setModel(dlm);
		}
	}
	private class ListListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			int index = list.getSelectedIndex();
			txtNombre.setText((String) dlm.getElementAt(index));
		}
	}
}
