/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Dom
 */
public class Vehiculo implements Serializable {
    private String tipoVehiculo;
    private String placa;
    private String modelo;
    private String marca;
    private String tipoMotor;
    private int año;
    private double recorrido;
    private String color;
    private String tipoCosmbustible;
    private double precio;
    private int idUsuario;
    private ArrayList<Oferta> ofertas;
    
    public Vehiculo(){
        
    }

    public Vehiculo(String tipo,String placa, String modelo, String marca, String tipoMotor, 
            int año, double recorrido, String color, String tipoCosmbustible, 
            double precio, int idUsuario) {
        this.tipoVehiculo = tipo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoMotor = tipoMotor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCosmbustible = tipoCosmbustible;
        this.precio = precio;
        this.idUsuario=idUsuario;
        this.ofertas = new ArrayList<>(); 
        
    }
    


    public int getIdUsuario() {
        return idUsuario;
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


    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
    


    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
    
    public void añadirOferta(Oferta o){
        this.ofertas.add(o);
    }
    
    

    @Override
    public String toString(){
        return "Este "+this.tipoVehiculo+" tiene:\n"
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

    
     public static void saveListSer(ArrayList<Vehiculo> vehiculos){
        try(ObjectOutputStream output= new ObjectOutputStream(new FileOutputStream("VehiculoSer.txt"));){
            output.writeObject(vehiculos);
        } catch(IOException ioE){
        }
    }
    
    
    public static ArrayList<Vehiculo> readListSer(){
        ArrayList<Vehiculo> lista= new ArrayList<>();
        try(ObjectInputStream input= new ObjectInputStream(new FileInputStream("VehiculoSer.txt"));){
            lista = (ArrayList<Vehiculo>)input.readObject();
        } catch(IOException | ClassNotFoundException ioE){
            
        }
        return lista;
    }
    
    public void updateFile(){
        ArrayList<Vehiculo> vehiculos = Vehiculo.readListSer();
        Iterator<Vehiculo> iterator = vehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo v = iterator.next();
            if (v.getPlaca().equals(this.getPlaca())) {
                iterator.remove(); // Eliminamos el elemento actual de la lista
            }
        }
        vehiculos.add(this);
        Vehiculo.saveListSer(vehiculos);
        
    }
    
    public ArrayList<Oferta> vincularOfertasVehiculo(){
        ArrayList<Oferta> off = Oferta.readListSer();
        ArrayList<Oferta> fin = new ArrayList<>();
        for (Oferta o: off){
            if (o.getPlaca().equals(this.getPlaca())){
                fin.add(o);
            }
        }
        return fin;
    }
    
    public static void verificarPlaca(String placa) throws ObjetoExistente{
        ArrayList<Vehiculo> veh = Vehiculo.readListSer();
        for (Vehiculo v:veh){
            if ((v.getPlaca().equals(placa))){
                   throw new ObjetoExistente("Vehiculo ya Registrado");
            }
        } 
    }
    
    public void eliminar(){
        ArrayList<Vehiculo> vehiculos = Vehiculo.readListSer();
        Iterator<Vehiculo> iterator = vehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo v = iterator.next();
            if(v.getPlaca().equals(this.getPlaca())) {
                iterator.remove();
            }
        }
        Vehiculo.saveListSer(vehiculos);
    }
    
 
}
