package com.cliente;

import javax.swing.*;

/**
 *
 * @author mario
 */
public class Titulo extends JPanel {

    private JLabel titulo;
    private JLabel tiempo;
    private TiempoSimulado ts;

    public Titulo() {
        super();
        

        titulo = new JLabel("Este es el titulo de la aplicación.");
        tiempo = new JLabel("00:00:00");
        this.add(titulo);
        this.add(tiempo);
        
        ts = new TiempoSimulado(tiempo);
        ts.encender();
        ts.start();

    }

}
