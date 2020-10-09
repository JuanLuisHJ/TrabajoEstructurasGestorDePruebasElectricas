package Comparadores;
import Clases.Norma;
import java.util.Comparator;

public class ComparadoresNorma {

    public static class ComparadorNombreNorma implements Comparator<Norma> {
        @Override
        public int compare(Norma Norma1, Norma Norma2) {
            if (Norma1.Nombre.toLowerCase().compareTo(Norma2.Nombre.toLowerCase()) < 0) {
                return -1;
            } else if (Norma1.Nombre.equalsIgnoreCase(Norma2.Nombre)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorReferenciaNorma implements Comparator<Norma> {
        @Override
        public int compare(Norma Norma1, Norma Norma2){
            if (Norma1.Referencia.toLowerCase().compareTo(Norma2.Referencia.toLowerCase())<0){
                return -1;
            }else if (Norma1.Referencia.equalsIgnoreCase(Norma2.Referencia)){
                return 0;
            }else{
                return 1;
            }
        }
    }
}