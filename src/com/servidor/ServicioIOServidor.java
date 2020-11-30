
package com.servidor;

import com.cliente.EmpezarCliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class ServicioIOServidor {
    
        private ObjectOutputStream out = null;
        private ObjectInputStream in = null;
        private ServerSocket ss = null;
        private int PORT = 9991;
        
        private Circuito c; //Circuito donde estan los nodos de con la info de los buses
        
        // este sera la cadena que indicara el cliente como comando para obtener info
        private String comando;
        
        public ServicioIOServidor(Circuito c){
            try {
                this.c = c;
                ss = new ServerSocket(PORT);
            } catch (IOException ex) {
                Logger.getLogger(ServicioIOServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void iniciar() throws IOException, ClassNotFoundException{
            System.out.println("Servidor iniciado en el puerto "+ PORT);
            while(true){
                Socket accepted = ss.accept();

                System.out.println("Cliente conectado.");
                
                // conf los streams por donde pasara la data
                in = new ObjectInputStream(accepted.getInputStream());
                //obtenemos el comando desde el cliente
                comando = (String) in.readObject();
                System.out.println("Comando desde el cliente: '"+comando+"'");
                /*
                   
                 Aca va la logica del comando (if) (?)
                
                
                */
                out = new ObjectOutputStream(accepted.getOutputStream());
                String ret = "NIY";
                if(comando.equals("Bus 1")){
                    ret = c.obtenerInfoBus(0);
                }
                if(comando.equals("Bus 2")){
                    ret = c.obtenerInfoBus(1);
                }
                if(comando.equals("Bus 3")){
                    ret = c.obtenerInfoBus(2);
                }
                if(comando.equals("Bus 4")){
                    ret = c.obtenerInfoBus(3);
                }
                if(comando.equals("Bus 5")){
                    ret = c.obtenerInfoBus(4);
                }
                if(comando.equals("Bus 6")){
                    ret = c.obtenerInfoBus(5);
                }
                if(comando.equals("Bus 7")){
                    ret = c.obtenerInfoBus(6);
                }
                if(comando.equals("Bus 8")){
                    ret = c.obtenerInfoBus(7);
                }
                if(comando.equals("Bus 9")){
                    ret = c.obtenerInfoBus(8);
                }
                if(comando.equals("Bus 10")){
                    ret = c.obtenerInfoBus(9);
                }
                
                out.writeObject(ret);
                out.flush();
                
                in.close();
                out.close();
                
                
            }
            //out = new ObjectOutputStream(s.getOutputStream());
            
        }

//        try {
//            Socket s = new Socket(InetAddress.getByName("localhost"), 9991);
//            out = new ObjectOutputStream(s.getOutputStream());
//            in = new ObjectInputStream(s.getInputStream());
//
//            out.writeObject("testObject");
//            String inStr = (String)in.readObject();
//            
//            System.out.println(inStr);
//
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(EmpezarCliente.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(EmpezarCliente.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(EmpezarCliente.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            out.close();
//            in.close();
//        }
}
