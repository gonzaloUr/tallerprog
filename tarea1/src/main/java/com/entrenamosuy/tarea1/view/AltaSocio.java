package com.entrenamosuy.tarea1.view;

import java.awt.EventQueue;

import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.logic.IControladorUsuario;
import com.entrenamosuy.tarea1.util.FuncionFecha;
import com.toedter.calendar.JDateChooser;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AltaSocio extends JInternalFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JLabel lblIngresarFecha;
    private JLabel lblNewLabel_1;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AltaSocio frame = new AltaSocio(null, null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AltaSocio(App app, IControladorUsuario CU) {
    	setResizable(true);
    	setMaximizable(true);
    	setClosable(true);
        setTitle("Alta Socio");
        getContentPane().setForeground(Color.RED);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{76, 0, 0, 0, 0, 49, 0, 9, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Ingresar Nickname");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        textField_4 = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.gridwidth = 2;
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 5;
        gbc_textField_4.gridy = 1;
        getContentPane().add(textField_4, gbc_textField_4);
        textField_4.setColumns(10);

        JLabel lblIngresarNombre = new JLabel("Ingresar Nombre");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 3;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);

        textField_5 = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.gridwidth = 2;
        gbc_textField_5.insets = new Insets(0, 0, 5, 5);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 5;
        gbc_textField_5.gridy = 3;
        getContentPane().add(textField_5, gbc_textField_5);
        textField_5.setColumns(10);

        JLabel lblIngresarApellido = new JLabel("Ingresar Apellido");
        GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
        gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarApellido.gridx = 1;
        gbc_lblIngresarApellido.gridy = 5;
        getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

        textField_6 = new JTextField();
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.gridwidth = 2;
        gbc_textField_6.insets = new Insets(0, 0, 5, 5);
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.gridx = 5;
        gbc_textField_6.gridy = 5;
        getContentPane().add(textField_6, gbc_textField_6);
        textField_6.setColumns(10);

        JLabel lblIngresarEmail = new JLabel("Ingresar Email");
        GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
        gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarEmail.gridx = 1;
        gbc_lblIngresarEmail.gridy = 7;
        getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);

        textField_7 = new JTextField();
        GridBagConstraints gbc_textField_7 = new GridBagConstraints();
        gbc_textField_7.gridwidth = 2;
        gbc_textField_7.insets = new Insets(0, 0, 5, 5);
        gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_7.gridx = 5;
        gbc_textField_7.gridy = 7;
        getContentPane().add(textField_7, gbc_textField_7);
        textField_7.setColumns(10);

        lblIngresarFecha = new JLabel("Ingresar fecha");
        GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
        gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarFecha.gridx = 1;
        gbc_lblIngresarFecha.gridy = 9;
        getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);

        JDateChooser chooser = new JDateChooser();
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_1.gridwidth = 2;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 5;
        gbc_lblNewLabel_1.gridy = 9;
        getContentPane().add(chooser, gbc_lblNewLabel_1);

        btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nick = textField_4.getText();
                String nombre = textField_5.getText();
                String apellido = textField_6.getText();
                Email mail; 
                try {
                mail = Email.parse(textField_7.getText());
                } catch(Exception ep) {
                	JOptionPane.showMessageDialog(app, "Email invalido", "error", JOptionPane.ERROR_MESSAGE);
                    textField_7.setText("");
                	return;
                }
                Date fechaf = (Date) chooser.getDate();
                FuncionFecha f = new FuncionFecha();
                LocalDate fecha = f.convertToLocalDateViaInstant(fechaf);
                setVisible(false);
                try {
                    CU.crearSocio(nick, nombre, apellido, mail, fecha);
                } catch (UsuarioRepetidoException rep) {
                    textField_4.setText("");
                    textField_5.setText("");
                    textField_6.setText("");
                    textField_7.setText("");
                    chooser.setDate(null);
                    setVisible(true);
                    JOptionPane.showMessageDialog(app, "Usuario ya existe", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                textField_4.setText("");
                textField_5.setText("");
                textField_6.setText("");
                textField_7.setText("");
                chooser.setDate(null);
                JOptionPane.showMessageDialog(app, "Socio creado exitosamente.");
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.WEST;
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 11;
        getContentPane().add(btnNewButton, gbc_btnNewButton);
        setBounds(100, 100, 555, 360);
    }
}
