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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.entrenamosuy.tarea1.exceptions.CuponeraInicioFinInvalidoException;
import com.entrenamosuy.tarea1.exceptions.CuponeraInicioRegistroInvalidoException;
import com.entrenamosuy.tarea1.exceptions.CuponeraRepetidaException;
import com.entrenamosuy.tarea1.logic.IControladorCuponera;
import com.entrenamosuy.tarea1.util.FechaUtil;
import com.toedter.calendar.JDateChooser;

public class CrearCuponera extends JInternalFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField nombreField;
    private JTextField descField;
    private JLabel lblIngresarFecha;
    private JLabel lblNewLabel_1;
    private JButton aceptar;
    private JSpinner descuento;
    private JLabel lblIngresarFin;
    private JDateChooser calendarioFin;

    public CrearCuponera(IControladorCuponera controladorCuponera, App app) {
    	setMaximizable(true);
    	setResizable(true);
    	setClosable(true);
        setTitle("Crear Cuponera");
        getContentPane().setForeground(Color.RED);
        setBounds(100, 100, 660, 525);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{34, 0, 0, 49, 0, 9, 0};
        gridBagLayout.rowHeights = new int[]{38, 0, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Ingresar Nombre");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        nombreField = new JTextField();
        GridBagConstraints gbc_nombreField = new GridBagConstraints();
        gbc_nombreField.gridwidth = 2;
        gbc_nombreField.insets = new Insets(0, 0, 5, 5);
        gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreField.gridx = 3;
        gbc_nombreField.gridy = 1;
        getContentPane().add(nombreField, gbc_nombreField);
        nombreField.setColumns(10);

        JLabel lblIngresarNombre = new JLabel("Ingresar Descripcion");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 3;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);

        descField = new JTextField();
        GridBagConstraints gbc_descField = new GridBagConstraints();
        gbc_descField.gridwidth = 2;
        gbc_descField.insets = new Insets(0, 0, 5, 5);
        gbc_descField.fill = GridBagConstraints.HORIZONTAL;
        gbc_descField.gridx = 3;
        gbc_descField.gridy = 3;
        getContentPane().add(descField, gbc_descField);
        descField.setColumns(10);

        JLabel lblIngresarApellido = new JLabel("Ingresar Descuento");
        GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
        gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarApellido.gridx = 1;
        gbc_lblIngresarApellido.gridy = 5;
        getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
        descuento = new JSpinner(model);
        descuento.setToolTipText("");
        GridBagConstraints gbc_descuento = new GridBagConstraints();
        gbc_descuento.gridwidth = 2;
        gbc_descuento.fill = GridBagConstraints.HORIZONTAL;
        gbc_descuento.insets = new Insets(0, 0, 5, 5);
        gbc_descuento.gridx = 3;
        gbc_descuento.gridy = 5;
        getContentPane().add(descuento, gbc_descuento);

        lblIngresarFecha = new JLabel("Ingresar inicio");
        GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
        gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarFecha.gridx = 1;
        gbc_lblIngresarFecha.gridy = 7;
        getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);

        JDateChooser calendario = new JDateChooser();
        GridBagConstraints gbc_calendario = new GridBagConstraints();
        gbc_calendario.fill = GridBagConstraints.HORIZONTAL;
        gbc_calendario.gridwidth = 2;
        gbc_calendario.insets = new Insets(0, 0, 5, 5);
        gbc_calendario.gridx = 3;
        gbc_calendario.gridy = 7;
        getContentPane().add(calendario, gbc_calendario);

	lblIngresarFin = new JLabel("Ingresar fin");
	GridBagConstraints gbc_lblIngresarFin = new GridBagConstraints();
	gbc_lblIngresarFin.anchor = GridBagConstraints.WEST;
	gbc_lblIngresarFin.insets = new Insets(0, 0, 5, 5);
	gbc_lblIngresarFin.gridx = 1;
	gbc_lblIngresarFin.gridy = 9;
	getContentPane().add(lblIngresarFin, gbc_lblIngresarFin);

	calendarioFin = new JDateChooser();
	GridBagConstraints gbc_calendarioFin = new GridBagConstraints();
	gbc_calendarioFin.gridwidth = 2;
	gbc_calendarioFin.insets = new Insets(0, 0, 5, 5);
	gbc_calendarioFin.fill = GridBagConstraints.BOTH;
	gbc_calendarioFin.gridx = 3;
	gbc_calendarioFin.gridy = 9;
	getContentPane().add(calendarioFin, gbc_calendarioFin);

	aceptar = new JButton("Aceptar");
	GridBagConstraints gbc_aceptar = new GridBagConstraints();
	gbc_aceptar.insets = new Insets(0, 0, 5, 5);
	gbc_aceptar.gridx = 3;
	gbc_aceptar.gridy = 11;
	getContentPane().add(aceptar, gbc_aceptar);

        aceptar.addActionListener((ActionEvent a) -> {
            try {
		controladorCuponera.crearCuponera(nombreField.getText(), descField.getText(), 
		    FechaUtil.toLocalDate(calendario.getDate()),
		    FechaUtil.toLocalDate(calendarioFin.getDate()),
		    (Integer) descuento.getValue(), LocalDate.now());
	    } catch (CuponeraRepetidaException e1) {
		e1.printStackTrace();
		return;
	    } catch (CuponeraInicioFinInvalidoException e2) {
		JOptionPane.showMessageDialog(app, "Fecha de inicio/fin invalidas", "error", JOptionPane.ERROR_MESSAGE);
		return;
	    } catch (CuponeraInicioRegistroInvalidoException e3) {
		JOptionPane.showMessageDialog(app, "Fecha de inicio/registro invalidas", "error", JOptionPane.ERROR_MESSAGE);
		return;
	    }
            
            JOptionPane.showMessageDialog(app, "Cuponera creada exitosamente.");
            setVisible(false);
        });
    }
}
