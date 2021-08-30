package com.entrenamosuy.tarea1.view;

import java.awt.EventQueue;

import com.toedter.calendar.JDateChooser;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.logic.IControladorUsuario;
import com.entrenamosuy.tarea1.logic.Manejador;
import com.entrenamosuy.tarea1.util.FuncionFecha;
import com.entrenamosuy.tarea1.logic.Institucion;

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
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AltaProfesor extends JInternalFrame {
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
    private JButton btnNewButton_1;
    private JLabel lblIngresarInstitucion;
    private JTextField textField_8;
    private JLabel lblIngresarDescripcion;
    private JTextField textField_9;
    private JLabel lblIngresarBiografia;
    private JTextField textField_10;
    private JLabel lblIngresarUrlhttpsejej;
    private JTextField textField_11;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame h = new JFrame();
                    h.setVisible(true);
                    AltaProfesor frame = new AltaProfesor(null, null);
                    frame.setVisible(true);
                    h.getContentPane().add(frame);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AltaProfesor(App app, IControladorUsuario CU) {
        setTitle("Alta Profesor");
        getContentPane().setForeground(Color.RED);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{43, 209, 0, 49, 0, 9, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Ingresar Nickname");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 2;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        textField_4 = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.gridwidth = 2;
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 3;
        gbc_textField_4.gridy = 2;
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
        gbc_textField_5.gridx = 3;
        gbc_textField_5.gridy = 3;
        getContentPane().add(textField_5, gbc_textField_5);
        textField_5.setColumns(10);

        JLabel lblIngresarApellido = new JLabel("Ingresar Apellido");
        GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
        gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarApellido.gridx = 1;
        gbc_lblIngresarApellido.gridy = 4;
        getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

        textField_6 = new JTextField();
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.gridwidth = 2;
        gbc_textField_6.insets = new Insets(0, 0, 5, 5);
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.gridx = 3;
        gbc_textField_6.gridy = 4;
        getContentPane().add(textField_6, gbc_textField_6);
        textField_6.setColumns(10);

        JLabel lblIngresarEmail = new JLabel("Ingresar Email");
        GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
        gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarEmail.gridx = 1;
        gbc_lblIngresarEmail.gridy = 5;
        getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);

        textField_7 = new JTextField();
        GridBagConstraints gbc_textField_7 = new GridBagConstraints();
        gbc_textField_7.gridwidth = 2;
        gbc_textField_7.insets = new Insets(0, 0, 5, 5);
        gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_7.gridx = 3;
        gbc_textField_7.gridy = 5;
        getContentPane().add(textField_7, gbc_textField_7);
        textField_7.setColumns(10);

        lblIngresarFecha = new JLabel("Ingresar fecha");
        GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
        gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarFecha.gridx = 1;
        gbc_lblIngresarFecha.gridy = 6;
        getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);

        JDateChooser chooser = new JDateChooser();
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_1.gridwidth = 2;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 5;
        gbc_lblNewLabel_1.gridy = 9;
        getContentPane().add(chooser, gbc_lblNewLabel_1);

        lblIngresarInstitucion = new JLabel("Ingresar Institucion");
        GridBagConstraints gbc_lblIngresarInstitucion = new GridBagConstraints();
        gbc_lblIngresarInstitucion.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarInstitucion.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarInstitucion.gridx = 1;
        gbc_lblIngresarInstitucion.gridy = 8;
        getContentPane().add(lblIngresarInstitucion, gbc_lblIngresarInstitucion);

        textField_8 = new JTextField();
        GridBagConstraints gbc_textField_8 = new GridBagConstraints();
        gbc_textField_8.gridwidth = 2;
        gbc_textField_8.insets = new Insets(0, 0, 5, 5);
        gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_8.gridx = 3;
        gbc_textField_8.gridy = 8;
        getContentPane().add(textField_8, gbc_textField_8);
        textField_8.setColumns(10);

        lblIngresarDescripcion = new JLabel("Ingresar Descripcion");
        GridBagConstraints gbc_lblIngresarDescripcion = new GridBagConstraints();
        gbc_lblIngresarDescripcion.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarDescripcion.gridx = 1;
        gbc_lblIngresarDescripcion.gridy = 9;
        getContentPane().add(lblIngresarDescripcion, gbc_lblIngresarDescripcion);

        textField_9 = new JTextField();
        GridBagConstraints gbc_textField_9 = new GridBagConstraints();
        gbc_textField_9.gridwidth = 2;
        gbc_textField_9.insets = new Insets(0, 0, 5, 5);
        gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_9.gridx = 3;
        gbc_textField_9.gridy = 9;
        getContentPane().add(textField_9, gbc_textField_9);
        textField_9.setColumns(10);

        lblIngresarBiografia = new JLabel("Ingresar Biografia");
        GridBagConstraints gbc_lblIngresarBiografia = new GridBagConstraints();
        gbc_lblIngresarBiografia.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarBiografia.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarBiografia.gridx = 1;
        gbc_lblIngresarBiografia.gridy = 10;
        getContentPane().add(lblIngresarBiografia, gbc_lblIngresarBiografia);

        textField_10 = new JTextField();
        GridBagConstraints gbc_textField_10 = new GridBagConstraints();
        gbc_textField_10.gridwidth = 2;
        gbc_textField_10.insets = new Insets(0, 0, 5, 5);
        gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_10.gridx = 3;
        gbc_textField_10.gridy = 10;
        getContentPane().add(textField_10, gbc_textField_10);
        textField_10.setColumns(10);

        lblIngresarUrlhttpsejej = new JLabel("Ingresar URL (https://ej.ej)");
        GridBagConstraints gbc_lblIngresarUrlhttpsejej = new GridBagConstraints();
        gbc_lblIngresarUrlhttpsejej.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarUrlhttpsejej.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarUrlhttpsejej.gridx = 1;
        gbc_lblIngresarUrlhttpsejej.gridy = 11;
        getContentPane().add(lblIngresarUrlhttpsejej, gbc_lblIngresarUrlhttpsejej);

        textField_11 = new JTextField();
        GridBagConstraints gbc_textField_11 = new GridBagConstraints();
        gbc_textField_11.gridwidth = 2;
        gbc_textField_11.insets = new Insets(0, 0, 5, 5);
        gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_11.gridx = 3;
        gbc_textField_11.gridy = 11;
        getContentPane().add(textField_11, gbc_textField_11);
        textField_11.setColumns(10);

        btnNewButton_1 = new JButton("Cancelar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                textField_4.setText("");
                textField_5.setText("");
                textField_6.setText("");
                textField_7.setText("");
                chooser.setDate(null);
                textField_8.setText("");
                textField_9.setText("");
                textField_10.setText("");
                textField_11.setText("");
            }
        });


        btnNewButton = new JButton("Aceptar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nick = textField_4.getText();
                String nombre = textField_5.getText();
                String apellido = textField_6.getText();
                Email mail = Email.parse(textField_7.getText());
                Date fechaf = (Date) chooser.getDate();
                FuncionFecha f = new FuncionFecha();
                LocalDate fecha = f.convertToLocalDateViaInstant(fechaf);
                String institucion = textField_8.getText();
                String descripcion = textField_9.getText();
                String biografia = textField_10.getText();
                URL link = null;
                try {
                    link = new URL(textField_11.getText());
                } catch (MalformedURLException e1) {
                    textField_4.setText("");
                    textField_5.setText("");
                    textField_6.setText("");
                    textField_7.setText("");
                    chooser.setDate(null);
                    textField_8.setText("");
                    textField_9.setText("");
                    textField_10.setText("");
                    textField_11.setText("");
                    setVisible(true);
                    JOptionPane.showMessageDialog(app, "URL no valida ingrese: https://ejemplo.xxx", "error", JOptionPane.ERROR_MESSAGE);
                }
                setVisible(false);
                try {
                    CU.crearProfesor(nick, nombre, apellido, mail, fecha, institucion, descripcion, biografia, link);
                } catch (UsuarioRepetidoException rep) {
                    textField_4.setText("");
                    textField_5.setText("");
                    textField_6.setText("");
                    textField_7.setText("");
                    chooser.setDate(null);
                    textField_8.setText("");
                    textField_9.setText("");
                    textField_10.setText("");
                    textField_11.setText("");
                    setVisible(true);
                    JOptionPane.showMessageDialog(app, "Usuario ya existe", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (InstitucionNoEncontradaException e1) {
                    textField_4.setText("");
                    textField_5.setText("");
                    textField_6.setText("");
                    textField_7.setText("");
                    chooser.setDate(null);
                    textField_8.setText("");
                    textField_9.setText("");
                    textField_10.setText("");
                    textField_11.setText("");
                    setVisible(true);
                    JOptionPane.showMessageDialog(app, "Institucion no encontrada", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                textField_4.setText("");
                textField_5.setText("");
                textField_6.setText("");
                textField_7.setText("");
                chooser.setDate(null);
                textField_8.setText("");
                textField_9.setText("");
                textField_10.setText("");
                textField_11.setText("");
                JOptionPane.showMessageDialog(app, "Profesor creado exitosamente.");
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 13;
        getContentPane().add(btnNewButton, gbc_btnNewButton);
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1.gridx = 3;
        gbc_btnNewButton_1.gridy = 13;
        getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
        setBounds(100, 100, 555, 360);
    }
}