package com.iglesia.view.forms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class NewPersona extends JPanel{
	private JTextField nombres;
	private JTextField apellidos;
	private JTextField DPI;
	private JTextField sexo;
	private JTextField direccion;
	private JTextField tel_casa;
	private JTextField celular;
	private JTextField tel_empresa;
	private JTextField estado_civil;
	private JTextField fecha_nacimiento;
	private JTextField fecha_cristiano;
	private JTextField fotografia_url;
	
	public NewPersona(){
		//this.setVisible(false);
		this.setLayout(new MigLayout("wrap 4, debug", "50[left]10[100]10[left]10[100]0[grow]", "10[fill]20[][][][][][][][]50"));
		this.setBackground(Color.white);
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel("Añadir Nueva Persona", plus, SwingConstants. LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		this.add(titulo, "growx, span 4");
		this.inicializarComponentes();
		
	}

	private void inicializarComponentes() {
		this.add(new JLabel("Nombres:"));
		nombres = new JTextField("");
		this.add(nombres,"pushx, growx, span 3");
		
		this.add(new JLabel("Apellidos:"));
		apellidos = new JTextField("");
		this.add(apellidos, "pushx, growx, span 3");
		
		this.add(new JLabel("DPI:"));
		this.DPI = new JTextField("");
		this.add(DPI,"pushx, growx");
		
		this.add(new JLabel("Sexo:"));
		this.sexo = new JTextField("");
		this.add(sexo,"pushx, growx ");
		
		this.add(new JLabel("Dirección:"));
		this.direccion = new JTextField("");
		this.add(direccion," pushx, growx, span 3");
		
		this.add(new JLabel("Telefono Casa:"));
		this.tel_casa = new JTextField("");
		this.add(tel_casa,"pushx, growx ");
		
		this.add(new JLabel("Celular:"));
		this.celular = new JTextField("");
		this.add(celular,"pushx, growx ");
		
		this.add(new JLabel("Telefono Empresa:"));
		this.tel_empresa = new JTextField("");
		this.add(tel_empresa,"pushx, growx ");
		
		this.add(new JLabel("Estado Civil:"));
		this.estado_civil = new JTextField("");
		this.add(estado_civil,"pushx, growx ");
		
		this.add(new JLabel("Fecha de Nacimento:"));
		this.fecha_nacimiento = new JTextField("");
		this.add(fecha_nacimiento,"pushx, growx");
		
		this.add(new JLabel("Fecha Aceptó a Cristo:"));
		this.fecha_cristiano = new JTextField("");
		this.add(fecha_cristiano,"pushx, growx ");
		
		this.add(new JLabel("Jetografia:"));
		this.fotografia_url = new JTextField("");
		this.add(fotografia_url,"pushx, growx, span 3");

		
	}

}
