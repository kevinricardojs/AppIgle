package com.iglesia.view;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class JPIzquierda extends JPanel{
	private BtnPanIzq addPersona;
	private BtnPanIzq addMatrimonio;
	private BtnPanIzq addPresentacion;
	
	
	public JPIzquierda() {
		this.setBackground(Color.decode("#232F34"));
		this.setLayout(new MigLayout("wrap 1", "0[left]0", "0[60]0[60]0[60]0[grow]0" ));
		/*add(new JButton("uno"), "grow, push");
		add(new JButton("uno"), "grow, push");
		add(new JButton("uno"), "grow, push");*/
		
		addBotones();
	}
	
	private void addBotones() {
		Icon personaIcono = new ImageIcon("imagenes/persona.png");
		addPersona = new BtnPanIzq("Agregar Persona", personaIcono);
		
		Icon matrimonioIcono = new ImageIcon("imagenes/matrimonio.png");
		addMatrimonio = new BtnPanIzq("Agregar Matrimonio",matrimonioIcono);

		
		Icon presentacionIcono = new ImageIcon("imagenes/bebe.png");
		addPresentacion = new BtnPanIzq("Agregar Presentación", presentacionIcono);

		
		this.add(addPersona, "grow, push");
		this.add(addMatrimonio, "grow, push");
		this.add(addPresentacion, "grow, push");
		
	}
	
	private class BtnPanIzq extends JButton{
		
		
			public BtnPanIzq(String text, Icon icono){
				super(text, icono);
				this.setForeground(Color.decode("#FFFFFF"));
				this.setFocusPainted(false);
				this.setBackground(Color.decode("#3A4F5A"));
			}
		
			
			/* @Override
		        protected void paintComponent(Graphics g) {
		            if (getModel().isPressed()) {
		                g.setColor(Color.decode("#4A6572"));
		            } else if (getModel().isRollover()) {
		                g.setColor(Color.decode(""));
		            } else {
		                g.setColor(Color.decode(""));
		            }
		            g.fillRect(0, 0, getWidth(), getHeight());
		            super.paintComponent(g);
		        }*/
	}
}


