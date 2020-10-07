package Clases;
import java.util.*;

public class Clase {
    public String Nombre;
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
    }

    @Override
    public String toString() {
        return "Clases.Clase{" +
                ", Nombre='" + Nombre + '\'' +
                ", Clases.Norma=" + Norma +
                ", VoltajePrueba=" + VoltajePrueba +
                ", CorrientePrueba=" + CorrientePrueba +
                ", VoltajeMaximo=" + VoltajeMaximo +
                ", CorrienteMaxima=" + CorrienteMaxima +
                ", Tiempo=" + Tiempo +
                '}';
    }
}
