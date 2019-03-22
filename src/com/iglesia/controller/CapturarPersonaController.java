package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.iglesia.model.Persona;
import com.iglesia.view.forms.NewPersona;

public class CapturarPersonaController implements ActionListener{
	Persona p = new Persona();
	NewPersona formularioPersona = new NewPersona();
	
	
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
		p.setNombres(formularioPersona.nombres.getText());
		p.setApellidos(formularioPersona.apellidos.getText());
		p.setDPI(formularioPersona.DPI.getText());
		p.setSexo(formularioPersona.sexo.getText());
		p.setDireccion(formularioPersona.direccion.getText());
		p.setTelCasa(formularioPersona.tel_casa.getText());
		p.setTelEmpresa(formularioPersona.tel_empresa.getText());
		p.setCelular(formularioPersona.celular.getText());
		p.setEstadoCivil(formularioPersona.estado_civil.getText());
		p.setNacimiento(formularioPersona.fecha_nacimiento.getText());
		p.setCristiano(formularioPersona.fecha_cristiano.getText());
		p.setFotoUrl(formularioPersona.fotografia_url.getText());
		System.out.println("Funciona");
		//formularioPersona.show();
		
		p.describirPersona();
		
	}
}
