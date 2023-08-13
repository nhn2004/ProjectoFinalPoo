/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.vehitrade;

/**
 *
 * @author Dom
 */

import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor extends Usuario{
    private ArrayList<Vehiculo> vehiculos;

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Vendedor(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        super(id, nombre, apellidos, organizacion, correoElectronico, clave);
        this.vehiculos= new ArrayList<>();

    }
    
    
//    public static void registroNuevo(){
//        Scanner sc = new Scanner(System.in);
//        
//        System.out.println("Ingrese correo electrónico: ");
//        String cE= sc.nextLine();
//        System.out.println("Ingrese clave: ");
//        String key= sc.nextLine();
//        System.out.println("Ingrese nombres: ");
//        String nom= sc.nextLine();
//        System.out.println("Ingrese apellidos: ");
//        String apellido= sc.nextLine();
//        System.out.println("Ingrese organización: ");
//        String org= sc.nextLine();
//        int i= Utilitaria.nextId("Vendedor.txt");
//        if (Vendedor.buscarClave("Vendedor.txt", cE).equals("")){
//            Vendedor v= new Vendedor(i,nom,apellido,org,cE,key);
//            v.saveFile("Vendedor.txt");
//        }
//        else{
//            System.out.println("Ese correo ya existe no se puede registar");
//        } 
//    }
//
//    
//    public static ArrayList<Vehiculo> searchByIDS(int idVendedor){ 
//        ArrayList<Vehiculo> veh = Vehiculo.readFile();
//        System.out.println(veh.get(0));
//        ArrayList<Vehiculo> nuevaL= new ArrayList<>();  
//        for (Vehiculo v: veh){
//            if (v.getIdVendedor() == idVendedor)
//                nuevaL.add(v);
//            
//        }
//        return nuevaL;
//    }
//    
//    public static ArrayList<Vendedor> readFile(String nombreArchivo){
//        ArrayList<Vendedor> lV= new ArrayList<>();
//        try(Scanner sc= new Scanner(new File(nombreArchivo))){
//            while(sc.hasNextLine()){
//                String linea= sc.nextLine();
//                String[] el=linea.split("\\|");
//                Vendedor vende= new Vendedor(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5]);    
//                lV.add(vende);
//            }
//        }
//        catch(Exception e){
//          
//        }
//        return lV;
//    }
//    
//    public static String buscarClave(String nombreArchivo,String correoElectronico){
//        ArrayList<Vendedor> lV= Vendedor.readFile(nombreArchivo);
//        String key = "";
//
//        for (Vendedor v:lV){
//
//            if (v.getCorreoElectronico().equals(correoElectronico))
//                key = v.getClave();
//
//        }
//        return key;
//    }

//    public static void registrarNuevoVehiculo(){
//       Scanner sc= new Scanner(System.in);
//
//       System.out.println("Ingrese su correo electrónico: ");
//       String cE= sc.nextLine();
//       String claveSistema= Vendedor.buscarClave("Vendedor.txt",cE);
//       System.out.println("Ingrese su clave: ");
//       String clave= sc.nextLine();
//       boolean validacionClave= Utilitaria.validarClave(claveSistema, clave);
//       if (validacionClave==true){
//           Vendedor v1= Utilitaria.buscarVendedor(cE);
//           Utilitaria.vincularVehiculos(v1);
//           System.out.print("Ingrese la placa: ");
//           String placa = sc.nextLine();
//           boolean validacion=true;
//
//           if(v1.getVehiculos().size()>0){
//               for (Vehiculo v:v1.getVehiculos()){
//          if (!(placa.equals(v.getPlaca()))){
//            validacion=false;}
//           }
//           }
//           else
//               validacion = false;
//
//
//
//        if (validacion==false){
//           System.out.println("Ingrese el tipo de Vehículo a registrar: ");
//          String t= sc.nextLine();
//
//            System.out.print("Ingrese la marca: ");
//          String marca = sc.nextLine();
//
//          System.out.print("Ingrese el modelo: ");
//          String modelo = sc.nextLine();
//
//          System.out.print("Ingrese el tipo de motor: ");
//          String tipoMotor = sc.nextLine();
//
//          System.out.print("Ingrese el año: ");
//          int año = sc.nextInt();
//          sc.nextLine();
//          System.out.print("Ingrese el recorrido: ");
//          int recorrido = sc.nextInt();
//          sc.nextLine();
//          System.out.print("Ingrese el color: ");
//          String color = sc.nextLine();
//          System.out.print("Ingrese el tipo de combustible: ");
//          String tipoCombustible = sc.nextLine();
//          System.out.print("Ingrese el precio: ");
//          double precio = sc.nextDouble();
//          sc.nextLine(); 
//
//         String tipo= t.toLowerCase();
//          switch (tipo){
//            case "camioneta" -> {
//                System.out.print("Ingrese la tracción: ");
//                String traccion = sc.nextLine();
//                System.out.print("Ingrese los vidrios: ");
//                String vidrios = sc.nextLine();
//                System.out.print("Ingrese la transmisión: ");
//                String transmision = sc.nextLine();
//                Camioneta c= new Camioneta(placa, modelo, marca,
//                        tipoMotor, año, recorrido, color, tipoCombustible,
//                        precio,v1.getId(),traccion, vidrios, transmision);
//                c.saveFile("Vehiculo.txt");
//                v1.getVehiculos().add(c);
//                   }
//            case "auto" -> {
//                System.out.print("Ingrese los vidrios: ");
//                String vid = sc.nextLine();
//                System.out.print("Ingrese la transmisión: ");
//                String transm = sc.nextLine();
//                Auto a= new Auto(placa, modelo, marca,
//                        tipoMotor, año, recorrido, color,
//                        tipoCombustible, precio,v1.getId(),vid, transm);
//                a.saveFile("Vehiculo.txt");
//                v1.getVehiculos().add(a);
//                   }
//            case "moto" -> {
//                Vehiculo m= new Vehiculo(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCombustible, precio,v1.getId());
//                m.saveFile("Vehiculo.txt");
//                v1.getVehiculos().add(m);
//                   }
//             }
//
//             }
//       } else {
//           System.out.println("Usuario o contraseña incorrecta.");
//       }
//    }

 
//    public static void aceptarOferta(){
//       Scanner sc= new Scanner(System.in);
//       System.out.println("Ingrese su correo electrónico: ");
//       String cE= sc.nextLine();
//       String claveSistema= Vendedor.buscarClave("Vendedor.txt",cE);
//       System.out.println("Ingrese su clave: ");
//       String clave= sc.nextLine();
//       boolean validacionClave= Utilitaria.validarClave(claveSistema, clave);
//       if (validacionClave==true){
//           Vendedor v1= Utilitaria.buscarVendedor(cE);
//           Utilitaria.vincularVehiculos(v1);
//           System.out.println("Ingrese la placa: ");
//           String placa= sc.nextLine();
//
//           Vehiculo v= Utilitaria.filtrarPorPlaca(placa,v1.getVehiculos());
//           System.out.println(""+v.getMarca()+" "+v.getModelo()+" Precio: "+v.getPrecio());
//           int tamaño= v.getOfertas().size();
//           if (tamaño>0){
//           int seleccion;
//           Oferta oferta;
//           int i=0;
//           do{
//             System.out.println("Oferta "+(i+1)+":");
//
//             oferta= v.getOfertas().get(i);  
//             System.out.println("Correo: "+oferta.getComprador().getCorreoElectronico());
//             System.out.println("Precio "+oferta.getPrecio());
//             if (tamaño>0 && i==0){
//               System.out.println("1.- Siguiente Oferta");
//               System.out.println("2.- Aceptar Oferta");
//             }
//             else if(tamaño>i){
//               System.out.println("1.- Siguiente Oferta");
//               System.out.println("2.- Aceptar Oferta");
//               System.out.println("3.- Anterior Oferta");
//             }
//             else{
//               System.out.println("2.- Aceptar Oferta");
//               System.out.println("3.- Anterior Oferta");
//             }
//             seleccion= sc.nextInt();
//             System.out.println("");
//             switch (seleccion) {
//                       case 1 -> {
//                           i++;
//                           if (i >= tamaño) {
//                               System.out.println("Has revisado todos los vehículos.");
//                               i--;
//                           }
//                   }
//                       case 2 -> {
//                           String mensaje= "Hola soy "+v.getVendedor().getNombre()+",\n"+"Es un placer hacer negocios contigo, mi "+v.getMarca()+" "+v.getModelo()+" pronto será tuyo, enviame un correo a "+v.getVendedor().getCorreoElectronico()+" para hablar";
//                           String asunto= "¡"+v.getVendedor().getNombre()+" acepto tu oferta!";
//                           Utilitaria.enviarCorreo(oferta.getComprador().getCorreoElectronico(), asunto, mensaje);
//                           Utilitaria.eliminarVehiculo("Vehiculo.txt", placa);
//                       }
//
//                       case 3 -> {
//                           i--;
//                           if (i < 0) {
//                               System.out.println("Ya estás en el primer vehículo.");
//                               i++;
//                           } 
//                   }
//                       default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
//                   }
//
//           }while (seleccion != 2);
//           }
//           else
//               System.out.println("No tienes ofertas para tu vehiculo con placa "+placa);
//       } else {
//           System.out.println("Usuario o contraseña incorrecta.");
//       }
//
//   }

 }

