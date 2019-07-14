package com.iglesia.helpers;

import java.awt.Graphics;
import java.awt.Image;

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
	   /* Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);*/
	    this.setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
		  
	    g.drawImage(img, 0, 0, null);
	  }
}
