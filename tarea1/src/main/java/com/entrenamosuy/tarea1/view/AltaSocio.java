package com.entrenamosuy.tarea1.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AltaSocio extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaSocio frame = new AltaSocio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaSocio() {
		setTitle("Alta Socio");
		getContentPane().setForeground(Color.RED);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{76, 0, 0, 0, 49, 0, 9, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Ingresar Nickname");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 5;
		gbc_textField_4.gridy = 1;
		getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		JLabel lblIngresarNombre = new JLabel("Ingresar Nombre");
		GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
		gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarNombre.gridx = 1;
		gbc_lblIngresarNombre.gridy = 3;
		getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);

		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 5;
		gbc_textField_5.gridy = 3;
		getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);

		JLabel lblIngresarApellido = new JLabel("Ingresar Apellido");
		GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
		gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarApellido.gridx = 1;
		gbc_lblIngresarApellido.gridy = 5;
		getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 5;
		getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);

		JLabel lblIngresarEmail = new JLabel("Ingresar Email");
		GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
		gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblIngresarEmail.gridx = 1;
		gbc_lblIngresarEmail.gridy = 7;
		getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);

		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 0, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 5;
		gbc_textField_7.gridy = 7;
		getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		setBounds(100, 100, 555, 360);
	}
}
