/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.vehitrade;

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
    

//     public static void registroNuevo(){
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
//        int i= Utilitaria.nextId("Comprador.txt");
//        
//        if (Comprador.buscarClave("Comprador.txt", cE).equals("")){
//        Comprador v= new Comprador(i,nom,apellido,org,cE,key);
//        v.saveFile("Comprador.txt");
//         }
//        else{
//                System.out.println("Ese correo ya existe no se puede registar");
//                }
//         
//        }


}
