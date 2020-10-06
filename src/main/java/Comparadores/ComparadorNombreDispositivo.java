package Comparadores;
import Clases.Dispositivo;
import java.util.Comparator;

public class ComparadorNombreDispositivo implements Comparator<Dispositivo> {
    @Override
    public int compare(Dispositivo disp1, Dispositivo disp2){
        if (disp1.Nombre.toLowerCase().compareTo(disp2.Nombre.toLowerCase())<0){
            return -1;
        }else if (disp1.Nombre.equalsIgnoreCase(disp2.Nombre)){
            return 0;
        }else{
            return 1;
        }
    }
}