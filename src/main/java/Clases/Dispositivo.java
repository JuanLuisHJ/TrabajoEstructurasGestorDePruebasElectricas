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
        String print = "---------------------------------------------";
        print += "Dispositivo: " + "\n";
        print += "Referencia:            " + Refetencia + "." + "\n";
        print += "Nombre:                " + Nombre + "." + "\n";
        print += "Potencia nominal [VA]: " + PotenciaNominal + "." + "\n";
        print += "Voltaje nominal [V]:   " + VoltajeNominal + "." + "\n";
        print += "Corriente nominal [A]: " + CorrienteNominal + "." + "\n";
        print += "---------------------------------------------";
        return print;
    }
}
