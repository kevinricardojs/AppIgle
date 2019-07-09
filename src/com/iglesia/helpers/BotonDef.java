package com.iglesia.helpers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JButton;

public class BotonDef extends JButton{
	private Color hover;
	private Color clicked;
	private Color normal;
	
	public BotonDef() {
		
	}
	public BotonDef(String text, Icon icono){
		super(text, icono);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		super.setContentAreaFilled(false);
		//this.setRolloverEnabled(false);
	}
	
	public BotonDef(String text) {
		this.setText(text);
	}
	
	@Override	
	 protected void paintComponent(Graphics g) {
         if (getModel().isPressed()) {
             g.setColor(clicked);
         } else if (getModel().isRollover()) {
             g.setColor(hover);
         } else {
             g.setColor(normal);
         }
         g.fillRect(0, 0, getWidth(), getHeight());
         super.paintComponent(g);
     }

     @Override
     public void setContentAreaFilled(boolean b) {
     }
     
     public void setDefaultColors(Color normal, Color hover, Color clicked) {
    	 this.normal = normal;
    	 this.hover = hover;
    	 this.clicked = clicked;
     }


}
