package com.iglesia.helpers;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.iglesia.view.forms.NewPersona;

public class ImgChooser implements ActionListener{
	
	 private JFileChooser fileChooser;
     private File file;
     int returnVal;
     NewPersona padre;
    
     public ImgChooser(NewPersona padre){
    	 this.padre = padre;
             fileChooser = new JFileChooser();
     }
    
     public void actionPerformed(ActionEvent e){
    	 this.padre.fotografia_url.setBackground(new Color(75, 75, 75));
    	 JButton op = (JButton)e.getSource();
             if(op.getText() == "Añadir"){
                     returnVal = fileChooser.showOpenDialog(null);
                     if(returnVal == JFileChooser.APPROVE_OPTION){
                    	 file = fileChooser.getSelectedFile();
                    	 String dir = file.getAbsolutePath();
                    	 this.padre.imagePath = dir;
                    	 ImageIcon i = Helper.redimensionarIcono(new ImageIcon(dir), 250, 250);
                    	 
                    	 this.padre.fotografia_url.setIcon(i);
                    	 this.padre.fotografia_url.setOpaque(true);
                 		Border borde = BorderFactory.createLineBorder(Color.decode("#008b00"));
                 		this.padre.fotografia_url.setBorder(borde);
                    	// this.padre.fotografia_url.setForeground();
                    	 
                    	 
                     }
             }
     }


}
