/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenninjaalejo.Clases;

import com.mycompany.examenninjaalejo.Controladores.MisionControlador;
import com.mycompany.examenninjaalejo.Controladores.NinjaControlador;
import com.mycompany.examenninjaalejo.Percistencia.CRUD;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menus {

    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuninja() {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            try {
                System.out.println("MENU HOKAGE");
                System.out.println("1. Register nuevo nija");
                System.out.println("2. Actualizar nija");
                System.out.println("3. Listar niojas ");
                System.out.println("4. encontrar ninja ");
                System.out.println("5.Registrar Mision ");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarNinja();
                        break;
                    case 2:
                        Actualizarnija();
                        break;
                    case 3:
                        listarNinjas();
                        break;
                    case 4:
                        buscarNinmjasPorId();
                        break;
                    case 5:
                        registrarMision();
                    case 0:
                        System.out.println("Saliendo");
                        return;
                    default:
                        System.out.println("error.");
                }
            } catch (Exception e) {
                System.out.println("eror");
                scanner.nextLine();
            }
        }
    }

    public static void registrarNinja() {
        System.out.println("\n---- Registrar ninja ----");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Rango: ");
        String rango = scanner.nextLine();
        System.out.print("Aldea");
        String descripcion = scanner.nextLine();

        Ninja ninja = new Ninja(name, rango, descripcion);

        boolean result = NinjaControlador.insertNinja(ninja.getNombre(), ninja.getRango(), ninja.getAldea());
        if (result) {
            System.out.println("Ninja registrado exitosamente.");
        } else {
            System.out.println("Error al registrar.");
        }
    }

    public static void listarNinjas() {
        try {
            List<Ninja> Ninjas = NinjaControlador.listNinjas();
            if (Ninjas.isEmpty()) {
                System.out.println("No hay ninjas .");
            } else {
                for (Ninja vet : Ninjas) {
                    System.out.println(vet);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ninjas: " + e.getMessage());
        }
    }

    public static void buscarNinmjasPorId() {
        try {
            System.out.print("Ingrese el ID del ninja: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Ninja ninja = NinjaControlador.getNinjaById(id);
            if (ninja != null) {
                System.out.println(ninja);
            } else {
                System.out.println("Veterinario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar  por ID: " + e.getMessage());
        }
    }

    public static void Actualizarnija() {
        try {
            System.out.print("Ingrese el ID CNinja  ");
            int idCard = scanner.nextInt();
            Ninja vet = NinjaControlador.getNinjaById(idCard);
            if (vet != null) {
                System.out.println("\nSeleccione el atributo a actualizar:");
                System.out.println("1. Nombre");
                System.out.println("2. Rango");
                System.out.println("2. Aldea");
                System.out.println("0.  Salir ");
                System.out.print("Opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Nuevo nombre: ");
                        String name = scanner.nextLine();
                        vet.setNombre(name);
                        break;
                    case 2:
                        System.out.print("Nueva Rango: ");
                        String rango = scanner.nextLine();
                        vet.setRango(rango);
                        break;
                    case 3:
                        System.out.print("Nuevo Aldea: ");
                        String phone = scanner.nextLine();
                        vet.setAldea(phone);
                        break;

                    case 0:

                        return;
                    default:
                        System.out.println("Opción no válida.");
                        return;
                }

                boolean result = NinjaControlador.updateNinja(vet);
                if (result) {
                    System.out.println(" actualizado exitosamente.");
                } else {
                    System.out.println("Error al actualizar ");
                }
            } else {
                System.out.println("Veterinario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public static void registrarMision() {
        System.out.println("\n---- Registrar mision ----");
        System.out.print("Descripcion: ");
        String name = scanner.nextLine();
        System.out.print("Rango: ");
        String rango = scanner.nextLine();
        System.out.print("Recompensa");
        Double descripcion = scanner.nextDouble();

        Mision ninja = new Mision(name, rango, descripcion);

        boolean result = MisionControlador.insertMision(ninja.getDescripcion(), ninja.getRango(), ninja.getRecompensa());

        if (result) {
            System.out.println("Ninja registrado exitosamente.");
        } else {
            System.out.println("Error al registrar.");
        }
    }

    public static void listarMision() {
        try {
            List<Mision> Ninjas = MisionControlador.getAllMisiones();
            if (Ninjas.isEmpty()) {
                System.out.println("No hay ninjas .");
            } else {
                for (Mision vet : Ninjas) {
                    System.out.println(vet);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar misiones : " + e.getMessage());
        }
    }
    
    
//    public static void buscarNinmjasPorId() {
//        try {
//            System.out.print("Ingrese el ID del ninja: ");
//            int id = scanner.nextInt();
//            scanner.nextLine();
//            Ninja ninja = NinjaControlador.getNinjaById(id);
//            if (ninja != null) {
//                System.out.println(ninja);
//            } else {
//                System.out.println("Veterinario no encontrado.");
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al buscar  por ID: " + e.getMessage());
//        }
//    }


}
