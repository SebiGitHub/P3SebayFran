package view;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Random;

import controller.Lista;
import model.Beneficio;
import model.Comision;
import model.Cuenta;
import model.CuentaAhorro;
import model.CuentaCorriente;
import model.Titular;

public class GenerarCuentas {

    public static void main(String[] args) {
        completarCuentas("C:/Users/Sebas/Desktop/a.dat");
    }

    public static void completarCuentas(String nombreArchivo) {
        Lista<Cuenta> listaCuentas = new Lista<>();

        // Leer la lista existente desde el archivo
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            listaCuentas = (Lista<Cuenta>) in.readObject();  // Cargar lista serializada
        } catch (EOFException e) {
            System.out.println("Archivo vacío o fin de archivo alcanzado.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Obtener cuentas existentes y calcular cuántas faltan
        int cuentasExistentes = listaCuentas.obtenerTodos().size(); // Tamaño actual de la lista
        int totalCuentas = 100;  // Cambiado a 10 cuentas en total
        int cuentasFaltantes = totalCuentas - cuentasExistentes;

        // Generar cuentas adicionales si son necesarias
        if (cuentasFaltantes <= 0) {
            System.out.println("No se necesitan más cuentas. Total actual: " + cuentasExistentes);
            return;
        }

        Random rand = new Random();
        
        int cont = 0;

        for (int i = 0; i < cuentasFaltantes; i++) {
            int numeroCuenta = ++cont;
            String titular = Titular.values()[rand.nextInt(Titular.values().length)].getNombre();
            double saldo = rand.nextDouble() * 10000;
            double saldoMinimo = rand.nextDouble() * 500;
            Date fechaApertura = new Date();
            double interesAnual = 1 + (rand.nextDouble() * 4);
            Beneficio beneficioAdicional = Beneficio.values()[rand.nextInt(Beneficio.values().length)];
            double comisionMantenimiento = 1 + (rand.nextDouble() * 4);;
            Comision tipoComision = Comision.values()[rand.nextInt(Comision.values().length)];

            if (rand.nextBoolean()) {
                // Crear una Cuenta de Ahorro
                
                listaCuentas.agregar(new CuentaAhorro(numeroCuenta, titular, saldo, saldoMinimo, fechaApertura, interesAnual, beneficioAdicional));
            } else {
                // Crear una Cuenta Corriente
               
                listaCuentas.agregar(new CuentaCorriente(numeroCuenta, titular, saldo, saldoMinimo, fechaApertura, comisionMantenimiento, tipoComision));
            }
        }

        // Guardar la lista actualizada en el archivo
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            out.writeObject(listaCuentas);
            System.out.println("Archivo actualizado con éxito. Total de cuentas: " + totalCuentas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
