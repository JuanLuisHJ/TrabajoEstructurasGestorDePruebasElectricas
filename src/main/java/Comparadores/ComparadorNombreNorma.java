package Comparadores;
import Clases.Norma;
import java.util.Comparator;

public class ComparadorNombreNorma implements Comparator<Norma> {
    @Override
    public int compare(Norma Norma1, Norma Norma2){
        if (Norma1.Nombre.toLowerCase().compareTo(Norma2.Nombre.toLowerCase())<0){
            return -1;
        }else if (Norma1.Nombre.equalsIgnoreCase(Norma2.Nombre)){
            return 0;
        }else{
            return 1;
        }
    }
}