package com.iglesia.view;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iglesia.view.forms.NewPersona;

import net.miginfocom.swing.MigLayout;

public class MarcoApp extends JFrame {
	
	public MarcoApp() {
		//Inicializando JFrame mayor

		// Hacer visible

		
		//Cerrar al presionar boton de salir
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		//Seteando icono de app
		this.setIconImage(new ImageIcon("ico.png").getImage());
		
		//Seteando maximixado inicial 
		this.setMinimumSize(new Dimension(640,480));
		//Seteando el tipo de Layout
		//this.setLayout(new BorderLayout());
		this.iniciarComponentes();
		this.pack();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		
	}	
		
private void iniciarComponentes() {
	JPanel mainPanel = new JPanel();
	
	this.getContentPane().add(mainPanel);
	mainPanel.setBackground(Color.decode("#F9AA33"));
	mainPanel.setLayout(new MigLayout("fill", "0[150]10[grow]0", "0[grow]0"));
	
	mainPanel.add(new JPIzquierda(), "grow");
	mainPanel.add(new NewPersona(), "grow");
}
	
}
