package com.iglesia.model;

import com.iglesia.view.forms.AddPresentacion;

public class Presentacion {
	
	private int padre;
	private int madre;
	private int ninio;
	private String fecha;
	
	public Presentacion(AddPresentacion form) {
		int padre = Integer.parseInt(form.padre.getSelectedValue().split("-")[0]);
		int madre = Integer.parseInt(form.madre.getSelectedValue().split("-")[0]);
		int ninio = Integer.parseInt(form.ninio.getSelectedValue().split("-")[0]);
		setPadre(padre);
		setMadre(madre);
		setNinio(ninio);
		setFecha(form.fecha.getDate().toString());
	}

	public int getPadre() {
		return padre;
	}

	public void setPadre(int padre) {
		this.padre = padre;
	}

	public int getMadre() {
		return madre;
	}

	public void setMadre(int madre) {
		this.madre = madre;
	}

	public int getNinio() {
		return ninio;
	}

	public void setNinio(int ninio) {
		this.ninio = ninio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
