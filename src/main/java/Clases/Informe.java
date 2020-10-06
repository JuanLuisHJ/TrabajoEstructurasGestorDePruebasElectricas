package Clases;

import java.util.ArrayList;

public class Informe {
    public int IDPrueba;
    public boolean Resultado;
    public String Comentarios;
    public double Temperatura;
    public double Humedad;
    public double Presion;

    public Informe(int IDprueba, boolean resultado, String comentarios, double temperatura, double humedad,double presion) {
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
                ", IDPrueba=" + IDPrueba +
                ", Resultado=" + Resultado +
                ", Comentarios='" + Comentarios + '\'' +
                ", Temperatura=" + Temperatura +
                ", Humedad=" + Humedad +
                ", Presion=" + Presion +
                '}';
    }
    public String PasoNoPaso(){
        if (Resultado){
            return "Pasó";
        }
        else{
            return "No Pasó";
        }
    }
}