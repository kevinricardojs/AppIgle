package com.iglesia.crud;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iglesia.BD.MatrimonioDB;
import com.iglesia.BD.PresentacionDB;
import com.iglesia.helpers.Helper;
import com.iglesia.helpers.JLabelT;

import net.miginfocom.swing.MigLayout;

public class VerPresentacion extends JDialog{

	public VerPresentacion(int id) throws HeadlessException, SQLException, IOException, ParseException {
		super((Window)null, "Presentación", ModalityType.APPLICATION_MODAL);
		this.setIconImage(new ImageIcon("ico.png").getImage());
		
		//Seteando maximixado inicial 
		this.setMinimumSize(new Dimension(790, 565));
		this.setSize(new Dimension(790, 565));
		JPanel p = new JPanel() {
			 public void paintComponent(Graphics g) {
				 // super.paintComponent(g); 
		        Image img = new ImageIcon("imagenes/fondoPresentacion.PNG").getImage();
		        g.drawImage(img, 0, 90, null);
			  }
		};
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		this.setLayout(new MigLayout("fill", "0[grow]0"));
		this.add(p, "grow");
		p.setLayout(new MigLayout("wrap 3"));
		p.setVisible(true);
		ResultSet a = PresentacionDB.verPresentacion(id);
		a.next();
		
		JLabel padre = new JLabel();
		JLabel madre = new JLabel();
		JLabel hijo = new JLabel();
		InputStream blob = a.getBinaryStream("ftpadre");  
		BufferedImage image = ImageIO.read(blob);
		Image img = image;
		ImageIcon icon = Helper.redimensionarIcono(new ImageIcon(img), 250, 250);
		
		padre.setIcon(icon);
		
		blob = a.getBinaryStream("ftmadre");
		image = ImageIO.read(blob);
		img = image;
		icon = Helper.redimensionarIcono(new ImageIcon(img), 250, 250);
		madre.setIcon(icon);
		
		blob = a.getBinaryStream("fthijo");
		image = ImageIO.read(blob);
		img = image;
		icon = Helper.redimensionarIcono(new ImageIcon(img), 250, 250);
		hijo.setIcon(icon);
		
		p.add(padre, "span 1");
		p.add(hijo, "span 1");
		p.add(madre, "span 1");
		
		p.add(new JLabelT(a.getString("padre"), "Arial", 15, false), "span 1, left");
		p.add(new JLabelT(a.getString("hijo"), "Arial", 15, false), "span 1, center");
		p.add(new JLabelT(a.getString("madre"), "Arial", 15, false), "span 1, right");
		
		 
		SimpleDateFormat format= new SimpleDateFormat("EEEE dd, MMMM yyyy");
		Date fecha = new SimpleDateFormat("yyy-MM-dd"). parse(a.getString("fecha"));
		String f = format.format(fecha);
		
		p.add(new JLabelT(f, "Arial", 20, true), "gaptop 60, span, center");

		this.setVisible(true);
		
	}
}
