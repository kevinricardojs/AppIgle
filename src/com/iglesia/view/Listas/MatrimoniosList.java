package com.iglesia.view.Listas;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;

import com.iglesia.BD.MatrimonioDB;
import com.iglesia.controller.VerMatrimonioController;
import com.iglesia.controller.VerPersonaController;
import com.iglesia.helpers.JLabelColored;
import com.iglesia.helpers.OpenButton;

import net.miginfocom.swing.MigLayout;

public class MatrimoniosList extends JPanel{
	private ResultSet lista; 
	JPanel contenedor;
	


	public MatrimoniosList() {
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
		this.lista =  MatrimonioDB.all();
		this.listar();
	}
	
	
	public void listar(){
		contenedor.add(new JLabel("No."));
		contenedor.add(new JLabel("Nombres"), "sg hnombre");
		contenedor.add(new JLabel("Nombres"), "sg mnombre");
		contenedor.add(new JLabel("Fecha"), "sg fecha");
		contenedor.add(new JLabel("Acción"), "sg accion, center, span");
		
		int i = 1;
		try {
			while (this.lista.next()) {
				contenedor.add(new JLabel(Integer.toString(i)));
				contenedor.add(new JLabelColored(lista.getString("hnombres") + ", " +lista.getString("hapellidos"), "#000000"), "sg hnombre");
				contenedor.add(new JLabelColored(lista.getString("mnombres") + ", " + lista.getString("mapellidos"), "#000000"), "sg mnombre");
				contenedor.add(new JLabelColored(lista.getString("fecha"),"#000000"), "sg fecha");
				OpenButton ver = new OpenButton("Ver", lista.getInt("id"));
				OpenButton del = new OpenButton("Borrar", lista.getInt("id"));
				
				VerMatrimonioController v = new VerMatrimonioController(ver);
				VerMatrimonioController d = new VerMatrimonioController(del);
				
				contenedor.add(ver, "split 2");
				contenedor.add(del, "wrap");
				i++;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
