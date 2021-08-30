package com.entrenamosuy.tarea1.view;

import javax.swing.*;

// Muestra una lista de usuarios y llama a su callback pasandole el nombre del usuario elejido
public class SelecionarUsuario extends JInternalFrame {

    public interface Callback {

        void run(String nombre);
    }
}
