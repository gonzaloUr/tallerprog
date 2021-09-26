package com.entrenamosuy.tarea1.view;

import com.entrenamosuy.core.*;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.util.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

public class App extends JFrame {

    private final FacadeContainer facades;

    public App() {
        Fabrica fabrica = new Fabrica();
        // TODO: hacer que fabrica cree el Registry.
        AbstractRegistry registry = new Registry();
        facades = fabrica.createFacades();

        facades.getFacadeActividad().setRegistry(registry);
        facades.getFacadeClase().setRegistry(registry);
        facades.getFacadeCuponera().setRegistry(registry);
        facades.getFacadeInstitucion().setRegistry(registry);
        facades.getFacadeUsuario().setRegistry(registry);

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

        JMenuItem aceptarRechazarAct = new JMenuItem("Aceptar/Rechazar Actividad Deportiva");
        inicio.add(aceptarRechazarAct);

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

        JMenuItem altaDeSocio = new JMenuItem("Alta de socio");
        registros.add(altaDeSocio);

        JMenuItem altaDeProfesor = new JMenuItem("Alta de profesor");

        registros.add(altaDeProfesor);

        JMenuItem altaActividadDeportiva = new JMenuItem("Alta de actividad deportiva");
        registros.add(altaActividadDeportiva);

        JMenuItem altaDictadoClase = new JMenuItem("Alta de dictado de clase");
        registros.add(altaDictadoClase);

        JMenuItem altaCategoria = new JMenuItem("Alta de categoría");
        registros.add(altaCategoria);

        JMenuItem altaInstitucionDeportiva = new JMenuItem("Alta de institucion deportiva");
        registros.add(altaInstitucionDeportiva);

        JMenuItem registroDictadoClase = new JMenuItem("Registro a dictado clase");
        registros.add(registroDictadoClase);

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

        JMenuItem consultaSocio = new JMenuItem("Consulta de socio");
        consultas.add(consultaSocio);

        JMenuItem consultaProfesor = new JMenuItem("Consulta de profesor");
        consultas.add(consultaProfesor);

        JMenuItem consultaActividad = new JMenuItem("Consulta de actividad deportiva");
        consultas.add(consultaActividad);

        JMenuItem consultaDictadoClase = new JMenuItem("Consulta de dictado de clase");
        consultas.add(consultaDictadoClase);

        JMenuItem consultaCuponera = new JMenuItem("Consulta de cuponeras de actividades deportivas");
        consultas.add(consultaCuponera);

        // Modificar datos de usuario
        JMenu modificar = new JMenu("Modificar");
        menuBar.add(modificar);

        JMenuItem modificarSocio = new JMenuItem("Modificar datos de socio");
        modificar.add(modificarSocio);

        JMenuItem modificarProfesor = new JMenuItem("Modificar datos de profesor");
        modificar.add(modificarProfesor);

        //Aceptar o Rechazar Actividad Deportiva
        aceptarRechazarAct.addActionListener((ActionEvent a) -> {
            Set<DataActividad> dataIngresadas = facades.getFacadeActividad().listarActividadesRegistradas();
            
            if (dataIngresadas.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay actividades por aceptar o rechazar.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            Set<String> ingresadas = new HashSet<>();
            for (DataActividad ac : dataIngresadas){
                ingresadas.add(ac.getNombre());
            }

            SelecionarActividad selecionarIngresada = new SelecionarActividad(ingresadas, (String ingresada) -> {
                AceptarORechazar aR = new AceptarORechazar(ingresada,facades);
                getContentPane().add(aR);
                aR.setVisible(true);
            });

            getContentPane().add(selecionarIngresada);
            selecionarIngresada.setVisible(true);
        });


        modificarSocio.addActionListener((ActionEvent a) -> {
            Set<String> socios = facades.getFacadeUsuario().getSocios();

            if (socios.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay socios en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarUsuario selecionarUsuario = new SelecionarUsuario(socios, (String nickname) -> {
                ModificarDatosSocio modificarDatosUsuario = new ModificarDatosSocio(nickname, facades);
                getContentPane().add(modificarDatosUsuario);
                modificarDatosUsuario.setVisible(true);
            });

            getContentPane().add(selecionarUsuario);
            selecionarUsuario.setVisible(true);
        });

        modificarProfesor.addActionListener((ActionEvent a) -> {
            Set<String> profesores = facades.getFacadeUsuario().getProfesores();

            if (profesores.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay profesores en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarUsuario selecionarUsuario = new SelecionarUsuario(profesores, (String nickname) -> {
                ModificarDatosProfesor modificarDatosUsuario = new ModificarDatosProfesor(nickname, facades);
                getContentPane().add(modificarDatosUsuario);
                modificarDatosUsuario.setVisible(true);
            });

            getContentPane().add(selecionarUsuario);
            selecionarUsuario.setVisible(true);
        });

        consultaActividad.addActionListener((ActionEvent a) -> {
            Set<String> instituciones = facades.getFacadeInstitucion().getInstituciones();

            if (instituciones.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay instituciones en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String institucion) -> {
                Set<String> actividades = facades.getFacadeActividad().getActividadesDeInstitucion(institucion);

                if (actividades.isEmpty()){
                    JOptionPane.showMessageDialog(this,
                            "No hay actividades aceptadas en el sistema para " + institucion + ".",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                SelecionarActividad selecionarActividad = new SelecionarActividad(actividades, (String actividad) -> {
                    ConsultaActividad consulta = new ConsultaActividad(this, actividad, facades);
                    consulta.setVisible(true);
                    getContentPane().add(consulta);
                });

                selecionarActividad.setVisible(true);
                getContentPane().add(selecionarActividad);
            });

            getContentPane().add(selecionarInstitucion);
            selecionarInstitucion.setVisible(true);
        });

        consultaSocio.addActionListener((ActionEvent a) -> {
            Set<String> socios = facades.getFacadeUsuario().getSocios();

            if (socios.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay socios en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarUsuario selecionarUsuario = new SelecionarUsuario(socios, (String nickname) -> {
                ConsultaSocio consulta = new ConsultaSocio(this, nickname, facades);
                getContentPane().add(consulta);
                consulta.setVisible(true);
            });

            getContentPane().add(selecionarUsuario);
            selecionarUsuario.setVisible(true);
        });

        consultaProfesor.addActionListener((ActionEvent a) -> {
            Set<String> profesores = facades.getFacadeUsuario().getProfesores();

            if (profesores.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay profesores en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarUsuario selecionarUsuario = new SelecionarUsuario(profesores, (String nickname) -> {
                ConsultaProfesor consulta = new ConsultaProfesor(this, nickname, facades);
                getContentPane().add(consulta);
                consulta.setVisible(true);
            });

            getContentPane().add(selecionarUsuario);
            selecionarUsuario.setVisible(true);
        });

        altaDictadoClase.addActionListener((ActionEvent a) -> {
            Set<String> instituciones = facades.getFacadeInstitucion().getInstituciones();

            if (instituciones.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay instituciones en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String inst) -> {
                Set<String> actividades = facades.getFacadeActividad().getActividadesDeInstitucion(inst);

                if (actividades.isEmpty()){
                    JOptionPane.showMessageDialog(this,
                            "No hay actividades aceptadas en el sistema para " + inst + ".",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                SelecionarActividad selecionarActividad = new SelecionarActividad(actividades, (String actividad) -> {
                    AltaClase altaClase = new AltaClase(actividad, inst, this, facades);
                    altaClase.setVisible(true);
                    getContentPane().add(altaClase);
                });

                selecionarActividad.setVisible(true);
                getContentPane().add(selecionarActividad);
            });

            selecionarInstitucion.setVisible(true);
            getContentPane().add(selecionarInstitucion);
        });

        consultaDictadoClase.addActionListener((ActionEvent a) -> {
            Set<String> instituciones = facades.getFacadeInstitucion().getInstituciones();

            if (instituciones.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay instituciones en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String inst) -> {
                Set<String> actividades = facades.getFacadeActividad().getActividadesDeInstitucion(inst);

                if (actividades.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "No hay actividades aceptadas en el sistema para " + inst + ".",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                SelecionarActividad selecionarActividad = new SelecionarActividad(actividades, (String actividad) -> {
                    Set<String> clases = facades.getFacadeClase().getClases(actividad);

                    if (clases.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                                "No hay clases en el sistema para " + actividad + ".",
                                "error",
                                JOptionPane.ERROR_MESSAGE);

                        return;
                    }

                    SelecionarClase selecionarClase = new SelecionarClase(clases, (String clase) -> {
                        ConsultaDictadoClase consulta = new ConsultaDictadoClase(this, clase, facades);
                        consulta.setVisible(true);
                        getContentPane().add(consulta);
                    });

                    selecionarClase.setVisible(true);
                    getContentPane().add(selecionarClase);
                });

                selecionarActividad.setVisible(true);
                getContentPane().add(selecionarActividad);
            });

            selecionarInstitucion.setVisible(true);
            getContentPane().add(selecionarInstitucion);
        });

        registroDictadoClase.addActionListener((ActionEvent a) -> {
            Set<String> instituciones = facades.getFacadeInstitucion().getInstituciones();

            if (instituciones.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay instituciones en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String inst) -> {
                Set<String> actividades = facades.getFacadeActividad().getActividadesDeInstitucion(inst);

                if (actividades.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "No hay actividades aceptadas en el sistema para " + inst + ".",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                SelecionarActividad selecionarActividad = new SelecionarActividad(actividades, (String actividad) -> {
                    Set<String> clases = facades.getFacadeClase().getClases(actividad);

                    if (clases.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                                "No hay clases en el sistema para " + actividad + ".",
                                "error",
                                JOptionPane.ERROR_MESSAGE);

                        return;
                    }

                    SelecionarClase selecionarClase = new SelecionarClase(clases, (String clase) -> {

                        Set<String> socios = facades.getFacadeUsuario().getSocios();

                        if (socios.isEmpty()) {
                            JOptionPane.showMessageDialog(this,
                                    "No hay socios en el sistema.",
                                    "error",
                                    JOptionPane.ERROR_MESSAGE);

                            return;
                        }

                        SelecionarUsuario selecionarSocio = new SelecionarUsuario(socios, (String socio) -> {

                            DataSocio dataSocio = facades.getFacadeUsuario().getDataSocio(socio);

                            for (DataClase c : dataSocio.getClases()) {
                                if (c.getNombre().equals(clase)) {
                                    JOptionPane.showMessageDialog(this,
                                            "El socio ya esta registrado a la clase seleccionada.",
                                            "error",
                                            JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            }

                            Set<String> cuponeras = facades.getFacadeCuponera().cuponerasUsables(actividad, socio);

                            RegistroAClase registroAClase = new RegistroAClase(this, actividad, clase, socio, cuponeras, facades);
                            registroAClase.setVisible(true);
                            getContentPane().add(registroAClase);
                        });

                        selecionarSocio.setVisible(true);
                        getContentPane().add(selecionarSocio);
                    });

                    selecionarClase.setVisible(true);
                    getContentPane().add(selecionarClase);
                });

                selecionarActividad.setVisible(true);
                getContentPane().add(selecionarActividad);
            });

            selecionarInstitucion.setVisible(true);
            getContentPane().add(selecionarInstitucion);
        });

        crearCuponera.addActionListener((ActionEvent a) -> {
            CrearCuponera c = new CrearCuponera(this, facades);
            c.setVisible(true);
            getContentPane().add(c);
        });

        consultaCuponera.addActionListener((ActionEvent a) -> {
            Set<String> cuponeras = facades.getFacadeCuponera().getCuponeras();

            if (cuponeras.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay cuponeras en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }


            SelecionarCuponera selecionarCuponera = new SelecionarCuponera(cuponeras, (String cuponera) -> {
                ConsultarCuponera consulta = new ConsultarCuponera(this, cuponera, facades);
                consulta.setVisible(true);
                getContentPane().add(consulta);
            });

            selecionarCuponera.setVisible(true);
            getContentPane().add(selecionarCuponera);
        });

        altaCategoria.addActionListener((ActionEvent a) -> {
            AltaCategoria alta = new AltaCategoria(this, facades);
            alta.setVisible(true);
            getContentPane().add(alta);
        });

        altaActividadDeportiva.addActionListener((ActionEvent a) -> {
            AltaActividad alta = new AltaActividad(this, facades);
            alta.setVisible(true);
            getContentPane().add(alta);
        });

        altaInstitucionDeportiva.addActionListener((ActionEvent a) -> {
            AltaInstitucion alta = new AltaInstitucion(this, facades);
            alta.setVisible(true);
            getContentPane().add(alta);
        });

        altaDeProfesor.addActionListener((ActionEvent e) -> {
            AltaProfesor altaprofesor = new AltaProfesor(this, facades);
            getContentPane().add(altaprofesor);
            altaprofesor.setVisible(true);
        });

        altaDeSocio.addActionListener((ActionEvent e) -> {
            AltaSocio altasocio = new AltaSocio(this, facades);
            getContentPane().add(altasocio);
            altasocio.setVisible(true);
        });

        cargarDatos.addActionListener(new CargarDatosLambda(facades, () -> {
            JOptionPane.showMessageDialog(this, "Datos cargados", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }));

        agregarActividadCuponera.addActionListener((ActionEvent a) -> {
            Set<String> cuponeras = facades.getFacadeCuponera().getCuponerasSinCompras();

            if (cuponeras.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No existen cuponeras disponibles para agregarles una actividad.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarCuponera selecionarCuponera = new SelecionarCuponera(cuponeras, (String cuponera) -> {
                Set<String> instituciones = facades.getFacadeInstitucion().getInstituciones();

                if (instituciones.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "No hay instituciones en el sistema.",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String inst) -> {
                    Set<String> actividades = facades.getFacadeCuponera().actividadesAgregables(cuponera, inst);

                    if (actividades.size() == 0) {
                        JOptionPane.showMessageDialog(this, "No hay actividades agregables.", "error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    AgregarActividadACuponera agregarCuponera = new AgregarActividadACuponera(actividades, cuponera, this, facades);
                    agregarCuponera.setVisible(true);
                    getContentPane().add(agregarCuponera);

                });

                selecionarInstitucion.setVisible(true);
                getContentPane().add(selecionarInstitucion);
            });

            selecionarCuponera.setVisible(true);
            getContentPane().add(selecionarCuponera);

        });
    }

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}
