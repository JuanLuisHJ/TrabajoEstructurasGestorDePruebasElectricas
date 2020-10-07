package Clases;

import java.util.ArrayList;

public class Norma {
    public String Nombre;
    public String Referencia;
    public ArrayList<Integer> Clases;

    public Norma(String nombre, String referencia) {
        Nombre = nombre;
        Referencia = referencia;
        Clases = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Clases.Norma{" +
                ", Nombre='" + Nombre + '\'' +
                ", Referencia='" + Referencia + '\'' +
                ", Clases=" + Clases +
                '}';
    }
}
