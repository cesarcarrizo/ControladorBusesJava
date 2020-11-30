package com.servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mario
 */
public class EmpezarServidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        ServerSocket ss = new ServerSocket(9991);
//        Socket sock = ss.accept();
//
//        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
//        ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
//        System.out.println(in.readObject());
//        String msg = new Bus(Paradas.PAR00, "Bus desde el server").toString();
//        out.writeObject(msg);
//        in.close();
//        out.close();
        Circuito c = new Circuito();
        c.iniciarJornada();
        ServicioIOServidor io = new ServicioIOServidor(c);
        io.iniciar();
    }
}
