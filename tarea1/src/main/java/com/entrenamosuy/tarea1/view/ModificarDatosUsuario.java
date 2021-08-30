package com.entrenamosuy.tarea1.view;

import com.entrenamosuy.tarea1.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.tarea1.logic.IControladorUsuario;
import com.entrenamosuy.tarea1.util.FuncionFecha;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

public class ModificarDatosUsuario extends JInternalFrame {
    private JTextField nombre;
    private JTextField apellido;
    private JDateChooser nacimiento;

    public ModificarDatosUsuario(String nickname, IControladorUsuario controladorUsuario) {
        ModificarDatosUsuario that = this;
        setTitle("Modificar datos usuario");
        setResizable(true);
        setClosable(true);
        setSize(640, 415);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNombre = new JLabel("Nombre");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.anchor = GridBagConstraints.WEST;
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 1;
        getContentPane().add(lblNombre, gbc_lblNombre);

        nombre = new JTextField();
        GridBagConstraints gbc_nombre = new GridBagConstraints();
        gbc_nombre.insets = new Insets(0, 0, 5, 5);
        gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombre.gridx = 3;
        gbc_nombre.gridy = 1;
        getContentPane().add(nombre, gbc_nombre);
        nombre.setColumns(10);

        JLabel label = new JLabel("Apellido");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.WEST;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 1;
        gbc_label.gridy = 3;
        getContentPane().add(label, gbc_label);

        apellido = new JTextField();
        GridBagConstraints gbc_apellido = new GridBagConstraints();
        gbc_apellido.insets = new Insets(0, 0, 5, 5);
        gbc_apellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellido.gridx = 3;
        gbc_apellido.gridy = 3;
        getContentPane().add(apellido, gbc_apellido);
        apellido.setColumns(10);

        JLabel lblNacimiento = new JLabel("Nacimiento");
        GridBagConstraints gbc_lblNacimiento = new GridBagConstraints();
        gbc_lblNacimiento.insets = new Insets(0, 0, 5, 5);
        gbc_lblNacimiento.gridx = 1;
        gbc_lblNacimiento.gridy = 5;
        getContentPane().add(lblNacimiento, gbc_lblNacimiento);

        nacimiento = new JDateChooser();
        GridBagConstraints gbc_nacimiento = new GridBagConstraints();
        gbc_nacimiento.insets = new Insets(0, 0, 5, 5);
        gbc_nacimiento.fill = GridBagConstraints.BOTH;
        gbc_nacimiento.gridx = 3;
        gbc_nacimiento.gridy = 5;
        getContentPane().add(nacimiento, gbc_nacimiento);

        JButton btnAceptar = new JButton("Aceptar");
        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
        gbc_btnAceptar.gridx = 3;
        gbc_btnAceptar.gridy = 9;
        getContentPane().add(btnAceptar, gbc_btnAceptar);
        //that.setVisible(false);


        btnAceptar.addActionListener((ActionEvent a) -> {
            try {
                controladorUsuario.modificarDatosUsuario(nickname, nombre.getText(), apellido.getText(),
                        FuncionFecha.convertToLocalDateViaInstant(nacimiento.getDate()));
                that.setVisible(false);
                
            } catch (UsuarioNoEncontradoException e) {
                JOptionPane.showMessageDialog(this, "Nickname no encontrado", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
