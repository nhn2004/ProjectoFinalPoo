/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;


/**
 *
 * @author nicol
 */
public class Camioneta extends Vehiculo {
    private String traccion;
    private String vidrios;
    private String transmision;

    public Camioneta(String placa, String modelo, String marca, String tipoMotor, int año, 
            double recorrido, String color, String tipoCosmbustible, double precio, int idVendedor,String traccion, 
            String vidrios, String transmision) {
        super(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCosmbustible, precio,idVendedor);
        this.traccion = traccion;
        this.vidrios = vidrios;
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }
    

    public String getVidrios() {
        return vidrios;
    }

    public String getTransmision() {
        return transmision;
    }
    
    @Override
    public String toString(){
        return (super.toString()+",/n"
                + "Vidrios = "+this.vidrios+",/n"
                + "Transmisión = "+this.transmision+",/n"
                + "Tracción = "+this.traccion);
    }
    
    @Override
    public String lineFile(){
        return super.lineFile()+"|"+this.vidrios+"|"+this.transmision+this.traccion;
    }
    
    @Override
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(this.lineFile()); 
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
}
