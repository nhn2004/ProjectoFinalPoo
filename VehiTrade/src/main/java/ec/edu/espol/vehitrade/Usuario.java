/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.io.File;
import java.io.FileOutputStream;
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
    
    public Usuario(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
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
    
    public static void saveListSer(String nomArchivo,ArrayList<Usuario> lista){
        
    }
    public static ArrayList<Usuario> readListSer(String nomArchivo){
        return new ArrayList<>();
    }
    public static boolean validarUsuario(ArrayList<Usuario> lista,String correo,String contraseña){
        boolean validacionCorreo= false;
        boolean validacionClave= false;
        for (Usuario u:lista){
            if (u.getCorreoElectronico().equals(correo)){
                validacionCorreo=true;
                String clave=Usuario.buscarClave("UsuarioSer.txt", correo);
                if (clave.equals(contraseña)){
                    validacionClave=true;
                } else {
                    //Excepcion Contraseña INcorrecta
                }
            } else {
                //Excepcion Usuario no existe
            }
        }

        return validacionCorreo&&validacionClave;
    }
    
    
    
     public static String buscarClave(String nombreArchivo,String correoElectronico){
        ArrayList<Usuario> l= Usuario.readListSer(nombreArchivo);
        String key = "";

        for (Usuario u:l){

            if (u.getCorreoElectronico().equals(correoElectronico))
                key = u.getClave();

        }
        return key;
    }
}
