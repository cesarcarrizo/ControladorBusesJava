
package com.cliente;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Mario
 */
public class TiempoSimulado extends Thread {
        
    private int horas, mins, segs;
    private boolean estaFuncionando;
    private JLabel label;
    
    public TiempoSimulado(JLabel label){
        this.label = label;
        horas = 0;
        mins = 0;
        segs = 0;
        estaFuncionando = false;
    }
    
    private synchronized void tick(){
        segs++;
        if(segs > 59){
            segs = 0;
            mins++;
        }
        if(mins > 59){
            mins = 0;
            horas++;
        }
        if(horas > 23) horas = 0;

        
    }
    
    public void encender(){
        estaFuncionando = true;
    }
    
    public void apagar(){
        estaFuncionando = false;
    }
    
    
    @Override public synchronized String toString(){
        return String.format("%d:%d:%d", horas, mins, segs);
    }

    @Override public void run() {
        if(!estaFuncionando){
            System.out.println("Encienda el reloj!");
        }
        while(estaFuncionando){
            try {
                tick();
                label.setText(this.toString());
                Thread.sleep(2);
                //System.out.println(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(TiempoSimulado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
