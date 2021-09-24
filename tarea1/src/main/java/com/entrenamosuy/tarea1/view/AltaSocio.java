package com.entrenamosuy.tarea1.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.EmailParseException;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.util.*;
import com.toedter.calendar.JDateChooser;

public class AltaSocio extends JInternalFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField nicknameField;
    private JTextField passwordField;
    private JTextField confirmPasswordField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField emailField;
    private JLabel lblIngresarFecha;
    private JLabel lblNewLabel_1;
    private JButton aceptar;

    public AltaSocio(App app, FacadeContainer facades) {
        setResizable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Alta Socio");
        getContentPane().setForeground(Color.RED);
        setBounds(100, 100, 579, 400);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 49, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Ingresar Nickname");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        nicknameField = new JTextField();
        GridBagConstraints gbc_nicknameField = new GridBagConstraints();
        gbc_nicknameField.insets = new Insets(0, 0, 5, 5);
        gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nicknameField.gridx = 3;
        gbc_nicknameField.gridy = 1;
        getContentPane().add(nicknameField, gbc_nicknameField);
        nicknameField.setColumns(10);

        JLabel lblPassword = new JLabel("Ingresar Contraseña");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.anchor = GridBagConstraints.WEST;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 1;
        gbc_lblPassword.gridy = 3;
        getContentPane().add(lblPassword, gbc_lblPassword);

        passwordField = new JTextField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 3;
        gbc_passwordField.gridy = 3;
        getContentPane().add(passwordField, gbc_passwordField);
        passwordField.setColumns(10);

        JLabel lblconfirmPassword = new JLabel("Confirmar Contraseña");
        GridBagConstraints gbc_lblconfirmPassword = new GridBagConstraints();
        gbc_lblconfirmPassword.anchor = GridBagConstraints.WEST;
        gbc_lblconfirmPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblconfirmPassword.gridx = 1;
        gbc_lblconfirmPassword.gridy = 5;
        getContentPane().add(lblconfirmPassword, gbc_lblconfirmPassword);

        confirmPasswordField = new JTextField();
        GridBagConstraints gbc_confirmPasswordField = new GridBagConstraints();
        gbc_confirmPasswordField.insets = new Insets(0, 0, 5, 5);
        gbc_confirmPasswordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_confirmPasswordField.gridx = 3;
        gbc_confirmPasswordField.gridy = 5;
        getContentPane().add(confirmPasswordField, gbc_confirmPasswordField);
        confirmPasswordField.setColumns(10);

        JLabel lblIngresarNombre = new JLabel("Ingresar Nombre");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 7;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);

        nombreField = new JTextField();
        GridBagConstraints gbc_nombreField = new GridBagConstraints();
        gbc_nombreField.insets = new Insets(0, 0, 5, 5);
        gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreField.gridx = 3;
        gbc_nombreField.gridy = 7;
        getContentPane().add(nombreField, gbc_nombreField);
        nombreField.setColumns(10);

        JLabel lblIngresarApellido = new JLabel("Ingresar Apellido");
        GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
        gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarApellido.gridx = 1;
        gbc_lblIngresarApellido.gridy = 9;
        getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

        apellidoField = new JTextField();
        GridBagConstraints gbc_apellidoField = new GridBagConstraints();
        gbc_apellidoField.insets = new Insets(0, 0, 5, 5);
        gbc_apellidoField.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellidoField.gridx = 3;
        gbc_apellidoField.gridy = 9;
        getContentPane().add(apellidoField, gbc_apellidoField);
        apellidoField.setColumns(10);

        JLabel lblIngresarEmail = new JLabel("Ingresar Email");
        GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
        gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarEmail.gridx = 1;
        gbc_lblIngresarEmail.gridy = 11;
        getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);

        emailField = new JTextField();
        GridBagConstraints gbc_emailField = new GridBagConstraints();
        gbc_emailField.insets = new Insets(0, 0, 5, 5);
        gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
        gbc_emailField.gridx = 3;
        gbc_emailField.gridy = 11;
        getContentPane().add(emailField, gbc_emailField);
        emailField.setColumns(10);

        lblIngresarFecha = new JLabel("Ingresar nacimiento");
        GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
        gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarFecha.gridx = 1;
        gbc_lblIngresarFecha.gridy = 12;
        getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);

        JDateChooser calendario = new JDateChooser();
        GridBagConstraints gbc_calendario = new GridBagConstraints();
        gbc_calendario.fill = GridBagConstraints.HORIZONTAL;
        gbc_calendario.insets = new Insets(0, 0, 5, 5);
        gbc_calendario.gridx = 3;
        gbc_calendario.gridy = 12;
        getContentPane().add(calendario, gbc_calendario);

        aceptar = new JButton("Aceptar");
        GridBagConstraints gbc_aceptar = new GridBagConstraints();
        gbc_aceptar.insets = new Insets(0, 0, 5, 5);
        gbc_aceptar.gridx = 3;
        gbc_aceptar.gridy = 14;
        getContentPane().add(aceptar, gbc_aceptar);

        aceptar.addActionListener((ActionEvent e) -> {
            String nick = nicknameField.getText();
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String mail = emailField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            LocalDate fecha = FechaUtil.toLocalDate(calendario.getDate());

            if (!password.equals(confirmPassword)){ //hago el control aca para no obligar al constructor a hacer el checkeo
                JOptionPane.showMessageDialog(this,
                        "Las contraseñas ingresadas son distintas.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);
                confirmPasswordField.setText("");

                return;
            }

            try {
                facades.getFacadeUsuario().crearSocio()
                        .setNickname(nick)
                        .setPassword(password)
                        .setNombre(nombre)
                        .setApellido(apellido)
                        .setCorreo(Email.parse(mail))
                        .setNacimiento(fecha)
                        .invoke();
            } catch (UsuarioRepetidoException e1) {
                JOptionPane.showMessageDialog(app, "Usuario ya existe", "error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (EmailParseException e1) {
                JOptionPane.showMessageDialog(app, "Email invalido", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(app, "Socio creado exitosamente.");
            setVisible(false);
        });
    }
}
