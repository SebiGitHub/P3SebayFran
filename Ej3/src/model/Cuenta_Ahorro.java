package model;

import java.util.Date;

public class Cuenta_Ahorro extends Cuenta {
    private static final long serialVersionUID = 1L; // Añadir un identificador de versión para la serialización
    private double interesAnual;
    private String beneficioAdicional;

    public Cuenta_Ahorro(int numero, String titular, double saldo, double saldoMinimo, 
                        double interesAnual, String beneficioAdicional, Date fechaApertura) {
        super(numero, titular, saldo, saldoMinimo, fechaApertura);
        this.interesAnual = interesAnual;
        this.beneficioAdicional = beneficioAdicional;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }

    public String getBeneficioAdicional() {
        return beneficioAdicional;
    }

    public void setBeneficioAdicional(String beneficioAdicional) {
        this.beneficioAdicional = beneficioAdicional;
    }

    @Override
    public void calcularOperacion() throws SaldoInferiorException {
        double incremento = getSaldo() * (interesAnual / 100);
        setSaldo(getSaldo() + incremento);
    }
}
