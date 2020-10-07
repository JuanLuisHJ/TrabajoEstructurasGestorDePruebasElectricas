package Clases;

import java.util.ArrayList;

public class Prueba {
    public int ID;
    public String Nombre;
    public String TipoPrueba;
    public int NumInforme;
    public String Clase;
    public ArrayList<String> RefDispositivos;

    public Prueba(int ID,String nombre, String tipoprueba, String clase) {
        this.ID = ID;
        Nombre = nombre;
        TipoPrueba = tipoprueba;
        NumInforme = -1;
        Clase = clase;
        RefDispositivos = new ArrayList<>();
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
