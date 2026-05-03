package edu.unl.ec;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta = null;
        int opcion;

        do {
            System.out.println("\n=== MENÚ CUENTA BANCARIA ===");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Consultar saldo e historial");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación básica para evitar que el programa falle si se ingresa texto en lugar de números
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número de cuenta: ");
                    String numCuenta = scanner.nextLine();
                    System.out.print("Ingrese nombre del titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("Ingrese saldo inicial: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, ingrese un monto válido.");
                        scanner.next();
                    }
                    double saldoInicial = scanner.nextDouble();
                    cuenta = new CuentaBancaria(numCuenta, titular, saldoInicial);
                    System.out.println("¡Cuenta creada exitosamente!");
                    break;
                case 2:
                    if (cuenta != null) {
                        System.out.print("Ingrese el monto a depositar: ");
                        double montoDeposito = scanner.nextDouble();
                        cuenta.depositar(montoDeposito);
                    } else {
                        System.out.println("Primero debe crear una cuenta.");
                    }
                    break;
                case 3:
                    if (cuenta != null) {
                        System.out.print("Ingrese el monto a retirar: ");
                        double montoRetiro = scanner.nextDouble();
                        cuenta.retirar(montoRetiro);
                    } else {
                        System.out.println("Primero debe crear una cuenta.");
                    }
                    break;
                case 4:
                    if (cuenta != null) {
                        cuenta.consultarDatos();
                        cuenta.consultarHistorial();
                    } else {
                        System.out.println("Primero debe crear una cuenta.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
