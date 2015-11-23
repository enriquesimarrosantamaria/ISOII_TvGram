package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JToolBar;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ListSelectionModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal {

	private JFrame frame;
	private JInternalFrame ventanaTabla;
	private JButton btnAniadirFila;
	private JButton btnEliminarFila;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JTextArea taFilaSeleccionada;
	private JLabel lblFoto;
	private JScrollPane scrollPane_2;
	private JTable miTabla;
	private JPopupMenu popupMenu;
	private JMenuItem mntmAadir;
	private JMenuItem mntmEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaTabla = new JInternalFrame("");
		frame.getContentPane().add(ventanaTabla, BorderLayout.NORTH);
		ventanaTabla.setFrameIcon(null);
		ventanaTabla.setIconifiable(true);
		ventanaTabla.setMaximizable(true);
		ventanaTabla.setResizable(true);
		{
			JToolBar toolBar = new JToolBar();
			ventanaTabla.getContentPane().add(toolBar, BorderLayout.NORTH);
			{
				btnAniadirFila = new JButton("Añadir");
				btnAniadirFila.addActionListener(new BtnAniadirFilaActionListener());
				btnAniadirFila.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/ic_menu_btn_add.png")));
				toolBar.add(btnAniadirFila);
			}
			{
				btnEliminarFila = new JButton("Eliminar");
				btnEliminarFila.addActionListener(new BtnEliminarFilaActionListener());
				btnEliminarFila.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/ic_menu_delete.png")));
				toolBar.add(btnEliminarFila);
			}
		}
		{
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(50, 120));
			ventanaTabla.getContentPane().add(panel, BorderLayout.SOUTH);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				scrollPane_1 = new JScrollPane();
				panel.add(scrollPane_1);
				{
					lblFoto = new JLabel("");
					scrollPane_1.setViewportView(lblFoto);
				}
			}
			{
				taFilaSeleccionada = new JTextArea();
				panel.add(taFilaSeleccionada);
			}
		}
		scrollPane_2 = new JScrollPane();
		ventanaTabla.getContentPane().add(scrollPane_2, BorderLayout.CENTER);
		miTabla = new JTable();
		miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addPopup(miTabla, popupMenu);
		MiModeloTabla modeloTabla =new MiModeloTabla();
		miTabla.setRowHeight(50);
		miTabla.setModel(modeloTabla);
		
		
		Object[] fila2= {"300", "Acción", new
						ImageIcon(getClass().getClassLoader().getResource("presentacion/300.png")), true};
						modeloTabla.aniadeFila(fila2);
		Object[] fila3= {"Mickey Mouse", "Infantil", new
						ImageIcon(getClass().getClassLoader().getResource("presentacion/mickey.jpg")), false};
						modeloTabla.aniadeFila(fila3);
		Object[] fila4= {"Sexto Sentido", "Terror", new
						ImageIcon(getClass().getClassLoader().getResource("presentacion/poster.jpg")), true};
						modeloTabla.aniadeFila(fila4);
				
		
		
							
							ListSelectionModel rowSM = miTabla.getSelectionModel();
							
							TableColumn columnaRazas = miTabla.getColumnModel().getColumn(1);
							TableColumn columnaFoto = miTabla.getColumnModel().getColumn(2);
							
							{
								popupMenu = new JPopupMenu();
								addPopup(scrollPane_2, popupMenu);
								{
									mntmAadir = new JMenuItem("Añadir");
									mntmAadir.addActionListener(new BtnAniadirFilaActionListener());
									mntmAadir.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/ic_menu_btn_add.png")));
									popupMenu.add(mntmAadir);
								}
								{
									mntmEliminar = new JMenuItem("Eliminar");
									mntmEliminar.addActionListener(new BtnEliminarFilaActionListener());
									mntmEliminar.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/ic_menu_delete.png")));
									popupMenu.add(mntmEliminar);
								}
							}
							
							scrollPane_2.setViewportView(miTabla);
							ventanaTabla.setVisible(true);
		{
			{
				{
					{
						
						DefaultListModel modeloLista = new DefaultListModel();
						//Añadimos dos elementos de prueba a la lista
						modeloLista.addElement("Español");
						modeloLista.addElement("Inglés");
					}
				}
				{
					{
						{
						
																				
							rowSM.addListSelectionListener(new ListSelectionListener() {
								public void valueChanged(ListSelectionEvent e) {
									ListSelectionModel lsm = (ListSelectionModel) e.getSource();
									if (!lsm.isSelectionEmpty()) {
										//int filaSeleccionada = lsm.getMinSelectionIndex() + 1;
										//taFilaSeleccionada.setText("Fila "
												//+ filaSeleccionada
												//+ " seleccionada");
										if (!lsm.isSelectionEmpty()) {
											//int filaSeleccionada = lsm.getMinSelectionIndex() + 1;
											//taFilaSeleccionada.setText("Fila "+filaSeleccionada+" seleccionada");
											MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
											int n= miTabla.getSelectedRow();
											if (n != -1)
											{
											String contenido = "Nombre :"+ modeloTabla.getValueAt(n, 0)+":\n"+"Género: "+ modeloTabla.getValueAt(n, 1)+"\n";
											contenido += (Boolean) modeloTabla.getValueAt(n, 3)?"Vista": "No Vista\n";
											taFilaSeleccionada.setText(contenido);
											lblFoto.setIcon((ImageIcon)modeloTabla.getValueAt(n, 2));
											}
										}
									}
								}
							});
							
							JComboBox comboBox = new JComboBox();
							comboBox.addItem("Acción");
							comboBox.addItem("Comedia");
							comboBox.addItem("Suspense");
							comboBox.addItem("Drama");
							comboBox.addItem("Terror");
							columnaRazas.setCellEditor(new DefaultCellEditor(comboBox));
							columnaFoto.setCellEditor(new ColumnaFotoEditor());
						}
					}
				}
			}
		}
	}
	private class BtnAniadirFilaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
			Object[] nuevaFila = {"...", "...", new
			ImageIcon(getClass().getClassLoader().getResource("presentacion/video.png")),false};
			modeloTabla.aniadeFila(nuevaFila);
			modeloTabla.fireTableDataChanged();
			taFilaSeleccionada.setText("");
		}
	}
	private class BtnEliminarFilaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
			int n= miTabla.getSelectedRow();
			if (n != -1) modeloTabla.eliminaFila(miTabla.getSelectedRow());
			modeloTabla.fireTableDataChanged();
			taFilaSeleccionada.setText("");
			lblFoto.setIcon(null);
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

