package com.iglesia.model;

import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Persona {
	
	private String nombres;
	private String apellidos;
	private String DPI;
	private String sexo;
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

	public void setNombres(String nombres2) {
		this.nombres = nombres2;
		
	}

	public void setApellidos(String apellidos2) {
		this.apellidos = apellidos2;
		
	}

	public void setDPI(String dpi2) {
		this.DPI = dpi2;
		
	}

	public void setSexo(String sexo2) {
		this.sexo = sexo2;
		
	}

	public void setDireccion(String direccion2) {
		this.direccion = direccion2;

	}

	public void setTelCasa(String telCasa2) {
		this.telCasa = telCasa2;
		
	}

	public void setCelular(String celular2) {
		this.celular = celular2;
		
	}
	public void setTelEmpresa(String telempresa2){
		this.telEmpresa = telempresa2;
	}

	public void setEstadoCivil(String estadoCivil2) {
		this.estadoCivil = estadoCivil2;
		
	}

	public void setNacimiento(String nacimiento) {
		this.fechaNacimiento = nacimiento;
		
	}

	public void setCristiano(String cristiano) {
		this.fechaCristiano = cristiano;
		
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotografiaUrl = fotoUrl;
		
	}
	
	public void describirPersona(){
		System.out.println(nombres + " " + apellidos + " " + DPI + " " + sexo + " " + direccion + " " + telCasa + " " + celular + " " + telEmpresa + " " + estadoCivil + " " + fechaNacimiento + " " + fechaCristiano + " " + fotografiaUrl);
	}

}
