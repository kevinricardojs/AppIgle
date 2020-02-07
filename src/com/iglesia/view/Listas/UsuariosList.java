package com.iglesia.view.Listas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.iglesia.BD.PersonaDB;
import com.iglesia.controller.FiltrosPersonaController;
import com.iglesia.controller.VerPersonaController;
import com.iglesia.helpers.BotonDef;
import com.iglesia.helpers.JLabelColored;
import com.iglesia.helpers.OpenButton;
import com.iglesia.helpers.SearchTextField;
import com.iglesia.helpers.TextValidField;
import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class UsuariosList extends JPanel{
	public ResultSet lista; 
	public JPanel contenedor;
	public JComboBox<Object> sexo;
	public JComboBox<Object> estado_civil; 
	public JComboBox<Object> miembro_activo;
	public BotonDef consulta;
	public JTextField campo;
	public JPanel resultado;
	public int id;
	


	public UsuariosList() {
		this.setLayout(new MigLayout("wrap 6, gap 5! 12!, insets 50 50"));
		this.setBackground(Color.decode("#263238"));
		Icon plus = new ImageIcon("imagenes/plus.png");
		JLabel titulo = new JLabel("Listado de registros", plus, SwingConstants.LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		titulo.setForeground(Color.white);
		contenedor = new JPanel();
		contenedor.setLayout(new MigLayout("wrap 5, fillx"));
		contenedor.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.add(titulo, "span 6, growx, pushx");
		this.filtros();
		this.add(contenedor, "span 6, growx, pushx");

	}
	
	public void filtros(){
		JLabel titulo = new JLabel("Buscar nombre:",SwingConstants.LEFT);
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		titulo.setForeground(Color.white);
		
		this.add(titulo, "span 6, growx, pushx");
		campo = new JTextField();
		this.add(campo, "span 4, growx, pushx, wrap");
		
		this.add(new JLabelColored("Sexo(*):", "#FFFFFF"), "span 1");
		sexo = new JComboBox<Object>(new String[] {" ", "M", "F"});
		this.add(sexo,"span 1, pushx, growx ");
		
		this.add(new JLabelColored("Estado Civil(*):", "#FFFFFF"), "span 1");
		estado_civil = new JComboBox<Object>(new String[] {" ","Soltero/a", "Casado/a", "Viudo/a"});
		this.add(estado_civil,"span 1, pushx, growx ");
		
		this.add(new JLabelColored("Miembro Activo(*):", "#FFFFFF"), "span 1");
		miembro_activo = new JComboBox<Object>(new String[] {" ", "No", "Si"});
		this.add(miembro_activo,"span 1, pushx, growx");
		
		FiltrosPersonaController f = new FiltrosPersonaController(this);
		consulta = new BotonDef("Buscar");
		consulta.addActionListener(f);
		this.add(consulta, "span 4, growx, pushx, wrap");
	}
	
	
	public void listar(){
		contenedor.add(new JLabel("No."));
		contenedor.add(new JLabel("Nombres"), "sg nombre");
		contenedor.add(new JLabel("Apellidos"), "sg apellido");
		contenedor.add(new JLabel("Celular"), "sg cel");
		contenedor.add(new JLabel("Acción"), "sg accion, center, span");
		
		int i = 1;
		try {
			
				while (this.lista.next()) {
					contenedor.add(new JLabel(Integer.toString(i)));
					contenedor.add(new JLabelColored(lista.getString("nombres"), "#000000"), "sg nombre");
					contenedor.add(new JLabelColored(lista.getString("apellidos"),"#000000"), "sg apellido");
					contenedor.add(new JLabelColored(lista.getString("cel"),"#000000"), "sg cel");
					OpenButton ver = new OpenButton("Ver", lista.getInt("id"));
					OpenButton update = new OpenButton("Editar", lista.getInt("id"));
					OpenButton del = new OpenButton("Borrar", lista.getInt("id"));
					
					VerPersonaController v = new VerPersonaController(ver);
					VerPersonaController u = new VerPersonaController(update);
					VerPersonaController d = new VerPersonaController(del);
					
					contenedor.add(ver, "split 3");
					contenedor.add(update);
					contenedor.add(del, "wrap");
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

}
