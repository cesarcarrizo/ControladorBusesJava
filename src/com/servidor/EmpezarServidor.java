package com.servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class EmpezarServidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(9991);
        Socket sock = ss.accept();

        ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
        System.out.println(in.readObject());
        in.close();

    }
}
