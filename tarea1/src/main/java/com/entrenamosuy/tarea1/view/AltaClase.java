package com.entrenamosuy.tarea1.view;

import com.entrenamosuy.tarea1.logic.IControladorUsuario;
import com.entrenamosuy.tarea1.logic.Manejador;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ClaseRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.logic.ControladorActividadClase;
import com.entrenamosuy.tarea1.logic.IControladorActividadClase;
import com.entrenamosuy.tarea1.util.FuncionFecha;
import com.entrenamosuy.tarea1.util.Triple;
import com.toedter.calendar.JDateChooser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;

public class AltaClase extends JInternalFrame {
	private JTextField nombreField;
	private JTextField cantMin;
	private JTextField cantMax;
	private JTextField url;

    public AltaClase(String actividad, IControladorUsuario controladorUsuario, IControladorActividadClase controladorActividadClase, String institucion, App app) {
        
        final List<String> profesores = new ArrayList<>();
        Manejador maneja = Manejador.getInstance();
        for (Triple<String, String, String> profesor : controladorUsuario.obtenerDescProfesores()) {
            String nickname = profesor.getSecond();
            String nom = maneja.getProfesores().get(nickname).getInstitucion().getNombre();
            if (nom.equals(institucion))
                profesores.add(nickname);
        }
	
    	setClosable(true);
    	setResizable(true);
        setSize(573, 455);
        setTitle("Alta clase");
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        JLabel lblNombre = new JLabel("Nombre");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.anchor = GridBagConstraints.WEST;
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 1;
        getContentPane().add(lblNombre, gbc_lblNombre);
        
        nombreField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 3;
        gbc_textField.gridy = 1;
        getContentPane().add(nombreField, gbc_textField);
        nombreField.setColumns(10);
        
        JLabel lblInicio = new JLabel("Inicio");
        GridBagConstraints gbc_lblInicio = new GridBagConstraints();
        gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
        gbc_lblInicio.anchor = GridBagConstraints.WEST;
        gbc_lblInicio.gridx = 1;
        gbc_lblInicio.gridy = 3;
        getContentPane().add(lblInicio, gbc_lblInicio);
        
        JDateChooser calendario = new JDateChooser();
        GridBagConstraints gbc_lblFechaAlta = new GridBagConstraints();
        gbc_lblFechaAlta.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblFechaAlta.insets = new Insets(0, 0, 5, 5);
        gbc_lblFechaAlta.gridx = 3;
        gbc_lblFechaAlta.gridy = 3;
        getContentPane().add(calendario, gbc_lblFechaAlta);
        
        JLabel lblProfesores = new JLabel("Profesores");
        GridBagConstraints gbc_lblProfesores = new GridBagConstraints();
        gbc_lblProfesores.insets = new Insets(0, 0, 5, 5);
        gbc_lblProfesores.anchor = GridBagConstraints.WEST;
        gbc_lblProfesores.gridx = 1;
        gbc_lblProfesores.gridy = 5;
        getContentPane().add(lblProfesores, gbc_lblProfesores);

        JLabel lblCantidadMinimaSocios = new JLabel("Cantidad minima socios");
        GridBagConstraints gbc_lblCantidadMinimaSocios = new GridBagConstraints();
        gbc_lblCantidadMinimaSocios.anchor = GridBagConstraints.WEST;
        gbc_lblCantidadMinimaSocios.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantidadMinimaSocios.gridx = 1;
        gbc_lblCantidadMinimaSocios.gridy = 7;
        getContentPane().add(lblCantidadMinimaSocios, gbc_lblCantidadMinimaSocios);
        
        cantMin = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 3;
        gbc_textField_1.gridy = 7;
        getContentPane().add(cantMin, gbc_textField_1);
        cantMin.setColumns(10);
        
        JLabel lblCantidadMaximaSocios = new JLabel("Cantidad maxima socios");
        GridBagConstraints gbc_lblCantidadMaximaSocios = new GridBagConstraints();
        gbc_lblCantidadMaximaSocios.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantidadMaximaSocios.anchor = GridBagConstraints.WEST;
        gbc_lblCantidadMaximaSocios.gridx = 1;
        gbc_lblCantidadMaximaSocios.gridy = 9;
        getContentPane().add(lblCantidadMaximaSocios, gbc_lblCantidadMaximaSocios);
        
        cantMax = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 3;
        gbc_textField_2.gridy = 9;
        getContentPane().add(cantMax, gbc_textField_2);
        cantMax.setColumns(10);
        
        JLabel lblUrl = new JLabel("URL");
        GridBagConstraints gbc_lblUrl = new GridBagConstraints();
        gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
        gbc_lblUrl.anchor = GridBagConstraints.WEST;
        gbc_lblUrl.gridx = 1;
        gbc_lblUrl.gridy = 11;
        getContentPane().add(lblUrl, gbc_lblUrl);
        
        url = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 3;
        gbc_textField_3.gridy = 11;
        getContentPane().add(url, gbc_textField_3);
        url.setColumns(10);
        
        JButton btnAceptar = new JButton("Aceptar");
        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
        gbc_btnAceptar.gridx = 3;
        gbc_btnAceptar.gridy = 13;
        getContentPane().add(btnAceptar, gbc_btnAceptar);

        JList<String> list = new JList<>(profesores.toArray(new String[] {}));
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
        	    selectedNicknames.add(profesores.get(selected[i]));
        	
        	System.out.println(selectedNicknames);
            }
        });
        
        btnAceptar.addActionListener((ActionEvent a) -> {
            System.out.println(nombreField.getText());
            try {
		controladorActividadClase.crearClase(actividad, 
		    nombreField.getText(), 
		    LocalDateTime.of(FuncionFecha.convertToLocalDateViaInstant(calendario.getDate()), LocalTime.of(0,  0)),
		    selectedNicknames,
		    Integer.parseInt(cantMin.getText()),
		    Integer.parseInt(cantMax.getText()),
		    new URL(url.getText()),
		    LocalDate.now());
	    } catch (ProfesorNoEncontradoException | NumberFormatException | ActividadNoEncontradaException
		  | ClaseRepetidaException e1) {
		e1.printStackTrace();
	    }
        catch(MalformedURLException e5){
            JOptionPane.showMessageDialog(app,"El link ingresado no es correcto.","error", JOptionPane.ERROR_MESSAGE);
            url.setText("");
            return;
        }
            for (String s : maneja.getClases().keySet())
            System.out.println(s);
            dispose();
        });
    }
}
