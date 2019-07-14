package com.iglesia.view.forms;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

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
import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class AddPresentacion extends JPanel{
	
	public JList<String> padre;
	public JList<String> madre;
	public JList<String> ninio;
	public JDateChooser fecha;
	public BotonDef guardar;
	private SearchTextField buscarPadre;
	private SearchTextField buscarMadre;
	private SearchTextField buscarNinio;
	
	private boolean valid;
	
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
		
		padre = new JList();
		buscarPadre = new SearchTextField(padre, 0);
		this.add(buscarPadre,"pushx, growx, span 3");
		this.add(padre,"pushx, growx, span 3"); //data has type Object[]
		
		
		
		this.add(new JLabelColored("Madre:", "#FFFFFF"));

		madre = new JList();
		buscarMadre = new SearchTextField(madre, 1);

		this.add(buscarMadre,"pushx, growx, span 3");
		this.add(madre,"pushx, growx, span 3");
		
		this.add(new JLabelColored("Niño:", "#FFFFFF"));
		ninio = new JList();
		this.add(ninio,"pushx, growx, span 3");
		buscarNinio = new SearchTextField(ninio, 3);

		this.add(buscarNinio,"pushx, growx, span 3");
		this.add(ninio,"pushx, growx, span 3");
		
		this.add(new JLabelColored("Fecha Presentiación(*):", "#FFFFFF"));
		this.fecha = new JDateChooser(new Date());
		this.add(fecha,"pushx, growx, span 1");
		
		guardar = new BotonDef("Guardar");
		this.add(guardar, "span 1, pushx, growx");
	};
	
	
	public boolean formValid() {
		boolean valid = false;
		if (!this.padre.isSelectionEmpty() && !this.madre.isSelectionEmpty() && !this.ninio.isSelectionEmpty()) {
			valid = true;
		}
		return valid;
	}
	
	public void clean() {
		String[] vacia = {};
		this.buscarPadre.setText("");
		this.buscarMadre.setText("");
		this.buscarNinio.setText("");
		this.fecha.setDate(new Date());;
		this.padre.setListData(vacia);
		this.madre.setListData(vacia);
		this.ninio.setListData(vacia);
	}
}
