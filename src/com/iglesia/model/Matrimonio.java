package com.iglesia.model;

import com.iglesia.view.forms.AddMatrimonio;

public class Matrimonio {
	private int esposo;
	private int esposa;
	private String fecha;
	
	public Matrimonio(AddMatrimonio form) {
		System.out.println(esposo);
		int esposo = Integer.parseInt(form.esposo.getSelectedValue().split("-")[0]);
		int esposa = Integer.parseInt(form.esposa.getSelectedValue().split("-")[0]);
		setEsposo(esposo);
		setEsposa(esposa);
		setFecha(form.fecha.getDate().toString());
		System.out.println(esposo);
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
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
