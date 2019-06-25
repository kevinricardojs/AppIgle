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

public class AddPresentacion extends JPanel{
	
	private JComboBox padre;
	private JComboBox madre;
	private JComboBox ninio;
	private BotonDef guardar;
	
	public  AddPresentacion() {
		
		this.setLayout(new MigLayout("wrap 4", "50[left]10[100]10[left]10[100]0[grow]", "10[fill]20[][][][][][][][]50"));
		
		this.setBackground(Color.white);
		
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel("Añadir Nueva Presentación", plus, SwingConstants. LEFT);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		
		this.add(titulo, "growx, span 4");
		
		this.inicializarComponentes();
	}
	
	public void inicializarComponentes(){
		this.add(new JLabel("Padre:"));
		padre = new JComboBox(new String[] {"", "Erick Gonzalez"});
		this.add(padre,"pushx, growx, span 3");
		
		this.add(new JLabel("Madre:"));
		madre = new JComboBox(new String[] {"", "Esther Montepeque", "Brenda Gutierrez"});
		this.add(madre,"pushx, growx, span 3");
		
		this.add(new JLabel("Niño:"));
		ninio = new JComboBox(new String[] {"","Iliana Gonzalez Montepeque"});
		this.add(ninio,"pushx, growx, span 3");
		
		guardar = new BotonDef("Guardar");
		this.add(guardar, "span 1, pushx, growx");
	};

}
