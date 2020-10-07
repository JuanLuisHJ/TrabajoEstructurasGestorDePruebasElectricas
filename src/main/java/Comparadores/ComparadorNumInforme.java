package Comparadores;
import Clases.Informe;
import java.util.Comparator;

public class ComparadorNumInforme implements Comparator<Informe> {
    @Override
    public int compare(Informe informe1, Informe informe2){
        if (informe1.IDPrueba < informe2.IDPrueba){
            return -1;
        }else if (informe1.IDPrueba == informe2.IDPrueba){
            return 0;
        }else{
            return 1;
        }
    }
}
