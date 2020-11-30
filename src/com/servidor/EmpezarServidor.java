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

        Circuito c = new Circuito();
        c.iniciarJornada();
        ServicioIOServidor io = new ServicioIOServidor(c);
        io.iniciar();
    }
}
