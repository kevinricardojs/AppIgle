package com.iglesia.helpers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.border.Border;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.iglesia.view.forms.AddPersona;

public class ImgChooser implements ActionListener{
	
	 private JFileChooser fileChooser;
     private File file;
     int returnVal;
     AddPersona padre;
    
     public ImgChooser(AddPersona padre){
    	 this.padre = padre;
             fileChooser = new JFileChooser();
     }
    
     public void actionPerformed(ActionEvent e){
    	 
    			Display display = new Display ();
    		    Shell shell = new Shell (display);
    		    // Don't show the shell.
    		    // shell.open();  
    		    FileDialog dialog = new FileDialog (shell, SWT.OPEN | SWT.MULTI);
    		    dialog.setText("Escoger Fotografia");
    		    String[] filterNames = new String [] {"JPEG (*.jpg)", "PNG (*.png)"};
    		    String[] filterExtensions = new String [] {"*.jpg", "*.png"};
    		    String filterPath = "c:\\";
    		    dialog.setFilterNames (filterNames);
    		    dialog.setFilterExtensions (filterExtensions);
    		    dialog.setFilterPath (filterPath);
    		    
    		    String selected = dialog.open();
    		    if (selected != null) {
    		    	 ImageIcon i = Helper.redimensionarIcono(new ImageIcon(selected), 250, 250);
                	 
                	 this.padre.fotografia_url.setIcon(i);
                	 this.padre.fotografia_url.setOpaque(true);
             		Border borde = BorderFactory.createLineBorder(Color.decode("#008b00"));
             		this.padre.fotografia_url.setBorder(borde);
    		    	this.padre.imagePath = selected;
    		    }
    		    
    		   // String[] selectedFileNames = dialog.getFileNames();
    		    
    		    //System.out.println(dialog.getFilterPath() + selectedFileNames[0] );

    		    /*for(String fileName : selectedFileNames) {
    		        System.out.println("  " + fileName);
    		    }*/

    		    shell.close();

    		    while (!shell.isDisposed()) {
    		        if (!display.readAndDispatch())
    		            display.sleep();
    		    }

    		    display.dispose();
    	 
    	 
    	 
    	 
    	/* 
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
             */
     }


}
