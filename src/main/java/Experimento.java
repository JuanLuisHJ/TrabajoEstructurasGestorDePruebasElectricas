
import java.io.IOException;
import java.io.Writer;
import java.util.*;
public class Experimento {
    public int ID;
    public String TipoDeExperimento;
    public ArrayList<Muestra> Muestras;
    public String Metodo;


    public Experimento(int ID,String TipoDeExperimento, String Metodo) {
        this.ID = ID;
        this.TipoDeExperimento = TipoDeExperimento;
        Muestras = new ArrayList<>();
        this.Metodo = Metodo;
    }

    public String toString(){
        String salida = "ID Experiemnto:" + ID + "{\n";
        salida += "  Tipo de experimento  = "+ TipoDeExperimento + "\n";
        salida += "  Metodo = " + Metodo + "\n";
        salida += "  Cantidad de muestras = "+ Muestras.size() + "\n";
        salida += "}\n";
        return salida;
    }
}
