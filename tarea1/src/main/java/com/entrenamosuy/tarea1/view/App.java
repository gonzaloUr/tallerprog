package com.entrenamosuy.tarea1.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class App extends JFrame {

    public App() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Estación de trabajo");
        setSize(600, 400);

        getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Boton de cerrar.
        // Cargar datos.
        JMenu inicio = new JMenu("Inicio");
        menuBar.add(inicio);

        JMenuItem cargarDatos = new JMenuItem("Cargar datos");
        inicio.add(cargarDatos);

        JMenuItem salir = new JMenuItem("Salir");
        inicio.add(salir);

        // Alta de usuario
        // Alta de actividad deportiva
        // Alta de dictado de clase
        // Registro a dictado de clase
        //
        // Alta de institucion deportiva
        // Crear cuponera de actividades deportivas
        // Agregar actividad deportiva a cuponera
        JMenu registros = new JMenu("Registros");
        menuBar.add(registros);

        JMenuItem altaDeUsuario = new JMenuItem("Alta de usuario");
        registros.add(altaDeUsuario);

        JMenuItem altaActividadDeportiva = new JMenuItem("Alta de actividad deportiva");
        registros.add(altaActividadDeportiva);

        JMenuItem altaDictadoClase = new JMenuItem("Alta de dictado de clase");
        registros.add(altaDictadoClase);

        JMenuItem registroDictadoClase = new JMenuItem("Registro a dictado clase");
        registros.add(registroDictadoClase);

        JMenuItem altaInstitucionDeportiva = new JMenuItem("Alta de institucion deportiva");
        registros.add(altaInstitucionDeportiva);

        JMenuItem crearCuponera = new JMenuItem("Crear cuponera de actividad deportivas");
        registros.add(crearCuponera);

        JMenuItem agregarActividadCuponera = new JMenuItem("Agregar actividad deportiva a cuponera");
        registros.add(agregarActividadCuponera);

        // Consulta de usuario
        // Consulta de actividad deportiva
        // Consulta de dictado de clase
        //
        // Consulta de cuponeras de actividades deportivas
        JMenu consultas = new JMenu("Consultas");
        menuBar.add(consultas);

        JMenuItem consultaUsuario = new JMenuItem("Consulta de usuario");
        consultas.add(consultaUsuario);

        JMenuItem consultaActividad = new JMenuItem("Consulta de actividad deportiva");
        consultas.add(consultaActividad);

        JMenuItem consultaDictadoClase = new JMenuItem("Consulta de dictado de clase");
        consultas.add(consultaDictadoClase);

        JMenuItem consultaCuponera = new JMenuItem("Consulta de cuponeras de actividades deportivas");
        consultas.add(consultaCuponera);

        // Modificar datos de usuario
        JMenu modificar = new JMenu("Modificar");
        menuBar.add(modificar);

        JMenuItem modificarUsuario = new JMenuItem("Modificar datos de usuario");
        modificar.add(modificarUsuario);
    }

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}
