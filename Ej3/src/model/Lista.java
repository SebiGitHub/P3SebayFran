package model;

import controller.Nodo;

public class Lista<T> {
	private Nodo<T> cabeza;
	private Nodo<T> cola;
	private int tamaño;

	public Lista() {
		this.cabeza = null;
		this.cola = null;
		this.tamaño = 0;
	}

	public void agregarInicio(T dato) {
		Nodo<T> nuevoNodo = new Nodo<>(dato);
		if (cabeza == null) {
			cabeza = nuevoNodo;
			cola = nuevoNodo;
		} else {
			nuevoNodo.setSiguiente(cabeza);
			cabeza.setAnterior(nuevoNodo);
			cabeza = nuevoNodo;
		}
		tamaño++;
	}

	public void agregarFinal(T dato) {
		Nodo<T> nuevoNodo = new Nodo<>(dato);
		if (cola == null) {
			cabeza = nuevoNodo;
			cola = nuevoNodo;
		} else {
			nuevoNodo.setAnterior(cola);
			cola.setSiguiente(nuevoNodo);
			cola = nuevoNodo;
		}
		tamaño++;
	}

	public T eliminarInicio() {
		if (cabeza == null) {
			return null;
		}
		T dato = cabeza.getDato();
		cabeza = cabeza.getSiguiente();
		if (cabeza != null) {
			cabeza.setAnterior(null);
		} else {
			cola = null;
		}
		tamaño--;
		return dato;
	}

	public T eliminarFinal() {
		if (cola == null) {
			return null;
		}
		T dato = cola.getDato();
		cola = cola.getAnterior();
		if (cola != null) {
			cola.setSiguiente(null);
		} else {
			cabeza = null;
		}
		tamaño--;
		return dato;
	}

	public void recorrerAdelante() {
		Nodo<T> actual = cabeza;
		while (actual != null) {
			System.out.println(actual.getDato());
			actual = actual.getSiguiente();
		}
	}

	public void recorrerAtras() {
		Nodo<T> actual = cola;
		while (actual != null) {
			System.out.println(actual.getDato());
			actual = actual.getAnterior();
		}
	}

	public int getTamaño() {
		return tamaño;
	}

	public boolean estaVacia() {
		return tamaño == 0;
	}
}