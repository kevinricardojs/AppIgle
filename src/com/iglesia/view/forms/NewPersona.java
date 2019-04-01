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

import com.iglesia.controller.CapturarPersonaController;
import com.iglesia.helpers.BotonDef;

import net.miginfocom.swing.MigLayout;

public class NewPersona extends JPanel{
	public JTextField nombres;
	public JTextField apellidos;
	public JTextField DPI;
	public JComboBox sexo;
	public JTextField direccion;
	public JTextField tel_casa;
	public JTextField celular;
	public JTextField tel_empresa;
	public JTextField estado_civil;
	public JTextField fecha_nacimiento;
	public JTextField fecha_cristiano;
	public JTextField fotografia_url;
	public BotonDef guardar;
	
	public NewPersona(){
		
	}

	public void inicializarComponentes() {
		this.add(new JLabel("Nombres:"));
		nombres = new JTextField();
		this.add(nombres,"pushx, growx, span 3");
		
		this.add(new JLabel("Apellidos:"));
		apellidos = new JTextField();
		this.add(apellidos, "pushx, growx, span 3");
		
		this.add(new JLabel("DPI:"));
		this.DPI = new JTextField();
		this.add(DPI,"pushx, growx");
		
		this.add(new JLabel("Sexo:"));
		sexo = new JComboBox(new String[] {"", "M", "F"});
		this.add(sexo,"pushx, growx ");
		
		this.add(new JLabel("Dirección:"));
		this.direccion = new JTextField();
		this.add(direccion," pushx, growx, span 3");
		
		this.add(new JLabel("Telefono Casa:"));
		this.tel_casa = new JTextField();
		this.add(tel_casa,"pushx, growx ");
		
		this.add(new JLabel("Celular:"));
		this.celular = new JTextField();
		this.add(celular,"pushx, growx ");
		
		this.add(new JLabel("Telefono Empresa:"));
		this.tel_empresa = new JTextField();
		this.add(tel_empresa,"pushx, growx ");
		
		this.add(new JLabel("Estado Civil:"));
		this.estado_civil = new JTextField();
		this.add(estado_civil,"pushx, growx ");
		
		this.add(new JLabel("Fecha de Nacimento:"));
		this.fecha_nacimiento = new JTextField();
		this.add(fecha_nacimiento,"pushx, growx");
		
		this.add(new JLabel("Fecha Aceptó a Cristo:"));
		this.fecha_cristiano = new JTextField();
		this.add(fecha_cristiano,"pushx, growx ");
		
		this.add(new JLabel("Jetografia:"));
		this.fotografia_url = new JTextField();
		this.add(fotografia_url,"pushx, growx, span 3");
		
		guardar = new BotonDef("Guardar");
		this.add(guardar, "span 1, pushx, growx");
		
	}
	
	public void show(){
		System.out.println(nombres.getText() + " " + apellidos.getText() + " " + DPI.getText() + " " + sexo.getSelectedIndex() + " " + direccion.getText() + " " + tel_casa.getText() + " " + celular.getText() + " " + tel_empresa.getText() + " " + estado_civil.getText() + " " + fecha_nacimiento.getText() + " " + fecha_cristiano.getText() + " " + fotografia_url.getText());
	}

}
