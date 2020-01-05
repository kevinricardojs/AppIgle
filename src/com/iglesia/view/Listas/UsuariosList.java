package com.iglesia.view.Listas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.iglesia.BD.PersonaDB;
import com.iglesia.controller.VerPersonaController;
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
		contenedor.setLayout(new MigLayout("wrap 5, fillx"));
		contenedor.setBorder(BorderFactory.createLoweredBevelBorder());

		this.add(titulo, "growx, pushx");
		this.add(contenedor, "growx, pushx");
		this.lista =  PersonaDB.all();
		this.listar();
	}
	
	
	public void listar(){
		contenedor.add(new JLabel("No."));
		contenedor.add(new JLabel("Nombres"), "sg nombre");
		contenedor.add(new JLabel("Apellidos"), "sg apellido");
		contenedor.add(new JLabel("Celular"), "sg cel");
		contenedor.add(new JLabel("Acción"), "sg accion, center, span");
		
		int i = 1;
		try {
			while (this.lista.next()) {
				contenedor.add(new JLabel(Integer.toString(i)));
				contenedor.add(new JLabelColored(lista.getString("nombres"), "#000000"), "sg nombre");
				contenedor.add(new JLabelColored(lista.getString("apellidos"),"#000000"), "sg apellido");
				contenedor.add(new JLabelColored(lista.getString("cel"),"#000000"), "sg cel");
				OpenButton ver = new OpenButton("Ver", lista.getInt("id"));
				OpenButton update = new OpenButton("Editar", lista.getInt("id"));
				OpenButton del = new OpenButton("Borrar", lista.getInt("id"));
				
				VerPersonaController v = new VerPersonaController(ver);
				VerPersonaController u = new VerPersonaController(update);
				VerPersonaController d = new VerPersonaController(del);
				
				contenedor.add(ver, "split 3");
				contenedor.add(update);
				contenedor.add(del, "wrap");
				i++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
