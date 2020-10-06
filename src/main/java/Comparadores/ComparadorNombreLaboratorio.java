package Comparadores;
import Clases.Laboratorio;
import java.util.Comparator;

public class ComparadorNombreLaboratorio implements Comparator<Laboratorio> {
    @Override
    public int compare(Laboratorio Laboratorio1, Laboratorio Laboratorio2){
        if (Laboratorio1.Nombre.toLowerCase().compareTo(Laboratorio2.Nombre.toLowerCase())<0){
            return -1;
        }else if (Laboratorio1.Nombre.equalsIgnoreCase(Laboratorio2.Nombre)){
            return 0;
        }else{
            return 1;
        }
    }
}
