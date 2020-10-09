package Comparadores;

import Clases.Clase;
import java.util.Comparator;

public class ComparadoresClase {

    public static class ComparadorNombreClase implements Comparator<Clase> {
        @Override
        public int compare(Clase Clase1, Clase Clase2) {
            if (Clase1.Nombre.toLowerCase().compareTo(Clase2.Nombre.toLowerCase()) < 0) {
                return -1;
            } else if (Clase1.Nombre.equalsIgnoreCase(Clase2.Nombre)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorNormaClase implements Comparator<Clase> {
        @Override
        public int compare(Clase Clase1, Clase Clase2) {
            if (Clase1.Norma.toLowerCase().compareTo(Clase2.Norma.toLowerCase()) < 0) {
                return -1;
            } else if (Clase1.Norma.equalsIgnoreCase(Clase2.Norma)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorVoltajePrueba implements Comparator<Clase> {
        @Override
        public int compare(Clase Clase1, Clase Clase2) {
            if (Clase1.VoltajePrueba < Clase2.VoltajePrueba){
                return -1;
            }else if (Clase1.VoltajePrueba == Clase2.VoltajePrueba){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class ComparadorCorrientePrueba implements Comparator<Clase> {
        @Override
        public int compare(Clase Clase1, Clase Clase2) {
            if (Clase1.CorrientePrueba < Clase2.CorrientePrueba){
                return -1;
            }else if (Clase1.CorrientePrueba == Clase2.CorrientePrueba){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class ComparadorVoltajePruebaMax implements Comparator<Clase> {
        @Override
        public int compare(Clase Clase1, Clase Clase2) {
            if (Clase1.VoltajeMaximo < Clase2.VoltajeMaximo){
                return -1;
            }else if (Clase1.VoltajeMaximo == Clase2.VoltajeMaximo){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class ComparadorCorrientePruebaMax implements Comparator<Clase> {
        @Override
        public int compare(Clase Clase1, Clase Clase2) {
            if (Clase1.CorrienteMaxima < Clase2.CorrienteMaxima){
                return -1;
            }else if (Clase1.CorrienteMaxima == Clase2.CorrienteMaxima){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class ComparadorTiempoPrueba implements Comparator<Clase> {
        @Override
        public int compare(Clase Clase1, Clase Clase2) {
            if (Clase1.Tiempo < Clase2.Tiempo){
                return -1;
            }else if (Clase1.Tiempo == Clase2.Tiempo){
                return 0;
            }else{
                return 1;
            }
        }
    }
}
