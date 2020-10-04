import java.util.ArrayList;
public class Priori {
    public int ID;
    public ArrayList<Integer> Muestras;
    public int Posterior;
    public boolean Informativa;

    public String[] Parametros;

    public Priori(int ID,int Posterior, boolean Informativa, String[] Parametros) {
        this.ID = ID;
        Muestras = new ArrayList<>();
        this.Posterior = Posterior;
        this.Informativa = Informativa;
        this.Parametros = Parametros;
    }

}