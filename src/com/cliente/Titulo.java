package com.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author mario
 */
public class Titulo extends JPanel {

    private JLabel titulo, status;
    private JLabel tiempo;
    private TiempoSimulado ts;

    public Titulo() {
        super();
        
        titulo = new JLabel("Simulador de Control de autobuses Periférica L1");
        tiempo = new JLabel("00:00:00");
        status = new JLabel("Conectado con el servidor.");
        
        this.setLayout(new GridLayout(3, 1));
       
        
        this.setBackground(Color.BLACK);
        
        titulo.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        tiempo.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        tiempo.setForeground(Color.WHITE);
        status.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        status.setForeground(Color.GREEN);
        status.setForeground(Color.GREEN);
        status.setForeground(Color.GREEN);
        
        this.add(titulo);
        this.add(tiempo);
        this.add(status);

        
        ts = new TiempoSimulado(tiempo);
        ts.encender();
        ts.start();

    }

}
