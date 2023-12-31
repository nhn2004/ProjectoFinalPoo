/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dom
 */
public class Vehiculo implements Saveable,Serializable {
    private String placa;
    private String modelo;
    private String marca;
    private String tipoMotor;
    private int año;
    private double recorrido;
    private String color;
    private String tipoCosmbustible;
    private double precio;
    private int idVendedor;
    private Vendedor vendedor;
    private ArrayList<Oferta> ofertas;
    private String tipoVehiculo;
    
    public Vehiculo(){
        
    }

    public Vehiculo(String tV,String placa, String modelo, String marca, String tipoMotor, 
            int año, double recorrido, String color, String tipoCosmbustible, 
            double precio, int idVendedor) {
        this.tipoVehiculo=tV;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoMotor = tipoMotor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCosmbustible = tipoCosmbustible;
        this.precio = precio;
        this.idVendedor=idVendedor;
        this.ofertas = new ArrayList<>(); 
        
    }
    public Vehiculo(String tV,String placa, String modelo, String marca, String tipoMotor, 
            int año, double recorrido, String color, String tipoCosmbustible, 
            double precio) {
        this.tipoVehiculo=tV;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoMotor = tipoMotor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCosmbustible = tipoCosmbustible;
        this.precio = precio;
        this.ofertas = new ArrayList<>(); 
        
    }


    public int getIdVendedor() {
        return idVendedor;
    }
    

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getAño() {
        return año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public String getColor() {
        return color;
    }

    public String getTipoCosmbustible() {
        return tipoCosmbustible;
    }

    public double getPrecio() {
        return precio;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    

    @Override
    public String toString(){
        return "Este vehículo tiene:\n"
                + "Placa = "+this.placa+",\n"
                + "Marca = "+this.marca+",\n"
                + "Modelo = "+this.modelo+",\n"
                + "Tipo de motor = "+this.tipoMotor+",\n"
                + "Año = "+this.año+",\n"
                + "Recorrido = "+this.recorrido+",\n"
                + "Color = "+this.color+",\n"
                + "Tipo de combustible = "+this.tipoCosmbustible+",\n"
                + "Precio = "+this.precio;
    }
    
    public String lineFile(){
        return ""+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipoMotor+"|"+this.año+"|"+
                this.recorrido+"|"+this.color+"|"+this.tipoCosmbustible+"|"+this.precio+"|"+this.idVendedor;
    }

     @Override
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(this.lineFile());  
        } 
        catch(Exception e){
          System.out.println(e.getMessage()+"saveFileVehiculo");
        }
    }
     public  static boolean verificarPlaca(String placa) throws DigitosInvalidos{
        ArrayList<Vehiculo> lista = Vehiculo.readListSer();
        for (Vehiculo v:lista){
            if ((v.getPlaca().equals(placa)))
                return true;   
        }
        throw new DigitosInvalidos("El usuario no existe");
    }
    
      public static void saveVehiculo(Vehiculo v){
            ArrayList<Vehiculo> vehiculos = Vehiculo.readListSer(); 
            vehiculos.add(v);
            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("VehiculoSer.txt"))){
                out.writeObject(vehiculos);
            } catch(IOException e){ }
        }
      
     public static void saveListSer(ArrayList<Vehiculo> vehiculos){
            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("VehiculoSer.txt"))){
                out.writeObject(vehiculos);
            } catch(IOException e){ 
                System.out.println("No se va a guardar la lista xd");
            }
    }
     
     
     
     public static ArrayList<Vehiculo> readListSer(){
        ArrayList<Vehiculo> lista= new ArrayList<>();
        try(ObjectInputStream input= new ObjectInputStream(new FileInputStream("VehiculoSer.txt"));){
            lista = (ArrayList<Vehiculo>)input.readObject();
        } catch(IOException ioE){
            System.out.println("No se pudo abrir");
        } catch (ClassNotFoundException cE){
            System.out.println("No se encontró la clase");
        }
        return lista;
    }  
    
//    public static ArrayList<Vehiculo> readFile(){
//        ArrayList<Vehiculo> lV= new ArrayList<>();
//        try(Scanner sc= new Scanner(new File("Vehiculo.txt"))){
//            while(sc.hasNextLine()){
//                String linea= sc.nextLine();
//                String[] el=linea.split("\\|");
//                List<String> unido = Arrays.asList(el);
//                    switch (unido.size()) {
//                        case 12 -> {
//                            Auto auto= new Auto(el[0],el[1],el[2],el[3],Integer.parseInt(el[4]),
//                                    Double.parseDouble(el[5]),el[6],el[7],
//                                    Double.parseDouble(el[8]),Integer.parseInt(el[9]),el[10],el[11]);
//                            lV.add(auto);
//
//                        }
//                        case 13 -> {
//                            Camioneta camioneta= new Camioneta(el[0],el[1],el[2],el[3],Integer.parseInt(el[4]),
//                                    Double.parseDouble(el[5]),el[6],el[7],
//                                    Double.parseDouble(el[8]),Integer.parseInt(el[9]),el[10],el[11],el[12]);
//                            lV.add(camioneta);
//
//                        }
//                        default -> {
//                            Vehiculo vehiculo= new Vehiculo(el[0],el[1],el[2],el[3],Integer.parseInt(el[4]),
//                                    Double.parseDouble(el[5]),el[6],el[7],
//                                    Double.parseDouble(el[8]),Integer.parseInt(el[9]));
//                            lV.add(vehiculo);
//                        }
//
//                    }
//            }
//        }
//        catch(Exception e){
//            try{
//                File archivo = new File("Vehiculo.txt");
//                archivo.createNewFile();
//            }
//            catch(IOException a){}
//        }
//        return lV;
//    }

    
}
