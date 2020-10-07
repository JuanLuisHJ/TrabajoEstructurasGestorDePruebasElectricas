package Clases;

import java.util.*;

public class Prueba {
    public String ID;
    public String Nombre;
    public String TipoPrueba;
    public int NumInforme;
    public String Clase;
    public ArrayList<String> RefDispositivos;

    public Prueba(String ID,String nombre, String tipoprueba, String clase,ArrayList<String> refDispositivos) {
        this.ID = ID;
        Nombre = nombre;
        TipoPrueba = tipoprueba;
        NumInforme = -1;
        Clase = clase;
        RefDispositivos = refDispositivos;
    }

    @Override
    public String toString() {
        List<String> ref = RefDispositivos;
        String print = "---------------------------------------------";
        print += "Prueba:                      " + "\n";
        print += "ID:                          " + ID + "." + "\n";
        print += "Nombre:                      " + Nombre + "." + "\n";
        print += "Tipo de prueba:              " + TipoPrueba + "." + "\n";
        print += "Número de informe:           " + NumInforme + "." + "\n";
        print += "Clase:                       " + Clase + "." + "\n";
        print += "Referencias de dispositivos: " + ref + "." + "\n";
        print += "---------------------------------------------";
        return print;
    }
}
