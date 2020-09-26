import java.util.ArrayList;
public class Descriptiva {
    public Muestra Muestra;
    public ArrayList<Inferencial> Inferencias;
    public String[] Centralidad_Dispersion;
    public String[] Graficos;


    public Descriptiva(Muestra Muestra, ArrayList<Inferencial> Inferencias, String[] Centralidad_Dispersion, String[] Graficos) {
        this.Muestra = Muestra;
        this.Inferencias = Inferencias;
        this.Centralidad_Dispersion = Centralidad_Dispersion;
        this.Graficos = Graficos;
    }
    
}