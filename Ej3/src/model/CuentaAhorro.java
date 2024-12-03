package model;

import java.io.Serializable;
import java.util.Date;

public class CuentaAhorro extends Cuenta implements Serializable {
    private static final long serialVersionUID = 1L; // Añadir un identificador de versión para la serialización
    private double interesAnual;
    private Beneficio beneficioAdicional;

    public CuentaAhorro(int numero, String titular, double saldo, double saldoMinimo, Date fechaApertura,
                        double interesAnual, Beneficio beneficioAdicional) {
        super(numero, titular, saldo, saldoMinimo, fechaApertura);
        this.interesAnual = interesAnual;
        this.beneficioAdicional = beneficioAdicional;
    }

    // Getters y Setters
	public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }

    public Beneficio getBeneficioAdicional() {
        return beneficioAdicional;
    }

    public void setBeneficioAdicional(Beneficio beneficioAdicional) {
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