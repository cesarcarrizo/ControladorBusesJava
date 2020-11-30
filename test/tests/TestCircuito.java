package tests;

import com.servidor.Bus;
import com.servidor.Circuito;
import com.servidor.Paradas;
import com.cliente.TiempoSimulado;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class TestCircuito {

    public static void main(String args[]) throws InterruptedException {
        Circuito c = new Circuito();
        
        

        Runnable r = () -> {
            while (c.estaEnJornada()) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestCircuito.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println(c.obtenerInfoBus(i));

                }
            }
        };

        Runnable r1 = () -> {
            c.iniciarJornada();
            try {
                Thread.sleep(100000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestCircuito.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.terminarJornada();

        };

        new Thread(r1).start();
        new Thread(r).start();

        //Thread.sleep(100000);
    }

}
