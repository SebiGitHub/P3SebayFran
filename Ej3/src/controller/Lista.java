package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lista<T> implements Serializable {
    private static final long serialVersionUID = 1L;  // Añadir un identificador de versión para la serialización
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public Lista() {
        this.cabeza = null;
        this.cola = null;
    }

    // Agregar al final
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
    }

    // Eliminar un elemento
    public void eliminar(T dato) {
        Nodo<T> actual = cabeza;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                if (actual == cabeza) {
                    cabeza = actual.getSiguiente();
                    if (cabeza != null) {
                        cabeza.setAnterior(null);
                    }
                } else if (actual == cola) {
                    cola = actual.getAnterior();
                    if (cola != null) {
                        cola.setSiguiente(null);
                    }
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    // Obtener todos los elementos como lista
    public List<T> obtenerTodos() {
        List<T> lista = new ArrayList<>();
        Nodo<T> actual = cabeza;
        while (actual != null) {
            lista.add(actual.getDato());
            actual = actual.getSiguiente();
        }
        return lista;
    }

    // Recorrer hacia adelante
    public void recorrerAdelante() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    // Recorrer hacia atrás
    public void recorrerAtras() {
        Nodo<T> actual = cola;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getAnterior();
        }
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void vaciar() {
        cabeza = null;
        cola = null;
    }
}