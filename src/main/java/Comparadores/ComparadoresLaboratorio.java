package Comparadores;
import Clases.Laboratorio;
import java.util.Comparator;

public class ComparadoresLaboratorio {

    public static class ComparadorNombreLaboratorio implements Comparator<Laboratorio> {
        @Override
        public int compare(Laboratorio Laboratorio1, Laboratorio Laboratorio2) {
            if (Laboratorio1.Nombre.toLowerCase().compareTo(Laboratorio2.Nombre.toLowerCase()) < 0) {
                return -1;
            } else if (Laboratorio1.Nombre.equalsIgnoreCase(Laboratorio2.Nombre)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorNITLaboratorio implements Comparator<Laboratorio> {
        @Override
        public int compare(Laboratorio Laboratorio1, Laboratorio Laboratorio2){
            if (Laboratorio1.NIT < Laboratorio2.NIT){
                return -1;
            }else if (Laboratorio1.NIT == Laboratorio2.NIT){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class ComparadorDireccionLaboratorio implements Comparator<Laboratorio> {
        @Override
        public int compare(Laboratorio Laboratorio1, Laboratorio Laboratorio2) {
            if (Laboratorio1.Direccion.toLowerCase().compareTo(Laboratorio2.Direccion.toLowerCase()) < 0) {
                return -1;
            } else if (Laboratorio1.Direccion.equalsIgnoreCase(Laboratorio2.Direccion)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorIDPruebaLaboratorio implements Comparator<Laboratorio> {
        @Override
        public int compare(Laboratorio Laboratorio1, Laboratorio Laboratorio2){
            if (Laboratorio1.IDprueba < Laboratorio2.IDprueba){
                return -1;
            }else if (Laboratorio1.IDprueba == Laboratorio2.IDprueba){
                return 0;
            }else{
                return 1;
            }
        }
    }
}
