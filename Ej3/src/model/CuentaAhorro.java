package model;

import java.util.Date;

public class CuentaAhorro extends Cuenta {
    private static final long serialVersionUID = 1L; // Añadir un identificador de versión para la serialización
    private static double interesAnual;
    private String beneficioAdicional;

    public CuentaAhorro(int numero, String titular, double saldo, double saldoMinimo, 
                        double interesAnual, String beneficioAdicional, Date fechaApertura) {
        super(numero, titular, saldo, saldoMinimo, fechaApertura);
        this.interesAnual = interesAnual;
        this.beneficioAdicional = beneficioAdicional;
    }

    public static double getInteresAnual() {
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
    
    @Override
    public String toString() {
        return String.format(
            "Cuenta Ahorro [Número: %d, Titular: %s, Saldo: %.2f, Saldo Mínimo: %.2f, Fecha de Apertura: %s, Interés Anual: %.2f%%, Beneficio Adicional: %s]",
            getNumero(),
            getTitular(),
            getSaldo(),
            getSaldoMinimo(),
            getFechaApertura(),
            interesAnual,
            beneficioAdicional
        );
    }

}