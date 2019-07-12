package com.iglesia.view.forms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.iglesia.helpers.BotonDef;
import com.iglesia.helpers.JLabelColored;
import com.iglesia.helpers.SearchTextField;

import net.miginfocom.swing.MigLayout;

public class AddPresentacion extends JPanel{
	
	private JComboBox padre;
	private JComboBox madre;
	private JComboBox ninio;
	private BotonDef guardar;
	
	public  AddPresentacion() {
		
		this.setLayout(new MigLayout("wrap, gap 5! 12!, insets 50 50"));
		this.setBackground(Color.decode("#263238"));
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel("Registrar Presentación", plus, SwingConstants.LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		titulo.setForeground(Color.white);
		this.add(titulo, "growx, span 4");
		this.inicializarComponentes();
	}
	
	public void inicializarComponentes(){
		this.add(new JLabelColored("Padre:", "#FFFFFF"));
		
		JList<String> lista = new JList();
		SearchTextField buscador = new SearchTextField(lista);
		lista.setBackground(Color.white);
		this.add(buscador,"pushx, growx, span 3");
		this.add(lista,"pushx, growx, span 3"); //data has type Object[]
		
		
		padre = new JComboBox();
		this.add(padre,"pushx, growx, span 3");
		
		this.add(new JLabelColored("Madre:", "#FFFFFF"));
		madre = new JComboBox(new String[] {"", "Esther Montepeque", "Brenda Gutierrez"});
		this.add(madre,"pushx, growx, span 3");
		
		this.add(new JLabelColored("Niño:", "#FFFFFF"));
		ninio = new JComboBox(new String[] {"","Iliana Gonzalez Montepeque"});
		this.add(ninio,"pushx, growx, span 3");
		
		guardar = new BotonDef("Guardar");
		this.add(guardar, "span 1, pushx, growx");
	};

}
