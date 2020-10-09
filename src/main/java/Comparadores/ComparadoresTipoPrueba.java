package Comparadores;

import Clases.TipoPrueba;
import java.util.Comparator;

public class ComparadoresTipoPrueba {

    public static class ComparadorNombreTipoPrueba implements Comparator<TipoPrueba> {
        @Override
        public int compare(TipoPrueba TipoPrueba1, TipoPrueba TipoPrueba2) {
            if (TipoPrueba1.Nombre.toLowerCase().compareTo(TipoPrueba2.Nombre.toLowerCase()) < 0) {
                return -1;
            } else if (TipoPrueba1.Nombre.equalsIgnoreCase(TipoPrueba2.Nombre)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorRefNormaTipoPrueba implements Comparator<TipoPrueba> {
        @Override
        public int compare(TipoPrueba TipoPrueba1, TipoPrueba TipoPrueba2) {
            if (TipoPrueba1.RefNorma.toLowerCase().compareTo(TipoPrueba2.RefNorma.toLowerCase()) < 0) {
                return -1;
            } else if (TipoPrueba1.RefNorma.equalsIgnoreCase(TipoPrueba2.RefNorma)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorNitLaboratorioTipoPrueba implements Comparator<TipoPrueba> {
        @Override
        public int compare(TipoPrueba TipoPrueba1, TipoPrueba TipoPrueba2) {
            if (TipoPrueba1.NitLaboratorio < TipoPrueba2.NitLaboratorio){
                return -1;
            }else if (TipoPrueba1.NitLaboratorio == TipoPrueba2.NitLaboratorio){
                return 0;
            }else{
                return 1;
            }
        }
    }
}
