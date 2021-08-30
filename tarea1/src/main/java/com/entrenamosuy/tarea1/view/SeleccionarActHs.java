package com.entrenamosuy.tarea1.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.entrenamosuy.tarea1.logic.IControladorCuponera;

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
import javax.swing.JSpinner;

public class SeleccionarActHs extends JInternalFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;



    public SeleccionarActHs(Set<String> acts, IControladorCuponera CC, App app, String cuponera) {
    	setResizable(true);
    	setMaximizable(true);
    	setClosable(true);
        setTitle("Agregar actividad a cuponera.");
        getContentPane().setForeground(Color.RED);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{76, 0, 0, 0, 49, 0, 9, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Seleccionar Actividad");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 2;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        JComboBox comboBox = new JComboBox(acts.toArray(new String[0]));
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.gridwidth = 2;
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 4;
        gbc_comboBox.gridy = 2;
        getContentPane().add(comboBox, gbc_comboBox);

        JLabel lblIngresarNombre = new JLabel("Seleccionar Cantidad Clases");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 5;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);
        
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinner = new JSpinner(model);
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.insets = new Insets(0, 0, 5, 5);
        gbc_spinner.gridx = 5;
        gbc_spinner.gridy = 5;
        getContentPane().add(spinner, gbc_spinner);

        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String act = (String) comboBox.getSelectedItem();
        		int clas = (int) spinner.getValue();
        		try {
        		CC.agregarACuponera(cuponera, act, clas);
        		}catch(Exception ep) {};
        		JOptionPane.showMessageDialog(app,"Actividad agregada.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        		spinner.setValue(1);
        		setVisible(false);
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.WEST;
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 9;
        getContentPane().add(btnNewButton, gbc_btnNewButton);
        setBounds(100, 100, 555, 360);
    }
}
