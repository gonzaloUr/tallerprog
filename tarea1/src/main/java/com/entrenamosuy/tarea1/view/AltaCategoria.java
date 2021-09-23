package com.entrenamosuy.tarea1.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entrenamosuy.core.exceptions.CategoriaRepetidaException;
import com.entrenamosuy.core.util.*;

public class AltaCategoria extends JInternalFrame {
    private JTextField nombreField;
    private JButton aceptar;

    public AltaCategoria(App app, FacadeContainer facades) {
        setResizable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Alta Categoria");
        getContentPane().setForeground(Color.RED);
        setBounds(100, 100, 579, 400);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 49, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Ingresar Nombre");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        nombreField = new JTextField();
        GridBagConstraints gbc_nicknameField = new GridBagConstraints();
        gbc_nicknameField.insets = new Insets(0, 0, 5, 5);
        gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nicknameField.gridx = 3;
        gbc_nicknameField.gridy = 1;
        getContentPane().add(nombreField, gbc_nicknameField);
        nombreField.setColumns(10);

        aceptar = new JButton("Aceptar");
        GridBagConstraints gbc_aceptar = new GridBagConstraints();
        gbc_aceptar.insets = new Insets(0, 0, 5, 5);
        gbc_aceptar.gridx = 3;
        gbc_aceptar.gridy = 11;
        getContentPane().add(aceptar, gbc_aceptar);

        aceptar.addActionListener((ActionEvent e) -> {
            String nombre = nombreField.getText();

            try {
                facades.getFacadeActividad().crearCategoria(nombre);
            } catch (CategoriaRepetidaException e1) {
                nombreField.setText("");
                JOptionPane.showMessageDialog(app, "Ya existe una categoria con ese nombre.", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(app, "Categoria creada exitosamente.");
            setVisible(false);
        });
    }
}

