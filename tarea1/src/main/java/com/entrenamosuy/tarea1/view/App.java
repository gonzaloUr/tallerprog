package com.entrenamosuy.tarea1.view;

import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.logic.*;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.util.Triple;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class App extends JFrame {

    private final IControladorActividadClase controladorActividadClase;

    private final IControladorCuponera controladorCuponera;

    private final IControladorUsuario controladorUsuario;

    public App() {
        // Controladores y fabrica
        Fabrica fabrica = new Fabrica();

        controladorActividadClase = fabrica.crearControladorActividadClase();
        controladorCuponera = fabrica.crearControladorCuponera();
        controladorUsuario = fabrica.creaControladorUsuario();

        App that = this;

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

        JMenuItem consultaSocio = new JMenuItem("Consulta de socio");
        consultas.add(consultaSocio);

        JMenuItem consultaProfesor = new JMenuItem("Consulta de profesor");
        consultas.add(consultaProfesor);

        JMenuItem consultaActividad = new JMenuItem("Consulta de actividad deportiva");
        consultas.add(consultaActividad);

        JMenuItem consultaDictadoClase = new JMenuItem("Consulta de dictado de clase");
        consultas.add(consultaDictadoClase);

        JMenuItem consultaCuponera = new JMenuItem("Consulta de cuponeras de actividades deportivas");
        consultaCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        consultas.add(consultaCuponera);

        // Modificar datos de usuario
        JMenu modificar = new JMenu("Modificar");
        menuBar.add(modificar);

        JMenuItem modificarUsuario = new JMenuItem("Modificar datos de usuario");
        modificar.add(modificarUsuario);

        modificarUsuario.addActionListener((ActionEvent a) -> {
            Set<Triple<String, String, String>> usuarios = new HashSet<>();
            usuarios.addAll(controladorUsuario.obtenerDescProfesores());
            usuarios.addAll(controladorUsuario.obtenerDescSocios());

            if (usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay usuarios en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarUsuario selecionarUsuario = new SelecionarUsuario(usuarios, (String nickname) -> {
                ModificarDatosUsuario modificarDatosUsuario = new ModificarDatosUsuario(nickname, controladorUsuario);
                getContentPane().add(modificarDatosUsuario);
                modificarDatosUsuario.setVisible(true);
            });

            getContentPane().add(selecionarUsuario);
            selecionarUsuario.setVisible(true);
        });

        consultaActividad.addActionListener((ActionEvent a) -> {
            Set<Triple<String, String, URL>> instituciones = controladorActividadClase.obtenerDescInstituciones();

            if (instituciones.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay instituciones en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String institucion) -> {
        	   Set<Pair<String, String>> actividades = null;
    
                   try {
                       actividades = controladorActividadClase.obtenerDescActividades(institucion);
                   } catch (InstitucionNoEncontradaException e) {
                       e.printStackTrace();
                       return;
                   }
    
                   if (instituciones.isEmpty()) {
                       JOptionPane.showMessageDialog(this,
                               "No hay actividades en el sistema para " + institucion + ".",
                               "error",
                               JOptionPane.ERROR_MESSAGE);
    
                       return;
                   }
    
                   SelecionarActividad selecionarActividad = new SelecionarActividad(actividades, (String actividad) -> {
                       ConsultaActividad consulta = new ConsultaActividad(this, actividad, controladorActividadClase);
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
            Set<Triple<String, String, String>> socios = controladorUsuario.obtenerDescSocios();

            if (socios.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay socios en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarUsuario selecionarUsuario = new SelecionarUsuario(socios, (String nickname) -> {
                ConsultaSocio consulta = new ConsultaSocio(this, controladorActividadClase, controladorUsuario, nickname);
                getContentPane().add(consulta);
                consulta.setVisible(true);
            });

            getContentPane().add(selecionarUsuario);
            selecionarUsuario.setVisible(true);
        });

        consultaProfesor.addActionListener((ActionEvent a) -> {
            Set<Triple<String, String, String>> profesores = controladorUsuario.obtenerDescProfesores();

            if (profesores.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay profesores en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarUsuario selecionarUsuario = new SelecionarUsuario(profesores, (String nickname) -> {
                ConsultaProfesor consulta = new ConsultaProfesor(nickname, controladorUsuario);
                getContentPane().add(consulta);
                consulta.setVisible(true);
            });

            getContentPane().add(selecionarUsuario);
            selecionarUsuario.setVisible(true);
        });

        altaDictadoClase.addActionListener((ActionEvent a) -> {
            Set<Triple<String, String, URL>> instituciones = controladorActividadClase.obtenerDescInstituciones();

            if (instituciones.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay instituciones en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String inst) -> {
                Set<Pair<String, String>> actividades = null;

                try {
                    actividades = controladorActividadClase.obtenerDescActividades(inst);
                } catch (InstitucionNoEncontradaException e) {
                    e.printStackTrace();
                    return;
                }

                if (instituciones.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "No hay actividades en el sistema para " + inst + ".",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                SelecionarActividad selecionarActividad = new SelecionarActividad(actividades, (String actividad) -> {
                    AltaClase altaClase = new AltaClase(actividad, controladorUsuario, controladorActividadClase);
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
            Set<Triple<String, String, URL>> instituciones = controladorActividadClase.obtenerDescInstituciones();

            if (instituciones.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay instituciones en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String inst) -> {
                Set<Pair<String, String>> actividades = null;

                try {
                    actividades = controladorActividadClase.obtenerDescActividades(inst);
                } catch (InstitucionNoEncontradaException e) {
                    e.printStackTrace();
                    return;
                }

                if (instituciones.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "No hay actividades en el sistema para " + inst + ".",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                SelecionarActividad selecionarActividad = new SelecionarActividad(actividades, (String actividad) -> {
                    Set<String> clases = null;
                    
		    try {
			clases = controladorActividadClase.obtenerDescClases(actividad);
		    } catch (ActividadNoEncontradaException e1) {
			e1.printStackTrace();
			return;
		    }
		    
		    if (instituciones.isEmpty()) {
	                    JOptionPane.showMessageDialog(this,
	                            "No hay clases en el sistema para " + actividad + ".",
	                            "error",
	                            JOptionPane.ERROR_MESSAGE);

	                    return;
	            }
		    
		    SelecionarClase selecionarClase = new SelecionarClase(clases, (String clase) -> {
			ConsultaDictadoClase consulta = new ConsultaDictadoClase(clase, controladorActividadClase);
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
            Set<Triple<String, String, URL>> instituciones = controladorActividadClase.obtenerDescInstituciones();

            if (instituciones.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay instituciones en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String inst) -> {
                Set<Pair<String, String>> actividades = null;

                try {
                    actividades = controladorActividadClase.obtenerDescActividades(inst);
                } catch (InstitucionNoEncontradaException e) {
                    e.printStackTrace();
                    return;
                }

                if (actividades.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "No hay actividades en el sistema para " + inst + ".",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                SelecionarActividad selecionarActividad = new SelecionarActividad(actividades, (String actividad) -> {
                    Set<String> clases = null;
                    
		    try {
			clases = controladorActividadClase.obtenerDescClases(actividad);
		    } catch (ActividadNoEncontradaException e1) {
			e1.printStackTrace();
			return;
		    }
		    
		    if (clases.isEmpty()) {
	                    JOptionPane.showMessageDialog(this,
	                            "No hay clases en el sistema para " + actividad + ".",
	                            "error",
	                            JOptionPane.ERROR_MESSAGE);

	                    return;
	            }
		    
		    SelecionarClase selecionarClase = new SelecionarClase(clases, (String clase) -> {
		    
                        Set<Triple<String, String, String>> socios = controladorUsuario.obtenerDescSocios();
                        
                        if (socios.isEmpty()) {
    	                	JOptionPane.showMessageDialog(this,
    	                		"No hay socios en el sistema.",
    	                		"error",
    	                		JOptionPane.ERROR_MESSAGE);
    
    	                	return;
    	            	}
                        
                        SelecionarUsuario selecionarSocio = new SelecionarUsuario(socios, (String socio) -> {
            		    Set<Pair<String, String>> cuponeras = null;
            			    
            		    try {
            			cuponeras = controladorCuponera.cuponerasUsables(actividad, socio);
            		    } catch (SocioNoEncontradoException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            			return;
            		    } catch (ActividadNoEncontradaException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            			return;
            		    }
            		    
            		    RegistroAClase registroAClase = new RegistroAClase(actividad, clase, socio, cuponeras, controladorActividadClase);
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
            CrearCuponera c = new CrearCuponera(controladorCuponera);
            c.setVisible(true);
            getContentPane().add(c);
        });
        
        consultaCuponera.addActionListener((ActionEvent a) -> {
            Set<Pair<String, String>> cuponeras = controladorCuponera.obtenerDescCuponeras();
            
            if (cuponeras.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay cuponeras en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }
            
            
            SelecionarCuponera selecionarCuponera = new SelecionarCuponera(cuponeras, (String cuponera) -> {
        	ConsultarCuponera consulta = new ConsultarCuponera(this, cuponera, controladorCuponera, controladorActividadClase);
        	consulta.setVisible(true);
        	getContentPane().add(consulta);
            });
            
            selecionarCuponera.setVisible(true);
            getContentPane().add(selecionarCuponera);
        });
        
        altaActividadDeportiva.addActionListener((ActionEvent a) -> {
            AltaActividad alta = new AltaActividad(controladorActividadClase, this);
            alta.setVisible(true);
            getContentPane().add(alta);
        });
        
        altaInstitucionDeportiva.addActionListener((ActionEvent a) -> {
            AltaInstitucion alta = new AltaInstitucion(controladorActividadClase, that);
            alta.setVisible(true);
            getContentPane().add(alta);
        });
        
        altaDeProfesor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AltaProfesor altaprofesor = new AltaProfesor(that, controladorUsuario);
                that.getContentPane().add(altaprofesor);
                altaprofesor.setVisible(true);
            }
        });
        
        altaDeSocio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AltaSocio altasocio = new AltaSocio(that, controladorUsuario);
                that.getContentPane().add(altasocio);
                altasocio.setVisible(true);
            }
        });
        
        cargarDatos.addActionListener(new CargarDatosLambda(controladorUsuario,
                controladorActividadClase,
                controladorCuponera, () -> {

            JOptionPane.showMessageDialog(that,"Datos cargados", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }));
        
        agregarActividadCuponera.addActionListener((ActionEvent a) -> {
            Set<Pair<String, String>> cuponeras = controladorCuponera.obtenerDescCuponeras();
            
            if (cuponeras.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay cuponeras en el sistema.",
                        "error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }
            
            SelecionarCuponera selecionarCuponera = new SelecionarCuponera(cuponeras, (String cuponera) -> {
    	    	Set<Triple<String, String, URL>> instituciones = controladorActividadClase.obtenerDescInstituciones();

                if (instituciones.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "No hay instituciones en el sistema.",
                            "error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }
                
                SelecionarInstitucion selecionarInstitucion = new SelecionarInstitucion(instituciones, (String inst) -> {
                    Set<String> actividades = null;

                    try {
                	actividades = controladorCuponera.actividadesAgregables(cuponera, inst);
                    } catch (InstitucionNoEncontradaException | CuponeraNoEncontradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
                    }
                    if(actividades.size()==0) {
                    	JOptionPane.showMessageDialog(that,"No hay actividades agregables.","error", JOptionPane.ERROR_MESSAGE);
                    	return;
                    }
                    SeleccionarActHs selecActH = new SeleccionarActHs(actividades, controladorCuponera, that, cuponera);
                    selecActH.setVisible(true);
                    getContentPane().add(selecActH);
                    
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
