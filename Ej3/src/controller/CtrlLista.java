package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.Beneficio;
import model.Comision;
import model.Cuenta;
import model.CuentaAhorro;
import model.CuentaCorriente;
import model.Titular;

public class CtrlLista {
    private Lista<Cuenta> lista;

    public CtrlLista() {
        this.lista = new Lista<>();
    }

    public Lista<Cuenta> getLista() {
        return lista;
    }

    // Cargar datos desde un archivo
    public void cargarDesdeArchivo(File archivo) {
    	//Comprueba si existe el archivo
    	if (archivo.exists()) {
    		//Abre el archivo e intenta leerlo
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                Object obj = ois.readObject();
                //Lee el archivo y te muestra que tipo de archivo está leyendo
                System.out.println("Tipo de objeto deserializado: " + obj.getClass().getName());
                //Comprueba que tipo de archivo está leyendo y guarda valor a valor en la lista
                if (obj instanceof Lista) {
                    lista = (Lista<Cuenta>) obj;
                    //Mensaje de que todo salió bien
                    JOptionPane.showMessageDialog(null, "Datos cargados correctamente.");
                } else {
                	//Fallo, habrá algún elemento que no pertenesca ni a cuenta corriente ni a la de ahorro
                    JOptionPane.showMessageDialog(null, "El archivo no contiene una lista válida.");
                }//Excepciones
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado.");
        }
    }

    // Guardar datos en un archivo
    public void guardarEnArchivo(File archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e.getMessage());
        }
    }

    // Vaciar lista
    public void vaciarLista() {
        lista = new Lista<>();
        JOptionPane.showMessageDialog(null, "Lista vaciada.");
    }

    // Cargar datos de prueba
    public void cargarPruebas() {
        // Cambiar add() a agregar() para que coincida con el método definido en la clase Lista
        lista.agregar(new CuentaAhorro(1, Titular.TITULAR_16.getNombre(), 1000, 500, new Date(),  2.4, Beneficio.BAJO));
        lista.agregar(new CuentaAhorro(2, Titular.TITULAR_16.getNombre(), 2000, 1000, new Date(), 34.0, Beneficio.ALTO));
        lista.agregar(new CuentaCorriente(3, Titular.TITULAR_4.getNombre(), 1500, 500, new Date(), 10, Comision.MEDIA));
        lista.agregar(new CuentaCorriente(4, Titular.TITULAR_18.getNombre(), 3000, 2000, new Date(), 12, Comision.ALTA));
        JOptionPane.showMessageDialog(null, "Datos de prueba cargados.");
    }

    // Obtener datos para mostrar en una lista
 // Obtener una lista de cuentas directamente
    public List<Cuenta> obtenerDatosLista() {
        return lista.obtenerTodos(); // lista es una estructura que contiene las cuentas
    }
    
    
    //Agregar
    public void agregarCuenta(Cuenta cuenta) {
    	lista.agregar(cuenta);  // O donde estés almacenando las cuentas
    }


}
