package com.iglesia.model;

import java.awt.Color;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

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
			this.nombres = null;
			nombres2.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
	}

	public void setApellidos(JTextField apellidos2) {
		if(!apellidos2.getText().isEmpty() && apellidos2.getText().length() >= 5) {
			apellidos2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			
			String[] ap = apellidos2.getText().split(" ");
			for (int i = 0; i < ap.length; i++) {
				// Almacena el apellido actual en str
				String str = ap[i];
				// primer letra mayuscula + letras restantes
				ap[i] = str.substring(0, 1).toUpperCase() + str.substring(1);
			}
			
			this.apellidos = String.join(" ", ap );
		}
		else {
			this.apellidos = null;
			apellidos2.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
	}

	public void setDPI(JTextField dpi2) {
		if (dpi2.getText().length() == 13) {
			dpi2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			this.DPI = dpi2.getText();
		}
		else{
			this.DPI = null;
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
		if(!direccion2.getText().isEmpty() && direccion2.getText().length() >= 5) {
			direccion2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			this.direccion = direccion2.getText();
		}
		else{
			this.direccion = null;
			direccion2.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
	}

	public void setTelCasa(JTextField telCasa2) {
		if(!telCasa2.getText().isEmpty()) {
			this.telCasa = telCasa2.getText();
		}
		else{
			this.telCasa = "";
		}
	}

	public void setCelular(JTextField celular2) {
		if(!celular2.getText().isEmpty()) {
			this.celular = celular2.getText();
		}
		else{
			this.celular = "";
		}
		
	}
	public void setTelEmpresa(JTextField telempresa2){
		if(!telempresa2.getText().isEmpty())
			this.telEmpresa = telempresa2.getText();
		else
			this.telEmpresa = "";
	}

	public void setEstadoCivil(JComboBox estadoCivil2) {
		if(estadoCivil2.getSelectedIndex() != 0) {
			estadoCivil2.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			this.estadoCivil = estadoCivil2.getSelectedIndex();
		}
		else{
			
			estadoCivil2.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
		
	}

	public void setNacimiento(JDateChooser nacimiento) {
		if((nacimiento.getDate() != null)) {
			System.out.println(nacimiento.getDate().toString());
			String fecha = formatFecha(nacimiento.getDate().toString());
			nacimiento.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			System.out.println(fecha);
			this.fechaNacimiento = fecha;
		}
		else {
			System.out.println("fecha"  + nacimiento.getDate());
			nacimiento.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
	}

	public void setCristiano(JDateChooser cristiano) {
		if((cristiano.getDate() != null)) {
			System.out.println(cristiano.getDate().toString());
			String fecha = formatFecha(cristiano.getDate().toString());
			cristiano.setBorder(BorderFactory.createLineBorder(Color.decode("#008b00")));
			System.out.println(fecha);
			this.fechaCristiano = fecha;
		}
		else {
			System.out.println("fecha"  + cristiano.getDate());
			cristiano.setBorder(BorderFactory.createLineBorder(Color.decode("#B00020")));
		}
		
		
	}

	public void setFotoUrl(JTextField fotoUrl) {
		this.fotografiaUrl = fotoUrl.getText();
		
	}
	
	public void describirPersona(){
		System.out.println(nombres + " " + apellidos + " " + DPI + " " + sexo + " " + direccion + " " + telCasa + " " + celular + " " + telEmpresa + " " + estadoCivil + " " + fechaNacimiento + " " + fechaCristiano + " " + fotografiaUrl);
	}
	

	
	private String formatFecha(String f) {
		String[] ary = f.split(" ");
		f = ary[2] + "/" + ary[1] + "/" + ary[5] ;
		return f;
	}
	
	public String getNombres() {
		return this.nombres;
	}
	public String getApellidos() {
		return this.apellidos;
	}

	
	public String getDPI() {
		return DPI;
	}

	public int getSexo() {
		return sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelCasa() {
		return telCasa;
	}

	public String getCelular() {
		return celular;
	}

	public String getTelEmpresa() {
		return telEmpresa;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getFechaCristiano() {
		return fechaCristiano;
	}

	public String getFotografiaUrl() {
		return fotografiaUrl;
	}
	
	public boolean isValid() {
		if(this.nombres == null || this.apellidos == null || this.DPI == null || this.direccion == null || this.fechaCristiano == null || this.fechaNacimiento == null)
			return false;
		else
			return true;
	}


}
