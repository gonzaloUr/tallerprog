package com.entrenamosuy.tarea1.view;

import com.entrenamosuy.tarea1.util.Triple;

import javax.swing.*;
import java.net.URL;
import java.util.List;

public class SelecionarInstitucion extends JInternalFrame {


    public interface Callback {

        void run(String institucion);
    }

    public SelecionarInstitucion(List<Triple<String, String, URL>> instituciones, Callback callback) {}
}
