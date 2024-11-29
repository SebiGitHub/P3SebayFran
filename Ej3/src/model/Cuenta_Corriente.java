package model;

import java.time.LocalDate;

public class Cuenta_Corriente extends Cuenta {
	
	private Double comision_Mantenimiento;
	private String tipoComision;
	public Cuenta_Corriente(Integer numero, String titular, Double saldo, Double saldoMinimo, LocalDate fechaApertura,
			Double comision_Mantenimiento, String tipoComision) {
		super(numero, titular, saldo, saldoMinimo, fechaApertura);
		this.comision_Mantenimiento = comision_Mantenimiento;
		this.tipoComision = tipoComision;
	}
	public Double getComision_Mantenimiento() {
		return comision_Mantenimiento;
	}
	public void setComision_Mantenimiento(Double comision_Mantenimiento) {
		this.comision_Mantenimiento = comision_Mantenimiento;
	}
	public String getTipoComision() {
		return tipoComision;
	}
	public void setTipoComision(String tipoComision) {
		this.tipoComision = tipoComision;
	}
	

}
