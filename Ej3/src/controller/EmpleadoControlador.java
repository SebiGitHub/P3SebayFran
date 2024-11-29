package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import model.Empleado;
import model.EmpleadoModelo;
import view.EmpleadoVista;
import view.PanelAlta;

public class EmpleadoControlador {
    private EmpleadoModelo modelo;
    private EmpleadoVista vista;

    // Constructor de EmpleadoControlador que recibe el modelo y la vista
    public EmpleadoControlador(EmpleadoModelo modelo, EmpleadoVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Inicializamos la vista con el primer empleado
        mostrarEmpleadoActual();

        // Listeners para los botones en la vista
        vista.getAnteriorButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.anteriorEmpleado();
                mostrarEmpleadoActual();
            }
        });

        vista.getSiguienteButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.siguienteEmpleado();
                mostrarEmpleadoActual();
            }
        });

        vista.getAltaButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vista.cambiarPanel("Alta");  // Cambiar al panel Alta
            }
        });

        // Listener para el botón de aceptar en el PanelAlta
        PanelAlta panelAlta = (PanelAlta) vista.getPanelAlta();
        panelAlta.getAceptarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Restablecer los colores de fondo antes de cada validación
                resetFieldColors();

                // Obtener los datos del panel Alta
                int numero = panelAlta.getNumero();
                String nombre = panelAlta.getNombre();
                String fechaNacimiento = panelAlta.getFechaNacimiento();
                double salarioActual = panelAlta.getSalarioActual();
                double salarioMax = panelAlta.getSalarioMax();
                String direccion = panelAlta.getDireccion();

                // Validar los datos antes de crear el nuevo empleado
                if (!validarFechaNacimiento(fechaNacimiento)) {
                    mostrarError(panelAlta.getFechaNacimientoField(), "Fecha de nacimiento inválida. Debe ser entre 1900 y 2015.");
                    return;
                }
                
                if (!validarSueldos(salarioActual, salarioMax)) {
                    mostrarError(panelAlta.getSalarioActualField(), "El sueldo actual debe ser menor que el sueldo máximo.");
                    return;
                }

                // Si los datos son válidos, crear el nuevo empleado
                Empleado nuevoEmpleado = new Empleado(numero, nombre, fechaNacimiento, salarioActual, salarioMax, direccion);

                // Agregar el nuevo empleado al modelo
                modelo.agregarEmpleado(nuevoEmpleado);

                // Cambiar al panel "Ver" para ver el nuevo empleado
                vista.cambiarPanel("Ver");
                mostrarEmpleadoActual();  // Actualizar la vista con el nuevo empleado
            }
        });  
    }

    // Método para mostrar mensajes de error en el JTextField correspondiente
    private void mostrarError(javax.swing.JTextField campo, String mensaje) {
        campo.setBackground(Color.RED);  // Cambiar el fondo del campo al rojo para indicar el error
        campo.setToolTipText(mensaje);   // Añadir el mensaje de error como tooltip en el campo para proporcionar contexto
        vista.getPanelAlta().revalidate();  // Actualizar el panel
        vista.getPanelAlta().repaint();  // Redibujar el panel
    }

    // Método para restablecer los colores de los campos antes de cada validación
    private void resetFieldColors() {
        PanelAlta panelAlta = (PanelAlta) vista.getPanelAlta();
        panelAlta.getFechaNacimientoField().setBackground(Color.WHITE);  // Restablecer a fondo blanco
        panelAlta.getSalarioActualField().setBackground(Color.WHITE);     // Restablecer a fondo blanco
    }

    // Método para validar la fecha de nacimiento
    private boolean validarFechaNacimiento(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);  // Desactivar la leniencia en el formato
            sdf.parse(fecha);  // Intentar parsear la fecha
            
            // Verificar si el año está entre 1900 y 2015
            int year = Integer.parseInt(fecha.split("-")[0]);
            return year >= 1900 && year <= 2015;
        } catch (Exception e) {
            return false;
        }
    }

    // Método para validar los sueldos
    private boolean validarSueldos(double salarioActual, double salarioMax) {
        return salarioActual < salarioMax;
    }

    // Método para mostrar los datos del empleado actual
    private void mostrarEmpleadoActual() {
        Empleado empleado = modelo.getEmpleadoActual();
        vista.setEmpleadoData(empleado.getNumero(), empleado.getNombre(), empleado.getFechaNacimiento(),
                empleado.getSalarioTiempoReal(), empleado.getSalarioMax(), empleado.getDireccion());
    }
}

