package com.iglesia.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
	
	private String nombres;
	private String apellidos;
	private String DPI;
	private int sexo;
	private String direccion;
	private String telCasa;
	private String celular;
	private String telEmpresa;
	private int estadoCivil;
	private String fechaNacimiento;
	private String fechaCristiano;
	private String fotografiaUrl;
	
	
	public Persona(){
		//DateFormat formato = DateFormat.getDateInstance();
		//formato.format(f.fecha_nacimiento.getDate();
	}
	

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDPI() {
		return DPI;
	}

	public void setDPI(String dPI) {
		DPI = dPI;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelCasa() {
		return telCasa;
	}

	public void setTelCasa(String telCasa) {
		this.telCasa = telCasa;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelEmpresa() {
		return telEmpresa;
	}

	public void setTelEmpresa(String telEmpresa) {
		this.telEmpresa = telEmpresa;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaCristiano() {
		return fechaCristiano;
	}

	public void setFechaCristiano(String fechaCristiano) {
		this.fechaCristiano = fechaCristiano;
	}

	public String getFotografiaUrl() {
		return fotografiaUrl;
	}

	public void setFotografiaUrl(String fotografiaUrl) {
		this.fotografiaUrl = fotografiaUrl;
	}
}
