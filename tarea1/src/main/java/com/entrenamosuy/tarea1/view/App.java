package com.entrenamosuy.tarea1.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class App extends JFrame {
    
    public App() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Estación de trabajo");
        setSize(600, 400);
     
        getContentPane().setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu inicio = new JMenu("Inicio");
        menuBar.add(inicio);
        
        JMenu registros = new JMenu("Registros");
        menuBar.add(registros);
        
        JMenu consultas = new JMenu("Consultas");
        menuBar.add(consultas);
    }
    
    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}
