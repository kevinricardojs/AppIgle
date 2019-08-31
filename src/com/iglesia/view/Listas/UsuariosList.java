package com.iglesia.view.Listas;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.iglesia.BD.PersonaDB;
import com.iglesia.helpers.JLabelColored;
import com.iglesia.helpers.OpenButton;

import net.miginfocom.swing.MigLayout;

public class UsuariosList extends JPanel{
	private ResultSet lista; 
	JPanel contenedor;

	public UsuariosList() {
		this.setLayout(new MigLayout("wrap, gap 5! 12!, insets 50 50"));
		this.setBackground(Color.decode("#263238"));
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel("Listado de registros", plus, SwingConstants.LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		titulo.setForeground(Color.white);
		contenedor = new JPanel();
		contenedor.setLayout(new MigLayout("wrap 6"));
		contenedor.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.add(titulo, "growx, pushx");
		this.add(contenedor, "growx, pushx");
		this.lista =  PersonaDB.all();
		this.listar();
	}
	
	
	public void listar(){
		int i = 1;
		try {
			while (this.lista.next()) {
				contenedor.add(new JLabel(Integer.toString(i)));
				contenedor.add(new JLabelColored(lista.getString("nombres"), "#000000"), "sg nombre");
				contenedor.add(new JLabelColored(lista.getString("apellidos"),"#000000"), "sg apellido");
				contenedor.add(new JLabelColored(lista.getString("cel"),"#000000"), "sg cel");
				contenedor.add(new JLabelColored(lista.getString("DPI"),"#000000"), "sg DPI");
				contenedor.add(new OpenButton("Ver", lista.getString("DPI")));
				i++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
