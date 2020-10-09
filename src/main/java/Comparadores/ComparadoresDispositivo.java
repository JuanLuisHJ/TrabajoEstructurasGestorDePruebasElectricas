package Comparadores;
import Clases.Dispositivo;
import java.util.Comparator;

public class ComparadoresDispositivo {

    public static class ComparadorNombreDispositivo implements Comparator<Dispositivo> {
        @Override
        public int compare(Dispositivo disp1, Dispositivo disp2) {
            if (disp1.Nombre.toLowerCase().compareTo(disp2.Nombre.toLowerCase()) < 0) {
                return -1;
            } else if (disp1.Nombre.equalsIgnoreCase(disp2.Nombre)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorReferenciaDispositivo implements Comparator<Dispositivo> {
        @Override
        public int compare(Dispositivo disp1, Dispositivo disp2) {
            if (disp1.Refetencia.toLowerCase().compareTo(disp2.Refetencia.toLowerCase()) < 0) {
                return -1;
            } else if (disp1.Refetencia.equalsIgnoreCase(disp2.Refetencia)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorPotenciaNominalDispositivo implements Comparator<Dispositivo> {
        @Override
        public int compare(Dispositivo disp1, Dispositivo disp2) {
            if (disp1.PotenciaNominal < disp2.PotenciaNominal){
                return -1;
            }else if (disp1.PotenciaNominal == disp2.PotenciaNominal){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class ComparadorVoltajeNominalDispositivo implements Comparator<Dispositivo> {
        @Override
        public int compare(Dispositivo disp1, Dispositivo disp2) {
            if (disp1.VoltajeNominal < disp2.VoltajeNominal){
                return -1;
            }else if (disp1.VoltajeNominal == disp2.VoltajeNominal){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class ComparadorCorrienteNominalDispositivo implements Comparator<Dispositivo> {
        @Override
        public int compare(Dispositivo disp1, Dispositivo disp2) {
            if (disp1.CorrienteNominal < disp2.CorrienteNominal){
                return -1;
            }else if (disp1.CorrienteNominal == disp2.CorrienteNominal){
                return 0;
            }else{
                return 1;
            }
        }
    }
}