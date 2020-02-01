package com.iglesia.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.iglesia.BD.ConexionDB;
import com.iglesia.BD.PersonaDB;
import com.iglesia.crud.EditarPersona;
import com.iglesia.crud.RptPersona;
import com.iglesia.crud.VerPersona;
import com.iglesia.helpers.OpenButton;
import com.itextpdf.text.log.Level;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class VerPersonaController implements ActionListener {
	
	OpenButton btn;
	public VerPersonaController(OpenButton btn) {
		this.btn = btn;
		this.btn.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*try {
            ConexionDB con = new ConexionDB();
            Connection conn =  (Connection) con.conectar();
            
            JasperReport reporte = null;
            String path = "src\\rpt\\Personas.jasper";
            
            Map parametro = new HashMap();
            //parametro.put("id_estado", 36);
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            
            
            JasperViewer view = new JasperViewer(jprint, false);
            
            //view.setDefaultCloseOperation(1);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
        System.out.println(ex.getMessage());
            //Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
		*/
		 try {
			 if(e.getActionCommand() == "Ver") {
				 RptPersona v = new RptPersona(this.btn.id_persona);
			 }
			 else if(e.getActionCommand() == "Editar"){
				 EditarPersona edit = new EditarPersona(this.btn.id_persona);
			 }
			 else if(e.getActionCommand() == "Borrar") {
				 boolean b = true;
				 
				 int result = JOptionPane.showConfirmDialog(null, "Presiona si para borrar", "¿Borrar Persona?", JOptionPane.YES_NO_OPTION);
				    if (JOptionPane.YES_OPTION == result) {
				                 b = PersonaDB.delete(this.btn.id_persona);
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

