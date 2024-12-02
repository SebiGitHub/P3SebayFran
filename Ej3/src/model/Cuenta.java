package model;

import java.time.LocalDate;
import java.time.Period;

public class Cuenta implements VerificacionFecha {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double SaldoMinimo;
	private LocalDate fechaApertura;
	public Cuenta() {
	}
	public Cuenta(Integer numero, String titular, Double saldo, Double saldoMinimo, LocalDate fechaApertura) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		SaldoMinimo = saldoMinimo;
		this.fechaApertura = fechaApertura;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getSaldoMinimo() {
		return SaldoMinimo;
	}
	public void setSaldoMinimo(Double saldoMinimo) {
		SaldoMinimo = saldoMinimo;
	}
	public LocalDate getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	@Override
	public boolean VerificacionFecha(int meses, int anios) {
		   if (fechaApertura == null) {
	            throw new IllegalStateException("La fecha de apertura no está definida");
	        }

	        LocalDate hoy = LocalDate.now();
	        Period diferencia = Period.between(fechaApertura, hoy);

	        return diferencia.getYears() >= anios || diferencia.getMonths() + diferencia.getYears() * 12 >= meses;
	}
	

}
