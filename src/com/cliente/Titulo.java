
package com.cliente;

import javax.swing.*;

/**
 *
 * @author mario
 */
public class Titulo extends JPanel {
    
    private JLabel titulo;

    public Titulo() {
        super();
        
        titulo = new JLabel("Este es el titulo de la aplicación.");
        this.add(titulo);
        
    }
    
}
