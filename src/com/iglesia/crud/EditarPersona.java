package com.iglesia.crud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Dialog.ModalityType;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.Border;

import com.iglesia.BD.PersonaDB;
import com.iglesia.controller.CapturarPersonaController;
import com.iglesia.helpers.Helper;
import com.iglesia.helpers.ImgChooser;
import com.iglesia.helpers.JLabelColored;
import com.iglesia.view.forms.AddPersona;

public class EditarPersona extends JDialog{
	AddPersona a;
	int id_persona;
	
	public EditarPersona(int id_persona) throws ParseException, SQLException, IOException {
		
		super((Window)null, "Persona", ModalityType.APPLICATION_MODAL);
		this.id_persona = id_persona;
		this.setIconImage(new ImageIcon("ico.png").getImage());
		
		//Seteando maximixado inicial 
		this.setMinimumSize(new Dimension(100,50));
		this.setSize(new Dimension(800, 800));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		a = new AddPersona("Actualizar Persona");
		this.change();
		CapturarPersonaController captura = new CapturarPersonaController(a);
		this.add(a);
		this.setVisible(true);
	}
	
	public void change() throws ParseException, SQLException, IOException {
		ResultSet rs = PersonaDB.verPersona(this.id_persona);
		
		rs.next();
		this.a.id = rs.getInt("id");
		this.a.nombres.setText(rs.getString("nombres"));
		this.a.apellidos.setText(rs.getString("apellidos"));
		this.a.DPI.setText(rs.getString("dpi"));
		this.a.direccion.setText(rs.getString("direccion"));
		this.a.celular.setText(rs.getString("cel"));
		this.a.tel_casa.setText(rs.getString("tel_casa"));
		this.a.tel_empresa.setText(rs.getString("tel_empresa"));
		this.a.estado_civil.setSelectedIndex(rs.getInt("estado_civil"));
		this.a.miembro_activo.setSelectedIndex(rs.getInt("activo"));
		this.a.sexo.setSelectedIndex(rs.getInt("sexo"));
		this.a.fecha_asistir.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_asistir")));
		this.a.fecha_bautizo.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_bautizo")));
		this.a.fecha_cristiano.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_cristiano")));
		this.a.fecha_nacimiento.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_nacimiento")));
		this.a.remove(this.a.fotografia_url);
		this.a.remove(this.a.guardar);
		
		
		InputStream blob = rs.getBinaryStream("foto");  
		BufferedImage image = ImageIO.read(blob);
		Image img = image;
		ImageIcon icon = Helper.redimensionarIcono(new ImageIcon(img), 400, 400);
		JLabel foto = new JLabel("");
		foto.setBackground(new Color(75, 75, 75));
		foto.setPreferredSize(new Dimension(270, 270));
		foto.setForeground(Color.white);
		foto.setHorizontalAlignment(JLabelColored.CENTER);
		foto.setIcon(Helper.redimensionarIcono(icon, 250, 250));
		foto.setVisible(true);
		this.a.add(foto, "skip 1, span 2, wrap, growx");
		this.a.guardar.setText("Actualizar");
		this.a.add(this.a.guardar, "skip 1, span 2, growx");
	}

}
