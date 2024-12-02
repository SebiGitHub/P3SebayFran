package model;

import java.util.Date;

public class Cuenta_Corriente extends Cuenta {
    private static final long serialVersionUID = 1L; // Añadir un identificador de versión para la serialización
    private double comisionMantenimiento;
    private String tipoComision;

    public Cuenta_Corriente(int numero, String titular, double saldo, double saldoMinimo, 
                           double comisionMantenimiento, String tipoComision, Date fechaApertura) {
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

    public String getTipoComision() {
        return tipoComision;
    }

    public void setTipoComision(String tipoComision) {
        this.tipoComision = tipoComision;
    }

    @Override
    public void calcularOperacion() throws SaldoInferiorException {
        setSaldo(getSaldo() - comisionMantenimiento);
    }
}
