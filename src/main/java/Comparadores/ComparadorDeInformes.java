package Comparadores;
import Clases.Informe;
import java.util.Comparator;

public class ComparadorDeInformes implements Comparator<Informe> {
    String Parametro;
    public ComparadorDeInformes(String Parametro) {
        this.Parametro=Parametro;
    }
    @Override
    public int compare(Informe informe1, Informe informe2){
        if (Parametro.equals("IDPrueba")){
            return informe1.IDPrueba - informe2.IDPrueba;
        }
        // CUIDADO AQUÍ MI PAPA
        else if(Parametro.equals("Resultado")){
            if (informe1.Resultado==true && informe2.Resultado==false){
                return -1;
            } else if (informe1.Resultado==informe2.Resultado){
                return 0;
            }
            else {
                return 1;
            }
        }
        else if (Parametro.equals("Comentarios")){
            if (informe1.Comentarios./*toLowerCase().*/compareTo(informe2.Comentarios)<0){
                return -1;
            } else if (informe1.Comentarios.equalsIgnoreCase(informe2.Comentarios)){
                return 0;
            }
            else {
                return 1;
            }
        }
        else if (Parametro.equals("Temperatura")){
            if (informe1.Temperatura < informe2.Temperatura){
                return -1;
            } else if (informe1.Temperatura==informe2.Temperatura){
                return 0;
            }
            else {
                return 1;
            }
        }
        else if (Parametro.equals("Humedad")){
            if (informe1.Humedad < informe2.Humedad){
                return -1;
            } else if (informe1.Humedad==informe2.Humedad){
                return 0;
            }
            else {
                return 1;
            }
        }
        else if (Parametro.equals("Presion")){
            if (informe1.Presion < informe2.Presion){
                return -1;
            } else if (informe1.Presion==informe2.Presion){
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            return 0;
        }
    }

}
