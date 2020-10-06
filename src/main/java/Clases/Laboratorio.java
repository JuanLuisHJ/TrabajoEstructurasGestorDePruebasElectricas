package Clases;

import java.util.ArrayList;

public class Laboratorio {
    public int NIT;
    public String Nombre;
    public String Direccion;
    public ArrayList<String> TipoPruebas;

    public Laboratorio(int NIT, String nombre, String direccion) {
        this.NIT = NIT;
        Nombre = nombre;
        Direccion = direccion;
        TipoPruebas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Laboratotio{" +
                "NIT=" + NIT +
                ", Nombre='" + Nombre + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", Tipo de Pruebas=" + TipoPruebas +
                '}';
    }
}
