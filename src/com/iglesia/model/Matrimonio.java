package com.iglesia.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.iglesia.view.forms.AddMatrimonio;

public class Matrimonio {
	private int esposo;
	private int esposa;
	private String fecha;
	
	public Matrimonio(AddMatrimonio form) {
		int esposo = Integer.parseInt(form.esposo.getSelectedValue().split("-")[0]);
		int esposa = Integer.parseInt(form.esposa.getSelectedValue().split("-")[0]);
		setEsposo(esposo);
		setEsposa(esposa);
		setFecha(form.fecha.getDate());
	}
	
	public int getEsposo() {
		return esposo;
	}
	public void setEsposo(int esposo) {
		this.esposo = esposo;
	}
	public int getEsposa() {
		return esposa;
	}
	public void setEsposa(int esposa) {
		this.esposa = esposa;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
		this.fecha = dateFormat.format(fecha);
	}
	
	
}
