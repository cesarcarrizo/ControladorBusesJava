package com.cliente;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class ServicioIOCliente {

    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    private Socket s = null;
    private String comando;// string de peticion
    private String returnString = "";// info (string) de respuesta
    
    protected void setComando(String nuevoComando){
        comando = nuevoComando;
    }
    
    public String getReturnString() {
        return returnString;
    }

    public ServicioIOCliente(String comando){
        try {
            this.comando = comando;
            s = new Socket(InetAddress.getByName("localhost"), 9991);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServicioIOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioIOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void iniciar() throws IOException{
       
        try {
            out = new ObjectOutputStream(s.getOutputStream());
            out.flush();
            out.writeObject(comando);// enviando el comando
            in = new ObjectInputStream(s.getInputStream());
            returnString = (String)in.readObject();// recibiendo la info desde el servidor

        } catch (UnknownHostException ex) {
            Logger.getLogger(ServicioIOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServicioIOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
            in.close();
        }
    }

}
