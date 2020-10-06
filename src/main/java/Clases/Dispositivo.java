package Clases;

import java.util.ArrayList;

public class Dispositivo {
    public String Refetencia;
    public String Nombre;
    public double PotenciaNominal;
    public double VoltajeNominal;
    public double CorrienteNominal;
    public ArrayList<Integer> IDPruebas;

    public Dispositivo( String referencia,String nombre, double potenciaNominal, double voltajeNominal) {
        Refetencia = referencia;
        Nombre = nombre;
        PotenciaNominal = potenciaNominal;
        VoltajeNominal = voltajeNominal;
        CorrienteNominal = PotenciaNominal/VoltajeNominal;
        IDPruebas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Clases.Dispositivo{" +
                ", Nombre='" + Nombre + '\'' +
                ", PotenciaNominal=" + PotenciaNominal +
                ", VoltajeNominal=" + VoltajeNominal +
                ", CorrienteNominal=" + CorrienteNominal +
                '}';
    }
}
