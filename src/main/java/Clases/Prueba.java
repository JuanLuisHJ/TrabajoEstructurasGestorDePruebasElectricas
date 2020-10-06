package Clases;

import java.util.ArrayList;

public class Prueba {
    public int ID;
    public String Nombre;
    public String TipoPrueba;
    public int NumInforme;
    public String Clase;
    public ArrayList<String> RefDispositivos;

    public Prueba(int ID, String nombre, String tipoprueba, int Numinforme, String clase) {
        this.ID = ID;
        Nombre = nombre;
        TipoPrueba = tipoprueba;
        NumInforme = Numinforme;
        Clase = clase;
        RefDispositivos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ElementoPrueba{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Tipo de Clases.Prueba=" + TipoPrueba +
                ", Clases.Informe=" + NumInforme +
                ", Clases.Clase=" + Clase +
                '}';
    }
}
