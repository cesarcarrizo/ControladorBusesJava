
package com.servidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class TiempoSimulado extends Thread {
        
    private int horas, mins, segs;
    private boolean estaFuncionando;
    
    public TiempoSimulado(){
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
    
    
    @Override public String toString(){
        return String.format("%d:%d:%d", horas, mins, segs);
    }

    @Override public void run() {
        if(!estaFuncionando){
            System.out.println("Encienda el reloj!");
        }
        while(estaFuncionando){
            try {
                tick();
                Thread.sleep(100);
                //System.out.println(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(TiempoSimulado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
