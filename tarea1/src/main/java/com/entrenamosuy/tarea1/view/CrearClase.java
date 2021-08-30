package com.entrenamosuy.tarea1.view;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;

import com.entrenamosuy.tarea1.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.tarea1.logic.ControladorActividadClase;
import com.entrenamosuy.tarea1.logic.IControladorActividadClase;
import com.entrenamosuy.tarea1.logic.Manejador;
import com.entrenamosuy.tarea1.logic.Institucion;
import com.toedter.calendar.JDateChooser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class CrearClase extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;


	public CrearClase(IControladorActividadClase CAC, App app) {
		Manejador man = Manejador.getInstance();

		String[] insts = man.getInstituciones().keySet().toArray(new String[0]);

		setTitle("Alta de dictado de clase");
		getContentPane().setForeground(Color.RED);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{76, 0, 0, 0, 49, 0, 9, 0};
		gridBagLayout.rowHeights = new int[]{0, 66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
				JLabel lblNewLabel = new JLabel("Seleccionar Institucion");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 1;
				getContentPane().add(lblNewLabel, gbc_lblNewLabel);
				
				JComboBox comboBox = new JComboBox(insts);
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 5;
				gbc_comboBox.gridy = 1;
				getContentPane().add(comboBox, gbc_comboBox);
		
				JLabel lblIngresarNombre = new JLabel("Ingresar Nombre");
				GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
				gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
				gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngresarNombre.gridx = 1;
				gbc_lblIngresarNombre.gridy = 2;
				getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);
		
				textField_5 = new JTextField();
				GridBagConstraints gbc_textField_5 = new GridBagConstraints();
				gbc_textField_5.insets = new Insets(0, 0, 5, 5);
				gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_5.gridx = 5;
				gbc_textField_5.gridy = 2;
				getContentPane().add(textField_5, gbc_textField_5);
				textField_5.setColumns(10);
				
						JLabel lblIngresarApellido = new JLabel("Ingresar descripcion");
						GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
						gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
						gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
						gbc_lblIngresarApellido.gridx = 1;
						gbc_lblIngresarApellido.gridy = 4;
						getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);
				
						textField_6 = new JTextField();
						GridBagConstraints gbc_textField_6 = new GridBagConstraints();
						gbc_textField_6.insets = new Insets(0, 0, 5, 5);
						gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_6.gridx = 5;
						gbc_textField_6.gridy = 4;
						getContentPane().add(textField_6, gbc_textField_6);
						textField_6.setColumns(10);
		
				JLabel lblIngresarEmail = new JLabel("Ingresar duracion (min)");
				GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
				gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
				gbc_lblIngresarEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngresarEmail.gridx = 1;
				gbc_lblIngresarEmail.gridy = 6;
				getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);
		
				textField_7 = new JTextField();
				GridBagConstraints gbc_textField_7 = new GridBagConstraints();
				gbc_textField_7.insets = new Insets(0, 0, 5, 5);
				gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_7.gridx = 5;
				gbc_textField_7.gridy = 6;
				getContentPane().add(textField_7, gbc_textField_7);
				textField_7.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresar costo");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 8;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 5;
		gbc_textField_8.gridy = 8;
		getContentPane().add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JLabel lblIngresarFecha = new JLabel("Ingresar fecha");
		GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
		gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarFecha.gridx = 1;
		gbc_lblIngresarFecha.gridy = 10;
		getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);
		
		JDateChooser lblNewLabel_2 = new JDateChooser();
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 10;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Aceptar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 12;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 12;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		setBounds(100, 100, 555, 360);
	}
}