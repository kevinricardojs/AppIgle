package com.iglesia.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.iglesia.view.forms.NewPersona;

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
	private String fechaAsistir;
	private String fechaBautizo;
	private int activo;
	
	
	public Persona(NewPersona form){
		setNombres(form.nombres.getText());
		setApellidos(form.apellidos.getText());
		setDPI(form.DPI.getText());
		setSexo(form.sexo.getSelectedIndex());
		setDireccion(form.direccion.getText());
		setTelCasa(form.tel_casa.getText());
		setCelular(form.celular.getText());
		setTelEmpresa(form.tel_empresa.getText());
		setEstadoCivil(form.estado_civil.getSelectedIndex());
		setFechaNacimiento(form.fecha_nacimiento.getDate().toString());
		setFechaCristiano(form.fecha_cristiano.getDate().toString());
		setFechaAsistir(form.fecha_asistir.getDate().toString());
		setFechaBautizo(form.fecha_bautizo.getDate().toString());
		setActivo(form.miembro_activo.getSelectedIndex());
		
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

	public String getFechaAsistir() {
		return fechaAsistir;
	}


	public void setFechaAsistir(String fechaAsistir) {
		this.fechaAsistir = fechaAsistir;
	}


	public String getFechaBautizo() {
		return fechaBautizo;
	}


	public void setFechaBautizo(String fechaBautizo) {
		this.fechaBautizo = fechaBautizo;
	}


	public int getActivo() {
		return activo;
	}


	public void setActivo(int activo) {
		this.activo = activo;
	}


}
