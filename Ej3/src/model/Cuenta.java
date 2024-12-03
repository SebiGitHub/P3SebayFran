package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public abstract class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L; // Añadir un identificador de versión para la serialización
    private int numero;
    private String titular;
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
    
    // Método que determina si ha pasado un mes o un año desde la última operación
    public boolean isPeriodoCumplido() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        
        Calendar calUltimaOperacion = Calendar.getInstance();
        calUltimaOperacion.setTime(fechaApertura);
        
        // Verificamos si ha pasado un mes
        boolean mesCumplido = (cal.get(Calendar.MONTH) != calUltimaOperacion.get(Calendar.MONTH));
        
        // Verificamos si ha pasado un año
        boolean anoCumplido = (cal.get(Calendar.YEAR) != calUltimaOperacion.get(Calendar.YEAR));
        
        return mesCumplido || anoCumplido;
    }

    // Método para calcular el saldo
    public boolean calcularSaldo() throws Exception {
        if (!isPeriodoCumplido()) {
            return false; // No se cumple el periodo para el cálculo
        }

        // Aquí implementamos el cálculo dependiendo del tipo de cuenta
        // Si es una cuenta de ahorro, aplicamos el interés anual
        // Si es una cuenta corriente, aplicamos la comisión mensual
        
        if (this instanceof CuentaAhorro) {
            saldo += saldo * ((CuentaAhorro) this).getInteresAnual() / 100; // Se incrementa el saldo según el interés anual
        } else if (this instanceof CuentaCorriente) {
            saldo -= ((CuentaCorriente) this).getComisionMantenimiento(); // Se decrementa el saldo por la comisión mensual
        }

        // Verificamos que el saldo no sea menor al saldo mínimo
        if (saldo < saldoMinimo) {
            throw new Exception("El saldo es inferior al saldo mínimo.");
        }

        // Actualizamos la fecha de la última operación
        fechaApertura = new Date(); // Se actualiza la fecha a la actual

        return true; // El cálculo fue exitoso
    }


    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
    	if(numero < 1001) {
    		this.numero = numero;
    	}else {
    		System.out.println("Maximo alcanzado");
    	}
        
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
    
}
