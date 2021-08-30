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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RegistroAClase extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroAClase frame = new RegistroAClase();
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
	public RegistroAClase() {
		setTitle("Registro a dictado de clase.");
		getContentPane().setForeground(Color.RED);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{76, 0, 0, 0, 49, 0, 9, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Seleccionar Socio");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
						
						JComboBox comboBox = new JComboBox();
						GridBagConstraints gbc_comboBox = new GridBagConstraints();
						gbc_comboBox.insets = new Insets(0, 0, 5, 5);
						gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboBox.gridx = 5;
						gbc_comboBox.gridy = 1;
						getContentPane().add(comboBox, gbc_comboBox);
				
						JLabel lblIngresarNombre = new JLabel("Seleccionar Clase");
						GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
						gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
						gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
						gbc_lblIngresarNombre.gridx = 1;
						gbc_lblIngresarNombre.gridy = 3;
						getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);
								
								JComboBox comboBox_1 = new JComboBox();
								GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
								gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
								gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
								gbc_comboBox_1.gridx = 5;
								gbc_comboBox_1.gridy = 3;
								getContentPane().add(comboBox_1, gbc_comboBox_1);
								
								JLabel lblSeleccionarCuponera = new JLabel("Seleccionar Cuponera");
								GridBagConstraints gbc_lblSeleccionarCuponera = new GridBagConstraints();
								gbc_lblSeleccionarCuponera.insets = new Insets(0, 0, 5, 5);
								gbc_lblSeleccionarCuponera.gridx = 1;
								gbc_lblSeleccionarCuponera.gridy = 5;
								getContentPane().add(lblSeleccionarCuponera, gbc_lblSeleccionarCuponera);
								
								JComboBox comboBox_2 = new JComboBox();
								GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
								gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
								gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
								gbc_comboBox_2.gridx = 5;
								gbc_comboBox_2.gridy = 5;
								getContentPane().add(comboBox_2, gbc_comboBox_2);
						
								JLabel lblIngresarApellido = new JLabel("Ingresar fecha");
								GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
								gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
								gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
								gbc_lblIngresarApellido.gridx = 1;
								gbc_lblIngresarApellido.gridy = 7;
								getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);
						
						JButton btnNewButton = new JButton("Aceptar");
						GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
						gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
						gbc_btnNewButton.gridx = 1;
						gbc_btnNewButton.gridy = 9;
						getContentPane().add(btnNewButton, gbc_btnNewButton);
						
						JButton btnNewButton_1 = new JButton("Cancelar");
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
						gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
						gbc_btnNewButton_1.gridx = 5;
						gbc_btnNewButton_1.gridy = 9;
						getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		setBounds(100, 100, 555, 360);
	}
}