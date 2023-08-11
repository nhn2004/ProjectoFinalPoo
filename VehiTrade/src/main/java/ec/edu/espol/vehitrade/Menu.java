/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.util.Scanner;

/**
 *
 * @author nicol
 */
public class Menu {
    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Venta de Vehiculo");
        System.out.println("");
        System.out.println("1. Vendedor");
        System.out.println("2. comprador");
        int seleccion = sc.nextInt();
        switch (seleccion) {
            case 1 -> {
                Menu.menuVendedor();
                
                
                
                
            }
            case 2 -> {
                Menu.menuComprador();
                
            }

            default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
         }
        
    }
    
    public static void menuComprador(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Registrarse");
        System.out.println("2. Nueva Oferta");
        System.out.println("3. Eliminar Oferta");
        int seleccion = sc.nextInt();
        switch (seleccion) {
            case 1 -> {
                Comprador.registroNuevo();
            }
            case 2 -> {
                System.out.println("1. Auto");
                System.out.println("2. Camioneta");
                System.out.println("3. Moto");
                System.out.println("4. Todos");
                int tipo = sc.nextInt();
                switch (tipo) {
                    case 1 -> {
                        Comprador.ofertaPorVehiculo("Auto");
                    }
                    case 2 -> {
                        Comprador.ofertaPorVehiculo("Camioneta");
                    }

                    case 3 -> {
                        Comprador.ofertaPorVehiculo("Moto");
                    }
                    case 4 -> {
                        Comprador.ofertaPorVehiculo();
                    }

                    default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                }
            }
            case 3 -> {
                Comprador.erliminarOferta();
            }

            default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
         }
        System.out.println("Regresar");
                System.out.println("1. Si");
                System.out.println("2. No");
                int sel = sc.nextInt();
                switch (sel){
                        case 1 -> {
                            Menu.menuPrincipal();
                        }
                        case 2 -> {
                            Menu.menuComprador();
                        }
                        default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");

                }
    }
    
    public static void menuVendedor(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Registrarse");
        System.out.println("2. Ingresar Nuevo Vehiculo");
        System.out.println("3. Revisar Ofertas");
        int seleccion = sc.nextInt();
        switch (seleccion) {
            case 1 -> {
                Vendedor.registroNuevo();
            }
            case 2 -> {
                Vendedor.registrarNuevoVehiculo();
            }
            case 3 -> {
                Vendedor.aceptarOferta();
            }

            default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
         }
        System.out.println("Regresar");
                System.out.println("1. Si");
                System.out.println("2. No");
                int sel = sc.nextInt();
                switch (sel){
                        case 1 -> {
                            Menu.menuPrincipal();
                        }
                        case 2 -> {
                            Menu.menuVendedor();
                        }
                        default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");

                }
    }
}
