package com.entrenamosuy.tarea1.view;

import javax.swing.JInternalFrame;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.logic.IControladorUsuario;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class ConsultaProfesor extends JInternalFrame {
	private JTextField nicknameField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField correoField;
	private JTextField nacimientoField;
	private JTextField descripcionField;
	private JTextField textField_1;
	private JTextField textField_2;
    
    public ConsultaProfesor(String nickname, IControladorUsuario controladorUsuario) {
    	setResizable(true);
    	setClosable(true);
    	setTitle("Consulta profesor");
	setSize(757, 688);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{0, 108, 0, 0, 0, 0};
	gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
	getContentPane().setLayout(gridBagLayout);
	
	JLabel lblNickname = new JLabel("Nickname");
	GridBagConstraints gbc_lblNickname = new GridBagConstraints();
	gbc_lblNickname.anchor = GridBagConstraints.WEST;
	gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
	gbc_lblNickname.gridx = 1;
	gbc_lblNickname.gridy = 1;
	getContentPane().add(lblNickname, gbc_lblNickname);
	
	nicknameField = new JTextField();
	nicknameField.setEditable(false);
	GridBagConstraints gbc_nicknameField = new GridBagConstraints();
	gbc_nicknameField.insets = new Insets(0, 0, 5, 5);
	gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
	gbc_nicknameField.gridx = 3;
	gbc_nicknameField.gridy = 1;
	getContentPane().add(nicknameField, gbc_nicknameField);
	nicknameField.setColumns(10);
	
	JLabel lblNombre = new JLabel("Nombre");
	GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	gbc_lblNombre.anchor = GridBagConstraints.WEST;
	gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	gbc_lblNombre.gridx = 1;
	gbc_lblNombre.gridy = 3;
	getContentPane().add(lblNombre, gbc_lblNombre);
	
	nombreField = new JTextField();
	nombreField.setEditable(false);
	nombreField.setColumns(10);
	GridBagConstraints gbc_nombreField = new GridBagConstraints();
	gbc_nombreField.insets = new Insets(0, 0, 5, 5);
	gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
	gbc_nombreField.gridx = 3;
	gbc_nombreField.gridy = 3;
	getContentPane().add(nombreField, gbc_nombreField);
	
	JLabel lblApellido = new JLabel("Apellido");
	GridBagConstraints gbc_lblApellido = new GridBagConstraints();
	gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
	gbc_lblApellido.anchor = GridBagConstraints.WEST;
	gbc_lblApellido.gridx = 1;
	gbc_lblApellido.gridy = 5;
	getContentPane().add(lblApellido, gbc_lblApellido);
	
	apellidoField = new JTextField();
	apellidoField.setEditable(false);
	apellidoField.setColumns(10);
	GridBagConstraints gbc_apellidoField = new GridBagConstraints();
	gbc_apellidoField.insets = new Insets(0, 0, 5, 5);
	gbc_apellidoField.fill = GridBagConstraints.HORIZONTAL;
	gbc_apellidoField.gridx = 3;
	gbc_apellidoField.gridy = 5;
	getContentPane().add(apellidoField, gbc_apellidoField);
	
	JLabel lblCorreo = new JLabel("Correo");
	GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
	gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
	gbc_lblCorreo.anchor = GridBagConstraints.WEST;
	gbc_lblCorreo.gridx = 1;
	gbc_lblCorreo.gridy = 7;
	getContentPane().add(lblCorreo, gbc_lblCorreo);
	
	correoField = new JTextField();
	correoField.setEditable(false);
	correoField.setColumns(10);
	GridBagConstraints gbc_correoField = new GridBagConstraints();
	gbc_correoField.insets = new Insets(0, 0, 5, 5);
	gbc_correoField.fill = GridBagConstraints.HORIZONTAL;
	gbc_correoField.gridx = 3;
	gbc_correoField.gridy = 7;
	getContentPane().add(correoField, gbc_correoField);
	
	JLabel lblNacimiento = new JLabel("Nacimiento");
	GridBagConstraints gbc_lblNacimiento = new GridBagConstraints();
	gbc_lblNacimiento.insets = new Insets(0, 0, 5, 5);
	gbc_lblNacimiento.anchor = GridBagConstraints.WEST;
	gbc_lblNacimiento.gridx = 1;
	gbc_lblNacimiento.gridy = 9;
	getContentPane().add(lblNacimiento, gbc_lblNacimiento);
	
	nacimientoField = new JTextField();
	nacimientoField.setEditable(false);
	nacimientoField.setColumns(10);
	GridBagConstraints gbc_nacimientoField = new GridBagConstraints();
	gbc_nacimientoField.insets = new Insets(0, 0, 5, 5);
	gbc_nacimientoField.fill = GridBagConstraints.HORIZONTAL;
	gbc_nacimientoField.gridx = 3;
	gbc_nacimientoField.gridy = 9;
	getContentPane().add(nacimientoField, gbc_nacimientoField);
	
	JLabel descripcionbutton = new JLabel("Descripcion");
	GridBagConstraints gbc_descripcionbutton = new GridBagConstraints();
	gbc_descripcionbutton.anchor = GridBagConstraints.WEST;
	gbc_descripcionbutton.insets = new Insets(0, 0, 5, 5);
	gbc_descripcionbutton.gridx = 1;
	gbc_descripcionbutton.gridy = 11;
	getContentPane().add(descripcionbutton, gbc_descripcionbutton);
	
	descripcionField = new JTextField();
	descripcionField.setEditable(false);
	descripcionField.setColumns(10);
	GridBagConstraints gbc_descripcionField = new GridBagConstraints();
	gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
	gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
	gbc_descripcionField.gridx = 3;
	gbc_descripcionField.gridy = 11;
	getContentPane().add(descripcionField, gbc_descripcionField);
	
	JLabel lblBiografia = new JLabel("Biografia");
	GridBagConstraints gbc_lblBiografia = new GridBagConstraints();
	gbc_lblBiografia.anchor = GridBagConstraints.WEST;
	gbc_lblBiografia.insets = new Insets(0, 0, 5, 5);
	gbc_lblBiografia.gridx = 1;
	gbc_lblBiografia.gridy = 13;
	getContentPane().add(lblBiografia, gbc_lblBiografia);
	
	textField_1 = new JTextField();
	textField_1.setEditable(false);
	textField_1.setColumns(10);
	GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	gbc_textField_1.insets = new Insets(0, 0, 5, 5);
	gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_1.gridx = 3;
	gbc_textField_1.gridy = 13;
	getContentPane().add(textField_1, gbc_textField_1);
	
	JLabel lblSitioWeb = new JLabel("Sitio Web");
	GridBagConstraints gbc_lblSitioWeb = new GridBagConstraints();
	gbc_lblSitioWeb.anchor = GridBagConstraints.WEST;
	gbc_lblSitioWeb.insets = new Insets(0, 0, 5, 5);
	gbc_lblSitioWeb.gridx = 1;
	gbc_lblSitioWeb.gridy = 15;
	getContentPane().add(lblSitioWeb, gbc_lblSitioWeb);
	
	textField_2 = new JTextField();
	textField_2.setEditable(false);
	textField_2.setColumns(10);
	GridBagConstraints gbc_textField_2 = new GridBagConstraints();
	gbc_textField_2.insets = new Insets(0, 0, 5, 5);
	gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_2.gridx = 3;
	gbc_textField_2.gridy = 15;
	getContentPane().add(textField_2, gbc_textField_2);
	
	JLabel lblClases = new JLabel("Clases");
	GridBagConstraints gbc_lblClases = new GridBagConstraints();
	gbc_lblClases.anchor = GridBagConstraints.WEST;
	gbc_lblClases.insets = new Insets(0, 0, 5, 5);
	gbc_lblClases.gridx = 1;
	gbc_lblClases.gridy = 17;
	getContentPane().add(lblClases, gbc_lblClases);
	
	JScrollPane scrollPane = new JScrollPane();
	GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
	gbc_scrollPane.fill = GridBagConstraints.BOTH;
	gbc_scrollPane.gridx = 3;
	gbc_scrollPane.gridy = 17;
	getContentPane().add(scrollPane, gbc_scrollPane);
	
	JLabel lblActividades = new JLabel("Actividades");
	GridBagConstraints gbc_lblActividades = new GridBagConstraints();
	gbc_lblActividades.anchor = GridBagConstraints.WEST;
	gbc_lblActividades.fill = GridBagConstraints.VERTICAL;
	gbc_lblActividades.insets = new Insets(0, 0, 5, 5);
	gbc_lblActividades.gridx = 1;
	gbc_lblActividades.gridy = 19;
	getContentPane().add(lblActividades, gbc_lblActividades);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
	gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
	gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
	gbc_scrollPane_1.gridx = 3;
	gbc_scrollPane_1.gridy = 19;
	getContentPane().add(scrollPane_1, gbc_scrollPane_1);
	
	DataProfesor profesor = null;
	try {
	    profesor = controladorUsuario.consultarProfesor(nickname);
	} catch (ProfesorNoEncontradoException e) {
	    e.printStackTrace();
	}
	
	nicknameField.setText(profesor.getNickname());
	nombreField.setText(profesor.getNombre());
	apellidoField.setText(profesor.getApellido());
	nacimientoField.setText(profesor.getNacimiento().toString());
	descripcionField.setText(profesor.getDescripcion());
    }
}
