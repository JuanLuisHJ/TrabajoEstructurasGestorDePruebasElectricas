package Clases;

import java.util.ArrayList;

public class Clase {
    public String Nombre;
    public ArrayList<Integer> Pruebas;
    public String Norma;
    public double VoltajePrueba;
    public double CorrientePrueba;
    public double VoltajeMaximo;
    public double CorrienteMaxima;
    public double Tiempo;

    public Clase(String nombre, String norma, double voltajePrueba, double corrientePrueba, double voltajeMaximo, double corrienteMaxima, double tiempo) {
        Nombre = nombre;
        Norma = norma;
        VoltajePrueba = voltajePrueba;
        CorrientePrueba = corrientePrueba;
        VoltajeMaximo = voltajeMaximo;
        CorrienteMaxima = corrienteMaxima;
        Tiempo = tiempo;
        Pruebas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Clases.Clase{" +
                ", Nombre='" + Nombre + '\'' +
                ", Clases.Prueba=" + Pruebas +
                ", Clases.Norma=" + Norma +
                ", VoltajePrueba=" + VoltajePrueba +
                ", CorrientePrueba=" + CorrientePrueba +
                ", VoltajeMaximo=" + VoltajeMaximo +
                ", CorrienteMaxima=" + CorrienteMaxima +
                ", Tiempo=" + Tiempo +
                '}';
    }
}
