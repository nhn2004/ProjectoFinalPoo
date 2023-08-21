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


/**
 *
 * @author HP
 */
public class Usuario implements Saveable,Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    private int id;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
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
    
    @Override
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(toString());  
        } 
        catch(Exception e){
          }
    }

    public static void saveListSer(ArrayList<Usuario> lista){
        try(ObjectOutputStream output= new ObjectOutputStream(new FileOutputStream("UsuarioSer.txt"));){
            output.writeObject(lista);
        } catch(IOException ioE){
        }
    }
    public static ArrayList<Usuario> readListSer(){
        ArrayList<Usuario> lista= new ArrayList<>();
        try(ObjectInputStream input= new ObjectInputStream(new FileInputStream("UsuarioSer.txt"));){
            lista = (ArrayList<Usuario>)input.readObject();
        } catch(IOException ioE){
            System.out.println("No se pudo abrir");
        } catch (ClassNotFoundException cE){
            System.out.println("No se encontró la clase");
        }
        return lista;
    }   
    
    public static void saveUser(Usuario u){
            ArrayList<Usuario> usuarios = Usuario.readListSer(); 
            usuarios.add(u);
            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UsuarioSer.txt"))){
                out.writeObject(usuarios);
            } catch(IOException e){ }
        }
    
    
    public static Usuario verificarUsuario(String correo,String contraseña) throws DigitosInvalidos{
        ArrayList<Usuario> lista = Usuario.readListSer();
        for (Usuario u:lista){
            if ((u.getCorreoElectronico().equals(correo))&&(u.getClave().equals(contraseña)))
                return u;   
        }
        throw new DigitosInvalidos("Credenciales Incorrectas");
    }
    
     public  static boolean verificarCorreo(String correo) throws DigitosInvalidos{
        ArrayList<Usuario> lista = Usuario.readListSer();
        for (Usuario u:lista){
            if ((u.getCorreoElectronico().equals(correo)))
                return true;   
        }
        throw new DigitosInvalidos("El usuario no existe");
    }
    
    
     public static String buscarClave(String correoElectronico){
        ArrayList<Usuario> l= Usuario.readListSer();
        String key = "";

        for (Usuario u:l){

            if (u.getCorreoElectronico().equals(correoElectronico))
                key = u.getClave();

        }
        return key;
    }
     
    public static int nextId(){
        int n = Usuario.readListSer().size();
        
        return n+1;
    }
}
