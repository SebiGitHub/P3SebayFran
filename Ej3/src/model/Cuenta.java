package model;

import java.io.Serializable;
import java.util.Date;

public abstract class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L; // Añadir un identificador de versión para la serialización
    private int numero;
    private transient String titular;
    private double saldo;
    private double saldoMinimo;
    private Date fechaApertura;

    // Constructor
    public Cuenta(int numero, String titular, double saldo, double saldoMinimo, Date fechaApertura) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.saldoMinimo = saldoMinimo;
        this.fechaApertura = fechaApertura;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) throws SaldoInferiorException {
        if (saldo < saldoMinimo) {
            throw new SaldoInferiorException("El saldo no puede ser inferior al saldo mínimo.");
        }
        this.saldo = saldo;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public abstract void calcularOperacion() throws SaldoInferiorException;
    
    public void validarSaldo() throws SaldoInferiorException {
        if (saldo < saldoMinimo) {
            throw new SaldoInferiorException("El saldo no puede ser inferior al saldo mínimo.");
        }
    }
}
