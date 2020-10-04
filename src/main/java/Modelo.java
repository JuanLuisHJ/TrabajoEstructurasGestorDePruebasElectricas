import java.util.ArrayList;

public class Modelo {
    public int ID;
    public int Muestra;
    public ArrayList<Integer> Inferencias;
    public int Posterior;
    public String TipoDeModelo;
    public int Informe;


    public Modelo(int ID,int Muestra, int Posterior, String TipoDeModelo, int Informe) {
        this.ID = ID;
        this.Muestra = Muestra;
        Inferencias = new ArrayList<>();
        this.Posterior = Posterior;
        this.TipoDeModelo = TipoDeModelo;
        this.Informe = Informe;
    }

}