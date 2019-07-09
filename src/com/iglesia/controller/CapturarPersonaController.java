package com.iglesia.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import javax.imageio.ImageIO;

import com.iglesia.BD.ConexionDB;
import com.iglesia.BD.PersonaDB;
import com.iglesia.model.Persona;
import com.iglesia.view.forms.NewPersona;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CapturarPersonaController implements ActionListener{
	Persona p;
	NewPersona f;
	
	public CapturarPersonaController(NewPersona f) {
		this.f = f;
		f.guardar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.f.formValid()) {
			
			this.guardarFoto(f.imagePath, f.DPI.getText());
			f.clean();
		}
		else {
			System.out.println("Formulario invalid");
		}

		//PersonaDB pDB = new PersonaDB(this.p, this.f);
		//formulario.clean();
		
	}

	
	private void guardarFoto(String path, String dpi) {
		try {

			File foto = new File(path);
			FileInputStream fis = new FileInputStream(foto);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];

			try {

				for (int readNum; (readNum = fis.read(buf)) !=  -1;) {
					bos.write(buf, 0, readNum);
				}

				byte[] bytes = bos.toByteArray();

				File copia = new File("fotos\\FT-" + dpi + ".PNG");
				BufferedImage img  = ImageIO.read(new ByteArrayInputStream(bytes));
				ImageIO.write(img, "PNG", copia);
				
				
			} catch (IOException e2) {
				// TODO: handle exception
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
