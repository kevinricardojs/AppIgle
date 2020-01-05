package com.iglesia.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.iglesia.BD.MatrimonioDB;
import com.iglesia.BD.PersonaDB;
import com.iglesia.BD.PresentacionDB;
import com.iglesia.crud.EditarPersona;
import com.iglesia.crud.VerMatrimonio;
import com.iglesia.crud.VerPersona;
import com.iglesia.crud.VerPresentacion;
import com.iglesia.helpers.OpenButton;


public class VerPresentacionController implements ActionListener {
	
	OpenButton btn;
	public VerPresentacionController(OpenButton btn) {
		this.btn = btn;
		this.btn.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		 try {
			 if(e.getActionCommand() == "Ver") {
				 VerPresentacion v = new VerPresentacion(this.btn.id_persona);
			 }
			 else if(e.getActionCommand() == "Borrar") {
				 boolean b = true;
				 
				 int result = JOptionPane.showConfirmDialog(null, "Presiona si para borrar", "¿Borrar Presentación?", JOptionPane.YES_NO_OPTION);
				    if (JOptionPane.YES_OPTION == result) {
				                 b = PresentacionDB.delete(this.btn.id_persona);
				                 if (b) {
				                	 JOptionPane.showMessageDialog(null, "Borrado!");
				                 }else {
				                	 JOptionPane.showMessageDialog(null, "Error!");
				                 }
				     }
			 }
			
		} catch (HeadlessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
}

