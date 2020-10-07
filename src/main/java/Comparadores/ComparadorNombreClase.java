package Comparadores;

import Clases.Clase;

import java.util.Comparator;

public class ComparadorNombreClase implements Comparator<Clase> {
    @Override
    public int compare(Clase Clase1, Clase Clase2){
        if (Clase1.Nombre.toLowerCase().compareTo(Clase2.Nombre.toLowerCase())<0){
            return -1;
        }else if (Clase1.Nombre.equalsIgnoreCase(Clase2.Nombre)){
            return 0;
        }else{
            return 1;
        }
    }
}
