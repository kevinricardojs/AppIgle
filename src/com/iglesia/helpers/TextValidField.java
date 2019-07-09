package com.iglesia.helpers;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextValidField extends JTextField{
	private int max, min;
	private boolean empty;
	private boolean valid;
	
	public TextValidField(int min, int max, boolean empty) {
		this.min = min;
		this.max = max;
		this.empty = empty;
		this.valid = false;
		
		evts();

	}
	
	private int len() {
		return this.getText().length();
	}
	
	private boolean obligatorio() {
		return this.empty;
	}
	
	private void color(String color) {
		if(!(color == "reset")) {
		this.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 10, Color.decode(color)));
		}
		else {
			this.setBorder(new JTextField().getBorder());
		}
	}
	
	private void setValid(boolean ans) {
		valid = ans;
	}

	public boolean getValid() {
		if(this.valid == false) {
			color("#B00020");
		}

		return valid;
	}
	
	private void evts() {
		this.getDocument().addDocumentListener(new DocumentListener() {
			 
			public void changedUpdate(DocumentEvent e) {
				System.out.println("??");
			}
			public void removeUpdate(DocumentEvent e) {
				if(obligatorio() == true ) {
					if(len() > 0) {
						if(len() < min) {
							setValid(false);
							color("#B00020");
						}
					}
					else {
						color("reset");
						setValid(false);
					}
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(obligatorio() == true ) {
					if(len() > 5) {
						
						  if(len() <= max && len() >= min ){
							  setValid(true);
							  color("#008b00");
						}
						  else {
							  setValid(false);
							  color("#B00020");
						}
					  }
				}
				
				}
			});

	}
	

}
