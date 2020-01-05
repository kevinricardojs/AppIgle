package com.iglesia.view;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.iglesia.helpers.FJPanel;
import com.iglesia.view.Listas.MatrimoniosList;
import com.iglesia.view.Listas.PresentacionesList;
import com.iglesia.view.Listas.UsuariosList;
import com.iglesia.view.forms.AddMatrimonio;
import com.iglesia.view.forms.AddPresentacion;
import com.iglesia.view.forms.AddPersona;

import net.miginfocom.swing.MigLayout;

public class MarcoApp extends JFrame {
	public FJPanel mainPanel;
	public JPIzquierda panelIzquierda;
	public AddMatrimonio panelMatrimonio;
	public AddPresentacion panelPresentacion;
	public AddPersona panelPersona;
	public UsuariosList panelUserList;
	public MatrimoniosList panelMatrimonioList;
	public PresentacionesList panelPresentacionList;
	
	public MarcoApp(String titulo) {
		
		super(titulo);
		//Inicializando JFrame mayor

		// Hacer visible

		
		//Cerrar al presionar boton de salir
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		//Seteando icono de app
		this.setIconImage(new ImageIcon("ico.png").getImage());
		
		//Seteando maximixado inicial 
		this.setMinimumSize(new Dimension(1074,768));
		//Seteando el tipo de Layout
		//this.setLayout(new BorderLayout());
		this.iniciarComponentes();
		this.pack();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		
	}	
		
private void iniciarComponentes() {
	 mainPanel = new FJPanel(new ImageIcon("imagenes/background.jpg").getImage());
	 panelIzquierda = new JPIzquierda(this);
	 panelMatrimonio = new AddMatrimonio();
	 panelPresentacion = new AddPresentacion();
	 panelPersona = new AddPersona("Añadir Persona");
	 panelUserList = new UsuariosList();
	 panelMatrimonioList = new MatrimoniosList();
	 panelPresentacionList = new PresentacionesList();
	 
	 
	//this.getContentPane().add(mainPanel);
	JScrollPane scroll = new JScrollPane(this.mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scroll.getVerticalScrollBar().setUnitIncrement(14);
	this.add(scroll);
	this.mainPanel.setBackground(Color.decode("#10174d"));
	this.setBackground(Color.decode("#232F34"));
	

	mainPanel.setLayout(new MigLayout("fillx", "0[grow]0", "0[grow]0[]0"));
	
	mainPanel.add(panelIzquierda, "north");
	
	
}
	
}
