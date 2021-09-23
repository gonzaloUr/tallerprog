package com.entrenamosuy.tarea1.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.EmailParseException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.util.FacadeContainer;
import com.entrenamosuy.core.util.FechaUtil;
import com.toedter.calendar.JDateChooser;

public class AltaProfesor extends JInternalFrame {
    private JTextField nicknameField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField confirmPasswordField;
    private JLabel lblIngresarFecha;
    private JButton aceptar;
    private JLabel lblIngresarInstitucion;
    private JLabel lblIngresarDescripcion;
    private JTextField descripcionField;
    private JLabel lblIngresarBiografia;
    private JTextField biografiaField;
    private JLabel lblIngresarUrlhttpsejej;
    private JTextField urlField;
    private JComboBox institucionComboBox;

    public AltaProfesor(App app, FacadeContainer facades) {
    	setResizable(true);
    	setMaximizable(true);
    	setClosable(true);
        setBounds(100, 100, 586, 357);

        String[] instituciones = facades.getFacadeInstitucion().getInstituciones().toArray(new String[0]);

    	setTitle("Alta Profesor");
        getContentPane().setForeground(Color.RED);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{43, 209, 0, 49, 9, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
        gbc_lblPassword.gridy = 2;
        getContentPane().add(lblPassword, gbc_lblPassword);

        passwordField = new JTextField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 3;
        gbc_passwordField.gridy = 2;
        getContentPane().add(passwordField, gbc_passwordField);
        passwordField.setColumns(10);

        JLabel lblconfirmPassword = new JLabel("Confirmar Contraseña");
        GridBagConstraints gbc_lblconfirmPassword = new GridBagConstraints();
        gbc_lblconfirmPassword.anchor = GridBagConstraints.WEST;
        gbc_lblconfirmPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblconfirmPassword.gridx = 1;
        gbc_lblconfirmPassword.gridy = 3;
        getContentPane().add(lblconfirmPassword, gbc_lblconfirmPassword);

        confirmPasswordField = new JTextField();
        GridBagConstraints gbc_confirmPasswordField = new GridBagConstraints();
        gbc_confirmPasswordField.insets = new Insets(0, 0, 5, 5);
        gbc_confirmPasswordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_confirmPasswordField.gridx = 3;
        gbc_confirmPasswordField.gridy = 3;
        getContentPane().add(confirmPasswordField, gbc_confirmPasswordField);
        confirmPasswordField.setColumns(10);

        JLabel lblIngresarNombre = new JLabel("Ingresar Nombre");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 4;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);

        nombreField = new JTextField();
        GridBagConstraints gbc_nombreField = new GridBagConstraints();
        gbc_nombreField.insets = new Insets(0, 0, 5, 5);
        gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreField.gridx = 3;
        gbc_nombreField.gridy = 4;
        getContentPane().add(nombreField, gbc_nombreField);
        nombreField.setColumns(10);

        JLabel lblIngresarApellido = new JLabel("Ingresar Apellido");
        GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
        gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarApellido.gridx = 1;
        gbc_lblIngresarApellido.gridy = 5;
        getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

        apellidoField = new JTextField();
        GridBagConstraints gbc_apellidoField = new GridBagConstraints();
        gbc_apellidoField.insets = new Insets(0, 0, 5, 5);
        gbc_apellidoField.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellidoField.gridx = 3;
        gbc_apellidoField.gridy = 5;
        getContentPane().add(apellidoField, gbc_apellidoField);
        apellidoField.setColumns(10);

        JLabel lblIngresarEmail = new JLabel("Ingresar Email");
        GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
        gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarEmail.gridx = 1;
        gbc_lblIngresarEmail.gridy = 6;
        getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);

        emailField = new JTextField();
        GridBagConstraints gbc_emailField = new GridBagConstraints();
        gbc_emailField.insets = new Insets(0, 0, 5, 5);
        gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
        gbc_emailField.gridx = 3;
        gbc_emailField.gridy = 6;
        getContentPane().add(emailField, gbc_emailField);
        emailField.setColumns(10);

