package Clases;

import java.util.ArrayList;

public class TipoPrueba {
    public String Nombre;
    public String RefNorma;
    public ArrayList<Integer> Pruebas;
    public int NitLaboratorio;

    public TipoPrueba( String nombre, String refnorma, int laboratorio) {
        Nombre = nombre;
        RefNorma = refnorma;
        NitLaboratorio = laboratorio;
        Pruebas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Clases.TipoPrueba{" +
                ", Nombre='" + Nombre + '\'' +
                ", Clases.Norma=" + RefNorma +
                ", Pruebas=" + Pruebas +
                ", Clases.Laboratorio=" + NitLaboratorio +
                '}';
    }
}
