import java.util.ArrayList;
import java.util.Arrays;

public class Descriptiva {
    public int ID;
    public int Muestra;
    public int Inferencia;
    public String[] Centralidad_Dispersion;
    public String[] Graficos;


    public Descriptiva(int ID, int Muestra, String[] Centralidad_Dispersion, String[] Graficos) {
        this.ID = ID;
        this.Muestra = Muestra;
        this.Centralidad_Dispersion = Centralidad_Dispersion;
        this.Graficos = Graficos;
    }

    public String toString(){
        String salida = "ID Descriptiva:" + ID + "{\n";
        salida += "  Tipo de muestra  = "+ Muestra + "\n";
        salida += "  Inferencia de la descriptiva = " + Inferencia + "\n";
        salida += "  Centralidad y dispersion = "+ Arrays.toString(Centralidad_Dispersion) + "\n";
        salida += "  Graficos = " + Arrays.toString(Graficos) + "\n";
        salida += "}\n";
        return salida;
    }
}