package com.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author mario
 */
public class Ventana extends JFrame {

    private TextArea ta; // output de la informacion
    private GrupoBotones gb;// input del usuario
    private Titulo t;
    private boolean iniciarConexion;
    
    public Ventana() {
        // inicializam//os la clase de la cual hereda para obtener sus propiendades
        super("Circuito Periférica L1");// llamamos al constructor que toma como param el titulo de la ventana
        this.setEnabled(false);
        
        // validacion y autenticacion simple
        String res = JOptionPane.showInputDialog(this, "Ingrese password para conectar con el servidor:", "CONEXIÓN hacia localhost:9991", JOptionPane.QUESTION_MESSAGE);
        if(!res.equals("conn")){
            JOptionPane.showMessageDialog(this, "VALIDACIÓN INCORRECTA! INTENTE DE NUEVO MAS TARDE.");
            iniciarConexion = false;
            System.exit(0);
        };
        iniciarConexion = true;
        this.setEnabled(true);
        initConfig();
        colocarComponentes();

    }

    private void initConfig() {
        this.setBounds(200, 100, 1000, 300);// config de las dimensiones de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// config para que el programa se acabe cuando se de click en la equis
        this.setLayout(new BorderLayout());// definimos el tipo de diseno que va a tener (distribucion de los paneles)
        this.setVisible(true);// hacemos aparecer el componente
        
        this.setBackground(Color.BLACK);
    }

    private synchronized void colocarComponentes() {
        ta = new TextArea();
        gb = new GrupoBotones(ta);
        t = new Titulo();
        
        this.add(ta, BorderLayout.CENTER);
        this.add(gb, BorderLayout.SOUTH);
        this.add(t, BorderLayout.NORTH);
    }

}
