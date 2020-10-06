package Comparadores;


import Clases.TipoPrueba;
import java.util.Comparator;

public class ComparadorNombreTipoPrueba implements Comparator<TipoPrueba> {
    @Override
    public int compare(TipoPrueba TipoPrueba1, TipoPrueba TipoPrueba2){
        if (TipoPrueba1.Nombre.toLowerCase().compareTo(TipoPrueba2.Nombre.toLowerCase())<0){
            return -1;
        }else if (TipoPrueba1.Nombre.equalsIgnoreCase(TipoPrueba2.Nombre)){
            return 0;
        }else{
            return 1;
        }
    }
}
