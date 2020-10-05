
import java.io.IOException;
import java.io.Writer;
import java.util.*;
public class Experimento {
    public String Nombre;//UK
    public int ID;//UK
    public String TipoDeExperimento;
    public ArrayList<Integer> Muestras;
    public String Metodo;


    public Experimento(String Nombre,int ID,String TipoDeExperimento, String Metodo) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.TipoDeExperimento = TipoDeExperimento;
        Muestras = new ArrayList<>();
        this.Metodo = Metodo;
    }

    @Override
    public String toString() {
        return "Experimento{" +
                "Nombre='" + Nombre + '\'' +
                ", ID=" + ID +
                ", TipoDeExperimento='" + TipoDeExperimento + '\'' +
                ", Cantidad de Muestras=" + Muestras.size() +
                ", Metodo='" + Metodo + '\'' +
                '}';
    }
}
