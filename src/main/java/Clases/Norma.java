package Clases;

import java.util.*;

public class Norma {
    public String Nombre;
    public String Referencia;
    public ArrayList<String> Clases;

    public Norma(String nombre, String referencia) {
        Nombre = nombre;
        Referencia = referencia;
        Clases = new ArrayList<>();
    }

    @Override
    public String toString() {
        List<String> clases = Clases;
        String print = "---------------------------------------------";
        print += "Norma:      " + "\n";
        print += "Nombre:     " + Nombre + "." + "\n";
        print += "Referencia: " + Referencia + "." + "\n";
        print += "Clases:     " + clases + "." + "\n";
        print += "---------------------------------------------";
        return print;
    }
}
