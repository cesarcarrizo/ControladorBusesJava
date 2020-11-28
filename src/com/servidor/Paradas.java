package com.servidor;

/**
 *
 * @author Mario
 */
public enum Paradas {
    
    PAR00(0, "Ciudad Deportiva Rafael Ángel Pérez", false),
    PAR01(1, "Super Lian, Hatillo", false),
    PAR02(2, "Plásticos Tosso", false),
    PAR03(3, "Parqueo De Yamuni, San Francisco", false),
    PAR04(4, "Colegio María Auxiliadora", false),
    PAR05(5, "Escuela Juan Rafael Mora", false),
    PAR06(6, "Hotel Caribbean, Amón", false),
    PAR07(7, "Parque San Francisco", false),
    PAR08(8, "Liceo Nocturno José Joaquín Jiménez Nuñez", false),
    PAR09(9, "Acueductos  Y  Alcantarillados Guadalupe", false),
    PAR10(10, "Rotonda De Betania", false),
    PAR11(11, "Colegio Salesiano Don Bosco", false),
    PAR12(12, "Escuela República Dominicana", false),
    PAR13(13, "Abastecedor Los Sauces", false),
    PAR14(14, "Parque De Monte Azul", false),
    PAR15(15, "Cevichería Costa Azul", false),
    PAR16(16, "Taller Gernon", false),
    PAR17(17, "Plaza América", false),
    PAR18(18, "Rest. La Fortuna, Hatillo 4", false),
    PAR19(19, "Terminal Hatillo", false);
    
    private final int posicion; // posicion de la parada
    private final String nombre; // nombre de la parada
    private boolean estaOcupada; // indica si hay un bus en la parada


    Paradas(int p, String n, boolean o){
        posicion = p;
        nombre = n;
        estaOcupada = o;
    }
    
    public void setOcupada(boolean bool){
        estaOcupada = bool;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPosicion(){
        return posicion;
    }
    
    public boolean estaOcupada(){
        return estaOcupada;
    }
}
    

