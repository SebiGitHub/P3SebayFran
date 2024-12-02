package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Period;


public class Cuenta implements VerificacionFecha {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double SaldoMinimo;
	private LocalDate fechaApertura;
	
	
	public Cuenta() {}

	public Cuenta(Integer numero, String titular, Double saldo, Double saldoMinimo, LocalDate fechaApertura) {
		if (numero < 1 || numero > 1000) throw new IllegalArgumentException("Número fuera de rango.");
		else this.numero = numero;
        if (saldo < saldoMinimo) throw new IllegalArgumentException("Saldo inferior al saldo mínimo.");
        this.saldo = saldo;
        if (fechaApertura.isAfter(LocalDate.now())) throw new IllegalArgumentException("La fecha no puede ser futura.");
        else this.fechaApertura = fechaApertura;
        
        this.titular = titular;
        this.SaldoMinimo = saldoMinimo;
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

	
	public void setSaldo(Double saldo)throws FechaInvalidaException {
		if(saldo<SaldoMinimo)throw new FechaInvalidaException("Saldo no puede ser inferior al saldo mínimo.");
		else this.saldo = saldo;
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
	    public boolean seCumpleMes() {
	        LocalDate fechaActual = LocalDate.now();
	        // Verificar si exactamente ha transcurrido un mes
	        return ChronoUnit.MONTHS.between(fechaApertura, fechaActual) >= 1
	                && fechaActual.getDayOfMonth() >= fechaApertura.getDayOfMonth();
	    }

	    @Override
	    public boolean seCumpleAno() {
	        LocalDate fechaActual = LocalDate.now();
	        // Verificar si exactamente ha transcurrido un año
	        return ChronoUnit.YEARS.between(fechaApertura, fechaActual) >= 1
	                && fechaActual.getDayOfYear() >= fechaApertura.getDayOfYear();
	    }
	@Override
	public boolean hanPasadoTiempo(int meses, int anios) {
		   if (fechaApertura == null) {
	            throw new IllegalStateException("La fecha de apertura no está definida");
	        }

	        LocalDate hoy = LocalDate.now();
	        Period diferencia = Period.between(fechaApertura, hoy);

	        return diferencia.getYears() >= anios || diferencia.getMonths() + diferencia.getYears() * 12 >= meses;
	}
	

}
