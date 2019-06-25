package com.iglesia.view.forms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.iglesia.helpers.BotonDef;

import net.miginfocom.swing.MigLayout;

public class AddMatrimonio extends JPanel{
	private JComboBox esposo;
	private JComboBox esposa;
	private BotonDef guardar;

	
	public AddMatrimonio(){
		this.setLayout(new MigLayout("wrap 4", "50[left]10[100]10[left]10[100]0[grow]", "10[fill]20[][]20[]50"));
		this.setBackground(Color.white);
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel("Añadir Nuevo Matrimonio", plus, SwingConstants. LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		this.add(titulo, "growx, span 4");
		this.inicializarComponentes();
	}
	
	public void inicializarComponentes(){
		this.add(new JLabel("Esposo:"));
		esposo = new JComboBox(new String[] {"", "Erick Gonzalez", "Kevin Jimenez"});
		this.add(esposo,"pushx, growx, span 3");
		
		this.add(new JLabel("Esposa:"));
		esposa = new JComboBox(new String[] {"", "Esther Montepeque"});
		this.add(esposa,"pushx, growx, span 3");
		
		guardar = new BotonDef("Guardar");
		this.add(guardar, "span 1, pushx, growx");
	};

}
