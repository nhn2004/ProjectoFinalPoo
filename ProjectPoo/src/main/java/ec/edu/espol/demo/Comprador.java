/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Comprador extends Usuario{

  private ArrayList<Oferta> ofertas;

    public Comprador(int id, String nombre, String apellidos, String organizacion, 
            String correoElectronico, String clave) {
        super(id, nombre, apellidos, organizacion, correoElectronico, clave);
        this.ofertas=new ArrayList<>();
    }
    

     public static void registroNuevo(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese correo electrónico: ");
        String cE= sc.nextLine();
        System.out.println("Ingrese clave: ");
        String key= sc.nextLine();
        System.out.println("Ingrese nombres: ");
        String nom= sc.nextLine();
        System.out.println("Ingrese apellidos: ");
        String apellido= sc.nextLine();
        System.out.println("Ingrese organización: ");
        String org= sc.nextLine();
        int i= Utilitaria.nextId("Comprador.txt");
        
        if (Comprador.buscarClave("Comprador.txt", cE).equals("")){
        Comprador v= new Comprador(i,nom,apellido,org,cE,key);
        v.saveFile("Comprador.txt");
         }
        else{
                System.out.println("Ese correo ya existe no se puede registar");
                }
         
        }
    
    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }


  
  public static ArrayList<Comprador> readFile(String nombreArchivo){
        ArrayList<Comprador> lC= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Comprador comprador= new Comprador(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5]);    
            lC.add(comprador);
          }
        }
        catch(Exception e){
          
        }
        return lC;
    }
    
