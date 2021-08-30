package com.entrenamosuy.tarea1.view;

import java.awt.EventQueue;
import com.toedter.calendar.JDateChooser;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
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
import javax.swing.JSlider;
import javax.swing.JSpinner;

public class CrearCuponera extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JLabel lblIngresarFecha;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCuponera frame = new CrearCuponera();
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
	public CrearCuponera() {
		setTitle("Crear Cuponera");
		getContentPane().setForeground(Color.RED);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{76, 0, 0, 0, 0, 49, 0, 9, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
						
								JLabel lblNewLabel = new JLabel("Ingresar Nombre");
								GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
								gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
								gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel.gridx = 1;
								gbc_lblNewLabel.gridy = 1;
								getContentPane().add(lblNewLabel, gbc_lblNewLabel);
				
						textField_4 = new JTextField();
						GridBagConstraints gbc_textField_4 = new GridBagConstraints();
						gbc_textField_4.gridwidth = 2;
						gbc_textField_4.insets = new Insets(0, 0, 5, 5);
						gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_4.gridx = 5;
						gbc_textField_4.gridy = 1;
						getContentPane().add(textField_4, gbc_textField_4);
						textField_4.setColumns(10);
						
								JLabel lblIngresarNombre = new JLabel("Ingresar Descripcion");
								GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
								gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
								gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
								gbc_lblIngresarNombre.gridx = 1;
								gbc_lblIngresarNombre.gridy = 3;
								getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);
				
						textField_5 = new JTextField();
						GridBagConstraints gbc_textField_5 = new GridBagConstraints();
						gbc_textField_5.gridwidth = 2;
						gbc_textField_5.insets = new Insets(0, 0, 5, 5);
						gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_5.gridx = 5;
						gbc_textField_5.gridy = 3;
						getContentPane().add(textField_5, gbc_textField_5);
						textField_5.setColumns(10);
				
						JLabel lblIngresarApellido = new JLabel("Ingresar Descuento");
						GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
						gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
						gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
						gbc_lblIngresarApellido.gridx = 1;
						gbc_lblIngresarApellido.gridy = 5;
						getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);
						
						SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
						spinner = new JSpinner(model);
						spinner.setToolTipText("");
						GridBagConstraints gbc_spinner = new GridBagConstraints();
						gbc_spinner.gridwidth = 2;
						gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
						gbc_spinner.insets = new Insets(0, 0, 5, 5);
						gbc_spinner.gridx = 5;
						gbc_spinner.gridy = 5;
						getContentPane().add(spinner, gbc_spinner);
				
						JLabel lblIngresarEmail = new JLabel("Ingresar Email");
						GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
						gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
						gbc_lblIngresarEmail.insets = new Insets(0, 0, 5, 5);
						gbc_lblIngresarEmail.gridx = 1;
						gbc_lblIngresarEmail.gridy = 7;
						getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);
		
				textField_7 = new JTextField();
				GridBagConstraints gbc_textField_7 = new GridBagConstraints();
				gbc_textField_7.gridwidth = 2;
				gbc_textField_7.insets = new Insets(0, 0, 5, 5);
				gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_7.gridx = 5;
				gbc_textField_7.gridy = 7;
				getContentPane().add(textField_7, gbc_textField_7);
				textField_7.setColumns(10);
				
				lblIngresarFecha = new JLabel("Ingresar fecha");
				GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
				gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
				gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngresarFecha.gridx = 1;
				gbc_lblIngresarFecha.gridy = 9;
				getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);
				
				JDateChooser lblNewLabel_1 = new JDateChooser();
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel_1.gridwidth = 2;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 5;
				gbc_lblNewLabel_1.gridy = 9;
				getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
				
				btnNewButton = new JButton("Aceptar");
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.anchor = GridBagConstraints.WEST;
				gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton.gridx = 1;
				gbc_btnNewButton.gridy = 11;
				getContentPane().add(btnNewButton, gbc_btnNewButton);
				
				btnNewButton_1 = new JButton("Cancelar");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
				gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_1.gridx = 5;
				gbc_btnNewButton_1.gridy = 11;
				getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		setBounds(100, 100, 555, 360);
	}
}
