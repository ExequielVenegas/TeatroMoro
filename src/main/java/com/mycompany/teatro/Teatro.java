package com.mycompany.teatro;

import java.util.Scanner;

public class Teatro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        for (; ;) {
            System.out.println("\nBienvenido al sistema de venta del Teatro Moro");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        comprarEntrada(scanner);
                        break;
                    case 2:
                        System.out.println("Hasta luego.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();
            }
        }
    }

    public static void comprarEntrada(Scanner scanner) {
        String tipoEntrada = "";
        String tarifa = "";
        int totalPagar = 0;
        int precioEstudiante = 0;
        int precioGeneral = 0;
        String ubicacionAsiento = "";
        int edad = 0;
        boolean continuarCompra = true;

        while (continuarCompra) {
            while (true) {
                System.out.println("\nSeleccione el tipo de entrada:");
                System.out.println("1. VIP\n2. PLATEA BAJA\n3. PLATEA ALTA\n4. PALCOS\n5. Cancelar");
                System.out.print("Ingrese su opción: ");
                String opcionTipo = scanner.nextLine();

                switch (opcionTipo) {
                    case "1":
                        tipoEntrada = "VIP";
                        break;
                    case "2":
                        tipoEntrada = "PLATEA_BAJA";
                        break;
                    case "3":
                        tipoEntrada = "PLATEA_ALTA";
                        break;
                    case "4":
                        tipoEntrada = "PALCOS";
                        break;
                    case "5":
                        System.out.println("Compra cancelada.");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                        continue;
                }
                break;
            }

            while (true) {
                System.out.println("\nSeleccione la tarifa:");
                System.out.println("1. ESTUDIANTE\n2. PUBLICO GENERAL\n3. Cancelar");
                System.out.print("Ingrese su opción: ");
                String opcionTarifa = scanner.nextLine();

                switch (opcionTarifa) {
                    case "1":
                        tarifa = "ESTUDIANTE";
                        break;
                    case "2":
                        tarifa = "PUBLICO_GENERAL";
                        break;
                    case "3":
                        System.out.println("Compra cancelada.");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                        continue;
                }
                break;
            }

            while (true) {
                System.out.println("\nSeleccione la ubicación de su asiento:");
                System.out.println("Filas: A, B, C");
                System.out.println("Columnas: 1, 2, 3, 4, 5");
                System.out.print("Ingrese la ubicación (ej: A1): ");
                ubicacionAsiento = scanner.nextLine().trim().toUpperCase();

                if (ubicacionAsiento.matches("[ABC][1-5]")) {
                    break;
                } else {
                    System.out.println("Ubicación no válida. Inténtelo de nuevo (ej: A1).");
                }
            }

            System.out.println("\nPlano del Teatro (Representación Simple):");
            System.out.println("  1 2 3 4 5");
            System.out.println("A |_|_|_|_|_|");
            System.out.println("B |_|_|_|_|_|");
            System.out.println("C |_|_|_|_|_|");
            System.out.println("Usted seleccionó el asiento: " + ubicacionAsiento);

            if (tarifa.equals("ESTUDIANTE")) {
                while (true) {
                    System.out.print("Ingrese su edad: ");
                    try {
                        edad = scanner.nextInt();
                        scanner.nextLine();
                        if (edad > 0) {
                            break;
                        } else {
                            System.out.println("Edad no válida. Ingrese una edad positiva.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Entrada no válida. Por favor, ingrese un número para la edad.");
                        scanner.nextLine();
                    }
                }
            } else {
                while (true) {
                    System.out.print("Ingrese su edad (para posibles descuentos futuros): ");
                    try {
                        edad = scanner.nextInt();
                        scanner.nextLine();
                        if (edad > 0) {
                            break;
                        } else {
                            System.out.println("Edad no válida. Ingrese una edad positiva.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Entrada no válida. Por favor, ingrese un número para la edad.");
                        scanner.nextLine();
                    }
                }
            }

            switch (tipoEntrada) {
                case "VIP":
                    precioEstudiante = 20000;
                    precioGeneral = 30000;
                    break;
                case "PLATEA_BAJA":
                    precioEstudiante = 10000;
                    precioGeneral = 15000;
                    break;
                case "PLATEA_ALTA":
                    precioEstudiante = 9000;
                    precioGeneral = 18000;
                    break;
                case "PALCOS":
                    precioEstudiante = 6500;
                    precioGeneral = 13000;
                    break;
            }

            totalPagar = tarifa.equals("ESTUDIANTE") ? precioEstudiante : precioGeneral;

            System.out.println("\nResumen de la compra:");
            System.out.println("Ubicación del asiento: " + ubicacionAsiento);
            System.out.println("Edad: " + edad);
            System.out.println("Tipo de entrada: " + tipoEntrada);
            System.out.println("Tarifa: " + tarifa);
            System.out.println("Precio base: $" + (tarifa.equals("ESTUDIANTE") ? precioEstudiante : precioGeneral));

            if (tarifa.equals("ESTUDIANTE")) {
                double ahorro = precioGeneral - precioEstudiante;
                double porcentajeAhorro = (ahorro / precioGeneral) * 100;
                System.out.println("Descuento aplicado (Estudiante): $" + ahorro + " (" + String.format("%.2f", porcentajeAhorro) + "%)");
            } else {
                System.out.println("Descuento aplicado: $0 (Público General)");
            }

            System.out.println("Precio final a pagar: $" + totalPagar);
            System.out.println("Gracias por su compra, disfrute la función");

            while (true) {
                System.out.print("\n¿Desea realizar otra compra? (Sí/No): ");
                String otraCompra = scanner.nextLine().trim().toUpperCase();
                if (otraCompra.equals("NO") || otraCompra.equals("N")) {
                    continuarCompra = false;
                    break;
                } else if (otraCompra.equals("SI") || otraCompra.equals("S")) {
                    break;
                } else {
                    System.out.println("Opción no válida. Responda Sí o No.");
                }
            }
        }
    }
}