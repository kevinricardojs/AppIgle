package com.iglesia.root;

import com.iglesia.view.*;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.iglesia.BD.ConexionDB;
import com.iglesia.model.*;


public class Main {
	static MarcoApp m;
	public static void main(String[] args) {
		
		try { 
		        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 

		}
		 catch(Exception ignored){
			 JOptionPane.showMessageDialog(null, "Gui no compatible");
		 }
			 
		 m = new MarcoApp();

	}

}
