package com.entrenamosuy.tarea1.view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.util.FacadeContainer;

public class AceptarORechazar extends JInternalFrame {
    public interface Callback {
        void run(String institucion);
    }

    public AceptarORechazar(String ingresada, FacadeContainer facades) {
        setMaximizable(true);
        setResizable(true);
        setClosable(true);
        setTitle("Aceptar/Rechazar Actividad Deportiva");
        setSize(398, 273);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 350, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblPregunta = new JLabel("¿Desea aceptar o rechazar " + ingresada + " ?");
        GridBagConstraints gbc_lblPregunta = new GridBagConstraints();
        gbc_lblPregunta.anchor = GridBagConstraints.NORTH;
        gbc_lblPregunta.insets = new Insets(0, 0, 5, 5);
        gbc_lblPregunta.gridx = 1;
        gbc_lblPregunta.gridy = 0;
        getContentPane().add(lblPregunta, gbc_lblPregunta);

        JButton btnAcepButton = new JButton("Aceptar");
        GridBagConstraints gbc_btnAcepButton = new GridBagConstraints();
        gbc_btnAcepButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnAcepButton.gridx = 1;
        gbc_btnAcepButton.gridy = 1;
        getContentPane().add(btnAcepButton, gbc_btnAcepButton);

        JButton btnRechButton = new JButton("Rechazar");
        GridBagConstraints gbc_btnRechButton = new GridBagConstraints();
        gbc_btnRechButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnRechButton.gridx = 1;
        gbc_btnRechButton.gridy = 2;
        getContentPane().add(btnRechButton, gbc_btnRechButton);

        btnAcepButton.addActionListener((ActionEvent a) -> {
            facades.getFacadeActividad().aceptarActividad(ingresada);
            dispose();
        });

        btnRechButton.addActionListener((ActionEvent a) -> {
            facades.getFacadeActividad().rechazarActividad(ingresada);
            dispose();
        });
    }
}
