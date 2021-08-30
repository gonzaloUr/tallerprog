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
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import com.entrenamosuy.tarea1.util.Pair;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class RegistroAClase extends JInternalFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    public RegistroAClase(String actividad, String socio, Set<Pair<String, String>> cuponeras) {
	setTitle("Registro a dictado de clase.");
	getContentPane().setForeground(Color.RED);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
	gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	getContentPane().setLayout(gridBagLayout);

	JLabel lblSeleccionarCuponera = new JLabel("Seleccionar Cuponera");
	GridBagConstraints gbc_lblSeleccionarCuponera = new GridBagConstraints();
	gbc_lblSeleccionarCuponera.insets = new Insets(0, 0, 5, 5);
	gbc_lblSeleccionarCuponera.gridx = 1;
	gbc_lblSeleccionarCuponera.gridy = 1;
	getContentPane().add(lblSeleccionarCuponera, gbc_lblSeleccionarCuponera);

	JComboBox cuponerasComboBox = new JComboBox();
	GridBagConstraints gbc_cuponerasComboBox = new GridBagConstraints();
	gbc_cuponerasComboBox.insets = new Insets(0, 0, 5, 5);
	gbc_cuponerasComboBox.fill = GridBagConstraints.HORIZONTAL;
	gbc_cuponerasComboBox.gridx = 3;
	gbc_cuponerasComboBox.gridy = 1;
	getContentPane().add(cuponerasComboBox, gbc_cuponerasComboBox);

	JCheckBox utilizarCheckBox = new JCheckBox("Utilizar cuponera");
	GridBagConstraints gbc_utilizarCheckBox = new GridBagConstraints();
	gbc_utilizarCheckBox.insets = new Insets(0, 0, 5, 5);
	gbc_utilizarCheckBox.gridx = 3;
	gbc_utilizarCheckBox.gridy = 3;
	getContentPane().add(utilizarCheckBox, gbc_utilizarCheckBox);

	JLabel lblIngresarApellido = new JLabel("Ingresar fecha");
	GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
	gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
	gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
	gbc_lblIngresarApellido.gridx = 1;
	gbc_lblIngresarApellido.gridy = 5;
	getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

	JDateChooser calendario = new JDateChooser();
	GridBagConstraints gbc_calendario = new GridBagConstraints();
	gbc_calendario.fill = GridBagConstraints.HORIZONTAL;
	gbc_calendario.insets = new Insets(0, 0, 5, 9);
	gbc_calendario.gridx = 3;
	gbc_calendario.gridy = 5;
	getContentPane().add(calendario, gbc_calendario);

	JButton aceptar = new JButton("Aceptar");
	GridBagConstraints gbc_aceptar = new GridBagConstraints();
	gbc_aceptar.insets = new Insets(0, 0, 5, 5);
	gbc_aceptar.gridx = 3;
	gbc_aceptar.gridy = 7;
	getContentPane().add(aceptar, gbc_aceptar);
	setBounds(100, 100, 555, 360);
	
	aceptar.addActionListener((ActionEvent a) -> {

	});
    }
}