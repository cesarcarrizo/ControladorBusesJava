package com.cliente;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class EmpezarCliente {

    public static void main(String[] args) throws IOException {

        ObjectOutputStream out = null;

        try {
            Socket s = new Socket(InetAddress.getByName("localhost"), 9991);
            out = new ObjectOutputStream(s.getOutputStream());

            out.writeObject("testObject");

        } catch (UnknownHostException ex) {
            Logger.getLogger(EmpezarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpezarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }
}
