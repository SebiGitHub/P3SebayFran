package model;

import java.io.Serializable;
import java.util.Date;

public class CuentaCorriente extends Cuenta implements Serializable{
    private static final long serialVersionUID = 1L; // Añadir un identificador de versión para la serialización
    private double comisionMantenimiento;
    private Comision tipoComision;

    public CuentaCorriente(int numero, String titular, double saldo, double saldoMinimo, Date fechaApertura,
                           double comisionMantenimiento, Comision tipoComision) {
        super(numero, titular, saldo, saldoMinimo, fechaApertura);
        this.comisionMantenimiento = comisionMantenimiento;
        this.tipoComision = tipoComision;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public Comision getTipoComision() {
        return tipoComision;
    }

    public void setTipoComision(Comision tipoComision) {
        this.tipoComision = tipoComision;
    }

    @Override
    public void calcularOperacion() throws SaldoInferiorException {
        setSaldo(getSaldo() - comisionMantenimiento);
    }
    
    @Override
    public String toString() {
        return String.format(
            "Cuenta Corriente [Número: %d, Titular: %s, Saldo: %.2f, Saldo Mínimo: %.2f, Fecha de Apertura: %s, Comisión Mantenimiento: %.2f, Tipo Comisión: %s]",
            getNumero(),
            getTitular(),
            getSaldo(),
            getSaldoMinimo(),
            getFechaApertura(),
            comisionMantenimiento,
            tipoComision
        );
    }

}
