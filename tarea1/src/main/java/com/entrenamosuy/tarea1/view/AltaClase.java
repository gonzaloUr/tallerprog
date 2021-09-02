package com.entrenamosuy.tarea1.view;

import java.awt.GridBagConstraints;


import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;

import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ClaseCantInvalidoException;
import com.entrenamosuy.tarea1.exceptions.ClaseInicioRegistroInvalidoException;
import com.entrenamosuy.tarea1.exceptions.ClaseRegistroActividadInvalidaException;
import com.entrenamosuy.tarea1.exceptions.ClaseRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.logic.IControladorActividadClase;
import com.entrenamosuy.tarea1.logic.IControladorUsuario;
import com.entrenamosuy.tarea1.logic.Manejador;
import com.entrenamosuy.tarea1.util.FechaUtil;
import com.entrenamosuy.tarea1.util.Triple;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class AltaClase extends JInternalFrame {
    private JTextField nombreField;
    private JTextField cantMin;
    private JTextField cantMax;
    private JTextField url;

    public AltaClase(String actividad, IControladorUsuario controladorUsuario, IControladorActividadClase controladorActividadClase, String institucion, App app) {
        
        final String[] profesores = controladorUsuario.obtenerDescProfesores()
        	.stream()
        	.map(Triple::getSecond)
        	.toArray(String[]::new);
	
    	setClosable(true);
    	setResizable(true);
        setSize(573, 455);
        setTitle("Alta clase");
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        JLabel lblNombre = new JLabel("Nombre");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.anchor = GridBagConstraints.WEST;
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 0;
        getContentPane().add(lblNombre, gbc_lblNombre);
        
        nombreField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 3;
        gbc_textField.gridy = 0;
        getContentPane().add(nombreField, gbc_textField);
        nombreField.setColumns(10);
        
        JLabel lblInicio = new JLabel("Inicio");
        GridBagConstraints gbc_lblInicio = new GridBagConstraints();
        gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
        gbc_lblInicio.anchor = GridBagConstraints.WEST;
        gbc_lblInicio.gridx = 1;
        gbc_lblInicio.gridy = 1;
        getContentPane().add(lblInicio, gbc_lblInicio);
        
        JDateChooser calendario = new JDateChooser();
        GridBagConstraints gbc_lblFechaAlta = new GridBagConstraints();
        gbc_lblFechaAlta.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblFechaAlta.insets = new Insets(0, 0, 5, 5);
        gbc_lblFechaAlta.gridx = 3;
        gbc_lblFechaAlta.gridy = 1;
        getContentPane().add(calendario, gbc_lblFechaAlta);
        
        JLabel lblHora = new JLabel("Hora");
        GridBagConstraints gbc_lblHora = new GridBagConstraints();
        gbc_lblHora.anchor = GridBagConstraints.WEST;
        gbc_lblHora.insets = new Insets(0, 0, 5, 5);
        gbc_lblHora.gridx = 1;
        gbc_lblHora.gridy = 2;
        getContentPane().add(lblHora, gbc_lblHora);
        
        SpinnerNumberModel modelh = new SpinnerNumberModel(00, 00, 23, 1);
        JSpinner hora = new JSpinner(modelh);
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.insets = new Insets(0, 0, 5, 5);
        gbc_spinner.gridx = 3;
        gbc_spinner.gridy = 2;
        getContentPane().add(hora, gbc_spinner);
        
        JLabel lblMinuto = new JLabel("Minuto");
        GridBagConstraints gbc_lblMinuto = new GridBagConstraints();
        gbc_lblMinuto.anchor = GridBagConstraints.WEST;
        gbc_lblMinuto.insets = new Insets(0, 0, 5, 5);
        gbc_lblMinuto.gridx = 1;
        gbc_lblMinuto.gridy = 3;
        getContentPane().add(lblMinuto, gbc_lblMinuto);
        
        SpinnerNumberModel modelm = new SpinnerNumberModel(00, 00, 59, 1);
        JSpinner minuto = new JSpinner(modelm);
        GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
        gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
        gbc_spinner_1.gridx = 3;
        gbc_spinner_1.gridy = 3;
        getContentPane().add(minuto, gbc_spinner_1);
        
        JLabel lblProfesores = new JLabel("Profesores");
        GridBagConstraints gbc_lblProfesores = new GridBagConstraints();
        gbc_lblProfesores.insets = new Insets(0, 0, 5, 5);
        gbc_lblProfesores.anchor = GridBagConstraints.WEST;
        gbc_lblProfesores.gridx = 1;
        gbc_lblProfesores.gridy = 4;
        getContentPane().add(lblProfesores, gbc_lblProfesores);

        
        JLabel lblRegistro = new JLabel("Registro");
        GridBagConstraints gbc_lblRegistro = new GridBagConstraints();
        gbc_lblRegistro.anchor = GridBagConstraints.WEST;
        gbc_lblRegistro.insets = new Insets(0, 0, 5, 5);
        gbc_lblRegistro.gridx = 1;
        gbc_lblRegistro.gridy = 6;
        getContentPane().add(lblRegistro, gbc_lblRegistro);
        
        JDateChooser calendario2 = new JDateChooser();
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 3;
        gbc_lblNewLabel.gridy = 6;
        getContentPane().add(calendario2, gbc_lblNewLabel);

        JLabel lblCantidadMinimaSocios = new JLabel("Cantidad minima socios");
        GridBagConstraints gbc_lblCantidadMinimaSocios = new GridBagConstraints();
        gbc_lblCantidadMinimaSocios.anchor = GridBagConstraints.WEST;
        gbc_lblCantidadMinimaSocios.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantidadMinimaSocios.gridx = 1;
        gbc_lblCantidadMinimaSocios.gridy = 8;
        getContentPane().add(lblCantidadMinimaSocios, gbc_lblCantidadMinimaSocios);
        
        cantMin = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 3;
        gbc_textField_1.gridy = 8;
        getContentPane().add(cantMin, gbc_textField_1);
        cantMin.setColumns(10);
        
        JLabel lblCantidadMaximaSocios = new JLabel("Cantidad maxima socios");
        GridBagConstraints gbc_lblCantidadMaximaSocios = new GridBagConstraints();
        gbc_lblCantidadMaximaSocios.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantidadMaximaSocios.anchor = GridBagConstraints.WEST;
        gbc_lblCantidadMaximaSocios.gridx = 1;
        gbc_lblCantidadMaximaSocios.gridy = 10;
        getContentPane().add(lblCantidadMaximaSocios, gbc_lblCantidadMaximaSocios);
        
        cantMax = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 3;
        gbc_textField_2.gridy = 10;
        getContentPane().add(cantMax, gbc_textField_2);
        cantMax.setColumns(10);
        
        JLabel lblUrl = new JLabel("URL");
        GridBagConstraints gbc_lblUrl = new GridBagConstraints();
        gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
        gbc_lblUrl.anchor = GridBagConstraints.WEST;
        gbc_lblUrl.gridx = 1;
        gbc_lblUrl.gridy = 12;
        getContentPane().add(lblUrl, gbc_lblUrl);
        
        url = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 3;
        gbc_textField_3.gridy = 12;
        getContentPane().add(url, gbc_textField_3);
        url.setColumns(10);
        
        JButton btnAceptar = new JButton("Aceptar");
        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
        gbc_btnAceptar.gridx = 3;
        gbc_btnAceptar.gridy = 14;
        getContentPane().add(btnAceptar, gbc_btnAceptar);

        JList list = new JList(profesores);
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.insets = new Insets(0, 0, 5, 5);
        gbc_list.fill = GridBagConstraints.BOTH;
        gbc_list.gridx = 3;
        gbc_list.gridy = 5;
        getContentPane().add(list, gbc_list);
        
        Set<String> selectedNicknames = new HashSet<>();
        
        list.addListSelectionListener((ListSelectionEvent e) -> {
            if (e.getValueIsAdjusting() == false) {
        	int[] selected = list.getSelectedIndices();
        	selectedNicknames.clear();
        	
        	for (int i = 0; i < selected.length; i++)
        	    selectedNicknames.add(profesores[selected[i]]);
            }
        });

        btnAceptar.addActionListener((ActionEvent a) -> {
            try {
                controladorActividadClase.crearClase(actividad, 
                	nombreField.getText(),
                	LocalDateTime.of(FechaUtil.toLocalDate(
                		calendario.getDate()), 
                		LocalTime.of((int) hora.getValue(), (int) minuto.getValue())),
                	selectedNicknames,
                	Integer.parseInt(cantMin.getText()),
                	Integer.parseInt(cantMax.getText()),
                	new URL(url.getText()),
                	FechaUtil.toLocalDate(calendario2.getDate()));
                
                JOptionPane.showMessageDialog(app, "Clase creada exitosamente.");
            }
            catch(ActividadNoEncontradaException ex) {
        	ex.printStackTrace();
        	return;
            }
            catch(ProfesorNoEncontradoException ec) {
        	ec.printStackTrace();
        	return;
            }
            catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(app,"Por favor ingrese un numero.","error", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
                return;
            }
            catch(ClaseRepetidaException e2) {
                JOptionPane.showMessageDialog(app,"Nombre no disponible","error", JOptionPane.ERROR_MESSAGE);
                nombreField.setText("");
                return;
            }
            catch(MalformedURLException e5){
                JOptionPane.showMessageDialog(app,
                	"El link ingresado no es correcto.",
                	"error", JOptionPane.ERROR_MESSAGE);
                url.setText("");
                return;
            }
            catch(ClaseInicioRegistroInvalidoException e6){
                JOptionPane.showMessageDialog(app,
                	"La fecha de inicio debe ser posterior a la de registro.","error", 
                	JOptionPane.ERROR_MESSAGE);
                return;
            }
            catch(ClaseCantInvalidoException e7){
                JOptionPane.showMessageDialog(app,
                	"La cantidad minima de socios debe ser menor a la cantidad maxima.","error", 
                	JOptionPane.ERROR_MESSAGE);
                
                cantMin.setText("");
                cantMax.setText("");
                return;
            }
            catch (ClaseRegistroActividadInvalidaException e8){
                JOptionPane.showMessageDialog(app, 
                	"La fecha de registro de la clase debe ser posterior a la de registro de la actividad.",
                	"error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            dispose();
        });
    }
}
