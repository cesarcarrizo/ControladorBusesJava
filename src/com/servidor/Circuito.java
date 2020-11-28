package com.servidor;

import java.util.LinkedList;

/**
 *
 * @author Mario
 */
public class Circuito {

    private LinkedList<Bus> buses;
    private TiempoSimulado reloj;
    private boolean estaEnJornada;
    private String[] nombres;

    public Circuito() {
        // definimos los nombres de los buses a instanciar 10 en total
        nombres = new String[]{"Legendario es poco", "Vuelto parafina",
            "Ojalá salga el ventidós", "Con ella o sin ella", "Din Viesel", "BUScando la felicidad", "Soledad que mata", "Lizano Express", "Regando la salsa", "Es lo que hay"};

        buses = new LinkedList<>();
        // iniciamos los buses en sus respectivas paradas
        for (int pos = 0; pos < 10; pos++) {
            // iniciamos la parada para insertar al bus
            Paradas paradaParaInsertar = null;

            //iteramos sobre las paradas haciendo referencias con las posiciones
            for (Paradas p : Paradas.values()) {
                int posicion = p.getPosicion();
                if (posicion == pos) { // en caso de haber match se hace set a la parada
                    paradaParaInsertar = p;
                }
            }
            
            if(paradaParaInsertar == null) continue;
            
            Bus bus = new Bus(paradaParaInsertar, nombres[pos]);
            //System.out.println(bus);
            // agragamos un nuevo bus a la lista enlazada con sus correspondientes params
            buses.add(bus);
            
          
        }
        
    }
    
    
}
