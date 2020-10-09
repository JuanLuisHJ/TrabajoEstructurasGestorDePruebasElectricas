package Comparadores;

import Clases.Prueba;
import java.util.Comparator;

public class ComparadoresPrueba {

    public static class ComparadorIDPrueba implements Comparator<Prueba> {
        @Override
        public int compare(Prueba Prueba1, Prueba Prueba2) {
            if (Prueba1.ID.toLowerCase().compareTo(Prueba2.ID.toLowerCase()) < 0) {
                return -1;
            } else if (Prueba1.ID.equalsIgnoreCase(Prueba2.ID)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorNombrePrueba implements Comparator<Prueba> {
        @Override
        public int compare(Prueba Prueba1, Prueba Prueba2) {
            if (Prueba1.Nombre.toLowerCase().compareTo(Prueba2.Nombre.toLowerCase()) < 0) {
                return -1;
            } else if (Prueba1.Nombre.equalsIgnoreCase(Prueba2.Nombre)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorTipopruebaPrueba implements Comparator<Prueba> {
        @Override
        public int compare(Prueba Prueba1, Prueba Prueba2) {
            if (Prueba1.TipoPrueba.toLowerCase().compareTo(Prueba2.TipoPrueba.toLowerCase()) < 0) {
                return -1;
            } else if (Prueba1.TipoPrueba.equalsIgnoreCase(Prueba2.TipoPrueba)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorNumInformePrueba implements Comparator<Prueba> {
        @Override
        public int compare(Prueba Prueba1, Prueba Prueba2){
            if (Prueba1.NumInforme < Prueba2.NumInforme){
                return -1;
            }else if (Prueba1.NumInforme == Prueba2.NumInforme){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class ComparadorClasePrueba implements Comparator<Prueba> {
        @Override
        public int compare(Prueba Prueba1, Prueba Prueba2) {
            if (Prueba1.Clase.toLowerCase().compareTo(Prueba2.Clase.toLowerCase()) < 0) {
                return -1;
            } else if (Prueba1.Clase.equalsIgnoreCase(Prueba2.Clase)) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
