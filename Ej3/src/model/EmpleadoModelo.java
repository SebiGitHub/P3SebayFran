package model;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoModelo {
	private List<Empleado> empleados;
	private int indiceActual;

	// Constructor de EmpleadoModelo con 5 ejemplos y una lista donde almacenarlos
	public EmpleadoModelo() {
	    empleados = new ArrayList<>();
	    indiceActual = 0;

	    // Precargamos 5 empleados
	    empleados.add(new Empleado(1, "Juan Pérez", "1990-01-15", 3000.0, 50000.0, "Calle masin llanos"));
	    empleados.add(new Empleado(2, "María López", "1985-05-10", 3200.0, 4000.0, "Calle todas Iguales"));
	    empleados.add(new Empleado(3, "Carlos García", "1978-12-22", 2800.0, 3500.0, "Calle marrón"));
	    empleados.add(new Empleado(4, "Ana Fernández", "1993-03-03", 3500.0, 4200.0, "Calle Maldad"));
	    empleados.add(new Empleado(5, "Luis Sánchez", "2000-11-01", 2500.0, 3000.0, "Calle betis"));
	}

	
	// Metodos para los cambios en las listas
	public Empleado getEmpleadoActual() {
		return empleados.get(indiceActual);
	}

	public void siguienteEmpleado() {
		if (indiceActual < empleados.size() - 1) {
			indiceActual++;
		}
	}

	public void anteriorEmpleado() {
		if (indiceActual > 0) {
			indiceActual--;
		}
	}

	public boolean esUltimoEmpleado() {
		return indiceActual == empleados.size() - 1;
	}

	public boolean esPrimerEmpleado() {
		return indiceActual == 0;
	}

	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
		indiceActual = empleados.size() - 1; // Posiciona en el nuevo empleado
	}

	public boolean hayCampoNuevo() {
		return indiceActual == empleados.size(); // Indica si estamos en un "nuevo" registro
	}
}
