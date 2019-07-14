package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.iglesia.BD.PresentacionDB;
import com.iglesia.model.Presentacion;
import com.iglesia.view.forms.AddPresentacion;

public class CapturarPresentacionController  implements ActionListener{
	AddPresentacion form;
	Presentacion p;
	PresentacionDB pDB;
	
	public CapturarPresentacionController(AddPresentacion presentacion) {
		this.form = presentacion;
		this.form.guardar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.form.formValid()) {
			this.p = new Presentacion(this.form);
			this.pDB = new PresentacionDB(p);
			if(pDB.insert()) { 
				form.clean();
			}
		}
		
	}

}
