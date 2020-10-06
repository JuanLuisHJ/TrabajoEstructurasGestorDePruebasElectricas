package Clases;

import java.util.ArrayList;

public class TipoPrueba {
    public String Nombre;
    public String Norma;
    public ArrayList<Integer> Pruebas;
    public int NitLaboratorio;

    public TipoPrueba( String nombre, String norma, int laboratorio) {
        Nombre = nombre;
        Norma = norma;
        NitLaboratorio = laboratorio;
        Pruebas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Clases.TipoPrueba{" +
                ", Nombre='" + Nombre + '\'' +
                ", Clases.Norma=" + Norma +
                ", Pruebas=" + Pruebas +
                ", Clases.Laboratorio=" + NitLaboratorio +
                '}';
    }
}
