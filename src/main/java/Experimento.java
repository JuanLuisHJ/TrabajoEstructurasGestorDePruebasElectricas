
import java.io.IOException;
import java.io.Writer;
import java.util.*;
public class Experimento {
    public String TipoDeExperimento;
    public ArrayList<Muestra> Muestras;
    public String Metodo;


    public Experimento(String TipoDeExperimento, ArrayList<Muestra> Muestras, String Metodo) {
        this.TipoDeExperimento = TipoDeExperimento;
        this.Muestras = Muestras;
        this.Metodo = Metodo;
    }
}
