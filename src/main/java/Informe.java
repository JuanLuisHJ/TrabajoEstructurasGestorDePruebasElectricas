import java.util.ArrayList;

public class Informe {
    public int ID;
    public int Modelo;
    public ArrayList<String> Resultados;
    public int NumeroDeGraficas;
    public int Extension;


    public Informe(int ID,int Modelo, ArrayList<String> Resultados, int NumeroDeGraficas, int Extension) {
        this.ID = ID;
        this.Modelo = Modelo;
        this.Resultados = Resultados;
        this.NumeroDeGraficas = NumeroDeGraficas;
        this.Extension = Extension;
    }
    
}