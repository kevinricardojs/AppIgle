package com.iglesia.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.iglesia.view.MarcoApp;
import com.iglesia.view.forms.NewPersona;

import net.miginfocom.swing.MigLayout;

public class AddPersonaController implements ActionListener{
	private MarcoApp panel;
	
	public AddPersonaController(MarcoApp panel) {
		super();
		this.panel = panel;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//panel.mainPanel.add(new AddMatrimonio(), "grow");
		panel.mainPanel.remove(panel.panelPersona);
		panel.mainPanel.remove(panel.panelMatrimonio);
		panel.mainPanel.remove(panel.panelPresentacion);

		panel.panelPersona = new NewPersona();
		panel.panelPersona.setLayout(new MigLayout("wrap 4", "50[left]10[100]10[left]10[100]0[grow]", "10[fill]20[][][][][][][][][]50"));
		panel.panelPersona.setBackground(Color.white);
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel("Añadir Nueva Persona", plus, SwingConstants. LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		panel.panelPersona.add(titulo, "growx, span 4");
		panel.panelPersona.inicializarComponentes();
		panel.mainPanel.add(panel.panelPersona, "grow");
		
		CapturarPersonaController captura = new CapturarPersonaController(panel.panelPersona);
		
		SwingUtilities.updateComponentTreeUI(panel);


	}

}
