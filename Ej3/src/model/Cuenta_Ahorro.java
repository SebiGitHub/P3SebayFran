package model;

import java.time.LocalDate;

public class Cuenta_Ahorro extends Cuenta{
	
	private Double interesAnual;
	private String banco;
	
	public Cuenta_Ahorro(Integer numero, String titular, Double saldo, Double saldoMinimo, LocalDate fechaApertura,
			Double interesAnual, String banco) {
		super(numero, titular, saldo, saldoMinimo, fechaApertura);
		this.interesAnual = interesAnual;
		this.banco = banco;
	}

	public Double getInteresAnual() {
		return interesAnual;
	}

	public void setInteresAnual(Double interesAnual) {
		this.interesAnual = interesAnual;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	

}
