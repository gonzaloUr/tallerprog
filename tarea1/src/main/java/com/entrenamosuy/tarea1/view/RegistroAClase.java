package com.entrenamosuy.tarea1.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entrenamosuy.tarea1.exceptions.ClaseLlenaException;
import com.entrenamosuy.tarea1.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ClaseRegistroInvalidoException;
import com.entrenamosuy.tarea1.exceptions.CuponeraInvalidaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraLlenaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoCompradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.logic.IControladorActividadClase;
import com.entrenamosuy.tarea1.util.FechaUtil;
import com.entrenamosuy.tarea1.util.Pair;
import com.toedter.calendar.JDateChooser;


public class RegistroAClase extends JInternalFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    public RegistroAClase(String actividad, String clase, String socio, Set<Pair<String, String>> cuponeras, IControladorActividadClase controladorActividadClase, App app) {

	final List<String> cuponerasLista = new ArrayList<>();
	for (Pair<String, String> cuponera : cuponeras) {
		String nombre = cuponera.getFirst();
		cuponerasLista.add(nombre);
	}

	setTitle("Registro a dictado de clase.");
	setClosable(true);
	setResizable(true);
	getContentPane().setForeground(Color.RED);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
	gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	getContentPane().setLayout(gridBagLayout);

	JLabel lblSeleccionarCuponera = new JLabel("Seleccionar Cuponera");
	GridBagConstraints gbc_lblSeleccionarCuponera = new GridBagConstraints();
	gbc_lblSeleccionarCuponera.insets = new Insets(0, 0, 5, 5);
	gbc_lblSeleccionarCuponera.gridx = 1;
	gbc_lblSeleccionarCuponera.gridy = 1;
	getContentPane().add(lblSeleccionarCuponera, gbc_lblSeleccionarCuponera);

	JComboBox<String> cuponerasComboBox = new JComboBox<>(cuponerasLista.toArray(new String[0]));
	GridBagConstraints gbc_cuponerasComboBox = new GridBagConstraints();
	gbc_cuponerasComboBox.insets = new Insets(0, 0, 5, 5);
	gbc_cuponerasComboBox.fill = GridBagConstraints.HORIZONTAL;
	gbc_cuponerasComboBox.gridx = 3;
	gbc_cuponerasComboBox.gridy = 1;
	getContentPane().add(cuponerasComboBox, gbc_cuponerasComboBox);

	JCheckBox utilizarCheckBox = new JCheckBox("Utilizar cuponera");
	GridBagConstraints gbc_utilizarCheckBox = new GridBagConstraints();
	gbc_utilizarCheckBox.insets = new Insets(0, 0, 5, 5);
	gbc_utilizarCheckBox.gridx = 3;
	gbc_utilizarCheckBox.gridy = 3;
	getContentPane().add(utilizarCheckBox, gbc_utilizarCheckBox);

	JLabel lblIngresarApellido = new JLabel("Ingresar fecha");
	GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
	gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
	gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
	gbc_lblIngresarApellido.gridx = 1;
	gbc_lblIngresarApellido.gridy = 5;
	getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

	JDateChooser calendario = new JDateChooser();
	GridBagConstraints gbc_calendario = new GridBagConstraints();
	gbc_calendario.fill = GridBagConstraints.HORIZONTAL;
	gbc_calendario.insets = new Insets(0, 0, 5, 9);
	gbc_calendario.gridx = 3;
	gbc_calendario.gridy = 5;
	getContentPane().add(calendario, gbc_calendario);

	JButton aceptar = new JButton("Aceptar");
	GridBagConstraints gbc_aceptar = new GridBagConstraints();
	gbc_aceptar.insets = new Insets(0, 0, 5, 5);
	gbc_aceptar.gridx = 3;
	gbc_aceptar.gridy = 7;
	getContentPane().add(aceptar, gbc_aceptar);
	setBounds(100, 100, 555, 360);

	aceptar.addActionListener((ActionEvent a) -> {
	    String cuponeraSelecionada = (String) cuponerasComboBox.getSelectedItem();
	    LocalDate fecha = FechaUtil.toLocalDateTime(calendario.getDate());

	    if (utilizarCheckBox.isSelected() && cuponeraSelecionada != "") {
		try {
		    controladorActividadClase.registraseConCuponera(socio, clase, cuponeraSelecionada, fecha);
		} catch (SocioNoEncontradoException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (ClaseNoEncontradaException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (CuponeraNoEncontradaException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (CuponeraNoCompradaException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (CuponeraInvalidaException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (CuponeraLlenaException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (ClaseLlenaException e){
			JOptionPane.showMessageDialog(app,"No hay lugares disponibles en esa clase.","error", JOptionPane.ERROR_MESSAGE);
            return;
		} catch (ClaseRegistroInvalidoException e){
			JOptionPane.showMessageDialog(app,"Fecha de registro inválida.","error", JOptionPane.ERROR_MESSAGE);
            return;
		}
	    } else {
		try {
		    controladorActividadClase.registarseSinCuponera(socio, clase, fecha);
		} catch (SocioNoEncontradoException | ClaseNoEncontradaException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch(ClaseLlenaException e){
			JOptionPane.showMessageDialog(app,"No hay lugares disponibles en esa clase.","error", JOptionPane.ERROR_MESSAGE);
            return;
		} catch(ClaseRegistroInvalidoException e){
			JOptionPane.showMessageDialog(app,"Fecha de registro inválida.","error", JOptionPane.ERROR_MESSAGE);
            return;
		}
	    }
	    setVisible(false);
	    JOptionPane.showMessageDialog(app, "Registro creado exitosamente.");
	});
    }
}
