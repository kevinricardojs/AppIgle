package com.iglesia.model;

import java.awt.Color;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Persona {
	
	private String nombres;
	private String apellidos;
	private String DPI;
	private int sexo;
	private String direccion;
	private String telCasa;
	private String celular;
	private String telEmpresa;
	private String estadoCivil;
	private String fechaNacimiento;
	private String fechaCristiano;
	private String fotografiaUrl;
	
	/*public Persona(String nombres, String apellidos, String dpi, String sexo, String direccion, String telCasa, String celular, String estadoCivil, String nacimiento,String cristiano, String fotoUrl ) {
		
		this.setNombres(nombres);
		this.setApellidos(apellidos);
		this.setDPI(dpi);
		this.setSexo(sexo);
		this.setDireccion(direccion);
		this.setTelCasa(telCasa);
		this.setCelular(celular);
		this.setEstadoCivil(estadoCivil);
		this.setNacimiento(nacimiento);
		this.setCristiano(cristiano);
		this.setFotoUrl(fotoUrl);
		
	}*/
	
	public Persona(){}

	//Validaciones
	
	public void setNombres(JTextField nombres2) {
		if(!nombres2.getText().isEmpty() && nombres2.getText().length() >= 5) {
			nombres2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			this.nombres = nombres2.getText();
		}
		else {
			nombres2.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
	}

	public void setApellidos(JTextField apellidos2) {
		if(!apellidos2.getText().isEmpty() && apellidos2.getText().length() >= 5) {
			apellidos2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			this.apellidos = apellidos2.getText();
		}
		else {
			apellidos2.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
	}

	public void setDPI(JTextField dpi2) {
		if (dpi2.getText().length() == 13) {
			dpi2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			this.DPI = dpi2.getText();
		}
		else{
			dpi2.setBorder(BorderFactory.createLineBorder(Color.red));
		}
		
		
	}

	public void setSexo(JComboBox sexo2) {
		if(sexo2.getSelectedIndex() != 0) {
			sexo2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			this.sexo = sexo2.getSelectedIndex();
		}
		else{
			sexo2.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
		
	}

	public void setDireccion(JTextField direccion2) {
		if(!direccion2.getText().isEmpty() && direccion2.getText().length() <= 5) {
			direccion2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			this.direccion = direccion2.getText();
		}
		else{
			direccion2.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
	}

	public void setTelCasa(JTextField telCasa2) {
		if(telCasa2 != null) {
			this.telCasa = telCasa2.getText();
		}
		else{
			this.telCasa = "";
		}
	}

	public void setCelular(JTextField celular2) {
		if(celular2 != null) {
			this.celular = celular2.getText();
		}
		else{
			this.telCasa = "";
		}
		
	}
	public void setTelEmpresa(JTextField telempresa2){
		this.telEmpresa = telempresa2.getText();
	}

	public void setEstadoCivil(JTextField estadoCivil2) {
		this.estadoCivil = estadoCivil2.getText();
		
	}

	public void setNacimiento(JTextField nacimiento) {
		this.fechaNacimiento = nacimiento.getText();
		
	}

	public void setCristiano(JTextField cristiano) {
		this.fechaCristiano = cristiano.getText();
		
	}

	public void setFotoUrl(JTextField fotoUrl) {
		this.fotografiaUrl = fotoUrl.getText();
		
	}
	
	public void describirPersona(){
		System.out.println(nombres + " " + apellidos + " " + DPI + " " + sexo + " " + direccion + " " + telCasa + " " + celular + " " + telEmpresa + " " + estadoCivil + " " + fechaNacimiento + " " + fechaCristiano + " " + fotografiaUrl);
	}

}
