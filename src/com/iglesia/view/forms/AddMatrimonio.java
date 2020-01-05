package com.iglesia.view.forms;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.iglesia.helpers.BotonDef;
import com.iglesia.helpers.JLabelColored;
import com.iglesia.helpers.SearchTextField;
import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class AddMatrimonio extends JPanel{
	public JList<String> esposo;
	public JList<String> esposa;
	public SearchTextField buscarEsposo;
	public SearchTextField buscarEsposa;
	public JDateChooser fecha;
	public BotonDef guardar;

	
	public AddMatrimonio(){
		this.setLayout(new MigLayout("wrap, gap 5! 12!, insets 50 50"));
		this.setBackground(Color.decode("#263238"));
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel("Registrar Matrimonio", plus, SwingConstants.LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		titulo.setForeground(Color.white);
		this.add(titulo, "growx, span 4");
		this.inicializarComponentes();
	}
	
	public void inicializarComponentes(){
		this.add(new JLabelColored("Esposo:", "#FFFFFF"));
		esposo = new JList();
		buscarEsposo = new SearchTextField(esposo, 3);
		this.add(buscarEsposo,"pushx, growx, span 3");
		this.add(esposo,"pushx, growx, span 3"); //data has type Object[]
		
		
		
		this.add(new JLabelColored("Esposa:", "#FFFFFF"));

		esposa = new JList();
		buscarEsposa = new SearchTextField(esposa, 4);

		this.add(buscarEsposa,"pushx, growx, span 3");
		this.add(esposa,"pushx, growx, span 3");
		
		
		this.add(new JLabelColored("Fecha Matrimonio(*):", "#FFFFFF"));
		this.fecha = new JDateChooser(new Date());
		this.add(fecha,"pushx, growx, span 1");
		
		guardar = new BotonDef("Guardar");
		this.add(guardar, "span 1, pushx, growx");
	};
	
	public void clean() {
		String[] vacia = {};
		this.esposo.setListData(vacia);
		this.esposa.setListData(vacia);
		this.buscarEsposo.setText("");
		this.buscarEsposa.setText("");
		this.fecha.setDate(new Date());
	}
	
	public boolean formValid() {
		if (!this.esposo.isSelectionEmpty() && !this.esposa.isSelectionEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

}
