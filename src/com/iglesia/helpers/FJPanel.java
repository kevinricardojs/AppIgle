package com.iglesia.helpers;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FJPanel extends JPanel {
	private Image img;

	  public FJPanel(String img) {
	    this(new ImageIcon(img).getImage());
	   // this.setBackground(Color.decode("#67809f"));
	  }

	  public FJPanel(Image img) {
	    this.img = img;
	    this.setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
		  super.paintComponent(g); 
	    
	    Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 500, Color.decode("#10174d"), 1000, h, Color.decode("#695d73"));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        
        g.drawImage(img, 0, 0, null);
	  }
}
