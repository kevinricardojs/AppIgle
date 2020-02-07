package com.iglesia.view.Listas;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.iglesia.BD.MatrimonioDB;
import com.iglesia.controller.FiltrosMatrimonioController;
import com.iglesia.controller.FiltrosPersonaController;
import com.iglesia.controller.VerMatrimonioController;
import com.iglesia.controller.VerPersonaController;
import com.iglesia.helpers.BotonDef;
import com.iglesia.helpers.JLabelColored;
import com.iglesia.helpers.OpenButton;

import net.miginfocom.swing.MigLayout;

public class MatrimoniosList extends JPanel{
	public ResultSet lista;
	public JTextField campo;
	public BotonDef consulta;
	public JPanel contenedor;
	


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
		this.filtros();
		this.add(contenedor, "growx, pushx");
		this.lista =  MatrimonioDB.busqueda("");
		//this.listar();
	}
	
	public void filtros(){
		JLabel titulo = new JLabel("Buscar nombre:",SwingConstants.LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setForeground(Color.white);
		
		this.add(titulo, "span 6, growx, pushx");
		campo = new JTextField();
		this.add(campo, "span 4, growx, pushx, wrap");
		
		FiltrosMatrimonioController f = new FiltrosMatrimonioController(this);
		consulta = new BotonDef("Buscar");
		consulta.addActionListener(f);
		this.add(consulta, "span 4, growx, pushx, wrap");
	}
	
	
	
	public void listar(){
		contenedor.add(new JLabel("No."));
		contenedor.add(new JLabel("Esposo"), "sg hnombre");
		contenedor.add(new JLabel("Esposa"), "sg mnombre");
		contenedor.add(new JLabel("Fecha"), "sg fecha");
		contenedor.add(new JLabel("Acción"), "sg accion, center, span");
		
		int i = 1;
		try {
			while (this.lista.next()) {
				contenedor.add(new JLabel(Integer.toString(i)));
				contenedor.add(new JLabelColored(lista.getString("esposo_nombres") + ", " +lista.getString("esposo_apellidos"), "#000000"), "sg hnombre");
				contenedor.add(new JLabelColored(lista.getString("esposa_nombres") + ", " + lista.getString("esposa_apellidos"), "#000000"), "sg mnombre");
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
