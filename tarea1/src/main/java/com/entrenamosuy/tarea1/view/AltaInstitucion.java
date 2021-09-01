package com.entrenamosuy.tarea1.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entrenamosuy.tarea1.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.tarea1.logic.IControladorActividadClase;

public class AltaInstitucion extends JInternalFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    /**
     * Create the frame.
     */
    public AltaInstitucion(IControladorActividadClase CAC, App app) {
    	setMaximizable(true);
    	setResizable(true);
    	setClosable(true);
        setTitle("Alta de institucion deportiva");
        getContentPane().setForeground(Color.RED);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{76, 0, 0, 0, 49, 0, 9, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 5;
        gbc_textField_4.gridy = 1;
        getContentPane().add(textField_4, gbc_textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.gridheight = 3;
        gbc_textField_5.insets = new Insets(0, 0, 5, 5);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 5;
        gbc_textField_5.gridy = 3;
        getContentPane().add(textField_5, gbc_textField_5);
        textField_5.setColumns(10);

        JLabel lblIngresarNombre = new JLabel("Ingresar Descripcion");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 4;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);

        JLabel lblIngresarApellido = new JLabel("Ingresar URL");
        GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
        gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarApellido.gridx = 1;
        gbc_lblIngresarApellido.gridy = 7;
        getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

        textField_6 = new JTextField();
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.insets = new Insets(0, 0, 5, 5);
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.gridx = 5;
        gbc_textField_6.gridy = 7;
        getContentPane().add(textField_6, gbc_textField_6);
        textField_6.setColumns(10);
                                
                                        JButton btnNewButton = new JButton("Aceptar");
                                        btnNewButton.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		setVisible(false);
                                        		String nombre = textField_4.getText();
                                        		String desc = textField_5.getText();
                                        		URL link = null;
                                                try {
                                                    link = new URL(textField_6.getText());
                                                } catch (MalformedURLException e1) {
                                                    textField_4.setText("");
                                                    textField_5.setText("");
                                                    textField_6.setText("");
                                                    setVisible(true);
                                                    JOptionPane.showMessageDialog(app, "URL no valida ingrese: https://ejemplo.xxx", "error", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                                                try {
                                                	CAC.crearInstitucion(nombre, desc, link);
                                                }
                                                catch(InstitucionRepetidaException rep) {
                                                    textField_4.setText("");
                                                    textField_5.setText("");
                                                    textField_6.setText("");
                                                    setVisible(true);
                                                    JOptionPane.showMessageDialog(app, "Institucion ya existente", "error", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                                                JOptionPane.showMessageDialog(app,"Institucion creada exitosamente,", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                        	}
                                        });
                                        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
                                        gbc_btnNewButton.anchor = GridBagConstraints.WEST;
                                        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
                                        gbc_btnNewButton.gridx = 1;
                                        gbc_btnNewButton.gridy = 10;
                                        getContentPane().add(btnNewButton, gbc_btnNewButton);
        setBounds(100, 100, 555, 360);
    }
}