package Clases;

import java.util.ArrayList;

public class Norma {
    public String Nombre;
    public String Referencia;
    public String TipoPrueba;
    public ArrayList<Integer> Clases;

    public Norma(String nombre, String referencia, String tipoprueba) {
        Nombre = nombre;
        Referencia = referencia;
        TipoPrueba = tipoprueba;
        Clases = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Clases.Norma{" +
                ", Nombre='" + Nombre + '\'' +
                ", Referencia='" + Referencia + '\'' +
                ", Tipo de Clases.Prueba=" + TipoPrueba +
                ", Clases=" + Clases +
                '}';
    }
}