        lblIngresarFecha = new JLabel("Ingresar nacimiento");
        GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
        gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarFecha.gridx = 1;
        gbc_lblIngresarFecha.gridy = 7;
        getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);

	JDateChooser fechaField = new JDateChooser();
	GridBagConstraints gbc_fechaField = new GridBagConstraints();
	gbc_fechaField.fill = GridBagConstraints.HORIZONTAL;
	gbc_fechaField.insets = new Insets(0, 0, 5, 5);
	gbc_fechaField.gridx = 3;
	gbc_fechaField.gridy = 7;
	getContentPane().add(fechaField, gbc_fechaField);

	lblIngresarInstitucion = new JLabel("Ingresar Institucion");
	GridBagConstraints gbc_lblIngresarInstitucion = new GridBagConstraints();
	gbc_lblIngresarInstitucion.anchor = GridBagConstraints.WEST;
	gbc_lblIngresarInstitucion.insets = new Insets(0, 0, 5, 5);
	gbc_lblIngresarInstitucion.gridx = 1;
	gbc_lblIngresarInstitucion.gridy = 8;
	getContentPane().add(lblIngresarInstitucion, gbc_lblIngresarInstitucion);

	institucionComboBox = new JComboBox(instituciones);
	GridBagConstraints gbc_institucionComboBox = new GridBagConstraints();
	gbc_institucionComboBox.insets = new Insets(0, 0, 5, 5);
	gbc_institucionComboBox.fill = GridBagConstraints.HORIZONTAL;
	gbc_institucionComboBox.gridx = 3;
	gbc_institucionComboBox.gridy = 8;
	getContentPane().add(institucionComboBox, gbc_institucionComboBox);

	lblIngresarDescripcion = new JLabel("Ingresar Descripcion");
	GridBagConstraints gbc_lblIngresarDescripcion = new GridBagConstraints();
	gbc_lblIngresarDescripcion.anchor = GridBagConstraints.WEST;
	gbc_lblIngresarDescripcion.insets = new Insets(0, 0, 5, 5);
	gbc_lblIngresarDescripcion.gridx = 1;
	gbc_lblIngresarDescripcion.gridy = 9;
	getContentPane().add(lblIngresarDescripcion, gbc_lblIngresarDescripcion);

	descripcionField = new JTextField();
	GridBagConstraints gbc_descripcionField = new GridBagConstraints();
	gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
	gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
	gbc_descripcionField.gridx = 3;
	gbc_descripcionField.gridy = 9;
	getContentPane().add(descripcionField, gbc_descripcionField);
	descripcionField.setColumns(10);

	lblIngresarBiografia = new JLabel("Ingresar Biografia");
	GridBagConstraints gbc_lblIngresarBiografia = new GridBagConstraints();
	gbc_lblIngresarBiografia.anchor = GridBagConstraints.WEST;
	gbc_lblIngresarBiografia.insets = new Insets(0, 0, 5, 5);
	gbc_lblIngresarBiografia.gridx = 1;
	gbc_lblIngresarBiografia.gridy = 10;
	getContentPane().add(lblIngresarBiografia, gbc_lblIngresarBiografia);

	biografiaField = new JTextField();
	GridBagConstraints gbc_biografiaField = new GridBagConstraints();
	gbc_biografiaField.insets = new Insets(0, 0, 5, 5);
	gbc_biografiaField.fill = GridBagConstraints.HORIZONTAL;
	gbc_biografiaField.gridx = 3;
	gbc_biografiaField.gridy = 10;
	getContentPane().add(biografiaField, gbc_biografiaField);
	biografiaField.setColumns(10);

	lblIngresarUrlhttpsejej = new JLabel("Ingresar URL (https://ej.ej)");
	GridBagConstraints gbc_lblIngresarUrlhttpsejej = new GridBagConstraints();
	gbc_lblIngresarUrlhttpsejej.anchor = GridBagConstraints.WEST;
	gbc_lblIngresarUrlhttpsejej.insets = new Insets(0, 0, 5, 5);
	gbc_lblIngresarUrlhttpsejej.gridx = 1;
	gbc_lblIngresarUrlhttpsejej.gridy = 11;
	getContentPane().add(lblIngresarUrlhttpsejej, gbc_lblIngresarUrlhttpsejej);

	urlField = new JTextField();
	GridBagConstraints gbc_urlField = new GridBagConstraints();
	gbc_urlField.insets = new Insets(0, 0, 5, 5);
	gbc_urlField.fill = GridBagConstraints.HORIZONTAL;
	gbc_urlField.gridx = 3;
	gbc_urlField.gridy = 11;
	getContentPane().add(urlField, gbc_urlField);
	urlField.setColumns(10);

        aceptar = new JButton("Aceptar");
        GridBagConstraints gbc_aceptar = new GridBagConstraints();
        gbc_aceptar.insets = new Insets(0, 0, 5, 5);
        gbc_aceptar.gridx = 3;
        gbc_aceptar.gridy = 13;
        getContentPane().add(aceptar, gbc_aceptar);

        aceptar.addActionListener((ActionEvent a) -> {
           String nick = nicknameField.getText();
           String nombre = nombreField.getText();
           String apellido = apellidoField.getText();
           String email = emailField.getText();
           String password = passwordField.getText();
           String confirmPassword = confirmPasswordField.getText();
           LocalDate fecha = FechaUtil.toLocalDate(fechaField.getDate());
           String institucion = (String) institucionComboBox.getSelectedItem();
           String descripcion = descripcionField.getText();
           String biografia = biografiaField.getText();
           String url = urlField.getText();
        
           if (!password.equals(confirmPassword)){ //hago el control aca para no obligar al constructor a hacer el checkeo
            JOptionPane.showMessageDialog(this,
                    "Las contraseñas ingresadas son distintas.",
                    "error",
                    JOptionPane.ERROR_MESSAGE);
            confirmPasswordField.setText("");

            return;
            }
            if (institucion==null){JOptionPane.showMessageDialog(this,
                "Por favor seleccione una institucion.",
                "error",
                JOptionPane.ERROR_MESSAGE);
                

                return;
        }

	    try {
	        facades.getFacadeUsuario().crearProfesor()
                    .setNickname(nick)
                    .setPassword(password)
                    .setNombre(nombre)
                    .setApellido(apellido)
                    .setCorreo(Email.parse(email))
                    .setNacimiento(fecha)
                    .setInstitucion(institucion)
                    .setDescripcion(descripcion)
                    .setBiografia(biografia)
                    .setSitioWeb(new URL(url))
                    .invoke();
	    } catch (InstitucionNoEncontradaException e1) {
		e1.printStackTrace();
		return;
	    } catch (MalformedURLException e1) {
                JOptionPane.showMessageDialog(app, "URL no valida", "error", JOptionPane.ERROR_MESSAGE);
                return;
	    } catch (UsuarioRepetidoException e1) {
		JOptionPane.showMessageDialog(app, "Usuario ya existe", "error", JOptionPane.ERROR_MESSAGE);
                return;
	    } catch (EmailParseException e1) {
		JOptionPane.showMessageDialog(app, "Email invalido", "error", JOptionPane.ERROR_MESSAGE);
            	return;
	    }
        JOptionPane.showMessageDialog(app, "Profesor creado exitosamente.");
	    setVisible(false);
        });
    }
}
