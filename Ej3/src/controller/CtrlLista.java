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

import model.Cuenta;
import model.CuentaAhorro;
import model.CuentaCorriente;

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
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                lista = (Lista<Cuenta>) ois.readObject();
                JOptionPane.showMessageDialog(null, "Datos cargados correctamente.");
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
        lista.agregar(new CuentaAhorro(1, "Usuario 1", 1000, 500, 2.5, "Otro Atributo 1", new Date()));
        lista.agregar(new CuentaAhorro(2, "Usuario 2", 2000, 1000, 3.0, "Otro Atributo 2", new Date()));
        lista.agregar(new CuentaCorriente(3, "Usuario 3", 1500, 500, 10, "Mensual", new Date()));
        lista.agregar(new CuentaCorriente(4, "Usuario 4", 3000, 2000, 15, "Mensual", new Date()));
        JOptionPane.showMessageDialog(null, "Datos de prueba cargados.");
    }

    // Obtener datos para mostrar en una lista
    public String[] obtenerDatosLista() {
        List<String> datos = new ArrayList<>();
        for (Cuenta cuenta : lista.obtenerTodos()) {
            datos.add(cuenta.toString());
        }
        return datos.toArray(new String[0]);
    }
}