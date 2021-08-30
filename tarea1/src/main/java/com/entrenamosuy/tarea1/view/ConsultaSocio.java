package com.entrenamosuy.tarea1.view;

import javax.swing.*;

import com.entrenamosuy.tarea1.data.DataUsuario;
import com.entrenamosuy.tarea1.data.DataSocio;

public class ConsultaSocio extends JInternalFrame {


    public ConsultaSocio(App app, IControladorUsuario CU, String nombre) {
        
		setTitle("Consulta Socio");
		getContentPane().setForeground(Color.RED);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{43, 209, 0, 49, 0, 9, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

        DataSocio data = CU.consultarSocio(nombre);
        String nickname = data.getNickname();
        String nombre = data.getNombre();
        String apellido = data.getApellido();
        Email correo = data.getCorreo();
        LocalDate nacimiento = data.getNacimiento();


		JLabel lblNewLabel = new JLabel("Ingresar Nickname");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
			
		
		JLabel lblIngresarNombre = new JLabel("Ingresar Nombre");
		GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
		gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarNombre.gridx = 1;
		gbc_lblIngresarNombre.gridy = 3;
		getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);
	
		
		JLabel lblIngresarApellido = new JLabel("Ingresar Apellido");
		GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
		gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarApellido.gridx = 1;
		gbc_lblIngresarApellido.gridy = 4;
		getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);
		
		JLabel lblIngresarEmail = new JLabel("Ingresar Email");
		GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
		gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarEmail.gridx = 1;
		gbc_lblIngresarEmail.gridy = 5;
		getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);
		
		
		lblIngresarFecha = new JLabel("Ingresar fecha");
		GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
		gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarFecha.gridx = 1;
		gbc_lblIngresarFecha.gridy = 6;
		getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);    
}
