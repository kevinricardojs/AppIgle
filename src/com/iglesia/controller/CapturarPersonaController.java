package com.iglesia.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iglesia.BD.ConexionDB;
import com.iglesia.BD.PersonaDB;
import com.iglesia.model.Persona;
import com.iglesia.view.forms.NewPersona;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CapturarPersonaController implements ActionListener{
	Persona p = new Persona();
	NewPersona formularioPersona = new NewPersona();
	//ConexionDB db = new ConexionDB();
	
	
	public CapturarPersonaController(NewPersona formPersona) {
		formularioPersona = formPersona;
		formularioPersona.guardar.addActionListener(this);
		 
		/*
		p.describirPersona();
		CapturarPersonaController capturar = new CapturarPersonaController(this);
		guardar.addActionListener(capturar);
		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		p.setNombres(formularioPersona.nombres);
		p.setApellidos(formularioPersona.apellidos);
		p.setDPI(formularioPersona.DPI);
		p.setSexo(formularioPersona.sexo);
		p.setDireccion(formularioPersona.direccion);
		p.setTelCasa(formularioPersona.tel_casa);
		p.setTelEmpresa(formularioPersona.tel_empresa);
		p.setCelular(formularioPersona.celular);
		p.setEstadoCivil(formularioPersona.estado_civil);
		p.setNacimiento(formularioPersona.fecha_nacimiento);
		p.setCristiano(formularioPersona.fecha_cristiano);
		p.setFotoUrl(formularioPersona.fotografia_url);
		//formularioPersona.show();
		
		p.describirPersona();
		PersonaDB pDB = new PersonaDB(this.p, this.formularioPersona);
		//formularioPersona.clean();
		
	}
	
	void addPersonaSQL() throws SQLException{
		

	}
	
}
