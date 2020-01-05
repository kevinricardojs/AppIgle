package com.iglesia.view;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iglesia.controller.AddMatrimonioController;
import com.iglesia.controller.AddPersonaController;
import com.iglesia.controller.AddPresentacionController;
import com.iglesia.controller.ListaMatrimonioController;
import com.iglesia.controller.ListaPersonaController;
import com.iglesia.controller.ListaPresentacionController;
import com.iglesia.helpers.BotonDef;

import net.miginfocom.swing.MigLayout;

public class JPIzquierda extends JPanel{
	private BtnPanIzq addPersona;
	private BtnPanIzq addMatrimonio;
	private BtnPanIzq addPresentacion;
	private BtnPanIzq listaBtn;
	private BtnPanIzq listaMatrinomio;
	private BtnPanIzq listaBebes;
	private MarcoApp padre;
	
	
	public JPIzquierda(MarcoApp padre) {
		this.padre = padre;
		this.setBackground(Color.decode("#232F34"));
		this.setLayout(new MigLayout("", "0[]0[]0[]0[]0[]0", "0[]0" ));
		
		addBotones();
	}
	// Inicializando botones del panel Izquierdo
	private void addBotones() {
		
		Icon personaIcono = new ImageIcon("imagenes/persona.png");
		addPersona = new BtnPanIzq("Agregar Persona", personaIcono);
		
		// Agregando actionListener para reaccionar al click
		AddPersonaController controllerPersona = new AddPersonaController(this.padre);
		addPersona.addActionListener(controllerPersona);
	
		
		Icon matrimonioIcono = new ImageIcon("imagenes/matrimonio.png");
		addMatrimonio = new BtnPanIzq("Agregar Matrimonio",matrimonioIcono);
		
		// Agregando actionListener para reaccionar al click
		AddMatrimonioController controllerMatrimonio = new AddMatrimonioController(this.padre);
		addMatrimonio.addActionListener(controllerMatrimonio);

		
		Icon presentacionIcono = new ImageIcon("imagenes/bebe.png");
		addPresentacion = new BtnPanIzq("Agregar Presentación", presentacionIcono);
		
		// Agregando actionListener para reaccionar al click
		AddPresentacionController controllerPresentacion = new AddPresentacionController(this.padre);
		addPresentacion.addActionListener(controllerPresentacion);
		
		Icon personas = new ImageIcon("imagenes/personas.png");
		listaBtn = new BtnPanIzq("Personas", personas);
		
		// Agregando actionListener para reaccionar al click
		ListaPersonaController controllerLista = new ListaPersonaController(this.padre);
		listaBtn.addActionListener(controllerLista);
		
		Icon matrimonios = new ImageIcon("imagenes/boda.png");
		listaMatrinomio = new BtnPanIzq("Matrimonios", matrimonios);
		
		// Agregando actionListener para reaccionar al click
		ListaMatrimonioController controllerListaM = new ListaMatrimonioController(this.padre);
		listaMatrinomio.addActionListener(controllerListaM);
		
		
		Icon bebes = new ImageIcon("imagenes/bebes.png");
		listaBebes = new BtnPanIzq("Presentaciones", bebes);

		ListaPresentacionController controllerListaP = new ListaPresentacionController(this.padre);
		listaBebes.addActionListener(controllerListaP);
		
		this.add(addPersona, "");
		this.add(addMatrimonio, "");
		this.add(addPresentacion, "");
		this.add(listaBtn, "");
		this.add(listaMatrinomio, "");
		this.add(listaBebes, "");
		
	}
	
	private class BtnPanIzq extends BotonDef{
		
			public BtnPanIzq(String text, Icon icono){
				
				super(text, icono);
				this.setDefaultColors(Color.decode("#3A4F5A"), Color.decode("#4A6572"), Color.decode("#344955"));
				this.setForeground(Color.decode("#FFFFFF"));
			}
	}
}


