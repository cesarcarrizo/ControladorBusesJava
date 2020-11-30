package com.cliente;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author mario
 */
public class GrupoBotones extends JPanel {
    
    private TextArea ta;
    private Boton[] botones;
    private String[] nombres = new String[]{"Bus 1", "Bus 2", "Bus 3", "Bus 4", "Bus 5", "Bus 6", "Bus 7", "Bus 8", "Bus 9", "Bus 10"};

    public GrupoBotones(TextArea ta) {
        super();
        
        this.ta = ta;
        
        this.setLayout(new GridLayout(1,10,4,4));
        for (int i = 0; i < 10; i++) {
            Boton b = new Boton(nombres[i], ta);
            this.add(b);
        }
        
        this.setBackground(Color.BLACK);

    }

}
