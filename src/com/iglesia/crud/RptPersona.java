package com.iglesia.crud;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.iglesia.BD.ConexionDB;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RptPersona {
	
	public RptPersona(int id_persona) {
		try {
        ConexionDB con = new ConexionDB();
        Connection conn =  (Connection) con.conectar();
        
        JasperReport reporte = null;
        String path = "rpt/Persona.jasper";
        
        Map parametros = new HashMap();
        parametros.put("id", id_persona);
        
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        
        JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, conn);
        
        
        JasperViewer view = new JasperViewer(jprint, false);
        
        //view.setDefaultCloseOperation(1);
        
        view.setVisible(true);
        
    } catch (JRException ex) {
    JOptionPane.showMessageDialog(null, ex.getMessage());
        //Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
    }
    
	}

}
