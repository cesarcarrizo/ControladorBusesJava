package com.servidor;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class Bus implements Runnable, Serializable {

    // definimos los atrr para la parada en donde se encuentra el bus, su nombre, la parada antecesora y la proxima para a llegar
    private Paradas paradaActual, paradaProxima, paradaAnterior;
    private String nombre; // nombre del bus
    // bandera para indicar si el bus debe ir en marcha o no
    private boolean estaTrabajando;

    // tiempo que tarda llegando de una parada a otra
    private int tiempoRestante;
    private Random r = new Random();

    // Hilo que representa el bus pasando por cada una de las paradas
    public Thread t;

    // Logica para que 
    @Override
    public void run() {
        while (estaTrabajando) {
            try {
                this.salirDeParada();
                try {
                    int iteraciones = tiempoRestante;
                    for (int i = 0; i < iteraciones; i++) {
                        if(!estaTrabajando) break;
                        Thread.sleep(2);
                        tiempoRestante--;
                    }
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.llegarAParada();
                Thread.sleep(3000);// para por 3 segundos reales en la parada
            } catch (InterruptedException ex) {
                Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //sobrescribimos para obtener un string mucho mas informativo acerca del bus
    @Override
    public String toString() {
        if (this.paradaActual != null) {
            return String.format("Bus: %s\nParada anterior: %s\nParada actual: %s\nParada Siguiente: %s\nEstado: %s\nTiempo restante para siguiente parada: %d segundos\n",
                    this.nombre, this.paradaAnterior.getNombre(), this.paradaActual.getNombre(), this.paradaProxima.getNombre(), this.estaTrabajando ? "Trabajando" : "No disponible", this.tiempoRestante);
        }
        return String.format("Bus: %s\nParada anterior: %s\nParada actual: En carretera...\nParada Siguiente: %s\nEstado: %s\nTiempo restante para siguiente parada: %d segundos\n",
                this.nombre, this.paradaAnterior.getNombre(), this.paradaProxima.getNombre(), this.estaTrabajando ? "Trabajando" : "No disponible", this.tiempoRestante);
    }

    public Bus(Paradas paradaActual, String nombre) {
        this.paradaActual = paradaActual;
        this.nombre = nombre;
        estaTrabajando = false; // si esta en true esta en test mode

        configuracionInicial();

        resetTiempo();
    }

    // comentar
    private synchronized void configuracionInicial() {

        // iniciamos el thread pero no se corre
        t = new Thread(this, "BusThread[" + nombre + "]");

        //indicamos que la parada esta ocupada por el bus
        this.paradaActual.setOcupada(true);
        // obtenemos la posicion de la parada actual
        int posicion = this.paradaActual.getPosicion();
        posicion++; // se incremente para obtener la posicion de la siguiente parada
        if (posicion == 20) {// en caso de se 20 (no existe) el circuito se completa y el bus pasa a estar en la parada 0
            posicion = 0;
        }
        // con la posicion se iteran las paradas
        for (Paradas p : Paradas.values()) {
            int match = p.getPosicion();
            if (match == posicion) {
                this.paradaProxima = p;// se iguala a la proxima parada
            }
        }

        //para la parada anterior ahora debemos saltar -2 paradas
        posicion = posicion - 2;
        if (posicion == -1) {//en caso de que la posicion llegue a ser 1 (1-2 = -1(not valid!))
            posicion = 19;// pasa a la posicion correspondiente
        }
        if (posicion == -2) {// en caso de que la posicion llegue a se 0 (0-2 = -2(not valid!)
            posicion = 18;// pasa a la posicion correspondiente
        }

        // se itera sobre las paradas de nuevo
        for (Paradas p : Paradas.values()) {
            int match = p.getPosicion();
            if (match == posicion) {// al hacer match procedemos al setear la parada correspondientes
                this.paradaAnterior = p;
            }
        }
    }

    // metodo para reiniciar el tiempo que le tomara a un bus llegar a la proxima parada
    private void resetTiempo() {
        tiempoRestante = r.nextInt(10000);
    }

    public synchronized void salirDeParada() {
        // si el servicio esta en el horario de trabajo y el bus sale
        if (this.estaTrabajando) {
            // la parada donde estaba pasa a ser la anterior y se desocupa
            this.paradaActual.setOcupada(false);
            this.paradaAnterior = this.paradaActual;
            // ya que el bus esta en carretera no esta en ninguna parada
            this.paradaActual = null;
        } else {
            System.out.println("fuera de servicio");
        }
    }

    public boolean estaTrabajando() {
        return estaTrabajando;
    }

    public void setEstaTrabajando(boolean estaTrabajando) {
        this.estaTrabajando = estaTrabajando;
    }

    public synchronized void llegarAParada() {
        // primero se comprueba si el bus esta trabajando y si esta en carretera
        if (this.estaTrabajando && this.paradaActual == null) {

            // almaceno la posicion de la parada anterior para poder obtener la proxima parada
            int posicionProxima = this.paradaProxima.getPosicion();

            // se itera sobre todas las paradas
            for (Paradas p : Paradas.values()) {
                // se saca la posicion de cada una de ellas para compararla
                int match = p.getPosicion();
                // cuando hay match se hace el cambio de paradas correspondiente
                if (match == posicionProxima) {
                    this.paradaActual = p;
                    this.paradaActual.setOcupada(true);
                }
            }

            //ahora para setear correctamente la parada proxima
            // si la referencia al  el circuito vuelve a la parada cero
            if (posicionProxima == 19) {
                posicionProxima = 0;
            } else {
                posicionProxima++;// de lo contrario referencia a la siguiente parada
            }

            for (Paradas p : Paradas.values()) {
                // se saca la posicion de cada una de ellas para compararla
                int match = p.getPosicion();
                // cuando hay match se hace el cambio de paradas correspondiente
                if (match == posicionProxima) {
                    this.paradaProxima = p;
                }
            }
            resetTiempo();
        } else if (this.estaTrabajando && this.paradaActual != null) { // si esta en jornada pero esta ya en una parada...
            System.out.println("El bus " + nombre + " ya se encuentra en una parada.");
        } else { // si no esta trabajando
            System.out.println("fuera de servicio.");
        }
    }

}
