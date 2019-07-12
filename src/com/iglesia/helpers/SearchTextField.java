package com.iglesia.helpers;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchTextField extends JTextField{
	JList lista;

	public SearchTextField(JList lista) {
		this.lista = lista;
		eventos();
	}
	
	
	private void eventos() {
		this.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				setLista();
				System.out.println(getWrited());
				getLista();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void setLista() {
		this.lista.setListData(new String[] {"maria","teresa","mariana","jose","pedro","juan"});
	}
	
	public void getLista() {
		this.lista.getSelectedIndex();
	}
	
	public String getWrited() {
		return this.getText();
	}
}
