/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */

public class Oferta {
    private int id;
    private double precio;
    private Vehiculo vehiculo;
    private Comprador comprador;
    private int idComprador;
    private String placa;

    public Oferta(){

    }
    
    public Oferta(int id,double p,int idC, String placa){
        this.id=id;
        this.precio=p;
        this.idComprador=idC;
        this.placa = placa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }
    
    
    public double getPrecio() {
        return precio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    public static ArrayList<Oferta> readFile(String nombreArchivo){
        ArrayList<Oferta> lO= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Oferta oferta= new Oferta(Integer.parseInt(el[0]),Double.parseDouble(el[1]),Integer.parseInt(el[2]), el[3]);
            lO.add(oferta);
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return lO;
    }
    
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(this.id+"|"+this.precio+"|"+this.idComprador+"|"+this.placa);  
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
}