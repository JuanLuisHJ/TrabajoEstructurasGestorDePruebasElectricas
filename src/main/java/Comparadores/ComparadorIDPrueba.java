package Comparadores;

import Clases.Prueba;

import java.util.Comparator;

public class ComparadorIDPrueba implements Comparator<Prueba> {
    @Override
    public int compare(Prueba Prueba1, Prueba Prueba2){
        if (Prueba1.ID.toLowerCase().compareTo(Prueba2.ID.toLowerCase())<0){
            return -1;
        }else if (Prueba1.ID.equalsIgnoreCase(Prueba2.ID)){
            return 0;
        }else{
            return 1;
        }
    }
}
