package Clases;
import java.util.*;

public class Laboratorio {
    public int NIT;
    public String Nombre;
    public String Direccion;
    public ArrayList<String> TipoPruebas;
    public int IDprueba;

    public Laboratorio(int NIT, String nombre, String direccion) {
        this.NIT = NIT;
        Nombre = nombre;
        Direccion = direccion;
        TipoPruebas = new ArrayList<>();
        IDprueba = 1;
    }

    @Override
    public String toString() {
        List<String> tipopruebas= TipoPruebas;
        String print = "---------------------------------------------";
        print += "Laboratorio:     " + "\n";
        print += "NIT:             " + NIT + "." + "\n";
        print += "Nombre:          " + Nombre + "." + "\n";
        print += "Dirección:       " + Direccion + "." + "\n";
        print += "Tipo de pruebas: " + tipopruebas + "." + "\n";
        print += "ID prueba:       " + IDprueba + "." + "\n";
        print += "---------------------------------------------";
        return print;
    }
}
