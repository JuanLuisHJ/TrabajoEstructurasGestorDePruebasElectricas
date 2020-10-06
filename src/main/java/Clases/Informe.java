package Clases;

import java.util.ArrayList;

public class Informe {
    public int NumInforme;
    public int IDPrueba;
    public boolean Resultado;
    public String Comentarios;
    public double Temperatura;
    public double Humedad;
    public double Presion;

    public Informe(int NumInforme, int IDprueba, boolean resultado, String comentarios, double temperatura, double humedad,double presion) {
        this.NumInforme = NumInforme;
        IDPrueba = IDprueba;
        Resultado = resultado;
        Comentarios = comentarios;
        Temperatura = temperatura;
        Humedad = humedad;
        Presion = presion;
    }

    @Override
    public String toString() {
        return "Clases.Informe{" +
                "NumInforme=" + NumInforme +
                ", IDPrueba=" + IDPrueba +
                ", Resultado=" + Resultado +
                ", Comentarios='" + Comentarios + '\'' +
                ", Temperatura=" + Temperatura +
                ", Humedad=" + Humedad +
                ", Presion=" + Presion +
                '}';
    }
}