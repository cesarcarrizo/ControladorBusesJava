package tests;

import com.servidor.Bus;
import com.servidor.Paradas;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class testBus {

    private static final Bus BUS = new Bus(Paradas.PAR00, "El bus del testeo");

    public static void main(String args[]) throws InterruptedException {

//        // 
//        Runnable snippet = () -> {
//            System.out.println(BUS);
//            BUS.salirDeParada();// en carretera...
//            try {
//                System.out.println("Saliendo...");
//                Thread.sleep(1000);
//                System.out.println("Llegando...");
//            } catch (InterruptedException ex) {
//                Logger.getLogger(testBus.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            BUS.llegarAParada();
//            System.out.println(BUS);
//        };
//        
//        Thread controller = new Thread(snippet, "testThread");
//       
//        controller.start();

            System.out.println(BUS.estaTrabajando());
            BUS.setEstaTrabajando(true);
            BUS.t.start();
            Thread.sleep(25000);
            BUS.setEstaTrabajando(false);
        
        

    }
}
