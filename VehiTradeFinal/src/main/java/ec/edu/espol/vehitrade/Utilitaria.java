/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Properties;
import javafx.scene.control.Alert;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax.mail.*;
//import javax.mail.internet.*;

/**
 *
 * @author Dom
 */
class Utilitaria {
    private static final String CORREO_ENVIO = "nhncevallos@gmail.com";
    private static final String CONTRASEÑA = "olbapqxbumuxutep";

    public static Usuario buscarUsuario(String correoElectronico){
        ArrayList<Usuario> lU= Usuario.readListSer();
      
        for (Usuario u:lU){
            if (u.getCorreoElectronico().equals(correoElectronico)){
                u.vincularOfertaUsuario();
                u.vincularVehiculoUsuario();
                return u;
            }
        }
        return null;
    }

    public static void eliminarOferta( Oferta o) {
        ArrayList<Oferta> ofertas = Oferta.readListSer();
        ofertas.remove(o);
        Oferta.saveListSer(ofertas);
    }
    
    public static void eliminarVehiculo( Vehiculo v) {
        ArrayList<Vehiculo> vehiculos = Vehiculo.readListSer();
        vehiculos.remove(v);
        Vehiculo.saveListSer(vehiculos);
    }
    
    
    
    
    
    public static ArrayList<Vehiculo> filtrarAño(ArrayList<Vehiculo> vehiculos, double añoInicio, double añoFin){
        ArrayList<Vehiculo> vehFiltrados = new ArrayList<>();
        for (Vehiculo veh: vehiculos){
            if(veh.getAño()<=añoFin && veh.getAño()>=añoInicio )
                vehFiltrados.add(veh);     
        }
        return vehFiltrados;
    }
    
    public static ArrayList<Vehiculo> filtrarRecorrido(ArrayList<Vehiculo> vehiculos, double añoInicio, double añoFin){
        ArrayList<Vehiculo> vehFiltrados = new ArrayList<>();
        for (Vehiculo veh: vehiculos){
            if(veh.getAño()<=añoFin && veh.getAño()>=añoInicio )
                vehFiltrados.add(veh);     
        }
        return vehFiltrados;
    }
    
    public static ArrayList<Vehiculo> filtrarPrecio(ArrayList<Vehiculo> vehiculos, double añoInicio, double añoFin){
        ArrayList<Vehiculo> vehFiltrados = new ArrayList<>();
        for (Vehiculo veh: vehiculos){
            if(veh.getAño()<=añoFin && veh.getAño()>=añoInicio )
                vehFiltrados.add(veh);     
        }
        return vehFiltrados;
    }
    
    public static ArrayList<Vehiculo> filtrarTipoVehiculo(ArrayList<Vehiculo> vehiculos, String tipo){
        ArrayList<Vehiculo> vehFiltrados = new ArrayList<>();
        for (Vehiculo veh: vehiculos){
            if(veh.getTipoVehiculo().equals(tipo) )
                vehFiltrados.add(veh);     
        }
        return vehFiltrados;
    }

    public static void enviarCorreo(String correoDestino, String asunto, String mensaje){
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.enable", "true");
        

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(CORREO_ENVIO, CONTRASEÑA);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CORREO_ENVIO));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(correoDestino)
            );
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
            Alert a = new Alert(Alert.AlertType.INFORMATION,"Oferta aceptada correctamente!\nSu vehiculo sera vendido");
            a.show();

            

        } catch (MessagingException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR,"Error al aceptar Oferta");
            a.show();
        } 
    }
}
