package controller;

import java.io.*;
import java.util.List;

public class CtrPersistencia<T> {
    private String nombreArchivo;

    public CtrPersistencia(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    // Guardar la lista en un archivo
    public void guardar(List<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar la lista desde un archivo
    @SuppressWarnings("unchecked")
    public List<T> cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se devolverá una lista vacía.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Lista<T>().obtenerTodos();
    }
}
