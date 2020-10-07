package Clases;

import java.util.ArrayList;
import java.util.List;

public class TipoPrueba {
    public String Nombre;
    public String RefNorma;
    public ArrayList<String> Pruebas;
    public int NitLaboratorio;

    public TipoPrueba( String nombre, String refnorma, int laboratorio) {
        Nombre = nombre;
        RefNorma = refnorma;
        NitLaboratorio = laboratorio;
        Pruebas = new ArrayList<>();
    }

    @Override
    public String toString() {
        List<String> pruebass = Pruebas;
        String print = "---------------------------------------------";
        print += "Tipo de prueba:         " + "\n";
        print += "Nombre:                 " + Nombre + "." + "\n";
        print += "Referencia de la norma: " + RefNorma + "." + "\n";
        print += "Pruebas:                " + pruebass + "." + "\n";
        print += "NIT del laboratorio:    " + NitLaboratorio + "." + "\n";
        print += "---------------------------------------------";
        return print;
    }
}
