import java.util.ArrayList;
public class Descriptiva {
    public int ID;
    public int Muestra;
    public ArrayList<Integer> Inferencias;
    public String[] Centralidad_Dispersion;
    public String[] Graficos;


    public Descriptiva(int ID,int Muestra, String[] Centralidad_Dispersion, String[] Graficos) {
        this.ID = ID;
        this.Muestra = Muestra;
        Inferencias = new ArrayList<>();
        this.Centralidad_Dispersion = Centralidad_Dispersion;
        this.Graficos = Graficos;
    }
    
}