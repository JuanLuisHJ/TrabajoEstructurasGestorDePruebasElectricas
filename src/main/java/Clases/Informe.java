package Clases;

public class Informe {
    public int IDPrueba;//numero de informe en clase prueba
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
        String print = "---------------------------------------------";
        print += "Informe: " + "\n";
        print += "Numero de informe:    " + IDPrueba + "." + "\n";
        print += "Resultado:            " + PasoNoPaso() + "." + "\n";
        print += "Comentarios:          " + Comentarios + "." + "\n";
        print += "Temperatura [°C]:     " + Temperatura + "." + "\n";
        print += "Humedad relativa [%]: " + Humedad + "." + "\n";
        print += "Presion [mmHg]:       " + Presion + "." + "\n";
        print += "---------------------------------------------";
        return print;
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