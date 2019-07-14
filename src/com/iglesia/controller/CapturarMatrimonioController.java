package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.iglesia.BD.MatrimonioDB;
import com.iglesia.model.Matrimonio;
import com.iglesia.view.forms.AddMatrimonio;

public class CapturarMatrimonioController implements ActionListener {
	
	Matrimonio matrimonio;
	MatrimonioDB pDB;
	AddMatrimonio form;
	
	public CapturarMatrimonioController(AddMatrimonio matrimonio) {
		this.form = matrimonio;
		this.form.guardar.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.form.formValid()) {
			this.matrimonio = new Matrimonio(this.form);
			this.pDB = new MatrimonioDB(this.matrimonio);
			if(pDB.insert()) {
				this.form.clean();
			}
		}
		
	}

}