package com.entrenamosuy.tarea1.view;

import javax.swing.JInternalFrame;

import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DescActividad;
import com.entrenamosuy.core.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.util.*;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JTextField;
import javax.swing.JList;

public class ConsultarCuponera extends JInternalFrame {
    private JTextField nombreField;
    private JTextField descripcionField;

    public ConsultarCuponera(App app, String cuponera, FacadeContainer facades) {
        setTitle("Consulta cuponera");
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setSize(389, 353);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNombre = new JLabel("Nombre");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.anchor = GridBagConstraints.WEST;
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 1;
        getContentPane().add(lblNombre, gbc_lblNombre);

        nombreField = new JTextField();
        nombreField.setEditable(false);
        GridBagConstraints gbc_nombreField = new GridBagConstraints();
        gbc_nombreField.insets = new Insets(0, 0, 5, 5);
        gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreField.gridx = 3;
        gbc_nombreField.gridy = 1;
        getContentPane().add(nombreField, gbc_nombreField);
        nombreField.setColumns(10);

        JLabel lblDescripcion = new JLabel("Descripcion");
        GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
        gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
        gbc_lblDescripcion.gridx = 1;
        gbc_lblDescripcion.gridy = 3;
        getContentPane().add(lblDescripcion, gbc_lblDescripcion);

        descripcionField = new JTextField();
        descripcionField.setEditable(false);
        GridBagConstraints gbc_descripcionField = new GridBagConstraints();
        gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
        gbc_descripcionField.gridx = 3;
        gbc_descripcionField.gridy = 3;
        getContentPane().add(descripcionField, gbc_descripcionField);
        descripcionField.setColumns(10);

        JLabel lblActividades = new JLabel("Actividades");
        GridBagConstraints gbc_lblActividades = new GridBagConstraints();
        gbc_lblActividades.insets = new Insets(0, 0, 5, 5);
        gbc_lblActividades.anchor = GridBagConstraints.WEST;
        gbc_lblActividades.gridx = 1;
        gbc_lblActividades.gridy = 7;
        getContentPane().add(lblActividades, gbc_lblActividades);

        JLabel lblCategorias = new JLabel("Categorias");
        GridBagConstraints gbc_lblCategorias = new GridBagConstraints();
        gbc_lblCategorias.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategorias.anchor = GridBagConstraints.WEST;
        gbc_lblCategorias.gridx = 1;
        gbc_lblCategorias.gridy = 5;
        getContentPane().add(lblCategorias, gbc_lblCategorias);

        DataCuponera dataCuponera = facades.getFacadeCuponera().getDataCuponera(cuponera);

        nombreField.setText(dataCuponera.getNombre());
        descripcionField.setText(dataCuponera.getDescripcion());

        List<String> actividades = new ArrayList<>();
        List<String> categorias = new ArrayList<>();

        for (DescActividad a : dataCuponera.getActividades())
            actividades.add(a.getNombre());
        for (String s : dataCuponera.getCategorias())
            categorias.add(s);

        JList<String> listCat = new JList<>(categorias.toArray(new String[]{}));
        GridBagConstraints gbc_listCat = new GridBagConstraints();
        gbc_listCat.insets = new Insets(0, 0, 5, 5);
        gbc_listCat.fill = GridBagConstraints.BOTH;
        gbc_listCat.gridx = 3;
        gbc_listCat.gridy = 5;
        getContentPane().add(listCat, gbc_listCat);

        JList<String> list = new JList<>(actividades.toArray(new String[]{}));
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.insets = new Insets(0, 0, 5, 5);
        gbc_list.fill = GridBagConstraints.BOTH;
        gbc_list.gridx = 3;
        gbc_list.gridy = 7;
        getContentPane().add(list, gbc_list);

        MouseListener mouseListener = new MouseAdapter() {

            public void mouseClicked(MouseEvent mouseEvent) {
                JList<?> theList = (JList<?>) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        String actividad = theList.getModel().getElementAt(index).toString();
                        ConsultaActividad consultaActividad = new ConsultaActividad(app, actividad, facades);
                        consultaActividad.setVisible(true);
                        app.getContentPane().add(consultaActividad);
                    }
                }
            }
        };

        list.addMouseListener(mouseListener);
    }
}
