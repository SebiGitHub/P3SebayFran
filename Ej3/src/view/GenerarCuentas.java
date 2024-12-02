package view;

import model.Cuenta;
import model.CuentaAhorro;
import model.CuentaCorriente;
import java.io.*;
import java.util.Random;
import java.util.Date;

public class GenerarCuentas {

    public static void main(String[] args) {
        // Generar el archivo de cuentas
        generarCuentasAleatorias("cuentasPrueba.dat");
    }

    public static void generarCuentasAleatorias(String nombreArchivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            Random rand = new Random();
            
            for (int i = 0; i < 1000; i++) {
                // Generamos datos aleatorios para la cuenta
                int numeroCuenta = rand.nextInt(1000000); // Número aleatorio de cuenta
                String titular = "Titular_" + rand.nextInt(1000); // Titular aleatorio
                double saldo = rand.nextDouble() * 10000; // Saldo aleatorio entre 0 y 10000
                double saldoMinimo = rand.nextDouble() * 500; // Saldo mínimo aleatorio entre 0 y 500
                Date fechaApertura = new Date(); // Fecha de apertura actual
                
                // Decidir aleatoriamente si la cuenta es de tipo Ahorro o Corriente
                if (rand.nextBoolean()) {
                    // Cuenta Ahorro
                    double interesAnual = rand.nextDouble() * 5; // Interés anual aleatorio entre 0 y 5
                    String beneficioAdicional = "Beneficio_" + rand.nextInt(100); // Beneficio aleatorio
                    
                    CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroCuenta, titular, saldo, saldoMinimo, interesAnual, beneficioAdicional, fechaApertura);
                    out.writeObject(cuentaAhorro);
                } else {
                    // Cuenta Corriente
                    double comisionMantenimiento = rand.nextDouble() * 50; // Comisión de mantenimiento aleatoria entre 0 y 50
                    String tipoComision = "Comision_" + rand.nextInt(100); // Tipo de comisión aleatorio
                    
                    CuentaCorriente cuentaCorriente = new CuentaCorriente(numeroCuenta, titular, saldo, saldoMinimo, comisionMantenimiento, tipoComision, fechaApertura);
                    out.writeObject(cuentaCorriente);
                }
            }
            System.out.println("Archivo generado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