public static String buscarClave(String nombreArchivo,String correoElectronico){
        ArrayList<Comprador> lC= Comprador.readFile(nombreArchivo);
        String clave= "";
        for (Comprador c:lC){
            if (c.getCorreoElectronico().equals(correoElectronico))
                clave=c.getClave();
        }
    return clave;
    }



    public static void ofertaPorVehiculo(String tipovehiculo){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese su correo electrónico: ");
        String cE= sc.nextLine();
        String claveSistema= Vendedor.buscarClave("Comprador.txt",cE);
        System.out.println("Ingrese su clave: ");
        String clave= sc.nextLine();
        boolean validacionClave= Utilitaria.validarClave(claveSistema, clave);
        if (validacionClave==true){
            Comprador c = Utilitaria.buscarComprador(cE);
            Utilitaria.vincularOfertas(c);    
            
            System.out.println("Recorrido Inicio: ");
            double ri = sc.nextDouble();
            System.out.println("Recorrido Fin: ");
            float rf = sc.nextFloat();
            System.out.println("Año Inicio: ");
            int ai = sc.nextInt();
            System.out.println("Año Fin: ");
            int af = sc.nextInt();
            System.out.println("Precio Inicio: ");
            double pi = sc.nextDouble();
            System.out.println("Precio Fin: ");
            float pf = sc.nextFloat();
             ArrayList<Vehiculo> vehiculos = Vehiculo.readFile();
            ArrayList<Vehiculo> vehiculosBuscados = Utilitaria.filtrarVehiculos(vehiculos,tipovehiculo, 
                    ri, rf, ai, af, pi, pf);
            Vehiculo vehiculoSeleccionado = Utilitaria.navegar(vehiculosBuscados);
            if ( vehiculoSeleccionado != null){
            System.out.println("Ingrese la oferta por el vehiculo elegido: ");
            double monto = sc.nextDouble();
            int idOffer = Utilitaria.nextId("Oferta.txt");
            
            Oferta oferta = new Oferta(idOffer, monto, c.getId(), vehiculoSeleccionado.getPlaca());
            oferta.setComprador(c); 
            oferta.saveFile("Oferta.txt");
            }
        } else {
            System.out.println("Usuario o clave incorrecta.");
        }
    }

    public static void ofertaPorVehiculo(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese su correo electrónico: ");
        String cE= sc.nextLine();
        String claveSistema= Vendedor.buscarClave("Comprador.txt",cE);
        System.out.println("Ingrese su clave: ");
        String clave= sc.nextLine();
        boolean validacionClave= Utilitaria.validarClave(claveSistema, clave);
        if (validacionClave==true){
            Comprador c = Utilitaria.buscarComprador(cE);
            Utilitaria.vincularOfertas(c);
            System.out.println("Recorrido Inicio: ");
            double ri = sc.nextDouble();
            System.out.println("Recorrido Fin: ");
            float rf = sc.nextFloat();
            System.out.println("Año Inicio: ");
            int ai = sc.nextInt();
            System.out.println("Año Fin: ");
            int af = sc.nextInt();
            System.out.println("Precio Inicio: ");
            double pi = sc.nextDouble();
            System.out.println("Precio Fin: ");
            float pf = sc.nextFloat();
            ArrayList<Vehiculo> vehiculos = Vehiculo.readFile();
            ArrayList<Vehiculo> vehiculosBuscados = Utilitaria.filtrarVehiculos(vehiculos, 
                    ri, rf, ai, af, pi, pf);
            Vehiculo vehiculoSeleccionado = Utilitaria.navegar(vehiculosBuscados);

            System.out.println("Ingrese la oferta por el vehiculo elegido: ");
            double monto = sc.nextDouble();
            int idOffer = Utilitaria.nextId("Oferta.txt");
            Oferta oferta = new Oferta(idOffer, monto, c.getId(), vehiculoSeleccionado.getPlaca());
            oferta.setComprador(c); 
            oferta.saveFile("Oferta.txt");
        } else {
            System.out.println("Usuario o clave incorrecta.");
        }
    }
    
    public static void erliminarOferta(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese su correo electrónico: ");
        String cE= sc.nextLine();
        String claveSistema= Vendedor.buscarClave("Comprador.txt",cE);
        System.out.println("Ingrese su clave: ");
        String clave= sc.nextLine();
        boolean validacionClave= Utilitaria.validarClave(claveSistema, clave);
        if (validacionClave==true){
            Comprador c = Utilitaria.buscarComprador(cE);
            Utilitaria.vincularOfertas(c);
            int tamaño= c.getOfertas().size();
            if (tamaño<0){
            int seleccion;
            Oferta oferta;
            int i=0;
            do{
              System.out.println("Oferta "+(i+1)+":");

              oferta= c.getOfertas().get(i);  
              System.out.println("Placa: "+oferta.getPlaca());
              System.out.println("Precio "+oferta.getPrecio());
              if (tamaño>0 && i==0){
                System.out.println("1.- Siguiente Oferta");
                System.out.println("2.- Eliminar Oferta");
              }
              else if(tamaño>i){
                System.out.println("1.- Siguiente Oferta");
                System.out.println("2.- Eliminar Oferta");
                System.out.println("3.- Anterior Oferta");
              }
              else{
                System.out.println("2.- Eliminar Oferta");
                System.out.println("3.- Anterior Oferta");
              }
              seleccion= sc.nextInt();
              System.out.println("");
              switch (seleccion) {
                        case 1 -> {
                            i++;
                            if (i >= tamaño) {
                                System.out.println("Has revisado todos los vehículos.");
                                i--;
                            }
                    }
                        case 2 -> {
                            System.out.println("Haz eliminado esta oferta");
                            c.getOfertas().remove(i);
                            Utilitaria.eliminarOferta(oferta);
                        }

                        case 3 -> {
                            i--;
                            if (i < 0) {
                                System.out.println("Ya estás en el primer vehículo.");
                                i++;
                            } 
                    }
                        default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    }

            }while (seleccion != 2);
            }
            else
                System.out.println("No tienes ninguna oferta. Aún!!!"); 
        } else {
            System.out.println("Usuario o clave incorrecta.");
        }
    }
}
