import java.util.*;

public class Informe {
    public Modelo Modelo;
    public ArrayList<String> Resultados;
    public int NumeroDeGraficas;
    public int Extension;


    public Informe(Modelo Modelo, ArrayList<String> Resultados, int NumeroDeGraficas, int Extension) {
        this.Modelo = Modelo;
        this.Resultados = Resultados;
        this.NumeroDeGraficas = NumeroDeGraficas;
        this.Extension = Extension;
    }
    
}