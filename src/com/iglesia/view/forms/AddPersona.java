package com.iglesia.view.forms;

import com.toedter.calendar.*;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.iglesia.helpers.BotonDef;
import com.iglesia.helpers.Helper;
import com.iglesia.helpers.ImgChooser;
import com.iglesia.helpers.JLabelColored;
import com.iglesia.helpers.TextValidField;

public class AddPersona extends JPanel{
	public TextValidField nombres;
	public TextValidField apellidos;
	public TextValidField DPI;
	public JComboBox<Object> sexo;
	public TextValidField direccion;
	public TextValidField tel_casa;
	public TextValidField celular;
	public TextValidField tel_empresa;
	public JComboBox<Object> estado_civil;
	public JDateChooser fecha_nacimiento;
	public JDateChooser fecha_cristiano;
	public JDateChooser fecha_bautizo;
	public JButton fotografia_url;
	public JDateChooser fecha_asistir; 
	public JComboBox<Object> miembro_activo;
	public BotonDef guardar;
	public String imagePath;
	public int id;
	
	public boolean valid;
	
	public AddPersona(String title){
		imagePath = "";
		this.setLayout(new MigLayout("wrap 4, gap 5! 12!, insets 50 50"));
		this.setBackground(Color.decode("#263238"));
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel(title, plus, SwingConstants.LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		titulo.setForeground(Color.white);
		this.add(titulo, "growx, span 4");
		this.inicializarComponentes();
		
	}

	public void inicializarComponentes() {
		this.add(new JLabelColored("Nombres(*):", "#FFFFFF"));
		nombres = new TextValidField(5, 50, true);
		this.add(nombres,"pushx, growx, span 3");
		
		this.add(new JLabelColored("Apellidos(*):", "#FFFFFF"));
		apellidos = new TextValidField(5, 50, true);
		this.add(apellidos, "pushx, growx, span 3");
		
		this.add(new JLabelColored("DPI:", "#FFFFFF" ));
		this.DPI = new TextValidField(13, 13, false);
		this.add(DPI,"pushx, growx");
		
		this.add(new JLabelColored("Sexo(*):", "#FFFFFF"));
		sexo = new JComboBox<Object>(new String[] {"M", "F"});
		this.add(sexo,"pushx, growx ");
		
		this.add(new JLabelColored("Dirección(*):", "#FFFFFF"));
		this.direccion = new TextValidField(5, 60, true);
		this.add(direccion," pushx, growx, span 3");
		
		
		this.add(new JLabelColored("Telefono Casa:", "#FFFFFF"));
		this.tel_casa = new TextValidField(8, 8, false);
		this.add(tel_casa,"pushx, growx ");
		
		this.add(new JLabelColored("Celular(*):", "#FFFFFF"));
		this.celular = new TextValidField(8, 8, true);
		this.add(celular,"pushx, growx ");
		
		this.add(new JLabelColored("Telefono Empresa:", "#FFFFFF"));
		this.tel_empresa = new TextValidField(8, 8,false);
		this.add(tel_empresa,"pushx, growx ");
		
		this.add(new JLabelColored("Estado Civil(*):", "#FFFFFF"));
		estado_civil = new JComboBox<Object>(new String[] {"Soltero/a", "Casado/a", "Viudo/a"});
		this.add(estado_civil,"pushx, growx ");
		
		this.add(new JLabelColored("Fecha de Nacimento(*):", "#FFFFFF"));
		this.fecha_nacimiento = new JDateChooser(new Date());
		this.add(fecha_nacimiento,"pushx, growx");
		
		this.add(new JLabelColored("Fecha Aceptó a Cristo(*):", "#FFFFFF"));
		this.fecha_cristiano = new JDateChooser(new Date());
		this.add(fecha_cristiano,"pushx, growx ");
		
		this.add(new JLabelColored("Primer asistencia(*):", "#FFFFFF"));
		this.fecha_asistir = new JDateChooser(new Date());
		this.add(fecha_asistir,"pushx, growx");
		
		this.add(new JLabelColored("Fecha Bautizo(*):", "#FFFFFF"));
		this.fecha_bautizo = new JDateChooser(new Date());
		this.add(fecha_bautizo,"pushx, growx");
		
		this.add(new JLabelColored("Miembro Activo(*):", "#FFFFFF"));
		miembro_activo = new JComboBox<Object>(new String[] {"No", "Si"});
		this.add(miembro_activo,"pushx, growx, wrap");

		this.fotografia_url = new BotonDef("Añadir");
		fotografia_url.addActionListener(new ImgChooser(this));
		fotografia_url.setBackground(new Color(75, 75, 75));
		fotografia_url.setPreferredSize(new Dimension(270, 270));
		fotografia_url.setForeground(Color.white);
		Border borde = BorderFactory.createDashedBorder(null, 3, 10, 10, true);
		
		fotografia_url.setBorder(borde);
		fotografia_url.setHorizontalAlignment(JLabelColored.CENTER);
		fotografia_url.setIcon(Helper.redimensionarIcono(new ImageIcon("imagenes/camara.PNG"), 250, 250));
		this.add(fotografia_url,"skip 1, span 2, wrap, growx");
		
		
		
		guardar = new BotonDef("Guardar");
		this.add(guardar, "skip 1, span 2, growx");
		
		
		
	}
	
	public boolean formValid() {
		if(this.nombres.getValid() && this.apellidos.getValid() && this.direccion.getValid() && this .celular.getValid() && this.imagePath != "imagenes/camara.PNG" && this.imagePath != "" ) {
			this.valid = true;;
		}
		else {
			JOptionPane.showMessageDialog(null, "Debes llenar los campos obligatorios!", "Error en campos",JOptionPane.ERROR_MESSAGE);
			this.valid = false;
		}
		
		return this.valid;
	}
	
	public void clean(){
		
		nombres.setText("");
		apellidos.setText("");
		DPI.setText("");
		sexo.setSelectedIndex(0);
		direccion.setText(""); 
		tel_casa.setText("");
		celular.setText("");
		tel_empresa.setText("");
		estado_civil.setSelectedIndex(0);
		miembro_activo.setSelectedIndex(0);
		fecha_nacimiento.setDate(new Date());
		fecha_cristiano.setDate(new Date());
		fotografia_url.setIcon(Helper.redimensionarIcono(new ImageIcon("imagenes/camara.PNG"), 250, 250));
	}
}
