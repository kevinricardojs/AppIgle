package com.iglesia.crud;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.iglesia.BD.PersonaDB;
import com.iglesia.helpers.Helper;
import com.iglesia.helpers.JLabelT;

import net.miginfocom.swing.MigLayout;

public class VerPersona extends JDialog{

	public VerPersona(int id_persona) throws HeadlessException, SQLException, IOException {
		super((Window)null, "Persona", ModalityType.APPLICATION_MODAL);
		this.setIconImage(new ImageIcon("ico.png").getImage());
		
		//Seteando maximixado inicial 
		this.setMinimumSize(new Dimension(380, 700));
		this.setSize(new Dimension(380, 700));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		this.setLayout(new MigLayout("wrap 5"));
		ResultSet a = PersonaDB.verPersona(id_persona);
		a.next();
		
		JLabel foto = new JLabel();
		InputStream blob = a.getBinaryStream("foto");  
		BufferedImage image = ImageIO.read(blob);
		Image img = image;
		ImageIcon icon = Helper.redimensionarIcono(new ImageIcon(img), 350, 350);
		foto.setIcon(icon);
		
		this.add(foto, "wrap, span 5");
		
		this.add(new JLabelT("Nombre: ", "Arial", 16, true), "span, left, wrap");
		this.add(new JLabelT(a.getString("nombres") + ", " + a.getString("apellidos"), "Arial", 15, false), "gap 10!,span, left, wrap");
		
		this.add(new JLabelT("Direccion: ", "Arial", 16, true), "span, left, wrap");
		this.add(new JLabelT(a.getString("direccion"), "Arial", 15, false), "gap 10!, span, left , wrap");
		
		this.add(new JLabelT("Telefonos ", "Arial", 16, true), "span 1, center, wrap");
		this.add(new JLabelT("Celular ", "Arial", 16, true), "skip 1, span 1, center");
		this.add(new JLabelT("Casa    ", "Arial", 16, true), "span 1, center");
		this.add(new JLabelT("Empresa ", "Arial", 16, true), "span 1, center, wrap");
		
		this.add(new JLabelT(a.getString("cel"), "Arial", 15, false), "skip 1, span 1, center");
		this.add(new JLabelT(a.getString("tel_casa"), "Arial", 15, false), "span 1, center");
		this.add(new JLabelT(a.getString("tel_empresa"), "Arial", 15, false), "span 1, center, wrap");
		
		this.add(new JLabelT("Fechas", "Arial", 16, true), "span, left, wrap");
		this.add(new JLabelT("Nacimiento: ", "Arial", 16, true), "skip 1, span 2, left");
		this.add(new JLabelT(a.getString("fecha_nacimiento"), "Arial", 15, false), "span 2, left,wrap");
		this.add(new JLabelT("Aceptó a Cristo: ", "Arial", 16, true), "skip 1, span 2, left");
		this.add(new JLabelT(a.getString("fecha_cristiano"), "Arial", 15, false), "span 2, left, wrap");
		this.add(new JLabelT("Bautizo: ", "Arial", 16, true), "skip 1, span 2, left");
		this.add(new JLabelT(a.getString("fecha_bautizo"), "Arial", 15, false), "span 2, left, wrap");
		this.add(new JLabelT("Primera Asistencia: ", "Arial", 16, true), "skip 1, span 2, left");
		this.add(new JLabelT(a.getString("fecha_asistir"), "Arial", 15, false), "span 2, left, wrap");
		
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		//Seteando icono de app
	
		//Seteando el tipo de Layout
		//this.setLayout(new BorderLayout());
		//this.pack();
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		
	}
}
