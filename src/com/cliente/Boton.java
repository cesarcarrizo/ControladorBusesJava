package com.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Mario
 */
public class Boton extends JButton implements ActionListener {

    private String busString;
    private TextArea ta;
    private ServicioIOCliente io;
    private boolean renderizando;

    public Boton(String text, TextArea ta) {
        super(text);
        diseno();
        this.ta = ta;
        addActionListener(this);
    }

    private void diseno() {
        this.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        this.setForeground(Color.WHITE);
        this.setBackground(Color.RED);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean done = false;

        JButton b = (JButton) e.getSource();
        Handler h = new Handler(b, b.getText());
        h.start();

    }

    // esta vlase permite que haya un manejo serial sobre los threads de peticion para obtener la info de los buses
    class Handler extends Thread {

        JButton b;
        String text;

        public Handler(JButton b, String text) {
            this.b = b;
            this.text = text;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2);
                    io = new ServicioIOCliente(text);
                    io.iniciar();
                    ta.logErase(io.getReturnString());// muestro la ddat en el gui
                } catch (IOException ex) {
                    Logger.getLogger(Boton.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Boton.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!b.isFocusOwner()) {
                    break;
                }
            }
            System.out.println("Thread dead");
        }

    }

}
