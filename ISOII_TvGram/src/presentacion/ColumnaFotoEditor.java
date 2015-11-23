package presentacion;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.table.*;

public class ColumnaFotoEditor extends AbstractCellEditor implements TableCellEditor {
	private JButton boton = new JButton();
	ImageIcon fotoCelda;

public ColumnaFotoEditor() { 
	boton.addActionListener(new ActionListener() {

		public void actionPerformed (ActionEvent actionEvent) { 
			JFileChooser fcAbrir = new JFileChooser();

int valorDevuelto = fcAbrir.showDialog(boton, "Cargar foto");
if (valorDevuelto == JFileChooser.APPROVE_OPTION) {

	File file = fcAbrir.getSelectedFile();
	cambiarFoto(new ImageIcon(file.getAbsolutePath()));

}
}
});
} 




public void cambiarFoto(ImageIcon imag) {
	if (imag != null) {
    fotoCelda = imag;
    boton.setIcon(imag);
	}
}

public Object getCellEditorValue() { 
	return fotoCelda;
}
public Component getTableCellEditorComponent (JTable table, Object value, boolean isSelected, int row, int column) {
	cambiarFoto((ImageIcon)value);
	return boton;
}
}
