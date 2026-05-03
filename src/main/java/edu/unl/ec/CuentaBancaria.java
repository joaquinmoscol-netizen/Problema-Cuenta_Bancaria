package edu.unl.ec;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    // Atributos encapsulados
    private String numeroCuenta;
    private String titular;
    private double saldo; // Uso de punto flotante para montos
    private List<String> historial;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.historial = new ArrayList<>();

        // Validación para que el saldo inicial no sea negativo
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
            this.historial.add("Apertura de cuenta. Saldo inicial: $" + saldoInicial);
        } else {
            this.saldo = 0;
            this.historial.add("Apertura de cuenta. Saldo inicial: $0.0 (Se intentó ingresar monto negativo)");
        }
    }

    // Método para depositar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            historial.add("Depósito: $+" + monto);
            System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println("Error: No se pueden depositar montos negativos o cero.");
        }
    }

    // Método para retirar
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser mayor a cero.");
        } else if (monto > saldo) {
            System.out.println("Error: Fondos insuficientes. No se puede retirar más del saldo disponible.");
        } else {
            saldo -= monto;
            historial.add("Retiro:-" + monto);
            System.out.println("Retiro exitoso. Saldo actual: $" + saldo);
        }
    }

    // Método para consultar datos y saldo
    public void consultarDatos() {
        System.out.println("\n--- Datos de la Cuenta ---");
        System.out.println("Titular: " + titular);
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Saldo Actual: $" + saldo);
        System.out.println("--------------------------");
    }

    // Método para consultar el historial
    public void consultarHistorial() {
        System.out.println("\n--- Historial de Transacciones ---");
        if (historial.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            for (String movimiento : historial) {
                System.out.println(movimiento);
            }
        }
        System.out.println("----------------------------------");
    }
}
