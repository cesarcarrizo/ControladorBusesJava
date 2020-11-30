package com.cliente;

import java.io.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mario
 */
public class EmpezarCliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        
        ///////// MAIN CLIENTE ////////// 
        SwingUtilities.invokeLater(() -> {
            Ventana v = new Ventana();

        });
    }

}
