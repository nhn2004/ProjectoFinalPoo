/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.vehitrade.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.control.Alert;


/**
 *
 * @author HP
 */
public class Usuario implements Serializable {
    private final int id;
    private String nombre;
    private String apellidos;
    private String organizacion;
    private String correoElectronico;
    private String clave;
    private ArrayList<Oferta> ofertas;
    private ArrayList<Vehiculo> vehiculos;
    
    public Usuario(String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        this.id = Usuario.nextId();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
        this.ofertas = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        
    }

    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }
    
    public void añadirVehiculo(Vehiculo v){
        this.vehiculos.add(v);
    }
    
    public void añadirOferta(Oferta o){
        this.ofertas.add(o);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    @Override
    public String toString(){
        return this.id+"|"+this.nombre+"|"+this.apellidos+"|"+this.organizacion+"|"+this.correoElectronico+"|"+this.clave;
    }
    
    public String datos(){
        return this.nombre+"\n"+this.apellidos+"\n"+this.organizacion+"\n"+this.correoElectronico;
    }

    
    public static void saveListSer(ArrayList<Usuario> lista){
        try(ObjectOutputStream output= new ObjectOutputStream(new FileOutputStream("UsuarioSer.txt"))){
            output.writeObject(lista);
        } catch(IOException ioE){
        }
    }
    public static ArrayList<Usuario> readListSer(){
        ArrayList<Usuario> lista= new ArrayList<>();
        try(ObjectInputStream input= new ObjectInputStream(new FileInputStream("UsuarioSer.txt"));){
            lista = (ArrayList<Usuario>)input.readObject();
        } catch(IOException | ClassNotFoundException ioE){
            
        }
        return lista;
    }
    public static Usuario verificarUsuario(String correo,String contraseña) throws DigitosInvalidos{
        ArrayList<Usuario> lista = Usuario.readListSer();
        Alert a = new Alert(Alert.AlertType.INFORMATION,lista.toString());
        a.show();
        for (Usuario u:lista){
            if ((u.getCorreoElectronico().equals(correo))&&(u.getClave().equals(contraseña))){
                u.setVehiculos(u.vincularVehiculoUsuario());
                u.setOfertas(u.vincularOfertaUsuario());
                return u;   
            }
        }
        throw new DigitosInvalidos("Credenciales Incorrectas");
    }
    
    public static void verificarCorreo(String correo) throws ObjetoExistente{
        ArrayList<Usuario> lista = Usuario.readListSer();
        for (Usuario u:lista){
            if ((u.getCorreoElectronico().equals(correo))){
                   throw new ObjetoExistente("Correo ya Existente");
            }
        } 
    }
    
    public static int nextId(){
        int n = Usuario.readListSer().size();
        
        return n+1;
    }
    
    public ArrayList<Oferta> vincularOfertaUsuario(){
        ArrayList<Oferta> off = Oferta.readListSer();
        ArrayList<Oferta> fin = new ArrayList<>();
        for (Oferta o: off){
            if (o.getIdUsuario()== this.getId()){
                fin.add(o);
            }
        }
        return fin;
    }
    
    public ArrayList<Vehiculo> vincularVehiculoUsuario(){
        ArrayList<Vehiculo> veh = Vehiculo.readListSer();
        ArrayList<Vehiculo> fin = new ArrayList<>();
        for (Vehiculo v: veh){
            if (v.getIdUsuario() == this.getId()){
                v.setOfertas(v.vincularOfertasVehiculo());
                fin.add(v);
            }
        }
        return fin;
    }
    
    public void updateFile(){
        ArrayList<Usuario> usuarios = Usuario.readListSer();
        Iterator<Usuario> iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            Usuario u = iterator.next();
            if (u.getId() == this.getId()) {
                iterator.remove(); // Eliminamos el elemento actual de la lista
            }
        }
        usuarios.add(this);
        Usuario.saveListSer(usuarios);
    }

    public void eliminarVehiculo(Vehiculo v){
        this.vehiculos.remove(v);
        
    }
    
    public void eliminarOferta(Oferta o){
        this.ofertas.remove(o);
        
    }
}
