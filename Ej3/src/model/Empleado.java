package model;

public class Empleado {
	private Integer numeroEmpleado;
	private String nombre;
	private String fechaNacimiento;
	private Double salarioTiempoReal;
	private Double salarioMax;
	private String direccion;

	// Constructor Empleado con sus datos
	public Empleado(Integer numeroEmpleado, String nombre, String fechaNacimiento, Double salarioTiempoReal,
			Double salarioMax, String direccion) {
		this.numeroEmpleado = numeroEmpleado;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.salarioTiempoReal = salarioTiempoReal;
		this.salarioMax = salarioMax;
		this.direccion = direccion;
	}

	// Getters y setters
	public Integer getNumero() {
		return numeroEmpleado;
	}

	public void setNumero(Integer numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Double getSalarioTiempoReal() {
		return salarioTiempoReal;
	}

	public void setSalarioTiempoReal(Double salarioTiempoReal) {
		this.salarioTiempoReal = salarioTiempoReal;
	}

	public Double getSalarioMax() {
		return salarioMax;
	}

	public void setSalarioMax(Double salarioMax) {
		this.salarioMax = salarioMax;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
