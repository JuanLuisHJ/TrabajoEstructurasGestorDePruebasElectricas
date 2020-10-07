package Clases;

import java.util.ArrayList;

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
        return "ElementoPrueba{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Tipo de Prueba=" + TipoPrueba +
                ", Informe=" + NumInforme +
                ", Clase=" + Clase +
                '}';
    }
}
