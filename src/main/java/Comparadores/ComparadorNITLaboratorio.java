package Comparadores;
import Clases.Laboratorio;
import java.util.Comparator;

public class ComparadorNITLaboratorio implements Comparator<Laboratorio> {
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