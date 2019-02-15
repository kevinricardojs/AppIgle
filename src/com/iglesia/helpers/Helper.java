package com.iglesia.helpers;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Helper{
	
	public static ImageIcon redimensionarIcono(ImageIcon icono, int ancho, int alto) {
		 Image img = icono.getImage();  
		 Image resizedImage = img.getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH);  
		 return new ImageIcon(resizedImage);
	}
}
